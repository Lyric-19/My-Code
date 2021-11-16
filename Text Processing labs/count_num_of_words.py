"""\
------------------------------------------------------------
USE: python <PROGNAME> (options) file1...fileN
OPTIONS:
    -h : print this help message
    -s FILE : use stoplist file FILE
    -p : use Porter stemming (default: no stemming)
    -b : use BINARY weights (default: count weighting)
------------------------------------------------------------\
"""
import sys, re, getopt
import glob
from nltk.stem import PorterStemmer

opts, args = getopt.getopt(sys.argv[1:], 'hs:pbI:')
opts = dict(opts)


##############################
# HELP option

if '-h' in opts:
    progname = sys.argv[0]
    progname = progname.split('/')[-1] # strip out extended path
    help = __doc__.replace('<PROGNAME>', progname, 1)
    print(help, file=sys.stderr)
    sys.exit()

##############################
# Identify input files, when "-I" option used

if '-I' in opts:
    filenames = glob.glob(opts['-I'])
else:
    filenames = args

# Check if filenames are being found 
# (comment out after checking)
print('INPUT-FILES:', filenames, file=sys.stderr)

##############################
# STOPLIST option

stops = set()
if '-s' in opts:
    with open(opts['-s'], 'r') as stop_fs:
        for line in stop_fs :
            stops.add(line.strip())
            
##############################
# Stemming function

stemmer = PorterStemmer().stem

def stem_word(word):
    return stemmer(word)

##############################
# COUNT-WORDS function. 
# Takes 2 inputs: 1= FILE-NAME, 2= stoplist
# Returns a dictionary of word counts

def count_words(filename, stops):
    counts = { }
    with open(filename,encoding = "utf8") as inputfile:
        wordre = re.compile('[A-Za-z]+')
        for line in inputfile.readlines():        
            wordlist = wordre.findall(line.lower())
            wordlist = list(filter(lambda x:x not in stops,wordlist))
            wordlist = list(map(lambda x:stem_word(x),wordlist))
            
            for word in wordlist:
                if word in counts:
                    counts[word] += 1
                else:
                    counts[word] = 1
    
    return counts

#if '-p' in opts:
#    with open(opts['-p'],endcoding = "utf8") as inputfile:
#        for line in inputfile.readlines():
#            wordlist = re.findall(r"[A-Z][a-z]*",line)
#            wordlist = list(filter(lambda x:x not in stops,wordlist))           
#        return wordlist
##############################
# Compute counts for individual documents

docs = [ ]

for infile in filenames:
    docs.append(count_words(infile, stops))
    
    
    print(count_words(infile, stops))   

##############################
# Compute similarity score for document pair
# Inputs are dictionaries of counts for each doc
# Returns similarity score

def jaccard(doc1, doc2):
    temp = 0
    for i in doc1:
        if i in doc2:
            temp+=1

    fenmu = len(doc1)+len(doc2)-temp   #bingji
    jaccard_coeefficient = float(temp/fenmu)
    
    return jaccard_coeefficient

##############################
# Compute scores for all document pairs

results = {}
for i in range(len(docs)-1):
    for j in range(i+1, len(docs)):        
        pair_name = '%s <> %s' % (filenames[i], filenames[j])
        results[pair_name] = jaccard(docs[i], docs[j])

##############################
# Sort, and print top N results

top_N = 20

pairs = list(results) # DUMMY CODE LINE 
# Replace with code to sort results based on scores.
# Have only results for highest "top_N" scores printed.

# Printing
c = 0
for pair in pairs:
    c += 1
    print('[%d] %s = %.3f' % (c, pair, results[pair]), file=sys.stdout)

##############################


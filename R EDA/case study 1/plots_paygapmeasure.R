#import the data
source("scripts/makePayGapData.R")

head(payGapDataLong)
glimpse(payGapDataLong)
unique(payGapData$payGapMeasure)

#extracting the pay quartile data 

unique(payGapDataLong$payGapMeasure)

#extracting the 8th,10th,12nd,14th variable in unique payGapMeasure

payQuartiles <- unique(payGapDataLong$payGapMeasure)[c(8,10,12,14)]

#extract the the row is equal with the variable of payQuartiles in payGapMeasure column
payGapDataLong %>%
  filter(payGapMeasure %in% payQuartiles)

#show it in boxplot
#it's ugly in axes

payGapDataLong %>%
  filter(payGapMeasure %in% payQuartiles) %>%
  ggplot(aes(x = payGapMeasure,y = value,colour = institution))+
  geom_boxplot()+
  facet_grid(cols = vars(year))

#so change the x-y in the plot

payGapDataLong %>%
  filter(payGapMeasure %in% payQuartiles) %>%
  ggplot(aes(y = payGapMeasure,x = value,colour = institution))+
  geom_boxplot()+
  facet_grid(cols = vars(year))


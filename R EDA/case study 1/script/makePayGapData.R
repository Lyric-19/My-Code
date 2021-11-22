# Import the data  ----

paste0("data/", dir("data/"))

library(tidyverse)

pay17 <- read_csv("data/UK Gender Pay Gap Data - 2017 to 2018.csv")

pay18 <- read_csv("data/UK Gender Pay Gap Data - 2018 to 2019.csv")

pay19 <- read_csv("data/UK Gender Pay Gap Data - 2019 to 2020.csv")

pay20 <- read_csv("data/UK Gender Pay Gap Data - 2020 to 2021.csv")

universities <- read_csv("data/universities.csv")


# Merge the datasets ----

## How to handle different years? 

## Note select() command is just to make the result easier to view

pay17 %>%
  mutate(year = "2017/18") %>%
  inner_join(universities, by = "EmployerName") %>%
  select(EmployerName, institution, year, DiffMeanHourlyPercent)  

## Now do this for all four years, store each result, and combine with rbind()

pay17year <- pay17 %>%
  mutate(year = "2017/18") %>%
  inner_join(universities, by = "EmployerName")

pay18year <- pay18 %>%
  mutate(year = "2018/19") %>%
  inner_join(universities, by = "EmployerName")

pay19year <- pay19 %>%
  mutate(year = "2019/20") %>%
  inner_join(universities, by = "EmployerName")

pay20year <- pay20 %>%
  mutate(year = "2020/21") %>%
  inner_join(universities, by = "EmployerName")


payGapData <- rbind(pay17year, pay18year, pay19year, pay20year)



# Summary statistics and data checks ----

## How many observations each year?

payGapData %>%
  count(year)

## How many universities reported in all four years?

payGapData %>%
  select(EmployerName, year, DiffMedianHourlyPercent) %>%
  pivot_wider(names_from = year, 
              values_from = DiffMedianHourlyPercent) %>%
  ##omit the data of NA  
  na.omit()

## Compute mean of DiffMedianHourlyPercent for each year
payGapData %>%
  group_by(year) %>%
  summarise(meanGap = mean(DiffMedianHourlyPercent))



## ...and split by institution

payGapData %>%
  group_by(year, institution) %>%
  summarise(meanGap = mean(DiffMedianHourlyPercent), .groups = "drop") %>%
  pivot_wider(names_from = institution, values_from = meanGap)

# Making a long format dataframe ----

## Might be useful if studying pay quartiles - 
## may wish to treat quartile (1st, 2nd, 3rd, 4th) as a variable


payGapDataLong <- payGapData %>%
  pivot_longer(DiffMeanHourlyPercent:FemaleTopQuartile, 
               names_to = "payGapMeasure",
               values_to = "value") %>%
  select(EmployerName, year, payGapMeasure, value, institution)

payGapDataLong %>%
  pivot_wider(names_from = "payGapMeasure",
              values_from = "value")%>%
  select(EmployerName, MaleBonusPercent, FemaleBonusPercent)
##plot the diff of MaleBonusPercent and FemaleBonusPercent

##show the data by plot
payGapData %>%
  select(EmployerName, MaleBonusPercent, FemaleBonusPercent, year) %>%
  group_by(year) %>%
  summarise(meanMaleBonus = mean(MaleBonusPercent),meanFemaleBonus = mean(FemaleBonusPercent))%>%
  pivot_longer(meanMaleBonus:meanFemaleBonus,
               names_to = "mean",
               values_to = "value")%>%
  ggplot(aes(x = year,y = value)) + 
  geom_point(aes(colour = mean),size = 3) +
  labs(x = "Mean Bonus between male and female in a year",
       y = "meanBonusPercent")+
  geom_smooth()


##show the data by bar
payGapData %>%
  select(EmployerName, MaleBonusPercent, FemaleBonusPercent, year, institution) %>%
  group_by(year) %>%
  summarise(meanMaleBonus = mean(MaleBonusPercent),meanFemaleBonus = mean(FemaleBonusPercent))%>%
  pivot_longer(meanMaleBonus:meanFemaleBonus,
               names_to = "mean",
               values_to = "value")%>%
  ggplot(aes(x=year,y=value)) + 
  geom_bar(stat = 'identity',aes( fill = mean),position = position_dodge(0.5),width = 0.5) +
  labs(x = "Mean Bonus between male and female in a year",
       y = "meanBonusPercent")


##show the data by boxplot
payGapData %>%
  select(EmployerName, MaleBonusPercent, FemaleBonusPercent, year, institution) %>%
  pivot_longer(MaleBonusPercent:FemaleBonusPercent,
               names_to = "mean",
               values_to = "value")%>%
  ggplot(aes(x=year,y=value)) + 
  geom_boxplot(aes(color=mean)) +
  labs(x = "Mean Bonus between male and female in a year",
       y = "meanBonusPercent")+
  coord_flip()


##show the data by table

pay20year %>%
  group_by(institution) %>%
  summarise(meanGap = mean(DiffMedianHourlyPercent))

pay20year %>%
  group_by(institution) %>%
  summarise(meanGap = mean(DiffMeanHourlyPercent))

pay20year %>%
  group_by(institution) %>%
  summarise(meanGap = mean(FemaleBonusPercent))

pay20year %>%
  group_by(institution) %>%
  summarise(meanGap = mean(DiffMeanBonusPercent,na.rm = TRUE))

pay20year %>%
  group_by(institution) %>%
  summarise(meanGap = mean(DiffMedianBonusPercent,na.rm = TRUE))

pay20year %>%
  group_by(institution) %>%
  summarise(meanGap = mean(MaleBonusPercent))

m1<- mean(pay20year$DiffMeanHourlyPercent,na.rm = TRUE)
m1
m2<- mean(pay20year$DiffMedianHourlyPercent,na.rm = TRUE)
m2
m3<- mean(pay20year$MaleBonusPercent,na.rm = TRUE)
m3
m4<- mean(pay20year$FemaleBonusPercent,na.rm = TRUE)
m4
m5<- mean(pay20year$DiffMeanBonusPercent,na.rm = TRUE)
m5
m6<- mean(pay20year$DiffMedianBonusPercent,na.rm = TRUE)
m6

m1<- max(pay20year$DiffMeanHourlyPercent,na.rm = TRUE)
m1
m2<- max(pay20year$DiffMedianHourlyPercent,na.rm = TRUE)
m2
m3<- max(pay20year$MaleBonusPercent,na.rm = TRUE)
m3
m4<- max(pay20year$FemaleBonusPercent,na.rm = TRUE)
m4
m5<- max(pay20year$DiffMeanBonusPercent,na.rm = TRUE)
m5
m6<- max(pay20year$DiffMedianBonusPercent,na.rm = TRUE)
m6

m1<- min(pay20year$DiffMeanHourlyPercent,na.rm = TRUE)
m1
m2<- min(pay20year$DiffMedianHourlyPercent,na.rm = TRUE)
m2
m3<- min(pay20year$MaleBonusPercent,na.rm = TRUE)
m3
m4<- min(pay20year$FemaleBonusPercent,na.rm = TRUE)
m4
m5<- min(pay20year$DiffMeanBonusPercent,na.rm = TRUE)
m5
m6<- min(pay20year$DiffMedianBonusPercent,na.rm = TRUE)
m6
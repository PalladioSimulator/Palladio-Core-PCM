makeHist <- function(data,noOfSensors){
  histData <- hist(data$Time.Span,breaks=100)
  histData$counts <- histData$counts / 10000
#  histData$breaks <- histData$breaks / 1000000
  #plot(histData,xlab="Execution time in seconds",ylab="Probability",main=paste("Execution time with",noOfSensors,"sensors"))
  plot(histData,xlab="Execution time in seconds",ylab="Probability",main="")
}

# Do not forget to delete the tear down candidates from the data
sensors3 <- read.csv("Hist_3x3Sensoren.csv",sep=";")
sensors6 <- read.csv("Hist_3x6Sensoren.csv",sep=";")
sensors9 <- read.csv("Hist_3x9Sensoren.csv",sep=";")
sensors3$noSensors <- 3
sensors6$noSensors <- 6
sensors9$noSensors <- 9

#scale data to seconds
sensors3$Time.Span <- sensors3$Time.Span /  1000000
sensors6$Time.Span <- sensors6$Time.Span /  1000000
sensors9$Time.Span <- sensors9$Time.Span /  1000000

sensors <- rbind(sensors3,sensors6,sensors9)
#sensors$Event.Time sensors$Time.Span  sensors$noSensors 

makeHist(sensors6,6)
makeHist(sensors3,3)
makeHist(sensors9,9)

boxplot(sensors$Time.Span ~ sensors$noSensors,xlab="Number of Sensors",ylab="Execution time in seconds")

# compare all sensors in density graph
attach(sensors)
#noSensors.f <- factor(noSensors, levels = c(3,6,9), labels = ("3 sensors","6 sensors","9 sensors"))
noSensors.f <- factor(noSensors, levels = c(3,6,9))
sm.density.compare(Time.Span,noSensors)

thruster1 <- read.csv("Hist_3x3Sensoren.csv",sep=";")
thruster6 <- read.csv("Hist_Thruster_6x.csv",sep=";")
thruster7 <- read.csv("Hist_Thruster_7x.csv",sep=";")
thruster8 <- read.csv("Hist_Thruster_8x.csv",sep=";")
thruster10 <- read.csv("Hist_Thruster_10x.csv",sep=";")

thruster1$factor <- 1
thruster6$factor <- 6
thruster7$factor <- 7
thruster8$factor <- 8
thruster10$factor <- 10

thruster1$Time.Span <- thruster1$Time.Span /  1000000
thruster6$Time.Span <- thruster6$Time.Span /  1000000
thruster7$Time.Span <- thruster7$Time.Span /  1000000
thruster8$Time.Span <- thruster8$Time.Span /  1000000
thruster10$Time.Span <- thruster10$Time.Span /  1000000

thrusters <- rbind(thruster1,thruster6,thruster7,thruster8,thruster10)

boxplot(thrusters$Time.Span ~ thrusters$factor,xlab="Increase Factor Thruster Allocation",ylab="Execution time in seconds")

middlethrusters <- rbind(thruster6,thruster7,thruster8)

boxplot(middlethrusters$Time.Span ~ middlethrusters$factor,xlab="Increase Factor Thruster Allocation",ylab="Execution time in seconds")




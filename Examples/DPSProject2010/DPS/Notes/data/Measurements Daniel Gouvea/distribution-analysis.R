printAsPDF <- function(hist,rawdata) {
  print("DoublePDF[",quote=FALSE)
  for (i in 2:NROW(hist$breaks)){
    print(paste("(",hist$breaks[i],";",hist$counts[i-1]/nrow(rawdata),")"),quote=FALSE)
  }
  print("]",quote=FALSE)
}

# See also internal R html help, section 8.2 Examining the distribution of a set of data

print("********* Dynamic Pos **********")
print("********* 4 thruster **********")
dynamicPositioning4 <- read.table("dynamicPos_4Thruster_1000000")
histDynamicPos4 <- hist(dynamicPositioning4[,1],breaks=50,xlab="Execution time in nanoseconds",ylab="Frequency",main="")

printAsPDF(histDynamicPos4,dynamicPositioning4)

# print the buckets of the histogram
# print(histDynamicPos)
# interesting other visualisation
#stem(dynamicPositioning[,1])
#doublePDFDynPos4 <- data.frame(value=histDynamicPos4$breaks[2:NROW(histDynamicPos4$breaks)], prob=histDynamicPos4$counts/nrow(dynamicPositioning4))
#print(doublePDFDynPos4)
# scale up to get the mean that Daniel has reported
# scaleFactorDynPos4 <- 115265 / mean(dynamicPositioning4)
# 1.498511

print("********* 6 thruster **********")
dynamicPositioning6 <- read.table("dynamicPos_6Thruster_1000000")
histDynamicPos6 <- hist(dynamicPositioning6[,1],breaks=50,xlab="Execution time in nanoseconds",ylab="Frequency",main="")

printAsPDF(histDynamicPos6,dynamicPositioning6)
# print the buckets of the histogram
# print(histDynamicPos)
# interesting other visualisation
#stem(dynamicPositioning[,1])
#doublePDFDynPos6 <- data.frame(value=histDynamicPos6$breaks[2:NROW(histDynamicPos6$breaks)], prob=histDynamicPos6$counts/nrow(dynamicPositioning6))
#print(doublePDFDynPos6)
# scale up to get the mean that Daniel has reported
#scaleFactorDynPos6 <- 115265 / mean(dynamicPositioning6)
# 1.498511

print("********* 8 thruster **********")
dynamicPositioning8 <- read.table("dynamicPos_8Thruster_1000000")
histDynamicPos8 <- hist(dynamicPositioning8[,1],breaks=50,xlab="Execution time in nanoseconds",ylab="Frequency",main="")

printAsPDF(histDynamicPos8,dynamicPositioning8)

# print the buckets of the histogram
# print(histDynamicPos)
# interesting other visualisation
#stem(dynamicPositioning[,1])
#doublePDFDynPos8 <- data.frame(value=histDynamicPos8$breaks[2:NROW(histDynamicPos8$breaks)], prob=histDynamicPos8$counts/nrow(dynamicPositioning8))
#print(doublePDFDynPos8)
# scale up to get the mean that Daniel has reported
#scaleFactorDynPos8 <- 115265 / mean(dynamicPositioning8)
# 1.498511



print("********* Data Layer **********")
dataLayer <- read.table("DataLayer.txt")
histDataLayer <- hist(dataLayer[,1],breaks=50,xlab="Execution time in nanoseconds",ylab="Frequency",main="")
# print the buckets of the histogram
# print(histDataLayer)
#doublePDFDataLayer <- data.frame(value=histDataLayer$breaks[2:42], prob=histDataLayer$counts/nrow(dataLayer))
#print(doublePDFDataLayer)

printAsPDF(histDataLayer,dataLayer)

scaleDL <- 23.3812 / mean(dataLayer)

print("********* Data Retrieval **********")
dataRetrieval <- read.table("DataRetrieval.txt")
histDataRetrieval <- hist(dataRetrieval[,1],breaks=50,xlab="Execution time in nanoseconds",ylab="Frequency",main="")
# print the buckets of the histogram
# print(histDataRetrieval)
#doublePDFDataRetrieval <- data.frame(value=histDataRetrieval$breaks[2:50], prob=histDataRetrieval$counts/nrow(dataRetrieval))
#print(doublePDFDataRetrieval)

printAsPDF(histDataRetrieval,dataRetrieval)


scaleGyro <- 42.3291 / mean(dataRetrieval)
#scaleGPS <- 248.751 / mean(dataRetrieval)
scaleYoung <- 43.4705 / mean(dataRetrieval)

#print("scale dyn pos:")
#print(scaleFactorDynPos)

print("scale data layer:")
print(scaleDL)

print("scale Gyro:")
print(scaleGyro)

#print("scale GPS:")
#print(scaleGPS)

print("scale Young:")
print(scaleYoung)






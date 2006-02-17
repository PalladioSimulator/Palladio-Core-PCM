type Performance = contract {
responseTime: increasing numeric msec;
}
setPerformance = Performance contract{
responseTime{
percentile 30 < 20;
percentile 70 < 40;
percentile 100 < 80;
mean < 35;
};
}
testServiceProfile for ITestService = profile {
from setter require setPerformance;
from get require Performance contract {
responseTime {
percentile 30 < 10;
percentile 70 < 20;
percentile 100 < 40;
mean < 17;
};
};
}


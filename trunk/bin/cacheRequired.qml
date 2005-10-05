type Performance = contract {
delay: increasing numeric msec;
throughput: increasing numeric mb/sec;
}
setPerformance = Performance contract{
delay{
percentile 50 < 5;
percentile 80 < 10;
percentile 100 < 20;
mean < 7.5;
};
throughput > 4;
}
cacheProfile for ICache = profile {
from setter require setPerformance;
from get require Performance contract {
delay {
percentile 50 < 2.5;
percentile 80 < 5;
percentile 100 < 10;
mean < 3.75;
};
throughput > 4;
};
}


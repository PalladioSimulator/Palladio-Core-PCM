type Performance = contract {
delay: increasing numeric msec;
throughput: increasing numeric mb/sec;
}
acquirePerformance = Performance contract{
delay{
percentile 50 < 10;
percentile 80 < 20;
percentile 100 < 40;
mean < 15;
};
throughput > 2;
};
cache Profile for ICache = profile {
from acquire require acquirePerformance;
from release require Performance contract {
delay {
percentile 50 < 5;
percentile 80 < 10;
percentile 100 < 20;
mean < 7.5;
};
throughput > 2;
};


type Performance = contract {
delay: increasing numeric msec;
throughput: increasing numeric mb/sec;
}
type Reliability = contract {
numberOfFailures: decreasing numeric no/year;
}
setPerformance = Performance contract{
delay{
percentile 50 < 10;
percentile 80 < 20;
percentile 100 < 40;
mean < 15;
variance >= 0.6;
frequency a1 <= 10%;
};
throughput > 2;
}
cacheProfile for ICache = profile {
from get require Performance contract {
delay {
percentile 50 < 5;
percentile 80 < 10;
percentile 100 < 20;
mean < 7.5;
};
throughput > 2;
},
Reliability contract {
numberOfFailures == 3;
};
}


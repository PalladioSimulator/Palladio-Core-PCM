type Performance = contract {
delay: increasing numeric msec;
throughput: increasing numeric mb/sec;
}
type Reliability = contract {
numberOfFailures: decreasing numeric no/year;
}
type Security = contract {
authenticationFailures: increasing numeric percent;
}
type Performance2 = contract {
delay: increasing numeric msec;
throughput: increasing numeric mb/sec;
}
test = Performance2 contract{
delay < 6;
throughput > 8;
}
setSecurity = Security contract {
authenticationFailures > 99;
}
setReliability = Reliability contract{
numberOfFailures < 2;
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
require setSecurity;
from setter require setReliability;
from get require Performance contract {
delay {
percentile 50 < 2.5;
percentile 80 < 7;
percentile 100 < 10;
mean < 3.75;
};
throughput > 4;
};
}


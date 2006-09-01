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
setSecurity = Security contract {
authenticationFailures > 98;
}
setReliability = Reliability contract{
numberOfFailures < 3;
}
setPerformance = Performance contract{
delay{
percentile 50 < 5;
percentile 80 < 12;
percentile 100 < 20;
mean < 14;
};
throughput > 3;
}
cacheProfile for ICache = profile {
require setSecurity;
from setter require setReliability;
from get require Performance contract {
delay {
percentile 50 < 2.5;
percentile 80 < 8;
percentile 100 < 11;
mean < 3.75;
};
throughput > 4;
};
}


type Reliability = contract {
	numberOfFailures: decreasing numeric no/year;
	TTR: decreasing numeric sec;
	availability: increasing numeric;
}

type Performance = contract {
	delay: decreasing numeric msec;
	throughput: increasing numeric mb/sec;
}

systemReliability = Reliability contract {
	numberOfFailures < 10 no/year;
	TTR {
		percentile 100 < 2000;
		mean < 500;
		variance < 0.3;
	};
	availability > 0.8;
}

rateServerProfile for RateServiceI = profile {
	require systemReliability;
	from latest require Performance contract {
		delay {
			percentile 50 < 10;
			percentile 80 < 20;
			percentile 100 < 40;
			mean < 15;
		};
	};
	from analysis require Performance contract {
		delay < 4000;
	};
}
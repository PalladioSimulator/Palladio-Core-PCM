package de.uka.ipd.sdq.simulation.abstractsimengine.example;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.BusStop;

public class Route {

	private Map<BusStop, RouteSegment> segmentMap;

	public Route() {
		this.segmentMap = new HashMap<>();
	}

	public void addSegment(BusStop from, BusStop to, int distance, int averageSpeed) {
		if (this.segmentMap.containsKey(from)) {
			throw new IllegalStateException("There is already a segement originating from bus stop " + from);
		}

		RouteSegment s = new RouteSegment(from, to, distance, averageSpeed);
		this.segmentMap.put(from, s);
	}
	
//	public BusStop nextStop(BusStop from) {
//		return getRouteSegment(from).getTo();
//	}
//	
//	public int distanceToNextStop(BusStop from) {
//		return getRouteSegment(from).getDistance();
//	}
//	
//	public int averageSpeedToNextStop(BusStop from) {
//		return getRouteSegment(from).getAverageSpeed();
//	}
	
	public RouteSegment getRouteSegment(BusStop from) {
		if(!this.segmentMap.containsKey(from)) {
			throw new IllegalStateException("There is no segment originating from bus stop " + from);
		}
		
		return this.segmentMap.get(from);
	}

	public class RouteSegment {

		private BusStop from, to;

		// distance in kilometers
		private int distance;

		// average speed in kilometers per hour
		private int averageSpeed;

		public RouteSegment(BusStop from, BusStop to, int distance, int averageSpeed) {
			this.from = from;
			this.to = to;
			this.distance = distance;
			this.averageSpeed = averageSpeed;
		}

		public BusStop getFrom() {
			return from;
		}

		public BusStop getTo() {
			return to;
		}

		public int getDistance() {
			return distance;
		}

		public int getAverageSpeed() {
			return averageSpeed;
		}

	}

}

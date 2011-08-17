package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.*;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;

public class SimGinpexDiskResource extends AbstractActiveResource {
	
	private class TimeSliceFinishedEvent extends Event {
		
		public TimeSliceFinishedEvent() {
			super(SchedulingFactory.getUsedSimulator());
			simulationTimeUnit = TimeUnit.SECONDS;
		}

		@Override
		public void actions() {
			LoggingWrapper.log(name + "Time slice of user " + currentUser.userNumber + " finished at " + simulator.time() + ".");
			
			// account working time and schedule request switch
			double timeWorked = MathTools.round(simulator.time() - workingTimeStart, 1/dataTransferRate[currentRequest.type.ordinal()]);
			if (timeWorked > 0) {
				currentRequest.remainingDemand -= durationWithBlockSize(timeWorked, currentRequest) * dataTransferRate[currentRequest.type.ordinal()];
				currentRequest.remainingDemand = currentRequest.remainingDemand > 0 ? currentRequest.remainingDemand : 0;
				currentRequest.currentRequestSwitchOverhead = 0;
				requestSwitchEvent.schedule(durationWithBlockSize(timeWorked, currentRequest) - timeWorked);
			} else {
				currentRequest.currentRequestSwitchOverhead -= MathTools.round(simulator.time() - requestStartTime, 1/dataTransferRate[currentRequest.type.ordinal()]);
				requestSwitchEvent.schedule(0);
			}
		}
		
	}
	
	private class RequestFinishedEvent extends Event {
		
		public RequestFinishedEvent() {
			super(SchedulingFactory.getUsedSimulator());
		}
		
		@Override
		public void actions() {
			LoggingWrapper.log(name + "Request of user " + currentUser.userNumber + " finished at " + simulator.time() + ".");
			
			// PCM internal stuff
			ISchedulableProcess r = currentRequest.request;
			fireStateChange(userQueue.size(), 0);
			r.activate();
			
			// remove request
			currentUser.remove(currentRequest);

			// schedule request switch
			double timeWorked = MathTools.round(simulator.time() - workingTimeStart, 1/dataTransferRate[currentRequest.type.ordinal()]);
			
			if (currentUser.requestQueue.size() > 0 || userQueue.size() > 1) {
				if (!anticipatoryScheduling[currentRequest.type.ordinal()]) {
					forceNext = true;
					requestSwitchEvent.schedule(durationWithBlockSize(timeWorked, currentRequest) - timeWorked);
				} else
					requestSwitchEvent.schedule(durationWithBlockSize(timeWorked, currentRequest) - timeWorked + Double.MIN_VALUE);
			}
		}
		
	}
	
	private class RequestSwitchEvent extends Event {
		
		public RequestSwitchEvent() {
			super(SchedulingFactory.getUsedSimulator());
		}
		
		@Override
		public void actions() {
			LoggingWrapper.log(name + "RequestSwitchEvent at "+simulator.time());
			
			boolean resetTimeSlice = false;
			remainingUserTimeSlice -= simulator.time() - requestStartTime;
			
			// get next user if necessary
			if (currentUser.requestQueue.size() == 0) {
				LoggingWrapper.log(name + "Deleting user " + currentUser.userNumber + " because it has no pending requests left.");
				userQueue.remove(currentUserIndex);
				if (userQueue.size() > 0)
					resetTimeSlice = true;
				else
					return;
			}
			
			if (!resetTimeSlice && (MathTools.lessOrEqual(remainingUserTimeSlice,0) || forceNext == true)) {
				forceNext = false;
				currentUserIndex++;
				currentUserIndex %= userQueue.size();
				resetTimeSlice = true;
			}
			currentUser = userQueue.get(currentUserIndex);
			LoggingWrapper.log(name + "Current user is " + currentUser.userNumber + ".");	
			
			// get next request
			Request nextRequest = currentUser.getRequest();
			
			// reset remaining time slice
			if (resetTimeSlice)
				remainingUserTimeSlice = timeSliceLength[nextRequest.type.ordinal()];			
			
			// regard the request switch overhead
			if (currentRequest != nextRequest) {
				currentRequest = nextRequest;
				currentRequest.currentRequestSwitchOverhead = requestSwitchOverhead[nextRequest.type.ordinal()];
			}
			
			requestStartTime = simulator.time();
			workingTimeStart = simulator.time() + currentRequest.currentRequestSwitchOverhead;
			
			// schedule the next event
			double neededTimeSlice = nextRequest.remainingDemand/dataTransferRate[nextRequest.type.ordinal()]+currentRequest.currentRequestSwitchOverhead;
			remainingUserTimeSlice = durationWithBlockSize(remainingUserTimeSlice, nextRequest);
			
			if (MathTools.lessOrEqual(neededTimeSlice, remainingUserTimeSlice))
				requestFinishedEvent.schedule(neededTimeSlice);
			else
				timeSliceFinishedEvent.schedule(remainingUserTimeSlice);
			
			LoggingWrapper.log(name + "Scheduled request of user " + currentUser.userNumber + " with a remaining demand of " + currentRequest.remainingDemand + ".");
		}
	}
	
	private class User {
		private int userNumber;
		private ArrayList<Request> requestQueue = new ArrayList<Request>();
		
		User(int userNumber) {
			this.userNumber = userNumber;
		}
		
		public void add(Request r) {
			requestQueue.add(r);
		}
		
		public void remove(Request r) {
			requestQueue.remove(r);
		}
		
		public Request getRequest() {
			return requestQueue.get(0);
		}
	}
	
	private class Request {
		public ISchedulableProcess request;
		public double remainingDemand;
		public double currentRequestSwitchOverhead;
		public RequestType type;
		
		public Request(ISchedulableProcess p, double r, RequestType t) {
			this.request = p;
			this.remainingDemand = r;
			this.type = t;
			this.currentRequestSwitchOverhead = requestSwitchOverhead[t.ordinal()];
		}
	}
	
	private String name = "GINPEX_DETECTED scheduler: "; 
	private enum TimeUnit {SECONDS, MILLISECONDS};
	private TimeUnit simulationTimeUnit;
	private Simulator simulator;
	
	private ArrayList<User> userQueue = new ArrayList<User>();
	private RequestSwitchEvent requestSwitchEvent = new RequestSwitchEvent();
	private RequestFinishedEvent requestFinishedEvent = new RequestFinishedEvent();
	private TimeSliceFinishedEvent timeSliceFinishedEvent = new TimeSliceFinishedEvent();
	private enum RequestType {READ, WRITE};
	
	private int currentUserIndex = 0;
	private Request currentRequest = null;
	private User currentUser = null;
	private double remainingUserTimeSlice;
	private double workingTimeStart = 0.0;
	private double requestStartTime = 0.0;
	private boolean forceNext = false;
	
	// scheduler parameters to be loaded from the feature.config
	private double dataTransferRate[] = new double[2];
	private double requestSwitchOverhead[] = new double[2];
	private double timeSliceLength[] = new double[2];
	private boolean anticipatoryScheduling[] = new boolean[2];
	private int blocksize;
	
	public SimGinpexDiskResource(String name, String id, HDDParameterConfig hddParameterConfig) {
		super(1, name, id);
		this.simulator = SchedulingFactory.getUsedSimulator();
		loadParameters(hddParameterConfig);
	}


	// add new disk request
	@Override
	protected void doProcessing(ISchedulableProcess request, int resourceServiceID, double demand) {
		LoggingWrapper.log(name + request + " demands " + demand + ".");
		synchronized (this) {			
			// add request to proper user queue (add one if necessary)
			int userNumber = Integer.valueOf(request.getId().substring(request.getId().indexOf("_") + 1));
			
			if (getUserQueue(userNumber) == null) {
				userQueue.add(new User(userNumber));
			}
			
			RequestType type;
			switch (resourceServiceID) {
			case 1: type=RequestType.READ; break;
			case 2: type=RequestType.WRITE; break;
			default: type=null;
			}
			
			getUserQueue(userNumber).add(new Request(request, demand, type));
			fireStateChange(userQueue.size(), 0);
			LoggingWrapper.log(name + "Added request to user "+userNumber+" at " + simulator.time() + ".");
			
			if (userQueue.size() == 1) {
				// first user in the queue, so we kick off the scheduler
				remainingUserTimeSlice = timeSliceLength[resourceServiceID - 1];
				currentUser = userQueue.get(0);
				requestSwitchEvent.schedule(0);
			}
		}
		request.passivate();
	}

	@Override
	public int getQueueLengthFor(SimResourceInstance simResourceInstance) {
		return this.userQueue.size();
	}
	
	private User getUserQueue(int userNumber) {
		for (int i=0; i<userQueue.size(); i++) {
			if (userQueue.get(i).userNumber == userNumber)
				return userQueue.get(i);
		}
		return null;
	}
	
	private double durationWithBlockSize(double durationWithout, Request r) {
		return Math.ceil(durationWithout * dataTransferRate[r.type.ordinal()] / blocksize) * blocksize / dataTransferRate[r.type.ordinal()];
	}
	
	private void loadParameters(HDDParameterConfig hddParameterConfig) {
		dataTransferRate[0] = hddParameterConfig.getReadDataTransferRate();
		dataTransferRate[1] = hddParameterConfig.getWriteDataTransferRate();
		requestSwitchOverhead[0] = hddParameterConfig.getReadRequestSwitchOverhead();
		requestSwitchOverhead[1] = hddParameterConfig.getWriteRequestSwitchOverhead();
		timeSliceLength[0] = hddParameterConfig.getReadTimeSliceLength();
		timeSliceLength[1] = hddParameterConfig.getWriteTimeSliceLength();
		anticipatoryScheduling[0] = hddParameterConfig.getAnticipatorySchedulingRead();
		anticipatoryScheduling[1] = hddParameterConfig.getAnticipatorySchedulingWrite();
		blocksize = hddParameterConfig.getBlocksize();
		
		if ((requestSwitchOverhead[0] > timeSliceLength[0]) || (requestSwitchOverhead[1] > timeSliceLength[1])) {
			LoggingWrapper.log("GinpexDisk: Request Switch Overhead is bigger than the Request Time Slice Length. This is most certainly wrong!");
		}
		
		if (simulationTimeUnit == TimeUnit.MILLISECONDS) {
			dataTransferRate[0] /= 1000;
			dataTransferRate[1] /= 1000;
			requestSwitchOverhead[0] *= 1000;
			requestSwitchOverhead[1] *= 1000;
			timeSliceLength[0] *= 1000;
			timeSliceLength[1] *= 1000;
		}
	}

	@Override
	public void registerProcess(IRunningProcess runningProcess) {
		
	}

	@Override
	public void start() {
		
	}

	@Override
	public void stop() {
		
	}

	@Override
	protected void enqueue(ISchedulableProcess process) {
		
	}
	
	@Override
	protected void dequeue(ISchedulableProcess process) {
		
	}
	
}

using System;
using ComponentNetworkSimulation.structure;

//TODO: logging
namespace ComponentNetworkSimulation.simulation
{
	/// <summary>
	/// The declaration of the eventhandler for all thread events.
	/// </summary>	
	public delegate void NextTCEventHandler(object sender,NextTCEventArgs eventArgs);

	/// <summary>
	/// This class implements the simulation thread which is representing one request to the component network.
	/// </summary>
	public class SimulationThread
	{	
		#region declarations
		
		/// <summary>
		/// the declaration of the threadtype specifying the logging behavior of this thread.
		/// </summary>
		public enum SimuationThreadType {TYPE_LOG_ALL,TYPE_LOG_ON_LPS,TYPE_LOG_NOTHING};

		#endregion declarations

		#region events

		/// <summary>
		/// This event is fired, if the timeconsumer has changed to next one
		/// </summary>
		public event NextTCEventHandler NextTCEvent;

		#endregion events

		#region data
		
		/// <summary>
		/// the id of the thread
		/// </summary>
		protected int threadId;

		/// <summary>
		/// this time contains the difference between the simulation time and the threads current state time.
		/// If this field is zero, the next timeconsumer is entered.
		/// </summary>
		protected long timeInFuture=0;

		/// <summary>
		/// holds the current timeconsumer.
		/// </summary>
		protected ComponentNetworkSimulation.structure.TimeConsumer currentTimeConsumer=null;

		/// <summary>
		/// holds the type of the thread
		/// </summary>
		protected SimuationThreadType type = SimuationThreadType.TYPE_LOG_ON_LPS;

		/// <summary>
		/// this field hold an implemented observer if set
		/// </summary>
		protected IThreadObserver observer;

		#endregion data

		#region constructor

		/// <summary>
		/// constructs a new simulationthread.
		/// </summary>
		/// <param name="id">The id of the thread.</param>
		/// <param name="firstTimeConsumer">The first timeconsumer.</param>
		/// <param name="type">The type of the thread.</param>
		public SimulationThread(int id, TimeConsumer firstTimeConsumer, SimuationThreadType type)
		{
			this.threadId = id;
			this.currentTimeConsumer = firstTimeConsumer;
			this.timeInFuture = currentTimeConsumer.getUsedTime();
			this.type = type;
		}

		/// <summary>
		/// constructs a new simulationthread.
		/// </summary>
		/// <param name="id">The id of the thread.</param>
		/// <param name="firstTimeConsumer">The first timeconsumer.</param>
		/// <param name="type">The type of the thread.</param>
		public SimulationThread(int id, TimeConsumer firstTimeConsumer, SimuationThreadType type,
			IThreadObserver observer)
		{
			this.threadId = id;
			this.currentTimeConsumer = firstTimeConsumer;
			this.timeInFuture = currentTimeConsumer.getUsedTime();
			this.type = type;
			this.observer = observer;
		}

		#endregion constructor

		#region properties
		/// <summary>
		/// the current timeconsumer
		/// </summary>
		public TimeConsumer CurrentTimeConsumer 
		{
			get{ return currentTimeConsumer;}
		}

		/// <summary>
		/// this time contains the difference between the simulation time and the threads current state time.
		/// </summary>
		public long TimeInFuture 
		{
			get{ return timeInFuture;}
		}

		/// <summary>
		/// is true, if the thread already has following timeconsumers 
		/// </summary>
		public bool IsAlive 
		{
			get {return currentTimeConsumer != null;}
		}

		/// <summary>
		/// the id of the thread
		/// </summary>
		public int ThreadID
		{
			get {return threadId;}
		}

		#endregion properties

		#region methods

		/// <summary>
		/// called to move the timeline.
		/// </summary>
		/// <param name="time">The timestep to be moved.</param>
		public void TimeMoved(long time) 
		{
			timeInFuture -= time;
			NotifyTimeStepEvent(time);
			if (timeInFuture <= 0) NextTimeConsumer();
		}

		/// <summary>
		/// called if timeToFuture is zero to change to the next timeconsumer.
		/// if the end of the control flow is reached, a thread event is fired and the thread is marked as dead.
		/// </summary>
		protected void NextTimeConsumer()
		{
			if (!IsAlive) return;

			if (!currentTimeConsumer.hasNextTimeConsumer()) 
			{
				NotifyThreadReachedEndEvent();
				currentTimeConsumer = null;
				return;
			}

			TimeConsumer previous = currentTimeConsumer;

			currentTimeConsumer = currentTimeConsumer.getNextTimeConsumer();
			timeInFuture = currentTimeConsumer.getUsedTime();

			NotifyNextTCEvent(previous);
		}

		/// <summary>
		/// called to fire an event, when the thread changed the timeconsumer
		/// </summary>
		/// <param name="previous">the previous timeconsumer</param>
		protected virtual void NotifyNextTCEvent(TimeConsumer previous)
		{
			if (NextTCEvent != null)
				NextTCEvent(this,new NextTCEventArgs(this.currentTimeConsumer,previous));

			if (observer != null)
				observer.NotifyThreadChangedTimeConsumer(this,previous);
		}

		/// <summary>
		/// called to notify the observer that the thread reached the end of its control flow
		/// </summary>
		protected virtual void NotifyThreadReachedEndEvent()
		{
			if (observer != null)
				observer.NotifyThreadReachedEnd(this);
		}

		/// <summary>
		/// called to notify the observer that the thread moves one timestep
		/// </summary>
		/// <param name="timeStep"></param>
		protected virtual void NotifyTimeStepEvent(long timeStep)
		{
			if (observer != null)
				observer.NotifyTimeStep(this,timeStep);
		}

		#endregion methods
	}
}
//EOF
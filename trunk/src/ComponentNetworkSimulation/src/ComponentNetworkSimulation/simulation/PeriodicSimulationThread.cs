using System;
using ComponentNetworkSimulation;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.simulation
{
	/// <summary>
	/// This class extends SimulationThread in order to provide periodic threads. A periodic thread notifies the scheduler,
	/// when the periodlength is reached. The notified scheduler has to create a new periodic thread. All threads, created
	/// from one periodic thread, contains the same periodID, to identify them.
	/// </summary>
	public class PeriodicSimulationThread : SimulationThread
	{
		#region events
		
		/// <summary>
		/// this event is fired, when the timeline of the thread reached the periodlength.
		/// </summary>
		public event EventHandler NewPeriodicThreadEvent;

		#endregion
		
		#region data
		
		/// <summary>
		/// Holds the first timeconsumer of the thread in order to create new threads starting at the same one.
		/// </summary>
		protected TimeConsumer firstTimeConsumer;

		/// <summary>
		/// this field holds the length of the period in order to create new threads with the same period.
		/// </summary>
		protected long periodLength;

		/// <summary>
		/// this fields identifies all threads, which have been created from one periodic thread.
		/// </summary>
		protected int periodID;

		/// <summary>
		/// this field contains the current periodic time, the thread has still to wait, until a 
		/// new thread has to be created.
		/// </summary>
		private long currentPeriodTime;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new periodic thread.
		/// </summary>
		/// <param name="periodLength">the length of the period, until a new thread has to be created.</param>
		/// <param name="periodID">the id of the period threads</param>
		/// <param name="id">the id of this thread</param>
		/// <param name="firstTimeConsumer">the first time consumer</param>
		/// <param name="type">the type of the thread</param>
		public PeriodicSimulationThread(long periodLength, int periodID, int id, TimeConsumer firstTimeConsumer,
			SimuationThreadType type) : this(periodLength,periodID,id,firstTimeConsumer,type,null)
		{
			
		}

		/// <summary>
		/// constructs a new periodic thread observered by given observer.
		/// </summary>
		/// <param name="periodLength">the length of the period, until a new thread has to be created.</param>
		/// <param name="periodID">the id of the period threads</param>
		/// <param name="id">the id of this thread</param>
		/// <param name="firstTimeConsumer">the first time consumer</param>
		/// <param name="type">the type of the thread</param>
		/// <param name="observer">the observer</param>
		public PeriodicSimulationThread(long periodLength, int periodID, int id, TimeConsumer firstTimeConsumer,
			SimuationThreadType type, IThreadObserver observer) : base (id, firstTimeConsumer,type,observer)
		{
			this.firstTimeConsumer = firstTimeConsumer;
			this.periodLength = periodLength;
			this.periodID = periodID;
			this.currentPeriodTime = periodLength;
		}

		#endregion

		#region properties

		/// <summary>
		/// return the length of the periodlength of this thread
		/// </summary>
		public virtual long PeriodLength 
		{
			get{ return this.periodLength;}
		}

		/// <summary>
		/// return the periodID of this thread.
		/// </summary>
		public int PeriodID 
		{
			get{ return this.periodID;}
		}

		/// <summary>
		/// is true, if the thread is alive. This method is overriden in order to also mark a thread alive, when the
		/// periodLength not has been reached.
		/// </summary>
		public override bool IsAlive
		{
			get
			{
				return base.IsAlive || this.currentPeriodTime > 0;
			}
		}

		
		/// <summary>
		/// return the TimeInFuture. This property is overriden from base class in order to insert a new timestep,
		/// when this thread has to notify the scheduler to create a new thread because the time reached the periodlength.
		/// </summary>
		public override long TimeInFuture
		{
			get
			{
				if (this.currentPeriodTime > 0 && (this.currentPeriodTime < this.timeInFuture || !HasAnyTimeConsumer()))
					return this.currentPeriodTime;
				else
					return this.timeInFuture;
			}
		}

		#endregion

		#region methods

		/// <summary>
		/// move the timeline of this thread. This method is overridden in order to move the currentPeriodTime. If this time
		/// reached zero, an event is fired to create a new thread. CurrentPeriodTime is left to zero in order only to fire
		/// a event one time in whole lifetime of the thread.
		/// </summary>
		/// <param name="time">the timstep to be moved</param>
		public override void TimeMoved(long time)
		{
			if (currentPeriodTime > 0)
			{
				currentPeriodTime -= time;
				if (currentPeriodTime <= 0) NotifyNewPeriodicThreadEvent();
			}

			base.TimeMoved (time);	
		}

		/// <summary>
		/// This method creates a new thread with same periodID, firstTimeConsumer, observer and periodLength like this.
		/// It is called when the scheduler is notified to create a new thread.
		/// </summary>
		/// <param name="newThreadID">The id of the new thread.</param>
		/// <returns>the new thread</returns>
		public virtual PeriodicSimulationThread CreateFollowingThread(int newThreadID)
		{
			return new PeriodicSimulationThread(this.periodLength,this.periodID,newThreadID,this.firstTimeConsumer,
				this.type,this.observer);
		}

		/// <summary>
		/// called by MoveTime(...) to fire an event, when the timeline of the thread reached the periodlength.
		/// </summary>
		protected virtual void NotifyNewPeriodicThreadEvent()
		{
			if (NewPeriodicThreadEvent != null)
				NewPeriodicThreadEvent(this,EventArgs.Empty);
		}

		#endregion
	}
}
//EOF
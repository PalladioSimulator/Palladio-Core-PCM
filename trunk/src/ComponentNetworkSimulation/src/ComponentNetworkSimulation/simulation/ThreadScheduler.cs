using System;
using System.Collections;
using ComponentNetworkSimulation.structure;

namespace ComponentNetworkSimulation.simulation
{
	/// <summary>
	/// Handles the events fired when threads are created or destroyed.
	/// </summary>	
	public delegate void ThreadLifeCycleEventHandler(object sender,ThreadLifeCycleEventArgs eventArgs);

	/// <summary>
	/// This class manages the threads in the simulation. Therefor, it supports methods to create 
	/// new Threads (single or periodic), calculate the next timestep and move this step. Dead threads are
	/// removed and periodic threads are created by this class.
	/// </summary>
	public class ThreadScheduler 
	{
		#region events
		
		/// <summary>
		/// This event is fired, if one of the threads changes its current timeconsumer.
		/// </summary>
		public event NextTCEventHandler NextTCEvent;

		/// <summary>
		/// This event is fired, if a new thread was created.
		/// </summary>
		public event ThreadLifeCycleEventHandler ThreadCreatedEvent;

		/// <summary>
		/// This event is fired, if a thread is destroyed.
		/// </summary>
		public event ThreadLifeCycleEventHandler ThreadDestroyedEvent;

		/// <summary>
		/// This event is fired, if no more threads are alive
		/// </summary>
		public event EventHandler NoMoreThreadsAliveEvent;

		#endregion events

		#region data

		/// <summary>
		/// this fields is the counter for the threadID.
		/// </summary>
		protected int threadIDCounter = 0;

		/// <summary>
		/// this field is the counter for the periodID.
		/// </summary>
		protected int periodIDCounter = 0;
		
		/// <summary>
		/// this list holds all SimulationThreads
		/// </summary>
		protected IList simulationThreads = new ArrayList();

		/// <summary>
		/// this field holds a reference to the SimulationEnvironment
		/// </summary>
		protected AbstractSimulationEnvironment simulationEnvironment;

		#endregion data

		#region constructors

		/// <summary>
		/// constructs a new ThreadScheduler
		/// </summary>
		/// <param name="simulationEnvironment">the instance of SimulationEnvironment</param>
		public ThreadScheduler(AbstractSimulationEnvironment simulationEnvironment)
		{
			this.simulationEnvironment = simulationEnvironment;
		}

		#endregion constructors

		#region properties

		/// <summary>
		/// true, if any thread is alive 
		/// </summary>
		public bool IsAnyThreadAlive
		{
			get { return this.simulationThreads.Count>0;}
		}

		#endregion properties

		#region methods

		/// <summary>
		/// call to create a new SimulationThread.
		/// </summary>
		/// <param name="firstTimeConsumer">The first timeconsumer of this thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		public void CreateSimulationThread(TimeConsumer firstTimeConsumer, SimulationThread.SimuationThreadType type)
		{
			CreateSimulationThread(firstTimeConsumer,type,null);
		}

		/// <summary>
		/// call to create a new SimulationThread observed by the given observer.
		/// </summary>
		/// <param name="firstTimeConsumer">The first timeconsumer of this thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		/// <param name="observer">the oberserver</param>
		public void CreateSimulationThread(TimeConsumer firstTimeConsumer, SimulationThread.SimuationThreadType type, 
			IThreadObserver observer)
		{
			SimulationThread tmp = new SimulationThread(this.threadIDCounter++,firstTimeConsumer,type,observer);
			tmp.NextTCEvent += new NextTCEventHandler(OnNextTCEvent);
			simulationThreads.Add(tmp);			
			NotifyThreadCreatedEvent(tmp);
		}

		//TODO: the periodic ones
/*		public void CreateSimulationThread(TimeConsumer firstTimeConsumer, SimuationThreadType type, long periodTime)
		{
			SimulationThread tmp = CreateSimulationThread(periodIDCounter++, firstTimeConsumer,type);
			periodicThreadDataList.Add(new PeriodicThreadData(tmp.PeriodID,firstTimeConsumer,periodTime));
		}

		public void createSimulationThread(TimeConsumer firstTimeConsumer, SimuationThreadType type, long periodTime, 
			ThreadEventHandler eventHandler)
		{
			SimulationThread tmp = CreateSimulationThread(periodIDCounter++, firstTimeConsumer,type);
			periodicThreadDataList.Add(new PeriodicThreadData(tmp.PeriodID,firstTimeConsumer,periodTime));
			tmp.ThreadEvent += eventHandler;
		}*/

		/// <summary>
		/// calculates the shortest time in future of the current threads. This time is used for the next
		/// simulation step.
		/// </summary>
		/// <returns>the shortest time in future of the current threads</returns>
		public long GetShortestFutureTime() 
		{
			long minTime = -1;
			foreach (SimulationThread thread in this.simulationThreads) 
				if (thread.TimeInFuture < minTime || minTime == -1) minTime = thread.TimeInFuture;

			if (minTime == -1)
				return 0;
			else
                return minTime;
		}

		/// <summary>
		/// call to move the timeline in the scheduler. This methods iterates all threads to move there timelines.
		/// </summary>
		/// <param name="time">the timestep</param>
		public void MoveTime(long time)
		{
			foreach (SimulationThread thread in this.simulationThreads)	
				thread.TimeMoved(time);		
			this.clearDeadThreads();
			if (!this.IsAnyThreadAlive)	NotifyNoMoreThreadsAliveEvent();
		}
		
		/// <summary>
		/// call to reset the scheduler. This method method removes all threads and reset the id counters to zero.
		/// </summary>
		public void Reset()
		{
			this.simulationThreads.Clear();
			this.threadIDCounter = 0;
			this.periodIDCounter = 0;
		}

		/// <summary>
		/// called by MoveTime(...) to remove dead threads from ThreadList.
		/// </summary>
		private void clearDeadThreads()
		{
			int i=0;
			while (i<simulationThreads.Count) 
			{
				SimulationThread curThread = (SimulationThread)simulationThreads[i];
				if (!curThread.IsAlive)
				{				
					this.simulationThreads.RemoveAt(i);
					NotifyThreadDestroyedEvent(curThread);
				}
				else
					i++;
			}
		}

		/// <summary>
		/// called, when a new thread was created to fire a event
		/// </summary>
		/// <param name="theThread">the thread, which was created</param>
		protected virtual void NotifyThreadCreatedEvent(SimulationThread theThread)
		{
			if (ThreadCreatedEvent != null)
				ThreadCreatedEvent(this,new ThreadLifeCycleEventArgs(theThread));
		}

		/// <summary>
		/// called, when a thread was destroyed
		/// </summary>
		/// <param name="theThread">the thread, which was destroyed</param>
		protected virtual void NotifyThreadDestroyedEvent(SimulationThread theThread)
		{
			if (ThreadDestroyedEvent != null)
				ThreadDestroyedEvent(this,new ThreadLifeCycleEventArgs(theThread));
		}

		/// <summary>
		/// called after a call of MoveTime, if no more threads are alive
		/// </summary>
		/// <param name="theThread">the thread, which was destroyed</param>
		protected virtual void NotifyNoMoreThreadsAliveEvent()
		{
			if (NoMoreThreadsAliveEvent != null)
				NoMoreThreadsAliveEvent(this,EventArgs.Empty);
		}

		/// <summary>
		/// this method delegates the NextTCEvents of each thread to the listed eventhandlers 
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="eventArgs"></param>
		protected virtual void OnNextTCEvent(object sender, NextTCEventArgs eventArgs)
		{
			if (NextTCEvent != null)
				NextTCEvent(sender,eventArgs);
		}

		#endregion
	}
}
//EOF
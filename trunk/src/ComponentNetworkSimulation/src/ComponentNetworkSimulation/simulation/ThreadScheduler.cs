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
		/// This event is fired, if one of the threads changes its current TimeConsumer.
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
		/// this list is filled with new threads while scheduling one timestep. Before the starting the next timestep,
		/// the threads are added through the threadlist.
		/// </summary>
		private IList prepairedSimulationThreads = new ArrayList();

		/// <summary>
		/// this list holds all SimulationThreads
		/// </summary>
		private IList simulationThreads = new ArrayList();

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
			get { return this.simulationThreads.Count>0 || this.prepairedSimulationThreads.Count>0;}
		}

		/// <summary>
		/// returns the next valid threadID.
		/// </summary>
		protected int NextThreadID
		{
			get{ return threadIDCounter++;}
		}

		/// <summary>
		/// returns the next valid periodID.
		/// </summary>
		protected int NextPeriodID
		{
			get{ return periodIDCounter++;}
		}

		#endregion properties

		#region methods

		/// <summary>
		/// call to create a new SimulationThread.
		/// </summary>
		/// <param name="firstTimeConsumer">The first TimeConsumer of this thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		public void CreateSimulationThread(ITimeConsumer firstTimeConsumer, SimulationThread.SimuationThreadType type)
		{
			this.PrepairNewThread(new SimulationThread(this.NextThreadID,firstTimeConsumer,type));			
		}

		/// <summary>
		/// call to create a new SimulationThread observed by the given observer.
		/// </summary>
		/// <param name="firstTimeConsumer">The first TimeConsumer of this thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		/// <param name="observer">the oberserver</param>
		public void CreateSimulationThread(ITimeConsumer firstTimeConsumer, SimulationThread.SimuationThreadType type, 
			IThreadObserver observer)
		{
			this.PrepairNewThread(new SimulationThread(this.NextThreadID,firstTimeConsumer,type,observer));			
		}

		/// <summary>
		/// call to create a new SimulationThread.
		/// </summary>
		/// <param name="firstTimeConsumer">The first TimeConsumer of this thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		public void CreateSimulationThread(ITimeConsumer firstTimeConsumer, 
			SimulationThread.SimuationThreadType type, long periodTime)
		{
			CreateSimulationThread(firstTimeConsumer,type,periodTime,null);
		}

		/// <summary>
		/// call to create a new PeriodicSimulationThread observed by the given observer.
		/// </summary>
		/// <param name="firstTimeConsumer">The first TimeConsumer of this thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		/// <param name="periodTime">reached the thread this time, a new thread is created.</param>
		/// <param name="observer">the oberserver</param>
		public void CreateSimulationThread(ITimeConsumer firstTimeConsumer,SimulationThread.SimuationThreadType type,
			long periodTime, IThreadObserver observer)
		{
			PeriodicSimulationThread tmp = new PeriodicSimulationThread(periodTime,NextPeriodID,NextThreadID,
				firstTimeConsumer,type,observer);
			
			tmp.NewPeriodicThreadEvent += new EventHandler(this.OnNewPeriodicThreadEvent);
			this.PrepairNewThread(tmp);
		}

		public void AddSimulationThread(SimulationThread simulationThread)
		{
			//TODO: implement
			throw(new NotImplementedException("To be implemented"));
		}

		/// <summary>
		/// call to move the timeline in the scheduler. This methods iterates all threads to move there timelines.
		/// </summary>
		/// <param name="maxTimeStep">the maximum timestep</param>
		/// <returns>the realy done time step</returns>
		public virtual long SimulationStep(long maxTimeStep)
		{
			this.InsertPrepairedThreads();
			long timeStep = this.GetShortestFutureTime();
			if (maxTimeStep < timeStep) timeStep = maxTimeStep;

			foreach (SimulationThread thread in this.simulationThreads)	
				thread.TimeMoved(timeStep);		

			this.InsertPrepairedThreads();
			this.clearDeadThreads();
			if (!this.IsAnyThreadAlive)	NotifyNoMoreThreadsAliveEvent();

			return timeStep;
		}

		/// <summary>
		/// calculates the shortest time in future of the current threads. This time is used for the next
		/// simulation step.
		/// </summary>
		/// <returns>the shortest time in future of the current threads</returns>
		protected virtual long GetShortestFutureTime() 
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
		/// called to move all prepaired threads to the scheduled threadlist
		/// </summary>
		protected void InsertPrepairedThreads()
		{
			foreach(SimulationThread thread in this.prepairedSimulationThreads) 
			{
				simulationThreads.Add(thread);
				NotifyThreadCreatedEvent(thread);
			}
			prepairedSimulationThreads.Clear();
		}

		/// <summary>
		/// call to reset the scheduler. This method method removes all threads and reset the id counters to zero.
		/// </summary>
		public virtual void Reset()
		{
			this.simulationThreads.Clear();
			this.threadIDCounter = 0;
			this.periodIDCounter = 0;
		}

		/// <summary>
		/// called to prepair the given thread for adding it to the scheduler. 
		/// The thread is added after ending the current or before the next simulationstep.
		/// </summary>
		/// <param name="newThread">the thread to be added</param>
		protected void PrepairNewThread(SimulationThread newThread)
		{
			newThread.NextTCEvent += new NextTCEventHandler(OnNextTCEvent);
			this.prepairedSimulationThreads.Add(newThread);
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

		/// <summary>
		/// called by periodic threads to notify that a new one has to be created.
		/// </summary>
		/// <param name="sender">the periodic thread fired the event.</param>
		/// <param name="args">set to EventArgs.Empty</param>
		protected virtual void OnNewPeriodicThreadEvent(object sender, EventArgs args)
		{
			PeriodicSimulationThread tmp = ((PeriodicSimulationThread)sender).CreateFollowingThread(this.NextThreadID);
			tmp.NewPeriodicThreadEvent += new EventHandler(this.OnNewPeriodicThreadEvent);
			PrepairNewThread(tmp);
		}

		#endregion
	}
}
//EOF
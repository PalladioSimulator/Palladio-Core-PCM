using System;
using System.Collections;
using ComponentNetworkSimulation.Analysis;
using ComponentNetworkSimulation.Structure;
using ComponentNetworkSimulation.Structure.Visitor;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This class manages the threads in the simulation. Therefor, it supports methods to create 
	/// new Threads (single or periodic), calculate the next timestep and move this step. Dead threads are
	/// removed and periodic threads are created by this class.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.8  2004/06/26 15:43:35  joemal
	/// - fix bug in logging method
	///
	/// Revision 1.7  2004/06/23 16:34:47  joemal
	/// - now copy observer from one to the next periodic thread
	///
	/// Revision 1.6  2004/06/19 16:02:28  joemal
	/// - now the threads work with new visitors
	///
	/// Revision 1.5  2004/05/26 16:28:35  joemal
	/// threads now use the visitor to walk through the architecture
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultThreadScheduler : IThreadScheduler
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

		/// <summary>
		/// this event is fired, if a thread wants to log something
		/// </summary>
		public event LogEventHandler ThreadLogEvent;

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
		protected ISimulationEnvironment simulationEnvironment;

		#endregion data

		#region constructors

		/// <summary>
		/// constructs a new ThreadScheduler
		/// </summary>
		/// <param name="simulationEnvironment">the instance of SimulationEnvironment</param>
		public DefaultThreadScheduler(ISimulationEnvironment simulationEnvironment)
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
		/// <param name="start">the starting point of the thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		public void CreateSimulationThread(IThreadStartingPoint start, SimulationThreadType type)
		{
			IComponentVisitor visitor = this.simulationEnvironment.ComponentArchitecture.CreateVisitor(start);
			this.PrepairNewThread(new DefaultSimulationThread(this.NextThreadID,visitor,type));			
		}

		/// <summary>
		/// call to create a new SimulationThread observed by the given observer.
		/// </summary>
		/// <param name="start">the starting point of the thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		/// <param name="observer">the oberserver</param>
		public void CreateSimulationThread(IThreadStartingPoint start, SimulationThreadType type, 
			IThreadObserver observer)
		{
			IComponentVisitor visitor = this.simulationEnvironment.ComponentArchitecture.CreateVisitor(start);
			this.PrepairNewThread(new DefaultSimulationThread(this.NextThreadID,visitor,type,observer));			
		}

		/// <summary>
		/// call to create a new SimulationThread.
		/// </summary>
		/// <param name="start">the starting point of the thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		public void CreateSimulationThread(IThreadStartingPoint start, SimulationThreadType type, long periodTime)
		{
			CreateSimulationThread(start,type,periodTime,null);
		}

		/// <summary>
		/// call to create a new PeriodicSimulationThread observed by the given observer.
		/// </summary>
		/// <param name="start">the starting point of the thread.</param>
		/// <param name="type">The logging type of this thread.</param>
		/// <param name="periodTime">reached the thread this time, a new thread is created.</param>
		/// <param name="observer">the oberserver</param>
		public void CreateSimulationThread(IThreadStartingPoint start,SimulationThreadType type,
			long periodTime, IThreadObserver observer)
		{
			IComponentVisitor visitor = this.simulationEnvironment.ComponentArchitecture.CreateVisitor(start);

			DefaultPeriodicSimulationThread tmp = new DefaultPeriodicSimulationThread(periodTime,NextPeriodID,NextThreadID,
				start,visitor,type,observer);
			
			tmp.NewPeriodicThreadEvent += new EventHandler(this.OnNewPeriodicThreadEvent);
			this.PrepairNewThread(tmp);
		}

		/// <summary>
		/// call to add a simulationthread to the scheduler, created by any extern method.
		/// </summary>
		/// <param name="simulationThread">The simulationthread</param>
		public void AddSimulationThread(ISimulationThread simulationThread)
		{
			this.PrepairNewThread(simulationThread);
			if (simulationThread is IPeriodicSimulationThread)
				((IPeriodicSimulationThread)simulationThread).NewPeriodicThreadEvent += 
					new EventHandler(this.OnNewPeriodicThreadEvent);
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
		/// this methods make the scheduler to calculate the largest possible timestep
		/// </summary>
		/// <returns>the largest possible timestep</returns>
		public virtual long CalculateNextTimeStep()
		{
			this.InsertPrepairedThreads();
			return this.GetShortestFutureTime();
		}

		/// <summary>
		/// call to move the timeline in the scheduler.
		/// </summary>
		/// <param name="steptime">the time, the schedulers timeline has to be moved</param>
		public virtual void SimulationStep(long steptime)
		{
			foreach (ISimulationThread thread in this.simulationThreads)	
				thread.TimeMoved(steptime);		

			this.InsertPrepairedThreads();
			this.ClearDeadThreads();
			if (!this.IsAnyThreadAlive)	NotifyNoMoreThreadsAliveEvent();		
		}

		/// <summary>
		/// calculates the shortest time in future of the current threads. This time is used for the next
		/// simulation step.
		/// </summary>
		/// <returns>the shortest time in future of the current threads</returns>
		protected virtual long GetShortestFutureTime() 
		{
			long minTime = -1;
			foreach (ISimulationThread thread in this.simulationThreads) 
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
			foreach(ISimulationThread thread in this.prepairedSimulationThreads) 
			{
				simulationThreads.Add(thread);
				NotifyThreadCreatedEvent(thread);
			}
			prepairedSimulationThreads.Clear();
		}

		/// <summary>
		/// called to prepair the given thread for adding it to the scheduler. 
		/// The thread is added after ending the current or before the next simulationstep.
		/// </summary>
		/// <param name="newThread">the thread to be added</param>
		protected void PrepairNewThread(ISimulationThread newThread)
		{
			newThread.NextTCEvent += new NextTCEventHandler(OnNextTCEvent);
			this.prepairedSimulationThreads.Add(newThread);
		}

		/// <summary>
		/// called by MoveTime(...) to remove dead threads from ThreadList.
		/// </summary>
		private void ClearDeadThreads()
		{
			int i=0;
			while (i<simulationThreads.Count) 
			{
				ISimulationThread curThread = (ISimulationThread)simulationThreads[i];
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
		/// called to fire a event, when a new thread was created 
		/// </summary>
		/// <param name="theThread">the thread, which was created</param>
		protected virtual void NotifyThreadCreatedEvent(ISimulationThread theThread)
		{
			if (ThreadCreatedEvent != null)
				ThreadCreatedEvent(this,new ThreadLifeCycleEventArgs(theThread));
			NotifyThreadLogEvent("A new thread was created.",theThread,ThreadLogEventArgs.EventType.THREAD_CREATED,
				theThread.CurrentTimeConsumer);
		}

		/// <summary>
		/// called, when a thread was destroyed
		/// </summary>
		/// <param name="theThread">the thread, which was destroyed</param>
		protected virtual void NotifyThreadDestroyedEvent(ISimulationThread theThread)
		{
			if (ThreadDestroyedEvent != null)
				ThreadDestroyedEvent(this,new ThreadLifeCycleEventArgs(theThread));

			NotifyThreadLogEvent("A thread was destroyed.",theThread,ThreadLogEventArgs.EventType.THREAD_REACHED_END,null);
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
		/// called by a thread, if it wants to log something.
		/// </summary>
		/// <param name="previousTimeConsumer">the previous timeconsumer</param>
		/// <param name="simulationThread">the simulationthread that fired this event</param>
		/// <param name="type">the type of event</param>
		protected virtual void NotifyThreadLogEvent(String message, ISimulationThread simulationThread, 
			ThreadLogEventArgs.EventType type, ITimeConsumer timeConsumer)
		{
            if (ThreadLogEvent != null)
				ThreadLogEvent(this,new ThreadLogEventArgs(message,simulationThread,type,timeConsumer));
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

			NotifyThreadLogEvent((ISimulationThread)sender, eventArgs.PreviousTimeConsumer, eventArgs.CurrentTimeConsumer);
		}

		/// <summary>
		/// called by OnNextTCEvent. This method determs by the threadtype, if the event has to be logged.
		/// </summary>
		/// <param name="simulationThread">the thread that changed the timconsumer</param>
		/// <param name="previousTimeConsumer">the previous timeconsumer</param>
		/// <param name="currentTimeConsumer">the current timeconsumer</param>
		private void NotifyThreadLogEvent(ISimulationThread simulationThread, ITimeConsumer previousTimeConsumer,
			ITimeConsumer currentTimeConsumer)
		{
			if (simulationThread.TheType == SimulationThreadType.TYPE_LOG_NOTHING) 
				return;
			else
			{
				if (simulationThread.TheType == SimulationThreadType.TYPE_LOG_ALL || 
					previousTimeConsumer.LoggingType == LoggingType_t.LOG_ON_EXIT ||
					previousTimeConsumer.LoggingType == LoggingType_t.LOG_BOTH)
				{
					NotifyThreadLogEvent("Thread exited TimeConsumer.",simulationThread,
						ThreadLogEventArgs.EventType.THREAD_EXITED_TIMECONSUMER,previousTimeConsumer);
				}

				if (simulationThread.TheType == SimulationThreadType.TYPE_LOG_ALL || 
					currentTimeConsumer.LoggingType == LoggingType_t.LOG_ON_ENTER ||
					currentTimeConsumer.LoggingType == LoggingType_t.LOG_BOTH)
				{
					NotifyThreadLogEvent("Thread entered TimeConsumer.",simulationThread,
						ThreadLogEventArgs.EventType.THREAD_ENTERED_TIMECONSUMER,currentTimeConsumer);
				}
			}
		}

		/// <summary>
		/// called by periodic threads to notify that a new one has to be created.
		/// </summary>
		/// <param name="sender">the periodic thread fired the event.</param>
		/// <param name="args">set to EventArgs.Empty</param>
		protected virtual void OnNewPeriodicThreadEvent(object sender, EventArgs args)
		{
			IPeriodicSimulationThread old = (IPeriodicSimulationThread)sender;
			IComponentVisitor visitor = this.simulationEnvironment.ComponentArchitecture.CreateVisitor(old.StartingPoint);

			IPeriodicSimulationThread tmp = new DefaultPeriodicSimulationThread(old.PeriodLength,old.PeriodID,this.NextThreadID,
				old.StartingPoint,visitor,old.TheType,old.Observer);
			tmp.NewPeriodicThreadEvent += new EventHandler(this.OnNewPeriodicThreadEvent);
			
			PrepairNewThread(tmp);
		}

		#endregion
	}
}
//EOF
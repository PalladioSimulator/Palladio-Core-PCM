using System;

using ComponentNetworkSimulation.Structure;
using ComponentNetworkSimulation.Structure.Visitor;

using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Simulation
{
	#region declarations
		
	/// <summary>
	/// the declaration of the threadtype specifying the logging behavior of this thread.
	/// </summary>
	public enum SimulationThreadType {TYPE_LOG_ALL,TYPE_LOG_ON_LPS,TYPE_LOG_NOTHING};

	/// <summary>
	/// The declaration of the eventhandler for all thread events.
	/// </summary>	
	public delegate void NextTCEventHandler(object sender,NextTCEventArgs eventArgs);

	#endregion declarations

	/// <summary>
	/// This class implements the simulation thread which is representing one request to the component network.
	/// </summary>
 	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.9  2004/07/06 12:24:55  joemal
	/// - add a method that is called when the thread has entered the first TC
	///
	/// Revision 1.8  2004/07/02 16:20:12  joemal
	/// - now the threads must be started, after they have been created
	///
	/// Revision 1.7  2004/06/23 16:32:18  joemal
	/// - add sender attribute to some methods of the observer
	///
	/// Revision 1.6  2004/06/19 16:02:28  joemal
	/// - now the threads work with new visitors
	///
	/// Revision 1.5  2004/05/26 16:28:12  joemal
	/// threads now use the visitor to walk through the architecture
	///
	/// 
	/// </pre>
	/// </remarks>
	public class DefaultSimulationThread : ISimulationThread
	{
		#region event
		
		/// <summary>
		/// This event is fired, if the TimeConsumer has changed to next one
		/// </summary>
		public event NextTCEventHandler NextTCEvent;

		#endregion

		#region data

		// the visitor used to navigate through the component architecture
		private IComponentVisitor visitor = null;
	
		/// <summary>
		/// the id of the thread
		/// </summary>
		protected int threadId;

		/// <summary>
		/// this time contains the difference between the simulation time and the threads current state time.
		/// If this field is zero, the next TimeConsumer is entered.
		/// </summary>
		protected long timeInFuture=0;

		/// <summary>
		/// holds the type of the thread
		/// </summary>
		protected SimulationThreadType type = SimulationThreadType.TYPE_LOG_ON_LPS;

		/// <summary>
		/// this flag is false, until the scheduler has started this thread
		/// </summary>
		protected bool isStarted=false;

		/// <summary>
		/// this field hold an implemented observer if set
		/// </summary>
		protected IThreadObserver observer;

		#endregion data

		#region constructors

		/// <summary>
		/// constructs a new simulationthread.
		/// </summary>
		/// <param name="threadId">The id of the thread.</param>
		/// <param name="visitor">the visitor, used to walk through the componentarchitecture</param>
		/// <param name="type">The type of the thread.</param>
		public DefaultSimulationThread(int threadId, IComponentVisitor visitor,SimulationThreadType type):
			this(threadId,visitor,type,null)
		{
		}

		/// <summary>
		/// constructs a new simulationthread.
		/// </summary>
		/// <param name="threadId">The id of the thread.</param>
		/// <param name="visitor">the visitor, used to walk through the componentarchitecture</param>
		/// <param name="type">The type of the thread.</param>
		/// <param name="observer">the observer for this thread</param>
		public DefaultSimulationThread(int threadId, IComponentVisitor visitor,SimulationThreadType type, 
			IThreadObserver observer)
		{
			this.threadId = threadId;
			this.type = type;
			this.observer = observer;
			this.visitor = visitor;
			Init();
		}

		#endregion

		#region properties

		/// <summary>
		/// the current TimeConsumer
		/// </summary>
		public ComponentNetworkSimulation.Structure.ITimeConsumer CurrentTimeConsumer
		{
			get
			{
				return visitor.CurrentTimeConsumer;
			}
		}

		/// <summary>
		/// this time contains the difference between the simulation time and the threads current state time.
		/// </summary>
		public virtual long TimeInFuture
		{
			get
			{
				return this.timeInFuture;
			}
		}

		/// <summary>
		/// is true, if the thread already has following TimeConsumers 
		/// </summary>
		public virtual bool IsAlive
		{
			get
			{
				return this.HasAnyTimeConsumer();
			}
		}

		/// <summary>
		/// the id of the thread
		/// </summary>
		public int ThreadID
		{
			get
			{
				return this.threadId;
			}
		}

		/// <summary>
		/// returns the thread type
		/// </summary>
		public ComponentNetworkSimulation.Simulation.SimulationThreadType TheType
		{
			get
			{
				return this.type;
			}
		}

		#endregion

		#region methods

		/// <summary>
		/// call to init the first timeconsumer
		/// </summary>
		private void Init()
		{
			this.visitor.OnVisitorEvent += new VisitorEventHandler(HandleVisitorEvent);

			if (!(visitor.CurrentElement is ITimeConsumer))
			{
				while(!visitor.IsTimeConsumer && visitor.HasAnyElement)
					visitor.NextElement();
			}				
		}

		/// <summary>
		/// call to start the thread. This method normaly is started by the scheduler when it is inserted in the queue
		/// of threads. This method only must be called one time in the whole lifecycle of the thread.
		/// </summary>
		public void Start() 
		{
			if (this.isStarted) return; 
			
			this.timeInFuture = visitor.CurrentTimeConsumer.ThreadEntered();
			this.NotifyNextTCEvent(null);

			this.isStarted = true;
		}

		/// <summary>
		/// called to move the timeline.
		/// </summary>
		/// <param name="time">The timestep to be moved.</param>
		public virtual void TimeMoved(long time)
		{
			if (!this.HasAnyTimeConsumer()) return;
			
			timeInFuture -= time;
			NotifyTimeStepEvent(time);
			if (timeInFuture <= 0) NextTimeConsumer();
		}

		/// <summary>
		/// called if timeToFuture is zero to change to the next TimeConsumer.
		/// if the end of the control flow is reached, a thread event is fired and the thread is marked as dead.
		/// </summary>
		protected void NextTimeConsumer()
		{
			if (!this.HasAnyTimeConsumer()) return;

			ITimeConsumer previousTimeConsumer = visitor.CurrentTimeConsumer;
			previousTimeConsumer.ThreadExited();
            
			do
			{
				visitor.NextElement();
			}
			while(!visitor.IsTimeConsumer && visitor.HasAnyElement);

			ITimeConsumer newTimeConsumer = visitor.CurrentTimeConsumer;

			if (newTimeConsumer == null) return;

			this.timeInFuture = newTimeConsumer.ThreadEntered();
			NotifyNextTCEvent(previousTimeConsumer);
		}

		/// <summary>
		/// called to fire an event, when the thread changed the TimeConsumer
		/// </summary>
		/// <param name="previous">the previous TimeConsumer</param>
		protected virtual void NotifyNextTCEvent(ITimeConsumer previous)
		{
			if (NextTCEvent != null && previous != null)
				NextTCEvent(this,new NextTCEventArgs(this.CurrentTimeConsumer,previous));

			if (observer != null)
			{
				if (previous != null)
					observer.NotifyThreadChangedTimeConsumer(this,previous);
				else
					observer.NotifyThreadEnteredFirstTimeConsumer(this);
			}
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

		/// <summary>
		/// called to notify the listener, that an unbound external call was found. The thread skips the call.
		/// </summary>
		/// <param name="args">the parameter of the visitorevent</param>
		protected virtual void NotifyUnboundExternalCallEvent(VisitorEventArgs args)
		{
			if (observer != null)
				observer.NotifyUnboundExternalCall(this,args.Component,args.Signature);
		}

		/// <summary>
		/// called, if the visitor has found an unknown element. The threads is stopped and removed from the
		/// scheduler.
		/// </summary>
		protected virtual void NotifyUnknownElementEvent()
		{
			if (observer != null)
				observer.NotifyUnknownElementFound(this);
		}

		/// <summary>
		/// returns true, if any TimeConsumer is set to currentTimeConsumer
		/// </summary>
		/// <returns>true, if the thread is alive.</returns>
		protected bool HasAnyTimeConsumer()
		{
			return this.visitor.HasAnyElement && this.isStarted;
		}

		/// <summary>
		/// called by the visitor to notify events.
		/// </summary>
		/// <param name="sender">the visitor</param>
		/// <param name="args">the parameter of the event</param>
		protected virtual void HandleVisitorEvent(object sender, VisitorEventArgs args)
		{
			switch(args.Type)
			{
				case VisitorEventArgs.EventType.TYPE_EXTERNALCALL:
					NotifyUnboundExternalCallEvent(args);
					return;
				case VisitorEventArgs.EventType.TYPE_UNKNOWN_ELEMENT:
					NotifyUnknownElementEvent();
					NotifyThreadReachedEndEvent();
					return;
				case VisitorEventArgs.EventType.TYPE_RETURN:
					NotifyThreadReachedEndEvent();
					return;
				case VisitorEventArgs.EventType.TYPE_UNBOUNDREQUIRES:
					NotifyUnboundExternalCallEvent(args);
					return;
			}
		}

		#endregion
	}
}
//EOF
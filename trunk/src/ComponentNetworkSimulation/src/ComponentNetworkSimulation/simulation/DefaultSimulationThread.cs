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
		private IComponentArchitectureVisitor visitor = new DefaultComponentArchitectureVisitor();
	
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
		/// this field hold an implemented observer if set
		/// </summary>
		protected IThreadObserver observer;

		#endregion data

		#region constructors

		/// <summary>
		/// constructs a new simulationthread.
		/// </summary>
		/// <param name="threadId">The id of the thread.</param>
		/// <param name="start">the startingpoint of this thread</param>
		/// <param name="type">The type of the thread.</param>
		public DefaultSimulationThread(int threadId, IThreadStartingPoint start,SimulationThreadType type):
			this(threadId,start,type,null)
		{
		}

		/// <summary>
		/// constructs a new simulationthread.
		/// </summary>
		/// <param name="threadId">The id of the thread.</param>
		/// <param name="start">the startingpoint of this thread</param>
		/// <param name="type">The type of the thread.</param>
		/// <param name="observer">the observer for this thread</param>
		public DefaultSimulationThread(int threadId, IThreadStartingPoint start,SimulationThreadType type, 
			IThreadObserver observer)
		{
			this.threadId = threadId;
			this.type = type;
			this.observer = observer;

			init(start);
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

		//does some initial work
		private void init(IThreadStartingPoint start)
		{
			this.visitor.SetStart(start);
			if (visitor.CurrentTimeConsumer != null)
				this.timeInFuture = visitor.CurrentTimeConsumer.ThreadEntered();
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
            
			ITimeConsumer newTimeConsumer = visitor.NextTimeConsumer();            

			if (newTimeConsumer == null)
			{
				NotifyThreadReachedEndEvent();
				return;
			}

			this.timeInFuture = newTimeConsumer.ThreadEntered();
			NotifyNextTCEvent(previousTimeConsumer);
		}



		/// <summary>
		/// called to fire an event, when the thread changed the TimeConsumer
		/// </summary>
		/// <param name="previous">the previous TimeConsumer</param>
		protected virtual void NotifyNextTCEvent(ITimeConsumer previous)
		{
			if (NextTCEvent != null)
				NextTCEvent(this,new NextTCEventArgs(this.CurrentTimeConsumer,previous));

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

		/// <summary>
		/// returns true, if any TimeConsumer is set to currentTimeConsumer
		/// </summary>
		/// <returns>true, if the thread is alive.</returns>
		protected bool HasAnyTimeConsumer()
		{
			return this.visitor.CurrentTimeConsumer != null;
		}

		#endregion
	}
}
//EOF
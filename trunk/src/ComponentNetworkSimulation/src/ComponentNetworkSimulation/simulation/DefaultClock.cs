using System;
using ComponentNetworkSimulation;
using ComponentNetworkSimulation.structure;
using System.Collections;

namespace ComponentNetworkSimulation.Simulation
{
	/// <summary>
	/// This class represents the clock of the simulation environment. It contains an absolute time counter of simulation time
	/// to syncronize the simulation. The simulation time, if not set, is limitet to long.MaxValue.
	/// Clock also contains an instance of ThreadScheduler, which manages the simulationthreads.
	/// </summary>
	public class DefaultClock : IClock
	{		
		#region events

		/// <summary>
		/// This event is fired, when the timeline of the clock moves a step. The arguments of this events contains
		/// the step length and the new absolute time.
		/// </summary>
		public event TimeStepEventHandler TimeStepEvent;

		/// <summary>
		/// This event is fired, when the maximum simulation time s reached
		/// </summary>
		public event EventHandler MaxTimeReachedEvent;

		/// <summary>
		/// This event is fired, when the clock was reseted.
		/// </summary>
		public event EventHandler ClockResetEvent;

		#endregion

		#region data

		/// <summary>
		/// holds the maxium simulation time. By default, it is set to long.MaxValue.
		/// </summary>
		protected long maxSimulationTime = long.MaxValue;

		/// <summary>
		/// holds the current absolute simulation time.
		/// </summary>
		private long currentTime = 0;

		/// <summary>
		/// holds an reference to the simulation environment
		/// </summary>
		protected ISimulationEnvironment simulationEnvironment = null;

		/// <summary>
		/// holds the instance of the threadscheduler
		/// </summary>
		private IThreadScheduler scheduler = null;

		#endregion

		#region constructors

		/// <summary>
		/// constructs a new Clock used by given simulation environment. The maximum simulation time is set to long.MaxValue.
		/// </summary>
		/// <param name="simulationEnvironment">the simulation environment</param>
		public DefaultClock(ISimulationEnvironment simulationEnvironment) : this(simulationEnvironment,long.MaxValue)
		{
		}

		/// <summary>
		/// constructs a new Clock used by given simulation environment. The maximum simulation time is set to 
		/// given value.
		/// </summary>
		/// <param name="simulationEnvironment">the simulation environment</param>
		/// <param name="maxSimulationTime">the maximum simulation time</param>
		public DefaultClock(ISimulationEnvironment simulationEnvironment, long maxSimulationTime) 
		{
			this.maxSimulationTime = maxSimulationTime;
			this.simulationEnvironment = simulationEnvironment;
			this.scheduler = this.CreateScheduler();
		}

		#endregion

		#region Properties

		/// <summary>
		/// This property sets and returns the maximum simulation time.
		/// </summary>
		public long MaximumSimulationTime 
		{
			get { return this.maxSimulationTime;}
			set 
			{
				if (value < 0)
					this.maxSimulationTime = long.MaxValue;
				else
					this.maxSimulationTime = value;
			}
		}

		/// <summary>
		/// return the instance of the Thread Scheduler
		/// </summary>
		public IThreadScheduler ThreadScheduler
		{
			get {return this.scheduler;}
		}

		/// <summary>
		/// return the current absolute simulation time
		/// </summary>
		public long CurrentTime
		{
			get {return this.currentTime;}
		}

		/// <summary>
		/// returns true, if the maximum simulation time is reached 
		/// </summary>
		public bool IsMaxTimeReached 
		{
			get {return currentTime >= maxSimulationTime;}
		}

		#endregion

		#region methods

		/// <summary>
		/// this method is called by the constructor to create an instance of the ThreadScheduler 
		/// </summary>
		protected virtual IThreadScheduler CreateScheduler()
		{
			return new DefaultThreadScheduler(this.simulationEnvironment);
		}

		/// <summary>
		/// call to simulate one step
		/// </summary>
		/// <returns>returns false, if the simulation reached its end because of reaching the maximum simulation time
		/// or there are no more thread alive.</returns>
		public bool SimulationStep() 
		{

			if (IsMaxTimeReached || !scheduler.IsAnyThreadAlive) return false;
			
			long curStep = scheduler.SimulationStep(maxSimulationTime-currentTime);
			currentTime += curStep;

			NotifyTimeStepEvent(curStep);

			if (currentTime == maxSimulationTime) NotifyMaxTimeReachedEvent();

			return scheduler.IsAnyThreadAlive && !IsMaxTimeReached;
		}

		/// <summary>
		/// call to reset the clock. All Threads in the ThreadScheduler are reseted and the simulationtime is set to zero.
		/// </summary>
		public void Reset() 
		{
			currentTime = 0;
			scheduler.Reset();
			NotifyClockResetEvent();
		}

		/// <summary>
		/// called, when the current time moved, to fire an event.
		/// </summary>
		/// <param name="timeStep">The timestep, the time moved</param>
		protected virtual void NotifyTimeStepEvent(long timeStep)
		{
            if (TimeStepEvent != null)
				TimeStepEvent(this,new TimeStepEventArgs(timeStep,this.currentTime));
		}

		/// <summary>
		/// called, when the maximum time is reached, in order to fire an event
		/// </summary>
		protected virtual void NotifyMaxTimeReachedEvent()
		{
			if (MaxTimeReachedEvent != null)
				MaxTimeReachedEvent(this,EventArgs.Empty);
		}

		/// <summary>
		/// called, when the clock was reset, in order to fire an event.
		/// </summary>
		protected virtual void NotifyClockResetEvent()
		{
			if (ClockResetEvent != null)
				ClockResetEvent(this,EventArgs.Empty);
		}

		#endregion
	}
}
//EOF
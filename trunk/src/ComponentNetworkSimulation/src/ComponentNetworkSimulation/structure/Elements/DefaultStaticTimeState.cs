using System;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// This class is the default implementation of a simulationstate with static waitingtime.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/05/20 14:12:22  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultStaticTimeState : AbstractSimulationState
	{
		/// <summary>
		/// constructs a new DefaultStaticTimeState.
		/// </summary>
		/// <param name="param">the structure constaining some parameters for this state.</param>
		public DefaultStaticTimeState(StaticTimeStateParams param) : base(param)
		{
		}

		/// <summary>
		/// called, when a thread entered this state.
		/// </summary>
		/// <returns>the static waiting time of this state.</returns>
		public override long ThreadEntered()
		{
			return ((StaticTimeStateParams)this.stateParams).StaticTime;
		}

		/// <summary>
		/// a call to this method has no effect on this implementation.
		/// </summary>
		public override void ThreadExited()
		{

		}
	}
}
//EOF
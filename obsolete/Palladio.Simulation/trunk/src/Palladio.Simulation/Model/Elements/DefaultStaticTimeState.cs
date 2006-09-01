using System;
using Palladio.Simulation.Model.Attributes;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This class is the default implementation of a simulationstate with static waitingtime.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
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
			this.Attributes.Add(DefaultAttributeTypeSet.StaticTimeType,param.StaticTime);
		}

		/// <summary>
		/// called, when a thread entered this state.
		/// </summary>
		/// <returns>the static waiting time of this state.</returns>
		public override long ThreadEntered()
		{
			return (long)this.Attributes[DefaultAttributeTypeSet.StaticTimeType];
		}

		/// <summary>
		/// a call to this method has no effect on this implementation.
		/// </summary>
		public override void ThreadExited()
		{

		}

		/// <summary>
		/// this method is called, when the simulation wants to reset the architecture. 
		/// This method is not needed in this implementation.
		/// </summary>
		public override void Reset()
		{
		}

		/// <summary>
		/// Default implementation of GetHashCode
		/// </summary>
		/// <returns></returns>
		public override int GetHashCode()
		{
			return base.GetHashCode ();
		}

		
		/// <summary>
		///		Default implementation of Equals.
		/// </summary>
		/// <param name="obj">
		///		The other object.
		///	</param>
		/// <returns>
		///		True, if Name, IsStartState, IsFinalState 
		///		and the static time are Equal; false otherwise.
		///	</returns>
		public override bool Equals(object obj) 
		{
			if (!base.Equals(obj)) return false;
			ISimulationState simState = (ISimulationState)obj;

			long myTime = (long)this.Attributes[DefaultAttributeTypeSet.StaticTimeType];
			long itsTime = (long)simState.Attributes[DefaultAttributeTypeSet.StaticTimeType];

			return myTime == itsTime;
		}
	}
}
//EOF
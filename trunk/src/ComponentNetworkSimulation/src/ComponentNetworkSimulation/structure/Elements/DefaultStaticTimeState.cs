using System;
using ComponentNetworkSimulation.Structure.Attributes;

namespace ComponentNetworkSimulation.Structure.Elements
{
	/// <summary>
	/// This class is the default implementation of a simulationstate with static waitingtime.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.3  2004/06/17 12:07:35  joemal
	/// change namespace from service to elements
	///
	/// Revision 1.2  2004/05/25 16:23:37  joemal
	/// parameters now are stored in attributehash
	///
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
	}
}
//EOF
using System;
using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// Zusammenfassung für StaticTimeTransition.
	/// </summary>
	public class StaticTimeTransition : AbstractTimeConsumingTransition
	{
		public StaticTimeTransition(IState aSourceState, Input anInputSymbol, IState aDestinationState, 
			BasicTimeTransitionParams param) : base(aSourceState,anInputSymbol,aDestinationState,param)
		{
		}

		public override bool HasNextTimeConsumer
		{
			get
			{
				return true;
			}
		}

		public override ITimeConsumer NextTimeConsumer
		{
			get
			{
				return null;
			}
		}

		public override ITimeConsumer NextTimeConsumerAfterReturn
		{
			get
			{
				return null;
			}
		}

		public override long ThreadEntered()
		{
			return param.StaticTime;
		}

	}
}

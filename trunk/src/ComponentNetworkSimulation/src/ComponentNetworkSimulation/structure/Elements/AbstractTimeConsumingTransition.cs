using System;

using Palladio.FiniteStateMachines;

using ComponentNetworkSimulation.Structure;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// Zusammenfassung für AbstractTimeConsumingTransition.
	/// </summary>
	public abstract class AbstractTimeConsumingTransition : Transition,ISubCallingTimeConsumer
	{
		protected BasicTimeTransitionParams param;

		public AbstractTimeConsumingTransition(IState aSourceState, Input anInputSymbol, IState aDestinationState,
			BasicTimeTransitionParams param): base(aSourceState,anInputSymbol,aDestinationState)
		{
			this.param = param;
		}

		#region methods

		public abstract long ThreadEntered();

		public void ThreadExited()
		{
		}

		#endregion

		#region Properties

		public abstract ITimeConsumer NextTimeConsumerAfterReturn
		{
			get;
		}

		public abstract ITimeConsumer NextTimeConsumer
		{
			get;
		}

		public abstract bool HasNextTimeConsumer
		{
			get;
		}

		public LoggingType_t LoggingType
		{
			get { return this.param.LoggingType;}
		}

		public double Probability
		{
			get { return this.param.Probability;}
		}

		#endregion
	}
}
//EOF
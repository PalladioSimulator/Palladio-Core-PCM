using System;
using System.Collections;

using Palladio.FiniteStateMachines;

using ComponentNetworkSimulation.Structure;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// Zusammenfassung für StaticTimeConsumingState.
	/// </summary>
	public class StaticTimeState : AbstractTimeConsumingState
	{
		#region data

		protected static Random RANDOMIZER = new Random();

		protected ITimeConsumer nextTimeConsumer=null;

		#endregion

		internal StaticTimeState(string name ,bool isStart ,bool isFinal, BasicTimeStateParams param) :
			base (name,isStart,isFinal,param)
		{
		}

		public override long ThreadEntered()
		{
			this.nextTimeConsumer = SelectNextTimeConsumer();
			return this.param.StaticTime;
		}

		protected virtual ITimeConsumer SelectNextTimeConsumer()
		{
			IList outTransitions = this.param.FiniteStateMachine.GetOutgoingTransitions(this);

			//calculate the sum of the probabilities of all out going transitions
			double probabilitySum = 0;
			foreach (AbstractTimeConsumingTransition trans in outTransitions)
				probabilitySum += trans.Probability;

			double random = RANDOMIZER.NextDouble();

			//if the probability sum is more than 1.0 or this state is not a final state, normalize the random value
			if (probabilitySum > 1.0 || !this.IsFinalState) random *= probabilitySum;

			probabilitySum = 0;
			foreach (AbstractTimeConsumingTransition trans in outTransitions)
			{
				probabilitySum += trans.Probability;
				if (random < probabilitySum) return trans;
			}
			
			return null;
		}

		public override bool HasNextTimeConsumer
		{
			get
			{
				return (this.nextTimeConsumer != null);
			}
		}

		public override ITimeConsumer NextTimeConsumer
		{
			get
			{
				return this.nextTimeConsumer;
			}
		}

	}
}
//EOF
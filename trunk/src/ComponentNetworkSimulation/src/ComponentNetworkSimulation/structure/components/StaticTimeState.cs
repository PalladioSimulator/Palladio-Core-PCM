using System;

using Palladio.FiniteStateMachines;

using ComponentNetworkSimulation.Structure;

namespace ComponentNetworkSimulation.Structure.Components
{
	/// <summary>
	/// Zusammenfassung für StaticTimeConsumingState.
	/// </summary>
	public class StaticTimeState : AbstractTimeConsumingState
	{
		#region data

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
			//IList outTransitions = this.param.FiniteStateMachine.GetOutgoingTransitions(this);

			double probabilitySum = 0;
			//TODO: impl ...
//			foreach (
			return null;
		}

		public override bool HasNextTimeConsumer
		{
			get
			{
				return false;
			}
		}

		public override ITimeConsumer NextTimeConsumer
		{
			get
			{
				return null;
			}
		}

	}
}

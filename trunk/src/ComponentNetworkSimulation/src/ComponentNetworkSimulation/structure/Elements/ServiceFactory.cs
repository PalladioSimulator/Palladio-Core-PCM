using System;

using Palladio.FiniteStateMachines;

namespace ComponentNetworkSimulation.Structure.Services
{
	/// <summary>
	/// Zusammenfassung für TimeConsumingFSMFactory.
	/// </summary>
	public class ServiceFactory
	{
		protected static FSMFactory FSM_FACTORY = new FSMFactory();

		public static IFiniteStateMachine CreateEmptyFSM()
		{
			return FSM_FACTORY.GenerateFSM();
		}

		public static AbstractTimeConsumingState CreateStaticTimeStartState(string name,BasicTimeStateParams param)
		{
			return new StaticTimeState(name,true,false,param);
		}

		public static AbstractTimeConsumingState CreateStaticTimeFinalState(string name,BasicTimeStateParams param)
		{
			return new StaticTimeState(name,false,true,param);
		}

		public static AbstractTimeConsumingState CreateStaticTimeState(string name,BasicTimeStateParams param)
		{
			return new StaticTimeState(name,false,false,param);
		}
	}
}

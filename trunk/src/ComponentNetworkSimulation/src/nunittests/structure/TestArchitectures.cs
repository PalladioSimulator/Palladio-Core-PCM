using System;
using Palladio.FiniteStateMachines;
using ComponentNetworkSimulation.Structure.Services;
using ComponentNetworkSimulation.Structure;

namespace nunittests.structure
{
	/// <summary>
	/// </summary>
 	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.3  2004/05/27 10:31:47  joemal
	/// xxx
	///
	/// Revision 1.2  2004/05/26 16:38:46  joemal
	/// xxx
	///
	/// Revision 1.1  2004/05/24 16:00:14  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>

	public class TestArchitectures
	{

		public static IFiniteStateMachine createFSM() 
		{
			IServiceBuilder builder = new DefaultServiceBuilder();

			IControlFlowStrategy strategy = builder.GetControlFlowStrategy(DefaultServiceBuilder.STRATEGY_RANDOM);

			builder.AddState(new StaticTimeStateParams("0",strategy,LoggingType_t.NO_LOG,5));
			builder.AddState(new StaticTimeStateParams("1",strategy,LoggingType_t.NO_LOG,7));
			builder.AddState(new StaticTimeStateParams("2",strategy,LoggingType_t.NO_LOG,3));
			builder.AddState(new StaticTimeStateParams("3",strategy,LoggingType_t.NO_LOG,8));

			builder.SetFinalStates(new String[]{"3"});
			builder.SetStartState("0");

			builder.AddTransition("0","e0","1");
			builder.AddTransition("1","e1","2");
			builder.AddTransition("1","e2","3");
			builder.AddTransition("2","e2","3");

			return builder.BuildService();
		}

		public static IFiniteStateMachine createFSM2() 
		{
			IServiceBuilder builder = new DefaultServiceBuilder();

			IControlFlowStrategy strategy = builder.GetControlFlowStrategy(DefaultServiceBuilder.STRATEGY_RANDOM);

			builder.AddState(new StaticTimeStateParams("0",strategy,LoggingType_t.NO_LOG,2));
			builder.AddState(new StaticTimeStateParams("1",strategy,LoggingType_t.NO_LOG,3));
			builder.AddState(new StaticTimeStateParams("2",strategy,LoggingType_t.NO_LOG,1));
			builder.AddState(new StaticTimeStateParams("3",strategy,LoggingType_t.NO_LOG,6));

			builder.SetFinalStates(new String[]{"3"});
			builder.SetStartState("0");

			builder.AddTransition("0","e0","1");
			builder.AddTransition("1","e2","2");
			builder.AddTransition("2","e3","1");
			builder.AddTransition("1","e1","3");

			return builder.BuildService();
		}

		public static IFiniteStateMachine createFSMSEqualsFOneT() 
		{
			IServiceBuilder builder = new DefaultServiceBuilder();
			IControlFlowStrategy strategy = builder.GetControlFlowStrategy(DefaultServiceBuilder.STRATEGY_RANDOM);

			builder.AddState(new StaticTimeStateParams("0",strategy,LoggingType_t.NO_LOG,5));
			builder.SetFinalStates(new String[]{"0"});
			builder.SetStartState("0");
            
			builder.AddTransition("0","e0","0");

			return builder.BuildService();
		}
	}
}

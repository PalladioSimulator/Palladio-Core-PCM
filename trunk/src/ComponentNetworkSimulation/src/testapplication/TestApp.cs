using System;
using System.Collections;
using ComponentNetworkSimulation;
using ComponentNetworkSimulation.Structure;
using ComponentNetworkSimulation.Structure.Services;
using ComponentNetworkSimulation.Structure.Visitor;
using Palladio.FiniteStateMachines;

namespace testapplication
{

	public class TestApp
	{
		public static Random random = new Random();

		public static void Main()
		{
			/*		try 
					{
						ISimulationEnvironment env = new SimpleTestSimulationEnvironment();
						env.Simulate();
					}
					catch(Exception exc)
					{
						Console.Out.WriteLine(""+exc.GetType()+exc.StackTrace);
				
					}
		*/			
			IFiniteStateMachine fsm = createFSM();

			IComponentArchitectureVisitor visitor = new DefaultComponentArchitectureVisitor();
			visitor.SetStart(fsm);
            
			int a=0;

			while(visitor.CurrentTimeConsumer != null && a++ <20)
			{
				Console.WriteLine("Enter TC: "+visitor.CurrentTimeConsumer+", time to wait: "+
					visitor.CurrentTimeConsumer.ThreadEntered());
				visitor.NextTimeConsumer();
			}
			Console.ReadLine();
			
		}

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

	}
}

using System;
using Palladio.FiniteStateMachines;
using Palladio.Attributes;
using ComponentNetworkSimulation.Structure.Services;

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

			IState state = FSMFactory.CreateDefaultState("State");
			IAttributeType type = new AttributesFactory().Default.CreateAttributeType(Guid.NewGuid(),"Controlflowstrategie",typeof(IControlFlowStrategy));
			state.Attributes.Add(type, new DefaultServiceBuilder().GetControlFlowStrategy(DefaultServiceBuilder.STRATEGY_RANDOM));
            Console.WriteLine("Attr: "+state.Attributes[type]);
			Console.ReadLine();
			
		}
	}
}

using System;
using ComponentNetworkSimulation;
namespace testapplication
{

	public class TestApp
	{
		public static void Main()
		{
			try 
			{
				ISimulationEnvironment env = new SimpleTestSimulationEnvironment();
				env.Simulate();
			}
			catch(Exception exc)
			{
				Console.Out.WriteLine(""+exc.GetType()+exc.StackTrace);
				
			}

			Console.ReadLine();
		}
	}
}

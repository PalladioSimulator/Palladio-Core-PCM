using ComponentNetworkSimulation.structure;
using ComponentNetworkSimulation.structure.componentnetwork;

namespace testapplication
{
	public class TestApp
	{
		public static void Main()
		{
			AbstractComponentNetwork network = ComponentNetworkFactory.createXMLBasedComponentNetwork("Hallo.xml");
			network.buildUp();
			
			System.Console.Out.WriteLine(network.getName());
			System.Console.ReadLine();
		}
	}
}

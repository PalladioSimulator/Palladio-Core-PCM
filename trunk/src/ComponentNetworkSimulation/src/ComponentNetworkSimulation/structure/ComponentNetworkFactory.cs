namespace ComponentNetworkSimulation.Structure
{
	public class ComponentNetworkFactory
	{
		public static AbstractComponentNetwork createXMLBasedComponentNetwork(System.String xmlFile) 
		{
			return new Componentnetwork.XMLBasedComponentNetwork(xmlFile);
		}
	}
}

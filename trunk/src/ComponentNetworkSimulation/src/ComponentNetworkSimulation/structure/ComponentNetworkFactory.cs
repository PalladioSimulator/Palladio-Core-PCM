namespace ComponentNetworkSimulation.structure
{
	public class ComponentNetworkFactory
	{
		public static AbstractComponentNetwork createXMLBasedComponentNetwork(System.String xmlFile) 
		{
			return new componentnetwork.XMLBasedComponentNetwork(xmlFile);
		}
	}
}

namespace ComponentNetworkSimulation.structure.componentnetwork
{
	public class ComponentNetworkFactory
	{
		public static AbstractComponentNetwork createXMLBasedComponentNetwork(System.String xmlFile) 
		{
			return new XMLBasedComponentNetwork(xmlFile);
		}
	}
}

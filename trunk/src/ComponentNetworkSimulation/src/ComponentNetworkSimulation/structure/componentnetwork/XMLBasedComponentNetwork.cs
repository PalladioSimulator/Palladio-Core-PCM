namespace ComponentNetworkSimulation.Structure.Componentnetwork
{
	internal class XMLBasedComponentNetwork: AbstractComponentNetwork 
	{
		public XMLBasedComponentNetwork(System.String xmlFile)
		{			
			throw(new System.ApplicationException("XMLBasedComponentNetwork: Has to be implemented"));
		}

		public override System.String getName()
		{
			//TODO: return name of network read from xmlfile
			return "XMLBasedComponentNetwork";
		}
	}
}

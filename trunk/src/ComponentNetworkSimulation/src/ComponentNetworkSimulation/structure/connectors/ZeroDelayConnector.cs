namespace ComponentNetworkSimulation.structure.connectors
{
	internal class ZeroDelayConnector: ComponentNetworkSimulation.structure.AbstractConnector 
	{
		public ZeroDelayConnector()
		{
		}

		public override System.String getName()
		{
			return "Connector with zero delay";
		}

		public override long getUsedTime(System.Object thread)
		{
			return 0;
		}
	}
}

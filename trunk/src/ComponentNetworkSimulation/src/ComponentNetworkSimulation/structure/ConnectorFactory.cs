namespace ComponentNetworkSimulation.Structure
{
	public class ConnectorFactory
	{
		public static ComponentNetworkSimulation.Structure.AbstractConnector createZeroTimeConnector(int id)
		{
			return new Connectors.ZeroDelayConnector(id);
		}

		public static ComponentNetworkSimulation.Structure.AbstractConnector createConstantTimeConnector(int id,long delayTime)
		{
			return new Connectors.ConstantTimeConnector(id,delayTime);
		}
	}
}

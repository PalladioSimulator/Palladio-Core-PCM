namespace ComponentNetworkSimulation.structure.connectors
{
	public class ConnectorFactory
	{
		public static ComponentNetworkSimulation.structure.AbstractConnector createZeroTimeConnector(int id)
		{
			return new ZeroDelayConnector(id);
		}

		public static ComponentNetworkSimulation.structure.AbstractConnector createConstantTimeConnector(int id,long delayTime)
		{
			return new ConstantTimeConnector(id,delayTime);
		}
	}
}

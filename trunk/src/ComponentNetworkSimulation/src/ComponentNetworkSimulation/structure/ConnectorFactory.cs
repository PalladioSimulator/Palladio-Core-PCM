namespace ComponentNetworkSimulation.structure
{
	public class ConnectorFactory
	{
		public static ComponentNetworkSimulation.structure.AbstractConnector createZeroTimeConnector(int id)
		{
			return new connectors.ZeroDelayConnector(id);
		}

		public static ComponentNetworkSimulation.structure.AbstractConnector createConstantTimeConnector(int id,long delayTime)
		{
			return new connectors.ConstantTimeConnector(id,delayTime);
		}
	}
}

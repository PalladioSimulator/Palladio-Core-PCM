namespace ComponentNetworkSimulation.structure.connectors
{
	public enum ConnectorType {ZeroTimeConnector};

	public class ConnectorFactory
	{
		public static AbstractConnector createConnector(ConnectorType type)
		{
			switch(type) 
			{
				case ConnectorType.ZeroTimeConnector:
					return new ZeroDelayConnector();
				default:
					return null;
			}
		}
	}
}

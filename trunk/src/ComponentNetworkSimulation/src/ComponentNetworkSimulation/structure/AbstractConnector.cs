namespace ComponentNetworkSimulation.structure
{
	public abstract class AbstractConnector : TimeUser
	{
		public abstract long getUsedTime(System.Object thread);

		public abstract System.String getName();
	}
}

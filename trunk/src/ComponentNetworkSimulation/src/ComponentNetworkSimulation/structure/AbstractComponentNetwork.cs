using System.Collections;

namespace ComponentNetworkSimulation.Structure
{
	public abstract class AbstractComponentNetwork
	{
		protected ArrayList SystemServices = new ArrayList();
		protected ArrayList ConnectorList = new ArrayList();
	
		public abstract System.String getName();

		public ITimeConsumer getSystemService(int idx)
		{
			if (idx < SystemServices.Count)
				return (ITimeConsumer)SystemServices[idx];
			else
				return null;
		}

		public int getSystemServiceCount() 
		{
			return SystemServices.Count;
		}

		public IList getSystemServices()
		{
			return SystemServices;
		}

		public void reset()
		{
			for (int a=0;a<ConnectorList.Count;a++)
				((AbstractConnector)ConnectorList[a]).reset();
		}
	}
}

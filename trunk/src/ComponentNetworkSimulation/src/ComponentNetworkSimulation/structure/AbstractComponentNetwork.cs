using System.Collections;

namespace ComponentNetworkSimulation.structure
{
	public abstract class AbstractComponentNetwork
	{
		protected ArrayList SystemServices = new ArrayList();
	
		public abstract System.String getName();

		public abstract void buildUp();

		public ExternalComponentService getSystemService(int idx)
		{
			if (idx >= SystemServices.Count)
				return (ExternalComponentService)SystemServices[idx];
			else
				return null;
		}

		public int getSystemServiceCount() 
		{
			return SystemServices.Count;
		}

		public IEnumerator getSystemServices()
		{
			return SystemServices.GetEnumerator();
		}
 
	}
}

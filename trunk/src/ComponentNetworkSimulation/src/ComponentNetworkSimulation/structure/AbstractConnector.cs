using System.Collections;
namespace ComponentNetworkSimulation.structure
{
	public abstract class AbstractConnector
	{
		public AbstractConnector(int id)
		{
			this.the_id = id;
		}

		public int id
		{
			get
			{
				return the_id;
			}
		}

		public void addConnectorPath(ConnectorPath path) 
		{
			connectorPathList.Add(path);
		}

		public virtual System.String getName() 
		{
			return "Connector "+id;
		}

		public override string ToString()
		{
			return this.getName();
		}


		public abstract long getDelayTime();

		public abstract void reset();


		protected ArrayList connectorPathList = new ArrayList();

		protected int the_id;
	}
}

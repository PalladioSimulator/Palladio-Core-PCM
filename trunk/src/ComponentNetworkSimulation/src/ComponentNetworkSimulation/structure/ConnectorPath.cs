namespace ComponentNetworkSimulation.Structure
{
	public class ConnectorPath : ITimeConsumer
	{
		//
		// all connectorpaths have at least an internal service as following TimeConsumer
		// 
		/// <TgData>
		/// 	<link_directed>Directed</link_directed>
		/// 	<link_label>nextTimeConsumer</link_label>
		/// 	<link_clientCardinality>1</link_clientCardinality>
		/// </TgData>
		protected ITimeConsumer nextTimeConsumer = null;

		//
		//each path belongs to one connector
		//
		/// <TgData>
		/// 	<link_clientCardinality>1</link_clientCardinality>
		/// 	<link_supplierCardinality>0..*</link_supplierCardinality>
		/// </TgData>
		protected AbstractConnector owningConnector = null;

		protected LoggingType_t loggingType = LoggingType_t.NO_LOG;

		public ConnectorPath(AbstractConnector owningConnector, ITimeConsumer nextTimeConsumer) : 
			this(owningConnector, nextTimeConsumer,LoggingType_t.NO_LOG)
		{
		}

		public ConnectorPath(AbstractConnector owningConnector, ITimeConsumer nextTimeConsumer, LoggingType_t type) 
		{
			this.nextTimeConsumer = nextTimeConsumer;
			this.owningConnector = owningConnector;
		}

		#region ITimeConsumer Member

		public ITimeConsumer NextTimeConsumer 
		{
			get
			{
				return this.nextTimeConsumer;
			}
		}

		public bool HasNextTimeConsumer
		{
			get
			{
				return true;
			}
		}

		public ComponentNetworkSimulation.Structure.LoggingType_t LoggingType
		{
			get
			{
				return loggingType;
			}
		}

		public long ThreadEntered()
		{
			return this.owningConnector.ThreadEntered();
		}

		public void ThreadExited()
		{
			this.owningConnector.ThreadExited();
		}

		#endregion
	}
}

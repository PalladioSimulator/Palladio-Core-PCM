namespace ComponentNetworkSimulation.structure
{
	public class ConnectorPath : TimeConsumer
	{
		//
		// all connectorpaths have at least an internal service as following TimeConsumer
		// 
		/// <TgData>
		/// 	<link_directed>Directed</link_directed>
		/// 	<link_label>nextTimeConsumer</link_label>
		/// 	<link_clientCardinality>1</link_clientCardinality>
		/// </TgData>
		protected TimeConsumer nextTimeConsumer = null;

		//
		//each path belongs to one connector
		//
		/// <TgData>
		/// 	<link_clientCardinality>1</link_clientCardinality>
		/// 	<link_supplierCardinality>0..*</link_supplierCardinality>
		/// </TgData>
		protected AbstractConnector owningConnector = null;

		protected LoggingType loggingType = LoggingType.NO_LOG;

		public ConnectorPath(AbstractConnector owningConnector, TimeConsumer nextTimeConsumer) : 
			this(owningConnector, nextTimeConsumer,LoggingType.NO_LOG)
		{
		}

		public ConnectorPath(AbstractConnector owningConnector, TimeConsumer nextTimeConsumer, LoggingType type) 
		{
			this.nextTimeConsumer = nextTimeConsumer;
			this.owningConnector = owningConnector;
		}

		#region TimeConsumer Member

		public long getUsedTime() 
		{
			return owningConnector.getDelayTime();
		}

		public TimeConsumer getNextTimeConsumer() 
		{
			return this.nextTimeConsumer;
		}

		public bool hasNextTimeConsumer()
		{
			return true;
		}

		public ComponentNetworkSimulation.structure.LoggingType getLoggingType()
		{
			return loggingType;
		}

		#endregion
	}
}

namespace ComponentNetworkSimulation.structure
{
	public class ConnectorPath : TimeUser
	{
		//
		// all connectorpaths have at least an internal service as following timeuser
		// 
		/// <TgData>
		/// 	<link_directed>Directed</link_directed>
		/// 	<link_label>nextTimeUser</link_label>
		/// 	<link_clientCardinality>1</link_clientCardinality>
		/// </TgData>
		protected TimeUser nextTimeUser = null;

		//
		//each path belongs to one connector
		//
		/// <TgData>
		/// 	<link_clientCardinality>1</link_clientCardinality>
		/// 	<link_supplierCardinality>0..*</link_supplierCardinality>
		/// </TgData>
		protected AbstractConnector owningConnector = null;

		protected LoggingType loggingType = LoggingType.NO_LOG;

		public ConnectorPath(AbstractConnector owningConnector, TimeUser nextTimeUser) : 
			this(owningConnector, nextTimeUser,LoggingType.NO_LOG)
		{
		}

		public ConnectorPath(AbstractConnector owningConnector, TimeUser nextTimeUser, LoggingType type) 
		{
			this.nextTimeUser = nextTimeUser;
			this.owningConnector = owningConnector;
		}

		#region TimeUser Member

		public long getUsedTime() 
		{
			return owningConnector.getDelayTime();
		}

		public TimeUser getNextTimeUser() 
		{
			return this.nextTimeUser;
		}

		public bool hasNextTimeUser()
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

namespace ComponentNetworkSimulation.structure
{
	public class ExternalComponentService : TimeUser
	{
		protected System.Object nextService;
		/// <TgData>
		/// 	<link_link>aggregation</link_link>
		/// 	<link_clientCardinality>1</link_clientCardinality>
		/// 	<link_directed>Directed</link_directed>
		/// 	<link_supplierCardinality>1..*</link_supplierCardinality>
		/// </TgData>
		private AbstractConnector connectedWith;

		public long getUsedTime(System.Object thread) 
		{
			return 0;
		}
	}
}

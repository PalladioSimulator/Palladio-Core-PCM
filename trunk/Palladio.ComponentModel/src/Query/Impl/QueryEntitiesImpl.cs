using System.Data;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Query.Impl
{
	/// <summary>
	/// This is class implements all queries to the whole componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/18 09:45:21  joemal
	/// implement query methods
	///
	/// Revision 1.1  2005/04/18 08:50:50  joemal
	/// initial creation
	///
	/// Revision 1.1  2005/04/10 15:33:48  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class QueryEntitiesImpl : BasicQueryImpl,IQueryEntities
	{
		/// <summary>
		/// constructor
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="hashtable">the hashtable</param>
		public QueryEntitiesImpl(ModelDataSet dataset, EntityHashtable hashtable) : base (dataset,hashtable)
		{
		}

		/// <summary>
		/// called to return the entity with given id from the componentmodel
		/// </summary>
		/// <param name="entityID">the id of the entity</param>
		/// <returns>the entity or null if the entity could not be found in the model</returns>
		public IComponentModelEntity getEntity(IIdentifier entityID)
		{
			return this.getModelEntity(entityID);
		}

		/// <summary>
		/// called to return the component with given id from the componentmodel
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <returns>the component or null if the component could not be found in the model</returns>
		public IComponent getComponent(IComponentIdentifier compID)
		{
			return (IComponent) this.getModelEntity(compID);
		}

		/// <summary>
		/// called to return the interface with given id from the componentmodel
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the interface or null if the interface could not be found in the model</returns>
		public IInterface getInterface(IInterfaceIdentifier ifaceID)
		{
			return (IInterface) this.getModelEntity(ifaceID);
		}

		/// <summary>
		/// called to return the connection with given id from the componentmodel
		/// </summary>
		/// <param name="conID">the id of the connection</param>
		/// <returns>the connection or null if the connection could not be found in the model</returns>
		public IConnection getConnection(IConnectionIdentifier conID)
		{
			return (IConnection) this.getModelEntity(conID);
		}

		/// <summary>
		/// called to return the signature with given id from the componentmodel
		/// </summary>
		/// <param name="sigID">the id of the signature</param>
		/// <returns>the signature or null if the signature could not be found in the model</returns>
		public ISignature getSignature(ISignatureIdentifier sigID)
		{
			return (ISignature) this.getModelEntity(sigID);
		}

		/// <summary>
		/// called to return the protocol with given id from the componentmodel
		/// </summary>
		/// <param name="protID">the id of the protocol</param>
		/// <returns>the protocol or null if the protocol could not be found in the model</returns>
		public IProtocol getProtocol(IProtocolIdentifier protID)
		{
			return (IProtocol) this.getModelEntity(protID);
		}

		/// <summary>
		/// called to return the assembly connector between to components 
		/// </summary>
		/// <param name="reqCompID">the id of the requiring component</param>
		/// <param name="reqIfaceID">the id of the requiring components interface</param>
		/// <param name="provCompID">the id of the providing component</param>
		/// <param name="provIfaceID">the id of the providing components interface</param>
		/// <returns></returns>
		public IConnection GetAssemblyConnector(IComponentIdentifier reqCompID, IInterfaceIdentifier reqIfaceID, 
			IComponentIdentifier provCompID, IInterfaceIdentifier provIfaceID)
		{
			ModelDataSet.RolesRow reqRole = QueryRole(reqCompID,reqIfaceID,InterfaceRole.REQUIRES);
			ModelDataSet.RolesRow provRole = QueryRole(provCompID,provIfaceID,InterfaceRole.PROVIDES);

			if (reqRole == null || provRole == null) return null;
            ModelDataSet.ConnectionsRow con;

			string query = "incoming = "+provRole.id+" and outgoing = "+reqRole.id;
			DataRow[] result = Dataset.Connections.Select(query);
			if (result == null) return null;

			return (IConnection) this.getModelEntity(((ModelDataSet.ConnectionsRow)result[0]).guid);
		}

	}
}

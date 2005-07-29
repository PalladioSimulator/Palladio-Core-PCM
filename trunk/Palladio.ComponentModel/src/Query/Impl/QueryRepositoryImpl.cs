using System;
using System.Collections;
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
	/// Revision 1.4  2005/07/29 16:02:57  joemal
	/// now service effect specifications can be added ...
	///
	/// Revision 1.3  2005/06/25 16:54:44  joemal
	/// some more queries are need for the xml serlialization
	///
	/// Revision 1.2  2005/06/17 18:33:10  joemal
	/// changes in the connection tables
	///
	/// Revision 1.1  2005/06/12 17:06:18  joemal
	/// renamed from QueryEntityImpl
	///
	///
	///
	/// </pre>
	/// </remarks>
	internal class QueryRepositoryImpl : BasicQueryImpl,IQueryRepository
	{
		/// <summary>
		/// constructor
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="hashtable">the hashtable</param>
		/// <param name="query">the root of the query tree</param>
		public QueryRepositoryImpl(ModelDataSet dataset, EntityHashtable hashtable,IQuery query) : base (dataset,hashtable,query)
		{
		}

		/// <summary>
		/// called to return the entity with given id from the componentmodel
		/// </summary>
		/// <param name="entityID">the id of the entity</param>
		/// <returns>the entity or null if the entity could not be found in the model</returns>
		public IIdentifiable GetEntity(IIdentifier entityID)
		{
			return this.getModelEntity(entityID);
		}

		/// <summary>
		/// called to return the component with given id from the componentmodel
		/// </summary>
		/// <param name="compID">the id of the component</param>
		/// <returns>the component or null if the component could not be found in the model</returns>
		public IComponent GetComponent(IComponentIdentifier compID)
		{
			return (IComponent) this.getModelEntity(compID);
		}

		/// <summary>
		/// called to return the interface with given id from the componentmodel
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the interface or null if the interface could not be found in the model</returns>
		public IInterface GetInterface(IInterfaceIdentifier ifaceID)
		{
			return (IInterface) this.getModelEntity(ifaceID);
		}

		/// <summary>
		/// called to return the connection with given id from the componentmodel
		/// </summary>
		/// <param name="conID">the id of the connection</param>
		/// <returns>the connection or null if the connection could not be found in the model</returns>
		public IConnection GetConnection(IConnectionIdentifier conID)
		{
			return (IConnection) this.getModelEntity(conID);
		}

		/// <summary>
		/// called to return the signature with given id from the componentmodel
		/// </summary>
		/// <param name="sigID">the id of the signature</param>
		/// <returns>the signature or null if the signature could not be found in the model</returns>
		public ISignature GetSignature(ISignatureIdentifier sigID)
		{
			return (ISignature) this.getModelEntity(sigID);
		}

		/// <summary>
		/// called to return the protocol with given id from the componentmodel
		/// </summary>
		/// <param name="protID">the id of the protocol</param>
		/// <returns>the protocol or null if the protocol could not be found in the model</returns>
		public IProtocol GetProtocol(IProtocolIdentifier protID)
		{
			return (IProtocol) this.getModelEntity(protID);
		}

		/// <summary>
		/// called to return all components of the componentmodel
		/// </summary>
		/// <returns>an array with components</returns>
		public IComponent[] GetComponents()
		{
			ArrayList result = this.AllEntities(typeof(IComponent));
			return (IComponent[]) result.ToArray(typeof(IComponent));
		}

		/// <summary>
		/// called to return all interfaces of the componentmodel
		/// </summary>
		/// <returns>an array with interfaces</returns>
		public IInterface[] GetInterfaces()
		{
			ArrayList result = this.AllEntities(typeof(IInterface));
			return (IInterface[]) result.ToArray(typeof(IInterface));
		}

		/// <summary>
		/// called to return all connections of the componentmodel
		/// </summary>
		/// <returns>an array with connections</returns>
		public IConnection[] GetConnections()
		{
			ArrayList result = this.AllEntities(typeof(IConnection));
			return (IConnection[]) result.ToArray(typeof(IConnection));
		}

		/// <summary>
		/// called to return all signatures of the componentmodel
		/// </summary>
		/// <returns>an array with signatures</returns>
		public ISignature[] GetSignatures()
		{
			ArrayList result = this.AllEntities(typeof(ISignature));
			return (ISignature[]) result.ToArray(typeof(ISignature));
		}

		/// <summary>
		/// called to return all protocols of the componentmodel
		/// </summary>
		/// <returns>an array with protocols</returns>
		public IProtocol[] GetProtocols()
		{
			ArrayList result = this.AllEntities(typeof(IProtocol));
			return (IProtocol[]) result.ToArray(typeof(IProtocol));
		}

		//returns an array with all entities from given type
		private ArrayList AllEntities(Type type)
		{
			ArrayList result = new ArrayList();
			foreach(IIdentifiable entity in this.Entities)
				if (type.IsInstanceOfType(entity)) result.Add(entity);				

			return result;
		}	
	}
}

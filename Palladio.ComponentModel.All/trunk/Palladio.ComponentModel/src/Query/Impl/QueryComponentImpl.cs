using System;
using System.Data;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelDataManagement;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query;
using Palladio.ComponentModel.Query.Impl;
using Palladio.ComponentModel.Query.TypeLevel;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Query.Impl
{
	/// <summary>
	/// This is the implementing class of the components and the basic components query methods.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/07/30 15:43:48  joemal
	/// add basiccomponent queries (for seffs)
	///
	/// Revision 1.1  2005/04/19 16:47:13  joemal
	/// initial creation
	///
	///
	/// </pre>
	/// </remarks>
	internal class QueryComponentImpl : BasicQueryImpl,IQueryComponentTypeLevel
		//todo: add query methods of the other layers
	{
		#region data

		//holds the id of the connection
		protected IComponentIdentifier componentID;

		#endregion

		#region constructor

		/// <summary>
		/// called to create the implementation of the query methods for components.
		/// </summary>
		/// <param name="dataset">the dataset</param>
		/// <param name="entities">the hashtable</param>
		/// <param name="compId">the component</param>
		/// <param name="query">the root implementation of the query tree</param>
		/// <exception cref="EntityNotFoundException">thrown if the component could not be found in the model.</exception>
		public QueryComponentImpl(IComponentIdentifier compId, ModelDataSet dataset, EntityHashtable entities, IQuery query)
			: base(dataset, entities, query)
		{
			this.CheckEntityExists(compId);
			this.componentID = compId;
		}

		#endregion

		#region methods

		/// <summary>
		/// returns the query interface to the interface with given id.
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>the query interface</returns>
		/// <exception cref="EntityNotFoundException">thrown if the interface could not be found in the model.</exception>
		public IQueryInterfaceTypeLevel QueryInterfaceTypeLevel(IInterfaceIdentifier ifaceID)
		{
			return this.Query.QueryTypeLevel.QueryInterface(ifaceID);
		}

		/// <summary>
		/// called to return the list of ids that belong to the components provides interfaces
		/// </summary>
		/// <returns>the list of  ids that belong to the components provides interfaces</returns>
		public IInterfaceIdentifier[] GetProvidesInterfaceIDs()
		{
			return GetInterfaceIDs(InterfaceRole.PROVIDES);
        }

		/// <summary>
		/// called to return the list of ids that belong to the components requires interfaces
		/// </summary>
		/// <returns>the list of  ids that belong to the components requires interfaces</returns>
		public IInterfaceIdentifier[] GetRequiresInterfaceIDs()
		{
			return GetInterfaceIDs(InterfaceRole.REQUIRES);
		}

        //called to return the interfaces of this component that have given role
		private IInterfaceIdentifier[] GetInterfaceIDs(InterfaceRole role)
		{
			string query = "fk_comp = '"+this.componentID.Key+"' and type = "+(byte)role;
			DataRow[] rolesRows = this.Dataset.Roles.Select(query);

			IInterfaceIdentifier[] ifaceIdentifier = new IInterfaceIdentifier[rolesRows.Length];

			for (int a=0;a<rolesRows.Length;a++)
				ifaceIdentifier[a] = ComponentModelIdentifier.CreateInterfaceID(((ModelDataSet.RolesRow)rolesRows[a]).fk_iface);

			return ifaceIdentifier;
		}

		/// <summary>
		/// returns true, if the interface with given id is a provides interface of the component
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>true, if the interface is a provides interfaces of the component</returns>
		public bool IsProvidesInterface(IInterfaceIdentifier ifaceID)
		{
			return (this.QueryRole(this.componentID,ifaceID,InterfaceRole.PROVIDES)!=null);			
		}

		/// <summary>
		/// returns true, if the interface with given id is a requires interface of the component
		/// </summary>
		/// <param name="ifaceID">the id of the interface</param>
		/// <returns>true, if the interface is a requires interfaces of the component</returns>
		public bool IsRequiresInterface(IInterfaceIdentifier ifaceID)
		{
			return (this.QueryRole(this.componentID,ifaceID,InterfaceRole.REQUIRES)!=null);			
		}

		#endregion
	}
}

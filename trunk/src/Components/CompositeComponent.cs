using System;
using System.Collections;
using Palladio.Utils.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.src.TypedCollections;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Components 
{
	/// <summary>
	/// A CompositeComponent consists of a set of internal components which 
	/// are wired using ComponentBindings and mapped to the outside world 
	/// using ComponentMappings.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2004/07/05 09:28:54  sbecker
	/// Added GetComponent
	///
	/// Revision 1.4  2004/07/02 03:00:01  sliver
	/// - absolute path changed to relative path in ndoc project
	/// - ToString Method for Connections
	/// - Methods for getting all incoming and outgoing transitions of a component added
	///
	/// Revision 1.3  2004/06/09 12:36:30  sbecker
	/// Fixed documentation and renamed IExternalSignature
	///
	/// Revision 1.2  2004/06/04 01:53:58  sliver
	/// rework of composite component
	///
	/// Revision 1.7  2004/05/24 15:20:44  sliver
	/// added cvs log
	///
	/// </pre>
	/// </remarks>
	internal class CompositeComponent : AbstractComponent, ICompositeComponent 
	{

		#region Properties

		/// <summary>
		/// List of IComponent objects assembled by the CompositComponent.
		/// </summary>
		public IComponent[] Components 
		{ 
			get { 
				IComponent[] result = new IComponent[componentMap.Values.Count];
				componentMap.Values.CopyTo(result,0);
				return result;
			}
		}

		public IIdentifier[] ComponentIDs
		{
			get 
			{ 
				IIdentifier[] result = new IIdentifier[componentMap.Keys.Count];
				componentMap.Keys.CopyTo(result,0);
				return result;
			}
		}

		/// <summary>
		/// List of CompBinding objects, which represent 
		/// the wiring of the internal components.
		/// </summary>
		public IBinding[] Bindings
		{ 
			get { 
				return (IBinding[])SelectConnections("(ProvComponentID <> '"+this.ID.ToString()+"') AND (ReqComponentID <> '"+this.ID.ToString()+"')").ToArray(typeof(IBinding));
			}
		}

		/// <summary>
		/// List of ICompProvMappings mapping the provides interfaces
		/// of the internal components onto the provides interfaces of the
		/// CompositeComponent.
		/// </summary>
		public IMapping[] ProvidesMappings
		{ 
			get 
			{ 
				return (IMapping[])SelectConnections("ReqComponentID = '"+this.ID.ToString()+"'").ToArray(typeof(IMapping));
			}
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the requires interface of the
		/// CompositeComponent.
		/// </summary>
		public IMapping[] RequiresMappings
		{ 
			get 
			{ 
				return (IMapping[])SelectConnections("ProvComponentID = '"+this.ID.ToString()+"'").ToArray(typeof(IMapping));
			}
		}

		#endregion
		
		#region Methods 

		public void AddComponents(params IComponent[] aComponentArray)
		{
			if (aComponentArray == null)
				throw new NullNotAllowedException();
			foreach(object o in aComponentArray)
				if (o == null)
					throw new NullNotAllowedException();

			foreach(IComponent c in aComponentArray)
				componentMap[c.ID] = c;
		}

		public void DeleteComponents(params IIdentifier[] aCompIDArray)
		{
			if (aCompIDArray == null) return;

			// check precondition
			foreach (IIdentifier id in aCompIDArray)
			{
				if (id == null) continue;
				if (HasIncomingConnections(id))
					throw new ComponentHasIncomingConnectionsException(id);
				if (HasOutgoingConnections(id))
					throw new ComponentHasOutgoingConnectionsException(id);
			}
			// delete data
			foreach (IIdentifier id in aCompIDArray)
			{
				if (id == null) continue;
				componentMap.Remove(id);
			}
		}
		
		public override void DeleteProvidesInterfaces(params IIdentifier[] aProvRoleArray)
		{
			// check preconditions
			if (aProvRoleArray == null) return;

			foreach ( IIdentifier id in aProvRoleArray)
			{
				if ((id != null) && (SelectConnections("(ProvComponentID = '"+this.ID.ToString()+"') AND (ProvRoleID = '" + id.ToString() + "')").Count != 0))
					throw new HasOutgoingMappingException(id);
			}

			// delete data
			base.DeleteProvidesInterfaces(aProvRoleArray);
		}
		
		public override void DeleteRequiresInterfaces(params IIdentifier[] aReqRoleArray)
		{
			// check preconditions
			if (aReqRoleArray == null) return;

			foreach ( IIdentifier id in aReqRoleArray)
			{
				if ((id != null) && (SelectConnections("(ReqComponentID = '"+this.ID.ToString()+"') AND (ReqRoleID = '" + id.ToString() + "')").Count != 0))
					throw new HasIncomingMappingsException(id);
			}

			// delete data
			base.DeleteRequiresInterfaces(aReqRoleArray);
		}

		public void AddProvidesMappings(params IMapping[] aProvMappingArray )
		{
			// check preconditions
			if (aProvMappingArray == null)
				throw new NullNotAllowedException();

			foreach( IMapping provMapping in aProvMappingArray)
			{
				CheckProvidesInterface(provMapping.InnerRole);
				if( !this.HasProvidesInterface(provMapping.OuterRole.RoleID))
					throw new NoInterfaceForRoleException(provMapping.OuterRole.RoleID);
			}

			// insert data
			AddConnections(aProvMappingArray);
		}

		public void DeleteProvidesMappings(params IMapping[] aProvMappingArray)
		{
			DeleteConnections(aProvMappingArray);
		}


		public void AddRequiresMappings(params IMapping[] aReqMappingArray)
		{
			// check preconditions
			if (aReqMappingArray == null)
				throw new NullNotAllowedException();

			foreach( IMapping reqMapping in aReqMappingArray)
			{
				CheckRequiresInterface(reqMapping.InnerRole);
				if (!this.HasRequiresInterface(reqMapping.OuterRole.RoleID))
					throw new NoInterfaceForRoleException(reqMapping.OuterRole.RoleID);
			}
			AddConnections(aReqMappingArray);
		}

		public void DeleteRequiresMappings(params IMapping[] aReqMappingArray)
		{
			DeleteConnections(aReqMappingArray);
		}

		public void AddBindings(params IBinding[] aBindingArray)
		{
			// check preconditions
			if (aBindingArray == null)
				throw new NullNotAllowedException();

			foreach (IBinding binding in aBindingArray)
			{
				CheckProvidesInterface(binding.ProvidingRole);
				CheckRequiresInterface(binding.RequiringRole);
			}

			// add data
			AddConnections(aBindingArray);
		}

		public void DeleteBindings(params IBinding[] aBindingArray)
		{
			DeleteConnections(aBindingArray);
		}
		
		public IConnection[] GetProvidesConnections(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IConnection[]) SelectConnections("(ProvComponentID = '"+aComponentID.ToString()+"')").ToArray(typeof(IConnection));
		}
		
		public IConnection[] GetRequiresConnections(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IConnection[]) SelectConnections("(ReqComponentID = '"+aComponentID.ToString()+"')").ToArray(typeof(IConnection));
		}
		

		public IBinding[] GetProvidesBindings(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IBinding[]) SelectConnections("(ProvComponentID = '"+aComponentID.ToString()+"') AND (ReqComponentID <> '"+this.ID.ToString()+"')").ToArray(typeof(IBinding));
		}

		
		public IMapping[] GetProvidesMappings(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IMapping[]) SelectConnections("(ProvComponentID = '"+aComponentID.ToString()+"') AND (ReqComponentID = '"+this.ID.ToString()+"')").ToArray(typeof(IMapping));
		}

		public IBinding[] GetRequiresBindings(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IBinding[]) SelectConnections("(ReqComponentID = '"+aComponentID.ToString()+"') AND (ProvComponentID <> '"+this.ID.ToString()+"')").ToArray(typeof(IBinding));
		}

		public IMapping[] GetRequiresMappings(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IMapping[]) SelectConnections("(ReqComponentID = '"+aComponentID.ToString()+"') AND (ProvComponentID = '"+this.ID.ToString()+"')").ToArray(typeof(IMapping));
		}


		public IMapping GetProvidesMappingByOuter(IIdentifier anOuterRoleID)
		{
			if (!HasProvidesInterface(anOuterRoleID))
				throw new RoleIDNotFoundException(anOuterRoleID);
			Vector connectionList = SelectConnections("(ReqComponentID = '"+this.ID.ToString()+"') AND (ReqRoleID = '"+ anOuterRoleID.ToString() +"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(this.ID,anOuterRoleID);
			return (IMapping)connectionList[0];
		}

		public IMapping[] GetRequiresMappingsByOuter(IIdentifier anOuterRoleID)
		{
			if (!HasRequiresInterface(anOuterRoleID))
				throw new RoleIDNotFoundException(anOuterRoleID);
			Vector connectionList = SelectConnections("(ProvComponentID = '"+this.ID.ToString()+"') AND (ProvRoleID = '"+ anOuterRoleID.ToString() +"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(this.ID,anOuterRoleID);
			return (IMapping[])connectionList.ToArray(typeof(IMapping));
		}

		public IMapping[] GetProvidesMappingsByInner(IAttachedRole anInnerRole)
		{
			CheckProvidesInterface(anInnerRole);
			Vector connectionList = SelectConnections("(ProvComponentID = '"+anInnerRole.ComponentID.ToString()+"') AND (ProvRoleID = '"+ anInnerRole.RoleID.ToString() +"') AND (ReqComponentID = '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(anInnerRole);
			return (IMapping[])connectionList.ToArray(typeof(IMapping));
		}

		public IMapping[] GetProvidesMappingsByInner(IIdentifier anInnerCompID, IIdentifier anInnerRoleID)
		{
			return GetProvidesMappingsByInner(new DefaultAttachedRole(GetComponent(anInnerCompID),anInnerRoleID));
		}

		public IMapping GetRequiresMappingByInner(IAttachedRole anInnerRole)
		{
			CheckRequiresInterface(anInnerRole);
			Vector connectionList = SelectConnections("(ReqComponentID = '"+anInnerRole.ComponentID.ToString()+"') AND (ReqRoleID = '"+ anInnerRole.RoleID.ToString() +"') AND (ProvComponentID = '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(anInnerRole);
			return (IMapping)connectionList[0];
		}

		public IMapping GetRequiresMappingByInner(IIdentifier anInnerCompID, IIdentifier anInnerRoleID)
		{
			return GetRequiresMappingByInner(new DefaultAttachedRole( GetComponent(anInnerCompID), anInnerRoleID) );
		}

		public IBinding GetBindingByRequires(IAttachedRole aReqRole)
		{
			CheckRequiresInterface(aReqRole);
			Vector connectionList = SelectConnections("(ReqComponentID = '"+aReqRole.ComponentID.ToString()+"') AND (ReqRoleID = '"+ aReqRole.RoleID.ToString() +"') AND (ProvComponentID <> '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(aReqRole);
			return (IBinding)connectionList[0];
		}

		public IBinding GetBindingByRequires(IIdentifier aReqComponentID, IIdentifier aReqRoleID)
		{
			return GetBindingByRequires(new DefaultAttachedRole(GetComponent(aReqComponentID), aReqRoleID) );
		}

		public IBinding[] GetBindingsByProvides(IAttachedRole aProvRole)
		{
			CheckProvidesInterface(aProvRole);
			Vector connectionList = SelectConnections("(ProvComponentID = '"+aProvRole.ComponentID.ToString()+"') AND (ProvRoleID = '"+ aProvRole.RoleID.ToString() +"') AND (ReqComponentID <> '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(aProvRole);
			return (IBinding[])connectionList.ToArray(typeof(IBinding));
		}

		public IBinding[] GetBindingsByProvides(IIdentifier aProvComponentID, IIdentifier aProvRoleID)
		{
			return GetBindingsByProvides(new DefaultAttachedRole(GetComponent(aProvComponentID), aProvRoleID));
		}

		
		public bool HasIncomingConnections(IIdentifier aComponentID)
		{
			if (aComponentID == null)
				return false;
			if (SelectConnections("ProvComponentID = '"+aComponentID.ToString()+"'").Count > 0)
				return true;
			return false;
		}

		public bool HasOutgoingConnections(IIdentifier aComponentID)
		{
			if (aComponentID == null)
				return false;
			if (SelectConnections("ReqComponentID = '"+aComponentID.ToString()+"'").Count > 0)
				return true;
			return false;
		}

		public bool ContainsComponent(IIdentifier aComponentID)
		{
			return (aComponentID != null ? componentMap.Contains(aComponentID) : false);
		}

		/// <summary>
		/// Query the composite component for a certain basic component
		/// </summary>
		/// <param name="aComponentID">ID of the component to search for</param>
		/// <returns>The component with the given ID</returns>
		public IComponent GetComponent(IIdentifier aComponentID)
		{
			if (aComponentID == null) 
				throw new ComponentNotFoundException(aComponentID);
			return (IComponent) componentMap[aComponentID];
		}

		private void CheckProvidesInterface(IAttachedRole aRole)
		{
			if ((!ContainsComponent(aRole.ComponentID)) || (!aRole.Component.HasProvidesInterface(aRole.RoleID)))
				throw new InvalidAttachedRoleException(aRole);
		}

		private void CheckRequiresInterface(IAttachedRole aRole)
		{
			if ((!ContainsComponent(aRole.ComponentID)) || (!aRole.Component.HasRequiresInterface(aRole.RoleID)))
				throw new InvalidAttachedRoleException(aRole);
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new CompositeComponent(this);
		}

		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
		public override bool Equals(object obj)
		{
			if (!(obj is CompositeComponent)) return false;
			if (obj == (object)this) return true;
			if (!base.Equals(obj)) return false;
			CompositeComponent cc = (CompositeComponent)obj;
			return (
				componentMap.Equals(cc.componentMap) &&
				Set.SetwiseEquals( connectionMap.Values, cc.connectionMap.Values )
				);
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return base.GetHashCode ();
		}

		private Vector SelectConnections(string filterExpression)
		{
			Vector result = new Vector();
			ConnectionDataSet.ConnectionTableRow[] rows = (ConnectionDataSet.ConnectionTableRow[]) connectionDataSet.ConnectionTable.Select(filterExpression);
			foreach(ConnectionDataSet.ConnectionTableRow row in rows)
			{
				result.Add(connectionMap[ row.ID ]);
			}
			return result;
		}

		private void AddConnections(params IConnection[] aConnectionArray)
		{
			foreach (IConnection c in aConnectionArray)
			{
				long id = nextID++;
				connectionDataSet.ConnectionTable.AddConnectionTableRow(
					id,
					c.ProvidingRole.ComponentID.ToString(),
					c.ProvidingRole.RoleID.ToString(),
					c.RequiringRole.ComponentID.ToString(),
					c.RequiringRole.RoleID.ToString() );
				connectionMap[id] = c;
			}
		}

		private void DeleteConnections(params IConnection[] aConnectionArray)
		{
			if (aConnectionArray == null) return;
			foreach( IConnection c in aConnectionArray)
			{
				ConnectionDataSet.ConnectionTableRow[] rows = (ConnectionDataSet.ConnectionTableRow[])
					connectionDataSet.ConnectionTable.Select("(ProvComponentID = '"+c.ProvidingRole.ComponentID.ToString()+"') AND ( ProvRoleID = '"+c.ProvidingRole.RoleID.ToString()+"') AND ( ReqComponentID = '"+c.RequiringRole.ComponentID.ToString()+"') AND ( ReqRoleID = '"+c.RequiringRole.RoleID.ToString()+"')");
				if (rows.Length > 0)
				{
					connectionMap.Remove(rows[0].ID);
					connectionDataSet.ConnectionTable.RemoveConnectionTableRow(rows[0]);
				}
			}
		}

		#endregion

		#region Constructors

		public CompositeComponent( IAttributeHash anAttHash, IIdentifier anID ) : base (anAttHash,anID)
		{
			nextID = 0;
			connectionDataSet = new ConnectionDataSet();
			componentMap = new Hashmap();
			connectionMap = new Hashmap();
		}

		public CompositeComponent( CompositeComponent aComponent) : base (aComponent)
		{
			nextID = 0;
			connectionDataSet = new ConnectionDataSet();
			componentMap = new Hashmap(aComponent.componentMap);
			connectionMap = new Hashmap();
			foreach( IConnection c in aComponent.connectionMap.Values )
				AddConnections(c);
		}

		#endregion

		#region Data

		private ConnectionDataSet connectionDataSet;
		private Hashmap componentMap;
		private Hashmap connectionMap;
		private long nextID;
		#endregion
	}
}

using System;
using System.Xml;
using System.Xml.Schema;
using System.Collections;
using Palladio.Utils.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;
using Palladio.ComponentModel.Exceptions;
using Palladio.ComponentModel.TypedCollections;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Components 
{
	/// <summary>
	/// A CompositeComponent consists of a set of internal components which 
	/// are wired using AssemblyConnectors and mapped to the outside world 
	/// using ComponentDelegationConnectors.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 13:52:55  joemal
	/// initial import
	///
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
		/// List of AssemblyConnector objects, which represent 
		/// the wiring of the internal components.
		/// </summary>
		public IAssemblyConnector[] AssemblyConnectors
		{ 
			get { 
				return (IAssemblyConnector[])SelectConnections("(ProvComponentID <> '"+this.ID.ToString()+"') AND (ReqComponentID <> '"+this.ID.ToString()+"')").ToArray(typeof(IAssemblyConnector));
			}
		}

		/// <summary>
		/// List of ICompProvDelegationConnectors mapping the provides interfaces
		/// of the internal components onto the provides interfaces of the
		/// CompositeComponent.
		/// </summary>
		public IDelegationConnector[] ProvidesDelegationConnectors
		{ 
			get 
			{ 
				return (IDelegationConnector[])SelectConnections("ReqComponentID = '"+this.ID.ToString()+"'").ToArray(typeof(IDelegationConnector));
			}
		}

		/// <summary>
		/// List of IReqCompDelegationConnectors mapping the RequireInterfaces
		/// of the internal components onto the requires interface of the
		/// CompositeComponent.
		/// </summary>
		public IDelegationConnector[] RequiresDelegationConnectors
		{ 
			get 
			{ 
				return (IDelegationConnector[])SelectConnections("ProvComponentID = '"+this.ID.ToString()+"'").ToArray(typeof(IDelegationConnector));
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
					throw new HasOutgoingDelegationConnectorException(id);
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
					throw new HasIncomingDelegationConnectorsException(id);
			}

			// delete data
			base.DeleteRequiresInterfaces(aReqRoleArray);
		}

		public void AddProvidesDelegationConnectors(params IDelegationConnector[] aProvDelegationConnectorArray )
		{
			// check preconditions
			if (aProvDelegationConnectorArray == null)
				throw new NullNotAllowedException();

			foreach( IDelegationConnector provDelegationConnector in aProvDelegationConnectorArray)
			{
				CheckProvidesInterface(provDelegationConnector.InnerRole);
				if( !this.HasProvidesInterface(provDelegationConnector.OuterRole.ID))
					throw new NoInterfaceForRoleException(provDelegationConnector.OuterRole.ID);
			}

			// insert data
			AddConnections(aProvDelegationConnectorArray);
		}

		public void DeleteProvidesDelegationConnectors(params IDelegationConnector[] aProvDelegationConnectorArray)
		{
			DeleteConnections(aProvDelegationConnectorArray);
		}


		public void AddRequiresDelegationConnectors(params IDelegationConnector[] aReqDelegationConnectorArray)
		{
			// check preconditions
			if (aReqDelegationConnectorArray == null)
				throw new NullNotAllowedException();

			foreach( IDelegationConnector reqDelegationConnector in aReqDelegationConnectorArray)
			{
				CheckRequiresInterface(reqDelegationConnector.InnerRole);
				if (!this.HasRequiresInterface(reqDelegationConnector.OuterRole.ID))
					throw new NoInterfaceForRoleException(reqDelegationConnector.OuterRole.ID);
			}
			AddConnections(aReqDelegationConnectorArray);
		}

		public void DeleteRequiresDelegationConnectors(params IDelegationConnector[] aReqDelegationConnectorArray)
		{
			DeleteConnections(aReqDelegationConnectorArray);
		}

		public void AddAssemblyConnectors(params IAssemblyConnector[] aAssemblyConnectorArray)
		{
			// check preconditions
			if (aAssemblyConnectorArray == null)
				throw new NullNotAllowedException();

			foreach (IAssemblyConnector assemblyConnector in aAssemblyConnectorArray)
			{
				CheckProvidesInterface(assemblyConnector.ProvidingRole);
				CheckRequiresInterface(assemblyConnector.RequiringRole);
			}

			// add data
			AddConnections( aAssemblyConnectorArray);
		}

		public void DeleteAssemblyConnectors(params IAssemblyConnector[] aAssemblyConnectorArray)
		{
			DeleteConnections(aAssemblyConnectorArray);
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
		

		public IAssemblyConnector[] GetProvidesAssemblyConnectors(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IAssemblyConnector[]) SelectConnections("(ProvComponentID = '"+aComponentID.ToString()+"') AND (ReqComponentID <> '"+this.ID.ToString()+"')").ToArray(typeof(IAssemblyConnector));
		}

		
		public IDelegationConnector[] GetProvidesDelegationConnectors(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IDelegationConnector[]) SelectConnections("(ProvComponentID = '"+aComponentID.ToString()+"') AND (ReqComponentID = '"+this.ID.ToString()+"')").ToArray(typeof(IDelegationConnector));
		}

		public IAssemblyConnector[] GetRequiresAssemblyConnectors(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IAssemblyConnector[]) SelectConnections("(ReqComponentID = '"+aComponentID.ToString()+"') AND (ProvComponentID <> '"+this.ID.ToString()+"')").ToArray(typeof(IAssemblyConnector));
		}

		public IDelegationConnector[] GetRequiresDelegationConnectors(IIdentifier aComponentID)
		{
			if (!ContainsComponent(aComponentID))
				throw new ComponentNotFoundException(aComponentID);
			return (IDelegationConnector[]) SelectConnections("(ReqComponentID = '"+aComponentID.ToString()+"') AND (ProvComponentID = '"+this.ID.ToString()+"')").ToArray(typeof(IDelegationConnector));
		}


		public IDelegationConnector GetProvidesDelegationConnectorByOuter(IIdentifier anOuterRoleID)
		{
			if (!HasProvidesInterface(anOuterRoleID))
				throw new RoleIDNotFoundException(anOuterRoleID);
			Vector connectionList = SelectConnections("(ReqComponentID = '"+this.ID.ToString()+"') AND (ReqRoleID = '"+ anOuterRoleID.ToString() +"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(this.ID,anOuterRoleID);
			return (IDelegationConnector)connectionList[0];
		}

		public IDelegationConnector[] GetRequiresDelegationConnectorsByOuter(IIdentifier anOuterRoleID)
		{
			if (!HasRequiresInterface(anOuterRoleID))
				throw new RoleIDNotFoundException(anOuterRoleID);
			Vector connectionList = SelectConnections("(ProvComponentID = '"+this.ID.ToString()+"') AND (ProvRoleID = '"+ anOuterRoleID.ToString() +"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(this.ID,anOuterRoleID);
			return (IDelegationConnector[])connectionList.ToArray(typeof(IDelegationConnector));
		}

		public IDelegationConnector[] GetProvidesDelegationConnectorsByInner(IRole anInnerRole)
		{
			CheckProvidesInterface(anInnerRole);
			Vector connectionList = SelectConnections("(ProvComponentID = '"+anInnerRole.Component.ID.ToString()+"') AND (ProvRoleID = '"+ anInnerRole.ID.ToString() +"') AND (ReqComponentID = '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(anInnerRole);
			return (IDelegationConnector[])connectionList.ToArray(typeof(IDelegationConnector));
		}

		public IDelegationConnector[] GetProvidesDelegationConnectorsByInner(IIdentifier anInnerCompID, IIdentifier anInnerRoleID)
		{
			return GetProvidesDelegationConnectorsByInner( GetComponent(anInnerCompID).GetRole(anInnerRoleID) );
		}

		public IDelegationConnector GetRequiresDelegationConnectorByInner(IRole anInnerRole)
		{
			CheckRequiresInterface(anInnerRole);
			Vector connectionList = SelectConnections("(ReqComponentID = '"+anInnerRole.Component.ID.ToString()+"') AND (ReqRoleID = '"+ anInnerRole.ID.ToString() +"') AND (ProvComponentID = '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(anInnerRole);
			return (IDelegationConnector)connectionList[0];
		}

		public IDelegationConnector GetRequiresDelegationConnectorByInner(IIdentifier anInnerCompID, IIdentifier anInnerRoleID)
		{
			return GetRequiresDelegationConnectorByInner( GetComponent(anInnerCompID).GetRole(anInnerRoleID) );
		}

		public IAssemblyConnector GetAssemblyConnectorByRequires(IRole aReqRole)
		{
			CheckRequiresInterface(aReqRole);
			Vector connectionList = SelectConnections("(ReqComponentID = '"+aReqRole.Component.ID.ToString()+"') AND (ReqRoleID = '"+ aReqRole.ID.ToString() +"') AND (ProvComponentID <> '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(aReqRole);
			return (IAssemblyConnector)connectionList[0];
		}

		public IAssemblyConnector GetAssemblyConnectorByRequires(IIdentifier aReqComponentID, IIdentifier aReqRoleID)
		{
			return GetAssemblyConnectorByRequires( GetComponent(aReqComponentID).GetRole(aReqRoleID) );
		}

		public IAssemblyConnector[] GetAssemblyConnectorsByProvides(IRole aProvRole)
		{
			CheckProvidesInterface(aProvRole);
			Vector connectionList = SelectConnections("(ProvComponentID = '"+aProvRole.Component.ID.ToString()+"') AND (ProvRoleID = '"+ aProvRole.ID.ToString() +"') AND (ReqComponentID <> '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(aProvRole);
			return (IAssemblyConnector[])connectionList.ToArray(typeof(IAssemblyConnector));
		}

		public IAssemblyConnector[] GetAssemblyConnectorsByProvides(IIdentifier aProvComponentID, IIdentifier aProvRoleID)
		{
			return GetAssemblyConnectorsByProvides( GetComponent(aProvComponentID).GetRole(aProvRoleID) );
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
			return (aComponentID != null ? componentMap.ContainsKey(aComponentID) : false);
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

		private void CheckProvidesInterface(IRole aRole)
		{
			if ((!ContainsComponent(aRole.Component.ID)) || (!aRole.Component.HasProvidesInterface(aRole.ID)))
				throw new InvalidRoleException(aRole);
		}

		private void CheckRequiresInterface(IRole aRole)
		{
			if ((!ContainsComponent(aRole.Component.ID)) || (!aRole.Component.HasRequiresInterface(aRole.ID)))
				throw new InvalidRoleException(aRole);
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
					c.ProvidingRole.Component.ID.ToString(),
					c.ProvidingRole.ID.ToString(),
					c.RequiringRole.Component.ID.ToString(),
					c.RequiringRole.ID.ToString() );
				connectionMap[id] = c;
			}
		}

		private void DeleteConnections(params IConnection[] aConnectionArray)
		{
			if (aConnectionArray == null) return;
			foreach( IConnection c in aConnectionArray)
			{
				ConnectionDataSet.ConnectionTableRow[] rows = (ConnectionDataSet.ConnectionTableRow[])
					connectionDataSet.ConnectionTable.Select("(ProvComponentID = '"+c.ProvidingRole.Component.ID.ToString()+"') AND ( ProvRoleID = '"+c.ProvidingRole.ID.ToString()+"') AND ( ReqComponentID = '"+c.RequiringRole.Component.ID.ToString()+"') AND ( ReqRoleID = '"+c.RequiringRole.ID.ToString()+"')");
				if (rows.Length > 0)
				{
					connectionMap.Remove(rows[0].ID);
					connectionDataSet.ConnectionTable.RemoveConnectionTableRow(rows[0]);
				}
			}
		}

		/// <summary>
		/// The Serialize method is used to write the structure of an object to a XML stream.
		/// </summary>
		/// <param name="writer">The writer which is used to serialize the component.</param>
		public override void Serialize(XmlTextWriter writer) 
		{
			// add subcomponent links
			foreach(IIdentifier id in componentMap.Keys) 
			{
				writer.WriteStartElement("Component","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",((IComponent)componentMap[id]).ID.ToString());
				writer.WriteEndElement();
			}
			// add interface links
			Hashtable interfaces = new Hashtable();
			foreach(IIdentifier id in providesMap.Keys)
				interfaces[id] = ((IRole)providesMap[id]).Interface;
			foreach(IIdentifier id in requiresMap.Keys)
				interfaces[id] = ((IRole)requiresMap[id]).Interface;
			foreach(IInterfaceModel iface in interfaces.Values)
			{
				writer.WriteStartElement("Interface","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",iface.ID.ToString());
				writer.WriteEndElement();
			}

			//add provides-interfaces
			foreach(IIdentifier c in providesMap.Keys)
			{
				writer.WriteStartElement("ProvidingRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("name",((IRole)providesMap[c]).Name);
				writer.WriteAttributeString("id",((IRole)providesMap[c]).ID.ToString());
				writer.WriteAttributeString("interface",((IRole)providesMap[c]).Interface.ID.ToString());
				writer.WriteEndElement();
			}
			//add requires-interfaces
			foreach(IIdentifier c in requiresMap.Keys)
			{
				writer.WriteStartElement("RequiringRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("name",((IRole)requiresMap[c]).Name);
				writer.WriteAttributeString("id",((IRole)requiresMap[c]).ID.ToString());
				writer.WriteAttributeString("interface",((IRole)requiresMap[c]).Interface.ID.ToString());
				writer.WriteEndElement();
			}

			// add connections
			foreach(IConnection connection in this.connectionMap.Values)
			{
				connection.Serialize(writer);
			}
		}

		public override void Deserialize(System.Xml.XmlNode element) 
		{
			System.Xml.XmlNode node = element.FirstChild;

			while (node != null)
			{
				switch (node.Name) 
				{
					case "ProvidingRole":
						FirstClassEntity iface = ModelPersistencyService.Instance.GetEntity(
							IdentifiableFactory.CreateGUID(node.Attributes["interface"].Value) as GloballyUniqueIdentifier );
						if (!(iface != null && iface is IInterfaceModel))
							throw new DeserializationException("Interface "+node.Attributes["interface"].Value+" not found.");
						this.AddProvidesInterface(iface as IInterfaceModel);
						IRole newRole = this.GetProvidesRoleByInterfaceID(iface.ID);
						newRole.Name = node.Attributes["name"].Value;
						break;
					case "RequiringRole":
						iface = ModelPersistencyService.Instance.GetEntity(
							IdentifiableFactory.CreateGUID(node.Attributes["interface"].Value) as GloballyUniqueIdentifier );
						if (!(iface != null && iface is IInterfaceModel))
							throw new DeserializationException("Interface "+node.Attributes["interface"].Value+" not found.");
						this.AddRequiresInterface(iface as IInterfaceModel);
						newRole = this.GetRequiresRoleByInterfaceID(iface.ID);
						newRole.Name = node.Attributes["name"].Value;
						break;
					case "Component":
						FirstClassEntity component = ModelPersistencyService.Instance.GetEntity(
							IdentifiableFactory.CreateGUID(node.Attributes["guid"].Value) as GloballyUniqueIdentifier );
						this.AddComponents(component as IComponent);
						break;
					case "Binding":
						IAssemblyConnector assemblyConnector = new Connections.DefaultAssemblyConnector(new AttributeHash(),null,null);
						assemblyConnector.Deserialize(node);
						this.AddAssemblyConnectors(assemblyConnector);
						break;
					case "ProvidesMapping":
						IDelegationConnector delegationCon = new Connections.DefaultDelegationConnector(new AttributeHash(),null,null,DelegationTypeEnum.PROVIDES_DELEGATION);
						delegationCon.Deserialize(node);
						this.AddProvidesDelegationConnectors(delegationCon);
						break;
					case "RequiresMapping":
						delegationCon = new Connections.DefaultDelegationConnector(new AttributeHash(),null,null,DelegationTypeEnum.REQUIRES_DELEGATION);
						delegationCon.Deserialize(node);
						this.AddRequiresDelegationConnectors(delegationCon);
						break;
				}
				node = node.NextSibling;
			}
		}

		private IIdentifier NewID(string aID)
		{
			return IdentifiableFactory.CreateStringID(aID);
		}
		#endregion

		#region Constructors

		public CompositeComponent( AttributeHash anAttHash, string name, GloballyUniqueIdentifier anID ) : base (anAttHash,name,anID)
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

		ConnectionDataSet connectionDataSet;
		private Hashmap componentMap;
		private Hashmap connectionMap;
		private long nextID;

		#endregion

	}
}

using System;
using System.Xml;
using System.Xml.Schema;
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
	/// Revision 1.6.2.5  2004/12/02 23:39:48  uffi
	/// IAttributeHash replaced by AttributeHash,
	/// added attribute serialization
	///
	/// Revision 1.6.2.4  2004/11/26 19:37:21  uffi
	/// *** empty log message ***
	///
	/// Revision 1.6.2.3  2004/11/26 19:35:39  uffi
	/// serialization schema changed.
	/// connection serialization/deserialization added
	///
	/// Revision 1.6.2.2  2004/11/26 16:23:44  uffi
	/// serialization schema changed.
	/// interfaces added to structure-node.
	/// sef-serialization/deserialization
	///
	/// Revision 1.6.2.1  2004/11/16 13:37:47  uffi
	/// Initial commit of the 2.0 version of the component model. BETA!!! See the techreport (to be updated) for details.
	/// Documentation needs fixing. Some unittests fail.
	///
	/// Revision 1.6  2004/09/02 12:50:06  uffi
	/// Added XML Serialization and Deserialization functionality
	///
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
				if( !this.HasProvidesInterface(provMapping.OuterRole.ID))
					throw new NoInterfaceForRoleException(provMapping.OuterRole.ID);
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
				if (!this.HasRequiresInterface(reqMapping.OuterRole.ID))
					throw new NoInterfaceForRoleException(reqMapping.OuterRole.ID);
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

		public IMapping[] GetProvidesMappingsByInner(IRole anInnerRole)
		{
			CheckProvidesInterface(anInnerRole);
			Vector connectionList = SelectConnections("(ProvComponentID = '"+anInnerRole.Component.ID.ToString()+"') AND (ProvRoleID = '"+ anInnerRole.ID.ToString() +"') AND (ReqComponentID = '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(anInnerRole);
			return (IMapping[])connectionList.ToArray(typeof(IMapping));
		}

		public IMapping[] GetProvidesMappingsByInner(IIdentifier anInnerCompID, IIdentifier anInnerRoleID)
		{
			return GetProvidesMappingsByInner( GetComponent(anInnerCompID).GetRole(anInnerRoleID) );
		}

		public IMapping GetRequiresMappingByInner(IRole anInnerRole)
		{
			CheckRequiresInterface(anInnerRole);
			Vector connectionList = SelectConnections("(ReqComponentID = '"+anInnerRole.Component.ID.ToString()+"') AND (ReqRoleID = '"+ anInnerRole.ID.ToString() +"') AND (ProvComponentID = '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(anInnerRole);
			return (IMapping)connectionList[0];
		}

		public IMapping GetRequiresMappingByInner(IIdentifier anInnerCompID, IIdentifier anInnerRoleID)
		{
			return GetRequiresMappingByInner( GetComponent(anInnerCompID).GetRole(anInnerRoleID) );
		}

		public IBinding GetBindingByRequires(IRole aReqRole)
		{
			CheckRequiresInterface(aReqRole);
			Vector connectionList = SelectConnections("(ReqComponentID = '"+aReqRole.Component.ID.ToString()+"') AND (ReqRoleID = '"+ aReqRole.ID.ToString() +"') AND (ProvComponentID <> '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(aReqRole);
			return (IBinding)connectionList[0];
		}

		public IBinding GetBindingByRequires(IIdentifier aReqComponentID, IIdentifier aReqRoleID)
		{
			return GetBindingByRequires( GetComponent(aReqComponentID).GetRole(aReqRoleID) );
		}

		public IBinding[] GetBindingsByProvides(IRole aProvRole)
		{
			CheckProvidesInterface(aProvRole);
			Vector connectionList = SelectConnections("(ProvComponentID = '"+aProvRole.Component.ID.ToString()+"') AND (ProvRoleID = '"+ aProvRole.ID.ToString() +"') AND (ReqComponentID <> '"+this.ID.ToString()+"')");
			if (connectionList.Count == 0)
				throw new ConnectionNotFoundException(aProvRole);
			return (IBinding[])connectionList.ToArray(typeof(IBinding));
		}

		public IBinding[] GetBindingsByProvides(IIdentifier aProvComponentID, IIdentifier aProvRoleID)
		{
			return GetBindingsByProvides( GetComponent(aProvComponentID).GetRole(aProvRoleID) );
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
						IBinding binding = new Connections.DefaultBinding(new AttributeHash(),null,null);
						binding.Deserialize(node);
						this.AddBindings(binding);
						break;
					case "ProvidesMapping":
						IMapping mapping = new Connections.DefaultMapping(new AttributeHash(),null,null,MappingTypeEnum.PROVIDES_MAPPING);
						mapping.Deserialize(node);
						this.AddProvidesMappings(mapping);
						break;
					case "RequiresMapping":
						mapping = new Connections.DefaultMapping(new AttributeHash(),null,null,MappingTypeEnum.REQUIRES_MAPPING);
						mapping.Deserialize(node);
						this.AddRequiresMappings(mapping);
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

using System;
using System.Collections;
using Palladio.Utils.Collections;
using Palladio.Attributes;
using ReflectionBasedVisitor;
using Palladio.ComponentModel.Collections;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel.Components 
{
	/// <summary>
	/// A CompositeComponent consists of a set of internal components which 
	/// are wired using ComponentBindings and mapped to the outside world 
	/// using ComponentMappings.
	/// </summary>
	internal class CompositeComponent : AbstractComponent, ICompositeComponent 
	{

		#region Properties

		/// <summary>
		/// List of IComponent objects assembled by the CompositComponent.
		/// </summary>
		public IComponent[] Components 
		{ 
			get { return (IComponent[]) componentList.ToArray(typeof(IComponent)); }
		}

		/// <summary>
		/// List of CompBinding objects, which represent 
		/// the wiring of the internal components.
		/// </summary>
		public IBinding[] Bindings
		{ 
			get { return (IBinding[]) bindingByProvTable.Get(); }
		}

		/// <summary>
		/// List of ICompProvMappings mapping the ProvidesInterfaces
		/// of the internal components onto the ProvidesInterfaces of the
		/// CompositeComponent.
		/// </summary>
		public IProvidesMapping[] ProvidesMappings
		{ 
			get { return (IProvidesMapping[]) provMapByInnerTable.Get(); }
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterfaces of the
		/// CompositeComponent.
		/// </summary>
		public IRequiresMapping[] RequiresMappings
		{ 
			get { return (IRequiresMapping[]) reqMapByInnerTable.Get(); }
		}

		#endregion
		
		#region Methods 

		public void AddComponents(params IComponent[] aCompArray)
		{
			componentList.AddRange(aCompArray);
		}

		public void DeleteComponents(params IComponent[] aCompArray)
		{
			foreach (IComponent cmp in aCompArray)
			{
				if (HasIncomingConnections(cmp))
					throw new ComponentHasIncomingConnectionsException(cmp);
				if (HasOutgoingConnections(cmp))
					throw new ComponentHasOutgoingConnectionsException(cmp);
				componentList.Remove(cmp);
			}
		}
		

		public void AddProvidesInterfaces(IProvidesMapping aProvMapping, params ISignatureList[] aProvIfaceArray)
		{
			CheckConsistency(aProvMapping,aProvIfaceArray);
			
			// insert data
			foreach ( ISignatureList prov in aProvIfaceArray )
			{
				providesTable.Add(prov.RoleID, prov);
			}
			provMapByInnerTable.Add(aProvMapping, aProvMapping.InnerInterface);
			foreach( string outerRoleID in aProvMapping.OuterRoleIDs)
			{
				provMapByOuterTable.Add(outerRoleID,aProvMapping);
			}
		}

		public void AddRequiresInterface(IRequiresMapping aReqMapping, ISignatureList aReqInterface)
		{
			CheckConsistency(aReqMapping, aReqInterface);

			// insert data
			requiresTable.Add(aReqInterface.RoleID, aReqInterface);
			reqMapByOuterTable.Add(aReqMapping.OuterRoleID,aReqMapping);
			reqMapByInnerTable.Add(aReqMapping,aReqMapping.InnerInterfaces);
		}

		public void DeleteProvidesInterfaces(IProvidesMapping aProvMapping, params ISignatureList[] aProvIfaceArray)
		{
		  CheckConsistency(aProvMapping,aProvIfaceArray);
			foreach ( ISignatureList prov in aProvIfaceArray )
			{
				providesTable.Remove(prov.RoleID);
			}
			foreach( string roleID in aProvMapping.OuterRoleIDs )
			{
				provMapByOuterTable.Remove(roleID);
			}
			provMapByInnerTable.Add(aProvMapping, aProvMapping.InnerInterface);
		}

		public void DeleteRequiresInterface(IRequiresMapping aReqMapping, ISignatureList aReqInterface)
		{
			CheckConsistency(aReqMapping, aReqInterface);

			requiresTable.Remove(aReqInterface.RoleID);
			reqMapByOuterTable.Remove(aReqMapping.OuterRoleID);
			reqMapByInnerTable.Delete(aReqMapping.InnerInterfaces);
		}


		public void AddBindings(params IBinding[] aBindingArray)
		{
			foreach (IBinding binding in aBindingArray)
			{
				CheckInterface(binding.ProvidesInterface);
				foreach (AttachedInterface iface in binding.RequiresInterfaces)
				{
					CheckInterface(iface);
				}
			}

			foreach (IBinding binding in aBindingArray)
			{
				bindingByProvTable.Add(binding, binding.ProvidesInterface);
				bindingByReqTable.Add(binding, binding.RequiresInterfaces );
			}
		}

		public void DeleteBindings(params IBinding[] aBindingArray)
		{
			foreach (IBinding binding in aBindingArray)
			{
				bindingByProvTable.Delete(binding.ProvidesInterface);
				bindingByReqTable.Delete(binding.RequiresInterfaces);
			}
		}
		

		public IBinding[] GetOutgoingBindings(IComponent aComponent)
		{
			return (IBinding[])bindingByReqTable.Get(aComponent);
		}

		public IBinding[] GetIncomingBindings(IComponent aComponent)
		{
			return (IBinding[])bindingByProvTable.Get(aComponent);
		}

		
		public IProvidesMapping[] GetIncomingMappings(IComponent aComponent)
		{
			return (IProvidesMapping[]) provMapByInnerTable.Get(aComponent);
		}

		public IRequiresMapping[] GetOutgoingMappings(IComponent aComponent)
		{
			return (IRequiresMapping[]) reqMapByInnerTable.Get(aComponent);
		}


		public IProvidesMapping GetProvidesMappingByOuter(string aProvRoleID)
		{
			return (IProvidesMapping) provMapByOuterTable[aProvRoleID];
		}

		public IBinding GetBindingByRequires(AttachedInterface aReqInterface)
		{
			return (IBinding) bindingByReqTable.Get(aReqInterface);
		}

		public IRequiresMapping GetRequiresMappingByInner(AttachedInterface aReqInterface)
		{
			return (IRequiresMapping) reqMapByInnerTable.Get(aReqInterface);
		}

		public IRequiresMapping GetRequiresMappingByOuter(string aReqRoleID)
		{
			return (IRequiresMapping) reqMapByOuterTable[aReqRoleID];
		}

		public IBinding GetBindingByProvides(AttachedInterface aProvInterface)
		{
			return (IBinding) bindingByProvTable.Get(aProvInterface);
		}

		public IProvidesMapping GetProvidesMappingByInner(AttachedInterface aProvInterface)
		{
			return (IProvidesMapping) provMapByInnerTable.Get(aProvInterface);
		}


		bool HasIncomingConnections(IComponent aComponent)
		{
			if (provMapByInnerTable.Get(aComponent).Length > 0)
				return true;
			if (bindingByProvTable.Get(aComponent).Length > 0)
				return true;
			return false;
		}

		bool HasOutgoingConnections(IComponent aComponent)
		{
			if ( reqMapByInnerTable.Get(aComponent).Length > 0 )
				return true;
			if ( bindingByReqTable.Get(aComponent).Length > 0 )
				return true;
			return false;
		}

		public bool HasComponent(IComponent aComponent)
		{
			return componentList.Contains(aComponent);
		}


		private void CheckConsistency(IProvidesMapping aProvMapping, params ISignatureList[] aProvIfaceArray)
		{
			// check preconditions
			// the mapped component exists
			CheckInterface(aProvMapping.InnerInterface);

			// each outer provides interface is also in the mapping
			Hashtable provTable = new Hashtable();
			foreach ( ISignatureList prov in aProvIfaceArray)
			{
				if ( Array.IndexOf( aProvMapping.OuterRoleIDs, prov.RoleID ) < 0 )
					throw new ProvidesInterfaceNotInMappingException(prov.RoleID, aProvMapping);
				provTable.Add(prov.RoleID,prov);
			}

			// for each outer role in the mapping exists an outer interface
			foreach ( string roleID in aProvMapping.OuterRoleIDs )
			{
				if ( !provTable.ContainsKey(roleID) )
					throw new NoInterfaceForRoleException(roleID);
			}
		}

		public void CheckConsistency(IRequiresMapping aReqMapping, ISignatureList aReqInterface)
		{
			// check preconditions
			if (aReqMapping.OuterRoleID != aReqInterface.RoleID)
				throw new	RoleIDNotInterfaceRoleIDException ( aReqMapping.OuterRoleID, aReqInterface );

			foreach (AttachedInterface iface in aReqMapping.InnerInterfaces)
			{
				CheckInterface(iface);
			}
		}

		public void CheckInterface(AttachedInterface anInterface)
		{
			if (!HasComponent(anInterface.Component))
				throw new ComponentNotFoundException(anInterface.Component);
			if (!anInterface.Component.HasRequiresInterface(anInterface.RoleID))
				throw new InvalidAttachedInterfaceException(anInterface);
		}


		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor)
		{
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return null;
		}

		#endregion

		#region Constructors

		public CompositeComponent( IAttributeHash anAttHash ) : base (anAttHash)
		{
		}

		public CompositeComponent( CompositeComponent aComponent) : base (aComponent)
		{
			componentList = new ArrayList(aComponent.componentList);
			provMapByOuterTable = new Hashtable(aComponent.provMapByOuterTable);
			reqMapByOuterTable = new Hashtable(aComponent.reqMapByOuterTable);
			provMapByInnerTable = (ConnectionHash) aComponent.provMapByInnerTable.Clone();
			reqMapByInnerTable = (ConnectionHash) aComponent.reqMapByInnerTable.Clone();
			bindingByProvTable = (ConnectionHash) aComponent.bindingByProvTable.Clone();
			bindingByReqTable = (ConnectionHash) aComponent.bindingByReqTable.Clone();
		}

		#endregion

		#region Data

		/// <summary>
		/// key string roleID
		/// value IProvidesmapping
		/// </summary>
		private Hashtable provMapByOuterTable;
		/// <summary>
		/// key string roleID
		/// value IRequiresMapping
		/// </summary>
		private Hashtable reqMapByOuterTable;

		private ConnectionHash provMapByInnerTable;
		private ConnectionHash reqMapByInnerTable;
		private ConnectionHash bindingByProvTable;
		private ConnectionHash bindingByReqTable;
		private ArrayList componentList;
		#endregion
	}
}

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
			get { return (IBinding[]) bindingByProvMCH.Get(); }
		}

		/// <summary>
		/// List of ICompProvMappings mapping the ProvidesInterfaces
		/// of the internal components onto the ProvidesInterfaces of the
		/// CompositeComponent.
		/// </summary>
		public IMapping[] ProvidesMappings
		{ 
			get { return (IMapping[]) provMapByInnerMCH.Get(); }
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterface of the
		/// CompositeComponent.
		/// </summary>
		public IMapping[] RequiresMappings
		{ 
			get { return (IMapping[]) reqMapByInnerCH.Get(); }
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
		

		public void AddProvidesInterface(ISignatureList aProvInterface, IMapping aProvMapping )
		{
			CheckConsistency(aProvInterface, aProvMapping);
			
			providesTable.Add(aProvInterface.RoleID, aProvInterface);
			provMapByInnerMCH.Add(aProvMapping.InnerInterface, aProvMapping);
			provMapByOuterHT.Add(aProvMapping.OuterRoleID, aProvMapping);
		}

		public void AddRequiresInterface(ISignatureList aReqInterface, IMapping aReqMapping)
		{
			CheckConsistency(aReqInterface, aReqMapping);

			requiresTable.Add(aReqInterface.RoleID, aReqInterface);
			reqMapByInnerCH.Add(aReqMapping.InnerInterface, aReqMapping);

			Set mapSet = (Set)reqMapByOuterMHT[aReqMapping.OuterRoleID];
			if (mapSet == null)
				mapSet = new Set();
			mapSet.Add(aReqMapping);
			reqMapByOuterMHT[aReqMapping.OuterRoleID] = mapSet;
		}

		public void DeleteProvidesInterfaces(ISignatureList aProvInterface, IMapping aProvMapping)
		{
		  CheckConsistency(aProvInterface, aProvMapping);
			
			providesTable.Remove(aProvInterface.RoleID);
			provMapByOuterHT.Remove(aProvMapping.OuterRoleID);
			provMapByInnerMCH.Delete(aProvMapping.InnerInterface,aProvMapping);
		}

		public void DeleteRequiresInterface(ISignatureList aReqInterface, IMapping aReqMapping)
		{
			CheckConsistency(aReqInterface, aReqMapping);

			requiresTable.Remove(aReqInterface.RoleID);
			reqMapByOuterMHT.Remove(aReqMapping.OuterRoleID);
			reqMapByInnerCH.Delete(aReqMapping.InnerInterface);
		}


		public void AddBindings(params IBinding[] aBindingArray)
		{
			foreach (IBinding binding in aBindingArray)
			{
				CheckInterface(binding.ProvidesInterface);
				CheckInterface(binding.RequiresInterface);
			}

			foreach (IBinding binding in aBindingArray)
			{
				bindingByProvMCH.Add(binding.ProvidesInterface, binding);
				bindingByReqCH.Add(binding.RequiresInterface, binding );
			}
		}

		public void DeleteBindings(params IBinding[] aBindingArray)
		{
			foreach (IBinding binding in aBindingArray)
			{
				bindingByProvMCH.Delete(binding.ProvidesInterface,binding);
				bindingByReqCH.Delete(binding.RequiresInterface);
			}
		}
		

		public IBinding[] GetOutgoingBindings(IComponent aComponent)
		{
			return (IBinding[])bindingByReqCH.Get(aComponent);
		}

		public IBinding[] GetIncomingBindings(IComponent aComponent)
		{
			return (IBinding[])bindingByProvMCH.Get(aComponent);
		}

		
		public IMapping[] GetIncomingMappings(IComponent aComponent)
		{
			return (IMapping[]) provMapByInnerMCH.Get(aComponent);
		}

		public IMapping[] GetOutgoingMappings(IComponent aComponent)
		{
			return (IMapping[]) reqMapByInnerCH.Get(aComponent);
		}


		public IMapping GetProvidesMappingByOuter(string aProvRoleID)
		{
			return (IMapping) provMapByOuterHT[aProvRoleID];
		}

		public IBinding GetBindingByRequires(AttachedInterface aReqInterface)
		{
			return (IBinding) bindingByReqCH.Get(aReqInterface);
		}

		public IMapping GetRequiresMappingByInner(AttachedInterface aReqInterface)
		{
			return (IMapping) reqMapByInnerCH.Get(aReqInterface);
		}

		public IMapping[] GetRequiresMappingsByOuter(string aReqRoleID)
		{
			Set mapSet = (Set) reqMapByOuterMHT[aReqRoleID];
			if (mapSet != null)
				return (IMapping[]) mapSet.ToArray(typeof(IMapping));
			else
				return new IMapping[0] ;
		}

		public IBinding[] GetBindingsByProvides(AttachedInterface aProvInterface)
		{
			return (IBinding[]) bindingByProvMCH.Get(aProvInterface);
		}

		public IMapping[] GetProvidesMappingByInner(AttachedInterface aProvInterface)
		{
			return (IMapping[]) provMapByInnerMCH.Get(aProvInterface);
		}


		public bool HasIncomingConnections(IComponent aComponent)
		{
			if (provMapByInnerMCH.Get(aComponent).Length > 0)
				return true;
			if (bindingByProvMCH.Get(aComponent).Length > 0)
				return true;
			return false;
		}

		public bool HasOutgoingConnections(IComponent aComponent)
		{
			if ( reqMapByInnerCH.Get(aComponent).Length > 0 )
				return true;
			if ( bindingByReqCH.Get(aComponent).Length > 0 )
				return true;
			return false;
		}

		public bool HasComponent(IComponent aComponent)
		{
			return componentList.Contains(aComponent);
		}


		private void CheckConsistency(ISignatureList aProvInterface, IMapping aProvMapping)
		{
			// check preconditions
			// the mapped component exists
			CheckInterface(aProvMapping.InnerInterface );

			// the outer provides interface is also in the mapping
			if ( aProvInterface.RoleID != aProvMapping.OuterRoleID )
				throw new	RoleIDNotInterfaceRoleIDException ( aProvMapping.OuterRoleID, aProvInterface );
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
			provMapByOuterHT = new Hashtable(aComponent.provMapByOuterHT);
			reqMapByOuterMHT = new Hashtable(aComponent.reqMapByOuterMHT);
			provMapByInnerMCH = (MultipleConnectionHash) aComponent.provMapByInnerMCH.Clone();
			reqMapByInnerCH = (ConnectionHash) aComponent.reqMapByInnerCH.Clone();
			bindingByProvMCH = (MultipleConnectionHash) aComponent.bindingByProvMCH.Clone();
			bindingByReqCH = (ConnectionHash) aComponent.bindingByReqCH.Clone();
		}

		#endregion

		#region Data

		/// <summary>
		/// key string roleID
		/// value IProvidesmapping
		/// </summary>
		private Hashtable provMapByOuterHT;
		private ConnectionHash reqMapByInnerCH;
		private ConnectionHash bindingByReqCH;

		/// <summary>
		/// key string roleID
		/// value Set
		/// </summary>
		private Hashtable reqMapByOuterMHT;
		private MultipleConnectionHash bindingByProvMCH;
		private MultipleConnectionHash provMapByInnerMCH;

		private ArrayList componentList;
		#endregion
	}
}

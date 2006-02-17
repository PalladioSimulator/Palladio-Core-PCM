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
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
			get { return (IComponent[]) componentList.ToArray(typeof(IComponent)); }
		}

		/// <summary>
		/// List of CompBinding objects, which represent 
		/// the wiring of the internal components.
		/// </summary>
		public IBinding[] Bindings
		{ 
			get { return (IBinding[]) bindingByProvMCH.Get().ToArray(typeof(IBinding)); }
		}

		/// <summary>
		/// List of ICompProvMappings mapping the ProvidesInterfaces
		/// of the internal components onto the ProvidesInterfaces of the
		/// CompositeComponent.
		/// </summary>
		public IMapping[] ProvidesMappings
		{ 
			get { return (IMapping[]) provMapByInnerMCH.Get().ToArray(typeof(IMapping)); }
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterface of the
		/// CompositeComponent.
		/// </summary>
		public IMapping[] RequiresMappings
		{ 
			get { return (IMapping[]) reqMapByInnerCH.Get().ToArray(typeof(IMapping)); }
		}

		#endregion
		
		#region Methods 

		public void AddComponents(params IComponent[] aCompArray)
		{
			if (ArrayIsNull(aCompArray))
				throw new NullNotAllowedException();
			componentList.AddRange(aCompArray);
		}

		public void DeleteComponents(params IComponent[] aCompArray)
		{
			if (aCompArray == null) return;

			// check precondition
			foreach (IComponent cmp in aCompArray)
			{
				if (HasIncomingConnections(cmp))
					throw new ComponentHasIncomingConnectionsException(cmp);
				if (HasOutgoingConnections(cmp))
					throw new ComponentHasOutgoingConnectionsException(cmp);
			}
			// delete data
			foreach (IComponent cmp in aCompArray)
			{
				componentList.Remove(cmp);
			}
		}
		

		public void AddProvidesInterfaces(params ISignatureList[] aProvInterfaceArray)
		{
			// check preconditions
			if (ArrayIsNull(aProvInterfaceArray))
				throw new NullNotAllowedException();

			foreach( ISignatureList provInterface in aProvInterfaceArray)
			{
				if ((provInterface.RoleID == null) || (provInterface.RoleID == ""))
					throw new MissingRoleIDException();
			}
			
			// insert data
			foreach( ISignatureList provInterface in aProvInterfaceArray)
			{
				providesMap.Add(provInterface.RoleID, provInterface);
			}
		}

		public void AddProvidesMappings(params IMapping[] aProvMappingArray )
		{
			// check preconditions
			if (ArrayIsNull(aProvMappingArray))
				throw new NullNotAllowedException();

			foreach( IMapping provMapping in aProvMappingArray)
			{
				CheckProvidesInterface(provMapping.InnerInterface);
				if( !this.HasProvidesInterface(provMapping.OuterRoleID))
					throw new NoInterfaceForRoleException(provMapping.OuterRoleID);
			}

			// insert data
			foreach( IMapping provMapping in aProvMappingArray)
			{
				provMapByInnerMCH.Add(provMapping.InnerInterface, provMapping);
				provMapByOuterHT.Add(provMapping.OuterRoleID, provMapping);
			}
		}

		public void DeleteProvidesInterfaces(params ISignatureList[] aProvInterfaceArray)
		{
			// check preconditions
			if (aProvInterfaceArray == null) return;

			foreach ( ISignatureList provInterface in aProvInterfaceArray)
			{
				if (provMapByOuterHT[provInterface.RoleID] != null)
					throw new HasOutgoingMappingException((IMapping)provMapByOuterHT[provInterface.RoleID]);
			}
			// delete data
			foreach ( ISignatureList provInterface in aProvInterfaceArray)
			{
				if (provInterface != null)
					providesMap.Remove(provInterface.RoleID);
			}
		}
		
		public void DeleteProvidesMappings(params IMapping[] aProvMappingArray)
		{
			if (aProvMappingArray == null) return;

			foreach (IMapping provMapping in aProvMappingArray)
			{
				if (provMapping != null)
				{
					provMapByOuterHT.Remove(provMapping.OuterRoleID);
					provMapByInnerMCH.Delete(provMapping.InnerInterface,provMapping);
				}
			}
		}


		public void AddRequiresInterfaces(params ISignatureList[] aReqInterfaceArray)
		{
			// check preconditions
			if (ArrayIsNull(aReqInterfaceArray))
				throw new NullNotAllowedException();

			foreach (ISignatureList reqInterface in aReqInterfaceArray)
			{
				if ((reqInterface.RoleID == null) || (reqInterface.RoleID == ""))
					throw new MissingRoleIDException();
			}

			// insert data
			foreach (ISignatureList reqInterface in aReqInterfaceArray)
			{
				requiresMap.Add(reqInterface.RoleID, reqInterface);
			}
		}

		public void AddRequiresMappings(params IMapping[] aReqMappingArray)
		{
			// check preconditions
			if (ArrayIsNull(aReqMappingArray))
				throw new NullNotAllowedException();

			foreach( IMapping reqMapping in aReqMappingArray)
			{
				CheckRequiresInterface(reqMapping.InnerInterface);
				if (!this.HasRequiresInterface(reqMapping.OuterRoleID))
					throw new NoInterfaceForRoleException(reqMapping.OuterRoleID);
			}

			// insert data
			foreach( IMapping reqMapping in aReqMappingArray)
			{
				reqMapByInnerCH.Add(reqMapping.InnerInterface, reqMapping);

				Set mapSet = (Set)reqMapByOuterMHT[reqMapping.OuterRoleID];
				if (mapSet == null)
					mapSet = new Set();
				mapSet.Add(reqMapping);
				reqMapByOuterMHT[reqMapping.OuterRoleID] = mapSet;
			}
		}

		public void DeleteRequiresInterfaces(params ISignatureList[] aReqInterfaceArray)
		{
			// check preconditions
			if (aReqInterfaceArray == null) return;

			foreach (ISignatureList reqInterface in aReqInterfaceArray)
			{
				if (aReqInterfaceArray != null)
				{
					Set connectionSet = (Set)reqMapByOuterMHT[reqInterface.RoleID];
					if ((connectionSet != null) && connectionSet.Count > 0)
						throw new HasIncomingMappingsException(connectionSet);
				}
			}

			// delete data
			foreach (ISignatureList reqInterface in aReqInterfaceArray)
			{
				if (aReqInterfaceArray != null)
					requiresMap.Remove(reqInterface.RoleID);
			}
		}

		public void DeleteRequiresMappings(params IMapping[] aReqMappingArray)
		{
			if (aReqMappingArray == null) return;

			foreach( IMapping mapping in aReqMappingArray)
			{
				if (mapping != null)
				{
					Set connectionSet = (Set)reqMapByOuterMHT[mapping.OuterRoleID];
					if (connectionSet != null)
						connectionSet.Remove(mapping);
					reqMapByInnerCH.Delete(mapping.InnerInterface);
				}
			}
		}


		public void AddBindings(params IBinding[] aBindingArray)
		{
			// check preconditions
			if (ArrayIsNull(aBindingArray))
				throw new NullNotAllowedException();

			foreach (IBinding binding in aBindingArray)
			{
				CheckProvidesInterface(binding.ProvidesInterface);
				CheckRequiresInterface(binding.RequiresInterface);
			}

			// add data
			foreach (IBinding binding in aBindingArray)
			{
				bindingByProvMCH.Add(binding.ProvidesInterface, binding);
				bindingByReqCH.Add(binding.RequiresInterface, binding );
			}
		}

		public void DeleteBindings(params IBinding[] aBindingArray)
		{
			if (aBindingArray == null) return;

			foreach (IBinding binding in aBindingArray)
			{
				if (binding != null)
				{
					bindingByProvMCH.Delete(binding.ProvidesInterface,binding);
					bindingByReqCH.Delete(binding.RequiresInterface);
				}
			}
		}
		

		public IBinding[] GetRequiresBindings(IComponent aComponent)
		{
			if (!ContainsComponent(aComponent))
				throw new ComponentNotFoundException(aComponent);
			return (IBinding[])bindingByReqCH.Get(aComponent).ToArray(typeof(IBinding));
		}

		public IBinding[] GetProvidesBindings(IComponent aComponent)
		{
			if (!ContainsComponent(aComponent))
				throw new ComponentNotFoundException(aComponent);
			return (IBinding[])bindingByProvMCH.Get(aComponent).ToArray(typeof(IBinding));
		}

		
		public IMapping[] GetProvidesMappings(IComponent aComponent)
		{
			if (!ContainsComponent(aComponent))
				throw new ComponentNotFoundException(aComponent);
			return (IMapping[]) provMapByInnerMCH.Get(aComponent).ToArray(typeof(IMapping));
		}

		public IMapping[] GetRequiresMappings(IComponent aComponent)
		{
			if (!ContainsComponent(aComponent))
				throw new ComponentNotFoundException(aComponent);
			return (IMapping[]) reqMapByInnerCH.Get(aComponent).ToArray(typeof(IMapping));
		}


		public IMapping GetProvidesMappingByOuter(string aProvRoleID)
		{
			if (!HasProvidesInterface(aProvRoleID))
				throw new RoleIDNotFoundException(aProvRoleID);
			return (IMapping) provMapByOuterHT[aProvRoleID];
		}

		public IMapping[] GetProvidesMappingsByInner(AttachedInterface aProvInterface)
		{
			CheckProvidesInterface(aProvInterface);
			return (IMapping[]) provMapByInnerMCH.Get(aProvInterface).ToArray(typeof(IMapping));
		}

		public IMapping[] GetProvidesMappingsByInner(IComponent aProvComponent, string aProvRole)
		{
			return GetProvidesMappingsByInner( new AttachedInterface(aProvComponent, aProvRole) );
		}


		public IBinding GetBindingByRequires(AttachedInterface aReqInterface)
		{
			CheckRequiresInterface(aReqInterface);
			return (IBinding) bindingByReqCH.Get(aReqInterface);
		}

		public IBinding GetBindingByRequires(IComponent aReqComponent, string aReqRole)
		{
			return GetBindingByRequires(new AttachedInterface(aReqComponent, aReqRole) );
		}

		public IBinding[] GetBindingsByProvides(AttachedInterface aProvInterface)
		{
			CheckProvidesInterface(aProvInterface);
			return (IBinding[]) bindingByProvMCH.Get(aProvInterface).ToArray(typeof(IBinding));
		}

		public IBinding[] GetBindingsByProvides(IComponent aProvComponent, string aProvRole)
		{
			return GetBindingsByProvides(new AttachedInterface(aProvComponent, aProvRole));
		}

		
		public IMapping GetRequiresMappingByInner(AttachedInterface aReqInterface)
		{
			CheckRequiresInterface(aReqInterface);
			return (IMapping) reqMapByInnerCH.Get(aReqInterface);
		}

		public IMapping GetRequiresMappingByInner(IComponent aReqComponent, string aReqRole)
		{
			return GetRequiresMappingByInner(new AttachedInterface( aReqComponent, aReqRole ) );
		}

		public IMapping[] GetRequiresMappingsByOuter(string aReqRoleID)
		{
			if (!HasRequiresInterface(aReqRoleID))
				throw new RoleIDNotFoundException(aReqRoleID);

			Set mapSet = (Set) reqMapByOuterMHT[aReqRoleID];
			if (mapSet != null)
				return (IMapping[]) mapSet.ToArray(typeof(IMapping));
			else
				return new IMapping[0] ;
		}


		public bool HasIncomingConnections(IComponent aComponent)
		{
			if (aComponent == null)
				return false;
			if (provMapByInnerMCH.Get(aComponent).Count > 0)
				return true;
			if (bindingByProvMCH.Get(aComponent).Count > 0)
				return true;
			return false;
		}

		public bool HasOutgoingConnections(IComponent aComponent)
		{
			if (aComponent == null)
				return false;
			if ( reqMapByInnerCH.Get(aComponent).Count > 0 )
				return true;
			if ( bindingByReqCH.Get(aComponent).Count > 0 )
				return true;
			return false;
		}

		public bool ContainsComponent(IComponent aComponent)
		{
			return (aComponent != null ? componentList.Contains(aComponent) : false);
		}


		private void CheckProvidesInterface(AttachedInterface anInterface)
		{
			if ((!ContainsComponent(anInterface.Component)) || (!anInterface.Component.HasProvidesInterface(anInterface.RoleID)))
				throw new InvalidAttachedInterfaceException(anInterface);
		}

		private void CheckRequiresInterface(AttachedInterface anInterface)
		{
			if ((!ContainsComponent(anInterface.Component)) || (!anInterface.Component.HasRequiresInterface(anInterface.RoleID)))
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
				this.componentList.Equals(cc.componentList) &&
				this.bindingByReqCH.Equals(cc.bindingByReqCH) &&
				this.provMapByOuterHT.Equals(cc.provMapByOuterHT) &&
				this.reqMapByInnerCH.Equals(cc.reqMapByInnerCH)
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

		#endregion

		#region Constructors

		public CompositeComponent( IAttributeHash anAttHash ) : base (anAttHash)
		{
			componentList = new Vector();
			provMapByOuterHT = new Hashmap();
			reqMapByOuterMHT = new Hashmap();
			provMapByInnerMCH = new MultipleConnectionHash();
			reqMapByInnerCH = new ConnectionHash();
			bindingByProvMCH = new MultipleConnectionHash();
			bindingByReqCH = new ConnectionHash();
		}

		public CompositeComponent( CompositeComponent aComponent) : base (aComponent)
		{
			componentList = new Vector(aComponent.componentList);
			provMapByOuterHT = aComponent.provMapByOuterHT.Clone();
			reqMapByOuterMHT = aComponent.reqMapByOuterMHT.Clone();
			provMapByInnerMCH = aComponent.provMapByInnerMCH.Clone();
			reqMapByInnerCH = aComponent.reqMapByInnerCH.Clone();
			bindingByProvMCH = aComponent.bindingByProvMCH.Clone();
			bindingByReqCH = aComponent.bindingByReqCH.Clone();
		}

		#endregion

		#region Data

		/// <summary>
		/// key string roleID
		/// value IProvidesmapping
		/// </summary>
		private Hashmap provMapByOuterHT;
		private ConnectionHash reqMapByInnerCH;
		private ConnectionHash bindingByReqCH;

		/// <summary>
		/// key string roleID
		/// value Set
		/// </summary>
		private Hashmap reqMapByOuterMHT;
		private MultipleConnectionHash bindingByProvMCH;
		private MultipleConnectionHash provMapByInnerMCH;

		private Vector componentList;
		#endregion
	}
}

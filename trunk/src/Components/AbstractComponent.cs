using System;
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
	/// Default Component class. A component consits of a set of
	/// Provides and RequiresInterface which can be adapted to
	/// its environment.
	/// </summary>
	internal abstract class AbstractComponent : IComponent 
	{
		#region Properties

		public IIdentifier ID
		{
			get
			{
				return myID;
			}
		}

		/// <summary>
		/// Interfaces provided by the component to its environment.
		/// </summary>
		public IIdentifier[] ProvidedRoles
		{ 
			get 
			{
				IIdentifier[] result = new IIdentifier[providesMap.Count];
				providesMap.Keys.CopyTo(result,0);
				return result;
			}
		}

		/// <summary>
		/// Interfaces required by the component from its environment.
		/// </summary>
		public IIdentifier[] RequiredRoles 
		{ 
			get
			{
				IIdentifier[] result = new IIdentifier[requiresMap.Count];
				requiresMap.Keys.CopyTo(result,0);
				return result;
			}
		}

		/// <summary>
		/// A list of attributes attached this component. 
		/// </summary>
		public IAttributeHash Attributes 
		{ 
			get { return attributes; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public abstract object Clone();
			
		/// <summary>
		/// Get the ProvidesInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The ProvidesInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		public IInterfaceModel GetProvidesInterface(IIdentifier aRoleID)
		{
			IRole result = providesMap[aRoleID];
			if (result == null)
				throw new RoleIDNotFoundException(aRoleID);
			return result.Interface;
		}
		
		/// <summary>
		/// Get the RequiresInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The RequiresInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		public IInterfaceModel GetRequiresInterface(IIdentifier aRoleID)
		{
			IRole result = requiresMap[aRoleID];
			if (result == null)
				throw new RoleIDNotFoundException(aRoleID);
			return result.Interface;
		}

		public bool HasProvidesInterface(IIdentifier aRoleID)
		{
			return (aRoleID != null ? providesMap.Contains(aRoleID) : false);
		}
		
		public bool HasRequiresInterface(IIdentifier aRoleID)
		{
			return (aRoleID != null ? requiresMap.Contains(aRoleID) : false);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is AbstractComponent)) return false;
			if ((object)this == obj) return true;
			AbstractComponent cmp = (AbstractComponent)obj;
			return (
				providesMap.Equals(cmp.providesMap) &&
				requiresMap.Equals(cmp.requiresMap)
				);
		}

		public override int GetHashCode()
		{
			return providesMap.GetHashCode() ^ requiresMap.GetHashCode();
		}

		public void AcceptVisitor(IVisitor v) {}

		/// <summary>
		/// Adds a provides interface to the component. For each service of the interface a 
		/// a service effect specification is required. It is given by a service effect mapping.
		/// </summary>
		/// <param name="aProvInterface">Provides interface to be added</param>
		/// <param name="roleID">The ID of the role to be created</param>
		public void AddProvidesInterface(IIdentifier roleID,IInterfaceModel aProvInterface)
		{
			if (aProvInterface == null || roleID == null)
				throw new ArgumentNullException("Interface or role can't be null");
			if (providesMap.Contains(roleID))
				throw new RoleIDAlreadySpecifiedException(roleID.ToString());
			providesMap.Add(roleID,ComponentFactory.CreateAttachedInterface(aProvInterface,roleID));
		}

		/// <summary>
		/// Remove all provides interfaces with the roles given by aProvRoleArray 
		/// from the component.
		/// </summary>
		/// <param name="aProvRoleArray">Roles of the interfaces to be removed.</param>
		public virtual void DeleteProvidesInterfaces(params IIdentifier[] aProvRoleArray)
		{
			foreach (IIdentifier id in aProvRoleArray)
				if (!HasProvidesInterface(id))
					throw new RoleIDNotFoundException(id);
			foreach (IIdentifier id in aProvRoleArray)
			{
				providesMap.Remove(id);
			}
		}
			
		/// <summary>
		/// Add all requires interfaces given by aReqArray to the component.
		/// </summary>
		/// <param name="aReqInterface">An requires interface to be added</param>
		/// <param name="roleID">The role ID of the interface to attach</param>
		public void AddRequiresInterface(IIdentifier roleID, IInterfaceModel aReqInterface)
		{
			if (aReqInterface == null || roleID == null)
				throw new ArgumentNullException("Interface or role can't be null");
			if (requiresMap.Contains(roleID))
				throw new RoleIDAlreadySpecifiedException(roleID.ToString());
			requiresMap.Add(roleID,ComponentFactory.CreateAttachedInterface(aReqInterface,roleID));
		}

		/// <summary>
		/// Remove all requires interfaces with the roles given by aReqRoleArray.
		/// </summary>
		/// <param name="aReqRoleArray">Roles of the requires interfaces to be deleted.</param>
		public virtual void DeleteRequiresInterfaces(params IIdentifier[] aReqRoleArray)
		{
			foreach (IIdentifier id in aReqRoleArray)
				if (!HasRequiresInterface(id))
					throw new RoleIDNotFoundException(id);
			foreach (IIdentifier id in aReqRoleArray)
			{
				requiresMap.Remove(id);
			}
		}
		
		public bool HasRole(IIdentifier roleID)
		{
			if (roleID == null)
				throw new ArgumentNullException("Interface or role can't be null");
			return (providesMap.Contains(roleID) || requiresMap.Contains(roleID));
		}

		public IRole GetRole(IIdentifier aRoleID)
		{
			if (!HasRole(aRoleID))
				throw new RoleIDNotFoundException(aRoleID);
			if (providesMap.Contains(aRoleID))
				return providesMap[aRoleID];
			else
				return requiresMap[aRoleID];

		}
		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty component with the attributes in anAttHash.
		/// </summary>
		/// <param name="anAttHash">List of attributes attached to this component.</param>
		/// <param name="aID">ID of the component</param>
		public AbstractComponent(IAttributeHash anAttHash, IIdentifier aID)
		{
			providesMap = new ComponentRolesHashmap();
			requiresMap = new ComponentRolesHashmap();
			attributes = anAttHash;
			myID = aID;
		}

		public AbstractComponent(AbstractComponent anotherComponent)
		{
			requiresMap = (ComponentRolesHashmap)anotherComponent.requiresMap.Clone();
			providesMap = (ComponentRolesHashmap)anotherComponent.providesMap.Clone();
			attributes = (IAttributeHash)anotherComponent.attributes.Clone();
			myID = (IIdentifier)anotherComponent.ID.Clone();
		}

		#endregion

		#region Data

		protected ComponentRolesHashmap providesMap;
		protected ComponentRolesHashmap requiresMap;
		protected IIdentifier myID;
		private	  IAttributeHash attributes;

		#endregion
	}
}
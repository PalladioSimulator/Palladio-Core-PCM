using System;
using Palladio.Identifier;
using Palladio.ComponentModel.Exceptions;

namespace Palladio.ComponentModel.Components
{
	/// <summary>
	/// Zusammenfassung für DefaultAttachedInterface.
	/// </summary>
	internal class DefaultAttachedRole : IAttachedRole
	{
		protected IComponent component;
		protected IRole role;

		/// <summary>
		/// The interface attached to a component
		/// </summary>
		public IIdentifier ComponentID
		{
			get
			{
				return component.ID;
			}
		}

		/// <summary>
		/// The role ID of the attached interface
		/// </summary>
		public IIdentifier RoleID
		{
			get
			{
				return role.ID;
			}
		}

		public IRole Role
		{
			get
			{
				return role;
			}
		}
		
		public IComponent Component
		{
			get
			{
				return component;
			}
		}

		public override bool Equals(object obj)
		{
			if (!(obj is DefaultAttachedRole)) return false;
			if (obj == this) return true;
			DefaultAttachedRole myRole = (DefaultAttachedRole)obj;
			return (ComponentID.Equals(myRole.ComponentID) && RoleID.Equals(myRole.RoleID));
		}


		/// <summary>
		/// Default constructor
		/// </summary>
		/// <param name="component">The component to which to role is attached</param>
		/// <param name="roleID">The role of the interface in the attachment</param>
		public DefaultAttachedRole(IComponent component, IIdentifier roleID)
		{
			this.component = component;
			this.role = component.GetRole(roleID);
		}
	}
}

using System;
using Palladio.Identifier;

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

		/// <summary>
		/// Default constructor
		/// </summary>
		/// <param name="anInterface">An interface to attach to a component</param>
		/// <param name="aRole">The role of the interface in the attachment</param>
		public DefaultAttachedRole(IComponent component, IIdentifier roleID)
		{
			this.component = component;
			this.role = component.GetRole(roleID);
		}
	}
}

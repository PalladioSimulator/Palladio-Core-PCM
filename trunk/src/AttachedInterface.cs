using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public struct AttachedInterface
	{
		private string roleID;
		private IComponent component;

		public string RoleID
		{
			get
			{
				return roleID;
			}
			set
			{
				roleID = value;
			}
		}

		public IComponent Component
		{
			get { return component; }
			set { component = value; }
		}

		public AttachedInterface(IComponent aComponent, string aRoleID)
		{
			component = aComponent;
			roleID = aRoleID;
		}
	}
}


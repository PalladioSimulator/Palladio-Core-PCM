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

		public string RoleID {
			get {
				return roleID;
			}
			set {
				roleID = value;
			}
		}
		public IComponent Component {
			get {
				return component;
			}
			set {
				component = value;
			}
		}
		
		public AttachedInterface(string roleID, IComponent component)
		{
			this.roleID = roleID;
			this.component = component;
		}
		
		public override string ToString()
		{
			return String.Format("[AttachedInterface: roleID = {0}, component = {1}]",
			                     roleID,
			                     component);
		}
		
		public override bool Equals(object obj)
		{
			if (!(obj is AttachedInterface)) return false;
			if ((object)this == obj) return true;
			AttachedInterface myAttachedInterface = (AttachedInterface)obj;
			if (roleID != null ? roleID.Equals(myAttachedInterface.roleID): myAttachedInterface.roleID != null) return false;
			if (component != myAttachedInterface.component) return false;
			
			return true;
		}
		
		public override int GetHashCode()
		{
			return (roleID != null ? roleID.GetHashCode() : 0) ^ component.GetHashCode();
		}
		
		
	}
}


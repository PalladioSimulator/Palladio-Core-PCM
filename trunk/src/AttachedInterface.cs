using System;
using System.Collections;
using Palladio.ComponentModel.Exceptions;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public struct AttachedInterface : IVisitable 
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
		
		public AttachedInterface(string aRoleID, IComponent aComponent)
		{
			this.component = aComponent;
			this.roleID = aRoleID;
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
			if (roleID != null ? !roleID.Equals(myAttachedInterface.roleID) : myAttachedInterface.roleID != null) return false;
			if (component != null ? !component.Equals( myAttachedInterface.component) : myAttachedInterface.component != null) return false;
			return true;
		}
		
		public override int GetHashCode()
		{
			return 
				(roleID != null ? roleID.GetHashCode() : 0) ^ 
				( component != null ? component.GetHashCode() : 0);
		}

		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor) {}
	}
}


using System;
using System.Collections;
using Palladio.ComponentModel.Exceptions;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// An AttachedInterface specifices a role by associating it with a component.
	/// </summary>
	public struct AttachedInterface : IVisitable 
	{
		#region Properties

		/// <summary>
		/// Role of the interface.
		/// </summary>
		public string RoleID 
		{
			get { return roleID; }
			set { roleID = value; }
		}

		/// <summary>
		/// Component the role is attached to.
		/// </summary>
		public string Component {
			get { return component; }
			set { component = value; }
		}

		#endregion

		#region Methods
		
		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return String.Format("[AttachedInterface: roleID = {0}, component = {1}]",
				roleID,
				component);
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
			if (!(obj is AttachedInterface)) return false;
			if ((object)this == obj) return true;
			AttachedInterface myAttachedInterface = (AttachedInterface)obj;
			if (roleID != null ? !roleID.Equals(myAttachedInterface.roleID) : myAttachedInterface.roleID != null) return false;
			if (component != null ? !component.Equals( myAttachedInterface.component) : myAttachedInterface.component != null) return false;
			return true;
		}
		
		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return 
				( roleID != null ? roleID.GetHashCode() : 0) ^ 
				( component != null ? component.GetHashCode() : 0);
		}

		/// <summary>
		/// This method is called by the <see cref="ReflectionBasedVisitor"/> to allow data
		/// structure driven visiting of the structure.<br></br>
		/// Leave this method's body empty if you don't need data structure driven visiting.
		/// </summary>
		/// <param name="visitor">The visitor to accept</param>
		public void AcceptVisitor (IVisitor visitor) {}

		#endregion
		
		#region Constructors
		
		/// <summary>
		/// Attaches the interface with aRoleID to aComponent. The component
		/// must contain an interface with aRoleID.
		/// </summary>
		/// <param name="aComponent"></param>
		/// <param name="aRoleID">aRoleID of aComponent.</param>
		public AttachedInterface(IComponent aComponent, string aRoleID)
		{
			this.component = aComponent;
			this.roleID = aRoleID;
		}

		#endregion

		#region Data

		private string roleID;
		private IComponent component;

		#endregion
	}
}


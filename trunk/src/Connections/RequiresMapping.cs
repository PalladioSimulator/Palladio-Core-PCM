using System;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Attributes;

namespace Palladio.ComponentModel.Connections
{
	/// <summary>
	/// Maps one ProvidesInterface of an inner Component
	/// onto one ProvidesInterfaces of an outer Component.
	/// </summary>
	internal class RequiresMapping : Connection, IRequiresMapping
	{
		#region Properties

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		public AttachedInterface[] InnerInterfaces
		{ 
			get { return MultipleInterfaces; }
			set { MultipleInterfaces = value; }
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		public string OuterRoleID
		{ 
			get { return SingleInterface.RoleID; } 
			set { SingleInterface = new AttachedInterface(value,null); }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new RequiresMapping(this);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is RequiresMapping))
				return false;
			return base.Equals (obj);
		}

		public override int GetHashCode()
		{
			return base.GetHashCode ();
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

		#endregion

		#region Constructors

		public RequiresMapping(IAttributeHash anAttHash) : base(anAttHash)
		{
		}

		public RequiresMapping(RequiresMapping aProvMapping) : base( aProvMapping )
		{
		}

		#endregion

	}
}


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
	internal class Mapping : AbstractConnection, IMapping
	{
		#region Properties

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		public AttachedInterface InnerInterface
		{ 
			get{ return this.FirstInterface; }
			set{ this.FirstInterface = value;}
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		public string OuterRoleID
		{ 
			get { return this.SecondInterface.RoleID; }
			set { this.SecondInterface = new AttachedInterface(null, value); }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new Mapping(this);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is Mapping))
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

		public Mapping(IAttributeHash anAttHash) : base(anAttHash)
		{
		}

		public Mapping(Mapping aProvMapping) : base( aProvMapping )
		{
		}

		public Mapping(IAttributeHash anAttHash, AttachedInterface anInnerIface, string anOuterRoleID) :
			base(anAttHash, anInnerIface, new AttachedInterface(null, anOuterRoleID))
		{
		}

		#endregion
	}
}


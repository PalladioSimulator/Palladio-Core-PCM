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
	internal class ProvidesMapping : Connection, IProvidesMapping
	{
		#region Properties

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		public AttachedInterface InnerInterface
		{ 
			get{ return this.SingleInterface; }
			set{ this.SingleInterface = value;}
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		public string[] OuterRoleIDs
		{ 
			get 
			{ 
				string[] result = new string[MultipleInterfaces.Length];
				int index = 0;
				foreach (AttachedInterface i in MultipleInterfaces)
				{
					result[index++] = i.RoleID;
				}
				return result;
			}
			set 
			{ 
				MultipleInterfaces = new AttachedInterface[0];
				foreach (string roleID in value)
				{
					AddInterface(roleID,null);
				}
			}
		}
		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new ProvidesMapping(this);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is ProvidesMapping))
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

		public ProvidesMapping(IAttributeHash anAttHash) : base(anAttHash)
		{
		}

		public ProvidesMapping(ProvidesMapping aProvMapping) : base( aProvMapping )
		{
		}

		#endregion
	}
}


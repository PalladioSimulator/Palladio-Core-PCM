using System;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Attributes;

namespace Palladio.ComponentModel.Connections
{
	/// <summary>
	/// Connects the RequiresInterface of one component to the ProvidesInterfaces
	/// of another.
	/// </summary>
	internal class Binding : AbstractConnection, IBinding
	{
		#region Properties

		/// <summary>
		/// Description of the services provided 
		/// by one of the compontents to the other.
		/// </summary>
		public AttachedInterface ProvidesInterface
		{ 
			get { return this.FirstInterface; }
			set { this.FirstInterface = value; }
		}

		/// <summary>
		/// Description of the services required by one of the
		/// components from the other.
		/// </summary>
		public AttachedInterface RequiresInterface
		{ 
			get { return this.SecondInterface; }
			set { this.SecondInterface = value; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new Binding(this);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is Binding))
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

		public Binding(IAttributeHash anAttHash) : base(anAttHash)
		{
		}

		public Binding(Binding aBinding) : base( aBinding )
		{
		}

		#endregion
	}
}

using System;
using System.Collections;
using Palladio.Attributes;
using Palladio.Utils.Collections;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel.Connections
{
	/// <summary>
	/// </summary>
	internal class DefaultConnection : IConnection
	{

		#region Properties

		/// <summary>
		/// A list of attributes attached this component. 
		/// </summary>
		public IAttributeHash Attributes 
		{ 
			get { return attributes; }
		}

		public IAttachedRole ProvidingRole
		{
			get { return providingRole; }
			set { providingRole = value; }
		}

		public IAttachedRole RequiringRole
		{
			get { return requiringRole;}
			set { requiringRole = value; }
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public virtual object Clone()
		{
			return new DefaultConnection(this);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is IConnection)) return false;
			if ((object)this == obj) return true;
			IConnection myConnection = (IConnection)obj;
			return (
				providingRole.Equals(myConnection.ProvidingRole) &&
				requiringRole.Equals(myConnection.RequiringRole)
			);
		}

		public override int GetHashCode()
		{
			return (
				requiringRole.GetHashCode() ^
				requiringRole.GetHashCode()
			);
		}
		
		public override string ToString()
		{
			return requiringRole.ToString() + " ---> " + providingRole.ToString();
		}

		public virtual void AcceptVisitor(IVisitor v){}

		public virtual void Serialize(System.Xml.XmlTextWriter writer) {}
		public virtual void Deserialize(System.Xml.XmlNode element) {}
		#endregion

		#region Constructors

		protected DefaultConnection(IAttributeHash anAttHash)
		{
			attributes = (IAttributeHash)anAttHash.Clone();
		}

		protected DefaultConnection(IAttributeHash anAttHash, IAttachedRole aReqRole, IAttachedRole aProvRole) : this (anAttHash)
		{
			providingRole = aProvRole;
			requiringRole = aReqRole;
		}

		protected DefaultConnection(DefaultConnection aConnection) : 
			this (aConnection.Attributes, aConnection.providingRole, aConnection.requiringRole)
		{
		}


		#endregion

		#region Data

		protected IAttachedRole providingRole;
		protected IAttachedRole requiringRole;
		private   IAttributeHash attributes;
		#endregion
	}
}

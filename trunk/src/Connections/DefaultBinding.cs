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
	internal class DefaultBinding : DefaultConnection, IBinding
	{
		public DefaultBinding(IAttributeHash anAttHash, IAttachedRole aReqRole, IAttachedRole aProvRole) : base(anAttHash,aReqRole,aProvRole) {}

		public DefaultBinding(DefaultBinding aBinding) : base(aBinding) {}

		public override bool Equals(object obj)
		{
			if (!(obj is DefaultBinding)) return false;
			return base.Equals (obj);
		}
		
		public override int GetHashCode()
		{
			return base.GetHashCode();
		}

		public override object Clone()
		{
			return new DefaultBinding(this);
		}

		public override void Serialize(System.Xml.XmlTextWriter writer) 
		{
			writer.WriteStartElement("Binding","http://palladio.informatik.uni-oldenburg.de/XSD");
			writer.WriteAttributeString("provCompID",this.ProvidingRole.ComponentID.ToString());
			writer.WriteAttributeString("provRoleID",this.ProvidingRole.RoleID.ToString());
			writer.WriteAttributeString("reqCompID",this.RequiringRole.ComponentID.ToString());
			writer.WriteAttributeString("reqRoleID",this.RequiringRole.RoleID.ToString());
			writer.WriteEndElement();
		}

		public override void Deserialize(System.Xml.XmlNode element) 
		{

		}

	}
}

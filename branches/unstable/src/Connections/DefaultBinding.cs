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
		public DefaultBinding(IAttributeHash anAttHash, IRole aReqRole, IRole aProvRole) : base(anAttHash,aReqRole,aProvRole) {}

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
			writer.WriteAttributeString("provCompID",this.ProvidingRole.Component.ID.ToString());
			writer.WriteAttributeString("provRoleID",this.ProvidingRole.ID.ToString());
			writer.WriteAttributeString("reqCompID",this.RequiringRole.Component.ID.ToString());
			writer.WriteAttributeString("reqRoleID",this.RequiringRole.ID.ToString());
			writer.WriteEndElement();
		}

		public override void Deserialize(System.Xml.XmlNode element) 
		{

		}

	}
}

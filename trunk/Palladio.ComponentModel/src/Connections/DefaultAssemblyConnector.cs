using System;
using System.Xml;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Attributes;
using Palladio.ComponentModel.Exceptions;
using Palladio.Identifier;

namespace Palladio.ComponentModel.Connections
{
	/// <summary>
	/// Connects the RequiresInterface of one component to the ProvidesInterfaces
	/// of another.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/21 15:37:43  joemal
	/// replace keyword as with real typcast
	///
	/// Revision 1.1  2005/02/21 13:48:18  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultAssemblyConnector : DefaultConnection, IAssemblyConnector
	{
		public DefaultAssemblyConnector(AttributeHash anAttHash, IRole aReqRole, IRole aProvRole) : base(anAttHash,aReqRole,aProvRole) {}

		public DefaultAssemblyConnector(DefaultAssemblyConnector aAssemblyConnector) : base(aAssemblyConnector) {}

		public override bool Equals(object obj)
		{
			if (!(obj is DefaultAssemblyConnector)) return false;
			return base.Equals (obj);
		}
		
		public override int GetHashCode()
		{
			return base.GetHashCode();
		}

		public override object Clone()
		{
			return new DefaultAssemblyConnector(this);
		}

		public override void Serialize(XmlTextWriter writer) 
		{
			writer.WriteStartElement("Binding","http://palladio.informatik.uni-oldenburg.de/XSD");
			writer.WriteAttributeString("id", this.ID.ToString());
			foreach (IAttributeType attrType in this.Attributes.Keys)
			{
				writer.WriteStartElement("Attribute","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",attrType.GUID.ToString());
				this.Attributes[attrType].Serialize(writer);
				writer.WriteEndElement();
			}
			writer.WriteStartElement("ProvidingRole","http://palladio.informatik.uni-oldenburg.de/XSD");
			writer.WriteAttributeString("guid",this.ProvidingRole.Component.ID.ToString());
			writer.WriteAttributeString("id",this.ProvidingRole.ID.ToString());
			writer.WriteEndElement();
			writer.WriteStartElement("RequiringRole","http://palladio.informatik.uni-oldenburg.de/XSD");
			writer.WriteAttributeString("guid",this.RequiringRole.Component.ID.ToString());
			writer.WriteAttributeString("id",this.RequiringRole.ID.ToString());
			writer.WriteEndElement();
			writer.WriteEndElement();
		}

		public override void Deserialize(XmlNode element) 
		{
			foreach (XmlNode node in element.ChildNodes)
			{
				switch(node.Name)
				{
					case "ProvidingRole":
						IComponent provComp = (IComponent)ModelPersistencyService.Instance.GetEntity(IdentifiableFactory.CreateGUID(node.Attributes["guid"].Value));
						if (provComp == null)
							throw new DeserializationException("Component "+node.Attributes["guid"].Value+" not found.");
						this.providingRole = provComp.GetRole(IdentifiableFactory.CreateStringID(node.Attributes["id"].Value));
						if (this.providingRole == null)
							throw new DeserializationException("Role "+node.Attributes["id"].Value+" not found in Component "+node.Attributes["guid"].Value);
						break;
					case "RequiringRole":
						IComponent reqComp = (IComponent)ModelPersistencyService.Instance.GetEntity(IdentifiableFactory.CreateGUID(node.Attributes["guid"].Value));
						if (reqComp == null)
							throw new DeserializationException("Component "+node.Attributes["guid"].Value+" not found.");
						this.requiringRole = reqComp.GetRole(IdentifiableFactory.CreateStringID(node.Attributes["id"].Value));
						if (this.requiringRole == null)
							throw new DeserializationException("Role "+node.Attributes["id"].Value+" not found in Component "+node.Attributes["guid"].Value);
						break;
				}
			}
		}

	}
}

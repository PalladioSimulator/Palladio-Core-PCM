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
	/// Maps one ProvidesInterface of an inner Component
	/// onto one ProvidesInterfaces of an outer Component.
	/// </summary>
	internal class DefaultMapping : DefaultConnection, IMapping
	{
		protected MappingTypeEnum myType;

		#region Properties
		public MappingTypeEnum MappingType
		{
			get
			{
				return myType;
			}
		}

		public bool IsProvidesMapping
		{
			get
			{
				return myType == MappingTypeEnum.PROVIDES_MAPPING;
			}
		}

		public bool IsRequiresMapping
		{
			get
			{
				return myType == MappingTypeEnum.REQUIRES_MAPPING;
			}
		}

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		public IRole InnerRole
		{ 
			get
			{
				switch (myType)
				{
					case MappingTypeEnum.PROVIDES_MAPPING:
						return this.ProvidingRole;
					case MappingTypeEnum.REQUIRES_MAPPING:
						return this.RequiringRole;
					default: // should never ever happen
						throw new Exception("Unknown Type!");
				}
			}
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		public IRole OuterRole
		{ 
			get
			{
				switch (myType)
				{
					case MappingTypeEnum.PROVIDES_MAPPING:
						return this.RequiringRole;
					case MappingTypeEnum.REQUIRES_MAPPING:
						return this.ProvidingRole;
					default: // should never ever happen
						throw new Exception("Unknown Type!");
				}
			}
		}

		public override object Clone()
		{
			return new DefaultMapping(this);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is IMapping)) return false;
			if ((object)this == obj) return true;
			IMapping myMapping = (IMapping)obj;
			return (
				base.Equals(obj) &&
				myType == myMapping.MappingType
				);
		}

		public override int GetHashCode()
		{
			return (
				base.GetHashCode()
			);
		}

		#endregion

		public override void Serialize(System.Xml.XmlTextWriter writer) 
		{
			if (IsProvidesMapping) 
			{
				writer.WriteStartElement("ProvidesMapping","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("id", this.ID.ToString());
				foreach (IAttributeType attrType in this.Attributes.Keys)
				{
					writer.WriteStartElement("Attribute","http://palladio.informatik.uni-oldenburg.de/XSD");
					writer.WriteAttributeString("guid",attrType.GUID.ToString());
					this.Attributes[attrType].Serialize(writer);
					writer.WriteEndElement();
				}
				writer.WriteStartElement("ProvidingRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",this.InnerRole.Component.ID.ToString());
				writer.WriteAttributeString("id",this.InnerRole.ID.ToString());
				writer.WriteEndElement();
				writer.WriteStartElement("RequiringRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",this.OuterRole.Component.ID.ToString());
				writer.WriteAttributeString("id",this.OuterRole.ID.ToString());
				writer.WriteEndElement();
				writer.WriteEndElement();
			}
			else
			{
				writer.WriteStartElement("RequiresMapping","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("id", this.ID.ToString());
				foreach (IAttributeType attrType in this.Attributes.Keys)
				{
					writer.WriteStartElement("Attribute","http://palladio.informatik.uni-oldenburg.de/XSD");
					writer.WriteAttributeString("guid",attrType.GUID.ToString());
					this.Attributes[attrType].Serialize(writer);
					writer.WriteEndElement();
				}
				writer.WriteStartElement("ProvidingRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",this.OuterRole.Component.ID.ToString());
				writer.WriteAttributeString("id",this.OuterRole.ID.ToString());
				writer.WriteEndElement();
				writer.WriteStartElement("RequiringRole","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("guid",this.InnerRole.Component.ID.ToString());
				writer.WriteAttributeString("id",this.InnerRole.ID.ToString());
				writer.WriteEndElement();
				writer.WriteEndElement();
			}
		}

		public override void Deserialize(XmlNode element) 
		{
			if (element.Name.Equals("ProvidesMapping")) 
				this.myType = MappingTypeEnum.PROVIDES_MAPPING;
			else
				this.myType = MappingTypeEnum.REQUIRES_MAPPING;

			foreach (XmlNode node in element.ChildNodes)
			{
				switch(node.Name)
				{
					case "ProvidingRole":
						IComponent provComp = ModelPersistencyService.Instance.GetEntity(IdentifiableFactory.CreateGUID(node.Attributes["guid"].Value)) as IComponent;
						if (provComp == null)
							throw new DeserializationException("Component "+node.Attributes["guid"].Value+" not found.");
						this.providingRole = provComp.GetRole(IdentifiableFactory.CreateStringID(node.Attributes["id"].Value));
						if (this.providingRole == null)
							throw new DeserializationException("Role "+node.Attributes["id"].Value+" not found in Component "+node.Attributes["guid"].Value);
						break;
					case "RequiringRole":
						IComponent reqComp = ModelPersistencyService.Instance.GetEntity(IdentifiableFactory.CreateGUID(node.Attributes["guid"].Value)) as IComponent;
						if (reqComp == null)
							throw new DeserializationException("Component "+node.Attributes["guid"].Value+" not found.");
						this.requiringRole = reqComp.GetRole(IdentifiableFactory.CreateStringID(node.Attributes["id"].Value));
						if (this.requiringRole == null)
							throw new DeserializationException("Role "+node.Attributes["id"].Value+" not found in Component "+node.Attributes["guid"].Value);
						break;
				}
			}
		}

		public DefaultMapping(AttributeHash anAttHash, IRole aReqRole, IRole aProvRole, MappingTypeEnum direction) : base(anAttHash,aReqRole,aProvRole)
		{
			this.myType = direction;
		}

		public DefaultMapping(DefaultMapping aMapping) : base (aMapping)
		{
			this.myType = aMapping.MappingType;
		}
	}
}


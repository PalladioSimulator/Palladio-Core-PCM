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
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/21 15:37:43  joemal
	/// replace keyword as with real typcast
	///
	/// Revision 1.1  2005/02/21 13:48:10  joemal
	/// initial import
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultDelegationConnector : DefaultConnection, IDelegationConnector
	{
		protected DelegationTypeEnum myType;

		#region Properties
		public DelegationTypeEnum DelegationType
		{
			get
			{
				return myType;
			}
		}

		public bool IsProvidesDelegationConnector
		{
			get
			{
				return myType == DelegationTypeEnum.PROVIDES_DELEGATION;
			}
		}

		public bool IsRequiresDelegationConnector
		{
			get
			{
				return myType == DelegationTypeEnum.REQUIRES_DELEGATION;
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
					case DelegationTypeEnum.PROVIDES_DELEGATION:
						return this.ProvidingRole;
					case DelegationTypeEnum.REQUIRES_DELEGATION:
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
					case DelegationTypeEnum.PROVIDES_DELEGATION:
						return this.RequiringRole;
					case DelegationTypeEnum.REQUIRES_DELEGATION:
						return this.ProvidingRole;
					default: // should never ever happen
						throw new Exception("Unknown Type!");
				}
			}
		}

		public override object Clone()
		{
			return new DefaultDelegationConnector(this);
		}

		public override bool Equals(object obj)
		{
			if (!(obj is IDelegationConnector)) return false;
			if ((object)this == obj) return true;
			IDelegationConnector myDelegationConnector = (IDelegationConnector)obj;
			return (
				base.Equals(obj) &&
				myType == myDelegationConnector.DelegationType
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
			if (IsProvidesDelegationConnector) 
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
				this.myType = DelegationTypeEnum.PROVIDES_DELEGATION;
			else
				this.myType = DelegationTypeEnum.REQUIRES_DELEGATION;

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

		public DefaultDelegationConnector(AttributeHash anAttHash, IRole aReqRole, IRole aProvRole, DelegationTypeEnum direction) : base(anAttHash,aReqRole,aProvRole)
		{
			this.myType = direction;
		}

		public DefaultDelegationConnector(DefaultDelegationConnector aDelCon) : base (aDelCon)
		{
			this.myType = aDelCon.DelegationType;
		}
	}
}


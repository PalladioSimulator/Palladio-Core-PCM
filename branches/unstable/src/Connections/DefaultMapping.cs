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
				writer.WriteAttributeString("provCompID",this.InnerRole.Component.ID.ToString());
				writer.WriteAttributeString("provRoleID",this.InnerRole.ID.ToString());
				writer.WriteAttributeString("reqCompID",this.OuterRole.Component.ID.ToString());
				writer.WriteAttributeString("reqRoleID",this.OuterRole.ID.ToString());
			}
			else if (IsRequiresMapping) 
			{
				writer.WriteStartElement("RequiresMapping","http://palladio.informatik.uni-oldenburg.de/XSD");
				writer.WriteAttributeString("provCompID",this.OuterRole.Component.ID.ToString());
				writer.WriteAttributeString("provRoleID",this.OuterRole.ID.ToString());
				writer.WriteAttributeString("reqCompID",this.InnerRole.Component.ID.ToString());
				writer.WriteAttributeString("reqRoleID",this.InnerRole.ID.ToString());
			}

			writer.WriteEndElement();

		}

		public DefaultMapping(IAttributeHash anAttHash, IRole aReqRole, IRole aProvRole, MappingTypeEnum direction) : base(anAttHash,aReqRole,aProvRole)
		{
			this.myType = direction;
		}

		public DefaultMapping(DefaultMapping aMapping) : base (aMapping)
		{
			this.myType = aMapping.MappingType;
		}
	}
}


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
		public IAttachedRole InnerRole
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
		public IAttachedRole OuterRole
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

		public DefaultMapping(IAttributeHash anAttHash, IAttachedRole aReqRole, IAttachedRole aProvRole, MappingTypeEnum direction) : base(anAttHash,aReqRole,aProvRole)
		{
			this.myType = direction;
		}

		public DefaultMapping(DefaultMapping aMapping) : base (aMapping)
		{
			this.myType = aMapping.MappingType;
		}
	}
}


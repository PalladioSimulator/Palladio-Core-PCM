using System;
using Palladio.Attributes;

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
	/// Revision 1.3  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
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

		#endregion

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


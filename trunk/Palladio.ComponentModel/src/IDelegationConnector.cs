namespace Palladio.ComponentModel
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
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface IDelegationConnector : IConnection
	{
		#region Properties
		/// <summary>
		/// The type of the DelegationConnector - provides DelegationConnector or requires DelegationConnector
		/// </summary>
		DelegationTypeEnum DelegationType
		{
			get;
		}

		/// <summary>
		/// True if the DelegationConnector maps an external provided role to an internal provided role
		/// </summary>
		bool IsProvidesDelegationConnector
		{
			get;
		}

		/// <summary>
		/// True if the DelegationConnector maps an internal required role to an outside required role
		/// </summary>
		bool IsRequiresDelegationConnector
		{
			get;
		}

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		IRole InnerRole
		{ 
			get;
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		IRole OuterRole
		{ 
			get;
		}
		#endregion
	}
	
	/// <summary>
	/// Describe the type of a DelegationConnector
	/// </summary>
	public enum DelegationTypeEnum
	{
		/// <summary>
		/// The DelegationConnector maps a requires role to the outer world
		/// </summary>
		REQUIRES_DELEGATION,
		/// <summary>
		/// The DelegationConnector maps a provided role to an internal component
		/// </summary>
		PROVIDES_DELEGATION
	}
}


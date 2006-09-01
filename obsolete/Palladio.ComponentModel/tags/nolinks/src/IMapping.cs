using System;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Describe the type of a mapping
	/// </summary>
	public enum MappingTypeEnum
	{
		/// <summary>
		/// The mapping maps a requires role to the outer world
		/// </summary>
		REQUIRES_MAPPING,
		/// <summary>
		/// The mapping maps a provided role to an internal component
		/// </summary>
		PROVIDES_MAPPING
	}

	/// <summary>
	/// Maps one ProvidesInterface of an inner Component
	/// onto one ProvidesInterfaces of an outer Component.
	/// </summary>
	public interface IMapping : IConnection, IVisitable
	{
		#region Properties
		/// <summary>
		/// The type of the mapping - provides mapping or requires mapping
		/// </summary>
		MappingTypeEnum MappingType
		{
			get;
		}

		/// <summary>
		/// True if the mapping maps an external provided role to an internal provided role
		/// </summary>
		bool IsProvidesMapping
		{
			get;
		}

		/// <summary>
		/// True if the mapping maps an internal required role to an outside required role
		/// </summary>
		bool IsRequiresMapping
		{
			get;
		}

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		IAttachedRole InnerRole
		{ 
			get;
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		IAttachedRole OuterRole
		{ 
			get;
		}
		#endregion
	}
}


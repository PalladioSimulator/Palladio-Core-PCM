using System;
using System.Collections;
using ReflectionBasedVisitor;
using Palladio.Identifier;

namespace Palladio.ComponentModel
{
	public enum MappingTypeEnum
	{
		REQUIRES_MAPPING,
		PROVIDES_MAPPING
	}

	/// <summary>
	/// Maps one ProvidesInterface of an inner Component
	/// onto one ProvidesInterfaces of an outer Component.
	/// </summary>
	public interface IMapping : IConnection, IVisitable
	{
		#region Properties
		MappingTypeEnum MappingType
		{
			get;
		}

		bool IsProvidesMapping
		{
			get;
		}

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


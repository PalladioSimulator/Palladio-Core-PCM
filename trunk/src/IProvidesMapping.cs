using System;
using System.Collections;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Maps one ProvidesInterface of an inner Component
	/// onto one ProvidesInterfaces of an outer Component.
	/// </summary>
	public interface IProvidesMapping : IConnection, IVisitable
	{
		#region Properties

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		AttachedInterface InnerInterface
		{ 
			get; set;
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		string[] OuterRoleIDs
		{ 
			get; set;
		}
		#endregion
	}
}


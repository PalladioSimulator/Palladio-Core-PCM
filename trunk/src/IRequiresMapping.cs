using System;
using System.Collections;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Maps one ProvidesInterface of an inner Component
	/// onto one ProvidesInterfaces of an outer Component.
	/// </summary>
	public interface IRequiresMapping : IConnection, IVisitable
	{
		#region Properties

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		AttachedInterface[] InnerInterfaces
		{ 
			get; set;
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		string OuterRoleID
		{ 
			get; set;
		}
		#endregion
	}
}


using System;
using System.Collections;
using ReflectionBasedVisitor;

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
	/// Revision 1.2  2004/05/24 15:20:44  sliver
	/// added cvs log
	///
	/// </pre>
	/// </remarks>
	public interface IMapping : IConnection, IVisitable
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
		string OuterRoleID
		{ 
			get; set;
		}
		#endregion
	}
}


using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Maps one ProvidesInterface of an inner Component
	/// onto one ProvidesInterfaces of an outer Component.
	/// </summary>
	public interface IIfaceProvMapping : IInterfaceConnection
	{
		#region Properties

		/// <summary>
		/// ProvidesInterface of the inner component.
		/// </summary>
		ProvidesInterface InnerInterface 
		{ 
			get;
		}

		/// <summary>
		/// ProvidesInterface of the outer component.
		/// </summary>
		ProvidesInterface OuterInterface 
		{ 
			get;
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks if the required subtype relation between the mapped elements
		/// is fulfilled. The relation depends on the role of the element.
		/// </summary>
		/// <param name="anErrorList">List of errors occured during the
		/// subtypececk.</param>
		/// <returns>True, if the subtype relation is fullfilled, false otherwise.</returns>
		bool IsSubType(out IList anErrorList);

		/// <summary>
		/// Checks if the required subtype relation between the mapped elements
		/// is fulfilled. The relation depends on the role of the element.
		/// </summary>
		/// <returns>True, if the subtype relation is fullfilled, false otherwise.</returns>
		bool IsSubType();

		#endregion
	}
}


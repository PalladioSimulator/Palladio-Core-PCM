using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Maps the RequiresInterfaces of an inner Component
	/// onto the RequiresInterfaces of an outer Component.
	/// </summary>
	public interface ICompReqMapping : IComponentConnection
	{
		#region Properties

		/// <summary>
		/// This Component is contained in the OuterComponent. 
		/// </summary>
		IComponent InnerComponent 
		{ 
			get;
		}

		/// <summary>
		/// This Component is containing the InnerComponent.
		/// </summary>
		IComponent OuterComponent 
		{ 
			get;
		}

		/// <summary>
		/// Mappings of the RequiresInterfaces of the
		/// InnerComponent onto the RequiresInterfaces of
		/// the OuterComponent.
		/// </summary>
		IIfaceReqMapping[] InterfaceMappings
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
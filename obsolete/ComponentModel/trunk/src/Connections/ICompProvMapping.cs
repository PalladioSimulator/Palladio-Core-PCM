using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Maps the ProvidesInterfaces of an inner Component
	/// onto the ProvidesInterfaces of an outer Component.
	/// </summary>
	public interface ICompProvMapping : IComponentConnection 
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
		/// Mappings of the ProvidesInterfaces of the
		/// InnerComponent onto the ProvidesInterfaces of
		/// the OuterComponent.
		/// </summary>
		IIfaceProvMapping[] InterfaceMappings
		{
			get;
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks if the required subtype relation between the mapped elements
		/// is fulfilled. In this case the ProvidesInterfaces of the outer 
		/// component have to be a subtype of the ones of the inner component.
		/// </summary>
		/// <param name="anErrorList">List of errors occured during the
		/// subtypececk.</param>
		/// <returns>True, if the subtype relation is fullfilled, false otherwise.</returns>
		bool IsSubType(out IList anErrorList);

		/// <summary>
		/// Checks if the required subtype relation between the mapped elements
		/// is fulfilled. In this case the ProvidesInterfaces of the outer 
		/// component have to be a subtype of the ones of the inner component.
		/// </summary>
		/// <returns>True, if the subtype relation is fullfilled, false otherwise.</returns>
		bool IsSubType();

		#endregion
	}
}


using System;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// An IInterfaceModel is the description of an interface (of a component).
	/// In our case an interface is a set of services
	/// which are somehow related to each other. This relation of
	/// the services is given by the implementation 
	/// of the IInterfaceModel interface.
	/// </summary>
	public interface IInterfaceModel : ICloneable 
	{
		/// <summary>
		/// Checks if this IInterfaceModel is a subset of each 
		/// IInterfaceModel in anIModelList.
		/// </summary>
		/// <param name="anIModelList">List of IInterfaceModels</param>
		/// <returns>True, if this IInterfaceModel is a subset of
		/// each IInterfaceModel contained in anIModelList, false otherwise.</returns>
		bool IsSubSetOf( IList anIModelList );

		/// <summary>
		/// Checks if this IInterfaceModel is a subset of each 
		/// IInterfaceModel in anIModelList.
		/// </summary>
		/// <param name="anIModelList">List of IInterfaceModels</param>
		/// <param name="anErrorList">List of errors occured during the check.</param>
		/// <returns>True, if this IInterfaceModel is a subset of
		/// each IInterfaceModel contained in anIModelList, false otherwise.</returns>
		bool IsSubSetOf( IList anIModelList, out IList anErrorList);

		/// <summary>
		/// Checks if this IInterfaceModel is a subset of anIModel. In
		/// other words all services of this IInterfaceModel must be
		/// provided by anIModel and all relations between these 
		/// services expected by this IInterfaceModel must be fulfilled
		/// by anIModel, but anIModel can provide more than what is required
		/// by this IInterfaceModel.
		/// </summary>
		/// <param name="anIModel">An other IInterfaceModel.</param>
		/// <returns>True, if this IInterfaceModel is a subset of anIModel, false otherwise.</returns>
		bool IsSubSetOf( IInterfaceModel anIModel );

		/// <summary>
		/// Checks if this interface is a subset of anIModel. In
		/// other words all services of this IInterfaceModel must be
		/// provided by anIModel and all relations between these 
		/// services expected by this IInterfaceModel must be fulfilled
		/// by anIModel, but anIModel can provide more than what is required
		/// by this IInterfaceModel.
		/// </summary>
		/// <param name="anIModel">An other IInterfaceModel.</param>
		/// <param name="anErrorList">List of error which occured during the subtypecheck.</param>
		/// <returns>True, if this IInterfaceModel is a subset of anIModel, false otherwise.</returns>
		bool IsSubSetOf( IInterfaceModel anIModel, out IList anErrorList);
		
		/// <summary>
		/// Merges this IInterfaceModel with anIModelList.
		/// </summary>
		/// <param name="anIModelList">List of IInterfaceModels</param>
		/// <returns>A new IInterfaceModel created by merging this IInterfacemodel with all 
		/// IInterfaceModels contained by anIModelList.</returns>
		IInterfaceModel Merge( IList anIModelList );

		/// <summary>
		/// Merges this IInterfaceModel with anIModel.
		/// </summary>
		/// <param name="anIModel">An IInterfaceModel which is merged with this one.</param>
		/// <returns>A new IInterfaceModel created by merging this IInterfacemodel and anIModel.</returns>
		IInterfaceModel Merge( IInterfaceModel anIModel );

		/// <summary>
		/// Intersects this IInterfaceModel and all IInterfaceModel in anIModelList. 
		/// The result contains alls services and relationships wich exist in all 
		/// IInterfaceModels.
		/// </summary>
		/// <param name="anIModelList">A List of IInterfaceModels.</param>
		/// <returns>A new IInterfaceModel representing the intersection 
		/// of all IInterfaceModels</returns>
		IInterfaceModel GetIntersection( IList anIModelList );

		/// <summary>
		/// Intersects this IInterfaceModel and anIModel. 
		/// The result contains alls services and relationships wich exist in both
		/// IInterfaceModels.
		/// </summary>
		/// <param name="anIModel">IInterfaceModel to intersect with.</param>
		/// <returns>A new IInterfaceModel representing the intersection 
		/// of both IInterfaceModels</returns>
		IInterfaceModel GetIntersection( IInterfaceModel anIModel );
	}
}

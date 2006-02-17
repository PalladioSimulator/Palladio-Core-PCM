using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Implementation of the methods common to all IInterfaceModels.
	/// </summary>
	public abstract class AbstractIModel : IInterfaceModel 
	{
		#region Abstract Methods

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
		public abstract bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList);

		/// <summary>
		/// Merges this IInterfaceModel with anIModel.
		/// </summary>
		/// <param name="anIModel">An IInterfaceModel which is merged with this one.</param>
		/// <returns>A new IInterfaceModel created by merging this IInterfacemodel an anIModel.</returns>
		public abstract IInterfaceModel Merge(IInterfaceModel anIModel);

		/// <summary>
		/// Intersects this IInterfaceModel and anIModel. 
		/// The result contains alls services and relationships wich exist in both
		/// IInterfaceModels.
		/// </summary>
		/// <param name="anIModel">IInterfaceModel to intersect with.</param>
		/// <returns>A new IInterfaceModel representing the intersection 
		/// of both IInterfaceModels</returns>
		public abstract IInterfaceModel GetIntersection( IInterfaceModel anIModel );

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public abstract object Clone();

		#endregion

		#region Implemented Methods

		/// <summary>
		/// Checks if this IInterfaceModel is a subset of each 
		/// IInterfaceModel in anIModelList.
		/// </summary>
		/// <param name="anIModelList">List of IInterfaceModels</param>
		/// <returns>True, if this IInterfaceModel is a subset of
		/// each IInterfaceModel contained in anIModelList, false otherwise.</returns>
		public bool IsSubSetOf(IList anIModelList) 
		{
			IList errorList;
			return IsSubSetOf(anIModelList, out errorList);
		}

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
		public bool IsSubSetOf(IInterfaceModel anIModel) 
		{
			IList errorList;
			return IsSubSetOf(anIModel, out errorList);
		}

		/// <summary>
		/// Checks if this IInterfaceModel is a subset of each 
		/// IInterfaceModel in anIModelList.
		/// </summary>
		/// <param name="anIModelList">List of IInterfaceModels</param>
		/// <param name="anErrorList">List of errors occured during the check.</param>
		/// <returns>True, if this IInterfaceModel is a subset of
		/// each IInterfaceModel contained in anIModelList, false otherwise.</returns>
		public bool IsSubSetOf(IList anIModelList, out IList anErrorList) 
		{
			bool result = false;
			anErrorList = new Vector();
			foreach (IInterfaceModel iModel in anIModelList)
			{
				IList errorList;
				if (!this.IsSubSetOf(iModel, out errorList))
				{
					((Vector)anErrorList).AddRange(errorList);
					result = false;
				}
			}
			return result;
		}
		

		/// <summary>
		/// Merges this IInterfaceModel with anIModelList.
		/// </summary>
		/// <param name="anIModelList">List of IInterfaceModels</param>
		/// <returns>A new IInterfaceModel created by merging this IInterfacemodel with all 
		/// IInterfaceModels contained by anIModelList.</returns>
		public IInterfaceModel Merge(IList anIModelList)
		{
			IInterfaceModel result = (IInterfaceModel) this.Clone();
			foreach ( IInterfaceModel iModel in anIModelList ) 
			{
				result = result.Merge( iModel );
			}
			return result;
		}

		/// <summary>
		/// Merges all IInterfaceModels contained by anIModelList into
		/// a new IInterfaceModel.
		/// </summary>
		/// <param name="anIModelList">A list of IInterfaceModels.</param>
		/// <returns></returns>
		public static IInterfaceModel MergeList( IList anIModelList )
		{
			IInterfaceModel resultIModel;
			Vector iModelList = new Vector( anIModelList );

			resultIModel = (IInterfaceModel) ((IInterfaceModel) iModelList[0]).Clone();
			
			if (iModelList.Count > 1)
			{
				iModelList.RemoveAt(0);
				resultIModel = resultIModel.Merge(iModelList);
			}

			return resultIModel;
		}

		/// <summary>
		/// Intersects this IInterfaceModel and all IInterfaceModel in anIModelList. 
		/// The result contains alls services and relationships wich exist in all 
		/// IInterfaceModels.
		/// </summary>
		/// <param name="anIModelList">A List of IInterfaceModels.</param>
		/// <returns>A new IInterfaceModel representing the intersection 
		/// of all IInterfaceModels</returns>
		public IInterfaceModel GetIntersection( IList anIModelList ) 
		{
			IInterfaceModel result = (IInterfaceModel) this.Clone();
			foreach ( IInterfaceModel iModel in anIModelList ) 
			{
				result = result.GetIntersection( iModel );
			}
			return result;
		}


		#endregion


	}
}

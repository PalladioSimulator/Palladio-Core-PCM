using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Implements functionality relevant to all InterfaceModels.
	/// </summary>
	public abstract class AbstractIModel : IInterfaceModel 
	{
		
		#region Abstract Methods

		public abstract bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList);

		public abstract IInterfaceModel Merge(IInterfaceModel anIModel);

		public abstract IInterfaceModel Intersect( IInterfaceModel anIModel );

		public abstract object Clone();

		#endregion

		#region Implemented Methods

		public bool IsSubSetOf(IList anIModelList) 
		{
			IList errorList;
			return IsSubSetOf(anIModelList, out errorList);
		}

		public bool IsSubSetOf(IInterfaceModel anIModel) 
		{
			IList errorList;
			return IsSubSetOf(anIModel, out errorList);
		}

		public bool IsSubSetOf(IList anIModelList, out IList anErrorList) 
		{
			bool result = false; // TODO select a proper return value
			anErrorList = new ArrayList(); // TODO set a correct error value for an empty input
			
			if ( anIModelList.Count != 0 ) 
			{
				IInterfaceModel iModel = (IInterfaceModel) anIModelList[0];
				anIModelList.RemoveAt(0);
				result = IsSubSetOf ( iModel.Merge( anIModelList ), out anErrorList );
			} 
			return result;
		}
		

		public IInterfaceModel Merge(IList anIModelList)
		{
			IInterfaceModel result = (IInterfaceModel) this.Clone();
			foreach ( IInterfaceModel iModel in anIModelList ) 
			{
				result = result.Merge( iModel );
			}
			return result;
		}

		public static IInterfaceModel MergeList( IList anIModelList )
		{
			IInterfaceModel resultIModel;
			ArrayList iModelList = new ArrayList( anIModelList );

			resultIModel = (IInterfaceModel) ((IInterfaceModel) iModelList[0]).Clone();
			
			if (iModelList.Count > 1)
			{
				iModelList.RemoveAt(0);
				resultIModel = resultIModel.Merge(iModelList);
			}

			return resultIModel;
		}

		public IInterfaceModel Intersect( IList anIModelList ) 
		{
			IInterfaceModel result = (IInterfaceModel) this.Clone();
			foreach ( IInterfaceModel iModel in anIModelList ) 
			{
				result = result.Intersect( iModel );
			}
			return result;
		}


		#endregion


	}
}

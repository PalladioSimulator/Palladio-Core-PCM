using System;
using System.Collections;

namespace Palladio.ComponentModel {
	/// <summary>
	/// Implements functionality relevant to all InterfaceModels.
	/// </summary>
	public abstract class AbstractIModel : IInterfaceModel {
		
		public abstract bool IsSubSetOf(IInterfaceModel anIModel, out IList anErrorList);

		public abstract IInterfaceModel Merge(IInterfaceModel anIModel);

		public abstract object Clone();

		public bool IsSubSetOf(IList anIModelList) {
			IList errorList;
			return IsSubSetOf(anIModelList, out errorList);
		}

		public bool IsSubSetOf(IInterfaceModel anIModel) {
			IList errorList;
			return IsSubSetOf(anIModel, out errorList);
		}

		public bool IsSubSetOf(IList anIModelList, out IList anErrorList) {
			bool result = false; // TODO select a proper return value
			anErrorList = new ArrayList(); // TODO set a correct error value for an empty input
			
			if ( anIModelList.Count != 0 ) {
				IInterfaceModel iModel = (IInterfaceModel) anIModelList[0];
				anIModelList.RemoveAt(0);
				result = IsSubSetOf ( iModel.Merge( anIModelList ), out anErrorList );
			} 
			return result;
		}
		

		public IInterfaceModel Merge(IList anIModelList){
			IInterfaceModel result = (IInterfaceModel) this.Clone();
			foreach ( IInterfaceModel iModel in anIModelList ) {
				result = result.Merge( iModel );
			}
			return result;
		}


	}
}

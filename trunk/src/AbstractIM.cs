using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// Implements functionality relevant to all InterfaceModels.
	/// </summary>
	public abstract class AbstractIM : IInterfaceModel {
		
		public abstract bool SubTypeCheck(IInterfaceModel anIModel, out IList anErrorList);

		public abstract IList GetInterOperabilityErrors(IInterfaceModel anIModel);

		public abstract IInterfaceModel Merge(IInterfaceModel anIModel);

		public bool SubTypeCheck(IList anIModelList) {
			IList errorList;
			return SubTypeCheck(anIModelList, out errorList);
		}

		public bool SubTypeCheck(IInterfaceModel anIModel) {
			IList errorList;
			return SubTypeCheck(anIModel, out errorList);
		}

		public bool SubTypeCheck(IList anIModelList, out IList anErrorList) {
			bool result = false; // TODO select a proper return value
			anErrorList = new ArrayList(); // TODO set a correct error value for an empty input
			
			if ( anIModelList.Count != 0 ) {
				IInterfaceModel iModel = (IInterfaceModel) anIModelList[0];
				anIModelList.RemoveAt(0);
				result = SubTypeCheck ( iModel.Merge( anIModelList ), out anErrorList );
			} 
			return result;
		}
		

		public IList GetInterOperabilityErrors(IList anIModelList) {
			IList result = new ArrayList();
			
			if ( anIModelList.Count != 0 ) {
				IInterfaceModel iModel = (IInterfaceModel) anIModelList[0];
				anIModelList.RemoveAt(0);
				result = GetInterOperabilityErrors( iModel.Merge( anIModelList ) );
			} 
			return result;
		}

		public IInterfaceModel Merge(IList anIModelList){
			IInterfaceModel result = this; // TODO clone??
			foreach ( IInterfaceModel iModel in anIModelList ) {
				result = result.Merge( iModel );
			}
			return result;
		}
	}
}

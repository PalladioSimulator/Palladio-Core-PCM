using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public abstract class AbstractIM : IInterfaceModel {

		public abstract bool SubTypeCheck(IList anIModelList, out IList anErrorList);

		public abstract IList GetInterOperabilityErrors(IList anIModelList);

		public abstract IInterfaceModel Merge(IList anIModelList);


		public bool SubTypeCheck(IList anIModelList) {
			IList errorList;
			return SubTypeCheck(anIModelList, errorList);
		}

		public bool SubTypeCheck(IInterfaceModel anIModel) {
			IList errorList;
			return SubTypeCheck(anIModel, errorList);
		}

		public bool SubTypeCheck(IInterfaceModel anIModel, out IList anErrorList) {
			IList iModelList = new ArrayList();
			iModelList.Add(anIModel);
			return SubTypeCheck(iModelList, anErrorList);
		}

		public IList GetInterOperabilityErrors(IInterfaceModel anIModel) {
			IList iModelList = new ArrayList();
			iModelList.Add(anIModel);
			return GetInterOperabilityErrors(iModelList);
		}

		public IInterfaceModel Merge(IInterfaceModel anIModel) {
			IList iModelList = new ArrayList();
			iModelList.Add(anIModel);
			return Merge(iModelList);
		}
	}
}

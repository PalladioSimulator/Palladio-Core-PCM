using System;
using System.Collections;

namespace ComponentModel
{
	/// <summary>
	/// </summary>
	public class RequiresInterface : AbstractIM	 {

		// Delegate
		IInterfaceModel requiresIM;

		public RequiresInterface() {
		}

		public override IList GetInterOperabilityErrors(IList anIModelList) {
			return null;
		}

		public override IInterfaceModel Merge(IList anIModelList) {
			return null;
		}

		public override bool SubTypeCheck(IList anIModelList, out IList anErrorList) {
			anErrorList = null;
			return false;
		}
	}
}

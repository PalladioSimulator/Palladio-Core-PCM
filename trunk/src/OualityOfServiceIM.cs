using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class OualityOfServiceIM : AbstractIM {

		public OualityOfServiceIM()	{
		}

		public override bool SubTypeCheck(IInterfaceModel anIModel, out IList anErrorList) {
			anErrorList = null;
			return false;
		}

		public override IList GetInterOperabilityErrors(IInterfaceModel anIModel) {
			return null;
		}

		public override IInterfaceModel Merge(IInterfaceModel anIModel) {
			return null;
		}

	}
}

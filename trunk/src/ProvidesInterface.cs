using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// Contains information about the services provided by a component.
	/// </summary>
	public class ProvidesInterface : AbstractIM {

		/// <summary>
		/// IInterfaceModel describing the relationship 
		/// of the provided services.
		/// </summary>
		private IInterfaceModel providesIM;
		
		private IList serviceList;


		public ProvidesInterface() {
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

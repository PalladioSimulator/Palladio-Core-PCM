using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class ProvidesInterface : IInterfaceModel {
		// Delegate
		private IInterfaceModel providesIM;
		
		private IList serviceList;


		public ProvidesInterface() {
		}

		public RequiresInterface GetRequiresInterface();

		// Adapt provides interface to the supply of the environment.
		// Which services can be supported.

		// define rules for adaptation ??
		public ProvidesInterface GetAdaptedProvInt( IList anEnvProvIntList );


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

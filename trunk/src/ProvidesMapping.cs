using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class ProvidesMapping : AbstractConnection {
		
		private ProvidesInterface	innerProvIFace;
		private IComponent			innerComp;

		private ProvidesInterface	outerProvIFace;
		private IComponent			outerComp;

		public ProvidesInterface InnerProvIFace { 
			get { return innerProvIFace; }
		}

		public IComponent InnerComp { 
			get { return innerComp; }
		}

		public ProvidesInterface OuterProvIFace { 
			get { return outerProvIFace; }
		}

		public IComponent OuterComp { 
			get { return outerComp; }
		}


		public ProvidesMapping ( IComponent anInnerComp, ProvidesInterface anInnerProvI, 
			IComponent anOuterComp, ProvidesInterface anOuterProvI ) {
		}

		public override bool CheckInteroperability(out IList anErrorList) {
			anErrorList = null;
			return false;
		}

		public override IInterfaceModel GetIntersection() {
			return null;
		}
	}
}

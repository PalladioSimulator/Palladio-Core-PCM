using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class RequiresMapping : AbstractConnection {
		
		private RequiresInterface	innerReqIFace;
		private IComponent			innerComp;

		private RequiresInterface	outerReqIFace;
		private IComponent			outerComp;

		public RequiresInterface InnerReqIFace { 
			get { return innerReqIFace; }
		}

		public IComponent InnerComp { 
			get { return innerComp; }
		}

		public RequiresInterface OuterReqIFace { 
			get { return outerReqIFace; }
		}

		public IComponent OuterComp { 
			get { return outerComp; }
		}

		public RequiresMapping ( IComponent anInnerComp, RequiresInterface anInnerReqIFace, 
			IComponent anOuterComponent, RequiresInterface anOuterReqIFace) {
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

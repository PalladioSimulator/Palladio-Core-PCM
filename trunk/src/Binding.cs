using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class Binding : IConnection {

		private ProvidesInterface provIFace;
		private IComponent provComp;

		private RequiresInterface reqIFace;
		private IComponent reqComp;

		public ProvidesInterface ProvIFace { 
			get { return provIFace; }
		}

		public RequiresInterface ReqIFace { 
			get { return reqIFace; }
		}

		public IComponent ProvComp { 
			get { return provComp; }
		}

		public IComponent ReqComp { 
			get { return reqComp; }
		}

		public Binding ( IComponent aProvComp, ProvidesInterface aProvIFace, 
			IComponent anOuterComponent, RequiresInterface aReqIFace ) {
		}

		public bool CheckInteroperability() {
			return false;
		}

		public bool CheckInteroperability(out IList anErrorList) {
			anErrorList = null;
			return false;
		}

		public IInterfaceModel GetIntersection() {
			return null;
		}

	}
}

using System;
using System.Collections;

namespace Palladio.ComponentModel {
	/// <summary>
	/// Connection between a requires interface of component A and
	/// a provides interface of component B. Both components stand on
	/// the same level. (none is including the other)
	/// </summary>
	public class Binding : IBinding {

		private ProvidesInterface provIFace;
		private IComponent provComp;

		private RequiresInterface reqIFace;
		private IComponent reqComp;

		/// <summary>
		/// Provides interface of component B.
		/// </summary>
		public ProvidesInterface ProvIFace { 
			get { return provIFace; }
		}

		/// <summary>
		/// Component B. Owner of the provides interface.
		/// </summary>
		public IComponent ProvComp { 
			get { return provComp; }
		}

		/// <summary>
		/// Requires interface of component A.
		/// </summary>
		public RequiresInterface ReqIFace { 
			get { return reqIFace; }
		}

		/// <summary>
		/// Component A. Owner of the requires interface.
		/// </summary>
		public IComponent ReqComp { 
			get { return reqComp; }
		}

		/// <summary>
		/// Creates a binding between the requires interface (aReqIFace) of
		/// the component A (aReqComp) and the provides interface (aProvIFace) of
		/// the component B (aProvComp).
		/// </summary>
		/// <param name="aProvComp"></param>
		/// <param name="aProvIFace"></param>
		/// <param name="anOuterComponent"></param>
		/// <param name="aReqIFace"></param>
		public Binding ( IComponent aProvComp, ProvidesInterface aProvIFace, 
			IComponent aReqComp, RequiresInterface aReqIFace ) {
			reqComp = aReqComp;
			reqIFace = aReqIFace;
			provComp = aProvComp;
			provIFace = aProvIFace;
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

using System;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class Binding : IConnection {

		public ProvidesInterface ProvIFace { get; }
		public RequiresInterface ReqIFace { get; }

		public IComponent ProvComp { get; }
		public IComponent ReqComp { get; }

		public Binding ( IComponent aProvComp, ProvidesInterface aProvIFace, 
			IComponent anOuterComponent, RequiresInterface aReqIFace ) {
		}

		#region IConnection Member

		public bool CheckInteroperability() {
			// TODO:  Implementierung von Binding.CheckInteroperability hinzufügen
			return false;
		}

		bool ComponentModel.IConnection.CheckInteroperability(out IList anErrorList) {
			// TODO:  Implementierung von Binding.ComponentModel.IConnection.CheckInteroperability hinzufügen
			anErrorList = null;
			return false;
		}

		public IInterfaceModel GetIntersection() {
			// TODO:  Implementierung von Binding.GetIntersection hinzufügen
			return null;
		}

		#endregion
	}
}

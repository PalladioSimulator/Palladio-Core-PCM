using System;
using System.Collections;

namespace ComponentModel {

	/// <summary>
	/// </summary>
	public class Component : IComponent {

		public Component( IList aProvIFaceList ){
		}

		public Component( IList aProvIFaceList, IList aReqIFaceList ) {
		}

		public IList GetProvidesIFaceList(IList aProvIFaceList) {
			return null;
		}

		public IList GetRequiresIFaceList(IList aReqIFaceList) {
			return null;
		}

		public IList GetProvidesIFaceList() {
			return null;
		}

		public IList GetRequiresIFaceList() {
			return null;
		}
	}
}
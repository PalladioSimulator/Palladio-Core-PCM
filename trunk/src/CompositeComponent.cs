using System;
using System.Collections;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class CompositeComponent : IComponent {
		private IList componentList;
		private IList bindingList;
		private IList mappingList;

		public IList ComponentList { 
			get { return componentList; }
		}

		public IList BindingList { 
			get { return bindingList; }
		}

		public IList MappingList { 
			get { return mappingList; }
		}

		public CompositeComponent() {
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

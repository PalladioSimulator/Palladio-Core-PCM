using System;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class CompositeComponent : IComponent
	{
		public IList ComponentList { get; }

		public IList BindingList { get; }

		public IList MappingList { get; }

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

using System;
using System.Collections;

namespace ComponentModel {

	/// <summary>
	/// Default Component class. A component consits of a set of
	/// provides and requires interfaces, which can be adapted to
	/// its environment.
	/// </summary>
	public class Component : IComponent {

		private IList provIFaceList;
		private IList reqIFaceList;

		/// <summary>
		/// Creates a new component with a list of provides interfaces an 
		/// no requirements to the environment.
		/// </summary>
		/// <param name="aProvIFaceList">
		/// A list of ProvidesInterface objects.
		/// </param>
		public Component( IList aProvIFaceList ){
			provIFaceList = aProvIFaceList;
		}

		/// <summary>
		/// Creates a new component with a list of provides and requires
		/// interfaces.
		/// </summary>
		/// <param name="aProvIFaceList">
		/// A list of ProvidesInterface objects.
		/// </param>
		/// <param name="aReqIFaceList">
		/// A list of RequiresInterface objects.
		/// </param>
		public Component( IList aProvIFaceList, IList aReqIFaceList ) {
			provIFaceList = aProvIFaceList;
			reqIFaceList = aReqIFaceList;
		}

		/// <summary>
		/// Returns an list of adapted provides interfaces of this component.
		/// </summary>
		/// <param name="aProvIFaceList">
		/// List of provides interfaces of the environment.
		///	</param>
		/// <returns>
		/// A list of ProvideInterface objects.
		/// </returns>
		public IList GetProvidesIFaceList(IList aProvIFaceList) {
			return null;
		}


		/// <summary>
		/// Returns a list of adapted requires interfaces of this component.
		/// </summary>
		/// <param name="aReqIFaceList">
		/// List of requires interfaces of the environment.
		/// </param>
		/// <returns>
		/// A list of RequiresInterface objects.
		/// </returns>
		public IList GetRequiresIFaceList(IList aReqIFaceList) {
			return null;
		}


		/// <summary>
		/// Returns a list of unmodified provides interfaces of this component.
		/// </summary>
		/// <returns>
		/// A List of ProvidesInterface objects.
		/// </returns>
		public IList GetProvidesIFaceList() {
			return provIFaceList;
		}


		/// <summary>
		/// Returns a list of unmodified requires interfaces of this component.
		/// </summary>
		/// <returns>
		/// A list of RequiresInterface objects.
		/// </returns>
		public IList GetRequiresIFaceList() {
			return reqIFaceList;
		}
	}
}
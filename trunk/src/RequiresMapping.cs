using System;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class RequiresMapping {
		public RequiresInterface InnerReqI { get; }
		public RequiresInterface OuterReqI { get; }

		public IComponent InnerComp { get; }
		public IComponent OuterComp { get; }

		public RequiresMapping ( IComponent anInnerComp, RequiresInterface anInnerReqI, 
			IComponent anOuterComponent, RequiresInterface anOuterReqI) {
		}
	}
}

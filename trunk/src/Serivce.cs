using System;
using System.Reflection;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class Service {

		private IInterfaceModel serviceEffectSpec;
		
		private MethodInfo methodInfo;

		public IInterfaceModel ServiceEffectSpec { 
			get { return serviceEffectSpec; }
		}
		
		public Service( MethodInfo aMethodInfo ){
		}

	}
}

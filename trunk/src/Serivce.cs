using System;
using System.Reflection;

namespace Palladio.ComponentModel {
	/// <summary>
	/// A service consists of a provided method or function with an associated service
	/// effect specification describing its requirements.
	/// </summary>
	public class Service {

		private IInterfaceModel effectSpec;
		private MethodSignature signature;

		/// <summary>
		/// Describes the method provided by this service.
		/// </summary>
		public MethodSignature Signature {
			get { return signature; }
		}

		/// <summary>
		/// Specifies the requirements of this service.
		/// </summary>
		public IInterfaceModel EffectSpec { 
			get { return effectSpec; }
		}
		
		public Service(IInterfaceModel anIModel, MethodSignature aSignature ){
			effectSpec = anIModel;
			signature = aSignature;
		}

		public Service(MethodSignature aSignature){
			signature = aSignature;
		}
	}
}

using System;
using System.Reflection;

namespace ComponentModel {
	/// <summary>
	/// </summary>
	public class Service : MethodInfo {
		
		public IInterfaceModel ServiceEffectSpec { get; }
		
		public Service(){
		}
	}
}

using System;
using System.Reflection;

namespace ComponentModel {
	/// <summary>
	/// Signature of a service.
	/// </summary>
	public class MethodSignature : MethodInfo {

		/// <summary>
		/// Delegation to a .Net MethodInfo object, which contains 
		/// all information about the method signature.
		/// </summary>
		private MethodInfo info;

		public MethodSignature(MethodInfo aMethodInfo) {
			info = aMethodInfo;
		}

		public bool Match( Service anOtherService ) {
			return Info.Equals( anOtherService.Info );
		}

		public bool MatchContraVariant( Service anOtherService ) {
			return false;
		}

		#region Delegate MethodInfo
		public override MethodAttributes Attributes {
			get {
				return info.Attributes;
			}
		}

		public override CallingConventions CallingConvention {
			get {
				return info.CallingConvention;
			}
		}

		public override Type DeclaringType {
			get {
				return info.DeclaringType;
			}
		}

		public override MethodInfo GetBaseDefinition() {
			return info.GetBaseDefinition();
		}

		public override object[] GetCustomAttributes(bool inherit) {
			return info.GetCustomAttributes(inherit);
		}

		public override object[] GetCustomAttributes(Type attributeType, bool inherit) {
			return info.GetCustomAttributes(attributeType, inherit);
		}

		public override MethodImplAttributes GetMethodImplementationFlags() {
			return info.GetMethodImplementationFlags();
		}

		public override ParameterInfo[] GetParameters() {
			return info.GetParameters();
		}

		public override object Invoke(object obj, BindingFlags invokeAttr, Binder binder, object[] parameters, System.Globalization.CultureInfo culture) {
			return info.Invoke(obj, invokeAttr, binder, parameters, culture);
		}

		public override bool IsDefined(Type attributeType, bool inherit) {
			return info.IsDefined(attributeType, inherit);
		}

		public override MemberTypes MemberType {
			get {
				return info.MemberType;
			}
		}

		public override RuntimeMethodHandle MethodHandle {
			get {
				return info.MethodHandle;
			}
		}

		public override string Name {
			get {
				return info.Name;
			}
		}

		public override Type ReflectedType {
			get {
				return info.ReflectedType;
			}
		}

		public override Type ReturnType {
			get {
				return info.ReturnType;
			}
		}

		public override ICustomAttributeProvider ReturnTypeCustomAttributes {
			get {
				return info.ReturnTypeCustomAttributes;
			}
		}

		#endregion
	}
}

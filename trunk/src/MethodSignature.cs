using System;
using System.Reflection;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// Signature of a service.
	/// </summary>
	public class MethodSignature : AbstractSignature
	{

		#region Data

		private MethodInfo info;
		#endregion


		#region Properties

		public MethodInfo Info
		{
			get { return info; }
		}

		public override string Name
		{
			get
			{
				return Info.Name;
			}
		}

		public Type ReturnType
		{
			get
			{
				return Info.ReturnType;
			}
		}
		#endregion


		#region Constructors

		public MethodSignature( MethodInfo anInfo ) 
		{
			info = anInfo;
		}

		public MethodSignature( MethodSignature aSig ) : this (aSig.Info) {}

		#endregion


		#region Methods

		public override object Clone()
		{
			return new MethodSignature(this);
		}

		public override bool Equals(object obj)
		{
			if (obj is MethodSignature) 
			{
				MethodSignature sig = (MethodSignature) obj;
				return sig.Match(this);
			}
			return false;
		}

		#endregion
	}
}

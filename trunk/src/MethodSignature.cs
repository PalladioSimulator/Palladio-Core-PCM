using System;
using System.Reflection;
using System.Collections;

namespace Palladio.ComponentModel 
{
	/// <summary>
	/// A MethodSignature describes the structure of a method, function or
	/// procedure using the .Net reflection API.
	/// </summary>
	public class MethodSignature : AbstractSignature
	{
		#region Properties

		/// <summary>
		/// Method description of the .Net reflection API.
		/// </summary>
		public MethodInfo Info
		{
			get { return info; }
		}

		/// <summary>
		/// The name of the signature without any additional
		/// information like the return type or parameters.
		/// </summary>
		public override string Name
		{
			get
			{
				return Info.Name;
			}
		}

		/// <summary>
		/// Type of the return value.
		/// </summary>
		public override Type ReturnType
		{
			get
			{
				return Info.ReturnType;
			}
		}

		/// <summary>
		/// Parameters required by this signature. If
		/// no parameters are needed Parameters is set to 'null'.
		/// </summary>
		public override ParameterInfo[] Parameters
		{
			get
			{
				return Info.GetParameters();
			}
		}

		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new MethodSignature(this);
		}

		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
		public override bool Equals(object obj)
		{
			if (obj is MethodSignature) 
			{
				MethodSignature sig = (MethodSignature) obj;
				return sig.Match(this);
			}
			return false;
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return base.GetHashCode ();
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new MethodSignature using the information of the .Net
		/// reflection API.
		/// </summary>
		/// <param name="anInfo">Information provided by the .Net reflection API.</param>
		public MethodSignature( MethodInfo anInfo ) 
		{
			info = anInfo;
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aSig">Signature to copy.</param>
		public MethodSignature( MethodSignature aSig ) : this (aSig.Info) {}

		#endregion

		#region Data

		private MethodInfo info;
		#endregion
	}
}

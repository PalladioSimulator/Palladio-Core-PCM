using System;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Simple implementation of the ISignature interface.
	/// </summary>
	public class SimpleSignature : AbstractSignature
	{
		#region Properties

		/// <summary>
		/// The name of the signature without any additional
		/// information like the return type or parameters.
		/// </summary>
		public override string Name
		{
			get
			{
				return name;
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
			return new SimpleSignature(this);
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
			if (obj is SimpleSignature)
			{
				SimpleSignature sig = (SimpleSignature)obj;
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
		/// Creates a new Signature with the name aName.
		/// </summary>
		/// <param name="aName">Name of the new Signature.</param>
		public SimpleSignature(string aName)
		{
			name = aName;
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aSig">Signature to copy.</param>
		public SimpleSignature(SimpleSignature  aSig) : this(aSig.Name) 
		{
		}
		#endregion

		#region Data
		
		private string name;
		#endregion
	}
}

using System;
using System.Collections;
using Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Implements an equal - match for signatures.
	/// </summary>
	public class EqualsSigMatch : AbstractSigMatch 
	{

		#region Methods

		/// <summary>
		/// Checks whether aSig matches anotherSig. What a match
		/// means exactly depends on the implementation. The signatures
		/// can be equal, contravariant or whatever is required.
		/// </summary>
		/// <param name="aSig">First signature for the matching.</param>
		/// <param name="anotherSig">Second signature for the matching.</param>
		/// <returns>True if both signatures are equal, contravariant or match somehow.</returns>
		public override bool Match(ISignature aSig, ISignature anotherSig)
		{
			return aSig.Equals(anotherSig);
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public override object Clone()
		{
			return new EqualsSigMatch(this);
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
			if (obj is EqualsSigMatch)
			{
				base.Equals(obj);
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

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return "EqualsSigMatch";
		}

		#endregion

		#region Constructors

		/// <summary>
		/// Creates a new EqualsSigMatch.
		/// </summary>
		public EqualsSigMatch ()
		{
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aEqualsSigMatch">EqualsSigMatch to copy.</param>
		public EqualsSigMatch( EqualsSigMatch aEqualsSigMatch ) :
			this ( )
		{
		}

		#endregion
	}
}

using System;
using System.Collections;
using Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Implementation of the methods and properties common to all 
	/// implementation of ISignature.
	/// </summary>
	public abstract class AbstractSignature	: ISignature
	{

		#region Properties

		/// <summary>
		/// The name of the signature without any additional
		/// information like the return type or parameters.
		/// </summary>
		public abstract string Name 
		{
			get;
		}

		/// <summary>
		/// Type of the return value.
		/// </summary>
		public virtual Type ReturnType
		{
			get { return null; }
		}

		/// <summary>
		/// Parameters required by this signature. If
		/// no parameters are needed Parameters is set to 'null'.
		/// </summary>
		public virtual ParameterInfo[] Parameters
		{
			get { return null; }
		}
		#endregion

		#region Methods

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public abstract object Clone();

		/// <summary>
		/// Checks whether this signature matches aSig. A match not 
		/// only means that the types of both signatures are equal, but
		/// also that they are contravariant.
		/// </summary>
		/// <param name="aSig">An other signature.</param>
		/// <returns>True if both signatures are equal or contravariant.</returns>
		public bool Match(ISignature aSig)
		{
			return (aSig.Name == this.Name);
		}

		/// <summary>
		/// Checks whether this signature has any matches in aSigList and
		/// returns them in aMatchList.
		/// </summary>
		/// <param name="aSigList">List of ISignatures.</param>
		/// <param name="aMatchList">List of ISignatures matching this signature.</param>
		/// <returns>True if one or more signature were found, false otherwise.</returns>
		public bool HasMatches(IList aSigList, out IList aMatchList)
		{
			aMatchList = new Vector();
			foreach (ISignature sig in aSigList) 
			{
				if (this.Match(sig)) 
				{
					aMatchList.Add(sig);
				}
			}
			return (aMatchList.Count != 0);
		}

		/// <summary>
		/// Checks whether this signature has any matches in aSigList
		/// </summary>
		/// <param name="aSigList">List of ISignatures.</param>
		/// <returns>True if one or more signature were found, false otherwise.</returns>
		public bool HasMatches(IList aSigList)
		{
			IList matchList;
			return HasMatches(aSigList, out matchList);
		}

		/// <summary>
		/// Checks whether this signature has exactly one match in aSigList.
		/// </summary>
		/// <param name="aSigList">List of ISignatures</param>
		/// <returns>True if exactly one match was found, false otherwise.</returns>
		public bool HasOneMatch(IList aSigList)
		{
			ISignature match;
			return HasOneMatch(aSigList, out match);
		}

		/// <summary>
		/// Checks whether this signature has exactly one match in aSigList and
		/// returns it as aMatch.
		/// </summary>
		/// <param name="aSigList">List of ISignatures</param>
		/// <param name="aMatch">The match of this signature in aSigList.</param>
		/// <returns>True if exactly one match was found, false otherwise.</returns>
		public bool HasOneMatch(IList aSigList, out ISignature aMatch)
		{
			aMatch = null;
			IList matchList;
			if (HasMatches(aSigList, out matchList) && (matchList.Count == 1))
			{
				aMatch = (ISignature) matchList[0];
				return true;
			}
			return false;
		}

		/// <summary>
		/// Retrieves a string representation of the object.
		/// </summary>
		/// <returns>String representation of the object.</returns>
		public override string ToString()
		{
			return Name;
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
			if (obj is ISignature) 
			{
				return ( ((ISignature)obj).Name == this.Name );
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
			return this.Name.GetHashCode();
		}

		#endregion
	}
}

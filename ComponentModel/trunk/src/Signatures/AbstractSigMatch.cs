using System;
using System.Collections;
using Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// </summary>
	public abstract class AbstractSigMatch	: ISigMatch
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
		public abstract bool Match(ISignature aSig, ISignature anotherSig);

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public abstract object Clone();

		/// <summary>
		/// Checks whether aSig has any matches in aSigList and
		/// returns them in aMatchList.
		/// </summary>
		/// <param name="aSig">Signature to matche with aSigList.</param>
		/// <param name="aSigList">List of ISignatures.</param>
		/// <param name="aMatchList">List of ISignatures matching this signature.</param>
		/// <returns>True, if one or more signature were found, false otherwise.</returns>
		public bool HasMatches(ISignature aSig, IList aSigList, out IList aMatchList)
		{
			aMatchList = new Vector();
			foreach (ISignature sig in aSigList) 
			{
				if (Match(aSig, sig)) 
				{
					aMatchList.Add(sig);
				}
			}
			return (aMatchList.Count != 0);
		}

		/// <summary>
		/// Checks whether this signature has any matches in aSigList
		/// </summary>
		/// <param name="aSig">Signature to matche with aSigList.</param>
		/// <param name="aSigList">List of ISignatures.</param>
		/// <returns>True if one or more signature were found, false otherwise.</returns>
		public bool HasMatches(ISignature aSig, IList aSigList)
		{
			IList matchList;
			return HasMatches(aSig, aSigList, out matchList);
		}

		/// <summary>
		/// Checks whether this signature has exactly one match in aSigList.
		/// </summary>
		/// <param name="aSig">Signature to matche with aSigList.</param>
		/// <param name="aSigList">List of ISignatures</param>
		/// <returns>True, if exactly one match was found, false otherwise.</returns>
		public bool HasOneMatch(ISignature aSig, IList aSigList)
		{
			ISignature match;
			return HasOneMatch(aSig, aSigList, out match);
		}

		/// <summary>
		/// Checks whether this signature has exactly one match in aSigList and
		/// returns it as aMatch.
		/// </summary>
		/// <param name="aSig">Signature to matche with aSigList.</param>
		/// <param name="aSigList">List of ISignatures</param>
		/// <param name="aMatch">The match of this signature in aSigList.</param>
		/// <returns>True if exactly one match was found, false otherwise.</returns>
		public bool HasOneMatch(ISignature aSig, IList aSigList, out ISignature aMatch)
		{
			aMatch = null;
			IList matchList;
			if (HasMatches(aSig, aSigList, out matchList) && (matchList.Count == 1))
			{
				aMatch = (ISignature) matchList[0];
				return true;
			}
			return false;
		}

		#endregion
	}
}

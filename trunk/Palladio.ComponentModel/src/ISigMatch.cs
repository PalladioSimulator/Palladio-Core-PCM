using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// ISigMatch describes a simple algebra vor Signatures. It allows
	/// you to implement different versions of matching algorithms to 
	/// satisfy a wide range of requirements.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 13:50:51  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public interface ISigMatch
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
		bool Match(ISignature aSig, ISignature anotherSig);

		/// <summary>
		/// Checks whether aSig has any matches in aSigList and
		/// returns them in aMatchList.
		/// </summary>
		/// <param name="aSig">Signature to matche with aSigList.</param>
		/// <param name="aSigList">List of ISignatures.</param>
		/// <param name="aMatchList">List of ISignatures matching this signature.</param>
		/// <returns>True, if one or more signature were found, false otherwise.</returns>
		bool HasMatches(ISignature aSig, IList aSigList, out IList aMatchList);

		/// <summary>
		/// Checks whether this signature has any matches in aSigList
		/// </summary>
		/// <param name="aSig">Signature to matche with aSigList.</param>
		/// <param name="aSigList">List of ISignatures.</param>
		/// <returns>True if one or more signature were found, false otherwise.</returns>
		bool HasMatches(ISignature aSig, IList aSigList);

		/// <summary>
		/// Checks whether this signature has exactly one match in aSigList.
		/// </summary>
		/// <param name="aSig">Signature to matche with aSigList.</param>
		/// <param name="aSigList">List of ISignatures</param>
		/// <returns>True, if exactly one match was found, false otherwise.</returns>
		bool HasOneMatch(ISignature aSig, IList aSigList);

		/// <summary>
		/// Checks whether this signature has exactly one match in aSigList and
		/// returns it as aMatch.
		/// </summary>
		/// <param name="aSig">Signature to matche with aSigList.</param>
		/// <param name="aSigList">List of ISignatures</param>
		/// <param name="aMatch">The match of this signature in aSigList.</param>
		/// <returns>True if exactly one match was found, false otherwise.</returns>
		bool HasOneMatch(ISignature aSig, IList aSigList, out ISignature aMatch);
		#endregion
	}
}

using System;
using System.Collections;
using Utils.Collections;
using System.Reflection;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A Signature describes the structure of a method, function or
	/// procedure.
	/// </summary>
	public interface ISignature : ICloneable 
	{
		#region Properties

		/// <summary>
		/// The name of the signature without any additional
		/// information like the return type or parameters.
		/// </summary>
		string Name 
		{
			get;
		}

		/// <summary>
		/// Type of the return value.
		/// </summary>
		Type ReturnType
		{
			get;
		}

		/// <summary>
		/// Parameters required by this signature. If
		/// no parameters are needed Parameters is set to 'null'.
		/// </summary>
		ParameterInfo[] Parameters
		{
			get;
		}
		#endregion

		#region Methods

		/// <summary>
		/// Checks whether this signature matches aSig. A match not 
		/// only means that the types of both signatures are equal, but
		/// also that they are contravariant.
		/// </summary>
		/// <param name="aSig">An other signature.</param>
		/// <returns>True if both signatures are equal or contravariant.</returns>
		bool Match(ISignature aSig);

		/// <summary>
		/// Checks whether this signature has any matches in aSigList and
		/// returns them in aMatchList.
		/// </summary>
		/// <param name="aSigList">List of ISignatures.</param>
		/// <param name="aMatchList">List of ISignatures matching this signature.</param>
		/// <returns>True if one or more signature were found, false otherwise.</returns>
		bool HasMatches(IList aSigList, out IList aMatchList);

		/// <summary>
		/// Checks whether this signature has any matches in aSigList
		/// </summary>
		/// <param name="aSigList">List of ISignatures.</param>
		/// <returns>True if one or more signature were found, false otherwise.</returns>
		bool HasMatches(IList aSigList);

		/// <summary>
		/// Checks whether this signature has exactly one match in aSigList.
		/// </summary>
		/// <param name="aSigList">List of ISignatures</param>
		/// <returns>True if exactly one match was found, false otherwise.</returns>
		bool HasOneMatch(IList aSigList);

		/// <summary>
		/// Checks whether this signature has exactly one match in aSigList and
		/// returns it as aMatch.
		/// </summary>
		/// <param name="aSigList">List of ISignatures</param>
		/// <param name="aMatch">The match of this signature in aSigList.</param>
		/// <returns>True if exactly one match was found, false otherwise.</returns>
		bool HasOneMatch(IList aSigList, out ISignature aMatch);

		#endregion
	}
}

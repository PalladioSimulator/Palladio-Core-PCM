using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Error indicating, that there exist multiple matches for anOriginalSig.
	/// </summary>
	public class AmbiguousMatchError : IInclusionError
	{
		#region Properties

		/// <summary>
		/// ErrorLevel indicating how serious the
		/// error is.
		/// </summary>
		public int ErrorLevel
		{
			get
			{
				return 0;
			}
		}

		/// <summary>
		/// Message discribing the error.
		/// </summary>
		public string Message
		{
			get
			{
				string result = "Ambiguous match found for "+originalSig+": ";
				bool first = true;
				foreach (ISignature sig in matchSigList) 
				{
					if (first) 
					{
						result += sig;
					} 
					else 
					{
						result += ", "+sig;
					}
				}
				return result;
			}
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Error indicating, that there exist multiple matches for anOriginalSig.
		/// </summary>
		/// <param name="anOriginalSig">Signature wich is required.</param>
		/// <param name="aMatchSigList">List of possible matches.</param>
		public AmbiguousMatchError(ISignature anOriginalSig, IList aMatchSigList)
		{
			originalSig = anOriginalSig;
			matchSigList = aMatchSigList;
		}
		#endregion

		#region Data

		private ISignature	originalSig;
		private IList		matchSigList;
		#endregion
	}
}

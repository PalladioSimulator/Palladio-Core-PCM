using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für AmbiguousMatchError.
	/// </summary>
	public class AmbiguousMatchError : IInclusionError
	{
		ISignature	originalSig;
		IList		matchSigList;

		public AmbiguousMatchError(ISignature anOriginalSig, IList aMatchSigList)
		{
			originalSig = anOriginalSig;
			matchSigList = aMatchSigList;
		}

		#region IInclusionError Member

		public int ErrorLevel
		{
			get
			{
				return 0;
			}
		}

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
	}
}

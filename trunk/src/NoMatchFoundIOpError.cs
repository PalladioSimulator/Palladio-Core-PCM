using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für NoMatchFoundError.
	/// </summary>
	public class NoMatchFoundError  : IInclusionError
	{
		ISignature signature;

		public NoMatchFoundError(ISignature aSignature)
		{
			signature = aSignature;
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
				return "No match found for: "+signature;
			}
		}

		#endregion
	}
}

using System;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// This error occures if a signature is required in
	/// an interface, but no match can be found.
	/// </summary>
	public class NoMatchFoundError  : IInclusionError
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
				return "No match found for: "+signature;
			}
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Error indicating, that aSignature could not be matched.
		/// </summary>
		/// <param name="aSignature">Signature that could not be matched.</param>
		public NoMatchFoundError(ISignature aSignature)
		{
			signature = aSignature;
		}
		#endregion
		
		#region Data

		private ISignature signature;
		#endregion
	}
}

using System;

namespace Palladio.Webserver.HTTPRequestParser
{
	/// <summary>
	/// NoValidRequestTypeException.
	/// Thrown e. g. if GET was called but only POST is supported.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/05/01 18:27:44  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.1  2004/11/01 07:42:16  kelsaka
	/// *** empty log message ***
	///
	/// </pre>
	/// </remarks>
	public class NoValidRequestTypeException : Exception
	{
		/// <summary>
		/// default constructor.
		/// </summary>
		public NoValidRequestTypeException()
		{

		}
	}
}

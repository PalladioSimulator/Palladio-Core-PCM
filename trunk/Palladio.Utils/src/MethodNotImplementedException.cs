using System;

namespace Palladio.Utils.Exceptions 
{
	/// <summary>
	/// This exception is thrown, if the called method is not
	/// implemented by a class.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/02/21 12:16:30  joemal
	/// initial import
	///
	///
	/// </pre>
	/// </remarks>
	public class MethodNotImplementedException : ApplicationException 
	{
		/// <summary>
		/// This exception is thrown, if the called method is not
		/// implemented by a class.
		/// </summary>
		public MethodNotImplementedException()
		{
		}
	}
}

using System;

namespace MySmallWebServer.MyServerException
{
	/// <summary>
	///  MyFatalServerException is thrown when something really bad happend
	///  on the server. The Server must be stopped then.
	/// </summary>
	public class MyFatalServerException : Exception
	{
		/// <summary>
		/// Initates an empty Exception
		/// </summary>
		public MyFatalServerException()
		{
		}
	}
}

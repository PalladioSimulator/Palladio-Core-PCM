using System;

namespace MySmallWebServer.MyServerException
{
	/// <summary>
	///  MyFatalServerException is thrown when something really bad happend
	///  on the server.
	/// </summary>
	public class MyFatalServerException : Exception
	{
		/// <summary>
		/// Initates an empty Exception
		/// </summary>
		public MyFatalServerException()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}
//		public void sendError(string kindOfError,ClientRequest r)
//		{
//			Console.WriteLine("send Error");
//			Console.WriteLine(httpCode);
//			SendHeader(sHttpVersion,  "", kindOfError.Length, httpCode , ref hereToSend);
//			SendToBrowser (kindOfError, ref hereToSend);
//			Console.WriteLine("Closing Connection");
//			hereToSend.Close();
//			return;
//		}
	}
}

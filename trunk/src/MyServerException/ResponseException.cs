using System;

namespace MySmallWebServer.MyServerException
{
	/// <summary>
	/// ResponseException It is thrown when there where Problems to answer the request
	/// </summary>
	public class ResponseException : Exception
	{
		/// <summary>
		/// Creates an <code>ResponseException</code> for a given client request
		/// </summary>
		/// <param name="r">A <code>ClientRequest</code> which could not have been answered</param>
		public ResponseException(ClientRequest r)
		{
			SendToClient s = new SendToClient();
		}
	}
}

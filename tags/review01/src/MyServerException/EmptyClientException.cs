using System;
using MySmallWebServer;

namespace MySmallWebServer.MyServerException
{
	/// <summary>
	/// Zusammenfassung für EmptyClientException.
	/// </summary>
	public class MyEmptyClientException : MyFatalServerException
	{
		
	
		/// <summary>
		/// 
		/// </summary>
		/// <param name="aClientRequest"></param>
		/// <param name="AnErrorCode"></param>
		/// <param name="aMessage"></param>
		public MyEmptyClientException(ClientRequest aClientRequest, string AnErrorCode)
		{
			ClientResponse res = new ClientResponse(aClientRequest);
			res.StatusCode = AnErrorCode;
			res.MessageToSend = "";
			SendToClient sender = new SendToClient();
			sender.sendError(res.MessageToSend,AnErrorCode,res);
			
		}
	}
}

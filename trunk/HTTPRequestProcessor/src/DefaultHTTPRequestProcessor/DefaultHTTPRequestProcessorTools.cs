using System;
using System.Net.Sockets;
using System.Text;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.HTTPRequestProcessor
{
	/// <summary>
	/// DefaultHTTPRequestProcessorTools.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/10/30 11:42:08  kelsaka
	/// Added full support for static websites using the get-method; added several test-documents; changed CoR for HTTP-Processing: dynamic files are delivered first
	///
	/// </pre>
	/// </remarks>
	public class DefaultHTTPRequestProcessorTools : IHTTPRequestProcessorTools
	{

		private IWebserverConfiguration webserverConfiguration;
		private IWebserverMonitor webserverMonitor;

		public DefaultHTTPRequestProcessorTools(IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			this.webserverConfiguration = webserverConfiguration;
			this.webserverMonitor = webserverMonitor;
		}




		/// <summary>
		/// This method sends the header information to the client.
		/// </summary>
		/// <param name="httpVersion">HTTP Version</param>
		/// <param name="mimeType">Mime Type of the content</param>
		/// <param name="totalBytes">Total Bytes to be sent in the body</param>
		/// <param name="httpStatusCode">Status Code of the HTTP-Answer.</param>
		/// <param name="socket">Socket reference</param>
		public void SendHTTPHeader(string httpVersion, string mimeType, int totalBytes, string httpStatusCode, Socket socket)
		{
			if(httpStatusCode != "")
			{
				httpStatusCode = " " + httpStatusCode; //add space between httpVersion and httpStatusCode
			}


			String headerContent = "";

			headerContent += httpVersion + httpStatusCode + "\r\n";
			headerContent += "Server: cx1193719-b\r\n"; //TODO: explain meaning
			headerContent += "Content-Type: " + mimeType + "\r\n";
			headerContent += "Accept-Ranges: bytes\r\n";
			headerContent += "Content-Length: " + totalBytes + "\r\n\r\n";			

			SendContentToClient(headerContent, socket);
		}




		/// <summary>
		/// Generates a standard HTTP-Error and sends it to the client.
		/// </summary>
		/// <param name="httpRequest">From the Client-Request.</param>
		/// <param name="errorMessage">The error Message to display to the client.</param>
		/// <param name="errorCode">The HTTP-Error-Code</param>
		public void SendHTTPError(IHTTPRequest httpRequest, string errorMessage, string errorCode)
		{
			webserverMonitor.WriteLogEntry("HTTP-Error Code " + errorCode + " | " + errorMessage);

			//Format The Message
			SendHTTPHeader(httpRequest.HttpVersion, "", errorMessage.Length, errorCode, httpRequest.Socket);

			//Send to the browser
			SendContentToClient(errorMessage, httpRequest.Socket);

		}


		/// <summary>
		/// Sends the data to the client.
		/// </summary>
		/// <param name="contentData">String that contains the answer to the client request.</param>
		/// <param name="socket">Socket reference</param>
		public void SendContentToClient(string contentData, Socket socket)
		{
			// convert string into byte-array so that it can be sent.			
			SendContentToClient(Encoding.ASCII.GetBytes(contentData), socket);
		}


		/// <summary>
		/// Sends the data to the client.
		/// </summary>
		/// <param name="contentDataBytes">Byte-array that contains the answer to the client request.</param>
		/// <param name="socket">Socket reference</param>
		public void SendContentToClient(byte[] contentDataBytes, Socket socket)
		{				
			int numberOfBytesSend = 0;

			
			try
			{
				if (socket.Connected)
				{
					// send data to client:
					numberOfBytesSend = socket.Send(contentDataBytes, contentDataBytes.Length, 0);
					
					if (numberOfBytesSend == -1)
					{
						webserverMonitor.WriteDebugMessage("Error: Socket Error. Packet was not sent.", 1);			
					}			
					else
					{
						webserverMonitor.WriteDebugMessage("Sent bytes to client: " + numberOfBytesSend, 1);
					}
				}
				else
				{
					webserverMonitor.WriteDebugMessage("Error: Socket is not connected.", 1);
				}
			}
			catch (Exception e)
			{
				webserverMonitor.WriteDebugMessage("Error: Error on sending data to client: " + e, 1);							
			}
		}




	}
}

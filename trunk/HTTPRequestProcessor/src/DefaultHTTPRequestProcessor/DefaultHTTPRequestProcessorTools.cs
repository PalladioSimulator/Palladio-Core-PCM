using System;
using System.IO;
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
	/// Revision 1.6  2004/12/15 00:32:33  sliver
	/// Thread handling changed:
	///   Instead of calling the Thread.Abort() method, each
	///   thread instance contains a variable IsRunning which is
	///   checked after each iteration through the loop.
	///   If it is set to false, the tread terminates. This has been introduced to
	///   establish a clean thread exit. The call of the Abort () method causes
	///   an exeption in the aborted thread. This execption is forwarded through
	///   the whole call stack, even if it is catched. So, every method on the stack
	///   is informed about the thread exit. However, this causes some trouble
	///   for the logging of the Webserver behaviour. Furthermore, the
	///   Thread.Abort() and Thread.Interrupt() methods do not terminate
	///   threads that are blocked. The call of the method TcpListener.AcceptSocket()
	///   blocks the thread until a new connection is opened. So, the running
	///   threads are not aborted until a new connection is opened.
	///
	///  Now, we proceed as follows to terminate the Webserver. For all
	///  listening treads, we set the IsRunning variable to false. Next, we need
	///  to unblock the threads. Therfore, we open a dummy connection to the
	///  IP and port the tread is listening on. When re-iterating the the loop, the
	///  check of the IsRunning variable causes the thread to terminate.
	///
	/// ListeningTread war renamed to PortListener
	/// interfaces 'IPortListener' and IBibTexDB' added
	///
	/// Revision 1.5  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.4  2004/10/31 16:30:40  kelsaka
	/// preparing parsing of post-requests
	///
	/// Revision 1.3  2004/10/30 15:24:39  kelsaka
	/// webserverMonitor-Output on console; documentation (doc) update
	///
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
			SendContentDataToClient(Encoding.ASCII.GetBytes(contentData), socket);
		}


		/// <summary>
		/// Sends the data to the client.
		/// </summary>
		/// <param name="contentDataBytes">Byte-array that contains the answer to the client request.</param>
		/// <param name="socket">Socket reference</param>
		public void SendContentDataToClient(byte[] contentDataBytes, Socket socket)
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
						webserverMonitor.WriteLogEntry("Sent bytes to client: " + numberOfBytesSend);
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



		/// <summary>
		/// Build the path to the actually requested file, either a relative or absolute path.
		/// (Uses the documentRoot from the webserver-configuration to build the complete path.)
		/// </summary>
		/// <param name="requestedPath">Build the complete path for this part of the request.</param>
		/// <returns>Path to file / directory requested.</returns>
		public string BuildCompletePath(string requestedPath)
		{
			return webserverConfiguration.DocumentRoot + requestedPath;
		}



		/// <summary>
		/// Returns the the MimeType for the specified file-type.
		/// </summary>
		/// <param name="requestedFileType">For this filetype you get the mimetype.</param>
		/// <returns>The mimetype. If no fitting mimetype was found the default type is returned.</returns>
		public string GetFileMimeTypeFor (string requestedFileType)
		{

			string fileMimeType;
			// Get the MimeType
			try
			{
				fileMimeType = webserverConfiguration.GetMimeTypeFor(requestedFileType);	
			}
			catch (ExtensionNotFoundException)
			{
				fileMimeType = webserverConfiguration.DefaultMimeType; // default-mimetype from configuration.
			}
			return fileMimeType;
		}



		/// <summary>
		/// Opens the file given by the path and the filename.
		/// </summary>
		/// <param name="completePath">The complete path directing to the specified filename.</param>
		/// <param name="fileName">The Filename that shall be opened.</param>
		/// <returns>The file's content a byte-array.</returns>
		public byte[] OpenFile (string completePath, string fileName)
		{
			FileStream fileStream = new FileStream(completePath + fileName, FileMode.Open, FileAccess.Read, FileShare.Read);
	
			// Create a reader that can read bytes from the FileStream: especially required for binary-files.
			BinaryReader reader = new BinaryReader(fileStream);
			byte[] bytes = new byte[fileStream.Length];
			int read;
	
			while(true) 
			{
				read = reader.Read(bytes, 0, bytes.Length);

				if(read == 0) //file completely read - so break loop.
				{
					break;
				}
			}
			reader.Close(); 
			fileStream.Close();
			return bytes;
		}



	}
}

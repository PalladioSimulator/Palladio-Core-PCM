using System;
using System.IO;
using System.Net.Sockets;
using System.Text;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.StaticFileProvider
{
	/// <summary>
	/// StaticFileProvider.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2004/10/29 16:30:39  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.3  2004/10/27 05:52:49  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.2  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class StaticFileProvider : IHTTPRequestProcessor
	{

		IWebserverMonitor webserverMonitor;
		IWebserverConfiguration webserverConfiguration;
		IHTTPRequestProcessor corSuccessor;

		public StaticFileProvider(IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.corSuccessor = corSuccessor;
		}

		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		public void handleRequest (IHTTPRequest httpRequest)
		{



			string sRequestedFile = httpRequest.RequestedFileName;
			String sErrorMessage;
			String sLocalDir;
			String sMyWebServerRoot = webserverConfiguration.DocumentRoot;
			String sPhysicalFilePath = "";
			String sFormattedMessage = "";
			String sResponse = "";
			
			/////////////////////////////////////////////////////////////////////
			// Identify the Physical Directory
			/////////////////////////////////////////////////////////////////////
			//if ( httpRequest.RequestedDirectoyName == "/")
				sLocalDir = sMyWebServerRoot;
			/*else
			{
				//Get the Virtual Directory
				sLocalDir = GetLocalPath(sMyWebServerRoot, httpRequest.RequestedDirectoyName);
			}*/


			Console.WriteLine("Directory Requested : " +  sLocalDir);

			//If the physical directory does not exists then
			// dispaly the error message
			if (sLocalDir.Length == 0 )
			{
				sErrorMessage = "<H2>Error!! Requested Directory does not exists</H2><Br>";
				//sErrorMessage = sErrorMessage + "Please check data\\Vdirs.Dat";

				//Format The Message
				SendHeader(httpRequest.HttpVersion,  "", sErrorMessage.Length, " 404 Not Found", httpRequest.Socket);

				//Send to the browser
				SendToBrowser(sErrorMessage, httpRequest.Socket);

				httpRequest.Socket.Close();

				//continue;
			}

			
			/////////////////////////////////////////////////////////////////////
			// Identify the File Name
			/////////////////////////////////////////////////////////////////////

			//If The file name is not supplied then look in the default file list
			if (sRequestedFile.Length == 0 )
			{
				// Get the default filename
				sRequestedFile = webserverConfiguration.DefaultFileNames[0]; // GetTheDefaultFileName(sLocalDir);

				if (sRequestedFile == "")
				{
					sErrorMessage = "<H2>Error!! No Default File Name Specified</H2>";
					SendHeader(httpRequest.HttpVersion,  "", sErrorMessage.Length, " 404 Not Found", httpRequest.Socket);
					SendToBrowser ( sErrorMessage, httpRequest.Socket);

					httpRequest.Socket.Close();

					return;

				}
			}

			


			/////////////////////////////////////////////////////////////////////
			// Get TheMime Type
			/////////////////////////////////////////////////////////////////////


			String fileMimeType;
			try
			{
				fileMimeType = webserverConfiguration.GetMimeTypeFor(httpRequest.RequestedFileType);	
			}
			catch (ExtensionNotFoundException)
			{
				fileMimeType = webserverConfiguration.DefaultMimeType; // default-mimetype from configuration.
			}
			



			//Build the physical path
			sPhysicalFilePath = sLocalDir + sRequestedFile;
			Console.WriteLine("File Requested : " +  sPhysicalFilePath);
			
			
			if (File.Exists(sPhysicalFilePath) == false)
			{
			
				sErrorMessage = "<H2>404 Error! File Does Not Exists...</H2>";
				SendHeader(httpRequest.HttpVersion, "", sErrorMessage.Length, " 404 Not Found", httpRequest.Socket);
				SendToBrowser( sErrorMessage,httpRequest.Socket);

				Console.WriteLine(sFormattedMessage);
			}
		
			else
			{
				int iTotBytes=0;

				sResponse ="";

				FileStream fs = new FileStream(sPhysicalFilePath, FileMode.Open, FileAccess.Read, FileShare.Read);
				// Create a reader that can read bytes from the FileStream.

				
				BinaryReader reader = new BinaryReader(fs);
				byte[] bytes = new byte[fs.Length];
				int read;
				while((read = reader.Read(bytes, 0, bytes.Length)) != 0) 
				{
					// Read from the file and write the data to the network
					sResponse = sResponse + Encoding.ASCII.GetString(bytes,0,read);

					iTotBytes = iTotBytes + read;

				}
				reader.Close(); 
				fs.Close();

				SendHeader(httpRequest.HttpVersion, fileMimeType, iTotBytes, " 200 OK", httpRequest.Socket);
				SendToBrowser(bytes, httpRequest.Socket);
				//mySocket.Send(bytes, bytes.Length,0);
			}
			

					
					


		}


//TODO: ####### "stolen code":

		/// <summary>
		/// This function send the Header Information to the client (Browser)
		/// </summary>
		/// <param name="sHttpVersion">HTTP Version</param>
		/// <param name="sMIMEHeader">Mime Type</param>
		/// <param name="iTotBytes">Total Bytes to be sent in the body</param>
		/// <param name="mySocket">Socket reference</param>
		/// <returns></returns>
		public void SendHeader(string sHttpVersion, string sMIMEHeader, int iTotBytes, string sStatusCode, Socket mySocket)
		{

			String sBuffer = "";
			
			// if Mime type is not provided set default to text/html
			if (sMIMEHeader.Length == 0 )
			{
				sMIMEHeader = "text/html";  // Default Mime Type is text/html
			}

			sBuffer = sBuffer + sHttpVersion + sStatusCode + "\r\n";
			sBuffer = sBuffer + "Server: cx1193719-b\r\n";
			sBuffer = sBuffer + "Content-Type: " + sMIMEHeader + "\r\n";
			sBuffer = sBuffer + "Accept-Ranges: bytes\r\n";
			sBuffer = sBuffer + "Content-Length: " + iTotBytes + "\r\n\r\n";
			
			Byte[] bSendData = Encoding.ASCII.GetBytes(sBuffer); 

			SendToBrowser( bSendData, mySocket);

			Console.WriteLine("Total Bytes : " + iTotBytes.ToString());

		}



		/// <summary>
		/// Overloaded Function, takes string, convert to bytes and calls 
		/// overloaded sendToBrowserFunction.
		/// </summary>
		/// <param name="sData">The data to be sent to the browser(client)</param>
		/// <param name="mySocket">Socket reference</param>
		public void SendToBrowser(String sData, Socket mySocket)
		{
			SendToBrowser (Encoding.ASCII.GetBytes(sData), mySocket);
		}



		/// <summary>
		/// Sends data to the browser (client)
		/// </summary>
		/// <param name="bSendData">Byte Array</param>
		/// <param name="mySocket">Socket reference</param>
		public void SendToBrowser(Byte[] bSendData,Socket mySocket)
		{
			int numBytes = 0;
			
			try
			{
				if (mySocket.Connected)
				{
					if (( numBytes = mySocket.Send(bSendData, bSendData.Length,0)) == -1)
						Console.WriteLine("Socket Error cannot Send Packet");
					else
					{
						Console.WriteLine("No. of bytes send {0}" , numBytes);
					}
				}
				else
					Console.WriteLine("Connection Dropped....");
			}
			catch (Exception  e)
			{
				Console.WriteLine("Error Occurred : {0} ", e );
							
			}
		}

	}
}

using System;
using System.Net.Sockets;
using System.Text;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver.HTTPRequestParser
{
	/// <summary>
	/// HTTPRequestParser.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.8  2004/10/30 15:24:39  kelsaka
	/// webserverMonitor-Output on console; documentation (doc) update
	///
	/// Revision 1.7  2004/10/29 16:30:38  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.6  2004/10/28 07:54:43  kelsaka
	/// -
	///
	/// Revision 1.5  2004/10/27 15:05:06  kelsaka
	/// added more request handling-abilities
	///
	/// Revision 1.4  2004/10/27 05:52:48  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.3  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.2  2004/10/21 15:02:02  kelsaka
	/// added some more interfaces
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class HTTPRequestParser : IRequestParser
	{

		private IWebserverMonitor webserverMonitor;
		private IWebserverConfiguration webserverConfiguration;
		private IHTTPRequestProcessor requestProcessor;
		private IRequestParser corSuccessor;

		public HTTPRequestParser(IHTTPRequestProcessor requestProcessor, IRequestParser corSuccessor, IWebserverMonitor webserverMonitor,  IWebserverConfiguration webserverConfiguration)
		{
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;		
			this.requestProcessor = requestProcessor;
			this.corSuccessor = corSuccessor;
		}



		/// <summary>
		/// Starts the Parsing-Process of the given request.
		/// </summary>
		/// <param name="request">The request that is going to be parsed.</param>
		public void HandleRequest (IRequest request)
		{
			// default starting position:
			int httpStartPos = 0;

			// Save the parsing-results into the IHTTP-Request
			IHTTPRequest httpRequest = new DefaultHTTPRequest();
			httpRequest.Socket = request.Socket;



			//make a byte array and receive data from the client 
			Byte[] bReceive = new Byte[1024];
			int i = request.Socket.Receive(bReceive, bReceive.Length, 0);

			// Convert Byte[] to String
			string requestStringBuffer = Encoding.ASCII.GetString(bReceive);
	



			// Look for HTTP request
			httpStartPos = requestStringBuffer.IndexOf("HTTP",1);

			// Call the CoR-Successor, if the request is not a HTTP-Request. The HTTP-Parser is not the right chain
			// for this request.
			// The HandleRequest-Method is called, as it is the standard way for the IRequest-Chain.
			if(httpStartPos == -1)
			{
				webserverMonitor.WriteLogEntry("Calling the COR-Successor as the actual request is not a HTTP-Request.");
				corSuccessor.HandleRequest(request);
			}

			// Get the HTTP text and version e.g. it will return "HTTP/1.1"
			httpRequest.HttpVersion = requestStringBuffer.Substring(httpStartPos, 8);
			webserverMonitor.WriteLogEntry("HTTP-request has version " + httpRequest.HttpVersion);



			// get the http-request-type (e. g. post, get):
			try
			{
				httpRequest.RequestedMethodType = parseRequestMethod(requestStringBuffer);
			}
			catch (NoValidRequestTypeException)
			{
				request.Socket.Close();
				webserverMonitor.WriteDebugMessage("Error: No valid http-request-type (GET, POST) found. Socket closed.", 1);
			}


			// sets the filename and the directory of the requested file in the httpRequest:
			setFilenameAndDirectoryInRequest (requestStringBuffer, httpStartPos, httpRequest);



			// parse file-type (e. g. ".html") out of the filename.
			httpRequest.RequestedFileType = parseFileType(httpRequest.RequestedFileName);



			// Handle IHTTPRequest in the requestProcessor. The httpRequest contains all necessary (parsed) data.
			requestProcessor.handleRequest(httpRequest);

		}


		/// <summary>
		/// Parses the FileType out of the given FileName (file-extension) and returns it.
		/// </summary>
		/// <param name="requestedFileName">String to parse. It has the form of e. g. "index.XXXX.YYYY.html"</param>
		/// <returns>In the example this would return ".html". - the substring beginning with the last occourence of '.'.
		/// If no valid fileType is found an empty string will be returned.</returns>
		private string parseFileType (string requestedFileName)
		{
			// searches for the last occurence of '.' and returns the remaining string, beginning with the
			// last '.' found, like e. g. ".html".
			try 
			{
				return requestedFileName.Substring(requestedFileName.LastIndexOf('.'), requestedFileName.Length - requestedFileName.LastIndexOf("."));
			}
			catch (ArgumentOutOfRangeException)
			{
				return ""; //Probably no special filetype available - return nothing but an empty string.
			}
		}


		/// <summary>
		/// Parses the requeststring for the requested filename and directory and sets it in the httpRequest.
		/// </summary>
		/// <param name="requestStringBuffer">String to parse.</param>
		/// <param name="httpStartPos">Position where the http-request starts.</param>
		/// <param name="httpRequest">The httpRequest where filename and directoy are set.</param>
		private void setFilenameAndDirectoryInRequest (string requestStringBuffer, int httpStartPos, IHTTPRequest httpRequest)
		{
			string requestedFileOrDirectory;
			string variables;

			
			// Extract the Requested Type and Requested file/directory
			requestedFileOrDirectory = requestStringBuffer.Substring(0, httpStartPos - 1);
	
	
			// Replace backslashes by forwardslashes
			requestedFileOrDirectory.Replace("\\", "/");
	
	
			//If file name is not supplied add forward slash to indicate 
			//that it is a directory and then we will look for the 
			//default file name..
			if ((requestedFileOrDirectory.IndexOf(".") <1) && (!requestedFileOrDirectory.EndsWith("/")))
			{
				requestedFileOrDirectory = requestedFileOrDirectory + "/"; 
			}
	
	
			//Extract the requested file name, in this step including "?xxxxx=aaaaa".
			httpStartPos = requestedFileOrDirectory.LastIndexOf("/") + 1;
			httpRequest.RequestedFileName = requestedFileOrDirectory.Substring(httpStartPos);


			// remove "?xxxxxx=aaaa.." from the string and save this part to variables.
			int qmarkPosition = httpRequest.RequestedFileName.IndexOf('?');
			if (qmarkPosition != -1)
			{								
				// first save variables-string:
				variables = httpRequest.RequestedFileName.Substring(qmarkPosition, httpRequest.RequestedFileName.Length - qmarkPosition);
				parseVariablesAndAddToHTTPRequest(variables, httpRequest);

				// second: remove variables-part from the RequestedFileName-string:
				httpRequest.RequestedFileName = httpRequest.RequestedFileName.Substring(0, qmarkPosition);
			}



	

			//Extract The directory Name
			httpRequest.RequestedDirectoyName = requestedFileOrDirectory.Substring(requestedFileOrDirectory.IndexOf("/"), requestedFileOrDirectory.LastIndexOf("/")-3);
	
			webserverMonitor.WriteLogEntry("Requested directory | file: " + httpRequest.RequestedDirectoyName + " | " + httpRequest.RequestedFileName);
		}


		/// <summary>
		/// Parses the string containing the variables of a GET-request (like e. g. "?xxxxx=aaaaa&yyyyy=bbbbb&..".
		/// The result it saved to the httpRequest.
		/// </summary>
		/// <param name="variables">The string to parse</param>
		/// <param name="httpRequest">Request to add variables key/value-pairs to.</param>
		private void parseVariablesAndAddToHTTPRequest (string variables, IHTTPRequest httpRequest)
		{
			// if variables contains "?" - first remove.
			if (variables.StartsWith("?"))
			{
				variables = variables.Remove(0, 1);
			}


			string keyValuePair;
			string key;
			string value;
			int andIndex;
			int equalsIndex;

			// IDEA: shorten variables-string until its size is 0 by removing key/value-pairs step by step. 
			while(variables.Length > 0)
			{	
				// FIRST: Get Key/Value-Pairs.
				andIndex = variables.IndexOf('&');
				if(andIndex == -1) 
				{
					// if "&" is not found use the complete rest of the string because no or no more variable exists.					
					keyValuePair = variables;
					variables = ""; //empty variables-rest
				}
				else
				{
					keyValuePair = variables.Substring(0, andIndex);
					variables = variables.Remove(0, andIndex + 1); //remove first key/value-pair
				}
				


				// SECOND: split the Key/Value-Pairs found into key and value.
				equalsIndex = keyValuePair.IndexOf('=');				
				if(equalsIndex == -1) //otherwise empty variable-value without "=" (last variable-position)
				{
					equalsIndex = keyValuePair.Length; //use the rest of the string as key.
					value = ""; //empty value;
				}
				else
				{
					// only set value if "=" exists:
					value = keyValuePair.Substring(equalsIndex + 1, keyValuePair.Length - ( equalsIndex + 1 ));	//remove "="-position					
				}
				// always set key:
				key = keyValuePair.Substring(0, equalsIndex); //remove rest (value-part) including "="-position



				// THIRD: save key-value-pairs.
				httpRequest.SetVariableValue(key, value);
				webserverMonitor.WriteLogEntry("GET-Variables, Key | Value: " + key + " | " + value);				
			}

			
		}


		/// <summary>
		/// Searches in the request for the http-request-type (e. g. post or get)
		/// </summary>
		/// <param name="requestStringBuffer">The string to search in.</param>
		/// <returns>The type of request represented in int (see DefaultHTTPRequest).</returns>
		private int parseRequestMethod (string requestStringBuffer)
		{
			// Get the request-method:
			string requestMethod = requestStringBuffer.Substring(0,3);
	
			switch(requestMethod)
			{
				case "GET":
				{
					webserverMonitor.WriteLogEntry("Request-method is of type GET.");
					return RequestTypes.GET_METHOD;
				}
				case "POST":
				{
					webserverMonitor.WriteLogEntry("Request-method is of type POST.");
					return  RequestTypes.POST_METHOD;
				}
				default:
				{
					throw new NoValidRequestTypeException();
				}
			}
		}


	}
}

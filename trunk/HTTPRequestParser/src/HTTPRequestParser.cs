using System;
using System.Collections.Specialized;
using System.IO;
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
	/// Revision 1.16  2004/12/15 00:32:33  sliver
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
	/// Revision 1.15  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.14  2004/11/21 17:10:03  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	/// Revision 1.13  2004/11/05 09:29:41  kelsaka
	/// Improved determining of HTTP-Request-Types
	///
	/// Revision 1.12  2004/11/05 08:31:19  kelsaka
	/// changed comment
	///
	/// Revision 1.11  2004/11/03 20:09:51  kelsaka
	/// Added full support for POST-requests.
	///
	/// Revision 1.10  2004/11/03 18:52:48  kelsaka
	/// Added ability to get the full content-data of post-requests
	///
	/// Revision 1.9  2004/10/31 16:30:40  kelsaka
	/// preparing parsing of post-requests
	///
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
		private IRequestFactory requestFactory;

		public HTTPRequestParser(IHTTPRequestProcessor requestProcessor, IRequestParser corSuccessor, IWebserverMonitor webserverMonitor,  IWebserverConfiguration webserverConfiguration, IRequestFactory requestFactory)
		{
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;		
			this.requestProcessor = requestProcessor;
			this.corSuccessor = corSuccessor;
			this.requestFactory = requestFactory;
		}



		/// <summary>
		/// Starts the Parsing-Process of the given request.
		/// </summary>
		/// <param name="request">The request that is going to be parsed.</param>
		public void HandleRequest (IRequest request)
		{
			// default starting position:
			int httpStartPos = 0;

			// the request-data:
			string requestString = "";

			// Save the parsing-results into the IHTTP-Request
			IHTTPRequest httpRequest = requestFactory.CreateHTTPRequest();
			httpRequest.Socket = request.Socket;


			// Read the content-data of the request
			try {				
				requestString = ReadRequestHTTPData(request);	 // IF post: WebLogEntry*
			} 
			catch (IOException e) 
			{
				webserverMonitor.WriteLogEntry("Calling COR-Successor as errors occured on handling (read data) the request as a http-request. " + e);
				corSuccessor.HandleRequest(request);
				return;
			}





			// FIRST: HTTP-Request? 
			// Look for HTTP request:	
			httpStartPos = IsRequestOfHTTPType(requestString);
			if(httpStartPos == -1) //handle non-http-request.
			{
				// Call the CoR-Successor, if the request is not a HTTP-Request. The HTTP-Parser is not the right chain link
				// for this request.
				// The HandleRequest-Method is called, as it is the standard call for the IRequest-Chain.
				webserverMonitor.WriteLogEntry("Calling the COR-Successor as the actual request is not a HTTP-Request.");
				corSuccessor.HandleRequest(request);
				return;
			}

			// Get the HTTP text and version e.g. it will return "HTTP/1.1"
			httpRequest.HttpVersion = requestString.Substring(httpStartPos, 8); // 8 comes from the length of "HTTP/1.1"
			webserverMonitor.WriteLogEntry("HTTP-request has version " + httpRequest.HttpVersion);




			// SECOND: GET / POST?
			// get the http-request-type (e. g. post, get):
			try
			{
				httpRequest.RequestedMethodType = parseRequestMethod(requestString); // WriteLogEntry
			}
			catch (NoValidRequestTypeException)
			{
				request.Socket.Close();
				webserverMonitor.WriteDebugMessage("Error: No valid http-request-type (GET, POST) found. Socket closed.", 1);
				return;
			}



			// THIRD: Parse
			// POST-Method:
			if(httpRequest.RequestedMethodType == (int)RequestTypes.HTTPMethodType.POST_METHOD)
			{				
				ParsePostRequest(requestString, httpStartPos, httpRequest);	 // WriteLogEntry*
			}

			// GET-Method:
			else if(httpRequest.RequestedMethodType == (int)RequestTypes.HTTPMethodType.GET_METHOD) 
			{
				ParseGetRequest(requestString, httpStartPos, httpRequest);	 // WriteLogEntry
			}



	
	
			// FOURTH: Call the RequestProcessor
			// Handle IHTTPRequest in the requestProcessor. The httpRequest contains all necessary (parsed) data.
			requestProcessor.HandleRequest(httpRequest);
		}



		/// <summary>
		/// Parses the request and determines, whether it is a HTTP-Request.
		/// </summary>
		/// <param name="requestString">The full request-string that has to be parsed.</param>
		/// <returns>The Index-Position of the "HTTP"-String, if a valid HTTP-Request was given.
		///	If an error occured on parsing or the parsing-process returned with an non HTTP-request -1 will be returned.</returns>
		private int IsRequestOfHTTPType (string requestString)
		{
			int httpStartPos;

			// A typical first GET/POST-HTTP-Request-Row looks like (without ""):
			// "GET /subdirectory/index.html HTTP/1.1"
			try
			{
				string firstRow = requestString.Substring(0, requestString.IndexOf("\n")); // get the first row
				httpStartPos = firstRow.LastIndexOf(" ") + 1; // "HTTP" should appear behind the last space.

				if (requestString.Substring(httpStartPos, 4) != "HTTP") // check for "HTTP"-string
				{
					return -1; //no HTTP-request
				}
			}
			catch (Exception) // if the first row is not of the expected form (probably not HTTP-Request) a exception will be thrown.
			{			
				return -1; //no HTTP-request
			}
			return httpStartPos;
		}


		/// <summary>
		/// As the request-structure of a http-request is very special it is neccessary to get it with a method
		/// which minds about this special features of the request-type.
		/// </summary>
		/// <param name="request">The request that contains the socket.</param>
		/// <returns>The request-content as a string.</returns>
		private string ReadRequestHTTPData (IRequest request)
		{
			NetworkStream networkStream = new NetworkStream(request.Socket, System.IO.FileAccess.ReadWrite, true);
			StreamReader reader = new StreamReader(networkStream);
			string requestStringBuffer = "";
			string buffer = "";
			int contentLength = 0;
			char[] charBuffer;
			bool contentRead = false;
	
			try 
			{
				while(true) 
				{
					
					//if the content has been read (blockread) the ReadLine-command would hang:
					if(!contentRead)
					{
						buffer = reader.ReadLine();
					}
					
					// break looping if teh is buffer emtpy or the content (from post-requests) has been read:
					if (buffer == null || buffer.Length <= 0 || contentRead)
					{
						break;
					}
					

					// for the POST-Variables; that section start with "Content-Length:", so search for it.
					// This part of the request can not be read by using ReadLine, because its size depends on each request.
					// The size has to be read from the request itself.
					if(buffer.IndexOf("Content-Length:") != -1)
					{
						requestStringBuffer += buffer + "\n";

						int lengthStartIndex = buffer.IndexOf(":") + 2; // 2: ":" is followed by a space - so read 2 chars later.
						string contentLengthString = buffer.Substring(lengthStartIndex, buffer.Length - lengthStartIndex);
						contentLength = Int32.Parse(contentLengthString) + 2; // 2: Two Linebreaks before the Variables start
						
						charBuffer = new char[contentLength];
						// read the rest of the request in a block; size is known from the request itself.
						int requestSize = reader.ReadBlock(charBuffer, 0, contentLength);
						buffer = new string(charBuffer);						

						webserverMonitor.WriteLogEntry("Got request; size (bytes): " + requestSize);
						contentRead = true;
					}

					// complete the request that has already been read.
					requestStringBuffer += buffer + "\n";
				}
			} 
			catch (SocketException e) 
			{
				webserverMonitor.WriteDebugMessage("ERROR: Caught Socket exception " + e, 1);
			} 
			catch (IOException e) 
			{
				webserverMonitor.WriteDebugMessage("ERROR: Caught IO exception " + e, 1);
				throw e; // might be handled by a COR-Successor
			}
			return requestStringBuffer;
		}


		/// <summary>
		/// Parses the rest (httpStartPos) of a get-method-request.
		/// </summary>
		/// <param name="requestStringBuffer">The request string.</param></param>
		/// <param name="httpStartPos">Position from where to start parsing.</param>
		/// <param name="httpRequest">The http-request that has to be created.</param>
		private void ParseGetRequest (string requestStringBuffer, int httpStartPos, IHTTPRequest httpRequest)
		{
			// sets the filename and the directory of the requested file in the httpRequest as well as
			// the variabels:
			setFilenameDirectoryAndGETVariablesInRequest (requestStringBuffer, httpStartPos, httpRequest);
	
			// parse file-type (e. g. ".html") out of the filename.
			httpRequest.RequestedFileType = parseFileType(httpRequest.RequestedFileName);
		}



		/// <summary>
		/// Parses the rest (httpStartPos) of a post-method-request.
		/// </summary>
		/// <param name="requestStringBuffer">The request string.</param></param>
		/// <param name="httpStartPos">Position from where to start parsing.</param>
		/// <param name="httpRequest">The http-request that has to be created.</param>
		private void ParsePostRequest (string requestStringBuffer, int httpStartPos, IHTTPRequest httpRequest)
		{	
			

			// sets the filename and the directory of the requested file in the httpRequest as well as
			// the variabels:
			setFilenameDirectoryAndGETVariablesInRequest (requestStringBuffer, httpStartPos, httpRequest);
	
			// parse file-type (e. g. ".html") out of the filename.
			httpRequest.RequestedFileType = parseFileType(httpRequest.RequestedFileName);

			
			// Extract the request-part, that contains the variables-names and values:
			int contentIndex = requestStringBuffer.IndexOf("Content-Length:");
			string contentStringPart = requestStringBuffer.Substring(contentIndex, requestStringBuffer.Length - contentIndex);
			contentIndex = contentStringPart.IndexOf("\n");
			// 3: remove superfluent line-breaks at the beginning of the string
			// 4: remove superfluent line-breaks at the end of the string
			contentStringPart = contentStringPart.Substring(contentIndex + 3, contentStringPart.Length - contentIndex - 4);

			// seperates the string into variables and set as POST-Variables (false):
			this.parseVariablesAndAddToHTTPRequest(contentStringPart, httpRequest, false);		
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
		/// Extracts the GET-Variables from the RequestString and sets it in the HTTPRequest.
		/// </summary>
		/// <param name="requestStringBuffer">String to parse.</param>
		/// <param name="httpStartPos">Position where the http-request starts.</param>
		/// <param name="httpRequest">The httpRequest where filename and directoy are set.</param>
		private void setFilenameDirectoryAndGETVariablesInRequest (string requestStringBuffer, int httpStartPos, IHTTPRequest httpRequest)
		{
			string requestedFileOrDirectory;
			string variables;

			
			// Extract the Requested Type and Requested file/directory
			// Typical part of the request: "POST /[directory/ies]/[filename] HTTP/1.1"
			// Positions: after "POST " / "GET "; Length: letters until httpStartPos minus the starting-position of "/" and space
			int slashIndex = requestStringBuffer.IndexOf("/");
			requestedFileOrDirectory = requestStringBuffer.Substring(slashIndex, httpStartPos - (1 + slashIndex) );

	
			// Replace backslashes by forwardslashes
			requestedFileOrDirectory.Replace("\\", "/");
				


			// If file name is not supplied add forward slash to indicate 
			// that it is a directory and then we will look for the 
			// default file name..
			if ((requestedFileOrDirectory.IndexOf(".") < 1) && (!requestedFileOrDirectory.EndsWith("/")))
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
				parseVariablesAndAddToHTTPRequest(variables, httpRequest, true);

				// second: remove variables-part from the RequestedFileName-string:
				httpRequest.RequestedFileName = httpRequest.RequestedFileName.Substring(0, qmarkPosition);
			}



				
			//Extract The directory Name
			httpRequest.RequestedDirectoryName = requestedFileOrDirectory.Substring(0, requestedFileOrDirectory.LastIndexOf("/") + 1);
	
			webserverMonitor.WriteLogEntry("Requested directory | file: " + httpRequest.RequestedDirectoryName + " | " + httpRequest.RequestedFileName);
		}


		/// <summary>
		/// Parses the string containing the variables of a GET-request (like e. g. "?xxxxx=aaaaa&yyyyy=bbbbb&..".
		/// The result it saved to the httpRequest.
		/// </summary>
		/// <param name="variables">The string to parse</param>
		/// <param name="httpRequest">Request to add variables key/value-pairs to.</param>
		/// <param name="setGETVariables">If set true, the GET-Variables are set. If set false; the POST-Variables are set.</param>
		private void parseVariablesAndAddToHTTPRequest (string variables, IHTTPRequest httpRequest, bool setGETVariables)
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
				if(setGETVariables) 
				{
					httpRequest.SetGETVariableValue(key, value);
					webserverMonitor.WriteLogEntry("GET-Variables, Key | Value: " + key + " | " + value);				
				}
				else //POST-Case.
				{
					httpRequest.SetPOSTVariableValue(key, value);
					webserverMonitor.WriteLogEntry("POST-Variables, Key | Value: " + key + " | " + value);									
				}
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
			if(requestStringBuffer.Substring(0,3) == "GET")
			{
				webserverMonitor.WriteLogEntry("Request-method is of type GET.");
				return (int)RequestTypes.HTTPMethodType.GET_METHOD;
			}

			if(requestStringBuffer.Substring(0,4) == "POST")
			{
				webserverMonitor.WriteLogEntry("Request-method is of type POST.");
				return  (int)RequestTypes.HTTPMethodType.POST_METHOD;
			}


			throw new NoValidRequestTypeException();	
		}


	}
}

using System;
using System.Net.Sockets;

namespace MySmallWebServer
{
	/// <summary>
	/// Parses the Request and generates a RequestClient.
	/// The generated request contains of method Type, protocol, FileID
	/// </summary>
	public class RequestParser
	{
		/// <summary>
		/// A instance ot the <code>ServerSettings</code> to check some things
		/// </summary>
		private ServerSettings settings;

		/// <summary>
		/// The <code>Socket</code> on which the client is conntected
		/// </summary>
		private Socket clientSocket;

		/// <summary>
		/// The request which has been sended by the client as <code>string</code>
		/// </summary>
		private string requestString;

		/// <summary>
		/// The dir, which has been requested by the client as <code>string</code>
		/// </summary>
		private string requestedDir;

		/// <summary>
		/// The <code>AbstractMethod</code> which is called by the client
		/// n the moment this can be head get and post
		/// </summary>
		private AbstractMethod method;

		/// <summary>
		/// The <code>AbstractFile</code> contains all inforamtion of the requested
		/// or used file
		/// </summary>
		private UsedFile file;

		/// <summary>
		/// The protocol which is used by the client
		/// </summary>
		private AbstractHttpProtocol protocol;

		/// <summary>
		/// This will be the generated <code>AbstractRequest</code>
		/// </summary>
		private ClientRequest generatedRequest;

		/// <summary>
		/// The fileextension of the Request
		/// </summary>
		private string fileEx;

		/// <summary>
		/// The user input as <code>string</code>
		/// </summary>
		private string userInput;

			

		/// <summary>
		/// The Constructor
		/// </summary>
		/// <param name="clientSocket"><code>Soclket</code> on which the client is connected</param>
		/// <param name="settings">The settings of the server</param>
		/// <param name="request">The requet of the client as a <code>string</code> representation</param>
		public RequestParser(ref Socket clientSocket, ServerSettings settings,string request)
		{
			this.generatedRequest = new ClientRequest();
			Console.WriteLine("Start Parsing");
			this.settings = settings;
			this.clientSocket = clientSocket;
			this.requestString = request;
			identifyMethod();
			

			if(this.method is PostMethod)
			{
				this.userInput = ParseUserInput();
			}

			this.file = new UsedFile();

			identifyFile();
			identifyProtocol();
			Console.WriteLine(this.ToString());
			
			this.generatedRequest.Protocol = this.protocol;
			this.generatedRequest.RequestedFile = this.file;
			this.generatedRequest.RequestedMethod = this.method;
			this.generatedRequest.Settings = this.settings;
			this.generatedRequest.ClientSocket = this.clientSocket;
			this.generatedRequest.UserInput = this.userInput;
			this.generatedRequest.RequestedFile.FileExtension = this.fileEx;
			this.generatedRequest.RequestedFile.RequestedDirectory = this.requestedDir;
			
		}

		
		/// <summary>
		/// The Request which has been generates by the Parser
		/// </summary>
		public ClientRequest GeneratedClientRequest
		{
			get{ return this.generatedRequest;}
		}


		/// <summary>
		/// This start parsing the onput, and locks for the user Input
		/// ist search for the line, which contains a "&"
		/// </summary>
		/// <returns></returns>
		private string ParseUserInput()
		{
			string output ="";
			this.requestString.Trim();
			string[] erg = this.requestString.Split('\n');
			foreach(string s in erg)
			{
				if(s.IndexOf("&")!=-1)
					output = s;
			}
			return output;
		}


		/// <summary>
		/// Searchs for the used protocol
		/// </summary>
		private void identifyProtocol()
		{
			string p = this.requestString.Substring(this.requestString.IndexOf("HTTP",1),8);
			this.protocol = new Http_1_1();
		}


		/// <summary>
		/// Searches in the input string for the filename and extensions
		/// </summary>
		private void identifyFile()
		{
			int startPos = this.requestString.IndexOf("HTTP",1);
			string requestLine = this.requestString.Substring(0,startPos - 1);
			Console.WriteLine("The requested Line: "+requestLine);
			this.requestedDir = requestLine.Substring(requestLine.IndexOf("/"), requestLine.LastIndexOf("/")-3);
			if(this.requestedDir=="/i" || this.requestedDir=="/d")
				this.requestedDir="/";
			Console.WriteLine("requested Dir: "+this.requestedDir);
			string requestedFile;
			//Replace backslash with Forward Slash, if Any
			this.requestString.Replace("\\","/");
			//If file name is not supplied add forward slash to indicate 
			//that it is a directory and then we will look for the 
			if ((requestLine.IndexOf(".") <1) && (!requestLine.EndsWith("/")))				
				requestLine = requestLine + "/"; 
			//Extract the requested file name
			startPos = requestLine.LastIndexOf("/") + 1;
			requestedFile = requestLine.Substring(startPos);
			if(requestedFile == "")
			{
				//this is a little bit ugly
				requestedFile = this.settings.DefaultFile;
				requestLine = requestedFile;
				Console.WriteLine("default Request!");
			}
			int exStart = requestLine.IndexOf(".");
			this.fileEx = requestLine.Substring(exStart);
			requestedFile.Trim();
//			if(this.method is PostMethod)
//				this.file = new UsedFile(requestedFile);
			this.file.RequestedFileName = requestedFile;
			Console.WriteLine("Requested File: "+requestedFile);
			Console.WriteLine("Ende identifyFile");
		}


		/// <summary>
		/// Parses out the requested method
		/// </summary>
		private void identifyMethod()
		{
			string requestedMethod = this.requestString.Substring(0,3);
			switch(requestedMethod)					
			{
				case "GET":
				{
					this.method = new GetMethod();
					break;
				}
				case "HEA":
				{
					this.method = new HeadMethod();
					break;
				}
				case "POS":
				{
					this.method = new PostMethod();
					break;
				}
				default:
				{
					///here a exception has to be thrown
					Console.WriteLine("Method not known!");
					throw new MyServerException.ResponseException(this.GeneratedClientRequest);
//					mySocket.Close();
					return;
				}
			}
		}
		
	}

}

using System;
using System.Collections;
using System.Net.Sockets;
using System.Text;
using System.Text.RegularExpressions;
using System.Timers;
using Request;
using RequestProssor;
using SimpleLogging;

namespace RequestParser
{
	/// <summary>
	/// Zusammenfassung für HttpParser.
	/// </summary>
	public class HTTPParser
	{
		protected bool isPostRequest = false;
		protected bool timeElasped = false;
		protected bool requestComplete = false;

		protected TcpClient tcpClient;
		protected NetworkStream currentStream;
		protected DateTime arravialTime;

		protected PostParsingStatus postStatus;

		protected string myTempPattern;
		protected Match myMatch;
		protected Regex myRegex;

		protected RequestProcessorComponent pro;

		protected string boundaryString;

		protected HttpPostRequest postRequest;

		protected SimpleLogger logger;


		public HTTPParser(DateTime da, TcpClient tcp, ref RequestProcessorComponent rp)
		{
			this.pro = rp;
			this.arravialTime = da;
			this.currentStream = tcp.GetStream();
			this.tcpClient = tcp;
			this.boundaryString = "null";
			this.myRegex = new Regex(this.boundaryString);
			this.requestComplete = false;
			this.isPostRequest = false;

			//intit logger
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput = true;
			this.logger.DebugOutput = true;
			this.logger.InfoOutput = true;
			this.logger.WarningOutput = true;


			ParsingAndIdentifyRequest();
		}

		internal void ReactOnTimeElapsed(object o, ElapsedEventArgs e)
		{
			if (!this.requestComplete)
			{
				byte[] msg =
					Encoding.ASCII.GetBytes("411 Time Out");
				this.currentStream.Write(msg, 0, msg.Length);
				this.currentStream.Close();
				this.tcpClient.Close();
				this.logger.Warning("Client Time out");
				this.timeElasped = true;
			}
		}

		public void ParsingAndIdentifyRequest()
		{
			StartTimeOutRequest();
			int i;
			Byte[] bytes = new Byte[256];
			String data = null;
			string completeMessage = "";

			// Loop to receive all the data sent by the client
			while (!this.requestComplete &&
				(i = this.currentStream.Read(bytes, 0, bytes.Length)) > 0 && !this.timeElasped)
			{
				// Translate data bytes to a ASCII string.
				data = Encoding.ASCII.GetString(bytes, 0, i);

				//setting up the next bytes to read.
				bytes = new Byte[32];

				//identify the end of a not PostRequest
				if (data.IndexOf("\n\r\n") != -1 && !this.isPostRequest)
				{
					this.logger.Debug("Not Post Request successfully read");
					completeMessage += data;
					this.requestComplete = true;
				}

				//add the currently read data to complete request
				completeMessage += data;


				//identify a Post Request, but only do it once
				if (completeMessage.IndexOf("POST") != -1 && !this.isPostRequest)
				{
					this.logger.Debug("Post Request found");
					this.isPostRequest = true;
				}
				if (this.isPostRequest)
				{
					HandlePostRequest(completeMessage);
				}

				// Send back a response.
				if (this.requestComplete && !this.isPostRequest)
				{
					this.logger.Debug("Request komplett eingelesen: ");
					HttpRequest tempRequest = this.ParseReallyRequest(completeMessage);
					this.pro.ServeRequest(tempRequest);
				}
			}

		}

		//Handles parsing a Postrequest
		private void HandlePostRequest(string completeMessage)
		{
			this.myRegex = new Regex(this.boundaryString);
			MatchCollection matchCollection = this.myRegex.Matches(completeMessage);

			if ((completeMessage.IndexOf("Content-Length")) != -1 && this.postStatus == PostParsingStatus.nothingFound)
			{
				this.postStatus = PostParsingStatus.boundarycanBeRead;
				HttpRequest tt = this.ParseReallyRequest(completeMessage);
				this.postRequest = new HttpPostRequest(tt);
			}

			if (matchCollection.Count == 2 && this.postStatus == PostParsingStatus.boundarycanBeRead)
				this.postStatus = PostParsingStatus.contentLengthCanBeRead;

			if (matchCollection.Count == 3 && this.postStatus == PostParsingStatus.contentLengthCanBeRead)
				this.postStatus = PostParsingStatus.contentCanBeRead;

			if (matchCollection.Count == 4 && this.postStatus == PostParsingStatus.contentCanBeRead)
				this.logger.Debug("Post Request completly read");

			if (this.postStatus == PostParsingStatus.boundarycanBeRead)
			{
				this.boundaryString = this.IdentífyBoundaryString(completeMessage);
				Console.WriteLine("Habe den ersten Boundary String gefunden!");
			}
			if (this.postStatus == PostParsingStatus.contentLengthCanBeRead)
			{
				Console.WriteLine("Aktuteller Match Collection Wert : " + matchCollection.Count);
				this.postRequest.ContentLength = this.IdentifyContentLength(completeMessage);
				Console.WriteLine(completeMessage);

			}

			if (this.postStatus == PostParsingStatus.contentCanBeRead)
			{
				Console.WriteLine("drittes Boundary Found");
				this.postRequest.Content = identifyContentent(completeMessage);
				this.requestComplete = true;
				this.pro.ServeRequest(this.postRequest);
			}
		}

		internal string identifyContentent(string aMessage)
		{
			Regex reg = new Regex(this.boundaryString);

			string[] inputForContentDelivery = reg.Split(aMessage);
			//message body is in the second segment
			string contentAndMore = inputForContentDelivery[2];
			//cut content Discription
			Regex reger = new Regex("\r\n\r\n");
			inputForContentDelivery = reger.Split(contentAndMore, 2);
			string content = inputForContentDelivery[1];
			return content;
		}


		internal int IdentifyContentLength(string aMessage)
		{
			string[] temp = aMessage.Split('\n');
			string rightline = "";
			foreach (string s in temp)
			{
				if (s.IndexOf("Content-Length:") != -1)
					rightline = s;
			}

			string size = (rightline.Split(':'))[1];
			int sizeAsInt = int.Parse(size.Trim());

			Console.WriteLine("ContentLengt is " + sizeAsInt);
			return sizeAsInt;
		}


		internal string IdentífyBoundaryString(string message)
		{
			string[] temp = message.Split('\n');
			string rightline = "";
			foreach (string s in temp)
			{
				if (s.IndexOf("boundary=") != -1)
					rightline = s;
			}

			string boundary = (rightline.Split('='))[1];
			Regex mozart = new Regex("\r");
			boundary = mozart.Replace(boundary, "");
			this.logger.Debug("Boundary: " + boundary);
			return boundary;

		}

		/// <summary>
		/// Identifies the properties of the HTTP Request and retruns them 
		/// </summary>
		/// <param name="completeMessage"></param>
		/// <returns></returns>
		internal HttpRequest ParseReallyRequest(string completeMessage)
		{
			HttpRequest httpRequest = new HttpRequest();

			httpRequest.TcpClientOn = this.tcpClient;
			httpRequest.Protocol = identifyProtocol(completeMessage);

			httpRequest.URI = (identifyURI(completeMessage));

			httpRequest.RequestedMethod = IdentifyMethod(completeMessage);

			httpRequest.FileExtension = identifyFileExtension(httpRequest.URI);

			httpRequest.ClientSocket = this.currentStream;

			httpRequest.ArrivalTime = this.arravialTime;

			httpRequest.UserInput = GetUserInput(httpRequest.URI);

			return httpRequest;

		}

		/// <summary>
		/// Identifies the method of the request
		/// </summary>
		/// <param name="aRequest">a string which contains the request head </param>
		/// <returns></returns>
		private string IdentifyMethod(string aRequest)
		{
			return aRequest.Substring(0, aRequest.IndexOf(' '));
		}

		private string identifyProtocol(string aRequest)
		{
			string p = aRequest.Substring(aRequest.IndexOf("HTTP", 1), 8);
			this.logger.Debug("the protocol: " + p);
			return p;
		}


		private string identifyURI(string request)
		{
			int startPos = request.IndexOf("HTTP", 1);
			string requestLine = request.Substring(0, startPos - 1);
			string[] uri = requestLine.Split(' ');
			return uri[1];
		}


		private string identifyFileExtension(string uri)
		{
			int startPos = uri.LastIndexOf(".");
			if (startPos <= 0)
				return "";
			return uri.Substring(startPos, uri.Length - startPos);
		}

		private Hashtable GetUserInput(string uri)
		{
			string[] temp = uri.Split('?');
			if (temp.Length == 1)
				return null;
			string aRequest = temp[1];
			Hashtable result = new Hashtable();
			string line = "";
			if (temp[1].IndexOf('&') == -1)
			{
				string[] singleResult = temp[1].Split('=');
				result.Add(singleResult[0], singleResult[1]);
				return result;
			}
			string[] erg1 = aRequest.Split('\n');
			try
			{
				foreach (string s in erg1)
				{
					if (s.IndexOf("&") != -1)
						line = s;
				}
				string[] singleFormular = line.Split('&');
				foreach (string s in singleFormular)
				{
					String[] erg = s.Split('=');
					result.Add(erg[0], erg[1]);
					Console.WriteLine("Keys: " + erg[0] + "#");
				}
			}
			catch (Exception)
			{
				Console.WriteLine("Kein User Input");
				return null;
			}

			foreach (DictionaryEntry f in result)
			{
				this.logger.Debug(f.Key + " : " + f.Value);
			}
			return result;
		}

		/// <summary>
		/// Measures the duration of parsing a client request.
		/// </summary>
		internal void StartTimeOutRequest()
		{
			Timer t = new Timer();
			t.Elapsed += new ElapsedEventHandler(ReactOnTimeElapsed);
			//t.Elapsed += new System.Timers.ElapsedEventHandler(
			t.Interval = 2000;
			t.AutoReset = false;
			t.Start();
		}


		//[Flags]
		/// <summary>
		/// A Enumeration which signalizes the status of parsing a postrequest.
		/// </summary>
		public enum PostParsingStatus
		{
			nothingFound = 0,
			boundarycanBeRead = 1,
			contentLengthCanBeRead = 2, //--> second boundary has been found
			contentCanBeRead = 3, //--> third boundary has been found
			postRequestFinshed = 4, //--> fourth boundary has been found
		}
	}
}

//**alter Http Parser mit TimeOut
//using System;
//using SimpleLogging;
//using Request;
//using System.Net.Sockets;
//using System.Collections;
//using System.Text.RegularExpressions;
//
//
//namespace RequestParser
//{
//	/// <summary>
//	/// Zusammenfassung für HTTPParser.
//	/// </summary>
//	public class HTTPParser
//	{
//		HttpRequest httpRequest;
//		SimpleLogger logger;
//
//		public HTTPParser(string aRequest,NetworkStream client,DateTime arrival,ref RequestProssor.RequestProzessorComponent pro,TcpClient tcp)
//		{
//			this.httpRequest = new HttpRequest();
//			this.httpRequest.TcpClientOn = tcp;
//			
//
//			//setting logging information 
//			this.logger = new SimpleLogger(this);
//			this.logger.ConsoleOutput=false;
//			this.logger.DebugOutput=false;
//
//			this.logger.Debug("Parsen geht los!");
//			this.httpRequest.Protocol=identifyProtocol(aRequest);
//
//			
//			this.httpRequest.URI=(identifyURI(aRequest));
//			this.logger.Debug("URI: "+this.httpRequest.URI);
//
//			this.httpRequest.RequestedMethod = IdentifyMethod(aRequest);
//			this.logger.Debug("Requested Method: "+this.httpRequest.RequestedMethod);
//			
//
//			this.httpRequest.FileExtension = identifyFileExtension(this.httpRequest.URI);
//			this.logger.Debug("File Extension: "+this.httpRequest.FileExtension);
//
//			this.httpRequest.ClientSocket = client;
//
//			this.httpRequest.ArrivalTime = arrival;
//
//			this.httpRequest.UserInput = GetUserInput(this.httpRequest.URI);
//
//			if(this.httpRequest.RequestedMethod =="POST")
//			{
//				try
//			{
//				ParsePostRequest(aRequest);
//				}
//				catch(Exception)
//				{
//					HttpRequest error = new HttpRequest();
//					error.URI = "/BAdRequest.htm";
//					error.ArrivalTime = this.httpRequest.ArrivalTime;
//					error.ClientSocket = this.httpRequest.ClientSocket;
//					error.UserInput = null;
//					error.FileExtension = ".htm";
//					error.Protocol = this.httpRequest.Protocol;
//					error.RequestedMethod="GET";
//					this.httpRequest = error;
//				}
//				
//			}
//			
//				
//			
//
//			pro.ServeRequest(this.httpRequest);
//			//this.httpRequest
//	
//
//
//		}
//
//		private void ParsePostRequest(string aRequest)
//		{
//			HttpPostRequest temp = new HttpPostRequest(this.httpRequest);
////			string body = GetMessageBody(aRequest);
////			Console.WriteLine("Der Message Body: "+ body);
//			//			temp.ContentLength = 89;
//			//			temp.Content = "HAllo";
//
//			string da = aRequest.Substring(aRequest.IndexOf("Content-Type:"));
//			string boundary =GetBoundary(da);
//			
//			Regex re = new Regex(boundary);
//			aRequest = aRequest.Substring(aRequest.IndexOf(boundary));
//
//
//			// An allen Fundstellen splitten 
//			string[] inputs = re.Split(aRequest);
////			foreach (string s in inputs)
//
////				Console.WriteLine("an Elemment: "+s);
//			int size = GetContentSize(inputs[1]);
//			string contentDiscription = GetContextDiscripton(inputs[2]);
//			string body = inputs[2];
//
////			Console.WriteLine("das ist the body  "+body);
//
//			Regex reg = new Regex("\r\n\r\n");
//
//			string[] inputFprContentDelivery = reg.Split(body,2);
//			
////			Console.WriteLine("Das ist der content "+inputFprContentDelivery[0]);
//
////			Console.WriteLine("das Sollte der Body sein"+ inputFprContentDelivery[1]);
//			string messageBody =  inputFprContentDelivery[0];
//			temp.Content = inputFprContentDelivery[1];
//
//			Console.Read();
//			this.httpRequest = temp;
//				
//		}
//		internal string GetMessageBody(string aRequest)
//		{
//			string da = aRequest.Substring(aRequest.IndexOf("Content-Type:"));
//			string boundary =GetBoundary(da);
//			
//			Regex re = new Regex(boundary);
//			aRequest = aRequest.Substring(aRequest.IndexOf(boundary));
//
//
//			// An allen Fundstellen splitten 
//			string[] inputs = re.Split(aRequest);
////			foreach (string s in inputs)
////
////				Console.WriteLine("an Elemment: "+s);
//			int size = GetContentSize(inputs[1]);
//			string contentDiscription = GetContextDiscripton(inputs[2]);
//			string body = inputs[2];
//
////			Console.WriteLine("das ist the body  "+body);
//
//			Regex reg = new Regex("\r\n\r\n");
//
//			string[] inputFprContentDelivery = reg.Split(body,2);
//			
////			Console.WriteLine("Das ist der content "+inputFprContentDelivery[0]);
//
////			Console.WriteLine("das Sollte der Body sein"+ inputFprContentDelivery[1]);
//			string messageBody =  inputFprContentDelivery[0];
//
//			//			string string content = 
//			////			
//			//			
//			//
//			//			return inputs[1];
//
//			return "hallo";
//		}
//
//		internal string GetContextDiscripton(string body)
//		{
//			
//			return "asdhasjdhaskdhaskjdha";
//			
//		}
//
//
//		internal int GetContentSize(string s)
//		{
//			string rightLine="";
//			string[] lines = s.Split('\n');
//			foreach(string st in lines)
//			{
//				if(st.IndexOf("Content-Length")>=0)
//					rightLine = st;
//			}
//
//			Console.WriteLine("das ist die line: "+rightLine);
//			string pattern = @"([0-9]+)";
//			Match m = Regex.Match(rightLine,pattern);
//			if(m.Success)
//				return int.Parse(m.Value);
//			else 
//				return 0;
//		}
//
//		internal string GetBoundary(string aMessageBody)
//		{
//			String temp = aMessageBody.Substring(aMessageBody.IndexOf("boundary="));
//			string[] resultString = temp.Split('\n');
//			string boundary = (resultString[0].Split('='))[1];
//			return boundary;
//		}
//
//		private string IdentifyMethod(string aRequest)
//		{
//			return aRequest.Substring(0,aRequest.IndexOf(' '));
//		}
//
//		private string identifyProtocol(string aRequest)
//		{
////			string p="HTTP/1.1";
////			try
////			{
//				string p = aRequest.Substring(aRequest.IndexOf("HTTP",1),8);
//				this.logger.Debug("Das Protokol: "+p);
//				return p;
//				
////			}catch(Exception e)
////			{
////				Console.WriteLine(e.Message);
////			}
////			return p;
//
//		}
//
//		private string identifyURI(string request)
//		{
////			Console.WriteLine("Kommt da was an? "+request);
//			int startPos = request.IndexOf("HTTP",1);
//			string requestLine = request.Substring(0,startPos - 1);
//			string[] uri = requestLine.Split(' ');
//			return uri[1];
//		}
//
//		private string identifyFileExtension(string uri)
//		{
//			int startPos = uri.LastIndexOf(".");
//			//			Console.WriteLine(startPos);
//			if(startPos <= 0)
//				return "";
//			return uri.Substring(startPos,uri.Length - startPos);
//		}
//
//		private Hashtable GetUserInput(string uri)
//		{
//			//return null;
//			string[] temp = uri.Split('?');
//			if(temp.Length==1)
//				return null;
//			string aRequest = temp[1];
//			Hashtable result = new Hashtable();
//			string line="";
//			if(temp[1].IndexOf('&')==-1)
//			{
//				string[] singleResult = temp[1].Split('=');
//				result.Add(singleResult[0],singleResult[1]);
//				return result;
//			}
//			string[] erg1 = aRequest.Split('\n');
//			try
//			{
//				foreach(string s in erg1)
//				{
//					if(s.IndexOf("&")!=-1)
//						line = s;
//				}
//				//			if(line == "")
//				//				return null;
//			
//			
//				
//				string[] singleFormular = line.Split('&');
//				foreach(string s in singleFormular)
//				{
//					String[] erg = s.Split('=');
//					result.Add(erg[0],erg[1]);
//					Console.WriteLine("Keys: "+erg[0]+"#"); 
//				}
//			}
//			catch(Exception)
//			{
//				Console.WriteLine("Kein User Input");
//				return null;
//			}
//			//generate Debug output
//			foreach(DictionaryEntry f in result)
//			{
//				this.logger.Debug(f.Key+" : "+f.Value);
//			}
//
//			return result;
//		}

//*************************************************************************************
//			Console.WriteLine("The requested Line: "+requestLine);
//			string requestedDir = requestLine.Substring(requestLine.IndexOf("/"), requestLine.LastIndexOf("/")-3);
//			if(requestedDir=="/i" || requestedDir=="/d")
//				requestedDir="/";
//			Console.WriteLine("requested Dir: "+ requestedDir);
//		
//
//			string requestedFile;
//			//Replace backslash with Forward Slash, if Any
//			request.Replace("\\","/");
//			//If file name is not supplied add forward slash to indicate 
//			//that it is a directory and then we will look for the 
//			if ((requestLine.IndexOf(".") <1) && (!requestLine.EndsWith("/")))				
//				requestLine = requestLine + "/"; 
//			//Extract the requested file name
//			startPos = requestLine.LastIndexOf("/") + 1;
//			requestedFile = requestLine.Substring(startPos);
//			if(requestedFile == "")
//			{
//				//this is a little bit ugly
////				requestedFile = this.settings.DefaultFile;
//				requestLine = requestedFile;
//				Console.WriteLine("default Request!");
//			}
//			int exStart = requestLine.IndexOf(".");
//			string fileEx = requestLine.Substring(exStart);
//			requestedFile.Trim();
////			if(this.method is PostMethod)
////				this.file = new UsedFile(requestedFile);
////			this.file.RequestedFileName = requestedFile;
//			Console.WriteLine("Requested File: "+requestedFile);
//			//			Console.WriteLine("Ende identifyFile");
//		}
//	}
//}
using System;
using SimpleLogging;
using Request;
using System.Net.Sockets;
using System.Collections;
using System.Text.RegularExpressions;


namespace RequestParser
{
	/// <summary>
	/// Zusammenfassung für HTTPParser.
	/// </summary>
	public class HTTPParser
	{
		HttpRequest httpRequest;
		SimpleLogger logger;

		public HTTPParser(string aRequest,NetworkStream client,DateTime arrival,ref RequestProssor.RequestProzessorComponent pro,TcpClient tcp)
		{
			this.httpRequest = new HttpRequest();
			this.httpRequest.TcpClientOn = tcp;
			

			//setting logging information 
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput=false;
			this.logger.DebugOutput=false;

			this.logger.Debug("Parsen geht los!");
			this.httpRequest.Protocol=identifyProtocol(aRequest);

			
			this.httpRequest.URI=(identifyURI(aRequest));
			this.logger.Debug("URI: "+this.httpRequest.URI);

			this.httpRequest.RequestedMethod = IdentifyMethod(aRequest);
			this.logger.Debug("Requested Method: "+this.httpRequest.RequestedMethod);
			

			this.httpRequest.FileExtension = identifyFileExtension(this.httpRequest.URI);
			this.logger.Debug("File Extension: "+this.httpRequest.FileExtension);

			this.httpRequest.ClientSocket = client;

			this.httpRequest.ArrivalTime = arrival;

			this.httpRequest.UserInput = GetUserInput(this.httpRequest.URI);

			if(this.httpRequest.RequestedMethod =="POST")
			{
				try
			{
				ParsePostRequest(aRequest);
				}
				catch(Exception)
				{
					HttpRequest error = new HttpRequest();
					error.URI = "/BAdRequest.htm";
					error.ArrivalTime = this.httpRequest.ArrivalTime;
					error.ClientSocket = this.httpRequest.ClientSocket;
					error.UserInput = null;
					error.FileExtension = ".htm";
					error.Protocol = this.httpRequest.Protocol;
					error.RequestedMethod="GET";
					this.httpRequest = error;
				}
				
			}
			
				
			

			pro.ServeRequest(this.httpRequest);
			//this.httpRequest
	


		}

		private void ParsePostRequest(string aRequest)
		{
			HttpPostRequest temp = new HttpPostRequest(this.httpRequest);
//			string body = GetMessageBody(aRequest);
//			Console.WriteLine("Der Message Body: "+ body);
			//			temp.ContentLength = 89;
			//			temp.Content = "HAllo";

			string da = aRequest.Substring(aRequest.IndexOf("Content-Type:"));
			string boundary =GetBoundary(da);
			
			Regex re = new Regex(boundary);
			aRequest = aRequest.Substring(aRequest.IndexOf(boundary));


			// An allen Fundstellen splitten 
			string[] inputs = re.Split(aRequest);
//			foreach (string s in inputs)

//				Console.WriteLine("an Elemment: "+s);
			int size = GetContentSize(inputs[1]);
			string contentDiscription = GetContextDiscripton(inputs[2]);
			string body = inputs[2];

//			Console.WriteLine("das ist the body  "+body);

			Regex reg = new Regex("\r\n\r\n");

			string[] inputFprContentDelivery = reg.Split(body,2);
			
//			Console.WriteLine("Das ist der content "+inputFprContentDelivery[0]);

//			Console.WriteLine("das Sollte der Body sein"+ inputFprContentDelivery[1]);
			string messageBody =  inputFprContentDelivery[0];
			temp.Content = inputFprContentDelivery[1];
			this.httpRequest = temp;
				
		}
		internal string GetMessageBody(string aRequest)
		{
			string da = aRequest.Substring(aRequest.IndexOf("Content-Type:"));
			string boundary =GetBoundary(da);
			
			Regex re = new Regex(boundary);
			aRequest = aRequest.Substring(aRequest.IndexOf(boundary));


			// An allen Fundstellen splitten 
			string[] inputs = re.Split(aRequest);
//			foreach (string s in inputs)
//
//				Console.WriteLine("an Elemment: "+s);
			int size = GetContentSize(inputs[1]);
			string contentDiscription = GetContextDiscripton(inputs[2]);
			string body = inputs[2];

//			Console.WriteLine("das ist the body  "+body);

			Regex reg = new Regex("\r\n\r\n");

			string[] inputFprContentDelivery = reg.Split(body,2);
			
//			Console.WriteLine("Das ist der content "+inputFprContentDelivery[0]);

//			Console.WriteLine("das Sollte der Body sein"+ inputFprContentDelivery[1]);
			string messageBody =  inputFprContentDelivery[0];

			//			string string content = 
			////			
			//			
			//
			//			return inputs[1];

			return "hallo";
		}

		internal string GetContextDiscripton(string body)
		{
			
			return "asdhasjdhaskdhaskjdha";
			
		}


		internal int GetContentSize(string s)
		{
			string rightLine="";
			string[] lines = s.Split('\n');
			foreach(string st in lines)
			{
				if(st.IndexOf("Content-Length")>=0)
					rightLine = st;
			}

			Console.WriteLine("das ist die line: "+rightLine);
			string pattern = @"([0-9]+)";
			Match m = Regex.Match(rightLine,pattern);
			if(m.Success)
				return int.Parse(m.Value);
			else 
				return 0;
		}

		internal string GetBoundary(string aMessageBody)
		{
			String temp = aMessageBody.Substring(aMessageBody.IndexOf("boundary="));
			string[] resultString = temp.Split('\n');
			string boundary = (resultString[0].Split('='))[1];
			return boundary;
		}

		private string IdentifyMethod(string aRequest)
		{
			return aRequest.Substring(0,aRequest.IndexOf(' '));
		}

		private string identifyProtocol(string aRequest)
		{
//			string p="HTTP/1.1";
//			try
//			{
				string p = aRequest.Substring(aRequest.IndexOf("HTTP",1),8);
				this.logger.Debug("Das Protokol: "+p);
				return p;
				
//			}catch(Exception e)
//			{
//				Console.WriteLine(e.Message);
//			}
//			return p;

		}

		private string identifyURI(string request)
		{
//			Console.WriteLine("Kommt da was an? "+request);
			int startPos = request.IndexOf("HTTP",1);
			string requestLine = request.Substring(0,startPos - 1);
			string[] uri = requestLine.Split(' ');
			return uri[1];
		}

		private string identifyFileExtension(string uri)
		{
			int startPos = uri.LastIndexOf(".");
			//			Console.WriteLine(startPos);
			if(startPos <= 0)
				return "";
			return uri.Substring(startPos,uri.Length - startPos);
		}

		private Hashtable GetUserInput(string uri)
		{
			//return null;
			string[] temp = uri.Split('?');
			if(temp.Length==1)
				return null;
			string aRequest = temp[1];
			Hashtable result = new Hashtable();
			string line="";
			if(temp[1].IndexOf('&')==-1)
			{
				string[] singleResult = temp[1].Split('=');
				result.Add(singleResult[0],singleResult[1]);
				return result;
			}
			string[] erg1 = aRequest.Split('\n');
			try
			{
				foreach(string s in erg1)
				{
					if(s.IndexOf("&")!=-1)
						line = s;
				}
				//			if(line == "")
				//				return null;
			
			
				
				string[] singleFormular = line.Split('&');
				foreach(string s in singleFormular)
				{
					String[] erg = s.Split('=');
					result.Add(erg[0],erg[1]);
					Console.WriteLine("Keys: "+erg[0]+"#"); 
				}
			}
			catch(Exception)
			{
				Console.WriteLine("Kein User Input");
				return null;
			}
			//generate Debug output
			foreach(DictionaryEntry f in result)
			{
				this.logger.Debug(f.Key+" : "+f.Value);
			}

			return result;
		}


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
	}
}

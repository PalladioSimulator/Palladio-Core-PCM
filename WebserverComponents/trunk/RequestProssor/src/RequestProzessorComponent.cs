using System;
using Request;
using SimpleLogging;
using System.IO;
using System.Text;
using Delivery;
using StaticFileProvider;
using RequestProssor.MonitorWebServer;
using BibTexAnalyzer;


namespace RequestProssor
{
	/// <summary>
	/// This class represents the prozessor of the server. It computes a response
	/// to a single request and sends this request pack to the client. This class
	/// is also responsible for sendig error Message to the clients. This class is
	/// a Facade to the other classes of the Request Prozessor.
	/// </summary>
	public class RequestProzessorComponent
	{
		/// <summary>
		/// The settings for the prozessor. Here a mappings and Mime-Types stored. 
		/// </summary>
		protected ServerSettings settings;

		/// <summary>
		/// A Handler that is responsable for generating the response. 
		/// </summary>
		protected DeliveresponseHandler responseHandler;

		/// <summary>
		/// Sends the response to a client
		/// </summary>
		protected Sender send;
		internal SimpleLogger logger;
		protected ErrorHandler errorHandler;
		
		/// <summary>
		/// Monitors the server.
		/// </summary>
		public Monitor testMoni;
		
		protected WebServerMonitor realMonitor;
		

		protected bool zipRequested=false;


		public DeliveresponseHandler  ResponseHandler
		{
			get{return this.responseHandler;}
			set{this.responseHandler = value;}
		}

		/// <summary>
		/// Starts a new RequestProzessor Component. This includes loading of 
		/// settings and starting the momitor.
		/// </summary>
		/// <param name="configFilePath">The absolute path to the configfile
		/// for the request prozessor. This file has to be a special XML-File.
		///  </param>
		public RequestProzessorComponent(string configFilePath)
		{	
			//load logger
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput=true;
			this.logger.DebugOutput=true;
			this.logger.ErrorOutput=true;
			//load Seetings
			this.settings = new ServerSettings(configFilePath);

			this.responseHandler = new DeliveresponseHandler();
			this.errorHandler = new ErrorHandler();
			this.testMoni = new Monitor();
			this.realMonitor = new WebServerMonitor();
			
			this.testMoni.requestHandelt += new RequestServedHandler(this.realMonitor.ServedRequestReciver);
			this.testMoni.shutdown += new ServerShutdown(this.realMonitor.ServerShutdown);
		}


		/// <summary>
		/// This severs a request from a client. 
		/// </summary>
		/// <param name="aRequest">The Client request that has to be answered.</param>
		public void ServeRequest(HttpRequest aRequest)
		{
			HttPResponse res = new HttPResponse();
			try
			{			
				string GetRealPath = this.settings.GetPhysicalPath(aRequest.URI);
				IDeliverResponse responseChain = this.responseHandler.FixDeliverer(aRequest,GetRealPath);
				this.logger.Debug("Das ist der Pfad: "+GetRealPath);
				res.MineType = this.settings.GetMineTypeMapping(aRequest.FileExtension);
				
				res.MessageByte = responseChain.GetResponse;
				res.FileSize = responseChain.GetFileSize;
				res.StatusCode=" 200 OK ";
			}
			catch(FileNotFoundException e)
			{
				this.logger.Error("Ah error occured when searching for te file");
				this.logger.Error(e.Message);
				res.MessageByte = this.errorHandler.GenerateErrorMessage(" 404 FileNotFound ");
				res.FileSize= res.MessageByte.Length;
				res.StatusCode=" 404 File Not Found";

			}
			catch(Exception e)
			{
				Console.WriteLine(e.Message);
				Console.WriteLine(e.GetType());
				Console.WriteLine(e.Source);
				Console.WriteLine(e.StackTrace);
				res.MessageByte = this.errorHandler.GenerateErrorMessage(" 505 Server Problems ");
				res.FileSize= res.MessageByte.Length;
				res.StatusCode=" 505 Server Problems ";
			}
			this.send = new Sender(aRequest,res,this.zipRequested);
			this.testMoni.RequestServed(aRequest,res);
		}


		/// <summary>
		/// This class stops the RequestProzessor. This is essential because with this
		/// all requests are stored to disk. This is important for performace evaluation.
		/// Later this can be used for other features.
		/// </summary>
		public void ShutDown()
		{
			this.testMoni.ServerShutdown();
		}
	}
}

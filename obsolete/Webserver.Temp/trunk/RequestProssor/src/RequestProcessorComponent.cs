using System;
using System.IO;
using System.Text;
using Delivery;
using Request;
using RequestProssor.MonitorWebServer;
using SimpleLogging;

namespace RequestProssor
{
	/// <summary>
	/// This class represents the prozessor of the server. It computes a response
	/// to a single request and sends this request pack to the client. This class
	/// is also responsible for sendig error Message to the clients. This class is
	/// a Facade to the other classes of the Request Prozessor.
	/// </summary>
	public class RequestProcessorComponent
	{
		/// <summary>
		/// The settings for the prozessor. Here a mappings and Mime-Types stored. 
		/// </summary>
		protected ServerSettings settings;

		/// <summary>
		/// A Handler that is responsable for generating the response. 
		/// </summary>
		protected ResponseHandlerQueue responseHandlerQueue;

		/// <summary>
		/// Sends the response to a client
		/// </summary>
		protected Sender send;

		internal SimpleLogger logger;
//		protected ErrorHandler errorHandler;

		/// <summary>
		/// Monitors the server.
		/// </summary>
		public Monitor testMoni;

		protected WebServerMonitor realMonitor;


		protected bool zipRequested = false;


		public ResponseHandlerQueue ResponseHandlerQueue
		{
			get { return this.responseHandlerQueue; }
			set { this.responseHandlerQueue = value; }
		}

		/// <summary>
		/// Starts a new RequestProzessor Component. This includes loading of 
		/// settings and starting the momitor.
		/// </summary>
		/// <param name="configFilePath">The absolute path to the configfile
		/// for the request prozessor. This file has to be a special XML-File.
		///  </param>
		public RequestProcessorComponent(string configFilePath)
		{
			//load logger
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput = true;
			this.logger.DebugOutput = true;
			this.logger.ErrorOutput = true;
			//load Seetings
			this.settings = new ServerSettings(configFilePath);

			this.responseHandlerQueue = new ResponseHandlerQueue();
//			this.errorHandler = new ErrorHandler();
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
			HttpResponse res = new HttpResponse();
			try
			{
				string GetRealPath = this.settings.GetPhysicalPath(aRequest.URI);
				IResponseHandler handler = this.responseHandlerQueue.GetResponsibleHandler(aRequest, GetRealPath);
				this.logger.Debug("Das ist der Pfad: " + GetRealPath);
				res.MineType = this.settings.GetMineTypeMapping(aRequest.FileExtension);

				res.MessageByte = handler.GetResponse;
				res.FileSize = handler.GetFileSize;
				res.StatusCode = handler.StatusCode;
			}
			catch (Exception e)
			{
				Console.WriteLine(e.Message);
				Console.WriteLine(e.GetType());
				Console.WriteLine(e.Source);
				Console.WriteLine(e.StackTrace);
				res.MessageByte = GenerateErrorMessage(" 505 Server Problems ");
				res.FileSize = res.MessageByte.Length;
				res.StatusCode = " 505 Server Problems ";
			}
			this.send = new Sender(aRequest, res, this.zipRequested);
			this.testMoni.RequestServed(aRequest, res);
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

		private byte[] GenerateErrorMessage(string message)
		{
			string reply = "<html><head><title>An Error occurred!</title></head>";
			reply = reply + "<body>" + message + "</body></html>";
			return Encoding.ASCII.GetBytes(reply);
		}
	}
}
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
	/// Zusammenfassung für Class1.
	/// </summary>
	public class RequestProzessorComponent
	{
		ServerSettings settings;
		DeliveresponseHandler responseHandler;
		Sender send;
		SimpleLogger logger;
		ErrorHandler errorHandler;
		//for monitoring
		Monitor testMoni;
		WebServerMonitor realMonitor;
		

		public DeliveresponseHandler  ResponseHandler
		{
			get{return this.responseHandler;}
			set{this.responseHandler = value;}
		}

		public RequestProzessorComponent()
		{	
			//load logger
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput=true;
			this.logger.DebugOutput=true;
			this.logger.ErrorOutput=true;
			//load Seetings
			this.settings = new ServerSettings();

			this.responseHandler = new DeliveresponseHandler();
			
//			this.responseHandler.AddAditionalHandler(new DLL_Engin.DLL_EnginComponent());
//			this.responseHandler.AddAditionalHandler(new BibTexAnalyzerComponent());
//			this.responseHandler.AddAditionalHandler(new StaticFileProviderComponent());
//			
			this.errorHandler = new ErrorHandler();

			this.testMoni = new Monitor();
			this.realMonitor = new WebServerMonitor();
			

			this.testMoni.requestHandelt += new RequestServedHandler(this.realMonitor.ServedRequestReciver);
			this.testMoni.shutdown += new ServerShutdown(this.realMonitor.ServerShutdown);

			
		}


		public void ServeRequest(HttpRequest r)
		{
			//loadMapping

			HttPResponse res = new HttPResponse();
			
			
			try
			{
				
				string GetRealPath = this.settings.GetPhysicalPath(r.URI);
				IDeliverResponse responseChain = this.responseHandler.FixDeliverer(r,GetRealPath);
				this.logger.Debug("Das ist der Pfad: "+GetRealPath);
				res.MineType = this.settings.GetMineTypeMapping(r.FileExtension);
				
				res.MessageByte = responseChain.GetResponse;
				res.FileSize = responseChain.GetFileSize;
				res.StatusCode=" 202 OK ";
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
				res.MessageByte = this.errorHandler.GenerateErrorMessage(" 505 Server Problems ");
				res.FileSize= res.MessageByte.Length;
				res.StatusCode=" 505 Server Problems ";
			}
			this.send = new Sender(r,res);
			this.testMoni.RequestServed(r,res);
		}

		public void ShutDown()
		{
			this.testMoni.ServerShutdown();
		}




	}
}

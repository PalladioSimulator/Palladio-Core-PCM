using System;
using System.Threading;
using BibTexAnalyzer;
using Dispatcher;
using DLLEngine;
using RequestParser;
using RequestProssor;
using StaticFileProvider;
using Palladio.XMLConfigReader;

namespace Palladio.Webserver
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class Webserver
	{
		public static string shutDownToken = "hallo";
		protected static DispatcherComponent dispatcher;

		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		private static void Main(string[] args)
		{
			//Change this if you run it on your computer
			XMLConfigFileReader config = new XMLConfigFileReader(@"..\..\..\Config Files\ConfigWebServerWithStaiticCache.xml");
			//instanziere Komponeten
			ConfigTable ct = config.GetConfigTable("BaseSettings");
			string configFileDir = ct["configFileDir"].ToString();
			ConfigList components = config.GetConfigList("UsedComponents", "name", "ConfigFile");

			#region instance Components

			RequestProcessorComponent requestProcessor = new RequestProcessorComponent(ct["configFileDir"].ToString() + components["RequestProzessor"].ToString());

			requestProcessor.ResponseHandlerQueue.AddHandler(new StaticFileProviderComponent());
			requestProcessor.ResponseHandlerQueue.AddHandler(new DLLEngineComponent());
			requestProcessor.ResponseHandlerQueue.AddHandler(new BibTexAnalyzerComponent());

			//Parser
			RequestParserComponent parser = new RequestParserComponent();
			parser.AddHandler(new HttpHandler());

			dispatcher = new DispatcherComponent(ct["configFileDir"].ToString() + components["Dispatcher"].ToString());

			#endregion

			Console.WriteLine("Press q to quit;");
			Thread d = new Thread(new ThreadStart(StartListen));
			d.Start();
			dispatcher.StartServer(ref parser, ref requestProcessor);


		}

		public static void StartListen()
		{
			Console.WriteLine("Thread gestartet");
			while (true)
			{
				shutDownToken = Console.ReadLine();
				if (shutDownToken == "q")
					dispatcher.Shutdown();
			}
		}

	}
}
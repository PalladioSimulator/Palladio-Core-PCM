using System;
using SinglethreadedDispatcher;
using RequestProssor;
using RequestParser;
using System.Threading;
using Delivery;
using XMLConfigReader;

namespace SingleThreaddedServer
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	class Class1
	{
		public static string shutDownToken ="hallo";
		protected static SinglethreadedDispatcherComponent dispatcher;
		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		static void Main(string[] args)
		{
			//instanziere Komponeten

			
			//Change this if you run it on your computer

			XMLConfigFileReader config = new XMLConfigFileReader(@"C:\Dokumente und Einstellungen\Yvette\Eigene Dateien\Visual Studio Projects\WebserverComponents\Config Files\ConfigSingleThreaddedServer.xml");
			//instanziere Komponeten
			ConfigTable ct = config.GetConfigTable("BaseSettings");
			string configFileDir = ct["configFileDir"].ToString();
			ConfigList components = config.GetConfigList("UsedComponents","name","ConfigFile");
			

			#region instance Components
			RequestProzessorComponent deliverer = new RequestProzessorComponent(ct["configFileDir"].ToString()+components["RequestProzessor"].ToString());

			deliverer.ResponseHandler.AddAditionalHandler(new DLL_Engin.DLL_EnginComponent());
			deliverer.ResponseHandler.AddAditionalHandler(new BibTexAnalyzer.BibTexAnalyzerComponent());
			deliverer.ResponseHandler.AddAditionalHandler(new StaticFileProvider.StaticFileProviderComponent());
			
			//Parser
			RequestParserComponent parser= new RequestParserComponent();
			parser.AddAdditionalHandler(new RequestParser.HTTPHandler());

			dispatcher = new SinglethreadedDispatcherComponent(ct["configFileDir"].ToString()+components["SinglethreadedDispatcher"].ToString());
			#endregion
			


			Console.WriteLine("Press q to quit;");
			Thread d = new Thread(new ThreadStart(StartListen));
			d.Start();
			dispatcher.StartServer(ref parser,ref deliverer);
			
			

			
			
				
		}

		public static void StartListen()
		{
			Console.WriteLine("Thread gestartett");
			while (true)
			{
				//				Console.WriteLine("hallo");
				shutDownToken = Console.ReadLine();
				if(shutDownToken=="q")
					dispatcher.Shutdown();
			}
		}
		
	}
}


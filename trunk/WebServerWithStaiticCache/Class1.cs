using System;
using Dispatcher;
using RequestProssor;
using RequestParser;
using System.Threading;
using Delivery;
using XMLConfigReader;

namespace ComponentWebServer
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	class Class1
	{
		public static string shutDownToken ="hallo";
		protected static DispatcherComponent dispatcher;
		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		static void Main(string[] args)
		{
			//instanziere Komponeten

			//Change this if you run it on your computer
			XMLConfigFileReader config = new XMLConfigFileReader(@"C:\Dokumente und Einstellungen\Yvette\Eigene Dateien\Visual Studio Projects\WebserverComponents\Config Files\ConfigWebServerWithStaiticCache.xml");
			//instanziere Komponeten
			ConfigTable ct = config.GetConfigTable("BaseSettings");
			string configFileDir = ct["configFileDir"].ToString();
			ConfigList components = config.GetConfigList("UsedComponents","name","ConfigFile");
			
//			#region instance Components
			RequestProzessorComponent requestProzessor = new RequestProzessorComponent(ct["configFileDir"].ToString()+components["RequestProzessor"].ToString());
			//Intanz components which fullfill the DeliverResponse Interface;
			StaticFileProvider.StaticFileProviderComponent staticFileProvider = new StaticFileProvider.StaticFileProviderComponent();

			object contentProvider = (object) staticFileProvider;
			
			requestProzessor.ResponseHandler.AddAditionalHandler(new Delivery.ErrorHandler());
			requestProzessor.ResponseHandler.AddAditionalHandler(new StaticFileProvider.StaticFileProviderComponent());
			requestProzessor.ResponseHandler.AddAditionalHandler(new Cache.CacheComponent( ref contentProvider,ct["configFileDir"].ToString()+components["Cache"].ToString(),Cache.CacheComponent.CacheStrategie.leastFrequentlyUsed));
			
			//Parser
			RequestParserComponent parser= new RequestParserComponent();
			parser.AddAdditionalHandler(new RequestParser.HTTPHandler());

			dispatcher = new DispatcherComponent(ct["configFileDir"].ToString()+components["Dispatcher"].ToString());
//			#endregion
			


			Console.WriteLine("Press q to quit;");
			Thread d = new Thread(new ThreadStart(StartListen));
			d.Start();
			dispatcher.StartServer(ref parser,ref requestProzessor);
			
			

			
			
				
		}

		public static void StartListen()
		{
			Console.WriteLine("Thread gestartett");
			while (true)
			{
				shutDownToken = Console.ReadLine();
				if(shutDownToken=="q")
					dispatcher.Shutdown();
			}
		}
		
	}
}

using System;
using Dispatcher;
using RequestProssor;
using RequestParser;
using System.Threading;
using Delivery;
using XMLConfigReader;


namespace WebServerWithDynamicCache
{
		/// <summary>
		/// Zusammenfassung für Class1.
		/// </summary>
		class BaseVersion
		{
			public static string shutDownToken ="hallo";
			protected static DispatcherComponent dispatcher;
			/// <summary>
			/// Der Haupteinstiegspunkt für die Anwendung.
			/// </summary>
			[STAThread]
			static void Main(string[] args)
			{
				//Change this if you run it on your computer
				XMLConfigFileReader config = new XMLConfigFileReader(@"C:\Dokumente und Einstellungen\Yvette\Eigene Dateien\Visual Studio Projects\WebserverComponents\Config Files\ConfigWebServerWithDynamicCache.xml");
				//instanziere Komponeten
				ConfigTable ct = config.GetConfigTable("BaseSettings");
				string configFileDir = ct["configFileDir"].ToString();
				ConfigList components = config.GetConfigList("UsedComponents","name","ConfigFile");
			
				#region instance Components
				RequestProzessorComponent deliverer = new RequestProzessorComponent(ct["configFileDir"].ToString()+components["RequestProzessor"].ToString());
				DLL_Engin.DLL_EnginComponent dllEngin = new DLL_Engin.DLL_EnginComponent();
				object forCache = dllEngin;
				deliverer.ResponseHandler.AddAditionalHandler(new BibTexAnalyzer.BibTexAnalyzerComponent());
				deliverer.ResponseHandler.AddAditionalHandler(new StaticFileProvider.StaticFileProviderComponent());
				deliverer.ResponseHandler.AddAditionalHandler(dllEngin);
				deliverer.ResponseHandler.AddAditionalHandler(new Cache.CacheComponent(ref forCache,ct["configFileDir"].ToString()+components["Cache"].ToString(),Cache.CacheComponent.CacheStrategie.leastFrequentlyUsed));
			
				//Parser
				RequestParserComponent parser= new RequestParserComponent();
				parser.AddAdditionalHandler(new RequestParser.HTTPHandler());

				dispatcher = new DispatcherComponent(ct["configFileDir"].ToString()+components["Dispatcher"].ToString());
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




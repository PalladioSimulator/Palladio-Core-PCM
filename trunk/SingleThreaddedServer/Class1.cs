using System;
using SinglethreadedDispatcher;
using RequestProssor;
using RequestParser;
using System.Threading;
using Delivery;

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
			#region instance Components
			RequestProzessorComponent deliverer = new RequestProzessorComponent();

			deliverer.ResponseHandler.AddAditionalHandler(new DLL_Engin.DLL_EnginComponent());
			deliverer.ResponseHandler.AddAditionalHandler(new BibTexAnalyzer.BibTexAnalyzerComponent());
			deliverer.ResponseHandler.AddAditionalHandler(new StaticFileProvider.StaticFileProviderComponent());
			
			//Parser
			RequestParserComponent parser= new RequestParserComponent();
			parser.AddAdditionalHandler(new RequestParser.HTTPHandler());

			dispatcher = new SinglethreadedDispatcherComponent();
			#endregion
			


			Console.WriteLine("Press q to quit;");
			Thread d = new Thread(new ThreadStart(StartListen));
			d.Start();
			dispatcher.StartServer(1233,ref parser,ref deliverer);
			
			

			
			
				
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


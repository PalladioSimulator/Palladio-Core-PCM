using System;
using Dispatcher;
using RequestProssor;
using RequestParser;
using System.Threading;
using Delivery;

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
//			#region instance Components
			RequestProzessorComponent requestProzessor = new RequestProzessorComponent();
			//Intanz components which fullfill the DeliverResponse Interface;
			StaticFileProvider.StaticFileProviderComponent staticFileProvider = new StaticFileProvider.StaticFileProviderComponent();


			
			requestProzessor.ResponseHandler.AddAditionalHandler(new Delivery.ErrorHandler());
			requestProzessor.ResponseHandler.AddAditionalHandler(new StaticFileProvider.StaticFileProviderComponent());
			requestProzessor.ResponseHandler.AddAditionalHandler(new StaticCache.StaticCacheComponent(ref staticFileProvider));
			
			//Parser
			RequestParserComponent parser= new RequestParserComponent();
			parser.AddAdditionalHandler(new RequestParser.HTTPHandler());

			dispatcher = new DispatcherComponent();
//			#endregion
			


			Console.WriteLine("Press q to quit;");
			Thread d = new Thread(new ThreadStart(StartListen));
			d.Start();
			dispatcher.StartServer(1233,ref parser,ref requestProzessor);
			
			

			
			
				
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

using System;
using Dispatcher;
using RequestProssor;
using RequestParser;
using System.Threading;

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
			#region instance Components
			RequestProzessorComponent deliverer = new RequestProzessorComponent();
			//Parser
			RequestParserComponent parser= new RequestParserComponent();
			parser.AddAdditionalHandler(new RequestParser.HTTPHandler());

			dispatcher = new DispatcherComponent();
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

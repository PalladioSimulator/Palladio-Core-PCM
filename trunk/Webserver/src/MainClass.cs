using System;
using System.Threading;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverFactory;

namespace Palladio.Webserver
{
	/// <summary>
	/// MainClass. The main entrance point to execute the webserver.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.4  2005/02/27 17:51:53  kelsaka
	/// Added NDoc-Support (doc.xml-files are generated)
	///
	/// Revision 1.3  2005/01/22 16:42:56  kelsaka
	/// added configureable (XML) connection-string for the database;
	/// added thread-name for the main thread;
	/// fixed socket-error (updated documentation)
	///
	/// Revision 1.2  2004/12/18 10:06:48  kelsaka
	/// Added CVS-logs and some comments.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class MainClass
	{
		/// <summary>
		/// (Relative) Path to the xml-config-file. All other settings should be read out from the xml-file.
		/// </summary>
		private const string DEFAULT_XML_CONFIGURATION_FILE = "WebserverXML.xml";

		/// <summary>
		/// Main webserver-application start.
		/// </summary>
		/// <param name="args">
		/// First position: path to the config-files, including last backspace.<br />
		/// Second position: configuration-number<br />>
		/// Example-usage: Webserver "..\..\..\Config\" 1</param>
		public static void Main(string[] args)
		{
			// Get the config-path:
			string pathToConfigFile;
			try
			{
				pathToConfigFile = args[0];
			}
			catch (IndexOutOfRangeException)
			{
				pathToConfigFile = @"..\..\..\Config\"; //use default path
			}

			// The kind of component-configuration:
			string configType;

			try
			{
				configType = args[1];
			}
			catch (IndexOutOfRangeException)
			{
				configType = ""; //use default configuration
			}


			// Choose Factories
			IWebserverFactory webserverFactory = new DefaultWebserverFactory();
			IRequestFactory requestFactory = new DefaultRequestFactory();
			IPortListenerFactory portListenerFactory = new DefaultPortListenerFactory();

			Webserver webserver;
			// Check for the desired configuration type:
			switch (configType)
			{
					// default case; no special config-advices:
				case "":
					webserver = Webserver.CreateDefaultConfiguration(webserverFactory, requestFactory, portListenerFactory, pathToConfigFile, DEFAULT_XML_CONFIGURATION_FILE);
					break;

				default:
					webserver = Webserver.CreateDefaultConfiguration(webserverFactory, requestFactory, portListenerFactory, pathToConfigFile, DEFAULT_XML_CONFIGURATION_FILE);
					break;
			}

			Thread.CurrentThread.Name = "Main-Thread"; //name the thread for debugging purposes.
			Console.WriteLine("# Main-Thread: Webserver.Run started...");
			webserver.Start();
			// make the webserver shutdown explicitly.
			webserver.WebserverMonitor.WriteLogEntry("/=========================================\\");
			webserver.WebserverMonitor.WriteLogEntry("|  Press ENTER to shutdown the webserver. |");
			webserver.WebserverMonitor.WriteLogEntry("\\=========================================/");
			Console.ReadLine();
			webserver.Stop();
			Console.WriteLine("# Main-Thread: Webserver.Run exited...");
		}
	}
}
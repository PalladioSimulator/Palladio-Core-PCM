using System;
using System.IO;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.WebserverFactory;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Webserver
{
	/// <summary>
	/// Webserver.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.7  2004/10/27 05:52:49  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.6  2004/10/25 06:35:51  kelsaka
	/// added XML-reading-abilities
	///
	/// Revision 1.5  2004/10/23 14:08:36  kelsaka
	/// first steps on reading xml-config-files
	///
	/// Revision 1.4  2004/10/23 11:55:08  kelsaka
	/// added some parts of the building process
	///
	/// Revision 1.3  2004/10/22 16:19:56  kelsaka
	/// even more interface changes; configuration-alternative on loading the webserver
	///
	/// Revision 1.2  2004/10/22 09:52:43  kelsaka
	/// extended xml-config-files by logging-file-definitions
	///
	/// Revision 1.1  2004/10/22 09:37:19  kelsaka
	/// minor changes
	///
	///
	/// </pre>
	/// </remarks>
	public class Webserver
	{
		/// <summary>
		/// (Relative) Path to the xml-config-file. All other settings should be read out from the xml-file.
		/// </summary>
		private const string DEFAULT_XML_CONFIGURATION_FILE = "..\\..\\..\\Config\\WebserverXML.xml";


		public Webserver()
		{

		}

		/// <summary>
		/// Main webserver-application start.
		/// </summary>
		public static void Main(string[] args) 
		{
			Webserver webserver = new Webserver();
			Console.WriteLine("# Webserver.Run started...");
			webserver.Run(args);
			Console.WriteLine("# Webserver.Run exited...");
			
			Console.ReadLine();

		}


		/// <summary>
		/// Decides which component-configuration shall be built.
		/// </summary>
		private void Run(string[] args)
		{
			// The kind of component-configuration:
			string configType;

			try 
			{
				configType = args[0];
			}
			catch(IndexOutOfRangeException)
			{
				configType = ""; //use default configuration
			}


			// Check for the desired configuration type:
			switch(configType)
			{
				// default case; no special config-advices:
				case "":
					DefaultConfiguration();
					break;
			}
		}


		/// <summary>
		/// Creates a default component-configuration of the webserver.
		/// Builds and starts a running webserver using the webserver-factory.
		/// </summary>
		private void DefaultConfiguration()
		{

			DefaultWebserverFactory webserverFactory = new DefaultWebserverFactory();

			IConfigReader configReader = webserverFactory.CreateConfigReader();
			configReader.ReadConfiguration(DEFAULT_XML_CONFIGURATION_FILE);
			IWebserverConfiguration webserverConfiguration = new WebserverConfiguration(configReader.GetRoot());

			string[] f = webserverConfiguration.DefaultFileNames;

			IWebserverMonitor webserverMonitor = webserverFactory.CreateWebserverMonitor(webserverConfiguration);

			webserverMonitor.InitializeWriteAccess();
			webserverMonitor.WriteDebugMessage("hallo", 2);
			webserverMonitor.FinishWriteAccess();




		}
	}
}

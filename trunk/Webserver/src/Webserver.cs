using System;
using Palladio.Webserver.WebserverFactory;

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
		private const string DEFAULT_XML_CONFIGURATION_FILE = "..\\..\\WebserverXML.xml";


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
			catch(ArgumentOutOfRangeException e)
			{
				configType = "";
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

			webserverFactory.CreateConfigReader();

		}
	}
}

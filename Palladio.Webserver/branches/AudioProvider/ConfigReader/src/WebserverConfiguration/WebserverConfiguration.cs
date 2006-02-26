using System;
using System.Xml.Schema;
using Altova.Types;
using WebserverXML;


namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// WebserverConfiguration.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.7  2005/05/01 17:23:26  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.6  2005/02/02 17:34:56  kelsaka
	/// Added multi-threading to handle requests.
	/// Added short architectural description.
	///
	/// Revision 1.5  2004/11/14 10:55:51  kelsaka
	/// Completed listening on IP-Addresses. Now the IP the server is listening on defineable in the WebserverXML.xml. Pay attention that there might be some problems with the project-name of WebserverXML as XMLSpy sometimes produces lower-case-versions that cause problems on windows-systems.
	///
	/// Revision 1.4  2004/11/05 16:17:00  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.3  2004/10/29 16:30:38  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.2  2004/10/27 05:52:48  kelsaka
	/// fixed xml-parsing for defaultFiles; monitor-functions available; usable webserverconfiguration
	///
	/// Revision 1.1  2004/10/26 16:07:16  kelsaka
	/// added initial version to cvs
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class WebserverConfiguration : IWebserverConfiguration
	{


		private ConfigType configRoot;
		private string configFilesPath;

		/// <summary>
		/// The default constructor.
		/// </summary>
		/// <param name="configRoot">config to use.</param>
		public WebserverConfiguration(Altova.Xml.Node configRoot)
		{
			this.configRoot = (ConfigType)configRoot;
		}


		/// <summary>
		/// The path to the xml-config-files of the webserver. (Path without filename.)
		/// This value must be set explicitly.
		/// </summary>
		public string ConfigFilesPath
		{
			get { return configFilesPath; }
			set { configFilesPath = value; }
		}

		/// <summary>
		/// The IP-address the server shall listen on. For local use this will probably be "127.0.0.1". If the
		/// server shall be accessed by external clients the IP-address of the network-interface has to be used with which
		/// the server is connected to the client (especially on using multiple network-interfaces on one server).
		/// </summary>
		public string ListenIP
		{
			get 
			{
				return configRoot.ListenIP.Getip().Value;
			}
		}

		/// <summary>
		/// The name of the webserver. This name is sent with the http-header.
		/// </summary>
		public string ServerName
		{
			get
			{
				return configRoot.ServerName.Value;
			}
		}


		/// <summary>
		/// The root-path of documents (e. g. html-sites) delivered. (Relative paths are supported.)
		/// </summary>
		public string DocumentRoot
		{
			get
			{
				return configRoot.GetDocumentRoot().Getpath().Value;
			}
		}

		/// <summary>
		/// Path and filename of the logfile.
		/// </summary>
		public string LogFile
		{
			get
			{ 
				return configRoot.GetLogFile().Getpath().Value;
			}
		}

		/// <summary>
		/// Path and filenae of the debug-logfile.
		/// </summary>
		public string DebugFile
		{
			get
			{
				return configRoot.GetDebugFile().Getpath().Value;
			}
		}

		/// <summary>
		/// Ports the webserver is listening on.
		/// </summary>
		public int[] ListeningPorts
		{
			get
			{
				PortsType portsType = configRoot.GetPorts();
				int[] ports = new int[portsType.PortCount];

				for(int x = 0; x < portsType.PortCount; x++)
				{
					ports[x] = portsType.GetPortAt(x).Getnumber().IntValue();
				}
					
				return ports;
			}
		}

		/// <summary>
		/// Deliveres the mimetype for requested files. E. g. for use in webserver-headers.
		/// </summary>
		/// <param name="fileExtension">The file-extension including the ".", e. g. ".html".</param>
		/// <returns>Returns the mimetype for the requested extension. If no mimetype is defined "" should be returned.</returns>
		public string GetMimeTypeFor (string fileExtension)
		{

			for(int x = 0; x < configRoot.GetMimeTypes().GetMimeTypeCount(); x++)
			{

				if(configRoot.GetMimeTypes().GetMimeTypeAt(x).Getextension().Value.Equals(fileExtension))
				{
					return configRoot.GetMimeTypes().GetMimeTypeAt(x).Getcontent_type().Value;
				}
			
			}
			
			throw new ExtensionNotFoundException("Could not find extension \"" + fileExtension + "\"");
		}


		/// <summary>
		/// If no fitting Mimetype can be found for a given extension, this should be used. (see GetMimeTypeFor(string fileExtension))
		/// </summary>
		public string DefaultMimeType
		{
			get
			{
				return configRoot.GetMimeTypes().Getdefault_content_type().Value;
			}
		}


		/// <summary>
		/// Descendend priority of filenames that are delivered by default.
		/// </summary>
		public string[] DefaultFileNames
		{
			get
			{

				// order by "id" and and order
				int numberOfNames = configRoot.DefaultFiles.GetFileNameCount();

				string[] defaultFileNames = new string[numberOfNames];
				
				for(int x = 0; x < numberOfNames; x++)
				{
					for(int y = 0; y < numberOfNames; y++)
					{
						if(configRoot.GetDefaultFiles().GetFileNameAt(y).Getid().IntValue() == x)
						{
							defaultFileNames[x]	= configRoot.GetDefaultFiles().GetFileNameAt(y).getDOMNode().FirstChild.Value;
						}						
					}
				}
				
				return defaultFileNames;
			}
		}

	}
}

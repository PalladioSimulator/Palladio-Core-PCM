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

		public WebserverConfiguration(ConfigType configRoot)
		{
			this.configRoot = configRoot;
		}


		/// <summary>
		/// The root-path of documents (e. g. html-sites) delivered.
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

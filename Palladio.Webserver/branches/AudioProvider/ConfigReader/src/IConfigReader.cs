using System;
using System.IO;
using WebserverXML;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// IConfigReader. Interface for the configuration reader.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.7  2005/05/01 18:27:43  kelsaka
	/// - update: codestyle + documentation
	///
	/// Revision 1.6  2005/05/01 17:23:25  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.5  2004/11/05 16:17:00  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.4  2004/10/23 14:08:35  kelsaka
	/// first steps on reading xml-config-files
	///
	/// Revision 1.3  2004/10/23 11:55:08  kelsaka
	/// added some parts of the building process
	///
	/// Revision 1.2  2004/10/21 15:02:02  kelsaka
	/// added some more interfaces
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public interface IConfigReader
	{

		/// <summary>
		/// Read the configuration at the specified path. Afterwards the setting can be accessed by GetValue.
		/// </summary>
		/// <param name="configPathFile">Path to XML-config-file including filename. All Webserver-Config-XMLs need to have a root-element called "Config".</param>
		/// <returns>Deliveres the configuration root-object</returns>
		ConfigType ReadConfiguration (string configPathFile);
	}
}

using System;
using System.IO;
using WebserverXML;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// IConfigReader.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
		/// <param name="configFilePath">Path to XML-config-file</param>
		void ReadConfiguration(string configFilePath);


		/// <summary>
		/// Deliveres the configuration root-object. First run ReadConfiguration().
		/// </summary>
		/// <returns>The ConfigType-root-object.</returns>
		ConfigType GetRoot();

	}
}

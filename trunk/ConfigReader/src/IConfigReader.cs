using System;
using System.IO;

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

		void ReadConfiguration(string path);

		object GetValue(string key);

	}
}

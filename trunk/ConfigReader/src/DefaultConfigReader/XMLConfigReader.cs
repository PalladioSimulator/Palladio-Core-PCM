using System;
using System.IO;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// XMLConfigReader.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/10/21 15:02:02  kelsaka
	/// added some more interfaces
	///
	/// Revision 1.1  2004/10/17 17:25:09  kelsaka
	/// initial cvs-version; added general project structure
	///
	///
	/// </pre>
	/// </remarks>
	public class XMLConfigReader : IConfigReader
	{
		public XMLConfigReader()
		{

		}

		public IConfiguration ReadConfiguration (Path path)
		{
			throw new NotImplementedException ();
		}
	}
}

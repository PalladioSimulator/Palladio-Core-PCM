using System;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// IConfiguration. Note: currently unused TODO
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/10/26 16:07:16  kelsaka
	/// added initial version to cvs
	///
	///
	/// </pre>
	/// </remarks>
	public interface IConfiguration
	{
		

		object GetValue(string key);

	}
}

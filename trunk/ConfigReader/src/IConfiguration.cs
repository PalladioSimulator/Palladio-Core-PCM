using System;

namespace Palladio.Webserver.ConfigReader
{
	//TODO: Note: currently unused
	/// <summary>
	/// IConfiguration. Note: currently unused
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/11/21 17:10:03  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
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

using System;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// IConfiguration.
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
	public interface IWebserverConfiguration
	{
		
		/// <summary>
		/// The root-path of documents delivered.
		/// </summary>
		string DocumentRoot{get; set;}


		/// <summary>
		/// Path and filename of the logfile.
		/// </summary>
		string LogFile{get; set;}


		/// <summary>
		/// Path and filenae of the debug-logfile.
		/// </summary>
		string DebugFile{get; set;}


		/// <summary>
		/// Ports the webserver is listening on.
		/// </summary>
		int[] ListeningPorts{get; set;}

		
		/// <summary>
		/// Deliveres the mimetype for requested files. E. g. for use in webserver-headers.
		/// </summary>
		/// <param name="fileExtension">The file-extension including the ".", e. g. ".html".</param>
		/// <returns>Returns the mimetype for the requested extension. If no mimetype is defined "" should be returned.</returns>
		string GetMimeTypeFor(string fileExtension);

		
		/// <summary>
		/// Descendend priority of filenames that are delivered by default.
		/// </summary>
		string[] DefaultFileNames{get; set;}


	}
}

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
	/// Revision 1.2  2004/10/29 16:30:38  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// Revision 1.1  2004/10/26 16:07:16  kelsaka
	/// added initial version to cvs
	///
	///
	/// </pre>
	/// </remarks>
	public interface IWebserverConfiguration
	{
		
		/// <summary>
		/// The root-path of documents (e. g. html-sites) delivered.
		/// </summary>
		string DocumentRoot{get;}


		/// <summary>
		/// Path and filename of the logfile.
		/// </summary>
		string LogFile{get;}


		/// <summary>
		/// Path and filenae of the debug-logfile.
		/// </summary>
		string DebugFile{get;}


		/// <summary>
		/// Ports the webserver is listening on.
		/// </summary>
		int[] ListeningPorts{get;}

		
		/// <summary>
		/// Deliveres the mimetype for requested files. E. g. for use in webserver-headers.
		/// </summary>
		/// <param name="fileExtension">The file-extension including the ".", e. g. ".html".</param>
		/// <returns>Returns the mimetype for the requested extension. If no mimetype is defined "" should be returned.</returns>
		string GetMimeTypeFor(string fileExtension);


		/// <summary>
		/// If no fitting Mimetype can be found for a given extension, this should be used. (see GetMimeTypeFor(string fileExtension))
		/// </summary>
		string DefaultMimeType{get;}
		

		/// <summary>
		/// Descendend priority of filenames that are delivered by default.
		/// </summary>
		string[] DefaultFileNames{get;}


	}
}

using System;

namespace Palladio.Webserver.ConfigReader
{
	/// <summary>
	/// The interface of the webserver base configuration. Other components have their own
	/// configurations.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.5  2005/05/01 17:23:25  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.4  2004/11/14 10:55:51  kelsaka
	/// Completed listening on IP-Addresses. Now the IP the server is listening on defineable in the WebserverXML.xml. Pay attention that there might be some problems with the project-name of WebserverXML as XMLSpy sometimes produces lower-case-versions that cause problems on windows-systems.
	///
	/// Revision 1.3  2004/11/05 16:17:00  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
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
		/// The path to the xml-config-files of the webserver. (Path without filename.)
		/// This value must be set explicitly.
		/// </summary>
		string ConfigFilesPath{get; set;}

		/// <summary>
		/// The IP-address the server shall listen on. For local use this will probably be "127.0.0.1". If the
		/// server shall be accessed by external clients the IP-address of the network-interface has to be used with which
		/// the server is connected to the client (especially on using multiple network-interfaces on one server).
		/// </summary>
		string ListenIP{get;}

		/// <summary>
		/// The name of the webserver. This name is sent with the http-header.
		/// </summary>
		string ServerName{get;}

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

using System;
using System.Net.Sockets;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// IHTTPRequest.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.3  2004/10/29 16:30:39  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// </pre>
	/// </remarks>
	public interface IHTTPRequest
	{ 


		/// <summary>
		/// The version of the http-request.
		/// </summary>
		string HttpVersion {get; set;}

		/// <summary>
		/// The name of the file that is requested by the client (including the suffix: e. g. "index.html").
		/// </summary>
		string RequestedFileName {get; set;}


		/// <summary>
		/// The file-suffix like ".html" of the requested file.
		/// </summary>
		string RequestedFileType {get; set;}


		/// <summary>
		/// The name of the directory that is requested by the client.
		/// </summary>
		string RequestedDirectoyName {get; set;}
		

		/// <summary>
		/// Represents the http method-type: e. g. get and post.
		/// </summary>
		int RequestedMethodType { get; set; }


		/// <summary>
		/// The Socket of the request.
		/// </summary>
		Socket Socket {get; set;}


		/// <summary>
		/// Creates a new key / value-pair if the key is new, otherwise updates the value for the key.
		/// Intention: use for the variables values of the http-request.
		/// </summary>
		/// <param name="key">The key.</param>
		/// <param name="value">Value for the given key.</param>
		void SetVariableValue(string key, string value);


		/// <summary>
		/// Returns the value for the given key. Use for the http-request variables values.
		/// </summary>
		/// <param name="key">The key to return the value for.</param>
		/// <returns>The Value for the key.</returns>
		string GetVariableValue(string key);



	}
}

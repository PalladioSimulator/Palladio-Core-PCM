using System;
using System.Collections;
using System.Net.Sockets;

namespace Palladio.Webserver.Request
{
	/// <summary>
	/// DefaultHTTPRequest.
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2004/10/29 16:30:39  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// </pre>
	/// </remarks>
	public class DefaultHTTPRequest : IHTTPRequest
	{
		

		private string requestedFileName;
		private string requestedFileType;
		private string requestedDirectoyName;
		private string httpVersion;
		private int methodType;
		private Socket socket;
		private Hashtable variables;


		public DefaultHTTPRequest()
		{
			variables = new Hashtable();
		}

		/// <summary>
		/// The version of the http-request.
		/// </summary>
		public string HttpVersion
		{
			get { return httpVersion; }
			set { httpVersion = value; }
		}

		/// <summary>
		/// The name of the file that is requested by the client.
		/// </summary>
		public string RequestedFileName
		{
			get { return requestedFileName; }
			set { requestedFileName = value; }
		}

		/// <summary>
		/// The file-suffix like ".html" of the requested file.
		/// </summary>
		public string RequestedFileType
		{
			get { return requestedFileType; }
			set { requestedFileType = value; }
		}

		/// <summary>
		/// The name of the directory that is requested by the client.
		/// </summary>
		public string RequestedDirectoyName
		{
			get { return requestedDirectoyName; }
			set { requestedDirectoyName = value; }
		}

		/// <summary>
		/// Represents the http method-type: e. g. get and post.
		/// Use GET_METHOD and POST_METHOD to declare the values.
		/// </summary>
		public int RequestedMethodType
		{
			get { return methodType; }
			set { methodType = value; }
		}

		/// <summary>
		/// The Socket of the request.
		/// </summary>
		public Socket Socket
		{
			get { return socket; }
			set { socket = value; }
		}

		/// <summary>
		/// Creates a new key / value-pair if the key is new, otherwise updates the value for the key.
		/// Intention: use for the variables values of the http-request.
		/// </summary>
		/// <param name="key">The key. Attention: duplicate keys are overwriten.</param>
		/// <param name="value">Value for the given key.</param>
		public void SetVariableValue (string key, string value)
		{
			if(variables.ContainsKey(key))
			{
				variables.Remove(key);
			}
			variables.Add(key, value);
		}

		/// <summary>
		/// Returns the value for the given key. Use for the http-request variables values.
		/// </summary>
		/// <param name="key">The key to return the value for.</param>
		/// <returns>The Value for the key.</returns>
		public string GetVariableValue (string key)
		{
			return (string)variables[key];
		}


	}
}

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
	/// Revision 1.2  2005/01/29 21:47:44  kelsaka
	/// Added continuous use of NetworkStream (instead of Socket)
	///
	/// Revision 1.1  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.5  2004/11/21 17:10:03  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	/// Revision 1.4  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// Revision 1.3  2004/10/31 16:30:40  kelsaka
	/// preparing parsing of post-requests
	///
	/// Revision 1.2  2004/10/29 16:30:39  kelsaka
	/// a lot of changes: xml-schema changed: added default mimetype; delivering file with the static file provider; changed parsing of filename; added parsing of variables; Altova-xml-spy-classes updated, ...
	///
	/// </pre>
	/// </remarks>
	internal class DefaultHTTPRequest : IHTTPRequest
	{
		

		private string requestedFileName;
		private string requestedFileType;
		private string requestedDirectoyName;
		private string httpVersion;
		private int methodType;
		private NetworkStream networkStream;
		private Hashtable variablesGET;
		private Hashtable variablesPOST;
        private Hashtable metaDataHash;

		public DefaultHTTPRequest()
		{
			variablesGET = new Hashtable();
			variablesPOST = new Hashtable();
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
		public string RequestedDirectoryName
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
		/// NetworkStream to read / write data from / to the client.
		/// </summary>
		public NetworkStream NetworkStream
		{
			get { return networkStream; }
			set { networkStream = value; }
		}

		/// <summary>
		/// Creates a new key / value-pair if the key is new, otherwise updates the value for the key.
		/// Intention: use for the GET-variables values of the http-request.
		/// </summary>
		/// <param name="key">The key. Attention: duplicate keys are overwriten.</param>
		/// <param name="value">Value for the given key.</param>
		public void SetGETVariableValue (string key, string value)
		{
			if(variablesGET.ContainsKey(key))
			{
				variablesGET.Remove(key);
			}
			variablesGET.Add(key, value);
		}

		/// <summary>
		/// Creates a new key / value-pair if the key is new, otherwise updates the value for the key.
		/// Intention: use for the POST-variables values of the http-request.
		/// </summary>
		/// <param name="key">The key. Attention: duplicate keys are overwriten.</param>
		/// <param name="value">Value for the given key.</param>
		public void SetPOSTVariableValue (string key, string value)
		{
			if(variablesPOST.ContainsKey(key))
			{
				variablesPOST.Remove(key);
			}
			variablesPOST.Add(key, value);
		}

		/// <summary>
		/// Returns the value for the given key. Use for the http-request variables values. GET-Method.
		/// </summary>
		/// <param name="key">The key to return the value for.</param>
		/// <returns>The Value for the key.</returns>
		public string GetGETVariableValue (string key)
		{
			return (string)variablesGET[key];
		}

		/// <summary>
		/// Returns the value for the given key. Use for the http-request variables values. POST-Method.
		/// </summary>
		/// <param name="key">The key to return the value for.</param>
		/// <returns>The Value for the key.</returns>
		public string GetPOSTVariableValue (string key)
		{
			return (string)variablesPOST[key];
		}

		/// <summary>
		/// Returns the internal Hashtable that contains the key-value-pairs for the variables of a GET-Request.
		/// </summary>
		public Hashtable POSTHashtable
		{
			get 
			{ 
				return variablesPOST;
			}
		}

		/// <summary>
		/// Returns the internal Hashtable that contains the key-value-pairs for the variables of a POST-Request.
		/// </summary>
		public Hashtable GETHashtable
		{
			get
			{
				return variablesGET;
			}
		}

        public Hashtable MetaData
        {
            get
            {
                return metaDataHash;
            }
            set
            {
                metaDataHash = value;
            }
        }

	}
}

using System;
using System.Collections;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Web;
using Altova.Xml;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.HTTPRequestProcessorTools;
using Palladio.Webserver.Request;
using Palladio.Webserver.WebserverMonitor;
using SimpleTemplateFileProviderXML;

namespace Palladio.Webserver.AudioFileProvider
{
	/// <summary>
	/// SimpleTemplateFileProvider. Using the variables-names of the request (POST and GET) this component replaces
	/// all occurences of the variables-names surrounded by defined delimiters (definition in SimpleTemplateFileProvider.xml)
	/// by their given values.
	/// Remark: First the POST-Variables are replaced in the second step the GET-Variables are replaced.
	/// This component only handles the requests for the file-types specified in its config-xml-file. Other requests are
	/// passed to the COR-Successor.
	/// 
	/// The file-types (extensions like .shtml) that are handled have to be specified in the config-xml-file of the
	/// SimpleTemplateFileProvider.
	/// </summary>
	/// 
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.11  2005/05/01 17:23:26  kelsaka
	/// - added further documentation
	/// - extracted IHTTPRequestProcessorTools as own project
	/// - made server name configureable by config files
	///
	/// Revision 1.10  2005/05/01 10:41:05  kelsaka
	/// - added gzip file compression
	///
	/// Revision 1.9  2005/01/29 21:47:44  kelsaka
	/// Added continuous use of NetworkStream (instead of Socket)
	///
	/// Revision 1.8  2004/12/15 00:32:33  sliver
	/// Thread handling changed:
	///   Instead of calling the Thread.Abort() method, each
	///   thread instance contains a variable IsRunning which is
	///   checked after each iteration through the loop.
	///   If it is set to false, the tread terminates. This has been introduced to
	///   establish a clean thread exit. The call of the Abort () method causes
	///   an exeption in the aborted thread. This execption is forwarded through
	///   the whole call stack, even if it is catched. So, every method on the stack
	///   is informed about the thread exit. However, this causes some trouble
	///   for the logging of the Webserver behaviour. Furthermore, the
	///   Thread.Abort() and Thread.Interrupt() methods do not terminate
	///   threads that are blocked. The call of the method TcpListener.AcceptSocket()
	///   blocks the thread until a new connection is opened. So, the running
	///   threads are not aborted until a new connection is opened.
	///
	///  Now, we proceed as follows to terminate the Webserver. For all
	///  listening treads, we set the IsRunning variable to false. Next, we need
	///  to unblock the threads. Therfore, we open a dummy connection to the
	///  IP and port the tread is listening on. When re-iterating the the loop, the
	///  check of the IsRunning variable causes the thread to terminate.
	///
	/// ListeningTread war renamed to PortListener
	/// interfaces 'IPortListener' and IBibTexDB' added
	///
	/// Revision 1.7  2004/12/06 05:20:21  sliver
	/// - RequestFactory added
	/// - Create Methods for IHTTPRequestProcessorTools and IWebserverConfiguration added to the WebserverFactory
	/// - WebserverConfigurator added
	///
	/// Revision 1.6  2004/11/28 19:01:32  kelsaka
	/// Added simple support for searching on a database, that contains BibTeX-Entries, added test-documents, added DB-test-content, added comments
	///
	/// Revision 1.5  2004/11/21 17:10:03  kelsaka
	/// Added BibTeX-Component; added enumerator for request-types; added test-html-documents
	///
	/// Revision 1.4  2004/11/08 20:42:44  kelsaka
	/// The webserver is now listening on all specified ports
	///
	/// Revision 1.3  2004/11/07 11:13:01  kelsaka
	/// Added recoding of variables-values representations; added support for dynamic pages created by HTTP GET; fixed HTML-field-names in test-documents.
	///
	/// Revision 1.2  2004/11/06 18:09:28  kelsaka
	/// Changed handling of delimiters for variables in template-files.
	///
	/// Revision 1.1  2004/11/05 16:17:01  kelsaka
	/// Added support for simple dynamic content (SimpleTemplateFileProvider). For this added a new xml-config-file and auto-generated XML-classes.
	/// Code refactoring.
	///
	/// </pre>
	/// </remarks>
	public class AudioFileProvider : IHTTPRequestProcessor
	{
		private IWebserverConfiguration webserverConfiguration;
		private IWebserverMonitor webserverMonitor;
		private IHTTPRequestProcessor corSuccessor;
		private AudioFileProviderConfiguration audioConfiguration;
		private IHTTPRequestProcessorTools requestProcessorTools;

		/// <summary>
		/// (Relative) Path to the xml-config-file. All other settings should be read out from the xml-file.
		/// </summary>
		private const string DEFAULT_XML_CONFIGURATION_FILE = "SimpleTemplateFileProviderXML.xml";
		

		public AudioFileProvider(IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			this.corSuccessor = corSuccessor;
			this.webserverMonitor = webserverMonitor;
			this.webserverConfiguration = webserverConfiguration;
			this.audioConfiguration = readConfiguration();
			this.requestProcessorTools = requestProcessorTools;
		}





		/// <summary>
		/// Proceeds on creating a answer to the httpRequest.
		/// </summary>
		/// <param name="httpRequest">The HTTP-Request.</param>
		public void HandleRequest (IHTTPRequest httpRequest)
		{
			if (!HasRequestFileTypeToBeHandled(httpRequest))
			{
				// As the extension (indentified by the file-type (e. g. ".html")) shall not be handled
				// by the SimpleTemplateProvider - Call the COR-Successor.
				corSuccessor.HandleRequest(httpRequest);
				return;
			}


			// Path to the requestedFile:
			string completePath = requestProcessorTools.BuildCompletePath(httpRequest.RequestedDirectoryName);
			if(!Directory.Exists(completePath))
			{	
				corSuccessor.HandleRequest(httpRequest);
				return;
			}



			// The filename effectively requested by the client.
			// E. g. if only a directoy is specified this is the default filename:
			if(!File.Exists(completePath + httpRequest.RequestedFileName))
			{	
				corSuccessor.HandleRequest(httpRequest);
				return;
			}

			webserverMonitor.WriteLogEntry("Full filename and path effectively requested: " + completePath + httpRequest.RequestedFileName);

			// The MimeType of the requested File.
			string fileMimeType = requestProcessorTools.GetFileMimeTypeFor(httpRequest.RequestedFileType);
			webserverMonitor.WriteLogEntry("Mime Type found: " + fileMimeType);


			Console.WriteLine("Audiofile!");

			string fileName = httpRequest.GetPOSTVariableValue("fileName");
			string fileData = httpRequest.GetPOSTVariableValue("fileContent");

			using(StreamWriter sw = new StreamWriter(fileName))
			{
				sw.Write(fileData);
				sw.Flush();
			}


			// Open and read the source-file:
			byte[] fileContent = requestProcessorTools.OpenFile (completePath, httpRequest.RequestedFileName);
			string fileContentString = Encoding.ASCII.GetString(fileContent);

			// create the response-content and send it to the client:
			CreateDynamicContentAndDeliverFile (fileContentString, httpRequest, fileMimeType); // WriteLogEntry
		}



		/// <summary>
		/// Uses the template-replacing for the variables names to create the dynamic content. Searches for all 
		/// occurences of [VariablesNameDelimiter][VariablesName][VariablesNameDelimiter] an replaces them by variables-values.
		/// </summary>
		/// <param name="fileContentString">String representing the file content.</param>
		/// <param name="httpRequest">The HTTPRequest.</param>
		/// <param name="fileMimeType">The recognized mime-type.</param>
		private void CreateDynamicContentAndDeliverFile (string fileContentString, IHTTPRequest httpRequest, string fileMimeType)
		{
			// First: replace POST-Variables-Names:
			IEnumerator enumer = httpRequest.POSTHashtable.GetEnumerator();
			fileContentString = SearchAndReplaceKeysByValues (enumer, fileContentString);

			// Second: replace GET-Variables-Names:
			enumer = httpRequest.GETHashtable.GetEnumerator();
			fileContentString = SearchAndReplaceKeysByValues (enumer, fileContentString);

			requestProcessorTools.SendContentToClient(fileContentString, httpRequest.HttpVersion, fileMimeType, httpRequest.NetworkStream);
			webserverMonitor.WriteLogEntry("Successfully sent response to client.");
		}


		/// <summary>
		/// Seaches for key-occurences and replaces them by thier values. This includes the convertion of character representation
		/// from in- and output. This method converts as well line-breaks to "&lt;br /&gt;".
		/// </summary>
		/// <param name="enumer">The key-value-pairs representing variables-names and their values.</param>
		/// <param name="fileContentString">The string where the key are replaced.</param>
		/// <returns>The string where the keys are replaced by thier values using the enumer.</returns>
		private string SearchAndReplaceKeysByValues (IEnumerator enumer, string fileContentString)
		{
			string value;
			string key;
			string searchString;

			// iterates over all variables-names and replaces the keys by their values.			
			while(enumer.MoveNext())
			{
				key = (string)((DictionaryEntry)enumer.Current).Key;
				value = (string)((DictionaryEntry)enumer.Current).Value;			

				// unescape value-chars from URI-Encoding using the default representation.
				// e. g. a whitespace is encoded by "+" or a linebreak by "%0A".
				Encoding encoding = Encoding.Default;
				value = HttpUtility.UrlDecode(value, encoding);
				
				// encode special characters for HTML-representation, e. g. "&" to "&amp;"
				value = HttpUtility.HtmlEncode(value);

				// convert linebreak to HTML-Linebreak:
				value = value.Replace("\n", "<br />");

				searchString = audioConfiguration.VariablesNameDelimiter + key + audioConfiguration.VariablesNameDelimiter;
				fileContentString = fileContentString.Replace(searchString, value);
			}
			return fileContentString;
		}


		/// <summary>
		/// Checks the file-extensions that are associated to this component and compares it with the file-type
		/// of the request.
		/// </summary>
		/// <param name="httpRequest">httpRequest containing the file-extensions.</param>
		/// <returns>true, if extension has to be handled; false else.</returns>
		private bool HasRequestFileTypeToBeHandled (IHTTPRequest httpRequest)
		{
			for(int x = 0; x < audioConfiguration.HandledFileExtensions.Length; x++)
			{
				if(audioConfiguration.HandledFileExtensions[x] == httpRequest.RequestedFileType)
				{
					return true;
				}				
			}
			return false;
		}


		/// <summary>
		/// Reads the configuration at the specified path and creates a SimpleTemplateFileProviderConfiguration out of the
		/// information read.
		/// </summary>
		/// <returns></returns>
		private AudioFileProviderConfiguration readConfiguration ()
		{
			SimpleTemplateFileProviderXMLDoc doc = new SimpleTemplateFileProviderXMLDoc();
			doc.SetRootElementName("", "Config");

			ConfigType root = new ConfigType();

			try 
			{
				root = new ConfigType(doc.Load(webserverConfiguration.ConfigFilesPath + DEFAULT_XML_CONFIGURATION_FILE));
			}
			catch (FileNotFoundException e)
			{
				webserverMonitor.WriteDebugMessage(e.ToString(), 1);
			}
			catch (XmlException e)
			{
				webserverMonitor.WriteDebugMessage(e.ToString(), 1);
			}

			return new AudioFileProviderConfiguration(root);
		}


	}
}

using System;
using System.Xml;
using System.Collections;
using System.IO;


namespace Palladio.XMLConfigReader
{
	/// <summary>
	/// This class is used to load Xml Config files from the file system. 
	/// It delivers methods to create <c>ConfigTables</c> and <c>ConfigList</c>
	/// </summary>
	public class XMLConfigFileReader
	{
		/// <summary>
		/// The read XML document
		/// </summary>
		protected XmlDocument doc;

		/// <summary>
		/// Contains the path, where the xml document is located.
		/// </summary>
		protected string filename;

		/// <summary>
		/// Initates the XMLConfigFileReader.
		/// </summary>
		/// <param name="aFilename">A string which contains the pysical path to the config XML file </param>
		public XMLConfigFileReader(string aFilename)
		{
			this.filename = aFilename;
			XmlTextReader xtr = new XmlTextReader(new StreamReader(aFilename));
			this.doc = new XmlDocument();
			this.doc.Load(xtr);
		}

		/// <summary>
		/// Creates a <c>ConfigList</c> which root element is tagValue.
		/// <param name="tagValue">Der Tagname des Knoten unter dem sich die zu erstellende Liste befindet</param>
		/// <param name="key">Der Schlüsselwert, dem die Einträge zugeordnet werden sollen. Im Beispiel wäre das "schluessel"</param>
		/// <param name="obj">Der Wert, der dem Schlüssel zugeordnet werden soll. Im Beispiel ist das "wert".</param>
		/// <returns>Eine Liste mit Key Value Paaren </returns>
		/// </summary>
		public ConfigList GetConfigList(string tagValue,string key, string val)
		{
			Console.WriteLine(this.doc);
			ConfigList configList = new ConfigList();
			configList.Name = tagValue;
			XmlNodeList node = this.doc.GetElementsByTagName(tagValue);
			foreach(XmlNode n in node)
			{
				XmlNodeList list = n.ChildNodes;
				foreach(XmlNode d in list)
				{
					configList.AddPair(d[key].InnerText,d[val].InnerText);
				}
			}
			foreach(DictionaryEntry di in configList)
			{
				Console.WriteLine(di.Value.ToString());
			}
			return configList;
		}


		/// <summary>
		/// Delivers a <c>ConfigTable</c> from the
		/// </summary>
		/// <param name="tagValue">The root element for the table</param>
		/// <returns>The generated <c>ConfigTable</c></returns>
		public ConfigTable GetConfigTable(string tagValue)
		{
			ConfigTable keyValueList = new ConfigTable();
			XmlNode node = this.doc[tagValue];
			if(node.HasChildNodes)
			{
				IEnumerator enumerate = node.ChildNodes.GetEnumerator();
				XmlNode currentNode;
				while(enumerate.MoveNext())
				{
					currentNode = (XmlNode) enumerate.Current;
					keyValueList.Add(currentNode.Name,currentNode.InnerText);
				}

			}
			return keyValueList;
		}


		/// <summary>
		/// Delives a single XML Node.
		/// </summary>
		/// <param name="tagValue">The Tag Name</param>
		/// <returns>Result</returns>
		public XmlNode GetXmlNode(string tagValue)
		{
			try
			{
				return this.doc[tagValue];
			}
			catch(Exception)
			{
				throw new ApplicationException("The TagValue doesn't exist in "+this.filename);
			}
		}
	}
	
}

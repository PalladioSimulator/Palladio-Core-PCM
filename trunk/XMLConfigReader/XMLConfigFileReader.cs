using System;
using System.Xml;
using System.Collections;
using System.IO;

namespace XMLConfigReader
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class XMLConfigFileReader
	{
		protected XmlDocument doc;
		protected string path;
		public XMLConfigFileReader(string path)
		{
			this.path = path;
			Console.WriteLine("Starte XML Reader Config");
			Console.WriteLine(this.path);

			
			StreamReader file = new StreamReader(path);
			string xmlContent = file.ReadToEnd();
			XmlTextReader xtr = new XmlTextReader(new StringReader(xmlContent));
			this.doc = new XmlDocument();
			this.doc.Load(xtr);
		}


		/// <summary>
		/// Deutsch: Erstellt eine Liste von Key Value Paaren. Besonders ist, dass es sich bei
		/// diesern Liste um einen Unterkonten der XML Congig Datei handelt. 
		/// Zum besseren Verständnis ein Beispiel:
		/// <meineConfigDatei>
		///		<andererEinfacherKram>ein Einzelwert</andererEinfacherKram>
		///		<meineListe>
		///			<item>
		///				<schluessel>erster Sclüssel</schluessel>
		///				<wert>erster Wert</wert>
		///			</item>
		///				<schluessel>zweiter Schluessel</schluessel>
		///				<wert>zweiter Wert</wert>
		///			<item>
		///			</item>
		///		</meineListe>
		/// </meineConfigDatei>
		/// Diese Metode würde als TagValue meine Liste erhalten. Und würde dann eine
		/// ConfigList mit folgenden Werten zurückgeben:
		/// erster Schluessel	erster Wert
		/// zweiter Schliessel	zweiter Wert
		/// </summary>
		/// <param name="tagValue">Der Tagname des Knoten unter dem sich die zu erstellende Liste befindet</param>
		/// <param name="key">Der Schlüsselwert, dem die Einträge zugeordnet werden sollen. Im Beispiel wäre das "schluessel"</param>
		/// <param name="obj">Der Wert, der dem Schlüssel zugeordnet werden soll. Im Beispiel ist das "wert".</param>
		/// <returns>Eine Liste mit Key Value Paaren </returns>
		public ConfigList GetConfigList(string tagValue,string key, string val)
		{
//			string key = "RequestedDir";
//			string val = "realDir";
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

		public XmlNode GetXmlNode(string tagValue)
		{
			try
			{
				return this.doc[tagValue];
			}
			catch(Exception)
			{
				throw new ApplicationException("The TagValue doesn't exist in "+this.path);
			}
		}
		public static void Main (string[] args)
		{
			XMLConfigFileReader test = new XMLConfigFileReader(@"C:\Dokumente und Einstellungen\Yvette\Eigene Dateien\Visual Studio Projects\WebserverComponents\XMLConfigReader\UnitTest\TestXMLFile.xml");
		}

		public string printKeyValueList(ConfigTable t)
		{
			string result= "";
			foreach(DictionaryEntry de in t)
			{
				result += "Key: "+de.Key+" Value: "+de.Value+"\n";
			}
			return result;
		}

	}
	
}

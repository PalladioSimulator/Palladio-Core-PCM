using System;
using System.Collections;
using System.IO;
using System.Xml;

namespace MySmallWebServer
{
	/// <summary>
	/// Does everythings which has to do with In and Output of the server.
	/// Checks if files are avalable, mapps dicrectories ...
	/// Loads the settings of this server from a xml File named serverSettings.xml
	/// This settings contains the server Root, all suported mine Types, the port
	/// on which the Server is waiting for requestes. Default file names ans dirs.
	/// </summary>
	public class ServerSettings
	{
	
		/// <summary>
		/// A String witch contains the RootDir of the server, here all
		/// documents are stored
		/// </summary>
		private string serverRoot;

		/// <summary>
		/// A Hashtable which contains a mapping fot Mine Types.
		/// Key is a fileextension like .htm
		/// Value is the suitable mine Type
		/// </summary>
		private Hashtable mineTypes;


		/// <summary>
		/// When a directory like sample.org/test/ ist called by the client
		/// this is not the dir which on ServerDisk, for this reason this 
		/// hashatable contains a mapping between this.
		/// Key: The requested dir form the client
		/// Value: The real dir on server disk
		/// </summary>
		private Hashtable physicalDir;

		/// <summary>
		/// The port on which the server is running
		/// </summary>
		private int port;

		/// <summary>
		/// the default file, when none is requested as <code>string</code>
		/// </summary>
		private string dafaultFile;

		/// <summary>
		/// Retruns the mapping between fileextensions and minetypes as
		/// <code>Hashtable</code>
		/// </summary>
		public Hashtable MappedMineTypes
			{get{ return this.mineTypes;}}

		/// <summary>
		/// Retruns the mapping between virtual and real dir
		/// </summary>
		public Hashtable DirMapping{get{return this.physicalDir;}}


		/// <summary>
		/// Returns a minetype to a given fileextension
		/// </summary>
		/// <param name="fileExtension">A File Extension</param>
		/// <returns>The suitable minetype</returns>
		public string GetMineTypeMapping(string fileExtension)
			{return this.mineTypes[fileExtension].ToString();}
			

		/// <summary>
		/// Delivers a string witch is a mapping between a a virtual Dir
		/// and a real Dir on thsi server.
		/// </summary>
		/// <param name="vDir">A Virtal dir as <code>string</code> </param>
		/// <returns>The real Server Dir as <code>string</code> </returns>
		public string GetDirMapping(string vDir)
		{return this.physicalDir[vDir].ToString();}

		
		/// <summary>
		/// Retrurn the default file name, when none is requested as <code>string</code>
		/// </summary>
		public string DefaultFile{get{return this.dafaultFile;}}


		/// <summary>
		///  Retrurn the default dir name, when none is requested as <code>string</code>
		/// </summary>
		public string DefaultDir {get{return this.physicalDir[0].ToString();}}
			

		/// <summary>
		/// Retruns the portnumber on which the server is running as <code>int</code>
		/// </summary>
		public int ServerPort{get{return this.port;}}

		/// <summary>
		/// The constructor loads the xmlFile and stores the setting in the class attributes 
		/// attributs
		/// </summary>
		public ServerSettings()
		{
			try
			{
				StreamReader file = new StreamReader("serverSettings.xml");
				string xmlContent = file.ReadToEnd();
				XmlTextReader xtr = new XmlTextReader(new StringReader(xmlContent));
				XmlDocument xmlDoc = new XmlDocument();
				xmlDoc.Load(xtr);
				XmlNode node;

				//load Mine Typs
				this.mineTypes = new Hashtable();
				XmlNodeList nodeList = xmlDoc.SelectNodes("//MineTypes/*");
				for(int i=0; i<nodeList.Count; i++)
				{

					try
					{
						this.mineTypes.Add(nodeList.Item(i).FirstChild.InnerText,nodeList.Item(i).LastChild.InnerText);
					}
					catch(Exception)
					{
						Console.WriteLine("One mineType has been already added");
					}
				}
				//serverRoot
				node = xmlDoc.DocumentElement.SelectSingleNode("/serverSettings/serverRoot/text()");
				this.serverRoot = node.Value.ToString();
				//identify the physical Dirs
				this.physicalDir = new Hashtable();
				nodeList = xmlDoc.SelectNodes("//VDirs/*");
				for(int i=0; i<nodeList.Count; i++)
				{
					try
					{
						this.physicalDir.Add(nodeList.Item(i).FirstChild.InnerText,nodeList.Item(i).LastChild.InnerText);
					}
					catch(Exception)
					{
						Console.WriteLine("One directory has been already added");
					}
				}
				node = xmlDoc.DocumentElement.SelectSingleNode("/serverSettings/defaultFile/text()");
				this.dafaultFile = node.Value.ToString();
				//port
				node = xmlDoc.DocumentElement.SelectSingleNode("/serverSettings/port/text()");
				Console.WriteLine(node.Value.ToString());
				this.port = int.Parse(node.Value.ToString());
			}
			catch (Exception e)
			{
				Console.WriteLine(e.Message);
				//throw new FatalServerException();
			}
			Console.WriteLine(this.ToString());
		}

		/// <summary>
		/// All settings of this server represented in a <code>string</code>
		/// This is mainly for debugging
		/// </summary>
		/// <returns>all server settings as string</returns>
		public  override string ToString()
		{
			string aString=null;

			//mineType
			foreach(DictionaryEntry dic in this.mineTypes)
				aString = aString +" "+dic.Key.ToString()+" "+ dic.Value.ToString()+"\n";

			aString = aString +"\n"+this.serverRoot;
			aString = aString +"\n";
			foreach(DictionaryEntry dic in this.physicalDir)
				aString = aString +" "+dic.Key.ToString()+" is mapped to "+ dic.Value.ToString()+"\n";
			//aString= aString +"\n" +
			aString= aString +"\n" + this.dafaultFile;
			return aString;
		}
		
	}
}

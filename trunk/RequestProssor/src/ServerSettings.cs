using System;
using System.Collections;
using System.IO;
using System.Xml;
using SimpleLogging;
using XMLConfigReader;

namespace RequestProssor
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
	
		SimpleLogger logger;
		/// <summary>
		/// A String witch contains the RootDir of the server, here all
		/// documents are stored
		/// </summary>
		private string serverRoot;

		/// <summary>
		/// A Hashtable which contains a mapping fot Mine Types.
		/// Key is a file extension like .htm
		/// Value is the suitable mine Type
		/// </summary>
		private ConfigList mineTypes;


		/// <summary>
		/// When a directory like sample.org/test/ ist called by the client
		/// this is not the dir which on Server Disk, for this reason this 
		/// <c></c> contains a mapping between this.
		/// Key: The requested dir form the client
		/// Value: The real dir on server disk
		/// </summary>
		private ConfigList physicalDir;

		/// <summary>
		/// the default file, when none is requested as <code>string</code>
		/// </summary>
		private string dafaultFile;

		/// <summary>
		/// Retruns the mapping between fileextensions and minetypes as
		/// <code>Hashtable</code>
		/// </summary>
		public ConfigList MappedMineTypes
		{get{ return this.mineTypes;}}

		/// <summary>
		/// Retruns the mapping between virtual and real dir
		/// </summary>
		public ConfigList DirMapping{get{return this.physicalDir;}}


		/// <summary>
		/// Returns a minetype to a given fileextension
		/// </summary>
		/// <param name="fileExtension">A File Extension</param>
		/// <returns>The suitable minetype</returns>
		public string GetMineTypeMapping(string fileExtension)
		{
			try
			{
				Console.WriteLine("File Extension " +fileExtension);
				return this.mineTypes[fileExtension].ToString();
			}
			catch(Exception)
			{
				return "text/html";
			}
		}
			

		/// <summary>
		/// Delivers a string witch is a mapping between a a virtual Dir
		/// and a real Dir on thsi server.
		/// </summary>
		/// <param name="vDir">A Virtal dir as <code>string</code> </param>
		/// <returns>The real Server Dir as <code>string</code> </returns>
		public string GetDirMapping(string vDir)
		{
				return this.physicalDir[vDir].ToString();
		}

		
		/// <summary>
		/// Retrurn the default file name, when none is requested as <code>string</code>
		/// </summary>
		public string DefaultFile{get{return this.dafaultFile;}}


		/// <summary>
		///  Retrurn the default dir name, when none is requested as <code>string</code>
		/// </summary>
		public string DefaultDir {get{return this.physicalDir[0].ToString();}}
			

		/// <summary>
		/// The constructor loads the xmlFile and stores the setting in the class attributes 
		/// attributs
		/// </summary>
		public ServerSettings(string configFilePath)
		{
			this.logger = new SimpleLogger(this);
			this.logger.ConsoleOutput = true;
			this.logger.DebugOutput = true;

			XMLConfigFileReader cfr = new XMLConfigFileReader(configFilePath);
			ConfigTable configTable = cfr.GetConfigTable("serverSettings");
			this.serverRoot = configTable["serverRoot"].ToString();
			Console.WriteLine("Server Root Dir: "+this.serverRoot);

			this.dafaultFile = configTable["defaultFile"].ToString();
			Console.WriteLine("Default File: "+this.DefaultFile);

			this.physicalDir = cfr.GetConfigList("VDirs","RequestedDir","realDir");
			this.mineTypes = cfr.GetConfigList("MineTypes","fileExtension","type");
			
//			try
//			{
//				StreamReader file = new StreamReader("serverSettings.xml");
//				string xmlContent = file.ReadToEnd();
//				XmlTextReader xtr = new XmlTextReader(new StringReader(xmlContent));
//				XmlDocument xmlDoc = new XmlDocument();
//				xmlDoc.Load(xtr);
//				XmlNode node;
//
//				//load Mine Typs
//				this.mineTypes = new Hashtable();
//				XmlNodeList nodeList = xmlDoc.SelectNodes("//MineTypes/*");
//				for(int i=0; i<nodeList.Count; i++)
//				{
//
//					try
//					{
//						this.mineTypes.Add(nodeList.Item(i).FirstChild.InnerText,nodeList.Item(i).LastChild.InnerText);
//					}
//					catch(Exception)
//					{
//						Console.WriteLine("One mineType has been already added");
//					}
//				}
//				//serverRoot
//				node = xmlDoc.DocumentElement.SelectSingleNode("/serverSettings/serverRoot/text()");
//				this.serverRoot = node.Value.ToString();
//				//identify the physical Dirs
//				this.physicalDir = new Hashtable();
//				nodeList = xmlDoc.SelectNodes("//VDirs/*");
//				for(int i=0; i<nodeList.Count; i++)
//				{
//					try
//					{
//						this.physicalDir.Add(nodeList.Item(i).FirstChild.InnerText,nodeList.Item(i).LastChild.InnerText);
//					}
//					catch(Exception)
//					{
//						Console.WriteLine("One directory has been already added");
//					}
//				}
//				node = xmlDoc.DocumentElement.SelectSingleNode("/serverSettings/defaultFile/text()");
//				this.dafaultFile = node.Value.ToString();
//				//port
//				node = xmlDoc.DocumentElement.SelectSingleNode("/serverSettings/port/text()");
//				//				Console.WriteLine(node.Value.ToString());
//				this.port = int.Parse(node.Value.ToString());
//			}
//			catch (Exception e)
//			{
//				Console.WriteLine(e.Message);
//				//throw new FatalServerException();
//			}
			
		}

		internal string GetPhysicalPath(string uri)
		{
			//Root Dir + <mapping> 
			if(uri=="/")
			{
				return this.serverRoot+this.DefaultFile;
			}
			string filename="";
			string path;
			string realDir;
			path = this.serverRoot;
			string[] virtualDir = uri.Split('/');
			for(int i=0; i<virtualDir.Length; i++)
			{
				if(virtualDir[i].IndexOf(".")>=0)
					filename = virtualDir[i];
				virtualDir[i] = "/"+virtualDir[i]+"/";
				
//				Console.WriteLine(virtualDir[i].ToString() +" is mapped to ");
				try
				{
					if(virtualDir[i]=="//" || virtualDir[i].IndexOf(".")>=0)
						continue;
					realDir = this.DirMapping[virtualDir[i]].ToString();
					path= path+realDir;


				}catch(Exception )
				{
					Console.WriteLine(virtualDir[i].ToString() +" wurde nciht gefunden.");
				}
			}
			path= path.Replace("//",@"\");
			path = path+filename;
			Console.WriteLine(path);
			return path;
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
			aString= aString +"\n Default File " + this.dafaultFile;
			return aString;
		}
		
	}
}

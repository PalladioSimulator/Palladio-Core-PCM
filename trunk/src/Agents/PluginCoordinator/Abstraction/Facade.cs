#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;
using System.Xml;
using System.Reflection;
using System.Collections;
using log4net;

using Palladio.Editor.Common;

namespace Palladio.Editor.Core.Agents.PluginCoordinator.Abstraction
{

	public delegate void PluginInfoEventHandler(object source, PluginInfo info);

	/// <summary>
	/// A Facade to the Abstraction subsystem of the PluginCoordinator PAC agent
	/// which holds the plugin configuration.
	/// </summary>
	internal class Facade
	{
		#region Fields
		/// <summary>
		/// log4net logging service</summary>
		private static readonly ILog log = LogManager.GetLogger(typeof(Facade));

		/// <summary>
		/// An adapter to communicate with the presentation component via the controller.</summary>
		private IPresentationAdapter _presentation;

		private string _configFileName;

		private Hashtable _viewPluginInfos;
		private Hashtable _analyzePluginInfos;
		private Hashtable _importPluginInfos;
		private Hashtable _exportPluginInfos;
		private ArrayList _infoList;
		#endregion

		public event EventHandler DataChanged;
		public event PluginInfoEventHandler PluginActivationRequested; 

		#region Constructors
		/// <summary>
		/// Creates a Facade object.
		/// </summary>
		/// <param name="presentation"></param>
		public Facade(IPresentationAdapter presentation)
		{
			this._presentation = presentation;

			this._viewPluginInfos    = new Hashtable();
			this._analyzePluginInfos = new Hashtable();
			this._importPluginInfos  = new Hashtable();
			this._exportPluginInfos  = new Hashtable();

			this._infoList = new ArrayList();

			this._configFileName = System.Windows.Forms.Application.StartupPath+"\\PluginCoordinator.cfg";
		}
		#endregion

		#region Public Methods
		/// <summary>
		/// 
		/// </summary>
		public void Initialize()
		{
			this.Deserialize();
			if (this.DataChanged != null) 
				DataChanged(this,null);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="info"></param>
		public void SetPluginInfo(PluginInfo info)
		{
			bool changed = false;
			if (info.PluginType == PluginType.VIEW)
			{
				this._viewPluginInfos[info.TypeName] = info;
				changed = true;
			}
			else if (info.PluginType == PluginType.ANALYZE)
			{
				this._analyzePluginInfos[info.TypeName] = info;
				changed = true;
			}
			else if (info.PluginType == PluginType.IMPORT)
			{
				this._importPluginInfos[info.TypeName] = info;
				changed = true;
			}
			else if (info.PluginType == PluginType.EXPORT)
			{
				this._exportPluginInfos[info.TypeName] = info;
				changed = true;
			}

			if (changed)
			{
				this.rebuildInfoList(); 
				this.Serialize();
				if (this.DataChanged != null) 
					DataChanged(this,null);
			}

		}

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public PluginInfo[] GetPluginInfos()
		{
			PluginInfo[] infoArray = new PluginInfo[this._infoList.Count];
			this._infoList.CopyTo(infoArray,0);
			return infoArray;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="index"></param>
		/// <returns></returns>
		public PluginInfo GetPluginInfo(int index)
		{
			return (PluginInfo)this._infoList[index];
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="type"></param>
		/// <returns></returns>
		public PluginInfo GetPluginInfo(string type)
		{
			if (this._viewPluginInfos[type] != null)
				return (PluginInfo)this._viewPluginInfos[type];
			if (this._analyzePluginInfos[type] != null)
				return (PluginInfo)this._analyzePluginInfos[type];
			if (this._importPluginInfos[type] != null)
				return (PluginInfo)this._importPluginInfos[type];
			if (this._exportPluginInfos[type] != null)
				return (PluginInfo)this._exportPluginInfos[type];
			throw new Exception();
		}
		#endregion

		#region Private Methods
		/// <summary>
		/// 
		/// </summary>
		private void rebuildInfoList()
		{
			this._infoList.Clear();
			this.attachHashToList(this._viewPluginInfos);
			this.attachHashToList(this._analyzePluginInfos);
			this.attachHashToList(this._importPluginInfos);
			this.attachHashToList(this._exportPluginInfos);
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="hash"></param>
		private void attachHashToList(Hashtable hash)
		{
			string[] keys;
			keys = new string[hash.Count];
			hash.Keys.CopyTo(keys,0);
			Array.Sort(keys);
			foreach (string key in keys) 
			{
				this._infoList.Add(hash[key]);
			}
		}

		/// <summary>
		/// 
		/// </summary>
		private void Serialize()
		{
			XmlTextWriter writer = new XmlTextWriter(this._configFileName, System.Text.Encoding.UTF8);
			writer.Formatting = Formatting.Indented;
			writer.Indentation= 6;
			writer.Namespaces = true;

			writer.WriteStartDocument();

			writer.WriteStartElement("Configuration");
			foreach (PluginInfo pluginInfo in this._infoList)
			{
				writer.WriteStartElement("Plugin");
				writer.WriteStartElement("TypeName");
				writer.WriteString(pluginInfo.TypeName);
				writer.WriteEndElement();
				writer.WriteStartElement("AssemblyPath");
				writer.WriteString(pluginInfo.Assembly);
				writer.WriteEndElement();
				writer.WriteStartElement("Status");
				writer.WriteString(pluginInfo.Status.ToString());
				writer.WriteEndElement();
				writer.WriteEndElement();
			}
			writer.WriteEndElement();

			writer.WriteEndDocument();
			writer.Close();
		}

		/// <summary>
		/// 
		/// </summary>
		private void Deserialize()
		{
			this._infoList.Clear();
			try 
			{
				XmlTextReader textReader = new XmlTextReader(this._configFileName);
				textReader.WhitespaceHandling = WhitespaceHandling.None;

				XmlDocument xmldoc = new XmlDocument();
				xmldoc.Load(textReader);

				foreach (System.Xml.XmlNode node in xmldoc.DocumentElement.ChildNodes)
				{
					if (node.Name == "Plugin")
					{
						PluginInfo shortInfo = new PluginInfo();
						foreach (System.Xml.XmlNode childNode in node.ChildNodes)
						{
							switch (childNode.Name)
							{
								case "TypeName":
									shortInfo.TypeName = childNode.InnerText;
									break;
								case "AssemblyPath":
									shortInfo.Assembly = childNode.InnerText;
									break;
								case "Status":
									switch (childNode.InnerText.ToUpper())
									{
										case "ACTIVE":
											shortInfo.Status = PluginStatus.ACTIVE;
											break;
										default:
											shortInfo.Status = PluginStatus.INACTIVE;
											break;
									}
									break;
							}
						}
						this._infoList.Add(shortInfo);
					}
				}
				textReader.Close();
			}
			catch (System.IO.FileNotFoundException e)
			{
				log.Info("Configuration file not found. ("+e.FileName+")");
			}

			foreach (PluginInfo shortInfo in this._infoList)
			{
				// create and define setup information for a new domain
				AppDomainSetup domainInfo = new AppDomainSetup();
				domainInfo.ApplicationBase = AppDomain.CurrentDomain.BaseDirectory;
				domainInfo.PrivateBinPath = "Assemblies";

				AppDomain pluginDomain = AppDomain.CreateDomain("PluginDomain",null,domainInfo);

				// instantiate a RemoteLoader in the new application domain
				RemoteLoader remoteLoader = pluginDomain.CreateInstanceFromAndUnwrap(
					AppDomain.CurrentDomain.BaseDirectory+"\\Palladio.Editor.Core.exe",
					typeof(RemoteLoader).ToString()) 
					as RemoteLoader;

				try 
				{
					PluginInfo fullInfo = remoteLoader.CompletePluginInfo(shortInfo);
					switch (fullInfo.PluginType)
					{
						case PluginType.VIEW:
							this._viewPluginInfos[fullInfo.TypeName] = fullInfo;
							break;
						case PluginType.ANALYZE:
							this._analyzePluginInfos[fullInfo.TypeName] = fullInfo;
							break;
						case PluginType.IMPORT:
							this._importPluginInfos[fullInfo.TypeName] = fullInfo;
							break;
						case PluginType.EXPORT:
							this._exportPluginInfos[fullInfo.TypeName] = fullInfo;
							break;
					}
				}
				catch (Exception e)
				{
					log.Warn("Could not recover plugin information for type "+shortInfo.TypeName+". "+e.ToString());
				}
				AppDomain.Unload(pluginDomain);
			}
			this.rebuildInfoList();

			// using a clone here because activation provokes a change in arraylist
			// which is bad within foreach
			ArrayList infoListCopy = (ArrayList)this._infoList.Clone();
			foreach (PluginInfo info in infoListCopy)
			{
				if (info.Status == PluginStatus.ACTIVE)
				{
					if (this.PluginActivationRequested != null)
						this.PluginActivationRequested(this, info);
				}
			}

		}
		#endregion
	}
}

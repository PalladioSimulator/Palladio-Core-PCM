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

namespace Palladio.Editor.Core.Agents.PluginCoordinator
{
	/// <summary>
	/// Zusammenfassung für PluginInfoCollection.
	/// </summary>
	internal class Abstraction
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(Abstraction));

		private Control _control;

		private string configFileName;

		private Hashtable _viewPluginInfos;
		private Hashtable _analyzePluginInfos;
		private Hashtable _importPluginInfos;
		private Hashtable _exportPluginInfos;
		private ArrayList _infoList;

		public event EventHandler DataChanged;

		public Abstraction(Control control)
		{
			this._control = control;
			this._viewPluginInfos = new Hashtable();
			this._analyzePluginInfos = new Hashtable();
			this._importPluginInfos = new Hashtable();
			this._exportPluginInfos = new Hashtable();
			this._infoList = new ArrayList();

			this.configFileName = System.Windows.Forms.Application.StartupPath+"\\PluginCoordinator.cfg";
		}

		public void Initialize()
		{
			this.deserialize();
			if (this.DataChanged != null) 
				DataChanged(this,null);
		}

		public void SetPluginInfo(PluginInfo info)
		{
			if (info.PluginType == PluginType.VIEW)
			{
				this._viewPluginInfos[info.TypeName] = info;
				this.rebuildInfoList(); 
				this.serialize();
				if (this.DataChanged != null) 
					DataChanged(this,null);
			}
		}

		public PluginInfo[] GetPluginInfos()
		{
			PluginInfo[] infoArray = new PluginInfo[this._infoList.Count];
			this._infoList.CopyTo(infoArray,0);
			return infoArray;
		}

		public PluginInfo GetPluginInfo(int index)
		{
			return (PluginInfo)this._infoList[index];
		}

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

		private void rebuildInfoList()
		{
			this._infoList.Clear();
			this.attachHashToList(this._viewPluginInfos);
			this.attachHashToList(this._analyzePluginInfos);
			this.attachHashToList(this._importPluginInfos);
			this.attachHashToList(this._exportPluginInfos);
		}

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

		private void serialize()
		{
			XmlTextWriter writer = new XmlTextWriter(this.configFileName, System.Text.Encoding.UTF8);
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

		private void deserialize()
		{
			this._infoList.Clear();
			try 
			{
				XmlTextReader textReader = new XmlTextReader(this.configFileName);
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
					this._control.ActivatePlugin(info);
				}
			}

		}
	}
}

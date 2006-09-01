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
using System.Xml.Serialization;

using Palladio.Editor.Common;

namespace Palladio.Editor.Core
{
	/// <summary>
	/// Zusammenfassung für PluginInfo.
	/// </summary>
	[Serializable]
	public struct PluginInfo
	{
		private string _name;
		private string _description;
		private string _author;
		private string _version;
		private string _typeName;
		private string _assembly;
		private PluginType _pluginType;
		private PluginStatus _status;

		/// <summary>
		/// 
		/// </summary>
		/// <param name="type">System Type</param>
		/// <param name="pluginType">Plugin Type</param>
		/// <param name="name">Plugin name</param>
		/// <param name="description">Plugin description</param>
		/// <param name="author">Plugin author</param>
		/// <param name="version">Plugin version</param>
		/// <param name="assembly">The path to the assembly this plugin resides in</param>
		/// <param name="status">Plugin status</param>
		public PluginInfo(System.Type type, PluginType pluginType, string name, string description, string author, string version, string assembly, PluginStatus status)
		{
			this._name = name;
			this._description = description;
			this._author = author;
			this._version = version;
			this._typeName = type.ToString();
			this._pluginType = pluginType;
			this._assembly = assembly;
			this._status = status;
		}

		/// <summary>
		/// Copy constructor
		/// </summary>
		/// <param name="info"></param>
		public PluginInfo(PluginInfo info)
		{
			this._name = info.Name;
			this._description = info.Description;
			this._author = info.Author;
			this._version = info.Version;
			this._typeName = info.TypeName;
			this._pluginType = info.PluginType;
			this._assembly = info.Assembly;
			this._status = info.Status;
		}

		/// <summary>
		/// 
		/// </summary>
		public string Name
		{
			get { return this._name; }
			set { this._name = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public string Description
		{
			get { return this._description; }
			set { this._description = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public string Author
		{
			get { return this._author; }
			set { this._author = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public string Version
		{
			get { return this._version; }
			set { this._version = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public string TypeName
		{
			get { return this._typeName; }
			set { this._typeName = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public PluginStatus Status
		{
			get { return this._status; }
			set { this._status = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public string Assembly
		{
			get { return this._assembly; }
			set { this._assembly = value; }
		}

		/// <summary>
		/// 
		/// </summary>
		public PluginType PluginType
		{
			get { return this._pluginType; }
			set { this._pluginType = value; }
		}
	}
}

using System;

namespace Palladio.Editor.Common
{
	/// <summary>
	/// Zusammenfassung für AbstractPlugin.
	/// </summary>
	public abstract class AbstractPlugin : IPlugin
	{
		public abstract event PluginStatusChangedHandler StatusChanged;

		//TODO: Properties private machen und im Konstruktor mittels Configdatei initialisieren
		public AbstractPlugin()
		{
			this._status = PluginStatusEnum.INACTIVE;
			this._name = "undef";
			this._description = "undef";
			this._author = "undef";
			this._version = "undef";
		}

		#region IPlugin Member

		private PluginStatusEnum _status;
		public virtual PluginStatusEnum Status
		{
			get { return this._status; }
			set { this._status = value;	}
		}

		protected string _name;
		public abstract string Name	{ get; }

		protected string _description;
		public abstract string Description {	get; }

		protected string _author;
		public abstract string Author {	get; }

		protected string _version;
		public abstract string Version { get; }


		#endregion

	}
}

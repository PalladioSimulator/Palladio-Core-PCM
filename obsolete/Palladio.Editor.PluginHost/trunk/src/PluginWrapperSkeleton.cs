using System;
using System.Reflection;
using Palladio.Editor.Common;

namespace Palladio.Editor.PluginHost
{
	/// <summary>
	/// Zusammenfassung für PluginWrapperSkeleton.
	/// </summary>
	public abstract class PluginWrapperSkeleton : IPluginHost, IPlugin
	{
		private IPlugin _wrappedPlugin;
		public event PluginStatusChangedHandler StatusChanged;
		protected PluginManager _manager;

		public PluginWrapperSkeleton(IPlugin plugin, Assembly assembly, PluginManager manager)
		{
			this._wrappedPlugin = plugin;
			this._status = PluginStatusEnum.INACTIVE;
			this._manager = manager;
		}

		#region IPlugin Member

		private PluginStatusEnum _status;
		public PluginStatusEnum Status
		{
			get { return this._status; }
			set
			{
				if (this._status != value) 
				{
					this._status = value;
					this._wrappedPlugin.Status = value;
					if (this.StatusChanged != null)
						this.StatusChanged(this,value);
				}
			}
		}

		public string Description
		{
			get	{ return this._wrappedPlugin.Description; }
		}

		public string Author
		{
			get { return this._wrappedPlugin.Author; }
		}

		public string Name
		{
			get { return this._wrappedPlugin.Name; }
		}

		public string Version
		{
			get	{ return this._wrappedPlugin.Version; }
		}

		#endregion
		
		internal System.Type GetWrappedPluginType()
		{
			return _wrappedPlugin.GetType();
		}
	}
}

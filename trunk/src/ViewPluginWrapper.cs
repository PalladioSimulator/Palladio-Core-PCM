using System;
using System.Reflection;
using Palladio.Editor.Common;
using Palladio.ComponentModel;

namespace Palladio.Editor.PluginHost
{
	/// <summary>
	/// Zusammenfassung für ViewPluginWrapper.
	/// </summary>
	public class ViewPluginWrapper : PluginWrapperSkeleton, IViewPluginHost, IViewPlugin
	{
		private IViewPlugin _wrappedPlugin;

		public ViewPluginWrapper(IViewPlugin plugin, Assembly assembly, PluginManager manager) : base(plugin, assembly, manager)
		{
			this._wrappedPlugin = plugin;
		}

		#region IViewPlugin Member

		public System.Windows.Forms.UserControl Control
		{
			get
			{
				if (this.Status == PluginStatusEnum.ACTIVE)
					return this._wrappedPlugin.Control;
				//TODO NotActiveException
				return null;
			}
		}

		public bool Initialize(IViewPluginHost host)
		{
			// Diese Methode macht nichts und gibt immer false zurück. 
			// Plugins werden nach der Instanziierung einmalig initialisiert.
			return false;
		}

		public object[] ToolboxItems
		{
			get
			{
				if (this.Status == PluginStatusEnum.ACTIVE)
					return this._wrappedPlugin.ToolboxItems;
				//TODO NotActiveException
				return null;
			}
		}

		public void OnComponentModelChanged(ICompositeComponent model)
		{
			if (this.Status == PluginStatusEnum.ACTIVE)
				this._wrappedPlugin.OnComponentModelChanged(model);			
		}
		#endregion


		#region IViewPluginHost Member

		public ICompositeComponent GetComponentModel() 
		{
			return this._manager.GetComponentModel();
		}	


		#endregion
	}
}

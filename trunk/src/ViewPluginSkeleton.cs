using System;
using Palladio.ComponentModel;

namespace Palladio.Editor.Common
{
	/// <summary>
	/// Zusammenfassung für ViewPluginSkeleton.
	/// </summary>
	public abstract class ViewPluginSkeleton : PluginSkeleton, IViewPlugin
	{
		protected IViewPluginHost _host;

		public ViewPluginSkeleton()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		#region IViewPlugin Member

		public virtual bool Initialize(IViewPluginHost host)
		{
			this._host = host;
			return true;
		}

		public abstract System.Windows.Forms.UserControl Control { get; }

		public abstract Object[] ToolboxItems { get; }

		public abstract void OnComponentModelChanged(ICompositeComponent model);
		#endregion

	}
}

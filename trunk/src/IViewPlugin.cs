using System;
using System.Windows.Forms;
using Palladio.ComponentModel;

namespace Palladio.Editor.Common
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public interface IViewPlugin : IPlugin
	{
		bool Initialize(IViewPluginHost host);

		System.Windows.Forms.UserControl Control { get; }
		Object[] ToolboxItems { get; }

		void OnComponentModelChanged(ICompositeComponent model);
	}
}

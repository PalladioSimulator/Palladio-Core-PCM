using System;

namespace Palladio.Editor.Core.Interfaces
{
	/// <summary>
	/// Zusammenfassung für IAnalyzeCoordinator.
	/// </summary>
	internal interface IAnalyzeCoordinator
	{
		/// <summary>
		/// 
		/// </summary>
		void Initialize();

		/// <summary>
		/// Attach plugin indicated by pluginInfo.
		/// </summary>
		/// <param name="pluginInfo">Data struct containing informations about the plugin.</param>
		void AttachPlugin(PluginInfo pluginInfo);

		/// <summary>
		/// Detach plugin with the indicated type name.
		/// </summary>
		/// <param name="type">The type name of the plugin.</param>
		void DetachPlugin(string type);

		/// <summary>
		/// 
		/// </summary>
		void ShowAnalysesControlDialog(string pluginType);
	}
}

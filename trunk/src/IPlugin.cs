using System;

namespace Palladio.Editor.Common
{
	public enum PluginStatusEnum 
	{
		ACTIVE,
		INACTIVE
	}

	/// <summary>
	/// Zusammenfassung für IPlugin
	/// </summary>
	public interface IPlugin
	{
		event PluginStatusChangedHandler StatusChanged;

		PluginStatusEnum Status	{ get; set; }
		string Name				{ get; }
		string Description		{ get; }
		string Author			{ get; }
		string Version			{ get; }
	
}
}

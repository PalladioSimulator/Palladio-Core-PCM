using System;
using Palladio.ComponentModel;

namespace Palladio.Editor.Common
{
	/// <summary>
	/// Zusammenfassung für IViewPluginHost.
	/// </summary>
	public interface IViewPluginHost : IPluginHost
	{
		ICompositeComponent GetComponentModel();
	}
}

using System;
using Palladio.ComponentModel;

namespace Palladio.Editor.Common
{

	public delegate void LogMessageAppendedHandler(object source, string level);
	public delegate void ComponentModelChangedHandler(ICompositeComponent newModel);
	public delegate void PluginStatusChangedHandler(IPlugin source, PluginStatusEnum newstatus);

}

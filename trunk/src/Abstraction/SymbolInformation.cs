using System;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Plugins.StaticView
{
	/// <summary>
	/// Zusammenfassung für SymbolInformation.
	/// </summary>
	public class SymbolInformation
	{
		public EntityProxy proxy;

		public float x;
		public float y;

		public SymbolInformation(EntityProxy proxy, float x, float y)
		{
			this.proxy = proxy;
			this.x = x;
			this.y = y;
		}
	}
}

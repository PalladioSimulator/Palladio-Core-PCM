using System;
using Palladio.Editor.Common.EntityProxies;
using Palladio.Identifier;

namespace Palladio.Editor.Plugins.StaticView
{
	/// <summary>
	/// Zusammenfassung für IAbstractionAdapter.
	/// </summary>
	public interface IAbstractionAdapter
	{
		void ClearRegistry();

		void RegisterSymbol(System.Guid guid, EntityProxy proxy, float x, float y);

		System.Guid ModelID {get; set;}

		System.Guid[] GetSymbolIDsByEntityID(IIdentifier id);

		SymbolInformation GetSymbolInfo(System.Guid guid);

	}
}

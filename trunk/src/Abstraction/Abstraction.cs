using System;
using System.Collections;
using Palladio.Identifier;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Plugins.StaticView
{
	/// <summary>
	/// Zusammenfassung für Abstraction.
	/// </summary>
	public class Abstraction
	{
		private Hashtable symbols;
		private System.Guid modelID;

		public Abstraction()
		{
			this.symbols = new Hashtable();
		}

		public void Initialize()
		{
			this.symbols.Clear();
		}

		public void RegisterSymbol(System.Guid guid, EntityProxy proxy)
		{
			RegisterSymbol(guid, proxy, 0, 0);
		}

		public void RegisterSymbol(System.Guid guid, EntityProxy proxy, float x, float y)
		{
			this.symbols[guid] = new SymbolInformation(proxy, x, y);
		}

		public System.Guid ModelID
		{
			get
			{
				return this.modelID;
			}
			set
			{
				this.modelID = value;
			}
		}

		public void ClearRegistry()
		{
			this.symbols.Clear();
		}

		public System.Guid[] GetSymbolIDsByEntityID(IIdentifier id)
		{
			ArrayList guids = new ArrayList();
			foreach (System.Guid guid in this.symbols.Keys)
			{
				SymbolInformation info = this.symbols[guid] as SymbolInformation;
				if (info.proxy != null)
					if (info.proxy.ID.Equals(id))
						guids.Add(guid);
			}
			System.Guid[] result = new System.Guid[guids.Count];
			guids.CopyTo(result);
			return result;
		}

		public SymbolInformation GetSymbolInfo(System.Guid guid)
		{
			return this.symbols[guid] as SymbolInformation;
		}
	}
}

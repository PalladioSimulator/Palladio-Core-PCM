using System;

namespace Palladio.Editor.Plugins.StaticView.Symbols
{
	/// <summary>
	/// Zusammenfassung für ProvidesRole.
	/// </summary>
	public class ProvidesRole : PalladioSymbol
	{
		PalladioSymbol interfaceSymbol;

		public ProvidesRole()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}

		public PalladioSymbol InterfaceSymbol
		{
			get
			{
				return this.interfaceSymbol;
			}
			set
			{
				this.interfaceSymbol = value;
			}
		}
	}
}

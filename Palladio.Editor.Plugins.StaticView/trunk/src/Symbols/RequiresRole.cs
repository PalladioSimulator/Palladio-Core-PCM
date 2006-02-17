using System;

namespace Palladio.Editor.Plugins.StaticView.Symbols
{
	/// <summary>
	/// Zusammenfassung für RequiresRole.
	/// </summary>
	public class RequiresRole : PalladioSymbol
	{
		PalladioSymbol interfaceSymbol;

		public RequiresRole()
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

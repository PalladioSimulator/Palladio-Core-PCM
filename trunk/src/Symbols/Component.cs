using System;
using System.Collections;
using Palladio.Identifier;

namespace Palladio.Editor.Plugins.StaticView.Symbols
{
	/// <summary>
	/// Zusammenfassung für ComponentSymbol.
	/// </summary>
	public abstract class Component : PalladioSymbol
	{
		private Hashtable providesRoles;
		private Hashtable requiresRoles;

		public Component()
		{
			this.providesRoles = new Hashtable();
			this.requiresRoles = new Hashtable();
		}

		public void RegisterProvidesRole(IIdentifier id, PalladioSymbol symbol)
		{
			this.providesRoles.Add(id, symbol);
		}

		public void UnregisterProvidesRole(IIdentifier id)
		{
			this.providesRoles.Remove(id);
		}

		public void RegisterRequiresRole(IIdentifier id, PalladioSymbol symbol)
		{
			this.requiresRoles.Add(id, symbol);
		}

		public void UnregisterRequiresRole(IIdentifier id)
		{
			this.requiresRoles.Remove(id);
		}

		public void UpdateRoles()
		{
			int total = this.providesRoles.Count;
			int placed = 0;
			if (total > 0)
				foreach(Symbols.ProvidesRole role in this.providesRoles.Values)
				{
					role.X = this.Bounds.Left-24;
					role.Y = this.Bounds.Top + (this.Bounds.Height/(total+1)) + (placed * (this.Bounds.Height/(total+1)));
					role.InterfaceSymbol.X = role.X-6;
					role.InterfaceSymbol.Y = role.Y-6f;
					placed++;
				}

			total = this.requiresRoles.Count;
			placed = 0;
			if (total > 0)
				foreach(Symbols.RequiresRole role in this.requiresRoles.Values)
				{
					role.X = this.Bounds.Right;
					role.Y = this.Bounds.Top + (this.Bounds.Height/(total+1)) + (placed * (this.Bounds.Height/(total+1)));
					role.InterfaceSymbol.X = role.X+18;
					role.InterfaceSymbol.Y = role.Y-6f;
					placed++;
				}
		}

		protected override void OnMove(Syncfusion.Windows.Forms.Diagram.MoveEventArgs evtArgs)
		{
			base.OnMove( evtArgs );
			this.UpdateRoles();
		}

		protected override void OnBoundsChanged(Syncfusion.Windows.Forms.Diagram.BoundsEventArgs evtArgs)
		{
			base.OnBoundsChanged (evtArgs);
			this.UpdateRoles();
		}


	}
}

using System;
using System.Collections;

using Palladio.Identifier;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Plugins.StaticView.Symbols
{
	/// <summary>
	/// Zusammenfassung für CompositeComponent.
	/// </summary>
	public class CompositeComponent : Component
	{
		private Hashtable components;

		/// <summary>
		/// Default constructor.
		/// </summary>
		public CompositeComponent()
		{
			this.components = new Hashtable();
		}

		public void RegisterComponent(IIdentifier id, PalladioSymbol symbol)
		{
			this.components.Add(id, symbol);
		}

		public void UnregisterComponent(IIdentifier id)
		{
			this.components.Remove(id);
		}

		public void UpdateComponents()
		{
			//this.components.Clear();
			CompositeComponentProxy proxy = this.Tag as CompositeComponentProxy;
			foreach(ComponentProxy containedProxy in proxy.Components)
			{
				object containedSymbol = components[containedProxy.ID];
				if (containedSymbol is Symbols.Component)
				{
					Symbols.Component compositeSymbol = containedSymbol as Symbols.Component;
					compositeSymbol.Tag = containedProxy;
					compositeSymbol.Labels["Name"].Text = containedProxy.Name;
					compositeSymbol.ParentSymbol = this;
				}
			}
		}

		public PalladioSymbol[] Components
		{
			get
			{
				PalladioSymbol[] result = new PalladioSymbol[this.components.Count];
				this.components.Values.CopyTo(result, 0);
				return result;
			}
		}

		public PalladioSymbol GetComponent(IIdentifier id)
		{
			return this.components[id] as PalladioSymbol;
		}

		public void ClearComponents()
		{
			this.components.Clear();
		}

		protected override void OnMove(Syncfusion.Windows.Forms.Diagram.MoveEventArgs evtArgs)
		{
			base.OnMove (evtArgs);
		}

	}
}

using System;
using System.Drawing;
using Palladio.Editor.Common;
using Palladio.Editor.Common.EntityProxies;
using Palladio.Identifier;
using Syncfusion.Windows.Forms.Diagram;
using Syncfusion.Windows.Forms.Diagram.Controls;
using log4net;


namespace Palladio.Editor.Plugins.StaticView
{
	/// <summary>
	/// Zusammenfassung für Control.
	/// </summary>
	[PluginInfo(Name="StaticView",
		 Description="This Plugin provides a static view onto the component model.",
		 Author="Matthias Uflacker")]
	public class Control : ViewPluginSkeleton, IAbstractionAdapter
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(Control));

		private StaticViewPresentation presentation;
		private Abstraction abstraction;

		public override event SelectionChangedHandler SelectionChanged;

		public Control(string name, string descr, string author, string version) :
			base(name,descr,author,version)
		{
			this.presentation = new StaticViewPresentation(this);
			this.abstraction = new Abstraction();
		}

		public override bool Initialize(IViewPluginHost host)
		{
			base.Initialize(host);

			CompositeComponentProxy activeModel = this._host.GetComponentModel();
			this.abstraction.Initialize();
			this.presentation.Initialize(activeModel);
			
			this.presentation.SelectionChanged += new SelectionChangedHandler(presentation_SelectionChanged);
			log.Debug("Initialized.");
			return true;
		}

		// place diagram into mdi container
		public override ViewControlPosition ViewControlPosition
		{
			get { return ViewControlPosition.MDI_CONTAINER; }
		}


		public override System.Windows.Forms.Control ViewControl
		{
			get
			{
				return this.presentation.ViewControl;
			}
		}
		
		public override object[] ToolboxItems
		{
			get
			{
				return new object[]{this.presentation.Palette};
			}
		}

		protected override void host_ComponentModelChanged(object source, CompositeComponentProxy newModel)
		{
			//this.abstraction.Initialize(newModel);
			this.presentation.Initialize(newModel);
		}

		protected override void host_EntityChanged(object source, EntityProxy entity, Palladio.Editor.Common.EntityProxies.EventArgs e) 
		{
			switch (e.Reason)
			{
				case EntityChangeReason.COMPONENT_ADDED:
					if (entity is CompositeComponentProxy)
						this.presentation.AddComponent(entity as CompositeComponentProxy, e.AssociatedID);
					break;
				case EntityChangeReason.COMPONENT_REMOVED:
					if (entity is CompositeComponentProxy)
						this.presentation.RemoveComponent(entity as CompositeComponentProxy, e.AssociatedID);
					break;
				case EntityChangeReason.PROVIDESINTERFACE_ADDED:
					this.presentation.AddProvidesInterface(entity as ComponentProxy, e.AssociatedID);
					break;
				case EntityChangeReason.REQUIRESINTERFACE_ADDED:
					this.presentation.AddRequiresInterface(entity as ComponentProxy, e.AssociatedID);
					break;
				case EntityChangeReason.BINDING_ADDED:
					CompositeComponentProxy comp = entity as CompositeComponentProxy;
					this.presentation.AddConnection(comp, e.AssociatedID, comp.GetBindingByID(e.AssociatedID));
					break;
				case EntityChangeReason.PROVIDESMAPPING_ADDED:
					comp = entity as CompositeComponentProxy;
					this.presentation.AddConnection(comp, e.AssociatedID, comp.GetProvidesMappingByID(e.AssociatedID));
					break;
				case EntityChangeReason.REQUIRESMAPPING_ADDED:
					comp = entity as CompositeComponentProxy;
					this.presentation.AddConnection(comp, e.AssociatedID, comp.GetRequiresMappingByID(e.AssociatedID));
					break;
				default:
					this.presentation.UpdateEntity(entity);
					break;
			}
		}

		public override void Detach()
		{
			this.presentation.Dispose();
			log.Debug("Detached.");
		}

		public override void Select(EntityProxy entity)
		{
			this.presentation.SelectSymbol(entity);
		}


		private void presentation_SelectionChanged(object source, EntityProxy entity)
		{
			if (this.SelectionChanged != null)
				this.SelectionChanged(this, entity);
		}

		public System.Guid ModelID
		{
			get
			{
				return this.abstraction.ModelID;
			}
			set
			{
				this.abstraction.ModelID = value;
			}
		}

		public void ClearRegistry()
		{
			this.abstraction.ClearRegistry();
		}

		public void RegisterSymbol(System.Guid guid, EntityProxy proxy, float x, float y)
		{
			this.abstraction.RegisterSymbol(guid, proxy, x, y);
		}

		public System.Guid[] GetSymbolIDsByEntityID(IIdentifier id)
		{
			return this.abstraction.GetSymbolIDsByEntityID(id);
		}

		public SymbolInformation GetSymbolInfo(System.Guid guid)
		{
			return this.abstraction.GetSymbolInfo(guid);
		}
	}
}

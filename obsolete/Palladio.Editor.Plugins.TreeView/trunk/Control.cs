using System;
using Palladio.Editor.Common;
using Palladio.Editor.Common.EntityProxies;
using Palladio.Identifier;
using log4net;

namespace Palladio.Editor.Plugins.TreeView
{
	/// <summary>
	/// Zusammenfassung für Control.
	/// </summary>
	[PluginInfo(Name="TreeView",
		        Description="This Plugin shows the component model in a tree-like structure",
		        Author="Matthias Uflacker")]
	public class Control : ViewPluginSkeleton
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(Control));

		private TreeViewPresentation _presentation;

		public override event SelectionChangedHandler SelectionChanged;

		public Control(string name, string descr, string author, string version) : 
			base(name,descr,author,version)
		{
			this._presentation = new TreeViewPresentation();
		}

		public override bool Initialize(IViewPluginHost host)
		{
			base.Initialize(host);
			this._presentation.BuildTree(this._host.GetComponentModel());
			this._presentation.SelectionChanged += new SelectionChangedHandler(treeControl_SelectionChanged);
			log.Debug("Initialized.");
			return true;
		}

		public override void Detach()
		{
			log.Debug("Detached.");
		}

		public override void Select(EntityProxy entity)
		{
			if (entity != null)
				this._presentation.SelectNode(entity);
			else
				this._presentation.ClearSelection();
		}

		public override System.Windows.Forms.Control ViewControl
		{
			get
			{
				return this._presentation;
			}
		}

		public override object[] ToolboxItems
		{
			get
			{
				return null;
			}
		}

		protected override void host_ComponentModelChanged(object source, CompositeComponentProxy newModel)
		{
			this._presentation.BuildTree(newModel);
		}

		protected override void host_EntityChanged(object source, EntityProxy entity, Palladio.Editor.Common.EntityProxies.EventArgs e) 
		{
			this._presentation.RebuildSubtree(entity);
		}

		private void treeControl_SelectionChanged(object source, EntityProxy entity)
		{
			if (this.SelectionChanged != null)
				this.SelectionChanged(this, entity);
		}
	}
}

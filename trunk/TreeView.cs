using System;
using Palladio.Editor.Common;
using Palladio.ComponentModel;
using log4net;

namespace Palladio.Editor.Plugins.TreeView
{
	/// <summary>
	/// Zusammenfassung für Class1.
	/// </summary>
	public class TreeView : ViewPluginSkeleton
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(TreeView));

		private TreeViewControl treeControl;

		public TreeView()
		{
			this.treeControl = new TreeViewControl();
		}


		public override bool Initialize(IViewPluginHost host)
		{
			base.Initialize(host);
			this._name = "TreeView";
			this._description = "This view shows the ComponentModel in a tree-like structure";
			this._author = "Matthias Uflacker";
			log.Debug("Initialized.");
			return true;
		}

		protected override void OnActivate()
		{
			this.treeControl.BuildTree(this._host.GetComponentModel());
			log.Debug("activated!");
		}

		protected override void OnInactivate()
		{
			log.Debug("deactivated!");
		}

		public override System.Windows.Forms.UserControl Control
		{
			get
			{
				return this.treeControl;
			}
		}

		public override object[] ToolboxItems
		{
			get
			{
				return null;
			}
		}

		public override void OnComponentModelChanged(ICompositeComponent model) 
		{
			this.treeControl.BuildTree(model);
		}

	}
}

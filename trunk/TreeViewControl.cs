using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;
using Palladio.ComponentModel;

namespace Palladio.Editor.Plugins.TreeView
{
	/// <summary>
	/// Zusammenfassung für TreeViewControl.
	/// </summary>
	public class TreeViewControl : System.Windows.Forms.UserControl
	{
		private System.Windows.Forms.TreeView treeView;
		/// <summary> 
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public TreeViewControl()
		{
			// Dieser Aufruf ist für den Windows Form-Designer erforderlich.
			InitializeComponent();

			// TODO: Initialisierungen nach dem Aufruf von InitializeComponent hinzufügen

		}

		/// <summary> 
		/// Die verwendeten Ressourcen bereinigen.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}

		#region Vom Komponenten-Designer generierter Code
		/// <summary> 
		/// Erforderliche Methode für die Designerunterstützung. 
		/// Der Inhalt der Methode darf nicht mit dem Code-Editor geändert werden.
		/// </summary>
		private void InitializeComponent()
		{
			this.treeView = new System.Windows.Forms.TreeView();
			this.SuspendLayout();
			// 
			// treeView
			// 
			this.treeView.Dock = System.Windows.Forms.DockStyle.Fill;
			this.treeView.ImageIndex = -1;
			this.treeView.Location = new System.Drawing.Point(0, 0);
			this.treeView.Name = "treeView";
			this.treeView.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {
																				 new System.Windows.Forms.TreeNode("modelNode")});
			this.treeView.SelectedImageIndex = -1;
			this.treeView.Size = new System.Drawing.Size(208, 216);
			this.treeView.TabIndex = 0;
			// 
			// TreeViewControl
			// 
			this.Dock = DockStyle.Fill;
			this.Controls.Add(this.treeView);
			this.Name = "TreeViewControl";
			this.Size = new System.Drawing.Size(208, 216);
			this.ResumeLayout(false);

		}
		#endregion

		internal void BuildTree(ICompositeComponent model) 
		{
			this.treeView.Nodes.Clear();
			TreeNode root = new TreeNode(model.ID.ToString());
			foreach (Palladio.ComponentModel.IComponent comp in model.Components)
			{
				TreeNode compNode = new TreeNode(comp.ID.ToString());
				root.Nodes.Add(compNode);
			}
			this.treeView.Nodes.Add(root);
		}
	}
}

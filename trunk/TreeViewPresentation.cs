using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;
using Palladio.Identifier;
using Palladio.Editor.Common;
using Palladio.Editor.Common.EntityProxies;
using log4net;

namespace Palladio.Editor.Plugins.TreeView
{
	/// <summary>
	/// Zusammenfassung für TreeViewControl.
	/// </summary>
	internal class TreeViewPresentation : System.Windows.Forms.UserControl
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(TreeViewPresentation));

		private System.Windows.Forms.TreeView treeView;
		private System.Windows.Forms.ContextMenu contextMenuComposite;
		private System.ComponentModel.IContainer components;
		private System.Windows.Forms.ContextMenu contextMenuBasic;
		private System.Windows.Forms.MenuItem cmi_cc_InsertComponent;
		private System.Windows.Forms.MenuItem cmi_cc_NewBasicComponent;
		private System.Windows.Forms.MenuItem cmi_cc_NewCompositeComponent;
		private System.Windows.Forms.MenuItem cmi_cc_ImportComponent;
		private System.Windows.Forms.MenuItem cmi_cc_AttachInterface;
		private System.Windows.Forms.MenuItem cmi_cc_NewProvidesInterface;
		private System.Windows.Forms.MenuItem cmi_cc_NewRequiresInterface;
		private System.Windows.Forms.MenuItem cmi_cc_ImportAsProvides;
		private System.Windows.Forms.MenuItem cmi_cc_ImportAsRequires;
		private System.Windows.Forms.MenuItem cmi_cc_NewConnection;
		private System.Windows.Forms.MenuItem cmi_cc_Save;
		private System.Windows.Forms.MenuItem cmi_cc_SaveAs;
		private System.Windows.Forms.MenuItem cmi_cc_Export;
		private System.Windows.Forms.MenuItem cmi_cc_Remove;
		private System.Windows.Forms.MenuItem cmi_cc_sep3;
		private System.Windows.Forms.MenuItem cmi_cc_sep4;
		private System.Windows.Forms.MenuItem cmi_cc_sep1;
		private System.Windows.Forms.MenuItem cmi_cc_sep2;
		private System.Windows.Forms.MenuItem cmi_bc_AttachInterface;
		private System.Windows.Forms.MenuItem cmi_bc_NewProvidesInterface;
		private System.Windows.Forms.MenuItem cmi_bc_NewRequiresInterface;
		private System.Windows.Forms.MenuItem cmi_bc_sep3;
		private System.Windows.Forms.MenuItem cmi_bc_ImportAsProvides;
		private System.Windows.Forms.MenuItem cmi_bc_ImportAsRequires;
		private System.Windows.Forms.MenuItem cmi_bc_sep1;
		private System.Windows.Forms.MenuItem cmi_bc_Save;
		private System.Windows.Forms.MenuItem cmi_bc_SaveAs;
		private System.Windows.Forms.MenuItem cmi_bc_sep2;
		private System.Windows.Forms.MenuItem cmi_bc_Remove;

		public event SelectionChangedHandler SelectionChanged;

		private TreeNode contextNode;
		private System.Windows.Forms.ImageList imageList;

		private TreeViewEventHandler treeView_AfterSelectHandler;

		public TreeViewPresentation()
		{
			// Dieser Aufruf ist für den Windows Form-Designer erforderlich.
			InitializeComponent();
			treeView_AfterSelectHandler = new TreeViewEventHandler(treeView_AfterSelect);
			treeView.AfterSelect += treeView_AfterSelectHandler;
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
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(TreeViewPresentation));
			this.treeView = new System.Windows.Forms.TreeView();
			this.imageList = new System.Windows.Forms.ImageList(this.components);
			this.contextMenuComposite = new System.Windows.Forms.ContextMenu();
			this.cmi_cc_InsertComponent = new System.Windows.Forms.MenuItem();
			this.cmi_cc_NewBasicComponent = new System.Windows.Forms.MenuItem();
			this.cmi_cc_NewCompositeComponent = new System.Windows.Forms.MenuItem();
			this.cmi_cc_sep3 = new System.Windows.Forms.MenuItem();
			this.cmi_cc_ImportComponent = new System.Windows.Forms.MenuItem();
			this.cmi_cc_AttachInterface = new System.Windows.Forms.MenuItem();
			this.cmi_cc_NewProvidesInterface = new System.Windows.Forms.MenuItem();
			this.cmi_cc_NewRequiresInterface = new System.Windows.Forms.MenuItem();
			this.cmi_cc_sep4 = new System.Windows.Forms.MenuItem();
			this.cmi_cc_ImportAsProvides = new System.Windows.Forms.MenuItem();
			this.cmi_cc_ImportAsRequires = new System.Windows.Forms.MenuItem();
			this.cmi_cc_NewConnection = new System.Windows.Forms.MenuItem();
			this.cmi_cc_sep1 = new System.Windows.Forms.MenuItem();
			this.cmi_cc_Save = new System.Windows.Forms.MenuItem();
			this.cmi_cc_SaveAs = new System.Windows.Forms.MenuItem();
			this.cmi_cc_Export = new System.Windows.Forms.MenuItem();
			this.cmi_cc_sep2 = new System.Windows.Forms.MenuItem();
			this.cmi_cc_Remove = new System.Windows.Forms.MenuItem();
			this.contextMenuBasic = new System.Windows.Forms.ContextMenu();
			this.cmi_bc_AttachInterface = new System.Windows.Forms.MenuItem();
			this.cmi_bc_NewProvidesInterface = new System.Windows.Forms.MenuItem();
			this.cmi_bc_NewRequiresInterface = new System.Windows.Forms.MenuItem();
			this.cmi_bc_sep3 = new System.Windows.Forms.MenuItem();
			this.cmi_bc_ImportAsProvides = new System.Windows.Forms.MenuItem();
			this.cmi_bc_ImportAsRequires = new System.Windows.Forms.MenuItem();
			this.cmi_bc_sep1 = new System.Windows.Forms.MenuItem();
			this.cmi_bc_Save = new System.Windows.Forms.MenuItem();
			this.cmi_bc_SaveAs = new System.Windows.Forms.MenuItem();
			this.cmi_bc_sep2 = new System.Windows.Forms.MenuItem();
			this.cmi_bc_Remove = new System.Windows.Forms.MenuItem();
			this.SuspendLayout();
			// 
			// treeView
			// 
			this.treeView.Dock = System.Windows.Forms.DockStyle.Fill;
			this.treeView.ImageList = this.imageList;
			this.treeView.Location = new System.Drawing.Point(0, 0);
			this.treeView.Name = "treeView";
			this.treeView.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {
																				 new System.Windows.Forms.TreeNode("modelNode")});
			this.treeView.Size = new System.Drawing.Size(1104, 570);
			this.treeView.TabIndex = 0;
			this.treeView.MouseDown += new System.Windows.Forms.MouseEventHandler(this.treeView_MouseDown);
			// 
			// imageList
			// 
			this.imageList.ImageSize = new System.Drawing.Size(16, 16);
			this.imageList.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList.ImageStream")));
			this.imageList.TransparentColor = System.Drawing.Color.Transparent;
			// 
			// contextMenuComposite
			// 
			this.contextMenuComposite.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																								 this.cmi_cc_InsertComponent,
																								 this.cmi_cc_AttachInterface,
																								 this.cmi_cc_NewConnection,
																								 this.cmi_cc_sep1,
																								 this.cmi_cc_Save,
																								 this.cmi_cc_SaveAs,
																								 this.cmi_cc_Export,
																								 this.cmi_cc_sep2,
																								 this.cmi_cc_Remove});
			// 
			// cmi_cc_InsertComponent
			// 
			this.cmi_cc_InsertComponent.Index = 0;
			this.cmi_cc_InsertComponent.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																								   this.cmi_cc_NewBasicComponent,
																								   this.cmi_cc_NewCompositeComponent,
																								   this.cmi_cc_sep3,
																								   this.cmi_cc_ImportComponent});
			this.cmi_cc_InsertComponent.Text = "Insert Component";
			// 
			// cmi_cc_NewBasicComponent
			// 
			this.cmi_cc_NewBasicComponent.Index = 0;
			this.cmi_cc_NewBasicComponent.Text = "New Basic Component...";
			this.cmi_cc_NewBasicComponent.Click += new System.EventHandler(this.cmi_cc_NewBasicComponent_Click);
			// 
			// cmi_cc_NewCompositeComponent
			// 
			this.cmi_cc_NewCompositeComponent.Index = 1;
			this.cmi_cc_NewCompositeComponent.Text = "New CompositeComponent...";
			this.cmi_cc_NewCompositeComponent.Click += new System.EventHandler(this.cmi_cc_NewCompositeComponent_Click);
			// 
			// cmi_cc_sep3
			// 
			this.cmi_cc_sep3.Index = 2;
			this.cmi_cc_sep3.Text = "-";
			// 
			// cmi_cc_ImportComponent
			// 
			this.cmi_cc_ImportComponent.Index = 3;
			this.cmi_cc_ImportComponent.Text = "Import...";
			// 
			// cmi_cc_AttachInterface
			// 
			this.cmi_cc_AttachInterface.Index = 1;
			this.cmi_cc_AttachInterface.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																								   this.cmi_cc_NewProvidesInterface,
																								   this.cmi_cc_NewRequiresInterface,
																								   this.cmi_cc_sep4,
																								   this.cmi_cc_ImportAsProvides,
																								   this.cmi_cc_ImportAsRequires});
			this.cmi_cc_AttachInterface.Text = "Attach Interface";
			// 
			// cmi_cc_NewProvidesInterface
			// 
			this.cmi_cc_NewProvidesInterface.Index = 0;
			this.cmi_cc_NewProvidesInterface.Text = "New Provides Interface...";
			this.cmi_cc_NewProvidesInterface.Click += new System.EventHandler(this.cmi_cc_NewProvidesInterface_Click);
			// 
			// cmi_cc_NewRequiresInterface
			// 
			this.cmi_cc_NewRequiresInterface.Index = 1;
			this.cmi_cc_NewRequiresInterface.Text = "New Requires Interface...";
			this.cmi_cc_NewRequiresInterface.Click += new System.EventHandler(this.cmi_cc_NewRequiresInterface_Click);
			// 
			// cmi_cc_sep4
			// 
			this.cmi_cc_sep4.Index = 2;
			this.cmi_cc_sep4.Text = "-";
			// 
			// cmi_cc_ImportAsProvides
			// 
			this.cmi_cc_ImportAsProvides.Index = 3;
			this.cmi_cc_ImportAsProvides.Text = "Import as Provides...";
			// 
			// cmi_cc_ImportAsRequires
			// 
			this.cmi_cc_ImportAsRequires.Index = 4;
			this.cmi_cc_ImportAsRequires.Text = "Import as Requires...";
			// 
			// cmi_cc_NewConnection
			// 
			this.cmi_cc_NewConnection.Index = 2;
			this.cmi_cc_NewConnection.Text = "New Connection";
			// 
			// cmi_cc_sep1
			// 
			this.cmi_cc_sep1.Index = 3;
			this.cmi_cc_sep1.Text = "-";
			// 
			// cmi_cc_Save
			// 
			this.cmi_cc_Save.Index = 4;
			this.cmi_cc_Save.Text = "Save";
			// 
			// cmi_cc_SaveAs
			// 
			this.cmi_cc_SaveAs.Index = 5;
			this.cmi_cc_SaveAs.Text = "Save As...";
			// 
			// cmi_cc_Export
			// 
			this.cmi_cc_Export.Index = 6;
			this.cmi_cc_Export.Text = "Export...";
			// 
			// cmi_cc_sep2
			// 
			this.cmi_cc_sep2.Index = 7;
			this.cmi_cc_sep2.Text = "-";
			// 
			// cmi_cc_Remove
			// 
			this.cmi_cc_Remove.Index = 8;
			this.cmi_cc_Remove.Text = "Remove";
			this.cmi_cc_Remove.Click += new System.EventHandler(this.cmi_cc_Remove_Click);
			// 
			// contextMenuBasic
			// 
			this.contextMenuBasic.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																							 this.cmi_bc_AttachInterface,
																							 this.cmi_bc_sep1,
																							 this.cmi_bc_Save,
																							 this.cmi_bc_SaveAs,
																							 this.cmi_bc_sep2,
																							 this.cmi_bc_Remove});
			// 
			// cmi_bc_AttachInterface
			// 
			this.cmi_bc_AttachInterface.Index = 0;
			this.cmi_bc_AttachInterface.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																								   this.cmi_bc_NewProvidesInterface,
																								   this.cmi_bc_NewRequiresInterface,
																								   this.cmi_bc_sep3,
																								   this.cmi_bc_ImportAsProvides,
																								   this.cmi_bc_ImportAsRequires});
			this.cmi_bc_AttachInterface.Text = "Attach Interface";
			// 
			// cmi_bc_NewProvidesInterface
			// 
			this.cmi_bc_NewProvidesInterface.Index = 0;
			this.cmi_bc_NewProvidesInterface.Text = "New Provides Interface...";
			this.cmi_bc_NewProvidesInterface.Click += new System.EventHandler(this.cmi_cc_NewProvidesInterface_Click);
			// 
			// cmi_bc_NewRequiresInterface
			// 
			this.cmi_bc_NewRequiresInterface.Index = 1;
			this.cmi_bc_NewRequiresInterface.Text = "New Requires Interface...";
			this.cmi_bc_NewRequiresInterface.Click += new System.EventHandler(this.cmi_cc_NewRequiresInterface_Click);
			// 
			// cmi_bc_sep3
			// 
			this.cmi_bc_sep3.Index = 2;
			this.cmi_bc_sep3.Text = "-";
			// 
			// cmi_bc_ImportAsProvides
			// 
			this.cmi_bc_ImportAsProvides.Index = 3;
			this.cmi_bc_ImportAsProvides.Text = "Import as Provides...";
			// 
			// cmi_bc_ImportAsRequires
			// 
			this.cmi_bc_ImportAsRequires.Index = 4;
			this.cmi_bc_ImportAsRequires.Text = "Import as Requires...";
			// 
			// cmi_bc_sep1
			// 
			this.cmi_bc_sep1.Index = 1;
			this.cmi_bc_sep1.Text = "-";
			// 
			// cmi_bc_Save
			// 
			this.cmi_bc_Save.Index = 2;
			this.cmi_bc_Save.Text = "Save";
			// 
			// cmi_bc_SaveAs
			// 
			this.cmi_bc_SaveAs.Index = 3;
			this.cmi_bc_SaveAs.Text = "Save As...";
			// 
			// cmi_bc_sep2
			// 
			this.cmi_bc_sep2.Index = 4;
			this.cmi_bc_sep2.Text = "-";
			// 
			// cmi_bc_Remove
			// 
			this.cmi_bc_Remove.Index = 5;
			this.cmi_bc_Remove.Text = "Remove";
			this.cmi_bc_Remove.Click += new System.EventHandler(this.cmi_cc_Remove_Click);
			// 
			// TreeViewPresentation
			// 
			this.Controls.Add(this.treeView);
			this.Name = "TreeViewPresentation";
			this.Size = new System.Drawing.Size(1104, 570);
			this.ResumeLayout(false);

		}
		#endregion

		internal void BuildTree(CompositeComponentProxy model) 
		{
			this.treeView.Nodes.Clear();

			TreeNode root = CreateCompositeComponentNode(model);

			this.treeView.Nodes.Add(root);
		}

		public void SelectNode(EntityProxy entity)
		{
			//Todo
			this.ClearSelection();
		}

		public void ClearSelection()
		{
			treeView.AfterSelect -= treeView_AfterSelectHandler;
			this.treeView.SelectedNode = null;
			treeView.AfterSelect += treeView_AfterSelectHandler;
		}

		internal void RebuildSubtree(EntityProxy entity)
		{
			this.treeView.AfterSelect -= this.treeView_AfterSelectHandler;

			bool finished = false;

			foreach (TreeNode node in this.treeView.Nodes)
			{
				if (node.Tag != null)
				{
					EntityProxy nodeEntity = node.Tag as EntityProxy;
					if (nodeEntity.ID.Equals(entity.ID))
					{
						TreeNode newNode = null;
						node.Remove();
						if (entity is BasicComponentProxy)
						{
							BasicComponentProxy bcp = entity as BasicComponentProxy;
							newNode = CreateBasicComponentNode(bcp);
							newNode.Tag = bcp;
						}
						else if (entity is CompositeComponentProxy)
						{
							CompositeComponentProxy ccp = entity as CompositeComponentProxy;
							newNode = CreateCompositeComponentNode(ccp);
							newNode.Tag = ccp;
						}
						else if (entity is RoleProxy)
						{
							RoleProxy rp = entity as RoleProxy;
							newNode = CreateRoleNode(rp, node.ImageIndex);
							newNode.Tag = rp;
						}
						else if (entity is InterfaceProxy)
						{
							InterfaceProxy ip = entity as InterfaceProxy;
							newNode = CreateInterfaceNode(ip);
							newNode.Tag = ip;
						}

						this.treeView.Nodes.Add(newNode);
						finished = true;
					}
				}
			}

			if (!finished)
			{
				for(int i = 0; i < this.treeView.Nodes.Count && !finished; i++)
				{
					TreeNode node = this.treeView.Nodes[i];
					finished = RebuildSubtree(node, entity);
				}
			}

			this.treeView.AfterSelect += this.treeView_AfterSelectHandler;
		}

		private bool RebuildSubtree(TreeNode rootNode, EntityProxy entity)
		{
			bool finished = false;

			foreach (TreeNode node in rootNode.Nodes)
			{
				if (node.Tag != null)
				{
					EntityProxy nodeEntity = node.Tag as EntityProxy;
					if (nodeEntity.ID.Equals(entity.ID))
					{
						TreeNode parent = node.Parent;
						TreeNode newNode = null;
						node.Remove();
						if (entity is BasicComponentProxy)
						{
							BasicComponentProxy bcp = entity as BasicComponentProxy;
							newNode = CreateBasicComponentNode(bcp);
							newNode.Tag = bcp;
						}
						else if (entity is CompositeComponentProxy)
						{
							CompositeComponentProxy ccp = entity as CompositeComponentProxy;
							newNode = CreateCompositeComponentNode(ccp);
							newNode.Tag = ccp;
						}
						else if (entity is RoleProxy)
						{
							RoleProxy rp = entity as RoleProxy;
							newNode = CreateRoleNode(rp, node.ImageIndex);
							newNode.Tag = rp;
						}
						else if (entity is InterfaceProxy)
						{
							InterfaceProxy ip = entity as InterfaceProxy;
							newNode = CreateInterfaceNode(ip);
							newNode.Tag = ip;
						}

						parent.Nodes.Add(newNode);
						finished = true;
					}
				}
			}

			if (!finished)
			{
				for(int i = 0; i < rootNode.Nodes.Count && !finished; i++)
				{
					TreeNode node = rootNode.Nodes[i];
					finished = RebuildSubtree(node, entity);
				}
			}
			return finished;
		}

		private TreeNode CreateCompositeComponentNode(CompositeComponentProxy comp)
		{
			TreeNode compNode = new TreeNode(comp.Name);
			compNode.Tag = comp;

			foreach (ComponentProxy subcomp in comp.Components)
			{
				if (subcomp is CompositeComponentProxy)
					compNode.Nodes.Add(CreateCompositeComponentNode(subcomp as CompositeComponentProxy));
				if (subcomp is BasicComponentProxy)
					compNode.Nodes.Add(CreateBasicComponentNode(subcomp as BasicComponentProxy));
			}

			if (comp.ProvidedRoles.Count > 0)
			{
				foreach (RoleProxy role in comp.ProvidedRoles)
				{
					compNode.Nodes.Add( CreateRoleNode(role, 1) );
				}
			}

			if (comp.RequiredRoles.Count > 0)
			{
				foreach (RoleProxy role in comp.RequiredRoles)
				{
					compNode.Nodes.Add( CreateRoleNode(role, 2) );
				}
			}

			return compNode;
		}

		private TreeNode CreateBasicComponentNode(BasicComponentProxy comp)
		{
			TreeNode compNode = new TreeNode(comp.Name);
			compNode.Tag = comp;

			if (comp.ProvidedRoles.Count > 0)
			{
				foreach (RoleProxy role in comp.ProvidedRoles)
				{
					compNode.Nodes.Add( CreateRoleNode(role, 1) );
				}
			}

			if (comp.RequiredRoles.Count > 0)
			{
				foreach (RoleProxy role in comp.RequiredRoles)
				{
					compNode.Nodes.Add( CreateRoleNode(role, 2) );
				}
			}

			return compNode;
		}

		private TreeNode CreateRoleNode(RoleProxy role, int imageIndex)
		{
			TreeNode roleNode = new TreeNode(role.Name, imageIndex, imageIndex);
			roleNode.Tag = role;

			roleNode.Nodes.Add( CreateInterfaceNode(role.Interface) );

			return roleNode;
		}

		private TreeNode CreateInterfaceNode(InterfaceProxy iface)
		{
			TreeNode ifaceNode = new TreeNode(iface.Name, 3, 3);
			ifaceNode.Tag = iface;

			foreach(SignatureProxy sig in iface.Signatures)
			{
				ifaceNode.Nodes.Add(CreateSignatureNode(sig));
			}
			return ifaceNode;
		}

		private TreeNode CreateSignatureNode(SignatureProxy sig)
		{
			TreeNode sigNode = new TreeNode(sig.DisplayName);
			sigNode.Tag = sig;

			return sigNode;
		}

		private void treeView_AfterSelect(object sender, TreeViewEventArgs e)
		{
			if (e.Node.Tag == null)
				return;

			if (this.SelectionChanged != null)
				this.SelectionChanged(this, e.Node.Tag as EntityProxy);
		}

		private void treeView_MouseDown(object sender, System.Windows.Forms.MouseEventArgs e)
		{
			if(e.Button == MouseButtons.Right)
			{
				this.contextNode = this.treeView.GetNodeAt(e.X, e.Y);
				if (this.contextNode != null && this.contextNode.Tag != null)
				{
					if (this.contextNode.Tag is CompositeComponentProxy)
						this.contextMenuComposite.Show(this, new Point(e.X,e.Y));
					else if (this.contextNode.Tag is BasicComponentProxy)
						this.contextMenuBasic.Show(this, new Point(e.X,e.Y));
				}
			}
		}

		private void cmi_cc_NewBasicComponent_Click(object sender, System.EventArgs e)
		{
			CompositeComponentProxy entity = this.contextNode.Tag as CompositeComponentProxy;
			entity.AddBasicComponentWithDialog();
		}

		private void cmi_cc_NewCompositeComponent_Click(object sender, System.EventArgs e)
		{
			CompositeComponentProxy entity = this.contextNode.Tag as CompositeComponentProxy;
			entity.AddCompositeComponentWithDialog();		
		}

		private void cmi_cc_NewProvidesInterface_Click(object sender, System.EventArgs e)
		{
			ComponentProxy entity = this.contextNode.Tag as ComponentProxy;
			entity.AddProvidesInterfaceWithDialog();
		}

		private void cmi_cc_NewRequiresInterface_Click(object sender, System.EventArgs e)
		{
			ComponentProxy entity = this.contextNode.Tag as ComponentProxy;
			entity.AddRequiresInterfaceWithDialog();		
		}

		private void cmi_cc_Remove_Click(object sender, System.EventArgs e)
		{
			TreeNode parent = this.contextNode.Parent;
			if (parent != null && parent.Tag is CompositeComponentProxy)
			{
				CompositeComponentProxy entity = parent.Tag as CompositeComponentProxy;
				entity.RemoveComponent(((ComponentProxy)this.contextNode.Tag).ID);
			}
		}
	}
}

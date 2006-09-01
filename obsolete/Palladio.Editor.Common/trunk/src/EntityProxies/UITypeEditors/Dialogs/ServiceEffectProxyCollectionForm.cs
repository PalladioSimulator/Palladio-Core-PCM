using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace Palladio.Editor.Common.EntityProxies.UITypeEditors.Dialogs
{
	/// <summary>
	/// Zusammenfassung für ServiceEffectProxyCollectionForm.
	/// </summary>
	public class ServiceEffectProxyCollectionForm : EntityProxyCollectionForm
	{
		private System.Windows.Forms.GroupBox groupBoxProvided;
		private System.Windows.Forms.Button buttonAdd;
		private System.Windows.Forms.Button buttonRemove;
		private System.Windows.Forms.GroupBox groupBoxSpecified;
		private System.Windows.Forms.GroupBox groupBoxProperties;
		private System.Windows.Forms.PropertyGrid propertyGrid;
		private System.Windows.Forms.Button buttonClose;
		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private System.Windows.Forms.TreeView treeViewProvided;
		private System.Windows.Forms.TreeView treeViewSpecified;

		private BasicComponentProxy _component;

		public ServiceEffectProxyCollectionForm(BasicComponentProxy component)
		{
			this._component = component;
			//
			// Erforderlich für die Windows Form-Designerunterstützung
			//
			InitializeComponent();

			this.BuildTrees();
			//
			// TODO: Fügen Sie den Konstruktorcode nach dem Aufruf von InitializeComponent hinzu
			//
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

		#region Vom Windows Form-Designer generierter Code
		/// <summary>
		/// Erforderliche Methode für die Designerunterstützung. 
		/// Der Inhalt der Methode darf nicht mit dem Code-Editor geändert werden.
		/// </summary>
		private void InitializeComponent()
		{
			this.groupBoxProvided = new System.Windows.Forms.GroupBox();
			this.treeViewProvided = new System.Windows.Forms.TreeView();
			this.buttonAdd = new System.Windows.Forms.Button();
			this.buttonRemove = new System.Windows.Forms.Button();
			this.groupBoxSpecified = new System.Windows.Forms.GroupBox();
			this.treeViewSpecified = new System.Windows.Forms.TreeView();
			this.groupBoxProperties = new System.Windows.Forms.GroupBox();
			this.propertyGrid = new System.Windows.Forms.PropertyGrid();
			this.buttonClose = new System.Windows.Forms.Button();
			this.groupBoxProvided.SuspendLayout();
			this.groupBoxSpecified.SuspendLayout();
			this.groupBoxProperties.SuspendLayout();
			this.SuspendLayout();
			// 
			// groupBoxProvided
			// 
			this.groupBoxProvided.Controls.Add(this.treeViewProvided);
			this.groupBoxProvided.Location = new System.Drawing.Point(0, 0);
			this.groupBoxProvided.Name = "groupBoxProvided";
			this.groupBoxProvided.Size = new System.Drawing.Size(184, 320);
			this.groupBoxProvided.TabIndex = 0;
			this.groupBoxProvided.TabStop = false;
			this.groupBoxProvided.Text = "Provided Services";
			// 
			// treeViewProvided
			// 
			this.treeViewProvided.Dock = System.Windows.Forms.DockStyle.Fill;
			this.treeViewProvided.ImageIndex = -1;
			this.treeViewProvided.Location = new System.Drawing.Point(3, 16);
			this.treeViewProvided.Name = "treeViewProvided";
			this.treeViewProvided.SelectedImageIndex = -1;
			this.treeViewProvided.Size = new System.Drawing.Size(178, 301);
			this.treeViewProvided.TabIndex = 0;
			// 
			// buttonAdd
			// 
			this.buttonAdd.Location = new System.Drawing.Point(192, 72);
			this.buttonAdd.Name = "buttonAdd";
			this.buttonAdd.Size = new System.Drawing.Size(48, 23);
			this.buttonAdd.TabIndex = 1;
			this.buttonAdd.Text = ">>";
			this.buttonAdd.Click += new System.EventHandler(this.buttonAdd_Click);
			// 
			// buttonRemove
			// 
			this.buttonRemove.Location = new System.Drawing.Point(192, 112);
			this.buttonRemove.Name = "buttonRemove";
			this.buttonRemove.Size = new System.Drawing.Size(48, 23);
			this.buttonRemove.TabIndex = 2;
			this.buttonRemove.Text = "<<";
			// 
			// groupBoxSpecified
			// 
			this.groupBoxSpecified.Controls.Add(this.treeViewSpecified);
			this.groupBoxSpecified.Location = new System.Drawing.Point(248, 0);
			this.groupBoxSpecified.Name = "groupBoxSpecified";
			this.groupBoxSpecified.Size = new System.Drawing.Size(184, 320);
			this.groupBoxSpecified.TabIndex = 3;
			this.groupBoxSpecified.TabStop = false;
			this.groupBoxSpecified.Text = "Specified Service Effects";
			// 
			// treeViewSpecified
			// 
			this.treeViewSpecified.Dock = System.Windows.Forms.DockStyle.Fill;
			this.treeViewSpecified.HideSelection = false;
			this.treeViewSpecified.ImageIndex = -1;
			this.treeViewSpecified.Location = new System.Drawing.Point(3, 16);
			this.treeViewSpecified.Name = "treeViewSpecified";
			this.treeViewSpecified.SelectedImageIndex = -1;
			this.treeViewSpecified.Size = new System.Drawing.Size(178, 301);
			this.treeViewSpecified.TabIndex = 0;
			this.treeViewSpecified.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.treeViewSpecified_AfterSelect);
			// 
			// groupBoxProperties
			// 
			this.groupBoxProperties.Controls.Add(this.propertyGrid);
			this.groupBoxProperties.Location = new System.Drawing.Point(440, 0);
			this.groupBoxProperties.Name = "groupBoxProperties";
			this.groupBoxProperties.Size = new System.Drawing.Size(240, 320);
			this.groupBoxProperties.TabIndex = 4;
			this.groupBoxProperties.TabStop = false;
			this.groupBoxProperties.Text = "Properties";
			// 
			// propertyGrid
			// 
			this.propertyGrid.CommandsVisibleIfAvailable = true;
			this.propertyGrid.Dock = System.Windows.Forms.DockStyle.Fill;
			this.propertyGrid.LargeButtons = false;
			this.propertyGrid.LineColor = System.Drawing.SystemColors.ScrollBar;
			this.propertyGrid.Location = new System.Drawing.Point(3, 16);
			this.propertyGrid.Name = "propertyGrid";
			this.propertyGrid.PropertySort = System.Windows.Forms.PropertySort.Categorized;
			this.propertyGrid.Size = new System.Drawing.Size(234, 301);
			this.propertyGrid.TabIndex = 1;
			this.propertyGrid.Text = "Properties";
			this.propertyGrid.ViewBackColor = System.Drawing.SystemColors.Window;
			this.propertyGrid.ViewForeColor = System.Drawing.SystemColors.WindowText;
			// 
			// buttonClose
			// 
			this.buttonClose.Location = new System.Drawing.Point(192, 288);
			this.buttonClose.Name = "buttonClose";
			this.buttonClose.Size = new System.Drawing.Size(48, 23);
			this.buttonClose.TabIndex = 5;
			this.buttonClose.Text = "Close";
			this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
			// 
			// ServiceEffectProxyCollectionForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(682, 322);
			this.Controls.Add(this.buttonClose);
			this.Controls.Add(this.groupBoxProperties);
			this.Controls.Add(this.groupBoxSpecified);
			this.Controls.Add(this.buttonRemove);
			this.Controls.Add(this.buttonAdd);
			this.Controls.Add(this.groupBoxProvided);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "ServiceEffectProxyCollectionForm";
			this.ShowInTaskbar = false;
			this.Text = "ServiceEffectProxyCollectionForm";
			this.groupBoxProvided.ResumeLayout(false);
			this.groupBoxSpecified.ResumeLayout(false);
			this.groupBoxProperties.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion


		private void BuildTrees()
		{
			this.treeViewProvided.Nodes.Clear();
			this.treeViewSpecified.Nodes.Clear();
			foreach(RoleProxy providedRole in this._component.ProvidedRoles)
			{
				TreeNode ifaceNode = new TreeNode(providedRole.Interface.Name);
				ifaceNode.Tag = providedRole;
				foreach(SignatureProxy sig in providedRole.Interface.Signatures)
				{
					TreeNode sigNode = new TreeNode(sig.DisplayName);
					sigNode.Tag = sig;
					ifaceNode.Nodes.Add(sigNode);
					if (this._component.GetServiceEffectSpecification(providedRole.Interface.ID,sig.ID) != null)
						this.AddServiceEffectToTree(sigNode);
				}
				this.treeViewProvided.Nodes.Add(ifaceNode);
			}
			this.treeViewProvided.ExpandAll();
			this.treeViewSpecified.ExpandAll();
		}


		private void buttonClose_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void buttonAdd_Click(object sender, System.EventArgs e)
		{
			TreeNode selectedNode = this.treeViewProvided.SelectedNode;
			if (selectedNode !=null && selectedNode.Tag is SignatureProxy)
			{
				TreeNode newNode = this.AddServiceEffectToTree(selectedNode);
				if (newNode != null)
				{
					this._component.AddServiceEffectSpecification(newNode.Tag as SignatureProxy);
					newNode.EnsureVisible();
					this.treeViewSpecified.SelectedNode = newNode;
					this.treeViewSpecified.Select();
				}
			}
		}

		private TreeNode AddServiceEffectToTree(TreeNode node)
		{
			if (node != null && node.Tag is SignatureProxy)
			{
				foreach(TreeNode ifaceNode in this.treeViewSpecified.Nodes)
				{
					if (ifaceNode.Tag == node.Parent.Tag)
					{
						foreach(TreeNode sigNode in ifaceNode.Nodes)
						{
							if (sigNode.Tag == node.Tag)
								return sigNode;
						}
						TreeNode newSigNode = new TreeNode(((SignatureProxy)node.Tag).DisplayName);
						newSigNode.Tag = node.Tag;
						ifaceNode.Nodes.Add(newSigNode);
						//this.propertyGrid.SelectedObject = this._component.GetServiceEffectSpecification(((RoleProxy)ifaceNode.Tag).ID, ((SignatureProxy)node.Tag).ID);
						return newSigNode;
					}
				}
				TreeNode newIfaceNode = new TreeNode(((RoleProxy)node.Parent.Tag).Interface.Name);
				newIfaceNode.Tag = node.Parent.Tag;
				TreeNode newSig = new TreeNode(((SignatureProxy)node.Tag).DisplayName);
				newSig.Tag = node.Tag;
				newIfaceNode.Nodes.Add(newSig);
				this.treeViewSpecified.Nodes.Add(newIfaceNode);
				return newSig;
			}
			return null;
		}

		private void treeViewSpecified_AfterSelect(object sender, System.Windows.Forms.TreeViewEventArgs e)
		{
			if (e.Node.Tag is SignatureProxy)
				this.propertyGrid.SelectedObject = this._component.GetServiceEffectSpecification(((RoleProxy)e.Node.Parent.Tag).Interface.ID, ((SignatureProxy)e.Node.Tag).ID);
		}

		public override EntityProxy Proxy
		{
			get
			{
				return this._component;
			}

			set
			{
				if (!(value is BasicComponentProxy))
					return;

				this._component = value as BasicComponentProxy;
				this.BuildTrees();
			}
		}
	}
}

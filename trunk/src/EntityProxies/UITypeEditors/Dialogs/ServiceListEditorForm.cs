using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace Palladio.Editor.Common.EntityProxies.UITypeEditors.Dialogs
{
	/// <summary>
	/// Zusammenfassung für ServiceListEditor.
	/// </summary>
	public class ServiceListEditorForm : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Button buttonClose;
		private System.Windows.Forms.GroupBox groupBoxSpecified;
		private System.Windows.Forms.Button buttonRemove;
		private System.Windows.Forms.Button buttonAdd;
		private System.Windows.Forms.GroupBox groupBoxProvided;
		private System.Windows.Forms.TreeView treeViewRequired;
		private System.Windows.Forms.TreeView treeViewAvailable;
		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		private ServiceEffectSpecificationProxy _sef;

		public ServiceListEditorForm(ServiceEffectSpecificationProxy sef)
		{
			this._sef = sef;
			//
			// Erforderlich für die Windows Form-Designerunterstützung
			//
			InitializeComponent();

			this.BuildTrees();
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
			this.buttonClose = new System.Windows.Forms.Button();
			this.groupBoxSpecified = new System.Windows.Forms.GroupBox();
			this.treeViewRequired = new System.Windows.Forms.TreeView();
			this.buttonRemove = new System.Windows.Forms.Button();
			this.buttonAdd = new System.Windows.Forms.Button();
			this.groupBoxProvided = new System.Windows.Forms.GroupBox();
			this.treeViewAvailable = new System.Windows.Forms.TreeView();
			this.groupBoxSpecified.SuspendLayout();
			this.groupBoxProvided.SuspendLayout();
			this.SuspendLayout();
			// 
			// buttonClose
			// 
			this.buttonClose.Location = new System.Drawing.Point(192, 248);
			this.buttonClose.Name = "buttonClose";
			this.buttonClose.Size = new System.Drawing.Size(48, 23);
			this.buttonClose.TabIndex = 10;
			this.buttonClose.Text = "Close";
			this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
			// 
			// groupBoxSpecified
			// 
			this.groupBoxSpecified.Controls.Add(this.treeViewRequired);
			this.groupBoxSpecified.Location = new System.Drawing.Point(248, 0);
			this.groupBoxSpecified.Name = "groupBoxSpecified";
			this.groupBoxSpecified.Size = new System.Drawing.Size(184, 280);
			this.groupBoxSpecified.TabIndex = 9;
			this.groupBoxSpecified.TabStop = false;
			this.groupBoxSpecified.Text = "Required Services";
			// 
			// treeViewRequired
			// 
			this.treeViewRequired.Dock = System.Windows.Forms.DockStyle.Fill;
			this.treeViewRequired.HideSelection = false;
			this.treeViewRequired.ImageIndex = -1;
			this.treeViewRequired.Location = new System.Drawing.Point(3, 16);
			this.treeViewRequired.Name = "treeViewRequired";
			this.treeViewRequired.SelectedImageIndex = -1;
			this.treeViewRequired.Size = new System.Drawing.Size(178, 261);
			this.treeViewRequired.TabIndex = 0;
			// 
			// buttonRemove
			// 
			this.buttonRemove.Location = new System.Drawing.Point(192, 112);
			this.buttonRemove.Name = "buttonRemove";
			this.buttonRemove.Size = new System.Drawing.Size(48, 23);
			this.buttonRemove.TabIndex = 8;
			this.buttonRemove.Text = "<<";
			// 
			// buttonAdd
			// 
			this.buttonAdd.Location = new System.Drawing.Point(192, 72);
			this.buttonAdd.Name = "buttonAdd";
			this.buttonAdd.Size = new System.Drawing.Size(48, 23);
			this.buttonAdd.TabIndex = 7;
			this.buttonAdd.Text = ">>";
			this.buttonAdd.Click += new System.EventHandler(this.buttonAdd_Click);
			// 
			// groupBoxProvided
			// 
			this.groupBoxProvided.Controls.Add(this.treeViewAvailable);
			this.groupBoxProvided.Location = new System.Drawing.Point(0, 0);
			this.groupBoxProvided.Name = "groupBoxProvided";
			this.groupBoxProvided.Size = new System.Drawing.Size(184, 280);
			this.groupBoxProvided.TabIndex = 6;
			this.groupBoxProvided.TabStop = false;
			this.groupBoxProvided.Text = "Services in Requires Interfaces";
			// 
			// treeViewAvailable
			// 
			this.treeViewAvailable.Dock = System.Windows.Forms.DockStyle.Fill;
			this.treeViewAvailable.ImageIndex = -1;
			this.treeViewAvailable.Location = new System.Drawing.Point(3, 16);
			this.treeViewAvailable.Name = "treeViewAvailable";
			this.treeViewAvailable.SelectedImageIndex = -1;
			this.treeViewAvailable.Size = new System.Drawing.Size(178, 261);
			this.treeViewAvailable.TabIndex = 0;
			// 
			// ServiceListEditorForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(432, 280);
			this.Controls.Add(this.buttonClose);
			this.Controls.Add(this.groupBoxSpecified);
			this.Controls.Add(this.buttonRemove);
			this.Controls.Add(this.buttonAdd);
			this.Controls.Add(this.groupBoxProvided);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "ServiceListEditorForm";
			this.ShowInTaskbar = false;
			this.Text = "ServiceListEditor";
			this.groupBoxSpecified.ResumeLayout(false);
			this.groupBoxProvided.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void BuildTrees()
		{
			this.treeViewAvailable.Nodes.Clear();
			this.treeViewRequired.Nodes.Clear();
			foreach(RoleProxy requiredRole in this._sef.Component.RequiredRoles)
			{
				TreeNode ifaceNode = new TreeNode(requiredRole.Interface.Name);
				ifaceNode.Tag = requiredRole;
				foreach(SignatureProxy sig in requiredRole.Interface.Signatures)
				{
					TreeNode sigNode = new TreeNode(sig.DisplayName);
					sigNode.Tag = sig;
					ifaceNode.Nodes.Add(sigNode);
					foreach(SignatureProxy sefSig in this._sef.ServiceList)
						if (sefSig.ID.Equals(sig.ID))
							this.AddServiceToTree(sigNode);
				}
				this.treeViewAvailable.Nodes.Add(ifaceNode);
			}
			this.treeViewAvailable.ExpandAll();
			this.treeViewRequired.ExpandAll();
		}

		private void buttonClose_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void buttonAdd_Click(object sender, System.EventArgs e)
		{
			TreeNode selectedNode = this.treeViewAvailable.SelectedNode;
			if (selectedNode !=null && selectedNode.Tag is SignatureProxy)
			{
				TreeNode newNode = this.AddServiceToTree(selectedNode);
				if (newNode != null)
				{
					this._sef.AddServiceToServiceList(newNode.Tag as SignatureProxy);
					newNode.EnsureVisible();
					this.treeViewRequired.SelectedNode = newNode;
					this.treeViewRequired.Select();
				}
			}
		}

		private TreeNode AddServiceToTree(TreeNode node)
		{
			if (node != null && node.Tag is SignatureProxy)
			{
				foreach(TreeNode ifaceNode in this.treeViewRequired.Nodes)
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
						return newSigNode;
					}
				}
				TreeNode newIfaceNode = new TreeNode(((RoleProxy)node.Parent.Tag).Interface.Name);
				newIfaceNode.Tag = node.Parent.Tag;
				TreeNode newSig = new TreeNode(((SignatureProxy)node.Tag).DisplayName);
				newSig.Tag = node.Tag;
				newIfaceNode.Nodes.Add(newSig);
				this.treeViewRequired.Nodes.Add(newIfaceNode);
				return newSig;
			}
			return null;
		}
	}
}

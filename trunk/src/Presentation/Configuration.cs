using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;

using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Plugins.AnalyzeTest.Presentation
{
	/// <summary>
	/// Zusammenfassung für Configuration.
	/// </summary>
	public class Configuration : System.Windows.Forms.UserControl
	{
		private System.Windows.Forms.TabControl tabControl1;
		private System.Windows.Forms.TabPage tabPage1;
		private System.Windows.Forms.TabPage tabPage2;
		private System.Windows.Forms.TabPage tabPage3;
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.TreeView treeView1;
		private System.Windows.Forms.GroupBox groupBox2;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label label2;

		public event EventHandler ServiceSelectionChanged;

		/// <summary> 
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public Configuration()
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
			this.tabControl1 = new System.Windows.Forms.TabControl();
			this.tabPage1 = new System.Windows.Forms.TabPage();
			this.tabPage2 = new System.Windows.Forms.TabPage();
			this.tabPage3 = new System.Windows.Forms.TabPage();
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.treeView1 = new System.Windows.Forms.TreeView();
			this.groupBox2 = new System.Windows.Forms.GroupBox();
			this.label1 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.tabControl1.SuspendLayout();
			this.tabPage1.SuspendLayout();
			this.groupBox1.SuspendLayout();
			this.groupBox2.SuspendLayout();
			this.SuspendLayout();
			// 
			// tabControl1
			// 
			this.tabControl1.Controls.Add(this.tabPage1);
			this.tabControl1.Controls.Add(this.tabPage2);
			this.tabControl1.Controls.Add(this.tabPage3);
			this.tabControl1.Dock = System.Windows.Forms.DockStyle.Fill;
			this.tabControl1.Location = new System.Drawing.Point(0, 0);
			this.tabControl1.Name = "tabControl1";
			this.tabControl1.SelectedIndex = 0;
			this.tabControl1.Size = new System.Drawing.Size(336, 200);
			this.tabControl1.TabIndex = 0;
			// 
			// tabPage1
			// 
			this.tabPage1.Controls.Add(this.groupBox2);
			this.tabPage1.Controls.Add(this.groupBox1);
			this.tabPage1.Location = new System.Drawing.Point(4, 22);
			this.tabPage1.Name = "tabPage1";
			this.tabPage1.Size = new System.Drawing.Size(328, 174);
			this.tabPage1.TabIndex = 0;
			this.tabPage1.Text = "tabPage1";
			// 
			// tabPage2
			// 
			this.tabPage2.Location = new System.Drawing.Point(4, 22);
			this.tabPage2.Name = "tabPage2";
			this.tabPage2.Size = new System.Drawing.Size(328, 174);
			this.tabPage2.TabIndex = 1;
			this.tabPage2.Text = "tabPage2";
			// 
			// tabPage3
			// 
			this.tabPage3.Location = new System.Drawing.Point(4, 22);
			this.tabPage3.Name = "tabPage3";
			this.tabPage3.Size = new System.Drawing.Size(328, 174);
			this.tabPage3.TabIndex = 2;
			this.tabPage3.Text = "tabPage3";
			// 
			// groupBox1
			// 
			this.groupBox1.Controls.Add(this.treeView1);
			this.groupBox1.Dock = System.Windows.Forms.DockStyle.Left;
			this.groupBox1.Location = new System.Drawing.Point(0, 0);
			this.groupBox1.Name = "groupBox1";
			this.groupBox1.Size = new System.Drawing.Size(192, 174);
			this.groupBox1.TabIndex = 0;
			this.groupBox1.TabStop = false;
			this.groupBox1.Text = "Select Service to call";
			// 
			// treeView1
			// 
			this.treeView1.Dock = System.Windows.Forms.DockStyle.Fill;
			this.treeView1.HideSelection = false;
			this.treeView1.ImageIndex = -1;
			this.treeView1.Location = new System.Drawing.Point(3, 16);
			this.treeView1.Name = "treeView1";
			this.treeView1.SelectedImageIndex = -1;
			this.treeView1.Size = new System.Drawing.Size(186, 155);
			this.treeView1.TabIndex = 0;
			this.treeView1.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.treeView1_AfterSelect);
			// 
			// groupBox2
			// 
			this.groupBox2.Controls.Add(this.label2);
			this.groupBox2.Controls.Add(this.label1);
			this.groupBox2.Dock = System.Windows.Forms.DockStyle.Fill;
			this.groupBox2.Location = new System.Drawing.Point(192, 0);
			this.groupBox2.Name = "groupBox2";
			this.groupBox2.Size = new System.Drawing.Size(136, 174);
			this.groupBox2.TabIndex = 1;
			this.groupBox2.TabStop = false;
			this.groupBox2.Text = "Analysis self-check";
			// 
			// label1
			// 
			this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label1.Location = new System.Drawing.Point(8, 24);
			this.label1.Name = "label1";
			this.label1.TabIndex = 0;
			this.label1.Text = "label1";
			this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// label2
			// 
			this.label2.Location = new System.Drawing.Point(8, 56);
			this.label2.Name = "label2";
			this.label2.TabIndex = 1;
			this.label2.Text = "label2";
			// 
			// Configuration
			// 
			this.Controls.Add(this.tabControl1);
			this.Name = "Configuration";
			this.Size = new System.Drawing.Size(336, 200);
			this.tabControl1.ResumeLayout(false);
			this.tabPage1.ResumeLayout(false);
			this.groupBox1.ResumeLayout(false);
			this.groupBox2.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		public void UpdateComponents(CompositeComponentProxy model)
		{
			this.treeView1.Nodes.Clear();
			foreach(RoleProxy role in model.ProvidedRoles)
			{
				TreeNode roleNode = new TreeNode(role.Name);
				roleNode.Tag = role.Interface;
				foreach(SignatureProxy sig in role.Interface.Signatures)
				{
					TreeNode sigNode = new TreeNode(sig.DisplayName);
					sigNode.Tag = sig;
					roleNode.Nodes.Add(sigNode);
				}
				this.treeView1.Nodes.Add(roleNode);
			}
		}

		public SignatureProxy GetSelectedService()
		{
			if (this.treeView1.SelectedNode != null && this.treeView1.SelectedNode.Tag is SignatureProxy)
				return this.treeView1.SelectedNode.Tag as SignatureProxy;
			return null;
		}

		private void treeView1_AfterSelect(object sender, System.Windows.Forms.TreeViewEventArgs e)
		{
			if (this.ServiceSelectionChanged != null)
				this.ServiceSelectionChanged(this, new System.EventArgs());
		}

		public bool CanStart
		{
			set
			{
				if (value == true)
				{
					this.label1.Text = "OK";
					this.label2.Text = "";
				}
				else
				{
					this.label1.Text = "Negative";
					this.label2.Text = "Select a Service";
				}
			}
		}

	}
}

using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Common.EntityProxies.UITypeEditors.Dialogs
{
	/// <summary>
	/// Zusammenfassung für EditCompositeComponentProxyCollection.
	/// </summary>
	public class RoleProxyCollectionForm : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Panel panel1;
		private System.Windows.Forms.Panel panel2;
		private System.Windows.Forms.Panel panelLeftBottom;
		private System.Windows.Forms.Panel panelRightBottom;
		private System.Windows.Forms.Button buttonAdd;
		private System.Windows.Forms.Button buttonRemove;
		private System.Windows.Forms.Button buttonOk;
		private System.Windows.Forms.GroupBox groupBoxLeft;
		private System.Windows.Forms.GroupBox groupBoxRight;
		private System.Windows.Forms.ListBox listBox;
		private System.Windows.Forms.PropertyGrid propertyGrid;
		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		private ComponentProxy _component;
		private bool _isRequiredRolesForm;
		private int lastSelectedIndex;

		public RoleProxyCollectionForm(ComponentProxy parentComp, bool isRequiredRolesForm)
		{
			this._component = parentComp;
			this._isRequiredRolesForm = isRequiredRolesForm;
			//
			// Erforderlich für die Windows Form-Designerunterstützung
			//
			InitializeComponent();

			if (this._isRequiredRolesForm)
				this.Text = "Edit Requires Interfaces";
			else
				this.Text = "Edit Provides Interfaces";

			this.propertyGrid.PropertyValueChanged += new PropertyValueChangedEventHandler(propertyGrid_PropertyValueChanged);

			this.listBox.DisplayMember = "Name";
			this.UpdateList();
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
			this.panel1 = new System.Windows.Forms.Panel();
			this.groupBoxLeft = new System.Windows.Forms.GroupBox();
			this.listBox = new System.Windows.Forms.ListBox();
			this.panelLeftBottom = new System.Windows.Forms.Panel();
			this.buttonRemove = new System.Windows.Forms.Button();
			this.buttonAdd = new System.Windows.Forms.Button();
			this.panel2 = new System.Windows.Forms.Panel();
			this.groupBoxRight = new System.Windows.Forms.GroupBox();
			this.propertyGrid = new System.Windows.Forms.PropertyGrid();
			this.panelRightBottom = new System.Windows.Forms.Panel();
			this.buttonOk = new System.Windows.Forms.Button();
			this.panel1.SuspendLayout();
			this.groupBoxLeft.SuspendLayout();
			this.panelLeftBottom.SuspendLayout();
			this.panel2.SuspendLayout();
			this.groupBoxRight.SuspendLayout();
			this.panelRightBottom.SuspendLayout();
			this.SuspendLayout();
			// 
			// panel1
			// 
			this.panel1.Controls.Add(this.groupBoxLeft);
			this.panel1.Controls.Add(this.panelLeftBottom);
			this.panel1.Dock = System.Windows.Forms.DockStyle.Left;
			this.panel1.Location = new System.Drawing.Point(0, 0);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(200, 352);
			this.panel1.TabIndex = 0;
			// 
			// groupBoxLeft
			// 
			this.groupBoxLeft.Controls.Add(this.listBox);
			this.groupBoxLeft.Dock = System.Windows.Forms.DockStyle.Fill;
			this.groupBoxLeft.Location = new System.Drawing.Point(0, 0);
			this.groupBoxLeft.Name = "groupBoxLeft";
			this.groupBoxLeft.Size = new System.Drawing.Size(200, 312);
			this.groupBoxLeft.TabIndex = 1;
			this.groupBoxLeft.TabStop = false;
			this.groupBoxLeft.Text = "Attached Roles";
			// 
			// listBox
			// 
			this.listBox.Dock = System.Windows.Forms.DockStyle.Fill;
			this.listBox.Location = new System.Drawing.Point(3, 16);
			this.listBox.Name = "listBox";
			this.listBox.Size = new System.Drawing.Size(194, 290);
			this.listBox.TabIndex = 0;
			this.listBox.SelectedIndexChanged += new System.EventHandler(this.listBox_SelectedIndexChanged);
			// 
			// panelLeftBottom
			// 
			this.panelLeftBottom.Controls.Add(this.buttonRemove);
			this.panelLeftBottom.Controls.Add(this.buttonAdd);
			this.panelLeftBottom.Dock = System.Windows.Forms.DockStyle.Bottom;
			this.panelLeftBottom.Location = new System.Drawing.Point(0, 312);
			this.panelLeftBottom.Name = "panelLeftBottom";
			this.panelLeftBottom.Size = new System.Drawing.Size(200, 40);
			this.panelLeftBottom.TabIndex = 0;
			// 
			// buttonRemove
			// 
			this.buttonRemove.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
			this.buttonRemove.Enabled = false;
			this.buttonRemove.Location = new System.Drawing.Point(120, 8);
			this.buttonRemove.Name = "buttonRemove";
			this.buttonRemove.Size = new System.Drawing.Size(72, 23);
			this.buttonRemove.TabIndex = 1;
			this.buttonRemove.Text = "Remove";
			// 
			// buttonAdd
			// 
			this.buttonAdd.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
			this.buttonAdd.Location = new System.Drawing.Point(8, 8);
			this.buttonAdd.Name = "buttonAdd";
			this.buttonAdd.Size = new System.Drawing.Size(72, 23);
			this.buttonAdd.TabIndex = 0;
			this.buttonAdd.Text = "Add";
			this.buttonAdd.Click += new System.EventHandler(this.buttonAdd_Click);
			// 
			// panel2
			// 
			this.panel2.Controls.Add(this.groupBoxRight);
			this.panel2.Controls.Add(this.panelRightBottom);
			this.panel2.Dock = System.Windows.Forms.DockStyle.Fill;
			this.panel2.Location = new System.Drawing.Point(200, 0);
			this.panel2.Name = "panel2";
			this.panel2.Size = new System.Drawing.Size(312, 352);
			this.panel2.TabIndex = 2;
			// 
			// groupBoxRight
			// 
			this.groupBoxRight.Controls.Add(this.propertyGrid);
			this.groupBoxRight.Dock = System.Windows.Forms.DockStyle.Fill;
			this.groupBoxRight.Location = new System.Drawing.Point(0, 0);
			this.groupBoxRight.Name = "groupBoxRight";
			this.groupBoxRight.Size = new System.Drawing.Size(312, 312);
			this.groupBoxRight.TabIndex = 1;
			this.groupBoxRight.TabStop = false;
			this.groupBoxRight.Text = "Properties";
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
			this.propertyGrid.Size = new System.Drawing.Size(306, 293);
			this.propertyGrid.TabIndex = 0;
			this.propertyGrid.Text = "Properties";
			this.propertyGrid.ViewBackColor = System.Drawing.SystemColors.Window;
			this.propertyGrid.ViewForeColor = System.Drawing.SystemColors.WindowText;
			// 
			// panelRightBottom
			// 
			this.panelRightBottom.Controls.Add(this.buttonOk);
			this.panelRightBottom.Dock = System.Windows.Forms.DockStyle.Bottom;
			this.panelRightBottom.Location = new System.Drawing.Point(0, 312);
			this.panelRightBottom.Name = "panelRightBottom";
			this.panelRightBottom.Size = new System.Drawing.Size(312, 40);
			this.panelRightBottom.TabIndex = 0;
			// 
			// buttonOk
			// 
			this.buttonOk.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.buttonOk.Location = new System.Drawing.Point(224, 8);
			this.buttonOk.Name = "buttonOk";
			this.buttonOk.Size = new System.Drawing.Size(80, 23);
			this.buttonOk.TabIndex = 0;
			this.buttonOk.Text = "Ok";
			this.buttonOk.Click += new System.EventHandler(this.buttonOk_Click);
			// 
			// RoleProxyCollectionForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(512, 352);
			this.Controls.Add(this.panel2);
			this.Controls.Add(this.panel1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.SizableToolWindow;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "RoleProxyCollectionForm";
			this.ShowInTaskbar = false;
			this.Text = "Edit Roles";
			this.panel1.ResumeLayout(false);
			this.groupBoxLeft.ResumeLayout(false);
			this.panelLeftBottom.ResumeLayout(false);
			this.panel2.ResumeLayout(false);
			this.groupBoxRight.ResumeLayout(false);
			this.panelRightBottom.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		public void UpdateList()
		{
			this.listBox.Items.Clear();
			if (this._isRequiredRolesForm)
				foreach(RoleProxy role in this._component.RequiredRoles)
					this.listBox.Items.Add(role);
			else
				foreach(RoleProxy role in this._component.ProvidedRoles)
					this.listBox.Items.Add(role);
		}

		private void buttonOk_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void buttonAdd_Click(object sender, System.EventArgs e)
		{
			if (this._isRequiredRolesForm)
				this._component.AddRequiresInterface("RequiresRole"+(this._component.RequiredRoles.Count+1),"Requires"+(this._component.RequiredRoles.Count+1));
			else
				this._component.AddProvidesInterface("ProvidesRole"+(this._component.ProvidedRoles.Count+1),"Provides"+(this._component.ProvidedRoles.Count+1));
			this.UpdateList();
		}

		private void listBox_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			this.lastSelectedIndex = this.listBox.SelectedIndex;
			this.propertyGrid.SelectedObject = this.listBox.SelectedItem;
		}

		private void propertyGrid_PropertyValueChanged(object s, PropertyValueChangedEventArgs e)
		{
			this.UpdateList();
			this.listBox.SelectedIndex = this.lastSelectedIndex;
		}
	}
}

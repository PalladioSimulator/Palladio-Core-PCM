#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using log4net;

using Palladio.Editor.Common;
using Palladio.Editor.Core.Agents.PluginCoordinator;

namespace Palladio.Editor.Core.Agents.PluginCoordinator.Presentation
{
	/// <summary>
	/// This class represents a form to load, remove and control plugins
	/// </summary>
	internal class PluginControlForm : System.Windows.Forms.Form
	{
		private static readonly ILog log = LogManager.GetLogger(typeof(PluginControlForm));

		private Facade _facade;

		private System.Windows.Forms.Button buttonClose;
		private System.Windows.Forms.GroupBox groupBoxDescr;
		private System.Windows.Forms.Button buttonRemove;
		private System.Windows.Forms.Button buttonDeactivate;
		private System.Windows.Forms.Button buttonActivate;
		private System.Windows.Forms.Button buttonAdd;
		private System.Windows.Forms.GroupBox groupBoxPlugins;
		private System.Windows.Forms.ListView pluginList;
		private System.Windows.Forms.ColumnHeader pluginColumnStatus;
		private System.Windows.Forms.ColumnHeader pluginColumnName;
		private System.Windows.Forms.ColumnHeader pluginColumnInterface;
		private System.Windows.Forms.ColumnHeader pluginColumnAssembly;
		private System.Windows.Forms.Label labelDescr;
		private System.Windows.Forms.OpenFileDialog openFileDialog;
		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public PluginControlForm(Facade facade)
		{
			this._facade = facade;

			InitializeComponent();
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
			this.groupBoxDescr = new System.Windows.Forms.GroupBox();
			this.labelDescr = new System.Windows.Forms.Label();
			this.buttonRemove = new System.Windows.Forms.Button();
			this.buttonDeactivate = new System.Windows.Forms.Button();
			this.buttonActivate = new System.Windows.Forms.Button();
			this.buttonAdd = new System.Windows.Forms.Button();
			this.groupBoxPlugins = new System.Windows.Forms.GroupBox();
			this.pluginList = new System.Windows.Forms.ListView();
			this.pluginColumnStatus = new System.Windows.Forms.ColumnHeader();
			this.pluginColumnName = new System.Windows.Forms.ColumnHeader();
			this.pluginColumnInterface = new System.Windows.Forms.ColumnHeader();
			this.pluginColumnAssembly = new System.Windows.Forms.ColumnHeader();
			this.openFileDialog = new System.Windows.Forms.OpenFileDialog();
			this.groupBoxDescr.SuspendLayout();
			this.groupBoxPlugins.SuspendLayout();
			this.SuspendLayout();
			// 
			// buttonClose
			// 
			this.buttonClose.Location = new System.Drawing.Point(480, 240);
			this.buttonClose.Name = "buttonClose";
			this.buttonClose.Size = new System.Drawing.Size(96, 23);
			this.buttonClose.TabIndex = 13;
			this.buttonClose.Text = "&Close";
			this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
			// 
			// groupBoxDescr
			// 
			this.groupBoxDescr.Controls.Add(this.labelDescr);
			this.groupBoxDescr.Location = new System.Drawing.Point(8, 184);
			this.groupBoxDescr.Name = "groupBoxDescr";
			this.groupBoxDescr.Size = new System.Drawing.Size(456, 88);
			this.groupBoxDescr.TabIndex = 12;
			this.groupBoxDescr.TabStop = false;
			this.groupBoxDescr.Text = "Description";
			// 
			// labelDescr
			// 
			this.labelDescr.Location = new System.Drawing.Point(16, 24);
			this.labelDescr.Name = "labelDescr";
			this.labelDescr.Size = new System.Drawing.Size(432, 56);
			this.labelDescr.TabIndex = 0;
			this.labelDescr.Text = "No item selected";
			// 
			// buttonRemove
			// 
			this.buttonRemove.Enabled = false;
			this.buttonRemove.Location = new System.Drawing.Point(480, 48);
			this.buttonRemove.Name = "buttonRemove";
			this.buttonRemove.Size = new System.Drawing.Size(96, 23);
			this.buttonRemove.TabIndex = 11;
			this.buttonRemove.Text = "&Remove";
			this.buttonRemove.Click += new System.EventHandler(this.buttonRemove_Click);
			// 
			// buttonDeactivate
			// 
			this.buttonDeactivate.Enabled = false;
			this.buttonDeactivate.Location = new System.Drawing.Point(480, 144);
			this.buttonDeactivate.Name = "buttonDeactivate";
			this.buttonDeactivate.Size = new System.Drawing.Size(96, 23);
			this.buttonDeactivate.TabIndex = 10;
			this.buttonDeactivate.Text = "D&eactivate";
			this.buttonDeactivate.Click += new System.EventHandler(this.buttonDeactivate_Click);
			// 
			// buttonActivate
			// 
			this.buttonActivate.Enabled = false;
			this.buttonActivate.Location = new System.Drawing.Point(480, 112);
			this.buttonActivate.Name = "buttonActivate";
			this.buttonActivate.Size = new System.Drawing.Size(96, 23);
			this.buttonActivate.TabIndex = 9;
			this.buttonActivate.Text = "Ac&tivate";
			this.buttonActivate.Click += new System.EventHandler(this.buttonActivate_Click);
			// 
			// buttonAdd
			// 
			this.buttonAdd.Location = new System.Drawing.Point(480, 16);
			this.buttonAdd.Name = "buttonAdd";
			this.buttonAdd.Size = new System.Drawing.Size(96, 23);
			this.buttonAdd.TabIndex = 8;
			this.buttonAdd.Text = "&Add...";
			this.buttonAdd.Click += new System.EventHandler(this.buttonAdd_Click);
			// 
			// groupBoxPlugins
			// 
			this.groupBoxPlugins.Controls.Add(this.pluginList);
			this.groupBoxPlugins.Location = new System.Drawing.Point(8, 8);
			this.groupBoxPlugins.Name = "groupBoxPlugins";
			this.groupBoxPlugins.Size = new System.Drawing.Size(456, 168);
			this.groupBoxPlugins.TabIndex = 7;
			this.groupBoxPlugins.TabStop = false;
			this.groupBoxPlugins.Text = "Available Plugins";
			// 
			// pluginList
			// 
			this.pluginList.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
																						 this.pluginColumnStatus,
																						 this.pluginColumnName,
																						 this.pluginColumnInterface,
																						 this.pluginColumnAssembly});
			this.pluginList.Dock = System.Windows.Forms.DockStyle.Fill;
			this.pluginList.FullRowSelect = true;
			this.pluginList.GridLines = true;
			this.pluginList.HideSelection = false;
			this.pluginList.Location = new System.Drawing.Point(3, 16);
			this.pluginList.MultiSelect = false;
			this.pluginList.Name = "pluginList";
			this.pluginList.Size = new System.Drawing.Size(450, 149);
			this.pluginList.TabIndex = 0;
			this.pluginList.View = System.Windows.Forms.View.Details;
			this.pluginList.SelectedIndexChanged += new System.EventHandler(this.pluginList_SelectedIndexChanged);
			// 
			// pluginColumnStatus
			// 
			this.pluginColumnStatus.Text = "Status";
			this.pluginColumnStatus.Width = 59;
			// 
			// pluginColumnName
			// 
			this.pluginColumnName.Text = "Name";
			this.pluginColumnName.Width = 166;
			// 
			// pluginColumnInterface
			// 
			this.pluginColumnInterface.Text = "Extension";
			this.pluginColumnInterface.Width = 62;
			// 
			// pluginColumnAssembly
			// 
			this.pluginColumnAssembly.Text = "Assembly";
			this.pluginColumnAssembly.Width = 697;
			// 
			// openFileDialog
			// 
			this.openFileDialog.Filter = "DLL\'s|*.dll";
			// 
			// PluginControlForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(594, 279);
			this.Controls.Add(this.buttonClose);
			this.Controls.Add(this.groupBoxDescr);
			this.Controls.Add(this.buttonRemove);
			this.Controls.Add(this.buttonDeactivate);
			this.Controls.Add(this.buttonActivate);
			this.Controls.Add(this.buttonAdd);
			this.Controls.Add(this.groupBoxPlugins);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "PluginControlForm";
			this.ShowInTaskbar = false;
			this.Text = "Plugins";
			this.groupBoxDescr.ResumeLayout(false);
			this.groupBoxPlugins.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void pluginList_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			if (this.pluginList.SelectedIndices.Count > 0)
			{
				PluginInfo info = this._facade.Abstraction.GetPluginInfo(this.pluginList.SelectedIndices[0]);
				this.labelDescr.Text = info.Description;
				if (info.Status == PluginStatus.ACTIVE) 
				{
					this.buttonActivate.Enabled = false;
					this.buttonDeactivate.Enabled = true;
				}
				else if (info.Status == PluginStatus.INACTIVE) 
				{
					this.buttonActivate.Enabled = true;
					this.buttonDeactivate.Enabled = false;
				}
				this.buttonRemove.Enabled = true;
			}
			else 
			{
				this.buttonActivate.Enabled = false;
				this.buttonDeactivate.Enabled = false;
				this.buttonRemove.Enabled = false;
			}
		}


		private void buttonAdd_Click(object sender, System.EventArgs e)
		{
			if (openFileDialog.ShowDialog() == DialogResult.OK)
			{
				this._facade.FireAddPluginRequested(openFileDialog.FileName);
			}
		}

		private void buttonRemove_Click(object sender, System.EventArgs e)
		{
			if (this.pluginList.SelectedIndices.Count > 0)
			{
				this._facade.FireRemovePluginRequested();
			}
		}

		private void buttonActivate_Click(object sender, System.EventArgs e)
		{
			this._facade.FireActivatePluginRequested();
		}

		private void buttonDeactivate_Click(object sender, System.EventArgs e)
		{
			this._facade.FireDeactivatePluginRequested();
		}

		private void buttonClose_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}


		public void UpdateList(PluginInfo[] infos)
		{
			this.pluginList.Items.Clear();
			foreach (PluginInfo info in infos) 
			{
				string status = info.Status.ToString();
				string pluginType = "";
				if (info.PluginType == PluginType.VIEW) pluginType = "View";
				if (info.PluginType == PluginType.ANALYZE) pluginType = "Analyze";
				if (info.PluginType == PluginType.IMPORT) pluginType = "Import";
				if (info.PluginType == PluginType.EXPORT) pluginType = "Export";

				ListViewItem item = new ListViewItem(new string[]{status,info.Name,pluginType,info.Assembly});
				item.Focused = false;
				item.Selected = false;
				this.pluginList.Items.Add(item);
			}
		}

		public int GetSelectedPluginListIndex()
		{
			if (this.pluginList.SelectedIndices.Count > 0)
			{
				return this.pluginList.SelectedIndices[0];
			}
			return -1;
		}

	}
}

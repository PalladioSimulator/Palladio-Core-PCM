using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

using Palladio.Editor.Common;

namespace Palladio.Editor.Core.Agents.AnalyzeCoordinator.Presentation
{
	/// <summary>
	/// Zusammenfassung für AnalysesControlForm.
	/// </summary>
	internal class AnalysesControlForm : System.Windows.Forms.Form
	{

		private Facade _facade;
		private System.Windows.Forms.GroupBox groupBoxAvailable;
		private System.Windows.Forms.ComboBox comboBoxAvailable;
		private System.Windows.Forms.GroupBox groupBoxBottom;
		private System.Windows.Forms.Button buttonStart;
		private System.Windows.Forms.GroupBox groupBoxConfigure;
		private System.Windows.Forms.Button buttonClose;

		/// <summary>
		/// Erforderliche Designervariable.</summary>
		private System.ComponentModel.Container components = null;


		public AnalysesControlForm(Facade facade)
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
			this.groupBoxAvailable = new System.Windows.Forms.GroupBox();
			this.comboBoxAvailable = new System.Windows.Forms.ComboBox();
			this.groupBoxBottom = new System.Windows.Forms.GroupBox();
			this.buttonClose = new System.Windows.Forms.Button();
			this.buttonStart = new System.Windows.Forms.Button();
			this.groupBoxConfigure = new System.Windows.Forms.GroupBox();
			this.groupBoxAvailable.SuspendLayout();
			this.groupBoxBottom.SuspendLayout();
			this.SuspendLayout();
			// 
			// groupBoxAvailable
			// 
			this.groupBoxAvailable.Controls.Add(this.comboBoxAvailable);
			this.groupBoxAvailable.Dock = System.Windows.Forms.DockStyle.Top;
			this.groupBoxAvailable.Location = new System.Drawing.Point(0, 0);
			this.groupBoxAvailable.Name = "groupBoxAvailable";
			this.groupBoxAvailable.Size = new System.Drawing.Size(528, 40);
			this.groupBoxAvailable.TabIndex = 0;
			this.groupBoxAvailable.TabStop = false;
			this.groupBoxAvailable.Text = "Available Analyses";
			// 
			// comboBoxAvailable
			// 
			this.comboBoxAvailable.Dock = System.Windows.Forms.DockStyle.Top;
			this.comboBoxAvailable.Location = new System.Drawing.Point(3, 16);
			this.comboBoxAvailable.Name = "comboBoxAvailable";
			this.comboBoxAvailable.Size = new System.Drawing.Size(522, 21);
			this.comboBoxAvailable.Sorted = true;
			this.comboBoxAvailable.TabIndex = 0;
			this.comboBoxAvailable.Text = "No analyses available. Load and activate appropriate plugins...";
			// 
			// groupBoxBottom
			// 
			this.groupBoxBottom.Controls.Add(this.buttonClose);
			this.groupBoxBottom.Controls.Add(this.buttonStart);
			this.groupBoxBottom.Dock = System.Windows.Forms.DockStyle.Bottom;
			this.groupBoxBottom.Location = new System.Drawing.Point(0, 309);
			this.groupBoxBottom.Name = "groupBoxBottom";
			this.groupBoxBottom.Size = new System.Drawing.Size(528, 48);
			this.groupBoxBottom.TabIndex = 1;
			this.groupBoxBottom.TabStop = false;
			this.groupBoxBottom.Text = "Control";
			// 
			// buttonClose
			// 
			this.buttonClose.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.buttonClose.Location = new System.Drawing.Point(8, 16);
			this.buttonClose.Name = "buttonClose";
			this.buttonClose.TabIndex = 1;
			this.buttonClose.Text = "Close";
			this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
			// 
			// buttonStart
			// 
			this.buttonStart.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
			this.buttonStart.Location = new System.Drawing.Point(344, 16);
			this.buttonStart.Name = "buttonStart";
			this.buttonStart.Size = new System.Drawing.Size(176, 23);
			this.buttonStart.TabIndex = 0;
			this.buttonStart.Text = "Start Analysis";
			this.buttonStart.Click += new System.EventHandler(this.buttonStart_Click);
			// 
			// groupBoxConfigure
			// 
			this.groupBoxConfigure.Dock = System.Windows.Forms.DockStyle.Fill;
			this.groupBoxConfigure.Location = new System.Drawing.Point(0, 40);
			this.groupBoxConfigure.Name = "groupBoxConfigure";
			this.groupBoxConfigure.Size = new System.Drawing.Size(528, 269);
			this.groupBoxConfigure.TabIndex = 2;
			this.groupBoxConfigure.TabStop = false;
			this.groupBoxConfigure.Text = "Configure";
			// 
			// AnalysesControlForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.CancelButton = this.buttonClose;
			this.ClientSize = new System.Drawing.Size(528, 357);
			this.Controls.Add(this.groupBoxConfigure);
			this.Controls.Add(this.groupBoxBottom);
			this.Controls.Add(this.groupBoxAvailable);
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "AnalysesControlForm";
			this.ShowInTaskbar = false;
			this.Text = "Analyses";
			this.groupBoxAvailable.ResumeLayout(false);
			this.groupBoxBottom.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		public void UpdateComboBox()
		{
			this.comboBoxAvailable.Items.Clear();
			foreach (string type in this._facade.Abstraction.AttachedPlugins)
			{
				this.comboBoxAvailable.Items.Add(new ComboBoxItem(type, this._facade.GetPluginName(type)));
			}
		}

		public void SelectPlugin(string type)
		{
			if (this.comboBoxAvailable.Items.Count > 0)
			{
				foreach (ComboBoxItem item in this.comboBoxAvailable.Items)
				{
					if (item.PluginType.ToString() == type)
					{
						this.comboBoxAvailable.SelectedItem = item;
						this.SetConfigControl(this._facade.GetConfigControl(item.PluginType));
						return;
					}
				}
				this.comboBoxAvailable.SelectedIndex = 0;
				this.SetConfigControl(this._facade.GetConfigControl(((ComboBoxItem)this.comboBoxAvailable.SelectedItem).PluginType));
			}
			else
			{
				this.comboBoxAvailable.Text = "No analyses available. Load and activate appropriate plugins...";
				this.groupBoxConfigure.Controls.Clear();
			}
		}

		public bool CanStart
		{
			set
			{
				this.buttonStart.Enabled = value;
			}
		}

		public void CanStartChanged(string type, bool canStart)
		{
			if (((ComboBoxItem)this.comboBoxAvailable.SelectedItem).PluginType == type)
				this.buttonStart.Enabled = canStart;
		}

		private void SetConfigControl(UserControl ctrl)
		{
			this.groupBoxConfigure.Controls.Clear();
			if (ctrl == null)
			{
				Label label = new Label();
				label.Text = "This analysis method provides no configuration dialog.";
				label.Dock = System.Windows.Forms.DockStyle.Fill;
				this.groupBoxConfigure.Controls.Add(label);
				return;
			}
			this.groupBoxConfigure.Controls.Add(ctrl);
			ctrl.Dock = System.Windows.Forms.DockStyle.Fill;
			ctrl.Location = new System.Drawing.Point(3, 16);
		}

		private void buttonClose_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void buttonStart_Click(object sender, System.EventArgs e)
		{
			ComboBoxItem item = this.comboBoxAvailable.SelectedItem as ComboBoxItem;
			if (item != null)
			{
				this._facade.FireAnalysisStartRequested(item.PluginType);
				this.Close();
			}
		}

		private class ComboBoxItem
		{
			private string _type;
			private string _name;

			public ComboBoxItem(string type, string name)
			{
				this._type = type;
				this._name = name;
			}

			public override string ToString()
			{
				return this._name+" ("+this._type+")";
			}

			public string PluginType
			{
				get { return this._type; }
			}

		}
	}
}

using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace Palladio.Editor.Common.EntityProxies.UITypeEditors.Dialogs
{
	/// <summary>
	/// Zusammenfassung für AttributeCollectionForm.
	/// </summary>
	public class AttributeCollectionForm : EntityProxyCollectionForm
	{
		private EntityProxy _proxy;
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.GroupBox groupBox2;
		private System.Windows.Forms.Button buttonAdd;
		private System.Windows.Forms.Button buttonRemove;
		private System.Windows.Forms.ListBox listBoxAdded;
		private System.Windows.Forms.ListBox listBoxAvailable;
		private System.Windows.Forms.Button buttonClose;

		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public AttributeCollectionForm(EntityProxy proxy)
		{
			this._proxy = proxy;

			//
			// Erforderlich für die Windows Form-Designerunterstützung
			//
			InitializeComponent();

			this.FillAvailableList();
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
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.listBoxAvailable = new System.Windows.Forms.ListBox();
			this.groupBox2 = new System.Windows.Forms.GroupBox();
			this.listBoxAdded = new System.Windows.Forms.ListBox();
			this.buttonAdd = new System.Windows.Forms.Button();
			this.buttonRemove = new System.Windows.Forms.Button();
			this.buttonClose = new System.Windows.Forms.Button();
			this.groupBox1.SuspendLayout();
			this.groupBox2.SuspendLayout();
			this.SuspendLayout();
			// 
			// groupBox1
			// 
			this.groupBox1.Controls.Add(this.listBoxAvailable);
			this.groupBox1.Location = new System.Drawing.Point(0, 0);
			this.groupBox1.Name = "groupBox1";
			this.groupBox1.Size = new System.Drawing.Size(152, 248);
			this.groupBox1.TabIndex = 0;
			this.groupBox1.TabStop = false;
			this.groupBox1.Text = "Available Attributes";
			// 
			// listBoxAvailable
			// 
			this.listBoxAvailable.Dock = System.Windows.Forms.DockStyle.Fill;
			this.listBoxAvailable.Location = new System.Drawing.Point(3, 16);
			this.listBoxAvailable.Name = "listBoxAvailable";
			this.listBoxAvailable.Size = new System.Drawing.Size(146, 225);
			this.listBoxAvailable.TabIndex = 0;
			// 
			// groupBox2
			// 
			this.groupBox2.Controls.Add(this.listBoxAdded);
			this.groupBox2.Location = new System.Drawing.Point(216, 0);
			this.groupBox2.Name = "groupBox2";
			this.groupBox2.Size = new System.Drawing.Size(152, 248);
			this.groupBox2.TabIndex = 1;
			this.groupBox2.TabStop = false;
			this.groupBox2.Text = "Attached Attributes";
			// 
			// listBoxAdded
			// 
			this.listBoxAdded.Dock = System.Windows.Forms.DockStyle.Fill;
			this.listBoxAdded.Location = new System.Drawing.Point(3, 16);
			this.listBoxAdded.Name = "listBoxAdded";
			this.listBoxAdded.Size = new System.Drawing.Size(146, 225);
			this.listBoxAdded.TabIndex = 0;
			// 
			// buttonAdd
			// 
			this.buttonAdd.Location = new System.Drawing.Point(160, 64);
			this.buttonAdd.Name = "buttonAdd";
			this.buttonAdd.Size = new System.Drawing.Size(48, 23);
			this.buttonAdd.TabIndex = 2;
			this.buttonAdd.Text = ">";
			this.buttonAdd.Click += new System.EventHandler(this.buttonAdd_Click);
			// 
			// buttonRemove
			// 
			this.buttonRemove.Location = new System.Drawing.Point(160, 112);
			this.buttonRemove.Name = "buttonRemove";
			this.buttonRemove.Size = new System.Drawing.Size(48, 23);
			this.buttonRemove.TabIndex = 3;
			this.buttonRemove.Text = "<";
			// 
			// buttonClose
			// 
			this.buttonClose.Location = new System.Drawing.Point(160, 216);
			this.buttonClose.Name = "buttonClose";
			this.buttonClose.Size = new System.Drawing.Size(48, 23);
			this.buttonClose.TabIndex = 4;
			this.buttonClose.Text = "Close";
			this.buttonClose.Click += new System.EventHandler(this.buttonClose_Click);
			// 
			// AttributeCollectionForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(368, 253);
			this.Controls.Add(this.buttonClose);
			this.Controls.Add(this.buttonRemove);
			this.Controls.Add(this.buttonAdd);
			this.Controls.Add(this.groupBox2);
			this.Controls.Add(this.groupBox1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "AttributeCollectionForm";
			this.ShowInTaskbar = false;
			this.Text = "AttributeCollectionForm";
			this.groupBox1.ResumeLayout(false);
			this.groupBox2.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void FillAvailableList()
		{
			this.listBoxAvailable.Items.Clear();
			foreach(AbstractAttributeType attrType in this._proxy.AvailableAttributes)
			{
				this.listBoxAvailable.Items.Add(attrType.DisplayName);
			}
		}

		private void FillAttachedList()
		{
			this.listBoxAdded.Items.Clear();
			foreach(AbstractAttributeType attrType in this._proxy.Attributes.Keys)
			{
				this.listBoxAdded.Items.Add(attrType.DisplayName);
			}
		}

		private void buttonAdd_Click(object sender, System.EventArgs e)
		{
			if (this.listBoxAvailable.SelectedIndex >= 0)
			{
				AbstractAttributeType attrType = this._proxy.AvailableAttributes[this.listBoxAvailable.SelectedIndex];
				this._proxy.AttachAttribute(attrType);
				this.FillAttachedList();
			}
		}

		private void buttonClose_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		public override EntityProxy Proxy
		{
			get
			{
				return this._proxy;
			}

			set
			{
				this._proxy = value as EntityProxy;
				this.FillAvailableList();
			}
		}
	}
}

using System;
using System.Collections;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Windows.Forms;

namespace Palladio.Editor.Plugins.AnalyzeTest.Presentation
{
	/// <summary>
	/// Zusammenfassung für Result.
	/// </summary>
	public class Result : System.Windows.Forms.UserControl
	{
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label label2;
		/// <summary> 
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public Result(string text, string result)
		{
			// Dieser Aufruf ist für den Windows Form-Designer erforderlich.
			InitializeComponent();

			this.label1.Text = text;
			this.label2.Text = result;

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
			this.label1 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.Dock = System.Windows.Forms.DockStyle.Fill;
			this.label1.Font = new System.Drawing.Font("Courier New", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label1.Location = new System.Drawing.Point(0, 0);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(216, 136);
			this.label1.TabIndex = 0;
			this.label1.Text = "label1";
			// 
			// label2
			// 
			this.label2.Dock = System.Windows.Forms.DockStyle.Bottom;
			this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label2.ForeColor = System.Drawing.Color.Navy;
			this.label2.Location = new System.Drawing.Point(0, 112);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(216, 24);
			this.label2.TabIndex = 1;
			this.label2.Text = "label2";
			// 
			// Result
			// 
			this.BackColor = System.Drawing.Color.White;
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.Name = "Result";
			this.Size = new System.Drawing.Size(216, 136);
			this.ResumeLayout(false);

		}
		#endregion

	}
}

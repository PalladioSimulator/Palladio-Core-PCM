//------------------------------------------------------------------------------
//
// Copyright (c) 2002-2004 Eric J. Smith.  All rights reserved.
// 
// The terms of use for this software are contained in the file
// named sourcelicense.txt, which can be found in the root of this distribution.
// By using this software in any fashion, you are agreeing to be bound by the
// terms of this license.
// 
// You must not remove this notice, or any other, from this software.
//
//------------------------------------------------------------------------------

using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Windows.Forms.Design;

namespace CodeSmith.CustomProperties
{
	public class StringCollectionEditorUI : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Button CancelDialogButton;
		private System.ComponentModel.Container components = null;
		private System.Windows.Forms.Button OKButton;
		private System.Windows.Forms.TextBox StringsTextBox;
		private StringCollection _currentStringCollection = null;
		
		public StringCollectionEditorUI()
		{
			InitializeComponent();
		}
		
		public void Start(IWindowsFormsEditorService editorService, object value)
		{
			if (value is StringCollection)
			{
				_currentStringCollection = (StringCollection)value;
				this.StringsTextBox.Lines = _currentStringCollection.ToArray();
			}
			else
			{
				_currentStringCollection = new StringCollection();
				this.StringsTextBox.Text = "";
			}
		}
		
		public void End()
		{
		}
		
		public StringCollection StringCollection
		{
			get
			{
				return _currentStringCollection;
			}
		}
		
		protected override void Dispose(bool disposing)
		{
			if (disposing)
			{
				if (components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose(disposing);
		}
		
		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.OKButton = new System.Windows.Forms.Button();
			this.CancelDialogButton = new System.Windows.Forms.Button();
			this.StringsTextBox = new System.Windows.Forms.TextBox();
			this.SuspendLayout();
			// 
			// OKButton
			// 
			this.OKButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.OKButton.DialogResult = System.Windows.Forms.DialogResult.OK;
			this.OKButton.Location = new System.Drawing.Point(178, 292);
			this.OKButton.Name = "OKButton";
			this.OKButton.TabIndex = 1;
			this.OKButton.Text = "OK";
			this.OKButton.Click += new System.EventHandler(this.OKButton_Click);
			// 
			// CancelDialogButton
			// 
			this.CancelDialogButton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.CancelDialogButton.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.CancelDialogButton.Location = new System.Drawing.Point(258, 292);
			this.CancelDialogButton.Name = "CancelDialogButton";
			this.CancelDialogButton.TabIndex = 2;
			this.CancelDialogButton.Text = "Cancel";
			// 
			// StringsTextBox
			// 
			this.StringsTextBox.Location = new System.Drawing.Point(8, 8);
			this.StringsTextBox.Multiline = true;
			this.StringsTextBox.Name = "StringsTextBox";
			this.StringsTextBox.Size = new System.Drawing.Size(328, 280);
			this.StringsTextBox.TabIndex = 3;
			this.StringsTextBox.Text = "";
			// 
			// StringCollectionEditorUI
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(342, 324);
			this.Controls.Add(this.StringsTextBox);
			this.Controls.Add(this.CancelDialogButton);
			this.Controls.Add(this.OKButton);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.SizableToolWindow;
			this.MinimumSize = new System.Drawing.Size(200, 200);
			this.Name = "StringCollectionEditorUI";
			this.ShowInTaskbar = false;
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
			this.Text = "String Collection Editor";
			this.ResumeLayout(false);

		}
		#endregion

		private void OKButton_Click(object sender, System.EventArgs e)
		{
			this.StringCollection.Clear();
			this.StringCollection.AddRange(StringsTextBox.Lines);
		}
	}
}

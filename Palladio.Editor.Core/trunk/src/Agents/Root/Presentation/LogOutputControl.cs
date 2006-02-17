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
using System.Data;
using System.Drawing;
using System.Collections;
using System.Windows.Forms;
using System.ComponentModel;
using log4net;

using Palladio.Editor.Common;

namespace Palladio.Editor.Core.Agents.Root.Presentation
{

	/// <summary>
	/// Zusammenfassung für LogOutputControl.
	/// </summary>
	internal class LogOutputControl : System.Windows.Forms.UserControl
	{

		private const int DEBUG = 1;
		private const int INFO  = 2;
		private const int WARN  = 4;
		private const int ERROR = 8;
		private const int FATAL = 16;

		private DataSetAppender appender;
		private System.Data.DataView dataView;
		private System.Windows.Forms.DataGrid dataGrid;
		private System.Windows.Forms.DataGridTextBoxColumn dataGridTextBoxColumnType;
		private System.Windows.Forms.DataGridTextBoxColumn dataGridTextBoxColumnTime;
		private System.Windows.Forms.DataGridTextBoxColumn dataGridTextBoxColumnDispatcher;
		private System.Windows.Forms.DataGridTextBoxColumn dataGridTextBoxColumnMessage;

		//private int levelMask = 0;
		private System.Windows.Forms.DataGridTableStyle tableStyle;

		/// <summary> 
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public LogOutputControl()
		{
			this.appender = new DataSetAppender();
			((log4net.Repository.Hierarchy.Hierarchy)log4net.LogManager.GetLoggerRepository()).Root.AddAppender(appender);

			this.appender.logMessageAppended += new LogMessageAppendedHandler(OnLogMessageAppended);

			this.dataView = new System.Data.DataView(this.appender.getTable());
			this.dataView.Sort = "ID DESC";

			//this.levelMask = DEBUG | INFO;

			// Dieser Aufruf ist für den Windows Form-Designer erforderlich.
			InitializeComponent();

			this.dataGrid.DataSource = this.dataView;

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
			this.dataGrid = new System.Windows.Forms.DataGrid();
			this.tableStyle = new System.Windows.Forms.DataGridTableStyle();
			this.dataGridTextBoxColumnType = new System.Windows.Forms.DataGridTextBoxColumn();
			this.dataGridTextBoxColumnTime = new System.Windows.Forms.DataGridTextBoxColumn();
			this.dataGridTextBoxColumnDispatcher = new System.Windows.Forms.DataGridTextBoxColumn();
			this.dataGridTextBoxColumnMessage = new System.Windows.Forms.DataGridTextBoxColumn();
			((System.ComponentModel.ISupportInitialize)(this.dataGrid)).BeginInit();
			this.SuspendLayout();
			// 
			// dataGrid
			// 
			this.dataGrid.AllowSorting = false;
			this.dataGrid.BackgroundColor = System.Drawing.Color.White;
			this.dataGrid.CaptionVisible = false;
			this.dataGrid.DataMember = "";
			this.dataGrid.Dock = System.Windows.Forms.DockStyle.Fill;
			this.dataGrid.HeaderForeColor = System.Drawing.SystemColors.ControlText;
			this.dataGrid.Location = new System.Drawing.Point(0, 0);
			this.dataGrid.Name = "dataGrid";
			this.dataGrid.ReadOnly = true;
			this.dataGrid.RowHeadersVisible = false;
			this.dataGrid.Size = new System.Drawing.Size(560, 184);
			this.dataGrid.TabIndex = 0;
			this.dataGrid.TableStyles.AddRange(new System.Windows.Forms.DataGridTableStyle[] {
																								 this.tableStyle});
			// 
			// tableStyle
			// 
			this.tableStyle.AllowSorting = false;
			this.tableStyle.AlternatingBackColor = System.Drawing.Color.WhiteSmoke;
			this.tableStyle.BackColor = System.Drawing.Color.White;
			this.tableStyle.DataGrid = this.dataGrid;
			this.tableStyle.GridColumnStyles.AddRange(new System.Windows.Forms.DataGridColumnStyle[] {
																										 this.dataGridTextBoxColumnType,
																										 this.dataGridTextBoxColumnTime,
																										 this.dataGridTextBoxColumnDispatcher,
																										 this.dataGridTextBoxColumnMessage});
			this.tableStyle.GridLineColor = System.Drawing.SystemColors.ControlLight;
			this.tableStyle.HeaderForeColor = System.Drawing.SystemColors.ControlText;
			this.tableStyle.MappingName = "Log";
			this.tableStyle.ReadOnly = true;
			this.tableStyle.RowHeadersVisible = false;
			// 
			// dataGridTextBoxColumnType
			// 
			this.dataGridTextBoxColumnType.Format = "";
			this.dataGridTextBoxColumnType.FormatInfo = null;
			this.dataGridTextBoxColumnType.HeaderText = "Level";
			this.dataGridTextBoxColumnType.MappingName = "Level";
			this.dataGridTextBoxColumnType.ReadOnly = true;
			this.dataGridTextBoxColumnType.Width = 55;
			// 
			// dataGridTextBoxColumnTime
			// 
			this.dataGridTextBoxColumnTime.Format = "";
			this.dataGridTextBoxColumnTime.FormatInfo = null;
			this.dataGridTextBoxColumnTime.HeaderText = "Time";
			this.dataGridTextBoxColumnTime.MappingName = "Time";
			this.dataGridTextBoxColumnTime.ReadOnly = true;
			this.dataGridTextBoxColumnTime.Width = 65;
			// 
			// dataGridTextBoxColumnDispatcher
			// 
			this.dataGridTextBoxColumnDispatcher.Format = "";
			this.dataGridTextBoxColumnDispatcher.FormatInfo = null;
			this.dataGridTextBoxColumnDispatcher.HeaderText = "Logger";
			this.dataGridTextBoxColumnDispatcher.MappingName = "Logger";
			this.dataGridTextBoxColumnDispatcher.Width = 260;
			// 
			// dataGridTextBoxColumnMessage
			// 
			this.dataGridTextBoxColumnMessage.Format = "";
			this.dataGridTextBoxColumnMessage.FormatInfo = null;
			this.dataGridTextBoxColumnMessage.HeaderText = "Message";
			this.dataGridTextBoxColumnMessage.MappingName = "Message";
			this.dataGridTextBoxColumnMessage.ReadOnly = true;
			this.dataGridTextBoxColumnMessage.Width = 2800;
			// 
			// LogOutputControl
			// 
			this.AutoScroll = true;
			this.Controls.Add(this.dataGrid);
			this.Name = "LogOutputControl";
			this.Size = new System.Drawing.Size(560, 184);
			((System.ComponentModel.ISupportInitialize)(this.dataGrid)).EndInit();
			this.ResumeLayout(false);

		}
		#endregion


		private void OnLogMessageAppended(object sender, string level) 
		{
			//			if (level.Equals("DEBUG") && (this.levelMask & DEBUG) != 0)
			//			this.dataGrid.DataSource = ((DataSetAppender)sender).getFilteredRows();
		}
	}
}

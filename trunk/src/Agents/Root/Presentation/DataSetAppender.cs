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

using Palladio.Editor.Common;

using log4net.Appender;
using log4net.spi;

namespace Palladio.Editor.Core.Agents.Root.Presentation
{
	/// <summary>
	/// Zusammenfassung für DataSetAppender.
	/// </summary>
	public class DataSetAppender : AppenderSkeleton
	{

		private System.Data.DataTable dataTable;
		private System.Data.DataColumn dataColumnID;
		private System.Data.DataColumn dataColumnTime;
		private System.Data.DataColumn dataColumnDispatcher;
		private System.Data.DataColumn dataColumnMessage;
		private System.Data.DataColumn dataColumnLevel;

		public event LogMessageAppendedHandler logMessageAppended;

		public DataSetAppender()
		{
			this.dataTable = new System.Data.DataTable();
			this.dataColumnID = new System.Data.DataColumn();
			this.dataColumnLevel = new System.Data.DataColumn();
			this.dataColumnTime = new System.Data.DataColumn();
			this.dataColumnDispatcher = new System.Data.DataColumn();
			this.dataColumnMessage = new System.Data.DataColumn();
			((System.ComponentModel.ISupportInitialize)(this.dataTable)).BeginInit();

			this.dataTable.TableName = "Log";
			this.dataTable.Columns.AddRange(new System.Data.DataColumn[] {
																			 this.dataColumnID,
																			 this.dataColumnLevel,
																			 this.dataColumnTime,
																			 this.dataColumnDispatcher,
																			 this.dataColumnMessage});

			// 
			// dataColumnID
			// 
			this.dataColumnID.Caption = "ID";
			this.dataColumnID.ColumnName = "ID";
			this.dataColumnID.AutoIncrement = true;
			// 
			// dataColumnType
			// 
			this.dataColumnLevel.Caption = "Level";
			this.dataColumnLevel.ColumnName = "Level";
			// 
			// dataColumnTime
			// 
			this.dataColumnTime.Caption = "Time";
			this.dataColumnTime.ColumnName = "Time";
			//this.dataColumnLevel.DataType = typeof(System.DateTime);
			// 
			// dataColumnDispatcher
			// 
			this.dataColumnDispatcher.Caption = "Logger";
			this.dataColumnDispatcher.ColumnName = "Logger";
			// 
			// dataColumnMessage
			// 
			this.dataColumnMessage.Caption = "Message";
			this.dataColumnMessage.ColumnName = "Message";

			((System.ComponentModel.ISupportInitialize)(this.dataTable)).EndInit();
		}
	
		/// <summary>
		/// 
		/// </summary>
		/// <param name="loggingEvent"></param>
		override protected void Append(LoggingEvent loggingEvent) 
		{
			this.dataTable.Rows.Add(new object[]{	null,
													loggingEvent.Level.ToString(),
													loggingEvent.TimeStamp.ToLongTimeString(),
													loggingEvent.LoggerName,
													loggingEvent.MessageObject.ToString() });
			if (this.logMessageAppended != null)
				this.logMessageAppended(this, loggingEvent.Level.ToString());
		}

		public System.Data.DataTable getTable() { return this.dataTable; }

		/// <summary>
		/// 
		/// </summary>
		/// <returns></returns>
		public System.Data.DataTable getDebugLog()
		{
			System.Data.DataTable table = this.dataTable.Clone();
			foreach(System.Data.DataRow row in this.dataTable.Select("Level = '"+Level.DEBUG.ToString()+"'"))
			{
				table.Rows.Add(new object[]{row[0],row[1],row[2],row[3]});
			}
			return table;
		}
	}
}

using System;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Drawing;
using System.Reflection;
using System.Windows.Forms;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.RequestParser;
using Palladio.WebserverAnalyser.Interceptor;
using Palldio.Interceptor.Data;

namespace Palladio.Interceptor
{
	/// <summary>
	/// Zusammenfassung für Form1.
	/// </summary>
	public class WebserverAnalyserForm : Form
	{
		private System.Windows.Forms.Button run_button;
		private System.Windows.Forms.Panel panel1;
		private DBLogger dbLogger;
		private System.Data.SqlClient.SqlConnection sqlConnection;
		private System.Data.SqlClient.SqlDataAdapter sqlCallTableAdapter;
		private Palldio.Interceptor.Data.ResultDataSet results;
		private System.Windows.Forms.Button analyse_button;

		private long startTime;
		private long runID;
		private System.Data.SqlClient.SqlCommand sqlSelectCommand1;
		private System.Data.SqlClient.SqlCommand sqlInsertCommand4;
		private System.Data.SqlClient.SqlCommand sqlUpdateCommand4;
		private System.Data.SqlClient.SqlCommand sqlDeleteCommand4;

		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private Container components = null;

		public WebserverAnalyserForm()
		{
			//
			// Erforderlich für die Windows Form-Designerunterstützung
			//
			InitializeComponent();

			panel1.BackColor = Color.Green;

			sqlCallTableAdapter.Fill(results);

			try
			{
				sqlConnection.Open();
				startTime = DateTime.Now.Ticks;
				SqlCommand cmd = new SqlCommand();
				cmd.Connection = sqlConnection;
				cmd.CommandText = "INSERT INTO RunTable VALUES ("+startTime+", 0)";
				cmd.ExecuteNonQuery();

				cmd.CommandText = "SELECT ID FROM RunTable WHERE (StartTime = " + startTime + ") AND (StopTime = 0)";
				SqlDataReader reader = cmd.ExecuteReader();

				if (reader.Read())
				{
					runID = reader.GetInt64(0);
				}
				else
					throw new ApplicationException("RunEntry could not be retrieved from the database!");
			}
			finally
			{
				sqlConnection.Close();
			}

			dbLogger = new DBLogger(results, runID);

			InterceptorActions.BeforeCall += new BeforeCallDelegate(dbLogger.OnCall);
			InterceptorActions.AfterCall += new AfterCallDelegate(dbLogger.OnReturn);


			//
			// TODO: Fügen Sie den Konstruktorcode nach dem Aufruf von InitializeComponent hinzu
			//
		}

		/// <summary>
		/// Die verwendeten Ressourcen bereinigen.
		/// </summary>
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

		#region Vom Windows Form-Designer generierter Code

		/// <summary>
		/// Erforderliche Methode für die Designerunterstützung. 
		/// Der Inhalt der Methode darf nicht mit dem Code-Editor geändert werden.
		/// </summary>
		private void InitializeComponent()
		{
			System.Configuration.AppSettingsReader configurationAppSettings = new System.Configuration.AppSettingsReader();
			this.run_button = new System.Windows.Forms.Button();
			this.panel1 = new System.Windows.Forms.Panel();
			this.sqlConnection = new System.Data.SqlClient.SqlConnection();
			this.sqlCallTableAdapter = new System.Data.SqlClient.SqlDataAdapter();
			this.sqlDeleteCommand4 = new System.Data.SqlClient.SqlCommand();
			this.sqlInsertCommand4 = new System.Data.SqlClient.SqlCommand();
			this.sqlSelectCommand1 = new System.Data.SqlClient.SqlCommand();
			this.sqlUpdateCommand4 = new System.Data.SqlClient.SqlCommand();
			this.results = new Palldio.Interceptor.Data.ResultDataSet();
			this.analyse_button = new System.Windows.Forms.Button();
			((System.ComponentModel.ISupportInitialize)(this.results)).BeginInit();
			this.SuspendLayout();
			// 
			// run_button
			// 
			this.run_button.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.run_button.Location = new System.Drawing.Point(368, 144);
			this.run_button.Name = "run_button";
			this.run_button.Size = new System.Drawing.Size(80, 32);
			this.run_button.TabIndex = 0;
			this.run_button.Text = "Run";
			this.run_button.Click += new System.EventHandler(this.run_button_Click);
			// 
			// panel1
			// 
			this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panel1.Location = new System.Drawing.Point(8, 8);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(440, 32);
			this.panel1.TabIndex = 1;
			// 
			// sqlConnection
			// 
			this.sqlConnection.ConnectionString = ((string)(configurationAppSettings.GetValue("sqlConnection.ConnectionString", typeof(string))));
			this.sqlConnection.InfoMessage += new System.Data.SqlClient.SqlInfoMessageEventHandler(this.sqlConnection1_InfoMessage);
			// 
			// sqlCallTableAdapter
			// 
			this.sqlCallTableAdapter.DeleteCommand = this.sqlDeleteCommand4;
			this.sqlCallTableAdapter.InsertCommand = this.sqlInsertCommand4;
			this.sqlCallTableAdapter.SelectCommand = this.sqlSelectCommand1;
			this.sqlCallTableAdapter.TableMappings.AddRange(new System.Data.Common.DataTableMapping[] {
																																																	new System.Data.Common.DataTableMapping("Table", "CallTable", new System.Data.Common.DataColumnMapping[] {
																																																																																																						 new System.Data.Common.DataColumnMapping("ID", "ID"),
																																																																																																						 new System.Data.Common.DataColumnMapping("CallNumber", "CallNumber"),
																																																																																																						 new System.Data.Common.DataColumnMapping("CallLevel", "CallLevel"),
																																																																																																						 new System.Data.Common.DataColumnMapping("CallerID", "CallerID"),
																																																																																																						 new System.Data.Common.DataColumnMapping("ClassName", "ClassName"),
																																																																																																						 new System.Data.Common.DataColumnMapping("MethodName", "MethodName"),
																																																																																																						 new System.Data.Common.DataColumnMapping("CallTime", "CallTime"),
																																																																																																						 new System.Data.Common.DataColumnMapping("ReturnTime", "ReturnTime"),
																																																																																																						 new System.Data.Common.DataColumnMapping("RunID", "RunID"),
																																																																																																						 new System.Data.Common.DataColumnMapping("ThreadID", "ThreadID")})});
			this.sqlCallTableAdapter.UpdateCommand = this.sqlUpdateCommand4;
			this.sqlCallTableAdapter.RowUpdated += new System.Data.SqlClient.SqlRowUpdatedEventHandler(this.sqlCallTableAdapter_RowUpdated);
			// 
			// sqlDeleteCommand4
			// 
			this.sqlDeleteCommand4.CommandText = @"DELETE FROM CallTable WHERE (ID = @Original_ID) AND (CallLevel = @Original_CallLevel) AND (CallNumber = @Original_CallNumber) AND (CallTime = @Original_CallTime) AND (CallerID = @Original_CallerID) AND (ClassName = @Original_ClassName) AND (MethodName = @Original_MethodName) AND (ReturnTime = @Original_ReturnTime) AND (RunID = @Original_RunID) AND (ThreadID = @Original_ThreadID)";
			this.sqlDeleteCommand4.Connection = this.sqlConnection;
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ID", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ID", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_CallLevel", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "CallLevel", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_CallNumber", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "CallNumber", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_CallTime", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "CallTime", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_CallerID", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "CallerID", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ClassName", System.Data.SqlDbType.VarChar, 256, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ClassName", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_MethodName", System.Data.SqlDbType.VarChar, 256, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "MethodName", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ReturnTime", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ReturnTime", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_RunID", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "RunID", System.Data.DataRowVersion.Original, null));
			this.sqlDeleteCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ThreadID", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ThreadID", System.Data.DataRowVersion.Original, null));
			// 
			// sqlInsertCommand4
			// 
			this.sqlInsertCommand4.CommandText = @"INSERT INTO CallTable(CallNumber, CallLevel, CallerID, ClassName, MethodName, CallTime, ReturnTime, RunID, ThreadID) VALUES (@CallNumber, @CallLevel, @CallerID, @ClassName, @MethodName, @CallTime, @ReturnTime, @RunID, @ThreadID); SELECT ID, CallNumber, CallLevel, CallerID, ClassName, MethodName, CallTime, ReturnTime, RunID, ThreadID FROM CallTable WHERE (ID = @@IDENTITY)";
			this.sqlInsertCommand4.Connection = this.sqlConnection;
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CallNumber", System.Data.SqlDbType.BigInt, 8, "CallNumber"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CallLevel", System.Data.SqlDbType.BigInt, 8, "CallLevel"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CallerID", System.Data.SqlDbType.BigInt, 8, "CallerID"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ClassName", System.Data.SqlDbType.VarChar, 256, "ClassName"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@MethodName", System.Data.SqlDbType.VarChar, 256, "MethodName"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CallTime", System.Data.SqlDbType.BigInt, 8, "CallTime"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ReturnTime", System.Data.SqlDbType.BigInt, 8, "ReturnTime"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@RunID", System.Data.SqlDbType.BigInt, 8, "RunID"));
			this.sqlInsertCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ThreadID", System.Data.SqlDbType.BigInt, 8, "ThreadID"));
			// 
			// sqlSelectCommand1
			// 
			this.sqlSelectCommand1.CommandText = "SELECT ID, CallNumber, CallLevel, CallerID, ClassName, MethodName, CallTime, Retu" +
				"rnTime, RunID, ThreadID FROM CallTable";
			this.sqlSelectCommand1.Connection = this.sqlConnection;
			// 
			// sqlUpdateCommand4
			// 
			this.sqlUpdateCommand4.CommandText = @"UPDATE CallTable SET CallNumber = @CallNumber, CallLevel = @CallLevel, CallerID = @CallerID, ClassName = @ClassName, MethodName = @MethodName, CallTime = @CallTime, ReturnTime = @ReturnTime, RunID = @RunID, ThreadID = @ThreadID WHERE (ID = @Original_ID) AND (CallLevel = @Original_CallLevel) AND (CallNumber = @Original_CallNumber) AND (CallTime = @Original_CallTime) AND (CallerID = @Original_CallerID) AND (ClassName = @Original_ClassName) AND (MethodName = @Original_MethodName) AND (ReturnTime = @Original_ReturnTime) AND (RunID = @Original_RunID) AND (ThreadID = @Original_ThreadID); SELECT ID, CallNumber, CallLevel, CallerID, ClassName, MethodName, CallTime, ReturnTime, RunID, ThreadID FROM CallTable WHERE (ID = @ID)";
			this.sqlUpdateCommand4.Connection = this.sqlConnection;
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CallNumber", System.Data.SqlDbType.BigInt, 8, "CallNumber"));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CallLevel", System.Data.SqlDbType.BigInt, 8, "CallLevel"));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CallerID", System.Data.SqlDbType.BigInt, 8, "CallerID"));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ClassName", System.Data.SqlDbType.VarChar, 256, "ClassName"));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@MethodName", System.Data.SqlDbType.VarChar, 256, "MethodName"));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@CallTime", System.Data.SqlDbType.BigInt, 8, "CallTime"));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ReturnTime", System.Data.SqlDbType.BigInt, 8, "ReturnTime"));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@RunID", System.Data.SqlDbType.BigInt, 8, "RunID"));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ThreadID", System.Data.SqlDbType.BigInt, 8, "ThreadID"));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ID", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ID", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_CallLevel", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "CallLevel", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_CallNumber", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "CallNumber", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_CallTime", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "CallTime", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_CallerID", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "CallerID", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ClassName", System.Data.SqlDbType.VarChar, 256, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ClassName", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_MethodName", System.Data.SqlDbType.VarChar, 256, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "MethodName", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ReturnTime", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ReturnTime", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_RunID", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "RunID", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@Original_ThreadID", System.Data.SqlDbType.BigInt, 8, System.Data.ParameterDirection.Input, false, ((System.Byte)(0)), ((System.Byte)(0)), "ThreadID", System.Data.DataRowVersion.Original, null));
			this.sqlUpdateCommand4.Parameters.Add(new System.Data.SqlClient.SqlParameter("@ID", System.Data.SqlDbType.BigInt, 8, "ID"));
			// 
			// results
			// 
			this.results.DataSetName = "InterceptorResults";
			this.results.Locale = new System.Globalization.CultureInfo("en-US");
			// 
			// analyse_button
			// 
			this.analyse_button.Location = new System.Drawing.Point(272, 144);
			this.analyse_button.Name = "analyse_button";
			this.analyse_button.Size = new System.Drawing.Size(88, 32);
			this.analyse_button.TabIndex = 3;
			this.analyse_button.Text = "Analyse";
			this.analyse_button.Click += new System.EventHandler(this.analyse_button_Click);
			// 
			// WebserverAnalyserForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(6, 15);
			this.ClientSize = new System.Drawing.Size(456, 184);
			this.Controls.Add(this.analyse_button);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.run_button);
			this.Name = "WebserverAnalyserForm";
			this.Text = "Webserver Analyser";
			this.Closing += new System.ComponentModel.CancelEventHandler(this.InterceptorForm_Closing);
			this.Load += new System.EventHandler(this.Interceptor_Load);
			((System.ComponentModel.ISupportInitialize)(this.results)).EndInit();
			this.ResumeLayout(false);

		}

		#endregion

		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		private static void Main()
		{
			Application.Run(new WebserverAnalyserForm());
		}

		private void Interceptor_Load(object sender, EventArgs e)
		{
		}

		private void run_button_Click(object sender, System.EventArgs e)
		{
//			panel1.BackColor = Color.Red;
//			panel1.Refresh();
//			IHTTPRequestProcessor processor = new HttpRequestProcessor();
//			IHTTPRequestProcessor processorInterceptor = new HTTPRequestProcessorInterceptor(processor);
//			IRequestParser parser = new RequestParser(processorInterceptor);
//			IRequestParser parserInterceptor = new RequestParserInterceptor(parser);
//			parserInterceptor.HandleRequest(null);
//			panel1.BackColor = Color.Green;
//			panel1.Refresh();
		}

		private void InterceptorForm_Closing(object sender, System.ComponentModel.CancelEventArgs e)
		{
			try
			{
				sqlConnection.Open();
				long stopTime = DateTime.Now.Ticks;
				SqlCommand cmd = new SqlCommand();
				cmd.Connection = sqlConnection;
				cmd.CommandText = "UPDATE RunTable SET StopTime =" + stopTime +" WHERE ID ="+runID;
				cmd.ExecuteNonQuery();
			}
			finally
			{
				sqlConnection.Close();	
			}
			sqlCallTableAdapter.Update(results);
		}

		private void sqlConnection1_InfoMessage(object sender, System.Data.SqlClient.SqlInfoMessageEventArgs e)
		{
		
		}

		private void sqlDataAdapter1_RowUpdated(object sender, System.Data.SqlClient.SqlRowUpdatedEventArgs e)
		{
		
		}

		private void sqlDataAdapterCallTable_RowUpdated(object sender, System.Data.SqlClient.SqlRowUpdatedEventArgs e)
		{
		
		}

		private void analyse_button_Click(object sender, System.EventArgs e)
		{
			try
			{
				sqlConnection.Open();
				{
					DBAnalyser analyser = new DBAnalyser(sqlConnection);
					analyser.Analyse();
				}
			}
			finally
			{
				sqlConnection.Close();
			}
		}

		private void sqlCallTableAdapter_RowUpdated(object sender, System.Data.SqlClient.SqlRowUpdatedEventArgs e)
		{
		
		}
	}
}
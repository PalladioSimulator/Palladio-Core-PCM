using System;
using System.Drawing;
using System.Collections;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.IO;
using FirebirdSql.Data.Firebird;
using ZedGraph;

namespace ILBenchmark.AnalyseTool
{
	/// <summary>
	/// Zusammenfassung für Form1.
	/// </summary>
	public class frmHaupt : System.Windows.Forms.Form
	{
		private System.Windows.Forms.StatusBar statusBar1;
		private System.Windows.Forms.MainMenu mainMenu1;
		private System.Windows.Forms.MenuItem menuItem1;
		private System.Windows.Forms.MenuItem menuItem2;
		private System.Windows.Forms.MenuItem menuItem4;
		private ZedGraph.ZedGraphControl graph;
		private System.Windows.Forms.Button cmdAktualisieren;
		private System.Windows.Forms.MenuItem menuItem5;
		private System.Windows.Forms.MenuItem menuItem7;
		private System.Windows.Forms.MenuItem menuItem8;
		private System.Windows.Forms.MenuItem menuItem9;
		private System.Windows.Forms.OpenFileDialog dlgOpen;
		private System.Windows.Forms.MenuItem mnuExit;
		private System.Windows.Forms.MenuItem mnuInfo;
		private System.Windows.Forms.MenuItem mnuClustering;
		private System.Windows.Forms.DataGrid grdKlassen;
		private System.Windows.Forms.DataGrid grdPlatform;

		private FbConnection fbConn;
		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public frmHaupt()
		{
			//
			// Erforderlich für die Windows Form-Designerunterstützung
			//
			InitializeComponent();

			fbConn = new FbConnection("User=USER;Password=geheim;Database=" + Application.StartupPath + @"\DATEN.FDB;DataSource=;Port=3050;Dialect=3;Charset=NONE;Role=;Connection lifetime=0;Connection timeout=15;Pooling=True;Packet Size=8192;ServerType=1");

		}

		/// <summary>
		/// Die verwendeten Ressourcen bereinigen.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if (components != null) 
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
			this.grdKlassen = new System.Windows.Forms.DataGrid();
			this.statusBar1 = new System.Windows.Forms.StatusBar();
			this.mainMenu1 = new System.Windows.Forms.MainMenu();
			this.menuItem1 = new System.Windows.Forms.MenuItem();
			this.menuItem4 = new System.Windows.Forms.MenuItem();
			this.menuItem5 = new System.Windows.Forms.MenuItem();
			this.mnuExit = new System.Windows.Forms.MenuItem();
			this.menuItem7 = new System.Windows.Forms.MenuItem();
			this.menuItem8 = new System.Windows.Forms.MenuItem();
			this.menuItem9 = new System.Windows.Forms.MenuItem();
			this.mnuClustering = new System.Windows.Forms.MenuItem();
			this.menuItem2 = new System.Windows.Forms.MenuItem();
			this.mnuInfo = new System.Windows.Forms.MenuItem();
			this.graph = new ZedGraph.ZedGraphControl();
			this.cmdAktualisieren = new System.Windows.Forms.Button();
			this.dlgOpen = new System.Windows.Forms.OpenFileDialog();
			this.grdPlatform = new System.Windows.Forms.DataGrid();
			((System.ComponentModel.ISupportInitialize)(this.grdKlassen)).BeginInit();
			((System.ComponentModel.ISupportInitialize)(this.grdPlatform)).BeginInit();
			this.SuspendLayout();
			// 
			// grdKlassen
			// 
			this.grdKlassen.CaptionText = "Code Klassen";
			this.grdKlassen.DataMember = "";
			this.grdKlassen.HeaderForeColor = System.Drawing.SystemColors.ControlText;
			this.grdKlassen.Location = new System.Drawing.Point(8, 8);
			this.grdKlassen.Name = "grdKlassen";
			this.grdKlassen.Size = new System.Drawing.Size(296, 152);
			this.grdKlassen.TabIndex = 0;
			// 
			// statusBar1
			// 
			this.statusBar1.Location = new System.Drawing.Point(0, 513);
			this.statusBar1.Name = "statusBar1";
			this.statusBar1.Size = new System.Drawing.Size(616, 16);
			this.statusBar1.TabIndex = 1;
			this.statusBar1.Text = "Bereit";
			// 
			// mainMenu1
			// 
			this.mainMenu1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																					  this.menuItem1,
																					  this.menuItem7,
																					  this.menuItem2});
			// 
			// menuItem1
			// 
			this.menuItem1.Index = 0;
			this.menuItem1.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																					  this.menuItem4,
																					  this.menuItem5,
																					  this.mnuExit});
			this.menuItem1.Text = "Datei";
			// 
			// menuItem4
			// 
			this.menuItem4.Index = 0;
			this.menuItem4.Text = "Datenübersicht";
			this.menuItem4.Click += new System.EventHandler(this.menuItem4_Click);
			// 
			// menuItem5
			// 
			this.menuItem5.Index = 1;
			this.menuItem5.Text = "-";
			// 
			// mnuExit
			// 
			this.mnuExit.Index = 2;
			this.mnuExit.Text = "Beenden";
			this.mnuExit.Click += new System.EventHandler(this.mnuExit_Click);
			// 
			// menuItem7
			// 
			this.menuItem7.Index = 1;
			this.menuItem7.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																					  this.menuItem8,
																					  this.menuItem9,
																					  this.mnuClustering});
			this.menuItem7.Text = "Daten";
			// 
			// menuItem8
			// 
			this.menuItem8.Index = 0;
			this.menuItem8.Text = "Ergebnisse einlesen";
			this.menuItem8.Click += new System.EventHandler(this.menuItem8_Click);
			// 
			// menuItem9
			// 
			this.menuItem9.Index = 1;
			this.menuItem9.Text = "-";
			// 
			// mnuClustering
			// 
			this.mnuClustering.Index = 2;
			this.mnuClustering.Text = "Clustering...";
			this.mnuClustering.Click += new System.EventHandler(this.mnuClustering_Click);
			// 
			// menuItem2
			// 
			this.menuItem2.Index = 2;
			this.menuItem2.MenuItems.AddRange(new System.Windows.Forms.MenuItem[] {
																					  this.mnuInfo});
			this.menuItem2.Text = "Hilfe";
			// 
			// mnuInfo
			// 
			this.mnuInfo.Index = 0;
			this.mnuInfo.Text = "Info";
			this.mnuInfo.Click += new System.EventHandler(this.mnuInfo_Click);
			// 
			// graph
			// 
			this.graph.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.graph.IsEnablePan = true;
			this.graph.IsEnableZoom = true;
			this.graph.IsShowContextMenu = true;
			this.graph.IsShowPointValues = false;
			this.graph.Location = new System.Drawing.Point(8, 168);
			this.graph.Name = "graph";
			this.graph.PointDateFormat = "g";
			this.graph.PointValueFormat = "G";
			this.graph.Size = new System.Drawing.Size(600, 312);
			this.graph.TabIndex = 2;
			// 
			// cmdAktualisieren
			// 
			this.cmdAktualisieren.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.cmdAktualisieren.Location = new System.Drawing.Point(528, 488);
			this.cmdAktualisieren.Name = "cmdAktualisieren";
			this.cmdAktualisieren.Size = new System.Drawing.Size(80, 24);
			this.cmdAktualisieren.TabIndex = 3;
			this.cmdAktualisieren.Text = "Aktualisieren";
			this.cmdAktualisieren.Click += new System.EventHandler(this.cmdAktualisieren_Click);
			// 
			// dlgOpen
			// 
			this.dlgOpen.DefaultExt = "*.txt";
			this.dlgOpen.Filter = "Result Dateien|*.txt";
			this.dlgOpen.Title = "Result Datei auswählen";
			// 
			// grdPlatform
			// 
			this.grdPlatform.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.grdPlatform.CaptionText = "Plattformen";
			this.grdPlatform.DataMember = "";
			this.grdPlatform.HeaderForeColor = System.Drawing.SystemColors.ControlText;
			this.grdPlatform.Location = new System.Drawing.Point(312, 8);
			this.grdPlatform.Name = "grdPlatform";
			this.grdPlatform.Size = new System.Drawing.Size(296, 152);
			this.grdPlatform.TabIndex = 4;
			// 
			// frmHaupt
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(616, 529);
			this.Controls.Add(this.grdPlatform);
			this.Controls.Add(this.cmdAktualisieren);
			this.Controls.Add(this.graph);
			this.Controls.Add(this.statusBar1);
			this.Controls.Add(this.grdKlassen);
			this.Menu = this.mainMenu1;
			this.Name = "frmHaupt";
			this.Text = "IL Benchmark Analyse Werkzeug";
			this.Load += new System.EventHandler(this.frmHaupt_Load);
			this.Paint += new System.Windows.Forms.PaintEventHandler(this.frmHaupt_Paint);
			((System.ComponentModel.ISupportInitialize)(this.grdKlassen)).EndInit();
			((System.ComponentModel.ISupportInitialize)(this.grdPlatform)).EndInit();
			this.ResumeLayout(false);

		}
		#endregion

		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new frmHaupt());
		}

		private void menuItem4_Click(object sender, System.EventArgs e)
		{
			frmDaten fDaten = new frmDaten();
			fDaten.Show();
		}

		private void menuItem8_Click(object sender, System.EventArgs e)
		{
			if (dlgOpen.ShowDialog() == DialogResult.OK)
			{
				Cursor.Current = Cursors.WaitCursor;
				LoadResultsFile (dlgOpen.FileName);
			}
		}

		private void LoadResultsFile(string Filename)
		{
			string strZeile;
			string[] splitZeile;
			int section = 0;
			NameValueCollection colCount = new NameValueCollection(2);
			NameValueCollection colSys = new NameValueCollection(8);
			ArrayList colResult = new ArrayList();


			using (StreamReader sr = new StreamReader(Filename)) 
			{
				while (sr.Peek() >= 0) 
				{
					strZeile = sr.ReadLine();
					if (strZeile != null && strZeile != "")
					{
						splitZeile = strZeile.Split(new Char[1] {Char.Parse("\t")});
						if (strZeile.IndexOf("[Count]") >=0)
							section = 1;						
						if (strZeile.IndexOf("[System]") >=0)
							section = 2;
						if (strZeile.IndexOf("[Results]") >=0)
							section = 3;
						if (strZeile.IndexOf("[Parameter]") >=0)
							section = 4;
						if (strZeile.IndexOf("[Errors]") >=0)
							section = 5;

						if (splitZeile.Length>1)
						{
							switch (section)
							{
								case 0:
									break;
								case 1:
									colCount.Add(splitZeile[0],splitZeile[1]);
									break;
								case 2:
									colSys.Add(splitZeile[0],splitZeile[1]);
									break;
								case 3:
									colResult.Add(strZeile);
									break;
								case 4:
									break;
								case 5:
									break;
							}
						}
					}
				}
			}
			string SysID = ReadSysInfo(colSys);
			int CountID = ReadCount(colCount);
			ReadResult (colResult,CountID,SysID);
			Cursor.Current = Cursors.Default;
			MessageBox.Show("Die Datei '" + Filename + "' wurde erfolgreich eingelesen.","Erfolg",MessageBoxButtons.OK,MessageBoxIcon.Information);
			
		}
		private void ReadResult(ArrayList col, int CountID, string SysID)
		{
			string BenchID;
			string[] splitZeile;
			FbDataAdapter da = new FbDataAdapter("Select * from RESULTS",fbConn);
			FbDataAdapter da2 = new FbDataAdapter("Select * from Benchmark",fbConn);
			DataSet ds = new DataSet();			
			
			if (fbConn.State == ConnectionState.Closed)		
				fbConn.Open();
			da2.Fill(ds,"Benchmark");
			FbCommandBuilder cmd2 = new FbCommandBuilder(da2);
			
			da.Fill(ds,"Results");
			ds.Tables["Results"].Columns["ID"].AutoIncrement=true;
			object o = new FbCommand("Select Max(ID) + 1 from Results",fbConn).ExecuteScalar();
			if (!o.Equals(System.DBNull.Value))
				ds.Tables["Results"].Columns["ID"].AutoIncrementSeed = (long)o;
			FbCommandBuilder cmd = new FbCommandBuilder(da);

			char[] trenn = new Char[1] {Char.Parse("\t")};

			for (int i=0;i<col.Count;i++)
			{
				splitZeile = col[i].ToString().Split(trenn);
				DataRow[] drBench = ds.Tables["Benchmark"].Select("ID='" + splitZeile[0] + "'");
				if (drBench.Length < 1)
				{
					DataRow r = ds.Tables["Benchmark"].NewRow();
					r["ID"] = splitZeile[0];
					r["Name"] = splitZeile[1];
					ds.Tables["Benchmark"].Rows.Add(r);
					BenchID = splitZeile[0];
					da2.Update(ds,"Benchmark");
				} 
				else 
				{
					BenchID = drBench[0]["ID"].ToString();
				}
				DataRow[] dr = ds.Tables["Results"].Select("BenchmarkID='" + BenchID + "' AND SYSTEMID='" + SysID + "' AND BenchCountID=" + CountID);
				if (dr.Length < 1 ) //Eintrag anlegen 
				{
					DataRow r = ds.Tables["Results"].NewRow();
					r["BenchmarkID"] = BenchID;
					r["Result"] = splitZeile[2];
					r["BenchCountID"] = CountID;
					r["SystemID"] = SysID;
					
					ds.Tables["Results"].Rows.Add(r);
				}
				da.Update(ds,"Results");
				
			}

		}
		private string ReadSysInfo(NameValueCollection col)
		{
			FbDataAdapter da = new FbDataAdapter("Select * from System",fbConn);
			DataSet ds = new DataSet("System");			
			da.Fill(ds,"System");
			FbCommandBuilder cmd = new FbCommandBuilder(da);

			DataRow[] dr = ds.Tables["System"].Select("ID='" + col.GetValues("ID")[0] + "'");
			if (dr.Length>0) //Eintrag schon vorhanden
			{
				return dr[0]["ID"].ToString();
			} 
			else //Eintrag anlegen 
			{
				DataRow r = ds.Tables["System"].NewRow();
				r["ID"] = col.GetValues("ID")[0];
				r["OSName"] = col.GetValues("OSName")[0];
				r["OSVersion"] = col.GetValues("OSVersion")[0];
				r["CLRVersion"] = col.GetValues("CLRVersion")[0];
				r["Processor"] = col.GetValues("Processor")[0];
				r["Manufacturer"] = col.GetValues("Manufacturer")[0];
				r["CPUSpeed"] = col.GetValues("CPUSpeed")[0];
				r["PhysicalMemory"] = col.GetValues("PhysicalMemory")[0];
				r["VirtualMemory"] = col.GetValues("VirtualMemory")[0];
				ds.Tables["System"].Rows.Add(r);
				da.Update(ds,"System");
				return r["ID"].ToString();
			}
		}
		private int ReadCount(NameValueCollection col)
		{
			FbDataAdapter da = new FbDataAdapter("Select * from BenchCount",fbConn);
			DataSet ds = new DataSet("BenchCount");			
			da.Fill(ds,"BenchCount");
			ds.Tables["BenchCount"].Columns["ID"].AutoIncrement = true;
			FbCommandBuilder cmd = new FbCommandBuilder(da);
			
			DataRow[] dr = ds.Tables["BenchCount"].Select("Standart=" + col.GetValues("Standart")[0] + " AND BCL=" + col.GetValues("BCL")[0]);
			if (dr.Length>0) //Eintrag schon vorhanden
			{
				return (int)dr[0]["ID"];
			} 
			else //Eintrag anlegen 
			{
				DataRow r = ds.Tables["BenchCount"].NewRow();
				r["Standart"] = col.GetValues("Standart")[0];
				r["BCL"] = col.GetValues("BCL")[0];
				
				ds.Tables["BenchCount"].Rows.Add(r);
				da.Update(ds,"BenchCount");
				return (int)r["ID"];
			}
		}

		private void mnuExit_Click(object sender, System.EventArgs e)
		{
			Application.Exit();
		}

		private void mnuInfo_Click(object sender, System.EventArgs e)
		{
			MessageBox.Show("IL Benchmark Analyse Tool\nCopyright (c) 2005 Winfried Klinker","Info");
		}

		private void frmHaupt_Load(object sender, System.EventArgs e)
		{
			InitCodeKlassenGrid();	
			InitPlatformenGrid();
			//Select Summe, mean from clustersystem where clusterid=0 and systemid='NHQto/ED85YuXS8qYIAh7A98rEm9rlP5ig==';
		}

		private void InitCodeKlassenGrid()
		{
			FbDataAdapter da = new FbDataAdapter("Select * from Cluster",fbConn);
			DataSet ds = new DataSet();
			da.Fill(ds,"Cluster");

			DataTable tb = new DataTable("Cluster");
			tb.Columns.Add(new DataColumn("ID",typeof(int)));
			tb.Columns.Add(new DataColumn("Durchschnitt",typeof(double)));
			tb.Columns.Add(new DataColumn("Anzahl",typeof(int)));
			
			for (int i=0;i<ds.Tables["Cluster"].Rows.Count;i++)
			{
				DataRow r = tb.NewRow();
				r["ID"] = ds.Tables["Cluster"].Rows[i]["ID"].ToString();
				r["Durchschnitt"] =  ds.Tables["Cluster"].Rows[i]["Mean"].ToString();
				r["Anzahl"] = 1;
				tb.Rows.Add(r);
			}
			grdKlassen.DataSource = tb;
		
			/*
			// Add a GridTableStyle and set the MappingName 
			// to the name of the DataTable.
			DataGridTableStyle tsMean = new DataGridTableStyle();
			tsMean.MappingName = "Cluster";

			// Add a GridColumnStyle and set the MappingName 
			// to the name of a DataColumn in the DataTable. 
			// Set the HeaderText and Width properties. 
			DataGridColumnStyle TCFirstName = new DataGridTextBoxColumn();
			TCFirstName.MappingName = " Durchschnitt";
			TCFirstName.HeaderText = "Durschnitt 2";
			TCFirstName.Width = 75;
			tsMean.GridColumnStyles.Add(TCFirstName);

			// Add the DataGridTableStyle instance to 
			// the GridTableStylesCollection. 
			grdKlassen.TableStyles.Add(tsMean);
			*/
			

		}
		private void InitPlatformenGrid()
		{
			FbDataAdapter da = new FbDataAdapter("Select * from System",fbConn);
			DataSet ds = new DataSet();
			da.Fill(ds,"System");

			DataTable tb = new DataTable();
			tb.Columns.Add(new DataColumn("ID",typeof(string)));
			tb.Columns.Add(new DataColumn("Anzeigen",typeof(bool)));
			tb.Columns.Add(new DataColumn("CLR",typeof(string)));
			tb.Columns.Add(new DataColumn("OS",typeof(string)));
			tb.Columns.Add(new DataColumn("Prozessor",typeof(string)));
			tb.Columns.Add(new DataColumn("Takt",typeof(string)));
			tb.Columns.Add(new DataColumn("RAM",typeof(string)));
			

			for (int i=0;i<ds.Tables["System"].Rows.Count;i++)
			{
				DataRow r = tb.NewRow();
				r["ID"] = ds.Tables["System"].Rows[i]["ID"].ToString();
				r["Anzeigen"] = true;
				r["CLR"] = ds.Tables["System"].Rows[i]["CLRVersion"].ToString();
				r["OS"] = ds.Tables["System"].Rows[i]["OSName"].ToString();
				r["Prozessor"] = ds.Tables["System"].Rows[i]["Processor"].ToString();
				r["Takt"] = ds.Tables["System"].Rows[i]["CPUSpeed"].ToString();
				r["RAM"] = ds.Tables["System"].Rows[i]["PhysicalMemory"].ToString();
				tb.Rows.Add(r);
			}
			grdPlatform.DataSource = tb;
			
		}
		private void mnuClustering_Click(object sender, System.EventArgs e)
		{
			frmCluster fcluster = new frmCluster();
			fcluster.ShowDialog();
			InitCodeKlassenGrid();	
			InitPlatformenGrid();
		}

		private void cmdAktualisieren_Click(object sender, System.EventArgs e)
		{
			graph.MasterPane.PaneList.Clear();
			graph.MasterPane.Add( new GraphPane());
			graph.AxisChange();
			graph.Invalidate();

			DataTable tb = (DataTable)grdPlatform.DataSource;
		
			FbDataAdapter da = new FbDataAdapter("Select * from ClusterSystem",fbConn);
			DataSet ds = new DataSet();
			da.Fill(ds,"ClusterSystem");

			string[] strX = new string[tb.Rows.Count];
 
			for (int i=0;i<tb.Rows.Count;i++)
			{
				if ((bool)tb.Rows[i]["Anzeigen"] == true)
				{
					//MessageBox.Show(tb.Rows[i]["ID"].ToString());	
					//alle Cluster durchlaufen
					DataTable tbCluster = (DataTable)grdKlassen.DataSource;
					double dauer =0;
					for (int b=0;b<tbCluster.Rows.Count;b++)
					{
						DataRow[] dr = ds.Tables["ClusterSystem"].Select("clusterid=" + tbCluster.Rows[b]["ID"] + " and systemid='" + tb.Rows[i]["ID"].ToString() + "'");
						if (dr.Length > 0)
						{
							double mean = (double)dr[0]["Mean"];
							int anz = (int)tbCluster.Rows[b]["Anzahl"];
							dauer += ( mean * anz );
						}
					}
					double [] y = new double[1];
					double [] x = new double[1]; //tb.Rows.Count];
					y[0] = dauer;
					x[0] = 0;
					strX[i] = tb.Rows[i]["CLR"].ToString();
					graph.GraphPane.AddBar(tb.Rows[i]["CLR"].ToString(),x,y, ColorSymbolRotator.StaticNextColor);

				}
			}
			
			graph.GraphPane.Title = "Ausführungsdauer";
			graph.GraphPane.XAxis.Type = AxisType.Text;
			graph.GraphPane.YAxis.Title = "Dauer";
			graph.GraphPane.XAxis.Title = "Plattform";
			//graph.GraphPane.XAxis.TextLabels = strX;
			graph.GraphPane.AxisChange(this.CreateGraphics());
			graph.Invalidate();
			this.Scale(1);
		}

		private void frmHaupt_Paint(object sender, PaintEventArgs e)
		{
			
			
		}

	}
}

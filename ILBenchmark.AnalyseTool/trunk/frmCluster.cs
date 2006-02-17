using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using FirebirdSql.Data.Firebird;
using System.IO;
using ZedGraph;

namespace ILBenchmark.AnalyseTool
{
	/// <summary>
	/// Zusammenfassung für frmCluster.
	/// </summary>
	public class frmCluster : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Label label1;
		private ZedGraph.ZedGraphControl graph;
		private System.Windows.Forms.Button cmdClustern;
		private System.Windows.Forms.Button cmdZurück;
		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;
		private System.Windows.Forms.NumericUpDown nKlassen;
		private FbConnection fbConn;

		public frmCluster()
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
			this.label1 = new System.Windows.Forms.Label();
			this.nKlassen = new System.Windows.Forms.NumericUpDown();
			this.cmdClustern = new System.Windows.Forms.Button();
			this.graph = new ZedGraph.ZedGraphControl();
			this.cmdZurück = new System.Windows.Forms.Button();
			((System.ComponentModel.ISupportInitialize)(this.nKlassen)).BeginInit();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.Location = new System.Drawing.Point(8, 16);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(112, 24);
			this.label1.TabIndex = 0;
			this.label1.Text = "Anzahl der Klassen:";
			// 
			// nKlassen
			// 
			this.nKlassen.Location = new System.Drawing.Point(120, 16);
			this.nKlassen.Name = "nKlassen";
			this.nKlassen.Size = new System.Drawing.Size(48, 20);
			this.nKlassen.TabIndex = 1;
			this.nKlassen.Value = new System.Decimal(new int[] {
																   4,
																   0,
																   0,
																   0});
			// 
			// cmdClustern
			// 
			this.cmdClustern.Location = new System.Drawing.Point(192, 16);
			this.cmdClustern.Name = "cmdClustern";
			this.cmdClustern.Size = new System.Drawing.Size(104, 24);
			this.cmdClustern.TabIndex = 2;
			this.cmdClustern.Text = "Neu clustern";
			this.cmdClustern.Click += new System.EventHandler(this.cmdClustern_Click);
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
			this.graph.Location = new System.Drawing.Point(8, 48);
			this.graph.Name = "graph";
			this.graph.PointDateFormat = "g";
			this.graph.PointValueFormat = "G";
			this.graph.Size = new System.Drawing.Size(424, 384);
			this.graph.TabIndex = 3;
			// 
			// cmdZurück
			// 
			this.cmdZurück.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.cmdZurück.Location = new System.Drawing.Point(352, 440);
			this.cmdZurück.Name = "cmdZurück";
			this.cmdZurück.Size = new System.Drawing.Size(80, 24);
			this.cmdZurück.TabIndex = 4;
			this.cmdZurück.Text = "Zurück";
			this.cmdZurück.Click += new System.EventHandler(this.cmdZurück_Click);
			// 
			// frmCluster
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(440, 470);
			this.Controls.Add(this.cmdZurück);
			this.Controls.Add(this.graph);
			this.Controls.Add(this.cmdClustern);
			this.Controls.Add(this.nKlassen);
			this.Controls.Add(this.label1);
			this.Name = "frmCluster";
			this.Text = "Statistisches Clustering";
			((System.ComponentModel.ISupportInitialize)(this.nKlassen)).EndInit();
			this.ResumeLayout(false);

		}
		#endregion

		private void cmdClustern_Click(object sender, System.EventArgs e)
		{
			Cursor.Current = Cursors.WaitCursor;
			fbConn.Open();
			FbDataAdapter da = new FbDataAdapter("Select * from Results",fbConn);
			FbDataAdapter daBench = new FbDataAdapter("Select * from Benchmark",fbConn);
			FbDataAdapter daCluster = new FbDataAdapter("Select * from Cluster",fbConn);
			FbDataAdapter daClusterSystem = new FbDataAdapter("Select * from CLUSTERSYSTEM",fbConn);
			
			//Cluster in DB löschen
			FbCommand cmdDel = new FbCommand("Delete from Cluster;",fbConn);
			cmdDel.ExecuteNonQuery();
			//ClusterSystem in DB löschen
			FbCommand cmdDelClusterSys = new FbCommand("Delete from ClusterSystem;",fbConn);
			cmdDelClusterSys.ExecuteNonQuery();

			DataSet ds = new DataSet();			
			da.Fill(ds,"Results");
			daBench.Fill(ds,"Benchmark");
			FbCommandBuilder cmd = new FbCommandBuilder(daBench);
			daCluster.Fill(ds,"Cluster");
			FbCommandBuilder cmdCluster = new FbCommandBuilder(daCluster);
			
			daClusterSystem.Fill(ds,"ClusterSystem");
			ds.Tables["ClusterSystem"].Columns["ID"].AutoIncrement=true;
			object o = new FbCommand("Select Max(ID) + 1 from ClusterSystem",fbConn).ExecuteScalar();
			if (!o.Equals(System.DBNull.Value))
				ds.Tables["ClusterSystem"].Columns["ID"].AutoIncrementSeed = (long)o;
		
			FbCommandBuilder cmdClusterSystem = new FbCommandBuilder(daClusterSystem);
			FbDataAdapter daSystem = new FbDataAdapter("Select * from System order by ID",fbConn);
			daSystem.Fill(ds,"System");
	
			StreamWriter sw = new StreamWriter("cluster.txt");

			double[,] daten = GetDataFromDB (ds);
			Clustering.KMeans.ClusterCollection col = Clustering.KMeans.KMeans.ClusterDataSet((int)nKlassen.Value,daten);
			for (int i=0;i<col.Count;i++)
			{
				DataRow d = ds.Tables["Cluster"].NewRow();
				d["ID"] = i;
				d["Mean"] = col[i].ClusterMean[1];
				d["Summe"] = col[i].ClusterSum[1];
				ds.Tables["Cluster"].Rows.Add(d);
				daCluster.Update(ds,"Cluster");

				double[] ClusterSysSumme = new double[ds.Tables["System"].Rows.Count];
				//PointPairList pl = new PointPairList();

				sw.WriteLine("Beginn Cluster " + i);
				for (int x=0;x<col[i].Count;x++)
				{
					double id = col[i][x][0]; //Id aus Resultstabelle
					DataRow[] drResult = ds.Tables["Results"].Select("ID=" + (int)id); 
					{
						for(int bID=0;bID<ds.Tables["Benchmark"].Rows.Count;bID++)
						{
							if (drResult[0]["BenchmarkID"].ToString().Equals(ds.Tables["Benchmark"].Rows[bID]["ID"].ToString()))
							{

								FbCommand cmdUpdate = new FbCommand("Update Benchmark set Clusterid=" + i + " where ID='" + ds.Tables["Benchmark"].Rows[bID]["ID"].ToString() + "';",fbConn);
								int bla = cmdUpdate.ExecuteNonQuery();
								//ds.Tables["Benchmark"].Rows[bID].BeginEdit();
								//ds.Tables["Benchmark"].Rows[bID]["CLUSTERID"] = i;
								//ds.Tables["Benchmark"].Rows[bID].EndEdit();
								daBench.Update(ds,"Benchmark");		

								DataRow[] drR = ds.Tables["Results"].Select("BenchmarkID='" + drResult[0]["BenchmarkID"].ToString() + "'");
								for (int g=0;g<drR.Length;g++)
								{
									ClusterSysSumme[getSysID(drR[g]["SystemID"].ToString())] +=  double.Parse(drR[g]["Result"].ToString());
								}
								break;
							}
						}
					}
					sw.WriteLine("Wert bei ID=" + col[i][x][0] + " (" + i + "," + x + ") = " + col[i][x][1]);
					//PointPair p = new PointPair(i,col[i][x][1]);
					//pl.Add(p);
				}
				for (int b=0;b<ClusterSysSumme.Length;b++)
				{
					DataRow dClusterSys = ds.Tables["CLUSTERSYSTEM"].NewRow();
					dClusterSys["SystemID"] = getSysID(b); //als string
					dClusterSys["Mean"] = ClusterSysSumme[b] / col[i].Count;
					dClusterSys["Summe"] = ClusterSysSumme[b]; //als int
					dClusterSys["CLUSTERID"] = i;
					ds.Tables["ClusterSystem"].Rows.Add(dClusterSys);
					daClusterSystem.Update(ds,"ClusterSystem");
				}
				sw.WriteLine("Ende Cluster " + i);
				
				PointPairList pl = new PointPairList();
				PointPair p = new PointPair(i,col[i].ClusterMean[1],"Mean");
				PointPair p2 = new PointPair(i,col[i].ClusterSum[1],"Sum");
				pl.Add(p);
				pl.Add(p2);
				graph.GraphPane.AddBar("Cluster " + i,pl,ZedGraph.ColorSymbolRotator.StaticNextColor);
			}
			sw.Close();
			fbConn.Close();


			graph.GraphPane.Title = "Clustering";
			graph.GraphPane.XAxis.Type = AxisType.Text;
			graph.GraphPane.YAxis.Title = "Dauer";
			graph.GraphPane.XAxis.TextLabels = new string[2] { "Durchschnitt","Summe" };
			graph.AxisChange();
			graph.Invalidate();
			Cursor.Current = Cursors.Default;
			MessageBox.Show("Fertig!");
		}
		private int getSysID(string ID)
		{
			FbDataAdapter daSystem = new FbDataAdapter("Select * from System order by ID",fbConn);
			DataSet ds = new DataSet();
			daSystem.Fill(ds,"System");

			for (int y=0;y<ds.Tables["System"].Rows.Count;y++)
			{
				if(ds.Tables["System"].Rows[y]["ID"].ToString().Equals(ID))
					return y;
			}
			return -1;

		}
		private string getSysID(int index)
		{
			FbDataAdapter daSystem = new FbDataAdapter("Select * from System order by ID",fbConn);
			DataSet ds = new DataSet();
			daSystem.Fill(ds,"System");

			return ds.Tables["System"].Rows[index]["ID"].ToString();
		}

		private double[,] GetDataFromDB(DataSet ds)
		{
			double[,] daten = new double[ds.Tables["Benchmark"].Rows.Count,2];
			double wert=0;

			for (int i=0;i<ds.Tables["Benchmark"].Rows.Count;i++)
			{
				DataRow[] dr = ds.Tables["Results"].Select("BenchmarkID='" + ds.Tables["Benchmark"].Rows[i]["ID"].ToString() + "'");
				daten[i,0] = double.Parse(dr[0]["ID"].ToString());
				for (int b=0;b<dr.Length;b++)
				{
					wert += double.Parse(dr[b]["Result"].ToString());
					//Mittelwert eines Benchmarks auf allen Plattformen berechnen
					//und den dann zum Clustern benutzen
				}
				daten[i,1] = wert;
				wert =0;
			}
			return daten;
		}

		private void cmdZurück_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}
	}
}

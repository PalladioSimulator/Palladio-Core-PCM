using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.IO;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

namespace WebAudioStore
{
	/// <summary>
	/// Zusammenfassung für WebForm1.
	/// </summary>
	public class UploadForm : System.Web.UI.Page
	{
		protected System.Web.UI.HtmlControls.HtmlInputFile myFile;
		protected System.Web.UI.WebControls.DataGrid grid;
		protected System.Web.UI.WebControls.Button Button1;
		protected DataView dataView;
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			// Hier Benutzercode zur Seiteninitialisierung einfügen
		}

		#region Vom Web Form-Designer generierter Code
		override protected void OnInit(EventArgs e)
		{
			DataSet ds = new DataSet();
			DataTable t = new DataTable("ImageTable");
			t.Columns.Add("ID",typeof(int));
			t.Columns.Add("Name",typeof(string));
			t.Columns.Add("Size",typeof(int));
			ds.Tables.Add(t);

			DirectoryInfo di = new DirectoryInfo(Server.MapPath("Data"));
			// Create an array representing the files in the current directory.
			FileInfo[] fis = di.GetFiles();
			int i = 1;
			foreach (FileInfo fi in fis)
			{
				object[] vals = new object[3];
				vals[0] = i++;
				vals[1] = fi.Name;
				vals[2] = fi.Length;
				t.Rows.Add(vals);
			}

			dataView = ds.Tables["ImageTable"].DefaultView;

			//
			// CODEGEN: Dieser Aufruf ist für den ASP.NET Web Form-Designer erforderlich.
			//
			InitializeComponent();
			base.OnInit(e);
		}
		
		/// <summary>
		/// Erforderliche Methode für die Designerunterstützung. 
		/// Der Inhalt der Methode darf nicht mit dem Code-Editor geändert werden.
		/// </summary>
		private void InitializeComponent()
		{    
			this.grid.Load += new System.EventHandler(this.GridLoad);
			this.Button1.Click += new System.EventHandler(this.Button1_Click);

		}
		#endregion

		private void GridLoad(object sender, System.EventArgs e)
		{
			grid.HeaderStyle.Font.Bold = true;
			grid.AlternatingItemStyle.BackColor = System.Drawing.Color.LightGray;
			grid.DataSource = dataView;
			grid.DataBind();
		}

		private void Button1_Click(object sender, System.EventArgs e)
		{
			if (myFile.PostedFile != null)
			{
				HttpPostedFile postedFile = myFile.PostedFile;
				byte[] buffer = new byte[postedFile.ContentLength];
				postedFile.InputStream.Read(buffer,0,buffer.Length);
				string fileName = Server.MapPath("Data\\"+Path.GetFileName(postedFile.FileName));
				using(FileStream fs = new FileStream(fileName,FileMode.Create))
				{
					fs.Write(buffer,0,buffer.Length);
				}
			}
			Response.Redirect("uploaded.htm");
		}
	}
}

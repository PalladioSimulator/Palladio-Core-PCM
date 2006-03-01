using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Web;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.ComponentModel;
using System.Threading;

namespace WebAudioStore
{
	/// <summary>
	/// Zusammenfassung für WebForm1.
	/// </summary>
	public class UploadForm : Page
	{
		protected HtmlInputFile myFile;
		protected DataGrid grid;
		protected DataView dataView;
		protected ListBox ListBox1;
		protected Button AddFile;
		protected Button RemvFile;
		protected HtmlInputFile FindFile;
		protected HtmlInputButton Upload;
		protected Label Label1;

		public ArrayList files = new ArrayList();
		static public ArrayList hif = new ArrayList();
		public int filesUploaded = 0;
		
		protected DBQueries queries;
		
		const int ERROR_FILE_NOT_FOUND = 2;
		protected System.Web.UI.WebControls.CheckBox CheckBox1;
		const int ERROR_ACCESS_DENIED = 5;
	
		public UploadForm()
		{
			this.queries = new DBQueries();
		}

		private void Page_Load(object sender, EventArgs e)
		{
			// Hier Benutzercode zur Seiteninitialisierung einfügen
		}

		#region Vom Web Form-Designer generierter Code
		override protected void OnInit(EventArgs e)
		{
			DataSet ds = queries.GetAudioFileInfo(); // read AudioFileInfo table from database
			dataView = ds.Tables["ImageTable"].DefaultView; // add table to webpage

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
			this.AddFile.Click += new System.EventHandler(this.AddFile_Click);
			this.RemvFile.Click += new System.EventHandler(this.RemvFile_Click);
			this.grid.Load += new System.EventHandler(this.GridLoad);
			this.Upload.ServerClick += new System.EventHandler(this.Upload_ServerClick);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void GridLoad(object sender, EventArgs e)
		{
			grid.HeaderStyle.Font.Bold = true;
			grid.DataSource = dataView;
			grid.DataBind();
		}
/*
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
				StringBuilder respString = 
					this.queries.InsertFile(buffer, postedFile.FileName, postedFile.ContentLength);
				
				Response.Write("<html><body>"+respString+"</body><html>");
			}
			Response.Redirect("UploadForm.aspx");
		}
*/
		/// <summary>
		/// AddFile will add the path of the client side file that is currently in the 
		/// PostedFile
		/// property of the HttpInputFile control to the listbox.
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void AddFile_Click(object sender, EventArgs e)
		{
			if (Page.IsPostBack == true)
			{
				hif.Add(FindFile);
				ListBox1.Items.Add(FindFile.PostedFile.FileName);
			}
			else
			{
                
			}
		}

		/// <summary>
		/// RemvFile will remove the currently selected file from the listbox.
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		private void RemvFile_Click(object sender, EventArgs e)
		{
			if(ListBox1.Items.Count != 0)
			{
				hif.RemoveAt(ListBox1.SelectedIndex);
				ListBox1.Items.Remove(ListBox1.SelectedItem.Text);
			}
        
		}

		/// <summary>
		/// Upload_ServerClick is the server side script that will upload the files to 
		/// the web server
		/// by looping through the files in the listbox.
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="e"></param>
		public void Upload_ServerClick(object sender, EventArgs e)
		{
			string baseLocation = "C:\\temp\\";
			string status = "";
            
			if((ListBox1.Items.Count == 0) && (filesUploaded == 0))
			{
				Label1.Text = "Error - a file name must be specified.";
				return;

			}
			else
			{
				foreach(HtmlInputFile HIF in hif)
				{
					try
					{
						string fn = ProcessFile(HIF, CheckBox1.Checked);
						status += fn + "<br>";
					}
					catch(Exception err)
					{
						Label1.Text = "Error saving file " + baseLocation
							+ "<br>" + err.ToString();
					}
				}

				if(filesUploaded == hif.Count)
				{
					Label1.Text = "These " + filesUploaded + " file(s) were "
						+ "uploaded:<br>" + status;
				}
				hif.Clear();
				ListBox1.Items.Clear();
			}
			Response.Redirect("UploadForm.aspx"); // to reload the table
		}

		/// <summary>
		/// Controls the handling of an uploaded file:
		/// 1. stores it to disk
		/// 2. (optionally) encodes it
		/// 3. stores it to database
		/// </summary>
		private string ProcessFile(HtmlInputFile HIF, bool doEncode)
		{
			HttpPostedFile postedFile = HIF.PostedFile;
			byte[] postedFileContent = new byte[postedFile.ContentLength];
			postedFile.InputStream.Read(postedFileContent,0,postedFileContent.Length);
			string postedFileName = Path.GetFileName(HIF.PostedFile.FileName);
	
			string fileName = Server.MapPath("Data\\"+postedFileName);
			using(FileStream fs = new FileStream(fileName,FileMode.Create))
			{
				fs.Write(postedFileContent,0,postedFileContent.Length);
			}

			if (!doEncode)
			{
				// store directly in DB
				this.queries.InsertFile(postedFileContent, postedFileName, postedFileContent.Length);	
			} 
			else
			{
				// do encoding, write file to disk
				EncodeFile(fileName);

				// read encoded file from disk
				string encodedFileName = fileName.Substring(0,fileName.Length-3);
				encodedFileName+="ogg";
				byte[] encodedFileContent = null;
				using(FileStream fs = new FileStream(encodedFileName,FileMode.Open))
				{
					int encodedFileLength = (int)fs.Length;
					encodedFileContent = new byte[encodedFileLength];
					fs.Read(encodedFileContent,0,encodedFileLength);
				}

				// store encoded file to database
				this.queries.InsertFile(encodedFileContent, encodedFileName, encodedFileContent.Length);
			}

			filesUploaded++;
			return fileName;
		}

		/// <summary>
		/// Encodes the file with the given fileName from a WAV to OGG
		/// by starting an external process (oggenc2.exe).
		/// </summary>
		private void EncodeFile(string fileName)
		{
			Process myProcess = new Process();
			
			// configure process
			ProcessStartInfo pInfo = 
				new ProcessStartInfo("C:\\Inetpub\\wwwroot\\WebAudioStore\\Data\\oggenc2.exe");
			pInfo.WorkingDirectory = "C:\\Inetpub\\wwwroot\\WebAudioStore\\Data";
			pInfo.Arguments = fileName;
			pInfo.UseShellExecute = true;
			pInfo.CreateNoWindow = true;
			myProcess.StartInfo = pInfo;
			
			// execute process
			try
			{
				myProcess.Start();		
				myProcess.WaitForExit();	
			}
			catch (Win32Exception e)
			{
				if(e.NativeErrorCode == ERROR_FILE_NOT_FOUND)
				{
					Console.WriteLine(e.Message + ". Check the path.");
				} 

				else if (e.NativeErrorCode == ERROR_ACCESS_DENIED)
				{
					Console.WriteLine(e.Message + 
						". You do not have permission to print this file.");
				}
			}
		}

	}
}

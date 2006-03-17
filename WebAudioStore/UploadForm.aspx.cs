using System;
using System.Collections;
using System.Data;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;

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

		protected IAudioStore audioStore;
		protected Button Button1;
		protected System.Web.UI.WebControls.TextBox TextBox1;
		
		
		protected CheckBox CheckBox1;
	
		public UploadForm()
		{
			//IAudioDB db = new DBAdapter();
			// IAudioDB db = new EncodingAdapter(new DBAdapter(), new OggEncoder());
			//IAudioDB db = new EncodingAdapter(new BufferingDBAdapter(), new OggEncoder());
			IAudioDB db = new BufferingDBAdapter();
			audioStore = new AudioStore(db);
		}

		private void Page_Load(object sender, EventArgs e)
		{
			// Hier Benutzercode zur Seiteninitialisierung einfügen
		}

		#region Vom Web Form-Designer generierter Code
		override protected void OnInit(EventArgs e)
		{
			dataView = audioStore.GetUploadedFileView();

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
			this.Button1.Click += new System.EventHandler(this.Button1_Click);
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
						string fn = audioStore.HandleUpload(HIF.PostedFile);
						status += fn + "<br>";
					}
					catch(Exception err)
					{
						Label1.Text = "Error saving file " + baseLocation
							+ "<br>" + err.ToString();
					}
				}

				audioStore.FinalizeUpload(); // for the BufferingDBAdapter to finish

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

		private void Button1_Click(object sender, EventArgs e)
		{
			CallLogger.SaveLoggedInformationXML(1);
		}

	}
}

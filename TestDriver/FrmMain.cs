//	11/17/2003
//	Alexander Kent
//	MSHTML-Automation
//	Version 1.1

using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Threading;
using System.Windows.Forms;
using System.Data;
using mshtml;

namespace mshtml_automation_demo
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class MainForm : System.Windows.Forms.Form
	{
		private AxSHDocVw.AxWebBrowser axWebBrowser;
		private Random rand;

		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		private object myLock;
		private bool isComplete;

		public MainForm()
		{
			InitializeComponent();
			myLock = new object();
			isComplete = false;
			rand = new Random();
		}

		/// <summary>
		/// Clean up any resources being used.
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

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(MainForm));
			this.axWebBrowser = new AxSHDocVw.AxWebBrowser();
			((System.ComponentModel.ISupportInitialize)(this.axWebBrowser)).BeginInit();
			this.SuspendLayout();
			// 
			// axWebBrowser1
			// 
			this.axWebBrowser.Dock = System.Windows.Forms.DockStyle.Fill;
			this.axWebBrowser.Enabled = true;
			this.axWebBrowser.Location = new System.Drawing.Point(0, 0);
			this.axWebBrowser.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("axWebBrowser1.OcxState")));
			this.axWebBrowser.Size = new System.Drawing.Size(616, 382);
			this.axWebBrowser.TabIndex = 0;
			this.axWebBrowser.DocumentComplete += new AxSHDocVw.DWebBrowserEvents2_DocumentCompleteEventHandler(this.axWebBrowser1_DocumentComplete);
			// 
			// MainForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(616, 382);
			this.Controls.Add(this.axWebBrowser);
			this.Name = "MainForm";
			this.Text = "Microsoft WebBrowser Automation";
			this.Load += new System.EventHandler(this.FrmMain_Load);
			((System.ComponentModel.ISupportInitialize)(this.axWebBrowser)).EndInit();
			this.ResumeLayout(false);

		}
		#endregion

		/// <summary>
		/// The main entry point for the application.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new MainForm());
		}

		private void FrmMain_Load(object sender, System.EventArgs e)
		{
			Thread t = new Thread(new ThreadStart(MyClient));
			t.Start();
		}

		private void LoadPage(object loc)
		{
			object null_obj_str = "";
			System.Object null_obj = 0;
			this.axWebBrowser.Navigate2(ref loc , ref null_obj, ref null_obj, ref null_obj_str, ref null_obj_str);
		}

		private HTMLDocument GetDocument()
		{
			Monitor.Enter(myLock);
			while(!isComplete) Monitor.Wait(myLock);
			isComplete = false;
			Monitor.Exit(myLock);
			return (HTMLDocument) axWebBrowser.Document;
		}

		private void MyClient()
		{
			DateTime stop = new DateTime(2006,3,20,15,0,0,0);
			//DateTime stop = new DateTime(2006,3,14,17,50,0,0);C:\Upload\4000_192.mp3


			while(DateTime.Compare(DateTime.Now,stop)<0)
			{
				try
				{
					int trackCnt = NumberofTracks();
					LoadPage("http://localhost/WebAudioStore/UploadForm.aspx");			
					for(int i=0; i<trackCnt; i++)
					{
						string fileName = ChooseFile();
						AddFile(fileName);
					}
					UploadFiles();
					GetDocument(); // Wait til completion
				} catch (Exception e)
				{
					Console.WriteLine(e);
				}
			}
		}

		private int NumberofTracks()
		{
			double trackProb = rand.NextDouble();
			if (trackProb <= 0.1) return 8; 
			if (trackProb <= 0.2) return 9; 
			if (trackProb <= 0.4) return 10; 
			if (trackProb <= 0.8) return 11; 
			return 12;			
		}

		private string ChooseFile()
		{
			double fileSizeProb = rand.NextDouble();
			if(fileSizeProb <= 0.1) return @"C:\Upload\3500_192.mp3";
			if(fileSizeProb <= 0.7) return @"C:\Upload\4000_192.mp3";
			return @"C:\Upload\4500_192.mp3";
		}


		private void axWebBrowser1_DocumentComplete(object sender, AxSHDocVw.DWebBrowserEvents2_DocumentCompleteEvent e)
		{
			lock(myLock)
			{
				isComplete = true;
				Monitor.Pulse(myLock);
			}
		}

		private void UploadFiles()
		{
			HTMLDocument myDoc = GetDocument();
			HTMLInputElement upload = (HTMLInputElement) myDoc.getElementById("Upload");				
			upload.click();
		}

		private void AddFile(string fileName)
		{
			HTMLDocument myDoc = GetDocument();
			HTMLInputElement file = (HTMLInputElement) myDoc.getElementById("FindFile");
			file.focus();
			SendKeys.SendWait(fileName + "{ENTER}");
		}
	}
}

using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using BibTeX.Parser;
using BibTeX.Parser.Types;
using BibTeX.Parser.Exceptions;
using System.IO;
using BibTeX.Parser.Modifier;
using BibTeX.Parser.Interfaces;
using BibTeX.Formater.Interfaces;
using BibTeX.Formater;

namespace BibTeX_Analyzer
{
	/// <summary>
	/// Zusammenfassung für Form1.
	/// </summary>
	public class Form1 : System.Windows.Forms.Form
	{
		private System.Windows.Forms.TextBox textBox1;
		private System.Windows.Forms.Button button1;
		private System.Windows.Forms.TextBox textBox2;
		private System.Windows.Forms.Button button2;
		private System.Windows.Forms.OpenFileDialog openFileDialog1;
		private System.Windows.Forms.Button button3;
		private System.Windows.Forms.TextBox logWindow;
		private System.Windows.Forms.ListBox listBox1;
		private System.Windows.Forms.Button button4;
		/// <summary>
		/// Erforderliche Designervariable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		private IBibTeXFormater ASCIIFormater = null;

		public Form1()
		{
			//
			// Erforderlich für die Windows Form-Designerunterstützung
			//
			InitializeComponent();

			//
			// TODO: Fügen Sie den Konstruktorcode nach dem Aufruf von InitializeComponent hinzu
			//
			ASCIIFormater = FormaterFactory.GetASCIIFormater();
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
			this.textBox1 = new System.Windows.Forms.TextBox();
			this.button1 = new System.Windows.Forms.Button();
			this.textBox2 = new System.Windows.Forms.TextBox();
			this.button2 = new System.Windows.Forms.Button();
			this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
			this.button3 = new System.Windows.Forms.Button();
			this.logWindow = new System.Windows.Forms.TextBox();
			this.listBox1 = new System.Windows.Forms.ListBox();
			this.button4 = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// textBox1
			// 
			this.textBox1.Location = new System.Drawing.Point(232, 16);
			this.textBox1.Name = "textBox1";
			this.textBox1.Size = new System.Drawing.Size(192, 20);
			this.textBox1.TabIndex = 0;
			this.textBox1.Text = "C:\\Job\\src\\BibTeXParser\\ralf.bib";
			// 
			// button1
			// 
			this.button1.Location = new System.Drawing.Point(592, 16);
			this.button1.Name = "button1";
			this.button1.Size = new System.Drawing.Size(64, 24);
			this.button1.TabIndex = 1;
			this.button1.Text = "Load";
			this.button1.Click += new System.EventHandler(this.button1_Click);
			// 
			// textBox2
			// 
			this.textBox2.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.textBox2.Font = new System.Drawing.Font("Courier New", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.textBox2.Location = new System.Drawing.Point(176, 48);
			this.textBox2.Multiline = true;
			this.textBox2.Name = "textBox2";
			this.textBox2.ScrollBars = System.Windows.Forms.ScrollBars.Both;
			this.textBox2.Size = new System.Drawing.Size(488, 192);
			this.textBox2.TabIndex = 2;
			this.textBox2.Text = "textBox2";
			this.textBox2.WordWrap = false;
			// 
			// button2
			// 
			this.button2.Location = new System.Drawing.Point(432, 16);
			this.button2.Name = "button2";
			this.button2.Size = new System.Drawing.Size(24, 23);
			this.button2.TabIndex = 3;
			this.button2.Text = "...";
			this.button2.Click += new System.EventHandler(this.button2_Click);
			// 
			// button3
			// 
			this.button3.Location = new System.Drawing.Point(464, 16);
			this.button3.Name = "button3";
			this.button3.Size = new System.Drawing.Size(32, 24);
			this.button3.TabIndex = 4;
			this.button3.Text = "Add";
			this.button3.Click += new System.EventHandler(this.button3_Click);
			// 
			// logWindow
			// 
			this.logWindow.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.logWindow.Location = new System.Drawing.Point(176, 248);
			this.logWindow.Multiline = true;
			this.logWindow.Name = "logWindow";
			this.logWindow.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
			this.logWindow.Size = new System.Drawing.Size(488, 88);
			this.logWindow.TabIndex = 9;
			this.logWindow.Text = "textBox3";
			// 
			// listBox1
			// 
			this.listBox1.Dock = System.Windows.Forms.DockStyle.Left;
			this.listBox1.Items.AddRange(new object[] {
														  "C:\\Job\\CBSE7-PerfPC\\palladio.bib"});
			this.listBox1.Location = new System.Drawing.Point(0, 0);
			this.listBox1.Name = "listBox1";
			this.listBox1.Size = new System.Drawing.Size(168, 342);
			this.listBox1.TabIndex = 10;
			// 
			// button4
			// 
			this.button4.Location = new System.Drawing.Point(504, 16);
			this.button4.Name = "button4";
			this.button4.Size = new System.Drawing.Size(32, 23);
			this.button4.TabIndex = 11;
			this.button4.Text = "Del";
			this.button4.Click += new System.EventHandler(this.button4_Click);
			// 
			// Form1
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(672, 342);
			this.Controls.Add(this.button4);
			this.Controls.Add(this.listBox1);
			this.Controls.Add(this.logWindow);
			this.Controls.Add(this.textBox2);
			this.Controls.Add(this.textBox1);
			this.Controls.Add(this.button3);
			this.Controls.Add(this.button2);
			this.Controls.Add(this.button1);
			this.Name = "Form1";
			this.Text = "Form1";
			this.ResumeLayout(false);

		}
		#endregion

		/// <summary>
		/// Der Haupteinstiegspunkt für die Anwendung.
		/// </summary>
		[STAThread]
		static void Main() 
		{
			Application.Run(new Form1());
		}

		private void FixEntries(IEntry[] entries)
		{
			foreach(IEntry e in entries)
			{
				EntryModifier.RemoveDuplicateWhiteSpaceInFieldValues(e);
				if (e.Type == EntryType.REGULAR)
				{
					IRegularEntry regularEntry = (IRegularEntry)e;
					try
					{
						EntryModifier.CheckAuthorField(regularEntry,new LogEventHandler(this.LogEventHandler));
						EntryModifier.GenerateLabel(regularEntry);
						IField[] fields = regularEntry.Fields.Fields;
						Array.Sort(fields,new FieldComparer());
						regularEntry.Fields.Fields = fields;
					}
					catch (EntryModifierException ex)
					{
						logWindow.Text += ex.Message+Environment.NewLine;
					}
				}
			}
		}

		private void AlterLabels(IEntry[] mergedEntries)
		{
			String lastLabel = null;
			int lastChar = (int)'a';

			Array.Sort(mergedEntries,new EntryComparer());
			foreach(IEntry e in mergedEntries)
			{
				if (e.Type == EntryType.REGULAR)
				{
					IRegularEntry entry = (IRegularEntry)e;

					if (lastLabel != null && lastLabel.Equals(entry.Label))
					{
						lastChar++;
					}
					else
					{
						lastChar = (char)'a';
					}
					lastLabel = entry.Label;
					if (entry.IsModified)
					{
						entry.Label = entry.Label + (char)lastChar;
					}
				}
			}
		}

		private string FormatEntries(IEntry[] mergedEntries)
		{
			StringWriter writer = new StringWriter();
			foreach (IEntry entry in mergedEntries)
			{
				ASCIIFormater.FormatToStream(writer,entry);
			}
			return writer.ToString();
		}

		private void button1_Click(object sender, System.EventArgs eventArg)
		{
			ArrayList mergedEntries = new ArrayList();
			IBibTeXFactory bibtexFactory = FactoryBuilder.CreateBibTeXFactory();
			IBibTeXFile bibFile;
			String currentFilename = "";
			
			logWindow.Text = "";

			try 
			{
				bibtexFactory.LogEvent += new LogEventHandler(this.LogEventHandler);
				foreach (string filename in listBox1.Items)
				{
					logWindow.Text += "Loading "+filename+Environment.NewLine;
					currentFilename = filename;
					Application.DoEvents();
					Console.WriteLine("Start loading: "+DateTime.Now);
					bibFile = bibtexFactory.CreateBibTeXFileFromLocalFile(filename);
					Console.WriteLine("End loading: "+DateTime.Now);
					logWindow.Text += "Done loading "+filename+Environment.NewLine;
					FixEntries(bibFile.Entries);
					Console.WriteLine("End fixing: "+DateTime.Now);
					logWindow.Text += "Done fixing "+filename+Environment.NewLine;
					mergedEntries.AddRange(bibFile.Entries);
					Application.DoEvents();
				}
				if (mergedEntries.Count > 0)
				{
					Type type = mergedEntries[0].GetType().GetInterface("IEntry");
					IEntry[] entries = (IEntry[])mergedEntries.ToArray(type);
					AlterLabels(entries);
					Console.WriteLine("Start formating: "+DateTime.Now);
					textBox2.Text = FormatEntries(entries);
					Console.WriteLine("End formating: "+DateTime.Now);
				}
			}
			catch(BibTeXParserException e) 
			{
				MessageBox.Show(null,"Parsing failed. See log for error messages! Message: "+e,"ERROR",MessageBoxButtons.OK,MessageBoxIcon.Error);
			}
		}

		private void button2_Click(object sender, System.EventArgs e)
		{
			if (openFileDialog1.ShowDialog() == DialogResult.OK)
			{
				textBox1.Text = openFileDialog1.FileName;
			}
		}

		public void LogEventHandler (object sender, LogEventArgs args)
		{
			logWindow.Text += args.ToString();
			Application.DoEvents();
		}

		private void button3_Click(object sender, System.EventArgs e)
		{
			listBox1.Items.Add(textBox1.Text);
		}

		private void listBox1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}

		private void button4_Click(object sender, System.EventArgs e)
		{
			if (listBox1.SelectedIndex >= 0)
			{
				listBox1.Items.Remove(listBox1.SelectedItem);
			}
		}
	}

	class EntryComparer : IComparer
	{
		public int Compare (object a, object b)
		{
			IEntry e1 = (IEntry)a;
			IEntry e2 = (IEntry)b;

			if ((int)e1.Type < (int)e2.Type)
				return -1;
			else if ((int)e1.Type > (int)e2.Type)
				return 1;
			else
			{
				if (e1.Type == EntryType.REGULAR && e2.Type == EntryType.REGULAR)
				{
					IRegularEntry re1 = (IRegularEntry)e1;
					IRegularEntry re2 = (IRegularEntry)e2;

					if (re1.Label.CompareTo(re2.Label) != 0)
						return re1.Label.CompareTo(re2.Label);
					else
					{
						if (re1.Fields.HasField("title") && re2.Fields.HasField("title"))
						{
							return re1.Fields["title"].FlatValue.CompareTo(
								re2.Fields["title"].FlatValue);
						}
						else
						{
							return 0;
						}
					}
				}
				else if ((e1.Type == EntryType.MACRO && e2.Type == EntryType.MACRO) ||
					(e1.Type == EntryType.COMMENT && e2.Type == EntryType.COMMENT))
				{
					return (e1.SortOrder < e2.SortOrder ? -1 : 1);
				}
				else
					return 0;
			}
		}
	}

	class FieldComparer : IComparer
	{
		private string[] fieldOrder = {   "abstract",
										  "annote",
										  "note",
										  "number",
										  "volume",
										  "journal",
										  "pages",
										  "publisher",
										  "editor",
										  "booktitle",
										  "year",
										  "title",
										  "author" };
		private ArrayList fieldOrderArray = null;

		public int Compare (object a, object b)
		{
			IField f1 = (IField)a;
			IField f2 = (IField)b;
			int index1 = fieldOrderArray.IndexOf(f1.ID.ToLower());
			int index2 = fieldOrderArray.IndexOf(f2.ID.ToLower());
			if (index1 < index2)
				return 1;
			else if (index1 == index2)
				return 0;
			else 
				return -1;
		}

		public FieldComparer()
		{
			fieldOrderArray = new ArrayList(fieldOrder);
		}
	}
}

using System;
using System.IO;

namespace SimpleLogging
{
	/// <summary>
	/// Zusammenfassung für Logger.
	/// </summary>
	public class SimpleLogger
	{
		private bool consoleOutput;
		private bool fileOutput;

		private bool error;
		private bool warning;
		private bool info;
		private bool debug;

		private object currentObject;

		private StreamWriter fileWriter;

		public SimpleLogger(object currentClass)
		{
			this.currentObject = currentClass;
			this.error = false;
			this.warning = false;
			this.info = false;
			this.debug = false;
		}

		public bool ErrorOutput
		{
			get { return this.error; }
			set { this.error = value; }
		}

		public bool WarningOutput
		{
			get { return this.warning; }
			set { this.warning = value; }
		}

		public bool InfoOutput
		{
			get { return this.info; }
			set { this.info = value; }
		}

		public bool DebugOutput
		{
			get { return this.debug; }
			set { this.debug = value; }
		}

		public bool ConsoleOutput
		{
			get { return this.consoleOutput; }
			set { this.consoleOutput = value; }
		}

		public bool FileOutput
		{
			get { return this.fileOutput; }
			set
			{
				this.fileOutput = value;
//				if(this.fileOutput)
//				{
//					InitFileWriter();
//				}
			}
		}

//		internal void InitFileWriter()
//		{
//			this.fileWriter = new StreamWriter(this.ToString()+".txt");
//			this.fileWriter.WriteLine("Logging");
//			this.fileWriter.Close();
//
//		}

		public void Debug(string debugMessage)
		{
			Console.WriteLine("Aktueller Methode: " + this.currentObject.GetType());
			if (this.DebugOutput)

				WriteText(DateTime.Now + " Debug " + this.currentObject.GetType().ToString() + ": " + debugMessage);
		}

		public void Error(string errorMessage)
		{
			if (this.ErrorOutput)
				WriteText(DateTime.Now + " " + this.currentObject.GetType().ToString() + ": " + errorMessage);
		}

		public void Warning(string warningMessage)
		{
			if (this.WarningOutput)
				WriteText(DateTime.Now + " " + this.currentObject.GetType().ToString() + ": " + warningMessage);
		}


		public void Info(string defaultMessage)
		{
			if (this.InfoOutput)
				WriteText(DateTime.Now + " " + this.currentObject.GetType().ToString() + ": " + defaultMessage);
		}


		internal void WriteToFile(string message)
		{
			this.fileWriter.WriteLine(message);
			this.fileWriter.Flush();
		}

//		public void WriteText(string aMessage)
//		{
//			if(this.ConsoleOutput)
//				Console.WriteLine(aMessage);
//			if(this.fileOutput)
//				WriteToFile(aMessage);
//		}

		internal void WriteText(string g)
		{
			try
			{
				StreamWriter w = File.AppendText(this.currentObject.ToString() + ".txt");


				Log(g, w);
				// Close the writer and underlying file.
				w.Close();
			}
			catch (Exception)
			{
				Console.WriteLine("Log Lost");
			}
			// Open and read the file.
//		StreamReader r = File.OpenText("log.txt");
//		DumpLog (r);
		}

		public static void Log(String logMessage, TextWriter w)
		{
			w.Write("\r\nLog Entry : ");
//		w.WriteLine("{0} {1}", DateTime.Now.ToLongTimeString(),
//		DateTime.Now.ToLongDateString());
//		w.WriteLine("  :");
			w.WriteLine("  :{0}", logMessage);
			w.WriteLine("-------------------------------");
			// Update the underlying file.
			w.Flush();
		}

		public static void DumpLog(StreamReader r)
		{
			// While not at the end of the file, read and write lines.
			String line;
			while ((line = r.ReadLine()) != null)
			{
				Console.WriteLine(line);
			}
			r.Close();
		}

	}
}
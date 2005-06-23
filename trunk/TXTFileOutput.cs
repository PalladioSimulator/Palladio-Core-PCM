using System;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für ConsoleOutput.
	/// </summary>
	public class TXTFileOutput : Interfaces.IOutput
	{
		private System.Text.StringBuilder _sb;
		private System.Text.StringBuilder _sbPara;
		private System.Text.StringBuilder _sbError;
		
		public TXTFileOutput()
		{
		}

		#region IOutput Member

		public void Init()
		{
			_sb = new System.Text.StringBuilder();
			_sbPara = new System.Text.StringBuilder();
			_sbError = new System.Text.StringBuilder();
		}

		public void WriteResult(string Name, long Result)
		{
			_sb.Append(Name);
			_sb.Append(",");
			_sb.Append(Result);
			_sb.Append(Environment.NewLine);
		}

		public void WriteMissingParameter(string Name)
		{
			_sbPara.Append(Name);
			_sbPara.Append(Environment.NewLine);
		}

		public void WriteSkip(string Name)
		{
			_sbError.Append("Error: ");
			_sbError.Append(Name);
			_sbError.Append(Environment.NewLine);
		}

		public void Save()
		{
			System.IO.StreamWriter sw = new System.IO.StreamWriter(Environment.CurrentDirectory + @"\Ausgabe.txt",false);
			sw.WriteLine("IL Benchmark - (c) Winfried Klinker");
			sw.WriteLine("-----------------------------------");
			sw.WriteLine();
			sw.WriteLine("OS: " + Environment.OSVersion.ToString());
			sw.WriteLine("CLR Version: " + Environment.Version);
			sw.WriteLine();
			sw.WriteLine("Missing Parametervalues: ");
			sw.Write(_sbPara.ToString());
			sw.WriteLine();
			sw.WriteLine("-----------------------------------");
			sw.WriteLine();
			sw.WriteLine("Errors: ");
			sw.Write(_sbError.ToString());
			sw.WriteLine();
			sw.WriteLine("-----------------------------------");
			sw.WriteLine();
			sw.WriteLine("Results: ");
			sw.Write(_sb.ToString());
			sw.WriteLine();
			sw.WriteLine("-----------------------------------");
			sw.WriteLine();
			sw.WriteLine("EOF");
			sw.Close();
		}

		#endregion
	}
}

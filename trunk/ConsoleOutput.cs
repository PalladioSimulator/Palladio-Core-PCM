using System;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für ConsoleOutput.
	/// </summary>
	public class ConsoleOutput : Interfaces.IOutput
	{
		private System.Text.StringBuilder _sbPara;
		private System.Text.StringBuilder _sbError;

		public ConsoleOutput()
		{
			_sbPara = new System.Text.StringBuilder();
			_sbError = new System.Text.StringBuilder();
		}
		#region IOutput Member

		public void Init()
		{
			Console.WriteLine("IL Benchmark - (c) Winfried Klinker");
			Console.WriteLine("-----------------------------------");
			Console.WriteLine();
			Console.WriteLine("OS: " + Environment.OSVersion.ToString());
			Console.WriteLine("CLR Version: " + Environment.Version);
			Console.WriteLine("-----------------------------------");
			Console.WriteLine();
			Console.WriteLine("Results: ");

		}

		public void WriteResult(string Name, long Result)
		{
			Console.WriteLine(Name + " - " + Result );
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
			Console.WriteLine("-----------------------------------");
			Console.WriteLine();
			Console.WriteLine("Missing Parametervalues: ");
			Console.Write(_sbPara.ToString());
			Console.WriteLine();
			Console.WriteLine("-----------------------------------");
			Console.WriteLine();
			Console.WriteLine("Errors: ");
			Console.Write(_sbError.ToString());
			Console.WriteLine();
			Console.WriteLine("-----------------------------------");
			Console.WriteLine();
			Console.WriteLine("EOF");
		}

		#endregion
	}
}

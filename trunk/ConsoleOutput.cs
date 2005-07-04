using System;
using ILBenchmark.Common.Interfaces;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für ConsoleOutput.
	/// </summary>
	public class ConsoleOutput : MarshalByRefObject, IOutput
	{
		private System.Text.StringBuilder _sbPara;
		private System.Text.StringBuilder _sbError;
		private System.Text.StringBuilder _sbLine;

		public ConsoleOutput()
		{
			_sbPara = new System.Text.StringBuilder();
			_sbError = new System.Text.StringBuilder();
			_sbLine = new System.Text.StringBuilder();
		}
		#region IOutput Member

		public void Init(long StandartCount, long BCLCount)
		{
			Console.WriteLine("IL Benchmark - (c) Winfried Klinker");
			Console.WriteLine("-----------------------------------");
			Console.WriteLine();
			Console.WriteLine("Standart Benchmark Ausführung: " + StandartCount);
			Console.WriteLine("BCL Funktion Benchmark Ausführung: " + BCLCount);
			Console.WriteLine("-----------------------------------");
			Console.WriteLine();
			Console.WriteLine("Results: ");

		}
		public void WriteLine(string wert)
		{
			_sbLine.Append(wert);
			_sbLine.Append(Environment.NewLine);
		}
		public void WriteResult(string ID,string Name, ulong Result)
		{
			Console.WriteLine(Name + " - " + Result );
		}

		public void WriteMissingParameter(string ID,string Name)
		{
			_sbPara.Append(Name);
			_sbPara.Append(Environment.NewLine);
		}

		public void WriteSkip(string ID,string Name)
		{
			_sbError.Append("Error / Skipped: ");
			_sbError.Append(Name);
			_sbError.Append(Environment.NewLine);
		}
		public void WriteSysInformation(ISysInfo info)
		{
			Console.WriteLine("Operating System: " + info.OSName);
			Console.WriteLine("OS Version: " + info.OSVersion);
			Console.WriteLine("CLR Version: " + info.CLRVersion);
			Console.WriteLine("Processor: " + info.Processor);
			Console.WriteLine("Manufacturer: " + info.Manufacturer);
			Console.WriteLine("CPU Speed: " + info.CPUSpeed);
			Console.WriteLine("Physical Memory: " + info.PhysicalMemory);
			Console.WriteLine("Virtual Memory: " + info.VirtualMemory);
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
			Console.WriteLine(_sbLine.ToString());
			Console.WriteLine("EOF");
		}
		public void WriteSuccessList(string filename)
		{
		}
		#endregion
	}
}

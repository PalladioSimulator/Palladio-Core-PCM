using System;
using ILBenchmark.Common.Interfaces;

namespace ILBenchmark
{
	/// <summary>
	/// Zusammenfassung für ConsoleOutput.
	/// </summary>
	public class TXTFileOutput : MarshalByRefObject, IOutput
	{
		private System.Text.StringBuilder _sb;
		private System.Text.StringBuilder _sbPara;
		private System.Text.StringBuilder _sbError;
		private System.Text.StringBuilder _sbLine;
		private System.Text.StringBuilder _sbSysInfo;
		private System.Text.StringBuilder _sbCount;
		private IOutput _con;
		private System.Text.StringBuilder _sbSuccess;

		public TXTFileOutput()
		{
			_con = new ConsoleOutput();
		}

		#region IOutput Member

		public void Init(long StandartCount, long BCLCount)
		{
			_sb = new System.Text.StringBuilder();
			_sbPara = new System.Text.StringBuilder();
			_sbError = new System.Text.StringBuilder();
			_sbLine= new System.Text.StringBuilder();
			_sbSysInfo = new System.Text.StringBuilder();
			_sbSuccess = new System.Text.StringBuilder();
			_sbCount = new System.Text.StringBuilder();
			_sbCount.Append("Standart\t" + StandartCount);
			_sbCount.Append(Environment.NewLine);
			_sbCount.Append("BCL\t" + BCLCount);
			_con.Init(StandartCount,BCLCount);
		}
		public void WriteLine(string wert)
		{
			_sbLine.Append(wert);
			_sbLine.Append(Environment.NewLine);

		}
		public void WriteResult(string ID, string Name, ulong Result)
		{
			//Success ID schreiben, damit Mono nur die ausführt
			_sbSuccess.Append(ID);
			_sbSuccess.Append(Environment.NewLine);
			_sb.Append(ID);
			_sb.Append("\t");
			_sb.Append(Name);
			_sb.Append("\t");
			_sb.Append(Result);
			_sb.Append(Environment.NewLine);
			_con.WriteResult(ID, Name,Result);
		}

		public void WriteMissingParameter(string ID,string Name)
		{
			_sbPara.Append(ID);
			_sbPara.Append("\t");
			_sbPara.Append(Name);
			_sbPara.Append(Environment.NewLine);
			_con.WriteMissingParameter(ID,Name);
		}

		public void WriteSkip(string ID,string Name)
		{
			//_sbError.Append("Error: ");
			_sbError.Append(ID);
			_sbError.Append("\t");
			_sbError.Append(Name);
			_sbError.Append(Environment.NewLine);
			_con.WriteSkip(ID,Name);
		}

		public void WriteSysInformation(ISysInfo info)
		{
			byte[] salt = System.Text.Encoding.Default.GetBytes("geheim");
			string id = ILBenchmark.Common.Helper.ComputeHash(info.ToString(),"SHA1",salt);
			_sbSysInfo.Append("ID\t" + id);
			_sbSysInfo.Append(Environment.NewLine);
			_sbSysInfo.Append("OSName\t" + info.OSName);
			_sbSysInfo.Append(Environment.NewLine);
			_sbSysInfo.Append("OSVersion\t " + info.OSVersion);
			_sbSysInfo.Append(Environment.NewLine);
			_sbSysInfo.Append("CLRVersion\t" + info.CLRVersion);
			_sbSysInfo.Append(Environment.NewLine);
			_sbSysInfo.Append("Processor\t" + info.Processor);
			_sbSysInfo.Append(Environment.NewLine);
			_sbSysInfo.Append("Manufacturer\t" + info.Manufacturer);
			_sbSysInfo.Append(Environment.NewLine);
			_sbSysInfo.Append("CPUSpeed\t" + info.CPUSpeed);
			_sbSysInfo.Append(Environment.NewLine);
			_sbSysInfo.Append("PhysicalMemory\t" + info.PhysicalMemory);
			_sbSysInfo.Append(Environment.NewLine);
			_sbSysInfo.Append("VirtualMemory\t" + info.VirtualMemory);
		}

		public void Save()
		{
			Nini.Config.IniConfigSource conf = new Nini.Config.IniConfigSource("config.ini");

			System.IO.StreamWriter sw = new System.IO.StreamWriter(conf.Configs["Output"].GetString("File","Ausgabe.txt"),false);
			sw.WriteLine("[Header]");
			sw.WriteLine("IL Benchmark - (c) Winfried Klinker");
			sw.WriteLine("-----------------------------------");
			sw.WriteLine();
			sw.WriteLine("-----------------------------------");
			sw.WriteLine("[Count]");
			sw.Write(_sbCount.ToString());
			sw.WriteLine();
			sw.WriteLine("-----------------------------------");
			sw.WriteLine("[System]");
			sw.Write(_sbSysInfo.ToString());
			sw.WriteLine();
			sw.WriteLine("-----------------------------------");
			sw.WriteLine("[Results]");
			sw.Write(_sb.ToString());
			sw.WriteLine();
			sw.WriteLine("-----------------------------------");
			sw.WriteLine("[Parameter]");
			sw.Write(_sbPara.ToString());
			sw.WriteLine();
			sw.WriteLine("-----------------------------------");
			sw.WriteLine("[Errors]");
			sw.Write(_sbError.ToString());
			sw.WriteLine();
			sw.WriteLine("-----------------------------------");
			sw.WriteLine("[Other]");
			sw.Write(_sbLine.ToString());
			sw.WriteLine();
			sw.Close();
			_con.Save();

		
		}
		public void WriteSuccessList(string filename)
		{
			try 
			{
				System.IO.StreamWriter swSuccess = new System.IO.StreamWriter(filename);
				swSuccess.Write(_sbSuccess.ToString());
				swSuccess.Close();
			} 
			catch (Exception e)
			{
				System.Diagnostics.Debug.WriteLine(e.Message);
			}
		}
		#endregion
	}
}

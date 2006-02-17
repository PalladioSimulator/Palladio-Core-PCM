using System;
using System.IO;
using CilBenchmark.Container;
using CilBenchmark.Container.Interfaces;

namespace CilBenchmark
{
	/// <summary>
	/// The class is responsible for the output of the data that is collected
	/// </summary>
	public class Output : MarshalByRefObject, IOutput
	{
		private System.Text.StringBuilder stringBuilderResults;
		private System.Text.StringBuilder stringBuilderParameter;
		private System.Text.StringBuilder stringBuilderError;
		private System.Text.StringBuilder stringBuilderLine;
		private System.Text.StringBuilder stringBuilderSysInfo;
		private System.Text.StringBuilder stringBuilderCount;
		private System.Text.StringBuilder stringBuilderSuccess;
		private TextWriter outputWriter;
		private TextWriter directOutputWriter;

		/// <summary>
		/// Initialises the output destination
		/// </summary>
		/// <param name="textWriter">The object which is used as output.</param>
		/// <param name="directWriter">The object which is used as direct output.</param>
		public Output(TextWriter textWriter, TextWriter directWriter)
		{
			outputWriter = textWriter;
			directOutputWriter = directWriter;
		}

		#region IOutput Member
		
		/// <summary>
		/// Initialises the output destination
		/// </summary>
		/// <param name="benchmarkCount">The number of times, a benchmark is to be executed</param>
		/// <param name="parameterProfile">The parameterprofile used in this benchmark process</param>
		public void Init(long benchmarkCount, int parameterProfile)
		{
			stringBuilderResults = new System.Text.StringBuilder();
			stringBuilderParameter = new System.Text.StringBuilder();
			stringBuilderError = new System.Text.StringBuilder();
			stringBuilderLine= new System.Text.StringBuilder();
			stringBuilderSysInfo = new System.Text.StringBuilder();
			stringBuilderSuccess = new System.Text.StringBuilder();
			stringBuilderCount = new System.Text.StringBuilder();
			stringBuilderCount.Append("Count\t" + benchmarkCount);
			stringBuilderCount.Append(Environment.NewLine);
			stringBuilderCount.Append("Parameter\t" + parameterProfile);
		}
		/// <summary>
		/// Writes a line into the output destination
		/// </summary>
		public void WriteLine(string line)
		{
			stringBuilderLine.Append(line);
			stringBuilderLine.Append(Environment.NewLine);
			directOutputWriter.WriteLine(line);
		}
		/// <summary>
		/// The method writes the signature of the sucessfully executed method into the output destination
		/// </summary>
		/// <param name="signature">The signature (full methodname plus parameter types)</param>
		public void WriteSuccess(string signature)
		{
			stringBuilderSuccess.Append(signature);
			stringBuilderSuccess.Append(Environment.NewLine);
		}
		/// <summary>
		/// The method writes a result into the output destination
		/// </summary>
		/// <param name="signature">The signature (full methodname plus parameter types)</param>
		/// <param name="result">The result</param>
		[CLSCompliant(false)]
		public void WriteResult(string signature, ulong result)
		{
			stringBuilderResults.Append(signature.Trim());
			stringBuilderResults.Append("\t");
			stringBuilderResults.Append(result); //wk
			stringBuilderResults.Append(Environment.NewLine);
			directOutputWriter.WriteLine(signature + "\t" + result);
		}
		/// <summary>
		/// The method writes the signature of a skipped benchmark into the output
		/// </summary>
		/// <param name="signature">The signature (full methodname plus parameter types)</param>
		public void WriteMissingParameter(string signature)
		{
			stringBuilderParameter.Append(signature);
			stringBuilderParameter.Append(Environment.NewLine);
			directOutputWriter.WriteLine("Missing Parameter: " + signature);

		}
		/// <summary>
		/// The method writes the signature of a benchmark that caused an error into the output 
		/// </summary>
		/// <param name="signature">The signature (full methodname plus parameter types)</param>
		public void WriteError(string signature)
		{
			stringBuilderError.Append(signature);
			stringBuilderError.Append(Environment.NewLine);
			directOutputWriter.WriteLine("Error: " + signature);
		}
		/// <summary>
		/// The method write the information about the underlying system into the output
		/// </summary>
		/// <param name="info">The object containing the information about the underlying system</param>
		[CLSCompliant(false)]
		public void WriteSysInformation(ISysInfo info)
		{
			byte[] seed = System.Text.Encoding.Default.GetBytes("geheim");
			string id = Helper.ComputeHash(info.ToString(),"SHA1",seed);
			stringBuilderSysInfo.Append("ID\t" + id);
			stringBuilderSysInfo.Append(Environment.NewLine);
			stringBuilderSysInfo.Append("OSName\t" + info.OSName);
			stringBuilderSysInfo.Append(Environment.NewLine);
			stringBuilderSysInfo.Append("OSVersion\t " + info.OSVersion);
			stringBuilderSysInfo.Append(Environment.NewLine);
			stringBuilderSysInfo.Append("CLRVersion\t" + info.ClrVersion);
			stringBuilderSysInfo.Append(Environment.NewLine);
			stringBuilderSysInfo.Append("Processor\t" + info.Processor);
			stringBuilderSysInfo.Append(Environment.NewLine);
			stringBuilderSysInfo.Append("Manufacturer\t" + info.Manufacturer);
			stringBuilderSysInfo.Append(Environment.NewLine);
			stringBuilderSysInfo.Append("CPUSpeed\t" + info.CpuSpeed);
			stringBuilderSysInfo.Append(Environment.NewLine);
			stringBuilderSysInfo.Append("PhysicalMemory\t" + info.PhysicalMemory);
			stringBuilderSysInfo.Append(Environment.NewLine);
			stringBuilderSysInfo.Append("VirtualMemory\t" + info.VirtualMemory);
			directOutputWriter.WriteLine("System information:");
			directOutputWriter.WriteLine("ID\t" + id);
			directOutputWriter.WriteLine("OSName\t" + info.OSName);
			directOutputWriter.WriteLine("OSVersion\t " + info.OSVersion);
			directOutputWriter.WriteLine("CLRVersion\t" + info.ClrVersion);
			directOutputWriter.WriteLine("Processor\t" + info.Processor);
			directOutputWriter.WriteLine("Manufacturer\t" + info.Manufacturer);
			directOutputWriter.WriteLine("CPUSpeed\t" + info.CpuSpeed);
			directOutputWriter.WriteLine("PhysicalMemory\t" + info.PhysicalMemory);
			directOutputWriter.WriteLine("PhysicalMemory\t" + info.PhysicalMemory);
			directOutputWriter.WriteLine();


		}
		/// <summary>
		/// The method saves the bufferd outputs into the output destination
		/// </summary>
		public void Save()
		{
			outputWriter.WriteLine("[Header]");
			outputWriter.WriteLine("IL Benchmark - (c) Winfried Klinker");
			outputWriter.WriteLine("-----------------------------------");
			outputWriter.WriteLine();
			outputWriter.WriteLine("-----------------------------------");
			outputWriter.WriteLine("[Count]");
			outputWriter.Write(stringBuilderCount.ToString());
			outputWriter.WriteLine();
			outputWriter.WriteLine("-----------------------------------");
			outputWriter.WriteLine("[System]");
			outputWriter.Write(stringBuilderSysInfo.ToString());
			outputWriter.WriteLine();
			outputWriter.WriteLine("-----------------------------------");
			outputWriter.WriteLine("[Results]");
			outputWriter.Write(stringBuilderResults.ToString());
			outputWriter.WriteLine();
			outputWriter.WriteLine("-----------------------------------");
			outputWriter.WriteLine("[Parameter]");
			outputWriter.Write(stringBuilderParameter.ToString());
			outputWriter.WriteLine();
			outputWriter.WriteLine("-----------------------------------");
			outputWriter.WriteLine("[Errors]");
			outputWriter.Write(stringBuilderError.ToString());
			outputWriter.WriteLine();
			outputWriter.WriteLine("-----------------------------------");
			outputWriter.WriteLine("[Other]");
			outputWriter.Write(stringBuilderLine.ToString());
			outputWriter.WriteLine();
			outputWriter.Close();	
		}
		/// <summary>
		/// The method writes a file containing the signatures of all sucessfully executed benchmarks.
		/// </summary>
		/// <param name="fileName">The filename</param>
		public void WriteSuccessList(string fileName)
		{
			try 
			{
				System.IO.StreamWriter swSuccess = new System.IO.StreamWriter(fileName);
				swSuccess.Write(stringBuilderSuccess.ToString());
				swSuccess.Close();
			} 
			catch (System.IO.IOException e)
			{
				System.Diagnostics.Debug.WriteLine(e.Message);
			}
		}
		#endregion
	}
}

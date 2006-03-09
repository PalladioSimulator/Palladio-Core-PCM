using System;
using System.ComponentModel;
using System.Diagnostics;
using System.IO;

namespace WebAudioStore
{
	/// <summary>
	/// Zusammenfassung für OggEncoder.
	/// </summary>
	public class OggEncoder : IEncoder
	{
		public const string WORKINGDIR = @"F:\";
		public const string TEMP_FILENAME_BASE ="temp";
		public const string TEMP_FILENAME_MP3 = TEMP_FILENAME_BASE + ".mp3";
		public const string TEMP_FILENAME_WAV = TEMP_FILENAME_BASE + ".wav";
		public const string TEMP_FILENAME_OGG = TEMP_FILENAME_BASE + ".ogg";
		
		public OggEncoder()
		{
			//
			// TODO: Fügen Sie hier die Konstruktorlogik hinzu
			//
		}
		#region IEncoder Member

		const int ERROR_FILE_NOT_FOUND = 2;
		const int ERROR_ACCESS_DENIED = 5;


		public string GetEncodedFileName(string fileName)
		{
			return fileName.Substring(0,fileName.Length-3)+"ogg";
		}

		/// <summary>
		/// Encodes the file with the given fileName from a WAV to OGG
		/// by starting an external process (oggenc2.exe).
		/// </summary>
		public byte[] EncodeFile(byte[] fileContent)
		{
			CallLogger.OnCall("IEncoder", this.GetType().GetMethod("EncodeFile"));
			WriteMp3ToDisk(fileContent);
			Mp32Wav();
			ExecuteEncoder();
			byte[] buffer = ReadEncodedFileFromDisk();
			CallLogger.OnReturn();
			return buffer;
		}

		public void WriteMp3ToDisk(byte[] fileContent)
		{
			CallLogger.OnCall("IEncoder", this.GetType().GetMethod("WriteMp3ToDisk"));
			using(FileStream fs = new FileStream(WORKINGDIR + TEMP_FILENAME_MP3,FileMode.Create))
			{
				fs.Write(fileContent,0,fileContent.Length);
			}
			CallLogger.OnReturn();
		}

		public void Mp32Wav()
		{
			CallLogger.OnCall("IEncoder", this.GetType().GetMethod("Mp32Wav"));
			Process myProcess = new Process();
	
			// configure process
			ProcessStartInfo pInfo = 
				new ProcessStartInfo(WORKINGDIR + "lame.exe");
			pInfo.WorkingDirectory = WORKINGDIR;
			pInfo.Arguments = "--decode "+WORKINGDIR+TEMP_FILENAME_MP3+" "+TEMP_FILENAME_WAV;
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
			CallLogger.OnReturn();
		}

		public void ExecuteEncoder()
		{
			CallLogger.OnCall("IEncoder", this.GetType().GetMethod("ExecuteEncoder"));

			Process myProcess = new Process();
	
			// configure process
			ProcessStartInfo pInfo = 
				new ProcessStartInfo(WORKINGDIR+"oggenc2.exe");
			pInfo.WorkingDirectory = WORKINGDIR;
			pInfo.Arguments = WORKINGDIR+TEMP_FILENAME_WAV;
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
			CallLogger.OnReturn();
		}

		public byte[] ReadEncodedFileFromDisk()
		{
			CallLogger.OnCall("IEncoder", this.GetType().GetMethod("ReadEncodedFileFromDisk"));
			byte[] encodedFileContent = null;
			using(FileStream fs = new FileStream(WORKINGDIR+TEMP_FILENAME_OGG,FileMode.Open))
			{
				int encodedFileLength = (int)fs.Length;
				encodedFileContent = new byte[encodedFileLength];
				fs.Read(encodedFileContent,0,encodedFileLength);
			}
			CallLogger.OnReturn();
			return encodedFileContent;
		}
		#endregion
	}
}

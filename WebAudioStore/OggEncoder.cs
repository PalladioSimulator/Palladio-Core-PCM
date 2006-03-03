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
			string tempFileName = WriteFileToDisk(fileContent);

			ExecuteEncoder(tempFileName);

			return ReadEncodedFileFromDisk(tempFileName);
		}

		private static string WriteFileToDisk(byte[] fileContent)
		{
			string tempFileName = @"C:\Inetpub\wwwroot\WebAudioStore\Data\temp.wav";
			using(FileStream fs = new FileStream(tempFileName,FileMode.Create))
			{
				fs.Write(fileContent,0,fileContent.Length);
			}
			return tempFileName;
		}

		private static void ExecuteEncoder(string tempFileName)
		{
			Process myProcess = new Process();
	
			// configure process
			ProcessStartInfo pInfo = 
				new ProcessStartInfo("C:\\Inetpub\\wwwroot\\WebAudioStore\\Data\\oggenc2.exe");
			pInfo.WorkingDirectory = "C:\\Inetpub\\wwwroot\\WebAudioStore\\Data";
			pInfo.Arguments = tempFileName;
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
		}

		private static byte[] ReadEncodedFileFromDisk(string tempFileName)
		{
			string encodedFileName = tempFileName.Substring(0,tempFileName.Length-3)+"ogg";
			byte[] encodedFileContent = null;
			using(FileStream fs = new FileStream(encodedFileName,FileMode.Open))
			{
				int encodedFileLength = (int)fs.Length;
				encodedFileContent = new byte[encodedFileLength];
				fs.Read(encodedFileContent,0,encodedFileLength);
			}
			return encodedFileContent;
		}
		#endregion
	}
}

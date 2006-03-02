using System;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.IO;
using System.Web;

namespace WebAudioStore
{
	/// <summary>
	/// Zusammenfassung für OggEncAdapter.
	/// </summary>
	public class OggEncAdapter : IAudioDB
	{
		const int ERROR_FILE_NOT_FOUND = 2;
		const int ERROR_ACCESS_DENIED = 5;

		IAudioDB audioDB; // required interface
		int encodedFileLength;

		public OggEncAdapter(IAudioDB audioDB)
		{
			this.audioDB = audioDB;
		}

		public int InsertAudioFile(byte[] fileContent)
		{
			string tempFileName = @"C:\Inetpub\wwwroot\WebAudioStore\Data\temp.wav";
			using(FileStream fs = new FileStream(tempFileName,FileMode.Create))
			{
				fs.Write(fileContent,0,fileContent.Length);
			}

			// do encoding, write file to disk
			EncodeFile(tempFileName);

			// read encoded file from disk
			string encodedFileName = tempFileName.Substring(0,tempFileName.Length-3);
			encodedFileName+="ogg";
			byte[] encodedFileContent = null;
			using(FileStream fs = new FileStream(encodedFileName,FileMode.Open))
			{
				encodedFileLength = (int)fs.Length;
				encodedFileContent = new byte[encodedFileLength];
				fs.Read(encodedFileContent,0,encodedFileLength);
			}

				// store encoded file to database
			return this.audioDB.InsertAudioFile(encodedFileContent);	
		}

		public void InsertAudioInfo(int fileID, string fileName, int fileSize)
		{
			string encodedFileName = fileName.Substring(0,fileName.Length-3);
			encodedFileName+="ogg";
			this.audioDB.InsertAudioInfo(fileID, encodedFileName, encodedFileLength);
		}

		public DataSet GetAudioFileInfo()
		{
			return this.audioDB.GetAudioFileInfo();
		}

		/// <summary>
		/// Encodes the file with the given fileName from a WAV to OGG
		/// by starting an external process (oggenc2.exe).
		/// </summary>
		private void EncodeFile(string fileName)
		{
			Process myProcess = new Process();
			
			// configure process
			ProcessStartInfo pInfo = 
				new ProcessStartInfo("C:\\Inetpub\\wwwroot\\WebAudioStore\\Data\\oggenc2.exe");
			pInfo.WorkingDirectory = "C:\\Inetpub\\wwwroot\\WebAudioStore\\Data";
			pInfo.Arguments = fileName;
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

	}
}

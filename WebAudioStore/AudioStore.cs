using System;
using System.Data;
using System.IO;
using System.Web;

namespace WebAudioStore
{
	/// <summary>
	/// Zusammenfassung für AudioStore.
	/// </summary>
	public class AudioStore : IAudioStore
	{
		protected IAudioDB audioDB;
		private int filesUploaded = 0;

		public int FilesUploaded
		{
			get { return filesUploaded; }
		}

		public AudioStore(IAudioDB audioDB)
		{
			this.audioDB = audioDB;
		}

		public DataView GetUploadedFileView()
		{
			CallLogger.OnCall("IAudioStore", this.GetType().GetMethod("GetUploadedFileView"));

			DataSet ds = audioDB.GetAudioFileInfo(); // read AudioFileInfo table from database
			
			CallLogger.OnReturn();
			return ds.Tables["ImageTable"].DefaultView; // add table to webpage			
		}

		/// <summary>
		/// Uploads Files to DB
		/// </summary>
		public string HandleUpload(HttpPostedFile postedFile)
		{
			CallLogger.OnCall("IAudioStore", this.GetType().GetMethod("HandleUpload"));

			byte[] postedFileContent = new byte[postedFile.ContentLength];

			CallLogger.OnCall("InputStream", postedFile.InputStream.GetType().GetMethod("Read"));
			postedFile.InputStream.Read(postedFileContent,0,postedFileContent.Length);
			CallLogger.OnReturn();

			string postedFileName = Path.GetFileName(postedFile.FileName);

			int id = this.audioDB.InsertAudioFile(postedFileContent);	
			this.audioDB.InsertAudioInfo(id, postedFileName, postedFileContent.Length);
			
			filesUploaded++;

			CallLogger.OnReturn();
			return postedFileName;
		}

		public void FinalizeUpload()
		{
			this.audioDB.FinalizeUpload();
		}
	}
}

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
			DataSet ds = audioDB.GetAudioFileInfo(); // read AudioFileInfo table from database
			return ds.Tables["ImageTable"].DefaultView; // add table to webpage			
		}

		/// <summary>
		/// Uploads Files to DB
		/// </summary>
		public string HandleUpload(HttpPostedFile postedFile)
		{
			byte[] postedFileContent = new byte[postedFile.ContentLength];
			postedFile.InputStream.Read(postedFileContent,0,postedFileContent.Length);

			string postedFileName = Path.GetFileName(postedFile.FileName);

			int id = this.audioDB.InsertAudioFile(postedFileContent);	
			this.audioDB.InsertAudioInfo(id, postedFileName, postedFileContent.Length);
			
			filesUploaded++;
			return postedFileName;
		}
	}
}

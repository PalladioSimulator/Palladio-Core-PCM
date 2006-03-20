using System.Data;
using System.Web;

namespace WebAudioStore
{
	public interface IAudioStore
	{
		string Identifier { get; set; }
		int FilesUploaded { get; }
		string HandleUpload(HttpPostedFile postedFile);
		DataView GetUploadedFileView();
		void FinalizeUpload();
	}
}
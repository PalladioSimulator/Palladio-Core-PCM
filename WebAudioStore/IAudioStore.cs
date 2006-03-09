using System.Data;
using System.Web;

namespace WebAudioStore
{
	public interface IAudioStore
	{
		int FilesUploaded { get; }
		string HandleUpload(HttpPostedFile postedFile);
		DataView GetUploadedFileView();
		void FinalizeUpload();
	}
}
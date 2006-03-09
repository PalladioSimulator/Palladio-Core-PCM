using System.Data;

namespace WebAudioStore
{
	public interface IAudioDB
	{
		int InsertAudioFile(byte[] fileContent);
		void InsertAudioInfo(int fileID, string fileName, int fileSize);
		DataSet GetAudioFileInfo();
		void FinalizeUpload();
	}
}
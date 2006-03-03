using System.Data;

namespace WebAudioStore
{
	/// <summary>
	/// Zusammenfassung für OggEncAdapter.
	/// </summary>
	public class EncodingAdapter : IAudioDB
	{
		IAudioDB audioDB; // required interface
		IEncoder encoder; // required interface
		int encodedFileLength;

		public EncodingAdapter(IAudioDB audioDB, IEncoder encoder)
		{
			this.audioDB = audioDB;
			this.encoder = encoder;
		}

		public int InsertAudioFile(byte[] fileContent)
		{
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("InsertAudioFile"));

			// encode file
			byte[] encodedFileContent = encoder.EncodeFile(fileContent);

		    // save file lenght for AudioFileInfo-Table
			encodedFileLength = encodedFileContent.Length;

			CallLogger.OnReturn();

			// store encoded file to database
			return this.audioDB.InsertAudioFile(encodedFileContent);	
		}

		public void InsertAudioInfo(int fileID, string fileName, int fileSize)
		{
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("InsertAudioInfo"));
			string encodedFileName = encoder.GetEncodedFileName(fileName);
			this.audioDB.InsertAudioInfo(fileID, encodedFileName, encodedFileLength);

			CallLogger.OnReturn();
		}

		public DataSet GetAudioFileInfo()
		{
			CallLogger.OnCall("IAudioDB", this.GetType().GetMethod("GetAudioFileInfo"));
			CallLogger.OnReturn();
			return this.audioDB.GetAudioFileInfo();
		}
	}
}

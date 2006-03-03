namespace WebAudioStore
{
	public interface IEncoder
	{
		/// <summary>
		/// Encodes the file with the given fileName from a WAV to OGG
		/// by starting an external process (oggenc2.exe).
		/// </summary>
		byte[] EncodeFile(byte[] fileContent);
		string GetEncodedFileName(string fileName);
	}
}
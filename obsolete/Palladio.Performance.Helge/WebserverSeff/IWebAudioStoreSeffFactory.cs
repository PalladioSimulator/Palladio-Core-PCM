using System;
using Palladio.FiniteStateMachines;

namespace Palladio.Performance.WebserverSeff
{
	/// <summary>
	/// Zusammenfassung für WebAudioStoreSeffFactory.
	/// </summary>
	public interface IWebAudioStoreSeffFactory
	{
		IFiniteStateMachine CreateSeff_AudioStore_GetUploadedFileView();
		IFiniteStateMachine CreateSeff_AudioStore_HandleUpload();
		IFiniteStateMachine CreateSeff_AudioStore_FinalizeUpload();
		IFiniteStateMachine CreateSeff_OggEncoder_EncodeFile();
		IFiniteStateMachine CreateSeff_WebGUI_Upload_ServerClick();
		IFiniteStateMachine CreateSeff_EncodingAdapter_InsertAudioFile();
		IFiniteStateMachine CreateSeff_EncodingAdapter_InsertAudioInfo();
		IFiniteStateMachine CreateSeff_EncodingAdapter_FinalizeUpload();
		IFiniteStateMachine CreateSeff_DBAdapter_InsertAudioFile();
		IFiniteStateMachine CreateSeff_DBAdapter_InsertAudioInfo();
		IFiniteStateMachine CreateSeff_DBAdapter_GetAudioFileInfo();
		IFiniteStateMachine CreateSeff_BufferingDBAdapter_GetAudioFileInfo();
		IFiniteStateMachine CreateSeff_BufferingDBAdapter_FinalizeUpload();
	}
}

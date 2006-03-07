using System;
using Palladio.FiniteStateMachines;

namespace WebserverSeff
{
	/// <summary>
	/// Zusammenfassung für WebAudioStoreSeffFactory.
	/// </summary>
	public interface IWebAudioStoreSeffFactory
	{
		IFiniteStateMachine CreateSeff_AudioStore_GetUploadedFileView();
		IFiniteStateMachine CreateSeff_AudioStore_HandleUpload();
		IFiniteStateMachine CreateSeff_EncodingAdapter_InsertAudioFile();
		IFiniteStateMachine CreateSeff_EncodingAdapter_InsertAudioInfo();
		IFiniteStateMachine CreateSeff_OggEncoder_EncodeFile();
		IFiniteStateMachine CreateSeff_WebGUI_Upload_ServerClick();
	}
}

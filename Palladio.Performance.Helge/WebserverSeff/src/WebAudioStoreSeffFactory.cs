using System;
using Palladio.FiniteStateMachines;
using Palladio.Performance.WebserverSeff;

namespace Palladio.Performance.WebserverSeff
{
	/// <summary>
	/// Zusammenfassung für WebAudioStoreSeffFactory.
	/// </summary>
	public class WebAudioStoreSeffFactory : IWebAudioStoreSeffFactory
	{
		public WebAudioStoreSeffFactory()
		{
		}

		public IFiniteStateMachine CreateSeff_AudioStore_GetUploadedFileView()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(101, 102);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(101);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(102)};
			
			WebserverModelHelper.AddTransition(103, ref fsm, 101, 102, "IAudioDB_GetAudioFileInfo");			
			return fsm;
		}

		public IFiniteStateMachine CreateSeff_AudioStore_HandleUpload()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(201, 202, 203, 204);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(201);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(204)};
			
			WebserverModelHelper.AddTransition(205, ref fsm, 201, 202, "InputStream_Read");			
			WebserverModelHelper.AddTransition(206, ref fsm, 202, 203, "IAudioDB_InsertAudioFile");			
			WebserverModelHelper.AddTransition(207, ref fsm, 203, 204, "IAudioDB_InsertAudioInfo");			
			return fsm;
		}

		public IFiniteStateMachine CreateSeff_EncodingAdapter_InsertAudioFile()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(301, 302, 303);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(301);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(303)};
			
			WebserverModelHelper.AddTransition(304, ref fsm, 301, 302, "IEncoder_EncodeFile");			
			WebserverModelHelper.AddTransition(305, ref fsm, 302, 303, "IAudioDB_InsertAudioFile");			
			return fsm;
		}

		public IFiniteStateMachine CreateSeff_EncodingAdapter_InsertAudioInfo()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(401, 402);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(401);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(402)};
			
			WebserverModelHelper.AddTransition(403, ref fsm, 401, 402, "IAudioDB_InsertAudioInfo");			
			return fsm;
		}

		public IFiniteStateMachine CreateSeff_OggEncoder_EncodeFile()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(501, 502, 503, 504, 505);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(501);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(505)};
			
			WebserverModelHelper.AddTransition(505, ref fsm, 501, 502, "IEncoder_WriteMp3ToDisk");			
			WebserverModelHelper.AddTransition(506, ref fsm, 502, 503, "IEncoder_Mp32Wav");			
			WebserverModelHelper.AddTransition(507, ref fsm, 503, 504, "IEncoder_ExecuteEncoder");			
			WebserverModelHelper.AddTransition(508, ref fsm, 504, 505, "IEncoder_ReadEncodedFileFromDisk");			
			return fsm;
		}

		public IFiniteStateMachine CreateSeff_WebGUI_Upload_ServerClick()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(601);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(601);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(601)};
			
			WebserverModelHelper.AddTransition(602, ref fsm, 601, 601, "IAudioStore_HandleUpload");			
			return fsm;
		}
	}
}

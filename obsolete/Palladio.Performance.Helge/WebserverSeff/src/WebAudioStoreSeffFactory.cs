using Palladio.FiniteStateMachines;

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

		//**********
		//AudioStore
		//**********
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


		public IFiniteStateMachine CreateSeff_AudioStore_FinalizeUpload()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(701);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(701);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(701)};
			
			WebserverModelHelper.AddTransition(702, ref fsm, 701, 701, "IAudioDB_FinalizeUpload");			
			return fsm;
		}



		//**********
		//OggEncoder
		//**********
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



		//******
		//WebGUI
		//******
		public IFiniteStateMachine CreateSeff_WebGUI_Upload_ServerClick()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(601,602);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(601);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(602)};
			
			WebserverModelHelper.AddTransition(603, ref fsm, 601, 601, "IAudioStore_HandleUpload");			
			WebserverModelHelper.AddTransition(604, ref fsm, 601, 602, "IAudioStore_FinalizeUpload");
			return fsm;
		}


		
		//***************
		//EncodingAdapter
		//***************
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
		public IFiniteStateMachine CreateSeff_EncodingAdapter_FinalizeUpload()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(801);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(801);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(801)};
			
			WebserverModelHelper.AddTransition(802, ref fsm, 801, 801, "IAudioDB_FinalizeUpload");			
			return fsm;
		}



		//*********
		//DBAdapter
		//*********
		public IFiniteStateMachine CreateSeff_DBAdapter_InsertAudioFile()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(901,902,903,904,905,906,907);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(901);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(907)};
			
			WebserverModelHelper.AddTransition(908, ref fsm, 901, 902, "IConnection_Open");
			WebserverModelHelper.AddTransition(909, ref fsm, 902, 903, "ICommand_ExecuteNonQuery");
			WebserverModelHelper.AddTransition(910, ref fsm, 903, 904, "ICommand_ExecuteReader");
			WebserverModelHelper.AddTransition(911, ref fsm, 904, 905, "IDataReader_Read");
			WebserverModelHelper.AddTransition(912, ref fsm, 905, 906, "IDataReader_Close");
			WebserverModelHelper.AddTransition(913, ref fsm, 906, 907, "IConnection_Close");
			return fsm;
		}

		public IFiniteStateMachine CreateSeff_DBAdapter_InsertAudioInfo()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(1001,1002,1003,1004);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(1001);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(1004)};
			
			WebserverModelHelper.AddTransition(1005, ref fsm, 1001, 1002, "IConnection_Open");
			WebserverModelHelper.AddTransition(1006, ref fsm, 1002, 1003, "ICommand.ExecuteNonQuery");
			WebserverModelHelper.AddTransition(1007, ref fsm, 1003, 1004, "IConnection_Close");
			return fsm;
		}

		public IFiniteStateMachine CreateSeff_DBAdapter_GetAudioFileInfo()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(1101,1102,1103,1104,1105,1106);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(1101);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(1106)};
			
			WebserverModelHelper.AddTransition(1107, ref fsm, 1101, 1102, "IConnection_Open");
			WebserverModelHelper.AddTransition(1108, ref fsm, 1102, 1103, "ICommand_ExecuteReader");
			WebserverModelHelper.AddTransition(1109, ref fsm, 1103, 1104, "IDataReader_Read");
			WebserverModelHelper.AddTransition(1110, ref fsm, 1104, 1105, "IDataReader_Close");
			WebserverModelHelper.AddTransition(1111, ref fsm, 1105, 1106, "IConnection_Close");
			return fsm;
		}



		//*******************
		//BufferingdDBAdapter
		//*******************
		public IFiniteStateMachine CreateSeff_BufferingDBAdapter_GetAudioFileInfo()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(1201,1202,1203,1204,1205,1206);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(1201);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(1206)};
			
			WebserverModelHelper.AddTransition(1207, ref fsm, 1201, 1202, "IConnection_Open");
			WebserverModelHelper.AddTransition(1208, ref fsm, 1202, 1203, "ICommand_ExecuteReader");
			WebserverModelHelper.AddTransition(1209, ref fsm, 1203, 1204, "IDataReader_Read");
			WebserverModelHelper.AddTransition(1210, ref fsm, 1204, 1205, "IDataReader_Close");
			WebserverModelHelper.AddTransition(1212, ref fsm, 1205, 1206, "IConnection_Close");
			return fsm;
		}

		public IFiniteStateMachine CreateSeff_BufferingDBAdapter_FinalizeUpload()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(1301,1302,1303,1304,1305,1306,1307);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(1301);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(1307)};
			
			WebserverModelHelper.AddTransition(1308, ref fsm, 1301, 1302, "IConnection_Open");
			WebserverModelHelper.AddTransition(1309, ref fsm, 1302, 1303, "ICommand_ExecuteReader");
			WebserverModelHelper.AddTransition(1310, ref fsm, 1303, 1304, "IDataReader_Read");
			WebserverModelHelper.AddTransition(1311, ref fsm, 1304, 1305, "IDataReader_Close");
			WebserverModelHelper.AddTransition(1312, ref fsm, 1305, 1306, "ICommand_ExecuteNonQuery");
			WebserverModelHelper.AddTransition(1313, ref fsm, 1306, 1305, "ICommand_ExecuteNonQuery");
			WebserverModelHelper.AddTransition(1314, ref fsm, 1305, 1307, "IConnection_Close");
			return fsm;
		}
	}
}

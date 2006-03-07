using Palladio.FiniteStateMachines;

namespace Palladio.Performance.WebserverSeff
{
	/// <summary>
	/// Factory for the creation of all required Seffs of the Webserver.
	/// This factory was created due to the missing save and load operations 
	/// for the Seffs.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: WebserverSeffFactory.cs,v $
	/// Revision 1.2  2005/10/11 22:05:14  helgeh
	/// - Added NUnit project and NDoc documentation.
	/// - fixed a bug in AdjustSamplingRate
	///
	/// Revision 1.1  2005/08/12 07:59:25  helgeh
	/// Initial impot after refactoring.
	///
	/// Math:
	/// - Added DiscretePDFunction.
	/// - Added Fast Fourier Transformation and FourierFunction.
	/// - Changed operations of DiscreteFunction. The operations are independent of the sampling rate. For a probability density  function the sum of function values is a value in [0,1].
	/// - Added to interface IDiscreteFunction: Sum,ExpandDomainPo2, Crop, NumberOfNullValues, AdjustSamplingRate,  FunctionWithNValues, ToFile, ValueAt, DismissValuesSmalerThanN, ValueOf, MaximumDataValue
	/// - Altered MEthods: ExpandDomain, Scale, GetScaled, Convolution, Add
	///
	/// FSMTransformer:
	/// - Method SEFFValidity added.
	/// - The Method FSMWithIntermediateState now returns a FSM, where all time consumption is contained by the input symbols of the  transitions.
	///
	/// WebserverSeffFactory:
	/// - All service effect automaton are now IFiniteStateMachines. No use of the PAlladio.ComponentModel.
	///
	/// WebserverAnalyser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// RegExASTVisitor:
	/// - There are now two visitors. One for the calculation in time domain and one for the calculation in frequency domain.
	///
	/// RegularExpressions:
	/// - No changes.
	///
	/// XmlSeffParser:
	/// - Data class for configuration added.
	/// - ConfigReader added.
	///
	/// PerformanceCalculator:
	/// - Added interface IPerformanceCalculator. Added CalculatorFactory.
	///
	/// Unit Tests added.
	/// Updated documentation.
	///
	/// 
	/// </pre>
	/// </remarks>
	public class WebserverSeffFactory : IWebserverSeffFactory
	{
		#region IWebserverSeffFactory Member


		/// <summary>
		/// Creates the service effect automaton for the DefaultDispatcher.Start() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultDispatcher_Start()
		{
				IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
				IState[] states = WebserverModelHelper.CreateStates(101, 102, 103, 104, 105, 106);
				fsm.AddStates(states);
				fsm.StartState = WebserverModelHelper.GetState(101);
				fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(105), WebserverModelHelper.GetState(106)};
				WebserverModelHelper.AddTransition(107, ref fsm, 101, 102, "IWebserverMonitor_WriteLogEntry");
				WebserverModelHelper.AddTransition(108, ref fsm, 102, 103, "IWebserverMonitor_WriteLogEntry");
				WebserverModelHelper.AddTransition(109, ref fsm, 103, 104, "IWebserverConfiguration_get_ListenIP");
				WebserverModelHelper.AddTransition(110, ref fsm, 104, 105, "IWebserverConfiguration_get_ListeningPorts");
				WebserverModelHelper.AddTransition(111, ref fsm, 105, 105, "IWebserverConfiguration_get_ListeningPorts");
				WebserverModelHelper.AddTransition(112, ref fsm, 105, 106, "IWebserverMonitor_WriteDebugMessage");

				return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DefaultDispatcher.Stop() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultDispatcher_Stop()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(201, 202, 203, 204);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(201);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(204)};
			WebserverModelHelper.AddTransition(205, ref fsm, 201, 202, "IPortListener_set_IsRunning");
			WebserverModelHelper.AddTransition(206, ref fsm, 202, 203, "IPortListener_get_Address");
			WebserverModelHelper.AddTransition(207, ref fsm, 203, 201, "IPortListener_get_Port");
			WebserverModelHelper.AddTransition(208, ref fsm, 201, 204, "IWebserverMonitor_WriteLogEntry");

			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DefaultDispatcher.StartListen() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultDispatcher_StartListen()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(301, 302, 303, 304, 305, 306, 307, 308);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(301);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(304)};
			
			WebserverModelHelper.AddTransition(309, ref fsm, 301, 302, "IWebserverConfiguration_get_ListenIP");
			WebserverModelHelper.AddTransition(310, ref fsm, 302, 303, "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(311, ref fsm, 303, 304, "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(312, ref fsm, 304, 305, "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(313, ref fsm, 305, 306, "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(314, ref fsm, 306, 307, "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(315, ref fsm, 307, 308, "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(316, ref fsm, 308, 306, "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(317, ref fsm, 308, 304, "IRequestParser_HandleRequest");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DynamicFileProvider.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DynamicFileProvider_HandleRequest()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(6101, 6102, 6103);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(6101);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(6103)};
			WebserverModelHelper.AddTransition(6104, ref fsm, 6101, 6102, "IWebserverMonitor_WriteLogEntry","IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(6105, ref fsm, 6102, 6103, "IHTTPRequestProcessor_HandleRequest", "IHTTPRequestProcessor_HandleRequest");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the BibTexProvider.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_BibTexProvider_HandleRequest()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(6201, 6202, 6203, 6204, 6205, 6206, 6207, 6208, 6209, 6210);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(6201);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(6210)};
			WebserverModelHelper.AddTransition(6211, ref fsm, 6201, 6202, "IBibTexDB_set_ConnectionString", "IBibTexDB_set_ConnectionString");
			WebserverModelHelper.AddTransition(6212, ref fsm, 6201, 6210, "IHTTPRequestProcessor_HandleRequest", "IHTTPRequestProcessor_HandleRequest");
			WebserverModelHelper.AddTransition(6213, ref fsm, 6202, 6203, "IBibTexDB_SearchAllEntries", "IBibTexDB_SearchAllEntries");
			WebserverModelHelper.AddTransition(6214, ref fsm, 6202, 6203, "IBibTexDB_Search", "IBibTexDB_Search");
			WebserverModelHelper.AddTransition(6215, ref fsm, 6203, 6207, "IWebserverMonitor_WriteDebugMessage", "IWebserverMonitor_WriteDebugMessage");
			WebserverModelHelper.AddTransition(6216, ref fsm, 6203, 6204, "IHTTPRequestProcessorTools_GetFileMimeTypeFor1", "IHTTPRequestProcessorTools_GetFileMimeTypeFor");
			WebserverModelHelper.AddTransition(6217, ref fsm, 6204, 6205, "IHTTPRequestProcessorTools_SendHTTPHeader1", "IHTTPRequestProcessorTools_SendHTTPHeader");
			WebserverModelHelper.AddTransition(6218, ref fsm, 6205, 6206, "IHTTPRequestProcessorTools_SendContentToClient1", "IHTTPRequestProcessorTools_SendContentToClient");
			WebserverModelHelper.AddTransition(6219, ref fsm, 6206, 6210, "IWebserverMonitor_WriteLogEntry", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(6220, ref fsm, 6207, 6208, "IHTTPRequestProcessorTools_GetFileMimeTypeFor2", "IHTTPRequestProcessorTools_GetFileMimeTypeFor");
			WebserverModelHelper.AddTransition(6221, ref fsm, 6208, 6209, "IHTTPRequestProcessorTools_SendHTTPHeader2", "IHTTPRequestProcessorTools_SendHTTPHeader");
			WebserverModelHelper.AddTransition(6222, ref fsm, 6209, 6210, "IHTTPRequestProcessorTools_SendContentToClient2", "IHTTPRequestProcessorTools_SendContentToClient");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the TemplateFileProviderHandleRequest() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_TemplateFileProvider_HandleRequest()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(6301, 6302, 6303, 6304, 6305, 6306, 6307, 6308, 6309);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(6301);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(6309)};
			WebserverModelHelper.AddTransition(6310, ref fsm, 6301, 6302, "IHTTPRequestProcessorTools_BuildCompletePath", "IHTTPRequestProcessorTools_BuildCompletePath");
			WebserverModelHelper.AddTransition(6311, ref fsm, 6301, 6309, "IHTTPRequestProcessor_HandleRequest1","IHTTPRequestProcessor_HandleRequest" );
			WebserverModelHelper.AddTransition(6312, ref fsm, 6302, 6309, "IHTTPRequestProcessor_HandleRequest2", "IHTTPRequestProcessor_HandleRequest");
			WebserverModelHelper.AddTransition(6313, ref fsm, 6302, 6303, "IWebserverMonitor_WriteLogEntry1", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(6314, ref fsm, 6303, 6304, "IHTTPRequestProcessorTools_GetFileMimeTypeFor", "IHTTPRequestProcessorTools_GetFileMimeTypeFor");
			WebserverModelHelper.AddTransition(6315, ref fsm, 6304, 6305, "IWebserverMonitor_WriteLogEntry2","IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(6316, ref fsm, 6305, 6306, "IHTTPRequestProcessorTools_OpenFile", "IHTTPRequestProcessorTools_OpenFile");
			WebserverModelHelper.AddTransition(6317, ref fsm, 6306, 6307, "IHTTPRequestProcessorTools_SendHTTPHeader", "IHTTPRequestProcessorTools_SendHTTPHeader");
			WebserverModelHelper.AddTransition(6318, ref fsm, 6307, 6308, "IHTTPRequestProcessorTools_SendContentToClient","IHTTPRequestProcessorTools_SendContentToClient" );
			WebserverModelHelper.AddTransition(6319, ref fsm, 6308, 6309, "IWebserverMonitor_WriteLogEntry3","IWebserverMonitor_WriteLogEntry3");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the StaticFileProvider.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_FileProvider_HandleRequest()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(6401, 6402, 6403, 6404, 6405, 6406, 6407, 6408, 6409, 6410);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(6401);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(6410)};
			WebserverModelHelper.AddTransition(6411, ref fsm, 6401, 6402, "IHTTPRequestProcessorTools_BuildCompletePath", "IHTTPRequestProcessorTools_BuildCompletePath");
//			WebserverModelHelper.AddTransition(6412, ref fsm, 6401, 6410, "IHTTPRequestProcessorTools_SendHTTPError", "IHTTPRequestProcessorTools_SendHTTPError");
			WebserverModelHelper.AddTransition(6413, ref fsm, 6402, 6410, "IHTTPRequestProcessorTools_SendHTTPError1", "IHTTPRequestProcessorTools_SendHTTPError");
			WebserverModelHelper.AddTransition(6414, ref fsm, 6402, 6403, "IWebserverConfiguration_get_DefaultFileNames", "IWebserverConfiguration_get_DefaultFileNames");
			WebserverModelHelper.AddTransition(6415, ref fsm, 6402, 6404, "IWebserverMonitor_WriteLogEntry1", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(6416, ref fsm, 6403, 6404, "IWebserverMonitor_WriteLogEntry2", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(6417, ref fsm, 6404, 6404, "IWebserverMonitor_WriteLogEntry3", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(6418, ref fsm, 6404, 6410, "IHTTPRequestProcessorTools_SendHTTPError2", "IHTTPRequestProcessorTools_SendHTTPError");
			WebserverModelHelper.AddTransition(6419, ref fsm, 6404, 6405, "IHTTPRequestProcessorTools_GetFileMimeTypeFor", "IHTTPRequestProcessorTools_GetFileMimeTypeFor");
			WebserverModelHelper.AddTransition(6420, ref fsm, 6405, 6406, "IWebserverMonitor_WriteLogEntry4", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(6421, ref fsm, 6406, 6407, "IHTTPRequestProcessorTools_OpenFile", "IHTTPRequestProcessorTools_OpenFile");
			WebserverModelHelper.AddTransition(6422, ref fsm, 6407, 6408, "IHTTPRequestProcessorTools_SendHTTPHeader", "IHTTPRequestProcessorTools_SendHTTPHeader");
			WebserverModelHelper.AddTransition(6423, ref fsm, 6408, 6409, "IHTTPRequestProcessorTools_SendContentDataToClient", "IHTTPRequestProcessorTools_SendContentDataToClient");
			WebserverModelHelper.AddTransition(6424, ref fsm, 6409, 6410, "IWebserverMonitor_WriteLogEntry5", "IWebserverMonitor_WriteLogEntry");
			
			return fsm;
		}


		/// <summary>
		/// Creates the service effect automaton for the HTTPRequestParser.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_HTTPRequestParser_HandleRequest()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(108101, 108102, 108103, 108104, 108105);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(108101);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(108105)};
			WebserverModelHelper.AddTransition(108106, ref fsm, 108101, 108102, "IWebserverMonitor_WriteLogEntry1", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(108107, ref fsm, 108102, 108103, "IWebserverMonitor_WriteLogEntry2", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(108108, ref fsm, 108103, 108104, "IWebserverMonitor_WriteLogEntry3", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(108109, ref fsm, 108104, 108104, "IWebserverMonitor_WriteLogEntry4", "IWebserverMonitor_WriteLogEntry");
			WebserverModelHelper.AddTransition(108110, ref fsm, 108102, 108105, "IRequestParser_HandleRequest1", "IRequestParser_HandleRequest");
			WebserverModelHelper.AddTransition(108111, ref fsm, 108103, 108105, "IRequestParser_HandleRequest2", "IRequestParser_HandleRequest");
			WebserverModelHelper.AddTransition(108112, ref fsm, 108104, 108105, "IRequestParser_HandleRequest3", "IRequestParser_HandleRequest");
			WebserverModelHelper.AddTransition(108113, ref fsm, 108104, 108105, "IHTTPRequestProcessor_HandleRequest", "IHTTPRequestProcessor_HandleRequest");

			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DefaultRequestParser.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultRequestParser_HandleRequest()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(8201, 8202);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(8201);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(8202)};
			WebserverModelHelper.AddTransition(8203, ref fsm, 8201, 8202, "IWebserverMonitor_WriteDebugMessage");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the WebserverMonitor.InitializeWriteAccess() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_WebserverMonitor_InitializeWriteAccess()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(4101, 4102, 4103);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(4101);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(4103)};
			WebserverModelHelper.AddTransition(4104, ref fsm, 4101, 4102, "IWebserverConfiguration_get_DebugFile");
			WebserverModelHelper.AddTransition(4105, ref fsm, 4102, 4103, "IWebserverConfiguration_get_LogFile");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.BuildCompletePath() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_BuildCompletePath()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(7101, 7102);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(7101);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(7102)};
			WebserverModelHelper.AddTransition(7103, ref fsm, 7101, 7102, "IWebserverConfiguration_get_DocumentRoot","IWebserverConfiguration_get_DocumentRoot");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.SendContentDataToClient() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_SendContentDataToClient()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(7201, 7202);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(7201);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(7202)};
			WebserverModelHelper.AddTransition(7203, ref fsm, 7201, 7202, "IWebserverMonitor_WriteDebugMessage");
			WebserverModelHelper.AddTransition(7204, ref fsm, 7201, 7202, "IWebserverMonitor_WriteLogEntry");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.SendContentToClient() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_SendContentToClient()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(7301, 7302);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(7301);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(7302)};
			WebserverModelHelper.AddTransition(7303, ref fsm, 7301, 7302, "IWebserverMonitor_WriteDebugMessage");
			WebserverModelHelper.AddTransition(7304, ref fsm, 7301, 7302, "IWebserverMonitor_WriteLogEntry");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.SendHTTPHeader() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_SendHTTPHeader()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(7401, 7402);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(7401);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(7402)};
			WebserverModelHelper.AddTransition(7403, ref fsm, 7401, 7402, "IWebserverMonitor_WriteDebugMessage");
			WebserverModelHelper.AddTransition(7404, ref fsm, 7401, 7402, "IWebserverMonitor_WriteLogEntry");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.SendHTTPError() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_SendHTTPError()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(7501, 7502, 7503, 7504);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(7501);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(7504)};
			WebserverModelHelper.AddTransition(7505, ref fsm, 7501, 7502, "IWebserverMonitor_WriteLogEntry1");
			WebserverModelHelper.AddTransition(7506, ref fsm, 7502, 7503, "IWebserverMonitor_WriteDebugMessage1");
			WebserverModelHelper.AddTransition(7507, ref fsm, 7502, 7503, "IWebserverMonitor_WriteLogEntry2");
			WebserverModelHelper.AddTransition(7508, ref fsm, 7503, 7504, "IWebserverMonitor_WriteDebugMessage2");
			WebserverModelHelper.AddTransition(7509, ref fsm, 7503, 7504, "IWebserverMonitor_WriteLogEntry3");
			
			return fsm;
		}

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.GetFileMimeTypeFor() service.
		/// </summary>
		/// <returns></returns>
		public   IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_GetFileMimeTypeFor()
		{
			IEditableFiniteStateMachine fsm = FSMFactory.CreateEmptyFSM();
			IState[] states = WebserverModelHelper.CreateStates(7601, 7602, 7603);
			fsm.AddStates(states);
			fsm.StartState = WebserverModelHelper.GetState(7601);
			fsm.FinalStates = new IState[] {WebserverModelHelper.GetState(7602), WebserverModelHelper.GetState(7603)};
			WebserverModelHelper.AddTransition(7604, ref fsm, 7601, 7602, "IWebserverConfiguration_GetMimeTypeFor");
			WebserverModelHelper.AddTransition(7605, ref fsm, 7602, 7603, "IWebserverConfiguration_get_DefaultMimeType");
			
			return fsm;
		}

		#endregion

	}
}
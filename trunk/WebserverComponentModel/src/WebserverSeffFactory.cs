using System.Collections;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.WebserverComponentModel
{
	/// <summary>
	/// Factory for the creation of all required Seffs of the Webserver.
	/// This factory was created due to the missing save and load operations 
	/// for the Seffs.
	/// 
	/// </summary>
	public class WebserverSeffFactory : WebserverModelHelper
	{
		#region Generated

		public static IService CreateService_DefaultDispatcher_Start()
		{
			IInterfaceModel iModel_IDispatcher = WebserverInterfaceFactory.CreateIDispatcher();
			return CreateService(iModel_IDispatcher, "Start");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultDispatcher_Start()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);
			IService service_IWebserverMonitor_WriteDebugMessage = CreateService(iModel_IWebserverMonitor, "WriteDebugMessage");
			methodHash["service_IWebserverMonitor_WriteDebugMessage"] = service_IWebserverMonitor_WriteDebugMessage;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteDebugMessage);
			IInterfaceModel iModel_IWebserverConfiguration = WebserverInterfaceFactory.CreateIWebserverConfiguration();
			IService service_IWebserverConfiguration_get_ListeningPorts = CreateService(iModel_IWebserverConfiguration, "get_ListeningPorts");
			methodHash["service_IWebserverConfiguration_get_ListeningPorts"] = service_IWebserverConfiguration_get_ListeningPorts;
			seff.SignatureList.AddSignatures(service_IWebserverConfiguration_get_ListeningPorts);
			IService service_IWebserverConfiguration_get_ListenIP = CreateService(iModel_IWebserverConfiguration, "get_ListenIP");
			methodHash["service_IWebserverConfiguration_get_ListenIP"] = service_IWebserverConfiguration_get_ListenIP;
			seff.SignatureList.AddSignatures(service_IWebserverConfiguration_get_ListenIP);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(101, 102, 103, 104, 105, 106);
			fsm.AddStates(states);
			fsm.StartState = GetState(101);
			fsm.FinalStates = new IState[] {GetState(105), GetState(106)};
			AddTransition(107, ref fsm, 101, 102, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(108, ref fsm, 102, 103, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(109, ref fsm, 103, 104, methodHash["service_IWebserverConfiguration_get_ListenIP"]);
			AddTransition(110, ref fsm, 104, 105, methodHash["service_IWebserverConfiguration_get_ListeningPorts"]);
			AddTransition(111, ref fsm, 105, 105, methodHash["service_IWebserverConfiguration_get_ListeningPorts"]);
			AddTransition(112, ref fsm, 105, 106, methodHash["service_IWebserverMonitor_WriteDebugMessage"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DefaultDispatcher_Stop()
		{
			IInterfaceModel iModel_IDispatcher = WebserverInterfaceFactory.CreateIDispatcher();
			return CreateService(iModel_IDispatcher, "Stop");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultDispatcher_Stop()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IPortListener = WebserverInterfaceFactory.CreateIPortListener();
			IService service_IPortListener_set_IsRunning = CreateService(iModel_IPortListener, "set_IsRunning");
			methodHash["service_IPortListener_set_IsRunning"] = service_IPortListener_set_IsRunning;
			seff.SignatureList.AddSignatures(service_IPortListener_set_IsRunning);
			IService service_IPortListener_get_Address = CreateService(iModel_IPortListener, "get_Address");
			methodHash["service_IPortListener_get_Address"] = service_IPortListener_get_Address;
			seff.SignatureList.AddSignatures(service_IPortListener_get_Address);
			IService service_IPortListener_get_Port = CreateService(iModel_IPortListener, "get_Port");
			methodHash["service_IPortListener_get_Port"] = service_IPortListener_get_Port;
			seff.SignatureList.AddSignatures(service_IPortListener_get_Port);
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(201, 202, 203, 204);
			fsm.AddStates(states);
			fsm.StartState = GetState(201);
			fsm.FinalStates = new IState[] {GetState(204)};
			AddTransition(205, ref fsm, 201, 202, methodHash["service_IPortListener_set_IsRunning"]);
			AddTransition(206, ref fsm, 202, 203, methodHash["service_IPortListener_get_Address"]);
			AddTransition(207, ref fsm, 203, 201, methodHash["service_IPortListener_get_Port"]);
			AddTransition(208, ref fsm, 201, 204, methodHash["service_IWebserverMonitor_WriteLogEntry"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DefaultDispatcher_StartListen()
		{
			IInterfaceModel iModel_IPortListener = WebserverInterfaceFactory.CreateIPortListener();
			return CreateService(iModel_IPortListener, "StartListen");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultDispatcher_StartListen()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverConfiguration = WebserverInterfaceFactory.CreateIWebserverConfiguration();
			IService service_IWebserverConfiguration_get_ListenIP = CreateService(iModel_IWebserverConfiguration, "get_ListenIP");
			methodHash["service_IWebserverConfiguration_get_ListenIP"] = service_IWebserverConfiguration_get_ListenIP;
			seff.SignatureList.AddSignatures(service_IWebserverConfiguration_get_ListenIP);
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);
			IService service_IWebserverMonitor_WriteDebugMessage = CreateService(iModel_IWebserverMonitor, "WriteDebugMessage");
			methodHash["service_IWebserverMonitor_WriteDebugMessage"] = service_IWebserverMonitor_WriteDebugMessage;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteDebugMessage);
			IInterfaceModel iModel_IRequestParser = WebserverInterfaceFactory.CreateIRequestParser();
			IService service_IRequestParser_HandleRequest = CreateService(iModel_IRequestParser, "HandleRequest");
			methodHash["service_IRequestParser_HandleRequest"] = service_IRequestParser_HandleRequest;
			seff.SignatureList.AddSignatures(service_IRequestParser_HandleRequest);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(301, 302, 303, 304, 305, 306, 307, 308);
			fsm.AddStates(states);
			fsm.StartState = GetState(301);
			fsm.FinalStates = new IState[] {GetState(304)};
			AddTransition(309, ref fsm, 301, 302, methodHash["service_IWebserverConfiguration_get_ListenIP"]);
			AddTransition(310, ref fsm, 302, 303, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(311, ref fsm, 303, 304, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(312, ref fsm, 304, 305, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(313, ref fsm, 305, 306, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(314, ref fsm, 306, 307, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(315, ref fsm, 307, 308, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(316, ref fsm, 308, 306, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(317, ref fsm, 308, 304, methodHash["service_IRequestParser_HandleRequest"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DynamicFileProvider_HandleRequest()
		{
			IInterfaceModel iModel_IHTTPRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
			return CreateService(iModel_IHTTPRequestProcessor, "HandleRequest");
		}

		public static IServiceEffectSpecification CreateSeff_DynamicFileProvider_HandleRequest()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);
			IInterfaceModel iModel_IHTTPRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
			IService service_IHTTPRequestProcessor_HandleRequest = CreateService(iModel_IHTTPRequestProcessor, "HandleRequest");
			methodHash["service_IHTTPRequestProcessor_HandleRequest"] = service_IHTTPRequestProcessor_HandleRequest;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessor_HandleRequest);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(6101, 6102, 6103);
			fsm.AddStates(states);
			fsm.StartState = GetState(6101);
			fsm.FinalStates = new IState[] {GetState(6103)};
			AddTransition(6104, ref fsm, 6101, 6102, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(6105, ref fsm, 6102, 6103, methodHash["service_IHTTPRequestProcessor_HandleRequest"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_BibTexProvider_HandleRequest()
		{
			IInterfaceModel iModel_IHTTPRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
			return CreateService(iModel_IHTTPRequestProcessor, "HandleRequest");
		}

		public static IServiceEffectSpecification CreateSeff_BibTexProvider_HandleRequest()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);
			IService service_IWebserverMonitor_WriteDebugMessage = CreateService(iModel_IWebserverMonitor, "WriteDebugMessage");
			methodHash["service_IWebserverMonitor_WriteDebugMessage"] = service_IWebserverMonitor_WriteDebugMessage;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteDebugMessage);
			IInterfaceModel iModel_IHTTPRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
			IService service_IHTTPRequestProcessor_HandleRequest = CreateService(iModel_IHTTPRequestProcessor, "HandleRequest");
			methodHash["service_IHTTPRequestProcessor_HandleRequest"] = service_IHTTPRequestProcessor_HandleRequest;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessor_HandleRequest);
			IInterfaceModel iModel_IBibTexDB = WebserverInterfaceFactory.CreateIBibTexDB();
			IService service_IBibTexDB_set_ConnectionString = CreateService(iModel_IBibTexDB, "set_ConnectionString");
			methodHash["service_IBibTexDB_set_ConnectionString"] = service_IBibTexDB_set_ConnectionString;
			seff.SignatureList.AddSignatures(service_IBibTexDB_set_ConnectionString);
			IService service_IBibTexDB_Search = CreateService(iModel_IBibTexDB, "Search");
			methodHash["service_IBibTexDB_Search"] = service_IBibTexDB_Search;
			seff.SignatureList.AddSignatures(service_IBibTexDB_Search);
			IService service_IBibTexDB_AllEntries = CreateService(iModel_IBibTexDB, "AllEntries");
			methodHash["service_IBibTexDB_AllEntries"] = service_IBibTexDB_AllEntries;
			seff.SignatureList.AddSignatures(service_IBibTexDB_AllEntries);
			IInterfaceModel iModel_IHTTPRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();
			IService service_IHTTPRequestProcessorTools_GetFileMimeTypeFor = CreateService(iModel_IHTTPRequestProcessorTools, "GetFileMimeTypeFor");
			methodHash["service_IHTTPRequestProcessorTools_GetFileMimeTypeFor"] = service_IHTTPRequestProcessorTools_GetFileMimeTypeFor;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_GetFileMimeTypeFor);
			IService service_IHTTPRequestProcessorTools_SendHTTPHeader = CreateService(iModel_IHTTPRequestProcessorTools, "SendHTTPHeader");
			methodHash["service_IHTTPRequestProcessorTools_SendHTTPHeader"] = service_IHTTPRequestProcessorTools_SendHTTPHeader;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_SendHTTPHeader);
			IService service_IHTTPRequestProcessorTools_SendContentToClient = CreateService(iModel_IHTTPRequestProcessorTools, "SendContentToClient");
			methodHash["service_IHTTPRequestProcessorTools_SendContentToClient"] = service_IHTTPRequestProcessorTools_SendContentToClient;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_SendContentToClient);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(6201, 6202, 6203, 6204, 6205, 6206, 6207, 6208, 6209, 6210);
			fsm.AddStates(states);
			fsm.StartState = GetState(6201);
			fsm.FinalStates = new IState[] {GetState(6210)};
			AddTransition(6211, ref fsm, 6201, 6202, methodHash["service_IBibTexDB_set_ConnectionString"]);
			AddTransition(6212, ref fsm, 6201, 6210, methodHash["service_IHTTPRequestProcessor_HandleRequest"]);
			AddTransition(6213, ref fsm, 6202, 6203, methodHash["service_IBibTexDB_AllEntries"]);
			AddTransition(6214, ref fsm, 6202, 6203, methodHash["service_IBibTexDB_Search"]);
			AddTransition(6215, ref fsm, 6203, 6207, methodHash["service_IWebserverMonitor_WriteDebugMessage"]);
			AddTransition(6216, ref fsm, 6203, 6204, methodHash["service_IHTTPRequestProcessorTools_GetFileMimeTypeFor"]);
			AddTransition(6217, ref fsm, 6204, 6205, methodHash["service_IHTTPRequestProcessorTools_SendHTTPHeader"]);
			AddTransition(6218, ref fsm, 6205, 6206, methodHash["service_IHTTPRequestProcessorTools_SendContentToClient"]);
			AddTransition(6219, ref fsm, 6206, 6210, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(6220, ref fsm, 6207, 6208, methodHash["service_IHTTPRequestProcessorTools_GetFileMimeTypeFor"]);
			AddTransition(6221, ref fsm, 6208, 6209, methodHash["service_IHTTPRequestProcessorTools_SendHTTPHeader"]);
			AddTransition(6222, ref fsm, 6209, 6210, methodHash["service_IHTTPRequestProcessorTools_SendContentToClient"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_TemplateFileProvider_HandleRequest()
		{
			IInterfaceModel iModel_IHTTPRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
			return CreateService(iModel_IHTTPRequestProcessor, "HandleRequest");
		}

		public static IServiceEffectSpecification CreateSeff_TemplateFileProvider_HandleRequest()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);
			IInterfaceModel iModel_IHTTPRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
			IService service_IHTTPRequestProcessor_HandleRequest = CreateService(iModel_IHTTPRequestProcessor, "HandleRequest");
			methodHash["service_IHTTPRequestProcessor_HandleRequest"] = service_IHTTPRequestProcessor_HandleRequest;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessor_HandleRequest);
			IInterfaceModel iModel_IHTTPRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();
			IService service_IHTTPRequestProcessorTools_BuildCompletePath = CreateService(iModel_IHTTPRequestProcessorTools, "BuildCompletePath");
			methodHash["service_IHTTPRequestProcessorTools_BuildCompletePath"] = service_IHTTPRequestProcessorTools_BuildCompletePath;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_BuildCompletePath);
			IService service_IHTTPRequestProcessorTools_OpenFile = CreateService(iModel_IHTTPRequestProcessorTools, "OpenFile");
			methodHash["service_IHTTPRequestProcessorTools_OpenFile"] = service_IHTTPRequestProcessorTools_OpenFile;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_OpenFile);
			IService service_IHTTPRequestProcessorTools_GetFileMimeTypeFor = CreateService(iModel_IHTTPRequestProcessorTools, "GetFileMimeTypeFor");
			methodHash["service_IHTTPRequestProcessorTools_GetFileMimeTypeFor"] = service_IHTTPRequestProcessorTools_GetFileMimeTypeFor;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_GetFileMimeTypeFor);
			IService service_IHTTPRequestProcessorTools_SendHTTPHeader = CreateService(iModel_IHTTPRequestProcessorTools, "SendHTTPHeader");
			methodHash["service_IHTTPRequestProcessorTools_SendHTTPHeader"] = service_IHTTPRequestProcessorTools_SendHTTPHeader;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_SendHTTPHeader);
			IService service_IHTTPRequestProcessorTools_SendContentToClient = CreateService(iModel_IHTTPRequestProcessorTools, "SendContentToClient");
			methodHash["service_IHTTPRequestProcessorTools_SendContentToClient"] = service_IHTTPRequestProcessorTools_SendContentToClient;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_SendContentToClient);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(6301, 6302, 6303, 6304, 6305, 6306, 6307, 6308, 6309);
			fsm.AddStates(states);
			fsm.StartState = GetState(6301);
			fsm.FinalStates = new IState[] {GetState(6309)};
			AddTransition(6310, ref fsm, 6301, 6302, methodHash["service_IHTTPRequestProcessorTools_BuildCompletePath"]);
			AddTransition(6311, ref fsm, 6301, 6309, methodHash["service_IHTTPRequestProcessor_HandleRequest"]);
			AddTransition(6312, ref fsm, 6302, 6309, methodHash["service_IHTTPRequestProcessor_HandleRequest"]);
			AddTransition(6313, ref fsm, 6302, 6303, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(6314, ref fsm, 6303, 6304, methodHash["service_IHTTPRequestProcessorTools_GetFileMimeTypeFor"]);
			AddTransition(6315, ref fsm, 6304, 6305, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(6316, ref fsm, 6305, 6306, methodHash["service_IHTTPRequestProcessorTools_OpenFile"]);
			AddTransition(6317, ref fsm, 6306, 6307, methodHash["service_IHTTPRequestProcessorTools_SendHTTPHeader"]);
			AddTransition(6318, ref fsm, 6307, 6308, methodHash["service_IHTTPRequestProcessorTools_SendContentToClient"]);
			AddTransition(6319, ref fsm, 6308, 6309, methodHash["service_IWebserverMonitor_WriteLogEntry"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_StaticFileProvider_HandleRequest()
		{
			IInterfaceModel iModel_IHTTPRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
			return CreateService(iModel_IHTTPRequestProcessor, "HandleRequest");
		}

		public static IServiceEffectSpecification CreateSeff_StaticFileProvider_HandleRequest()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);
			IInterfaceModel iModel_IHTTPRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
			IService service_IHTTPRequestProcessor_HandleRequest = CreateService(iModel_IHTTPRequestProcessor, "HandleRequest");
			methodHash["service_IHTTPRequestProcessor_HandleRequest"] = service_IHTTPRequestProcessor_HandleRequest;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessor_HandleRequest);
			IInterfaceModel iModel_IHTTPRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();
			IService service_IHTTPRequestProcessorTools_BuildCompletePath = CreateService(iModel_IHTTPRequestProcessorTools, "BuildCompletePath");
			methodHash["service_IHTTPRequestProcessorTools_BuildCompletePath"] = service_IHTTPRequestProcessorTools_BuildCompletePath;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_BuildCompletePath);
			IInterfaceModel iModel_IWebserverConfiguration = WebserverInterfaceFactory.CreateIWebserverConfiguration();
			IService service_IWebserverConfiguration_get_DefaultFileNames = CreateService(iModel_IWebserverConfiguration, "get_DefaultFileNames");
			methodHash["service_IWebserverConfiguration_get_DefaultFileNames"] = service_IWebserverConfiguration_get_DefaultFileNames;
			seff.SignatureList.AddSignatures(service_IWebserverConfiguration_get_DefaultFileNames);
			IService service_IHTTPRequestProcessorTools_OpenFile = CreateService(iModel_IHTTPRequestProcessorTools, "OpenFile");
			methodHash["service_IHTTPRequestProcessorTools_OpenFile"] = service_IHTTPRequestProcessorTools_OpenFile;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_OpenFile);
			IService service_IHTTPRequestProcessorTools_GetFileMimeTypeFor = CreateService(iModel_IHTTPRequestProcessorTools, "GetFileMimeTypeFor");
			methodHash["service_IHTTPRequestProcessorTools_GetFileMimeTypeFor"] = service_IHTTPRequestProcessorTools_GetFileMimeTypeFor;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_GetFileMimeTypeFor);
			IService service_IHTTPRequestProcessorTools_SendHTTPHeader = CreateService(iModel_IHTTPRequestProcessorTools, "SendHTTPHeader");
			methodHash["service_IHTTPRequestProcessorTools_SendHTTPHeader"] = service_IHTTPRequestProcessorTools_SendHTTPHeader;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_SendHTTPHeader);
			IService service_IHTTPRequestProcessorTools_SendContentDataToClient = CreateService(iModel_IHTTPRequestProcessorTools, "SendContentDataToClient");
			methodHash["service_IHTTPRequestProcessorTools_SendContentDataToClient"] = service_IHTTPRequestProcessorTools_SendContentDataToClient;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_SendContentDataToClient);
			IService service_IHTTPRequestProcessorTools_SendHTTPError = CreateService(iModel_IHTTPRequestProcessorTools, "SendHTTPError");
			methodHash["service_IHTTPRequestProcessorTools_SendHTTPError"] = service_IHTTPRequestProcessorTools_SendHTTPError;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessorTools_SendHTTPError);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(6401, 6402, 6403, 6404, 6405, 6406, 6407, 6408, 6409, 6410);
			fsm.AddStates(states);
			fsm.StartState = GetState(6401);
			fsm.FinalStates = new IState[] {GetState(6410)};
			AddTransition(6411, ref fsm, 6401, 6402, methodHash["service_IHTTPRequestProcessorTools_BuildCompletePath"]);
			AddTransition(6412, ref fsm, 6401, 6410, methodHash["service_IHTTPRequestProcessorTools_SendHTTPError"]);
			AddTransition(6413, ref fsm, 6402, 6410, methodHash["service_IHTTPRequestProcessorTools_SendHTTPError"]);
			AddTransition(6414, ref fsm, 6402, 6403, methodHash["service_IWebserverConfiguration_get_DefaultFileNames"]);
			AddTransition(6415, ref fsm, 6402, 6404, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(6416, ref fsm, 6403, 6404, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(6417, ref fsm, 6404, 6404, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(6418, ref fsm, 6404, 6410, methodHash["service_IHTTPRequestProcessorTools_SendHTTPError"]);
			AddTransition(6419, ref fsm, 6404, 6405, methodHash["service_IHTTPRequestProcessorTools_GetFileMimeTypeFor"]);
			AddTransition(6420, ref fsm, 6405, 6406, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(6421, ref fsm, 6406, 6407, methodHash["service_IHTTPRequestProcessorTools_OpenFile"]);
			AddTransition(6422, ref fsm, 6407, 6408, methodHash["service_IHTTPRequestProcessorTools_SendHTTPHeader"]);
			AddTransition(6423, ref fsm, 6408, 6409, methodHash["service_IHTTPRequestProcessorTools_SendContentDataToClient"]);
			AddTransition(6424, ref fsm, 6409, 6410, methodHash["service_IWebserverMonitor_WriteLogEntry"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_HTTPRequestParser_HandleRequest()
		{
			IInterfaceModel iModel_IRequestParser = WebserverInterfaceFactory.CreateIRequestParser();
			return CreateService(iModel_IRequestParser, "HandleRequest");
		}

		public static IServiceEffectSpecification CreateSeff_HTTPRequestParser_HandleRequest()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);
			IInterfaceModel iModel_IHTTPRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
			IService service_IHTTPRequestProcessor_HandleRequest = CreateService(iModel_IHTTPRequestProcessor, "HandleRequest");
			methodHash["service_IHTTPRequestProcessor_HandleRequest"] = service_IHTTPRequestProcessor_HandleRequest;
			seff.SignatureList.AddSignatures(service_IHTTPRequestProcessor_HandleRequest);
			IInterfaceModel iModel_IRequestParser = WebserverInterfaceFactory.CreateIRequestParser();
			IService service_IRequestParser_HandleRequest = CreateService(iModel_IRequestParser, "HandleRequest");
			methodHash["service_IRequestParser_HandleRequest"] = service_IRequestParser_HandleRequest;
			seff.SignatureList.AddSignatures(service_IRequestParser_HandleRequest);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(8101, 8102, 8103, 8104, 8105);
			fsm.AddStates(states);
			fsm.StartState = GetState(8101);
			fsm.FinalStates = new IState[] {GetState(8105)};
			AddTransition(8106, ref fsm, 8101, 8102, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(8107, ref fsm, 8102, 8103, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(8108, ref fsm, 8103, 8104, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(8109, ref fsm, 8104, 8104, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(8110, ref fsm, 8102, 8105, methodHash["service_IRequestParser_HandleRequest"]);
			AddTransition(8111, ref fsm, 8103, 8105, methodHash["service_IRequestParser_HandleRequest"]);
			AddTransition(8112, ref fsm, 8104, 8105, methodHash["service_IRequestParser_HandleRequest"]);
			AddTransition(8113, ref fsm, 8104, 8105, methodHash["service_IHTTPRequestProcessor_HandleRequest"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DefaultRequestParser_HandleRequest()
		{
			IInterfaceModel iModel_IRequestParser = WebserverInterfaceFactory.CreateIRequestParser();
			return CreateService(iModel_IRequestParser, "HandleRequest");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultRequestParser_HandleRequest()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteDebugMessage = CreateService(iModel_IWebserverMonitor, "WriteDebugMessage");
			methodHash["service_IWebserverMonitor_WriteDebugMessage"] = service_IWebserverMonitor_WriteDebugMessage;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteDebugMessage);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(8201, 8202);
			fsm.AddStates(states);
			fsm.StartState = GetState(8201);
			fsm.FinalStates = new IState[] {GetState(8202)};
			AddTransition(8203, ref fsm, 8201, 8202, methodHash["service_IWebserverMonitor_WriteDebugMessage"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_WebserverMonitor_InitializeWriteAccess()
		{
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			return CreateService(iModel_IWebserverMonitor, "InitializeWriteAccess");
		}

		public static IServiceEffectSpecification CreateSeff_WebserverMonitor_InitializeWriteAccess()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverConfiguration = WebserverInterfaceFactory.CreateIWebserverConfiguration();
			IService service_IWebserverConfiguration_get_DebugFile = CreateService(iModel_IWebserverConfiguration, "get_DebugFile");
			methodHash["service_IWebserverConfiguration_get_DebugFile"] = service_IWebserverConfiguration_get_DebugFile;
			seff.SignatureList.AddSignatures(service_IWebserverConfiguration_get_DebugFile);
			IService service_IWebserverConfiguration_get_LogFile = CreateService(iModel_IWebserverConfiguration, "get_LogFile");
			methodHash["service_IWebserverConfiguration_get_LogFile"] = service_IWebserverConfiguration_get_LogFile;
			seff.SignatureList.AddSignatures(service_IWebserverConfiguration_get_LogFile);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(4101, 4102, 4103);
			fsm.AddStates(states);
			fsm.StartState = GetState(4101);
			fsm.FinalStates = new IState[] {GetState(4103)};
			AddTransition(4104, ref fsm, 4101, 4102, methodHash["service_IWebserverConfiguration_get_DebugFile"]);
			AddTransition(4105, ref fsm, 4102, 4103, methodHash["service_IWebserverConfiguration_get_LogFile"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DefaultHTTPRequestProcessor_BuildCompletePath()
		{
			IInterfaceModel iModel_IHTTPRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();
			return CreateService(iModel_IHTTPRequestProcessorTools, "BuildCompletePath");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultHTTPRequestProcessor_BuildCompletePath()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverConfiguration = WebserverInterfaceFactory.CreateIWebserverConfiguration();
			IService service_IWebserverConfiguration_get_DocumentRoot = CreateService(iModel_IWebserverConfiguration, "get_DocumentRoot");
			methodHash["service_IWebserverConfiguration_get_DocumentRoot"] = service_IWebserverConfiguration_get_DocumentRoot;
			seff.SignatureList.AddSignatures(service_IWebserverConfiguration_get_DocumentRoot);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(7101, 7102);
			fsm.AddStates(states);
			fsm.StartState = GetState(7101);
			fsm.FinalStates = new IState[] {GetState(7102)};
			AddTransition(7103, ref fsm, 7101, 7102, methodHash["service_IWebserverConfiguration_get_DocumentRoot"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DefaultHTTPRequestProcessor_SendContentDataToClient()
		{
			IInterfaceModel iModel_IHTTPRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();
			return CreateService(iModel_IHTTPRequestProcessorTools, "SendContentDataToClient");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultHTTPRequestProcessor_SendContentDataToClient()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteDebugMessage = CreateService(iModel_IWebserverMonitor, "WriteDebugMessage");
			methodHash["service_IWebserverMonitor_WriteDebugMessage"] = service_IWebserverMonitor_WriteDebugMessage;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteDebugMessage);
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(7201, 7202);
			fsm.AddStates(states);
			fsm.StartState = GetState(7201);
			fsm.FinalStates = new IState[] {GetState(7202)};
			AddTransition(7203, ref fsm, 7201, 7202, methodHash["service_IWebserverMonitor_WriteDebugMessage"]);
			AddTransition(7204, ref fsm, 7201, 7202, methodHash["service_IWebserverMonitor_WriteLogEntry"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DefaultHTTPRequestProcessor_SendContentToClient()
		{
			IInterfaceModel iModel_IHTTPRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();
			return CreateService(iModel_IHTTPRequestProcessorTools, "SendContentToClient");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultHTTPRequestProcessor_SendContentToClient()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteDebugMessage = CreateService(iModel_IWebserverMonitor, "WriteDebugMessage");
			methodHash["service_IWebserverMonitor_WriteDebugMessage"] = service_IWebserverMonitor_WriteDebugMessage;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteDebugMessage);
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(7301, 7302);
			fsm.AddStates(states);
			fsm.StartState = GetState(7301);
			fsm.FinalStates = new IState[] {GetState(7302)};
			AddTransition(7303, ref fsm, 7301, 7302, methodHash["service_IWebserverMonitor_WriteDebugMessage"]);
			AddTransition(7304, ref fsm, 7301, 7302, methodHash["service_IWebserverMonitor_WriteLogEntry"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DefaultHTTPRequestProcessor_SendHTTPHeader()
		{
			IInterfaceModel iModel_IHTTPRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();
			return CreateService(iModel_IHTTPRequestProcessorTools, "SendHTTPHeader");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultHTTPRequestProcessor_SendHTTPHeader()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteDebugMessage = CreateService(iModel_IWebserverMonitor, "WriteDebugMessage");
			methodHash["service_IWebserverMonitor_WriteDebugMessage"] = service_IWebserverMonitor_WriteDebugMessage;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteDebugMessage);
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(7401, 7402);
			fsm.AddStates(states);
			fsm.StartState = GetState(7401);
			fsm.FinalStates = new IState[] {GetState(7402)};
			AddTransition(7403, ref fsm, 7401, 7402, methodHash["service_IWebserverMonitor_WriteDebugMessage"]);
			AddTransition(7404, ref fsm, 7401, 7402, methodHash["service_IWebserverMonitor_WriteLogEntry"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DefaultHTTPRequestProcessor_SendHTTPError()
		{
			IInterfaceModel iModel_IHTTPRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();
			return CreateService(iModel_IHTTPRequestProcessorTools, "SendHTTPError");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultHTTPRequestProcessor_SendHTTPError()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
			IService service_IWebserverMonitor_WriteDebugMessage = CreateService(iModel_IWebserverMonitor, "WriteDebugMessage");
			methodHash["service_IWebserverMonitor_WriteDebugMessage"] = service_IWebserverMonitor_WriteDebugMessage;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteDebugMessage);
			IService service_IWebserverMonitor_WriteLogEntry = CreateService(iModel_IWebserverMonitor, "WriteLogEntry");
			methodHash["service_IWebserverMonitor_WriteLogEntry"] = service_IWebserverMonitor_WriteLogEntry;
			seff.SignatureList.AddSignatures(service_IWebserverMonitor_WriteLogEntry);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(7501, 7502, 7503, 7504);
			fsm.AddStates(states);
			fsm.StartState = GetState(7501);
			fsm.FinalStates = new IState[] {GetState(7504)};
			AddTransition(7505, ref fsm, 7501, 7502, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(7506, ref fsm, 7502, 7503, methodHash["service_IWebserverMonitor_WriteDebugMessage"]);
			AddTransition(7507, ref fsm, 7502, 7503, methodHash["service_IWebserverMonitor_WriteLogEntry"]);
			AddTransition(7508, ref fsm, 7503, 7504, methodHash["service_IWebserverMonitor_WriteDebugMessage"]);
			AddTransition(7509, ref fsm, 7503, 7504, methodHash["service_IWebserverMonitor_WriteLogEntry"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		public static IService CreateService_DefaultHTTPRequestProcessor_GetFileMimeTypeFor()
		{
			IInterfaceModel iModel_IHTTPRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();
			return CreateService(iModel_IHTTPRequestProcessorTools, "GetFileMimeTypeFor");
		}

		public static IServiceEffectSpecification CreateSeff_DefaultHTTPRequestProcessor_GetFileMimeTypeFor()
		{
			IServiceEffectSpecification seff = ComponentFactory.CreateServiceEffectSpecification();
			Hashtable methodHash = new Hashtable();
			IInterfaceModel iModel_IWebserverConfiguration = WebserverInterfaceFactory.CreateIWebserverConfiguration();
			IService service_IWebserverConfiguration_GetMimeTypeFor = CreateService(iModel_IWebserverConfiguration, "GetMimeTypeFor");
			methodHash["service_IWebserverConfiguration_GetMimeTypeFor"] = service_IWebserverConfiguration_GetMimeTypeFor;
			seff.SignatureList.AddSignatures(service_IWebserverConfiguration_GetMimeTypeFor);
			IService service_IWebserverConfiguration_get_DefaultMimeType = CreateService(iModel_IWebserverConfiguration, "get_DefaultMimeType");
			methodHash["service_IWebserverConfiguration_get_DefaultMimeType"] = service_IWebserverConfiguration_get_DefaultMimeType;
			seff.SignatureList.AddSignatures(service_IWebserverConfiguration_get_DefaultMimeType);


			IFSMServiceEffect fsmSeff = ComponentFactory.CreateFSMProtocolServiceEffect();
			IEditableFiniteStateMachine fsm = fsmSeff.EditFSM;
			IState[] states = CreateStates(7601, 7602, 7603);
			fsm.AddStates(states);
			fsm.StartState = GetState(7601);
			fsm.FinalStates = new IState[] {GetState(7602), GetState(7603)};
			AddTransition(7604, ref fsm, 7601, 7602, methodHash["service_IWebserverConfiguration_GetMimeTypeFor"]);
			AddTransition(7605, ref fsm, 7602, 7603, methodHash["service_IWebserverConfiguration_get_DefaultMimeType"]);

			seff.AddAuxiliarySpecification(fsmSeff);
			return seff;
		}

		#endregion

		protected WebserverSeffFactory()
		{
		}
	}
}
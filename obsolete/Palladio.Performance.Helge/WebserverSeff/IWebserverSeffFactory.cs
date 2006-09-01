using Palladio.FiniteStateMachines;

namespace Palladio.Performance.WebserverSeff
{
	/// <summary>
	/// Factory for the creation of all required Seffs of the Webserver.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log: IWebserverSeffFactory.cs,v $
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
	public interface IWebserverSeffFactory
	{
		/// <summary>
		/// Creates the service effect automaton for the DefaultDispatcher.Start() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultDispatcher_Start();

		/// <summary>
		/// Creates the service effect automaton for the DefaultDispatcher.Stop() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultDispatcher_Stop();

		/// <summary>
		/// Creates the service effect automaton for the DefaultDispatcher.StartListen() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultDispatcher_StartListen();

		/// <summary>
		/// Creates the service effect automaton for the DynamicFileProvider.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DynamicFileProvider_HandleRequest();

		/// <summary>
		/// Creates the service effect automaton for the BibTexProvider.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_BibTexProvider_HandleRequest();

		/// <summary>
		/// Creates the service effect automaton for the TemplateFileProviderHandleRequest() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_TemplateFileProvider_HandleRequest();

		/// <summary>
		/// Creates the service effect automaton for the FileProvider.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_FileProvider_HandleRequest();

		/// <summary>
		/// Creates the service effect automaton for the HTTPRequestParser.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_HTTPRequestParser_HandleRequest();

		/// <summary>
		/// Creates the service effect automaton for the DefaultRequestParser.HandleRequest() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultRequestParser_HandleRequest();

		/// <summary>
		/// Creates the service effect automaton for the WebserverMonitor.InitializeWriteAccess() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_WebserverMonitor_InitializeWriteAccess();

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.BuildCompletePath() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_BuildCompletePath();

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.SendContentDataToClient() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_SendContentDataToClient();

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.SendContentToClient() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_SendContentToClient();

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.SendHTTPHeader() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_SendHTTPHeader();

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.SendHTTPError() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_SendHTTPError();

		/// <summary>
		/// Creates the service effect automaton for the DefaultHTTPRequestProcessor.GetFileMimeTypeFor() service.
		/// </summary>
		/// <returns></returns>
		IFiniteStateMachine CreateSeff_DefaultHTTPRequestProcessor_GetFileMimeTypeFor();
	}
}
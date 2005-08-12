using System;
using System.Xml;
using Palladio.Attributes;
using Palladio.FiniteStateMachines;
using Palladio.Performance.Math;
using Palladio.Performance.Attributes;

namespace Palladio.Performance.WebserverAnalyser
{
	/// <summary>
	/// This class provides functions for saving service effect automatons. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
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
	internal class XmlFileCreator
	{
		/// <summary>
		/// Creates an XML file which includes all probability density functions of a service effect automaton plus
		/// the measured and calculated functions of the service. 
		/// </summary>
		/// <param name="configuration">Configuration of the WebserverAnalyser.</param>
		/// <param name="seff">The service effect automaton annotated by RandomVariables.</param>
		/// <param name="calculatedPerformance">The result of the calculation.</param>
		internal static void CreateXmlFile(Config configuration, IFiniteStateMachine seff,
			RandomVariable calculatedPerformance)
		{
			XmlDocument document = CreateDocument(null,null);

			XmlElement rootElem = document.CreateElement("Performance");
			rootElem.SetAttribute("name", configuration.ServiceName);

			AddTransitions(seff, configuration, document, rootElem);
			AddStates(seff, configuration, document, rootElem);
			AddMeasuredService(configuration, document, rootElem);
			AddCalculatedService(calculatedPerformance, configuration, document, rootElem);

			document.AppendChild(rootElem);
			document.Save(configuration.StoreFile);
		}

		/// <summary>
		/// Adds the computed time  consumption of the service.
		/// </summary>
		/// <param name="calculatedPerformance"></param>
		/// <param name="configuration"></param>
		/// <param name="document"></param>
		/// <param name="rootElem"></param>
		private static void AddCalculatedService(RandomVariable calculatedPerformance, Config configuration, XmlDocument document, XmlElement rootElem)
		{
			IDiscreteFunction calculatedPDF = GetPDFWithNewSamplingRate(calculatedPerformance,configuration);
	
			XmlElement calculatedElement = document.CreateElement("calculated_timeConsumtion");
			calculatedElement.SetAttribute("name", configuration.ServiceName);
			
			XmlElement calculatedPdfElement = CreatePDFAsXml(document,calculatedPDF);

			calculatedElement.AppendChild(calculatedPdfElement);
			rootElem.AppendChild(calculatedElement);
		}

		/// <summary>
		/// Adds the time measured consumption of the service.
		/// </summary>
		/// <param name="configuration"></param>
		/// <param name="document"></param>
		/// <param name="rootElem"></param>
		private static void AddMeasuredService(Config configuration, XmlDocument document, XmlElement rootElem)
		{
			MeasureAttribute measureAttribute = CreateMeasureAttribute(configuration);

			RandomVariable measuredRand = 
				AttributeTransformer.MeasureAttribute2RandomVariable(measureAttribute,configuration.Samplingrate);
			IDiscreteFunction measuredPDF = GetPDFWithNewSamplingRate(measuredRand, configuration);

			XmlElement measuredElement = document.CreateElement("measured_timeConsumtion");
			measuredElement.SetAttribute("name", configuration.ServiceName);
	
			XmlElement measuredPdfElement = CreatePDFAsXml(document,measuredPDF);

			measuredElement.AppendChild(measuredPdfElement);
			rootElem.AppendChild(measuredElement);
		}


		/// <summary>
		/// Creates a MeasureAttribute from the measured data for the service to analyse.
		/// </summary>
		/// <param name="configuration"></param>
		/// <returns></returns>
		private static MeasureAttribute CreateMeasureAttribute(Config configuration)
		{
			XmlDocument measure = new XmlDocument();
			measure.Load(configuration.MeasureFile);

			XmlNodeList measureList = measure.GetElementsByTagName(configuration.ServiceName);
			MeasureAttribute measureAttribute = new MeasureAttribute();
			
			int count = measureList.Count;
			for (int i=0;i<count;i++) 
			{
				XmlNode callNumber = measureList[i].Attributes.GetNamedItem("CallNumber");
				measureAttribute.AddMeasure
					(Convert.ToInt64(measureList[i].SelectSingleNode("ExecutionTime").InnerText),
					 callNumber.InnerText);
			}
			
			return measureAttribute;
		}

		/// <summary>
		/// Add states.
		/// </summary>
		/// <param name="seff"></param>
		/// <param name="configuration"></param>
		/// <param name="document"></param>
		/// <param name="rootElem"></param>
		private static void AddStates(IFiniteStateMachine seff, Config configuration, XmlDocument document, XmlElement rootElem)
		{
			// add time consumption of states
			foreach(IState state in seff.States) 
			{
				// ID of state
				XmlElement stateElement = document.CreateElement("state_timeConsumtion");
				stateElement.SetAttribute("name", state.ID.ToString());

				AddPDF(state, configuration, document, stateElement);

				rootElem.AppendChild(stateElement);
			}
		}

		/// <summary>
		/// Adds the PDF of the <c>IAttributable</c> to the father.
		/// </summary>
		/// <param name="attributable"></param>
		/// <param name="configuration"></param>
		/// <param name="document"></param>
		/// <param name="father"></param>
		private static void AddPDF(IAttributable attributable, Config configuration, XmlDocument document, XmlElement father)
		{
			IDiscreteFunction pdf = GetPDFWithNewSamplingRate(attributable, configuration);
			XmlElement pdfElement = CreatePDFAsXml(document, pdf);
			father.AppendChild(pdfElement);
		}

		/// <summary>
		/// Add transitions.
		/// </summary>
		/// <param name="seff"></param>
		/// <param name="configuration"></param>
		/// <param name="document"></param>
		/// <param name="rootElem"></param>
		private static void AddTransitions(IFiniteStateMachine seff, Config configuration, XmlDocument document, XmlElement rootElem)
		{
			foreach(ITransition transition in seff.Transitions)
			{
				ProbabilityAttribute prob = ProbabilityAttribute.GetAttribute(transition);

				// ID of service
				XmlElement serviceElement = document.CreateElement("service_timeConsumtion");
				serviceElement.SetAttribute("name", transition.InputSymbol.ID.ToString());
				serviceElement.SetAttribute("transitionProbability", prob.Probability.ToString());

				AddPDF(transition, configuration, document, serviceElement);

				rootElem.AppendChild(serviceElement);
			}
		}

		/// <summary>
		/// Returns the probability density function of the <c>IAttributable</c>. The samplingrate is adjusted to
		/// the value of the config.
		/// </summary>
		/// <param name="attributable"></param>
		/// <param name="configuration"></param>
		/// <returns></returns>
		private static IDiscreteFunction GetPDFWithNewSamplingRate(IAttributable attributable, Config configuration)
		{
			RandomVariable rand = RandomVariable.GetAttribute(attributable);
			IDiscreteFunction pdf = rand.ProbabilityDensityFunction;
			pdf.AdjustSamplingRate(configuration.Samplingrate);
			return pdf;
		}

		/// <summary>
		/// Returns the probability density function of the <c>RandomVariable</c>. The samplingrate is adjusted to
		/// the value of the config.
		/// </summary>
		/// <param name="measuredRand"></param>
		/// <param name="configuration"></param>
		/// <returns></returns>
		private static IDiscreteFunction GetPDFWithNewSamplingRate(RandomVariable measuredRand, Config configuration)
		{
			IDiscreteFunction measuredPDF = measuredRand.ProbabilityDensityFunction;
			measuredPDF.AdjustSamplingRate(configuration.Samplingrate);
			return measuredPDF;
		}


		/// <summary>
		/// Creates a <c>XmlElement</c> which holds the values of the PDF.
		/// </summary>
		/// <param name="document"></param>
		/// <param name="pdf"></param>
		/// <returns></returns>
		private static XmlElement CreatePDFAsXml(XmlDocument document, IDiscreteFunction pdf)
		{
			XmlElement pdfElement = document.CreateElement("pdf");
			int pdfDataLength = pdf.Data.Length;
			for (int i=0;i<pdfDataLength;i++) 
			{
				XmlElement pdfEntryElement = document.CreateElement("entry");
				pdfEntryElement.SetAttribute("time", Convert.ToString(pdf.ValueAt(i)));
				pdfEntryElement.SetAttribute("probability", Convert.ToString(pdf.Data[i]));
				pdfElement.AppendChild(pdfEntryElement);
			}
			return pdfElement;
		}

		#region SaveAsXml

		/// <summary>
		/// Creates an xml file for a service effect automaton, which can be used 
		/// as input for perfromance calculation.
		/// </summary>
		/// <param name="savepoint">Location of the xml file to create.</param>
		/// <param name="seff">Seff which shall be stored.</param>
		public static void SavesSeffAsXml(string savepoint, IFiniteStateMachine seff)
		{
			XmlDocument document = CreateDocument("WebserverMeasure","XmlSeffParser.dtd");
			XmlElement rootElem = document.CreateElement("ServiceEffectAutomaton");

			AddStateList(document, seff, rootElem);
			AddInputList(document, seff, rootElem);
			AddTransitionList(document, seff, rootElem);

			document.AppendChild(rootElem);
			document.Save(savepoint);
		}

		/// <summary>
		/// Adds the transition list.
		/// </summary>
		/// <param name="document"></param>
		/// <param name="seff"></param>
		/// <param name="father"></param>
		private static void AddTransitionList(XmlDocument document, IFiniteStateMachine seff, XmlElement father)
		{
			XmlElement transitionlist = document.CreateElement("transitionlist");
			foreach(ITransition transition in seff.Transitions) 
			{
				AddQmlAttribut(transition);

				XmlElement transitionElement = document.CreateElement("transition");
				
				AddElement(document, transitionElement, "sourcestate", transition.SourceState.ID);
				AddElement(document, transitionElement, "input", transition.InputSymbol.ID.ToString());
				AddElement(document, transitionElement, "destinationstate",transition.DestinationState.ID);
				AddElement(document, transitionElement, "probability", 
					Convert.ToString(ProbabilityAttribute.GetAttribute(transition as IAttributable).Probability));

				AddTimeConsumptionToXML(transition,document,transitionElement);

				transitionlist.AppendChild(transitionElement);
			}
			father.AppendChild(transitionlist);
		}

		/// <summary>
		/// Adds a new Element with the specified name and value to the destination.
		/// </summary>
		/// <param name="doc"></param>
		/// <param name="destination"></param>
		/// <param name="name"></param>
		/// <param name="value"></param>
		private static void AddElement(XmlDocument doc,XmlElement destination, string name, string value)
		{
			XmlElement newElement = doc.CreateElement(name);
			newElement.InnerText=value;
			destination.AppendChild(newElement);
		}

		/// <summary>
		/// Adds the Input list.
		/// </summary>
		/// <param name="document"></param>
		/// <param name="seff"></param>
		/// <param name="father">father tag of the new xml tags.</param>
		private static void AddInputList(XmlDocument document, IFiniteStateMachine seff, XmlElement father)
		{
			XmlElement inputlist = document.CreateElement("inputlist");
			foreach(IInput input in seff.InputAlphabet) 
			{
				AddElement(document,inputlist,"input",input.ID.ToString());
			}
			father.AppendChild(inputlist);
		}

		/// <summary>
		/// Adds the state list.
		/// </summary>
		/// <param name="document"></param>
		/// <param name="seff"></param>
		/// <param name="father"></param>
		private static void AddStateList(XmlDocument document, IFiniteStateMachine seff, XmlElement father)
		{
			XmlElement statelist = document.CreateElement("statelist");
			statelist.SetAttribute("startstate",seff.StartState.ID.ToString());
	
			foreach(IState state in seff.States) 
			{
				AddQmlAttribut(state);
				XmlElement stateElement = document.CreateElement("state");
				if (seff.IsFinalState(state)) stateElement.SetAttribute("isFinalState","true");

				AddElement(document,stateElement,"name", state.ID);

				AddTimeConsumptionToXML(state, document, stateElement);
				statelist.AppendChild(stateElement);
			}
			father.AppendChild(statelist);
		}

		/// <summary>
		/// Adds the qml aspects of the <c>QMLAttribute</c> of the <c>IAttributable</c>.
		/// </summary>
		/// <param name="attributable"><c>IAttributable</c> that contains a <c>QMLAttribute</c>.</param>
		/// <param name="document">The XML document.</param>
		/// <param name="father">The father element of the new xml tags. </param>
		private static void AddTimeConsumptionToXML(IAttributable attributable, XmlDocument document, XmlElement father)
		{
			QMLAttribute qml = QMLAttribute.GetAttribute(attributable);
			int length = qml.Length;
			for(int i=0;i<length;i++) 
			{
				XmlElement time_consumption = document.CreateElement("time_consumption");
				time_consumption.SetAttribute("percentile",Convert.ToString(qml.Aspects[i].Percentile));
				time_consumption.SetAttribute("time",Convert.ToString(qml.Aspects[i].TimeValue));
				father.AppendChild(time_consumption);
			}
		}

		/// <summary>
		/// Adds a <c>QMLAttribute</c> if the <c>IAttributable</c> does not contain one. The attribute is
		/// generated from the <c>RandomVariable</c>.
		/// </summary>
		/// <param name="attributable">Object which shall get a <c>QMLAttribute</c>.</param>
		private static void AddQmlAttribut(IAttributable attributable)
		{
			if(!attributable.Attributes.Contains(QMLAttribute.AttributeType)) 
			{
				attributable.Attributes.Add(QMLAttribute.AttributeType,
				                     AttributeTransformer.RandomVariable2QML(RandomVariable.GetAttribute(attributable)));
			}
		}

		private static XmlDocument CreateDocument(string name, string dtd)
		{
			XmlDocument document = new XmlDocument();
			XmlDeclaration decl = document.CreateXmlDeclaration("1.0",null,null);
			document.AppendChild(decl);
			if(name!=null && dtd != null)
			{
				XmlDocumentType type = document.CreateDocumentType(name,null,dtd,null);
				document.AppendChild(type);
			}
			return document;
		}
		#endregion
	}
}

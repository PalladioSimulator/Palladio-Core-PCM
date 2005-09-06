#region info
///////////////////////////////////////////////////////////////////////////////
/// This software has been developed as a part of the diploma thesis 
/// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
/// Komponentenadapter" ("Influence of the configuration of a generator on the 
/// prediction of the QoS of component adaptors")
/// at the 
/// University of Oldenburg
/// Department of Computing Science
/// Software Engineering Group
/// Palladio Research Group
/// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
/// 
/// Development period: July 2005 - January 2006
/// 
/// Author: Niels Streekmann
/// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion
using System;
using System.IO;
using System.Xml;
using System.Xml.Schema;
using System.Xml.XPath;

namespace Palladio.QoSAdaptor.Pattern
{
	/// <summary>
	/// This class implements a parser for design pattern 
	/// descriptions in XML. 
	/// Some parts of the parser were taken from XmlSeffParser.
	/// </summary>
	public class PatternDescriptionParser
	{
		#region data
		private PatternDescription pattern;
		#endregion

		#region constructors
		public PatternDescriptionParser()
		{
		}
		
		public PatternDescriptionParser(string file)
		{
			pattern = ParseDescription(file);
		}
		#endregion

		#region properties
		public PatternDescription Pattern
		{
			get
			{
				return this.pattern;
			}
		}
		#endregion

		#region methods copied from XmlSeffParser
		/// <summary>
		/// This method was copied from XmlSeffParser.
		/// </summary>
		/// <param name="it"></param>
		/// <param name="child"></param>
		/// <returns></returns>
		private static string GetValueOfChild(XPathNodeIterator it,string child) 
		{
			XPathNodeIterator it2;
			it2=it.Current.SelectChildren(child,it.Current.NamespaceURI);
			it2.MoveNext();
			return it2.Current.Value;
		}

		/// <summary>
		/// This method was copied from XmlSeffParser.
		/// </summary>
		/// <param name="sender"></param>
		/// <param name="args"></param>
		private void OnValidateError(Object sender, ValidationEventArgs args ) 
		{
			throw new XmlException("File does not match PatternDescription.dtd  "+args.Message,null);
		}

		/// <summary>
		/// This method was copied from XmlSeffParser.
		/// </summary>
		/// <param name="file"></param>
		private void XmlValid(string file) 
		{
			try
			{
				XmlTextReader textReader = new XmlTextReader(file);
				XmlValidatingReader val = new XmlValidatingReader(textReader);
				val.ValidationType = ValidationType.DTD;
				val.ValidationEventHandler +=
					new ValidationEventHandler(OnValidateError);
				while (val.Read());			
			} 
			catch 
			{
				throw;
			}
		}
		#endregion

		#region private parsing methods
		/// <summary>
		/// This is the main parsing method. The XML-file 
		/// containing the pattern description is validated 
		/// against the DTD and other initialisations are made. 
		/// After that the methods for parsing the separate parts
		/// of the XML-file are called. 
		/// </summary>
		/// <param name="file">The XML file containing the pattern
		/// description</param>
		/// <returns>A PatternDescription object containing the 
		/// same information as the given XML file.</returns>
		private PatternDescription ParseDescription (string file)
		{
			PatternDescription pattern = new PatternDescription();
			XmlDocument doc;
			XPathNavigator nav;

			try 
			{
				XmlValid(file);
				doc = new XmlDocument();
				doc.Load(file);
				nav = doc.CreateNavigator();

				ReadGeneralDescription(nav, pattern);
				ReadQoSEffects(nav, pattern); 
				ReadAdapterTemplates(nav, pattern); 
				ReadPredictionTemplates(nav, pattern); 
			}
			catch (XmlException e) 
			{
				Console.WriteLine(e);
				return null;
			} 
			catch (IOException e) 
			{
				Console.WriteLine("File Was not Found!");
				Console.WriteLine(e);
			}
			return pattern;
		}

		/// <summary>
		/// This method parses the general information of the 
		/// pattern description, including the name, general 
		/// description and the source of the pattern. 
		/// </summary>
		/// <param name="nav">An XPathNavigator for the parsed XML
		/// file</param>
		/// <param name="pattern">The final PatternDescription 
		/// object.</param>
		private void ReadGeneralDescription(XPathNavigator nav, 
				PatternDescription pattern)
		{
			XPathNodeIterator it;
			it = nav.Select("/Pattern");
			it.MoveNext();
			pattern.Name = GetValueOfChild(it, "name");
			pattern.Description = GetValueOfChild(it, "description");
			pattern.Source = GetValueOfChild(it, "source");
		}

		/// <summary>
		/// This methods parses the QoS effects described in the 
		/// XML file.
		/// </summary>
		/// <param name="nav">An XPathNavigator for the parsed XML
		/// file</param>
		/// <param name="pattern">The final PatternDescription 
		/// object.</param>
		private void ReadQoSEffects(XPathNavigator nav, PatternDescription pattern)
		{
			XPathNodeIterator it;
			it = nav.Select("/Pattern/QoS-effect");
			it.MoveNext();
			XPathNodeIterator it2;
			it2=it.Current.SelectChildren("attribute", it.Current.NamespaceURI);
			while(it2.MoveNext())
				{
					QoSAttribute attribute = new QoSAttribute(GetValueOfChild(it2, "name"));
					attribute.Suitability = GetValueOfChild(it2, "suitability");
					pattern.AddQoSAttribute(attribute);
				}
		}

		/// <summary>
		/// This methods parses the list of templates needed to 
		/// created the adapter that can be used to adjust the 
		/// QoS mismatches of the pattern. 
		/// </summary>
		/// /// <param name="nav">An XPathNavigator for the parsed XML
		/// file</param>
		/// <param name="pattern">The final PatternDescription 
		/// object.</param>
		private void ReadAdapterTemplates(XPathNavigator nav, 
				PatternDescription pattern)
		{
			XPathNodeIterator it;
			it = nav.Select("/Pattern/adapterTemplates");
			it.MoveNext();
			XPathNodeIterator it2;
			it2=it.Current.SelectChildren("template", it.Current.NamespaceURI);
			while(it2.MoveNext())
			{
				pattern.AddAdaptorTemplate(it2.Current.Value);
			}
		}

		/// <summary>
		/// This method parses the list of templates that can be 
		/// used to created the prediction model for the 
		/// performance of the generated adapter. 
		/// </summary>
		/// <param name="nav">An XPathNavigator for the parsed XML
		/// file</param>
		/// <param name="pattern">The final PatternDescription 
		/// object.</param>
		private void ReadPredictionTemplates(XPathNavigator nav, 
			PatternDescription pattern)
		{
			XPathNodeIterator it;
			it = nav.Select("/Pattern/predictionTemplates");
			it.MoveNext();
			XPathNodeIterator it2;
			it2=it.Current.SelectChildren("template",it.Current.NamespaceURI);
			while(it2.MoveNext())
			{
				pattern.AddPredictionTemplate(it2.Current.Value);
			}
		}
		#endregion 
	}
}

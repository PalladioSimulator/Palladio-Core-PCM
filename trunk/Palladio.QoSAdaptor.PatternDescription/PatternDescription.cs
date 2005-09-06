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
using System.Collections;

namespace Palladio.QoSAdaptor.Pattern
{
	/// <summary>
	/// A PatternDescription has a number of attributes to 
	/// describe all aspects of a design pattern that may be 
	/// helpful to choose a certain pattern for adaptation. 
	/// </summary>
	public class PatternDescription
	{
		#region data
		private string name;
		private string description;
		private string source;

		private ArrayList qosAttributes;
		private ArrayList adaptorTemplates;
		private ArrayList predictionTemplates;
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a new empty PatternDescription.
		/// </summary>
		public PatternDescription()
		{
			qosAttributes = new ArrayList();
			adaptorTemplates = new ArrayList();
			predictionTemplates = new ArrayList();
		}
		#endregion

		#region properties
		public string Name 
		{
			get
			{
				return name;
			}
			set 
			{
				name = value;
			}
		}

		public string Description
		{
			get 
			{
				return description;
			}
			set 
			{
				description = value;
			}
		}

		public string Source
		{
			get 
			{
				return source;
			}
			set 
			{
				source = value;
			}
		}

		public IList QoSAttributes
		{
			get
			{
				return qosAttributes;
			}
		}
		public IList AdapterTemplates
		{
			get
			{
				return adaptorTemplates;
			}
		}

		public IList PredictionTemplates
		{
			get
			{
				return predictionTemplates;
			}
		}

		#endregion 

		#region public methods
		/// <summary>
		/// Adds a QoSattribute to the list of attributes the 
		/// description holds. 
		/// </summary>
		/// <param name="attribute">A new QoSAttribute</param>
		public void AddQoSAttribute (QoSAttribute attribute)
		{
			qosAttributes.Add(attribute);
		}

		/// <summary>
		/// Adds a template to the descriptions list of adapter 
		/// templates. The filename of the template has to be 
		/// given as a parameter. 
		/// By default the templates should 
		/// available in the same directory as the xml pattern 
		/// description. 
		/// </summary>
		/// <param name="template">The filename of the template
		/// </param>
		public void AddAdaptorTemplate (string template)
		{
			adaptorTemplates.Add(template);
		}

		/// <summary>
		/// Adds a template to the descriptions list of prediction 
		/// templates. The filename of the template has to be 
		/// given as a parameter. 
		/// By default the templates should 
		/// available in the same directory as the xml pattern 
		/// description. 
		/// </summary>
		/// <param name="template">The filename of the template
		/// </param>
		public void AddPredictionTemplate (string template)
		{
			predictionTemplates.Add(template);
		}
		#endregion
	}
}

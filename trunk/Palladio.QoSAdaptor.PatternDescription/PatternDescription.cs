#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
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
		private string interfaceModel;
		private string description;
		private string source;

		private ArrayList mismatches;
		private ArrayList adaptorTemplates;
		private ArrayList predictionTemplates;
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a new empty PatternDescription.
		/// </summary>
		public PatternDescription()
		{
			mismatches = new ArrayList();
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

		public string InterfaceModel 
		{
			get
			{
				return interfaceModel;
			}
			set 
			{
				interfaceModel = value;
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

		public IList MismatchAttributes
		{
			get
			{
				return mismatches;
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
		public void AddMismatchAttribute (MismatchAttribute attribute)
		{
			mismatches.Add(attribute);
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

		/// <summary>
		/// Checks if this PatternDescription covers the given QoS attribute.
		/// </summary>
		/// <param name="attributeName">The name of a QoS attribute.</param>
		/// <returns>True if this description covers the given attribute. Else
		/// false.</returns>
		public bool HasMismatchAttribute(string attributeName)
		{
			bool hasAttribute = false;
			foreach (MismatchAttribute attribute in this.mismatches)
			{
				if (attribute.Name.Equals(attributeName))
					hasAttribute = true;
			}
			return hasAttribute;
		}

		/// <summary>
		/// Returns the QoSAttribute with the given name. It is assumed that 
		/// there is only one attribute with the given name. 
		/// </summary>
		/// <param name="attributeName">The name of the searched QoSAttribute.
		/// </param>
		/// <returns>The QoSAttribute, if it is in the attribute list of this
		/// PatternDescription. Else null.</returns>
		public MismatchAttribute GetMismatchAttribute (string attributeName)
		{
			foreach (MismatchAttribute attribute in this.mismatches)
			{
				if (attribute.Name.Equals(attributeName))
					return attribute;
			}
			return null;
		}

		/// <summary>
		/// Checks if two PatternDescriptions instances are equal. To check
		/// this name, description and source are checked for equality.
		/// qosAttributes and templates are not checked, because it is much 
		/// more complex and it is assumed that if the first three attributes
		/// are equal the whole description is equal.
		/// </summary>
		/// <param name="obj">A PatternDescription.</param>
		/// <returns>True if the described attribute of this object equal the 
		/// attributes of the given object. Else false.</returns>
		public override bool Equals(object obj)
		{
			if (!(this.GetType().Equals(obj.GetType())))
				return false;
			PatternDescription pattern = (PatternDescription)obj;
			if ((this.name.Equals(pattern.Name)) &&
				(this.description.Equals(pattern.Description)) &&
				this.source.Equals(pattern.Source))
				return true;
			return false;
		}
		#endregion
	}
}

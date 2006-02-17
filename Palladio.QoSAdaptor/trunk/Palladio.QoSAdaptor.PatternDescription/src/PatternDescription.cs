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
	internal class PatternDescription : IPatternDescription
	{
		#region attributes
		/// <summary>
		/// The name of the pattern.
		/// </summary>
		private string name;

		/// <summary>
		/// The name of the interface model. E.g. Quality, Syntax, ...
		/// </summary>
		private Enumerations.InterfaceModel interfaceModel;

		/// <summary>
		/// A description of the pattern.
		/// </summary>
		private string description;

		/// <summary>
		/// The source of the pattern. I.e. where it was described first.
		/// </summary>
		private string source;

		/// <summary>
		/// A list of mismatches that can be corrected by the use of this 
		/// pattern.
		/// </summary>
		private ArrayList mismatches;

		/// <summary>
		/// A list of templates for the adaptor that can be generated for this
		/// pattern.
		/// </summary>
		private ArrayList adaptorTemplates;

		/// <summary>
		/// A list of prediction models belonging to this pattern.
		/// </summary>
		private ArrayList predictionModels;
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a new empty PatternDescription.
		/// </summary>
		internal PatternDescription()
		{
			mismatches = new ArrayList();
			adaptorTemplates = new ArrayList();
			this.predictionModels = new ArrayList();
		}
		#endregion

		#region properties
		/// <summary>
		/// The name of this pattern.
		/// </summary>
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

		/// <summary>
		/// The name of the interface model this pattern is able to correct 
		/// mismatches of.
		/// </summary>
		public Enumerations.InterfaceModel InterfaceModel 
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

		/// <summary>
		/// A description of the pattern.
		/// </summary>
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

		/// <summary>
		/// The source where this pattern has been described first.
		/// </summary>
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

		/// <summary>
		/// A list of mismatches that can be corrected by the use of this 
		/// pattern.
		/// </summary>
		public IList MismatchAttributes
		{
			get
			{
				return mismatches;
			}
		}

		/// <summary>
		/// A list of templates to generate the adapter belonging to this
		/// pattern.
		/// </summary>
		public IList AdapterTemplates
		{
			get
			{
				return adaptorTemplates;
			}
		}

		/// <summary>
		/// A list of prediction models for this pattern.
		/// </summary>
		public IList PredictionModels
		{
			get
			{
				return predictionModels;
			}
		}
		#endregion 

		#region public methods
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
		public IMismatchAttribute GetMismatchAttribute (string attributeName)
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

		/// <summary>
		/// Overrides GetHashCode. This is necessary, because Equals is 
		/// overridden.
		/// </summary>
		/// <returns>The hashcode of this object.</returns>
		public override int GetHashCode()
		{
			return base.GetHashCode ();
		}

		/// <summary>
		/// Getter for prediction models. 
		/// </summary>
		/// <param name="name">The name of the searched prediction model.
		/// </param>
		/// <returns>The searched prediction model or null if there is no 
		/// prediction model with the given name.</returns>
		public IPredictionModel GetPredictionModelByName(string name)
		{
			foreach (PredictionModel predictionModel in this.predictionModels)
			{
				if (name.Equals(predictionModel.Name))
					return predictionModel;
			}
			return null;
		}
		#endregion

		#region internal methods
		/// <summary>
		/// Adds a QoSattribute to the list of attributes the 
		/// description holds. 
		/// </summary>
		/// <param name="attribute">A new QoSAttribute</param>
		internal void AddMismatchAttribute (MismatchAttribute attribute)
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
		internal void AddAdaptorTemplate (string template)
		{
			adaptorTemplates.Add(template);
		}

		/// <summary>
		/// Adds a prediction model to this pattern description.
		/// </summary>
		/// <param name="pModel">A PredictionModel object.</param>
		internal void AddPredictionModel(PredictionModel pModel)
		{
			this.predictionModels.Add(pModel);
		}
		#endregion
	}
}

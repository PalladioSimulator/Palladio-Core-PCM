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
	/// Public interface of a PatternDescription.
	/// 
	/// All constructors and setters are implemented as internal. The 
	/// interface only provides read methods.
	/// </summary>
	public interface IPatternDescription
	{
		#region properties
		/// <summary>
		/// The name of this pattern.
		/// </summary>
		string Name {get;}

		/// <summary>
		/// The name of the interface model this pattern is able to correct 
		/// mismatches of.
		/// </summary>
		Enumerations.InterfaceModel InterfaceModel {get;}

		/// <summary>
		/// A description of the pattern.
		/// </summary>
		string Description{get;}

		/// <summary>
		/// The source where this pattern has been described first.
		/// </summary>
		string Source{get;}

		/// <summary>
		/// A list of mismatches that can be corrected by the use of this 
		/// pattern.
		/// </summary>
		IList MismatchAttributes{get;}

		/// <summary>
		/// A list of templates to generate the adapter belonging to this
		/// pattern.
		/// </summary>
		IList AdapterTemplates{get;}

		/// <summary>
		/// A list of prediction models for this pattern.
		/// </summary>
		IList PredictionModels{get;}
		#endregion

		#region methods
		/// <summary>
		/// Checks if this PatternDescription covers the given QoS attribute.
		/// </summary>
		/// <param name="attributeName">The name of a QoS attribute.</param>
		/// <returns>True if this description covers the given attribute. Else
		/// false.</returns>
		bool HasMismatchAttribute(string attributeName);

		/// <summary>
		/// Returns the QoSAttribute with the given name. It is assumed that 
		/// there is only one attribute with the given name. 
		/// </summary>
		/// <param name="attributeName">The name of the searched QoSAttribute.
		/// </param>
		/// <returns>The QoSAttribute, if it is in the attribute list of this
		/// PatternDescription. Else null.</returns>
		IMismatchAttribute GetMismatchAttribute (string attributeName);

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
		bool Equals(object obj);

		/// <summary>
		/// Getter for prediction models. 
		/// </summary>
		/// <param name="name">The name of the searched prediction model.
		/// </param>
		/// <returns>The searched prediction model or null if there is no 
		/// prediction model with the given name.</returns>
		IPredictionModel GetPredictionModelByName(string name);
		#endregion
	}
}

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

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Common interface of all QMLStatConstraints. Used e.g. in 
	/// QMLAspectConstraint as common interface of all aspects.
	/// </summary>
	public interface IQMLStatConstraint
	{
		/// <summary>
		/// Getter for the aspect type. Not implemented as property, because
		/// properties are not allowed in interfaces.
		/// </summary>
		/// <returns>The type of implementing aspect. The value is specified in 
		/// QMLParser.QMLTokenTypes.</returns>
		int Type{get;}
	}
}

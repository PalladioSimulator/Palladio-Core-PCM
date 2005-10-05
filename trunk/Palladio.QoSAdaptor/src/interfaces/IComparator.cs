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
using System.IO;

namespace Palladio.QoSAdaptor
{
	/// <summary>
	/// Describes an interface for the comparison of the interface required by
	/// on component and the interface provided by another component. Thereby
	/// it abstracts from the considered interface model. This could be 
	/// syntax-based, behavioral, interaction-based, conceptual or 
	/// quality-based, which is used in this prototypical implementation.
	/// </summary>
	public interface IComparator
	{
		/// <summary>
		/// This method is used to find mismatches between the two given 
		/// interface model descriptions. TextReader are used to abstract from
		/// the considered interface model. It is thereby assumed, that every
		/// interface model can be described in a text representation. 
		/// 
		/// TODO: Is this OK or should object be taken as parameter type?
		/// 
		/// It is furthermore assumed that the returned IList contains objects
		/// of type IMismatch.
		/// 
		/// TODO: Introduce IMismatch -> Are there similarities of the 
		/// mismatches of the different interface models?
		/// </summary>
		/// <param name="required">An interface model description of the 
		/// required interface.</param>
		/// <param name="provided">An interface model description of the 
		/// provided interface.</param>
		/// <returns>A list of interface mismatches.</returns>
		IList FindMismatches(TextReader required, TextReader provided);

		/// <summary>
		/// Returns a string representation of the internal interface model 
		/// desription of the required interface model. 
		/// </summary>
		string RequiredSpecificationString{get;}

		/// <summary>
		/// Returns a string representation of the internal interface model 
		/// desription of the provided interface model. 
		/// </summary>
		string ProvidedSpecificationString{get;}
	}
}

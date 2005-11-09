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
using Palladio.Utils.Collections;

namespace Palladio.QoSAdaptor.Control
{
	/// <summary>
	/// Interface to be implemented by all strategys for automated pattern
	/// preselection.
	/// </summary>
	public interface IPatternPreselectionStrategy
	{
		/// <summary>
		/// Preselects patterns from the given patterns collection that can fix
		/// the given mismatches. Thereby each mismatch is considered 
		/// separately.
		/// </summary>
		/// <param name="mismatches">A collection of IMismatch objects.</param>
		/// <param name="patterns">A collection of IPatternDescription objects.
		/// </param>
		/// <returns>A hashmap that indicates an ICollection of 
		/// IPatternDescriptions for each of the given mismatches.</returns>
		Hashmap PreselectPatterns(ICollection mismatches, 
			ICollection patterns);	
	}
}

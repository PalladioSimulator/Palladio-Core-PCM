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

using Palladio.QoSAdaptor.Pattern;
using Palladio.Utils.Collections;

namespace Palladio.QoSAdaptor.PatternSelection
{
	/// <summary>
	/// The provided interface of the Palladio.QoSAdaptor.PatternSelection
	/// component.
	/// </summary>
	public interface ISelector
	{
		/// <summary>
		/// Starts the selection process, using a GUI where the user gets an 
		/// overview over found mismatches and patterns that are able to 
		/// correct these mismatches and returns a pattern chosen by the user. 
		/// </summary>
		/// <param name="mismatchSolvingPatterns">A hashmap containing 
		/// mismatches and a list of PatternsDescriptions of patterns able to 
		/// correct these mismatches.</param>
		/// <param name="requiredSpecification">Textual representation of the 
		/// required specification.</param>
		/// <param name="providedSpecification">Textual representation of the 
		/// provided specification.</param>
		/// <returns>The PatternsDescription of the chosen pattern.</returns>
		IPatternDescription StartSelection(Hashmap mismatchSolvingPatterns, 
											string requiredSpecification, 
											string providedSpecification);
	}
}

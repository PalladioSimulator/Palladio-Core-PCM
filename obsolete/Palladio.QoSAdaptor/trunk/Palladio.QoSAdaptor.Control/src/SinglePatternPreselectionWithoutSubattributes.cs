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
using Palladio.QoSAdaptor.Interfaces;
using Palladio.QoSAdaptor.Pattern;
using Palladio.Utils.Collections;

namespace Palladio.QoSAdaptor.Control
{
	/// <summary>
	/// Implementation of IPatternPreselectionStrategy that does not 
	/// consider subattributes of mismatches.
	/// </summary>
	public class SinglePatternPreselectionWithoutSubattributes : 
		IPatternPreselectionStrategy
	{
		#region public methods
		/// <summary>
		/// Preselects patterns from the given patterns collection that can fix
		/// the given mismatches. Thereby each mismatch is considered 
		/// separately.
		/// This strategy only searches for attributes. Subattributes are not 
		/// considered. Each pattern is considered separately. Dependencies 
		/// between different patterns are not considered.
		/// </summary>
		/// <param name="mismatches">A collection of IMismatch objects.</param>
		/// <param name="patterns">A collection of IPatternDescription objects.
		/// </param>
		/// <returns>A hashmap that indicates an ICollection of 
		/// IPatternDescriptions for each of the given mismatches.</returns>
		public Hashmap PreselectPatterns(ICollection mismatches, 
			ICollection patterns)
		{
			Hashmap selectedPatterns = new Hashmap();

			// Create a list of PatternDescriptions that cover the 
			// mismatched attributes found by the Comparator. The list 
			// should not contain duplicates.
			foreach (IMismatch mismatch in mismatches)
			{
				IList mismatchPatterns = new ArrayList();
				string attribute = mismatch.MismatchAttribute;
				// Find patterns that cover the mismatches and have a 
				// suitability of + or ++
				foreach (IPatternDescription pattern in patterns)
				{
					if (pattern.HasMismatchAttribute(attribute))
					{
						IMismatchAttribute mismatchAttribute = pattern.
							GetMismatchAttribute(attribute);
						if ((mismatchAttribute.Suitability == 
							SuitabilityValue.PLUS) ||
							(mismatchAttribute.Suitability ==
								SuitabilityValue.PLUSPLUS))
						{
							mismatchPatterns.Add(pattern);
						}
					}
				}
				selectedPatterns.Add(mismatch, mismatchPatterns);
			}

			return selectedPatterns;
		}
		#endregion
	}
}

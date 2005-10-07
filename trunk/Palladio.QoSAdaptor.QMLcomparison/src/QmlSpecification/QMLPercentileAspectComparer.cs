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

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Implements an IComparer for QMLPercentileAspects. This is used to sort 
	/// lists of percentile aspects.
	/// It is expected that QMLPercentileAspect.Compare() only compares the
	/// percentiles and not the numeric operators or values.
	/// </summary>
	public class QMLPercentileAspectComparer : IComparer
	{
		/// <summary>
		/// Compares two QMLPercentileAspects.
		/// </summary>
		/// <param name="aspect1">A QMLPercentileAspect object.</param>
		/// <param name="aspect2">Another QMLPercentileAspect object.</param>
		/// <returns>An int smaller than 0 if aspect1 is smaller than 
		/// aspect2. 0 if they are equal and a value greater than 0
		/// if aspect1 is bigger than aspect2.</returns>
		public int Compare (object aspect1, object aspect2)
		{
			// TODO: Throw exception if the aspects have the wrong type
			return ((QMLPercentileAspect)aspect1).Compare(
				(QMLPercentileAspect)aspect2);
		}
	}
}

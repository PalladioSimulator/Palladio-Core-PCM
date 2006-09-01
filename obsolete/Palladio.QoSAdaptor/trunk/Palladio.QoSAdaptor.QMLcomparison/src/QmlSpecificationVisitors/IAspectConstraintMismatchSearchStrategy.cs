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

using Palladio.QoSAdaptor.QMLComparison.QmlSpecification;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors
{
	/// <summary>
	/// Interface for strategies to find mismatches in aspect constraints.
	/// </summary>
	public interface IAspectConstraintMismatchSearchStrategy
	{
		#region methods
		/// <summary>
		/// Searches for mismatches between required and provided aspect
		/// constraints.
		/// </summary>
		/// <param name="requiredConstraint">QMLAspectConstraint of the 
		/// required interface.</param>
		/// <param name="providedConstraint">QMLAspectConstraint of the 
		/// required interface.</param>
		/// <returns>A string that describes details about the found 
		/// mismatches.</returns>
		string FindAspectConstraintMismatches(QMLAspectConstraint 
			requiredConstraint, QMLAspectConstraint providedConstraint);
		#endregion
	}
}

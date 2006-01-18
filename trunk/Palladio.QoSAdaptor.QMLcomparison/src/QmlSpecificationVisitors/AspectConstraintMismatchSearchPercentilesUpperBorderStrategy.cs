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
using Palladio.QoSAdaptor.QMLComparison.QmlSpecification;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors
{
	/// <summary>
	/// IAspectConstraintMismatchSearchStrategy that only considers percentile
	/// aspect. These are interpreted as upper border values. For further 
	/// interpretations see diploma thesis mentioned in the info region.
	/// </summary>
	public class AspectConstraintMismatchSearchPercentilesUpperBorderStrategy : 
		IAspectConstraintMismatchSearchStrategy
	{
		#region public methods
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
		public string FindAspectConstraintMismatches(QMLAspectConstraint 
			requiredConstraint, QMLAspectConstraint providedConstraint)
		{
			string mismatchDetails = string.Empty;
			ArrayList providedPercentiles = new ArrayList();
			foreach (IQMLStatConstraint aspect in 
				providedConstraint.StatConstraints)
			{
				switch (aspect.Type)
				{
					case QMLTokenTypes.FREQUENCY_CONTR:
						// not considered in this implementation
						break;
					case QMLTokenTypes.MEAN_CONTR:
						// not considered in this implementation
						break;
					case QMLTokenTypes.PERCENTILE_CONTR:
						providedPercentiles.Add(aspect);
						break;
					case QMLTokenTypes.VARIANCE_CONTR:
						// not considered in this implementation
						break;
					default:
						throw new QMLMismatchSearchException("Unknown aspect "+
							"type: "+aspect.Type);
				}
			}

			ArrayList requiredPercentiles = new ArrayList();
			foreach (IQMLStatConstraint requiredAspect in 
				requiredConstraint.StatConstraints)
			{
				switch (requiredAspect.Type)
				{
					case QMLTokenTypes.FREQUENCY_CONTR:
						// not considered in this implementation
						break;
					case QMLTokenTypes.MEAN_CONTR:
						// not considered in this implementation
						break;
					case QMLTokenTypes.PERCENTILE_CONTR:
						requiredPercentiles.Add(requiredAspect);
						break;
					case QMLTokenTypes.VARIANCE_CONTR:
						// not considered in this implementation
						break;
					default:
						throw new QMLMismatchSearchException("Unknown aspect "+
							"type: "+requiredAspect.Type);
				}
			}
			mismatchDetails += FindPercentileMismatches(
				providedPercentiles, requiredPercentiles);

			return mismatchDetails;			
		}

		/// <summary>
		/// Searches for mismatches between required and provided percentile
		/// definitions.
		/// </summary>
		/// <param name="providedPercentiles">ArrayList of 
		/// QMLPercentileAspects of the provided interface.</param>
		/// <param name="requiredPercentiles">ArrayList of 
		/// QMLPercentileAspects of the required interface.</param>
		/// <returns>A string that describes details about the found 
		/// mismatches or string.Empty, if at least one of the lists is empty.
		/// </returns>
		private string FindPercentileMismatches(ArrayList providedPercentiles, 
			ArrayList requiredPercentiles)
		{
			if ((requiredPercentiles.Count > 0) && 
				(providedPercentiles.Count > 0))
			{
				// Sort the percentile lists so they start with the smallest 
				// percentile.
				IComparer comparer = new QMLPercentileAspectComparer();
				providedPercentiles.Sort(comparer);
				requiredPercentiles.Sort(comparer);
			
				// Constraint: Percentiles are only compared if they all share the
				// same numeric operator
				// TODO: implementation for groups like (<, <=, ==) or (>, >=, ==)
				int numericOperator = GetSharedNumericOperator(providedPercentiles, 
					requiredPercentiles);
				switch (numericOperator)
				{
					case QMLTokenTypes.NUMOP_EQUAL:
						throw new QMLMismatchSearchException("Error in "+
							"QMLAspectConstraint.PercentilesMatch(). Numeric "+
							"operator == is not supported in the current "+
							"implementation of mismatch search for percentiles.");
					case QMLTokenTypes.NUMOP_GTHAN:
						throw new QMLMismatchSearchException("Error in "+
							"QMLAspectConstraint.PercentilesMatch(). Numeric "+
							"operator > is not supported in the current "+
							"implementation of mismatch search for percentiles.");
					case QMLTokenTypes.NUMOP_GTE:
						throw new QMLMismatchSearchException("Error in "+
							"QMLAspectConstraint.PercentilesMatch(). Numeric "+
							"operator >= is not supported in the current "+
							"implementation of mismatch search for percentiles.");
					case QMLTokenTypes.NUMOP_LTHAN:
						return MatchLessThanPercentiles(providedPercentiles, 
							requiredPercentiles);					
					case QMLTokenTypes.NUMOP_LTE:
						throw new QMLMismatchSearchException("Error in "+
							"QMLAspectConstraint.PercentilesMatch(). Numeric "+
							"operator <= is not supported in the current "+
							"implementation of mismatch search for percentiles.");
					case -1:
						throw new QMLMismatchSearchException("Error in "+
							"QMLAspectConstraint.PercentilesMatch(). In the "+
							"current implementation of the mismatch search all "+
							"percentiles of an aspect constraint have to have "+
							"the same numeric operator.");
					case -2:
						throw new QMLMismatchSearchException("Error in "+
							"QMLAspectConstraint.PercentilesMatch(). The given "+
							"percentile lists are empty.");
					default:
						throw new QMLMismatchSearchException("Error in "+
							"QMLAspectConstraint.PercentilesMatch(). Unknown "+
							"numeric operator: "+numericOperator);

				}
			}
			else 
				return string.Empty;
		}
		#endregion

		#region private methods
		/// <summary>
		/// Checks if the function described by the percentiles in 
		/// providedPercentiles matches the function described by the 
		/// percentiles in requiredPercentiles. 
		/// It is assumed that all percentiles have the numeric operator 
		/// QMLTokenTypes.NUMOP_LTHAN and the lists are sorted by
		/// percentiles starting with the lowest percentile.
		/// </summary>
		/// <param name="providedPercentiles">List of percentiles defined for the
		/// provided interface.</param>
		/// <param name="requiredPercentiles">List of percentiles defined for 
		/// the required interface.</param>
		/// <returns>string.Empty if thisPercentiles matches requiredPercentiles.
		/// Else string that provides further details abaout the mismatch.
		/// </returns>
		private string MatchLessThanPercentiles(ArrayList providedPercentiles, 
			ArrayList requiredPercentiles)
		{
			string mismatchDetail = string.Empty;
			double currentPercentile = 0;
			// Simple implementation of a percentile match. Performance could
			// be enhanced in a future version.
			foreach (QMLPercentileAspect providedAspect in 
				providedPercentiles)
			{
				foreach (QMLPercentileAspect requiredAspect in 
					requiredPercentiles)
				{
					if (requiredAspect.Percentile > currentPercentile)
					{
						if (requiredAspect.Value < providedAspect.Value)
						{
							mismatchDetail += "Required: "+
								requiredAspect.ToString()+"   Provided: "+
								providedAspect.ToString()+"\n";
						}
							
					}	
				}	
				currentPercentile = providedAspect.Percentile;
			}
			return mismatchDetail;
		}

		/// <summary>
		/// Tries to find and return a shared numeric operator of the given 
		/// lists. The lists are expected to contain QMLPercentileAspect 
		/// objects that all have the same numeric operator. If this is not the
		/// case, -1 is returned. 
		/// </summary>
		/// <param name="percentiles1">A list of QMLPercentileAspects.</param>
		/// <param name="percentiles2">A second list of QMLPercentileAspects.
		/// </param>
		/// <returns>The shared numeric operator or -1 if the list do not 
		/// only contain QMLPercentileAspects or different numeric operators
		/// are used in the different QMLPercentileAspects. -2 is returned
		/// if both lists are empty.</returns>
		private int GetSharedNumericOperator (IList percentiles1, 
			IList percentiles2)
		{
			int numericOperator = -2;
			foreach (QMLPercentileAspect aspect in percentiles1)
			{
				// Set the initial value of numericOperator
				if (numericOperator == -2)
					numericOperator = aspect.NumericOperator;
				else if (numericOperator != aspect.NumericOperator)
				{
					numericOperator = -1;
					break;
				}
			}
			if (!(numericOperator == -1))
			{
				foreach (QMLPercentileAspect aspect in percentiles2)
				{
					// Set the initial value of numericOperator if the first 
					// list should be empty.
					if (numericOperator == -2)
						numericOperator = aspect.NumericOperator;
					else if (numericOperator != aspect.NumericOperator)
					{
						numericOperator = -1;
						break;
					}
				}
			}
			return numericOperator;
		}
		#endregion
	}
}

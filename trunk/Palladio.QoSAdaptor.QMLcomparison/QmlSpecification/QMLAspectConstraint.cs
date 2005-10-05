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
using System;
using System.Collections;
using antlr.collections;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a QML aspect constraint.
	/// TODO: Inherit from superclass/interface QMLConstraint?
	/// </summary>
	public class QMLAspectConstraint
	{
		#region data
		private string name;
		private ArrayList statConstraints;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLAspectConstraint containing the same information as the AST.
		/// </summary>
		/// <param name="aspectConstraint">AST representing a QML aspect 
		/// constraint.</param>
		public QMLAspectConstraint(AST aspectConstraint)
		{
			// check if the AST has the correct root node
			if (!aspectConstraint.getText().Equals("aspectConstr"))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLAspectConstraint constructor. "+
					"node name -aspectConstr- expected, but is -"+
					aspectConstraint.getText()+"-");

			AST child = aspectConstraint.getFirstChild();
			this.name = child.getText();

			this.statConstraints = new ArrayList();
			child = child.getNextSibling();
			for (int i=0; i<aspectConstraint.getNumberOfChildren()-1; i++)
			{
				switch (child.Type)
				{
					case QMLTokenTypes.PERCENTILE_CONTR:
						this.statConstraints.Add(
											new QMLPercentileAspect(child));
						break;
					case QMLTokenTypes.FREQUENCY_CONTR:
						this.statConstraints.Add(
							new QMLFrequencyAspect(child));
						break;
					case QMLTokenTypes.MEAN_CONTR:
						this.statConstraints.Add(
							new QMLMeanAspect(child));
						break;
					case QMLTokenTypes.VARIANCE_CONTR:
						this.statConstraints.Add(
							new QMLVarianceAspect(child));
						break;
					default:
						throw new QMLSpecificationConstructionException
							("Illegal argument in QMLAspectConstraint "+
							"constructor. Unknown aspect type: "
							+child.Type);
				}
				child = child.getNextSibling();
			}
		}
		#endregion

		#region properties	
		/// <summary>
		/// Returns the name (QoS aspect) of this QMLAspectConstraint
		/// </summary>
		public string Name
		{
			get
			{
				return this.name;
			}
		}

		/// <summary>
		/// Returns the aspects (percentile, mean, variance, frequency) of
		/// this QMLAspectConstraint.
		/// </summary>
		public IList StatConstraints
		{
			get
			{
				return this.statConstraints;
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML aspect constraint string containing all 
		/// information in this QMLAspectConstraint which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML aspect constraint.</returns>
		public override string ToString()
		{
			string s = this.name+"{\n";
			IEnumerator enu = this.statConstraints.GetEnumerator();
			while (enu.MoveNext())
				s += ((IQMLStatConstraint)enu.Current).ToString()+"\n";
			s += "};";
			return s;
		}

		/// <summary>
		/// Checks if this QMLAspectConstraint matches the given constraint.
		/// I.e. is better or equal to the given constraint. 
		/// As part of a mismatch search this constraint should be part of the
		/// provided specification while the given constraint should be part of the
		/// required specification
		/// </summary>
		/// <param name="requiredConstraint">QMLAspectConstraint that is part 
		/// of the required specification.</param>
		/// <returns>True if this constraint matches the given constraint, 
		/// else false.</returns>
		public bool Matches (QMLAspectConstraint requiredConstraint)
		{
			if (!this.name.Equals(requiredConstraint.Name))
				return false;

			bool match = true;
			ArrayList requiredPercentiles = new ArrayList();
			foreach (IQMLStatConstraint requiredAspect in 
				requiredConstraint.StatConstraints)
			{
				// Collect all QMLPercentileAspects, because they have to be 
				// compared as a whole.
				if (requiredAspect.Type() == QMLTokenTypes.PERCENTILE_CONTR)
					requiredPercentiles.Add(requiredAspect);
				else if (!AspectMatches(requiredAspect))
				{
					match = false;
					break;
				}
			}
			if (!PercentilesMatch(requiredPercentiles))
				match = false;
			return match;
		}
		#endregion

		#region private methods
		/// <summary>
		/// Checks if one of the aspects in this.statConstraints matches the 
		/// given aspect.
		/// </summary>
		/// <param name="requiredAspect">IQMLStatConstraint that is defined in
		/// the required specification.</param>
		/// <returns>True if one of the aspects of this QMLAspectContraint 
		/// matches the given aspect. Else false.</returns>
		private bool AspectMatches(IQMLStatConstraint requiredAspect)
		{
			bool check = false;
			// The loop is cancelled at the first finding of a matching 
			// aspect. One could search for redundant/invalid aspect 
			// definitions, which is not done for simplicity reasons.
			foreach (IQMLStatConstraint thisAspect in this.statConstraints)
			{
				if (thisAspect.Matches(requiredAspect))
				{
					check = true;
					break;
				}
			}
			return check;
		}

		private bool PercentilesMatch (ArrayList requiredPercentiles)
		{
			ArrayList thisPercentiles = GetThisPercentiles();
			// Sort the percentile lists so they start with the smallest 
			// percentile.
			IComparer comparer = new QMLPercentileAspectComparer();
			thisPercentiles.Sort(comparer);
			requiredPercentiles.Sort(comparer);
			
			// Constraint: Percentiles are only compared if they all share the
			// same numeric operator
			// TODO: implementation for groups like (<, <=, ==) or (>, >=, ==)
			int numericOperator = GetSharedNumericOperator(thisPercentiles, 
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
					return MatchLessThanPercentiles(thisPercentiles, 
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

		/// <summary>
		/// Searches this.statConstraints for all percentile aspects and 
		/// returns a list of them.
		/// </summary>
		/// <returns>IList with all QMLPercentileAspects of this aspect
		/// constraint.</returns>
		private ArrayList GetThisPercentiles()
		{
			ArrayList percentiles = new ArrayList();
			foreach (IQMLStatConstraint aspect in this.statConstraints)
				if (aspect.Type() == QMLTokenTypes.PERCENTILE_CONTR)
					percentiles.Add(aspect);
			return percentiles;
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

		/// <summary>
		/// Checks if the function described by the percentiles in 
		/// thisPercentiles matches the function described by the percentiles
		/// in requiredPercentiles. 
		/// It is assumed that all percentiles have the numeric operator 
		/// QMLTokenTypes.NUMOP_LTHAN and the lists are reverse sorted by
		/// percentiles starting with percentile 100.
		/// </summary>
		/// <param name="thisPercentiles">List of percentiles defined for the
		/// provided interface.</param>
		/// <param name="requiredPercentiles">List of percentiles defined for 
		/// the required interface.</param>
		/// <returns>True if thisPercentiles matches requiredPercentiles.
		/// Else false.</returns>
		private bool MatchLessThanPercentiles(ArrayList thisPercentiles, 
			ArrayList requiredPercentiles)
		{
			bool match = true;
			double currentPercentile = 0;
			// Simple implementation of a percentile match. Performance could
			// be enhanced in a future version.
			foreach (QMLPercentileAspect thisAspect in thisPercentiles)
			{
				foreach (QMLPercentileAspect requiredAspect in 
					requiredPercentiles)
				{
					if (requiredAspect.Percentile > currentPercentile)
					{
						if (requiredAspect.Value < thisAspect.Value)
						{
							match = false;
						}
							
					}	
				}	
				if (!match)
					break;
				else
					currentPercentile = thisAspect.Percentile;
			}
			return match;
		}
		#endregion
	}
}

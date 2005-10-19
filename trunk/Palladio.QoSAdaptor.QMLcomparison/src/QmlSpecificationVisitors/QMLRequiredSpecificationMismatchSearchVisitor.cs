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
using Palladio.QoSAdaptor.QMLComparison.QmlSpecification;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors
{
	/// <summary>
	/// Searches for mismatches between a QMLSpecification interpreted as 
	/// required specification and visited by an object of this class and a
	/// provided specification visited by an 
	/// QMLProvidedSpecificationMismatchSearchVisitor.
	/// After the mismatch search which is started by first calling the Accept
	/// method of the provided specification with the providedVisitor and then 
	/// calling the Accept method of the required specification with an object
	/// of this class, the found mismatches can be requested using the 
	/// Mismatches property.
	/// Some of the methods of the IQMLSpecificationVisitor interface are not 
	/// implemented, because the corresponding classes are not needed for the 
	/// mismatch search. A NotImplementedException is thrown instead.
	/// 
	/// TODO: exception handling, when the Current Property of the 
	/// providedVisitor is used.
	/// </summary>
	internal class QMLRequiredSpecificationMismatchSearchVisitor : 
		IQMLSpecificationVisitor
	{
		#region attributes
		/// <summary>
		/// Visitor of the provided specification.
		/// </summary>
		private QMLProvidedSpecificationMismatchSearchVisitor providedVisitor;

		/// <summary>
		/// A list of found mismatches.
		/// </summary>
		private ArrayList mismatches;

		/// <summary>
		/// The name of the currently visited interface. Null if no interface 
		/// is currently visited.
		/// </summary>
		private string currentInterfaceName;

		/// <summary>
		/// The name of the currently visited interface. Null if no entity is
		/// currently visited.
		/// </summary>
		private string currentEntityName;

		/// <summary>
		/// The name of the current mismatch attribute. Null if there is no 
		/// current mismatch attribute.
		/// </summary>
		private string currentMismatchAttribute;
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a new QMLRequiredSpecificationMismatchSearchVisitor. To
		/// start the mismatch search the provided specification has to be 
		/// visited by the given providedVisitor. After that this visitor has 
		/// to be given to the Accept method of the corresponding 
		/// QMLSpecification. 
		/// </summary>
		/// <param name="providedVisitor">The corresponding visitor of the 
		/// provided specification.</param>
		internal QMLRequiredSpecificationMismatchSearchVisitor(
			QMLProvidedSpecificationMismatchSearchVisitor providedVisitor)
		{
			this.mismatches = new ArrayList();
			this.providedVisitor = providedVisitor;
			this.currentEntityName = null;
			this.currentInterfaceName = null;
			this.currentMismatchAttribute = null;
		}
		#endregion

		#region properties
		/// <summary>
		/// Contains the found mismatches after a mismatch search.
		/// </summary>
		public IList Mismatches
		{
			get
			{
				return this.mismatches;
			}
		}
		#endregion

		#region methods by IQMLSpecificationVisitor
		/// <summary>
		/// Visit method for an QMLAspectConstraint.
		/// </summary>
		/// <param name="aspectConstraint">A QMLAspectConstraint whose Accept 
		/// method has been called.</param>
		public void VisitQMLAspectConstraint(QMLAspectConstraint 
			aspectConstraint)
		{
			QMLAspectConstraint providedConstraint = null;
			try
			{
				providedConstraint =
					(QMLAspectConstraint)this.providedVisitor.Current;
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" is QMLAspectConstraint. Invalid type is "+
					this.providedVisitor.Current.GetType());
			}

			if (!providedConstraint.Name.Equals(aspectConstraint.Name))
			{
				// TODO: throw exception	
			}

			bool match = true;
			string mismatchDetails = string.Empty;
			ArrayList providedPercentiles = new ArrayList();
			foreach (IQMLStatConstraint aspect in 
				providedConstraint.StatConstraints)
				if (aspect.Type == QMLTokenTypes.PERCENTILE_CONTR)
					providedPercentiles.Add(aspect);

			ArrayList requiredPercentiles = new ArrayList();
			foreach (IQMLStatConstraint requiredAspect in 
				aspectConstraint.StatConstraints)
			{
				// Collect all QMLPercentileAspects, because they have to be 
				// compared as a whole.
				if (requiredAspect.Type == QMLTokenTypes.PERCENTILE_CONTR)
					requiredPercentiles.Add(requiredAspect);
			//TODO: Overwork AspectMatches. Return mismatchDetails
				else 
					mismatchDetails += AspectMatches(
						providedConstraint.StatConstraints, requiredAspect);
			}

			if ((requiredPercentiles.Count > 0) && 
				(providedPercentiles.Count > 0))
			{
				mismatchDetails += PercentilesMatch(providedPercentiles,
					requiredPercentiles);
			}
			if (!mismatchDetails.Equals(string.Empty))
				match = false;
			
			if (!match)
			{
				QMLMismatch mismatch = new QMLMismatch(
					this.currentInterfaceName, this.currentEntityName, 
					this.currentMismatchAttribute, aspectConstraint.Name, 
					mismatchDetails);
				this.mismatches.Add(mismatch);
			}
		}


		/// <summary>
		/// Visit method for an QMLContract.
		/// </summary>
		/// <param name="contract">A QMLContract whose Accept 
		/// method has been called.</param>
		public void VisitQMLContract(QMLContract contract)
		{
			this.providedVisitor.GoToContractExpression();
			contract.ContractExpression.Accept(this);
			this.providedVisitor.GoUp();
		}


		/// <summary>
		/// Visit method for an QMLContractExpression.
		/// </summary>
		/// <param name="contractExpression">A QMLContractExpression whose 
		/// Accept method has been called.</param>
		public void VisitQMLContractExpression(QMLContractExpression 
			contractExpression)
		{
			this.currentMismatchAttribute = contractExpression.Name;
			QMLContractExpression providedContractExpression = null;
			try
			{
				providedContractExpression = 
					(QMLContractExpression)this.providedVisitor.Current;
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" is QMLContractExpression. Invalid type is "+
					this.providedVisitor.Current.GetType());
			}

			// Throw exception if the expressions don't describe the same
			// QoS aspect.
			if (!providedContractExpression.Name.Equals(
				contractExpression.Name))
				throw new QMLMismatchSearchException("Error in "+
					"QMLContractExpression.Matches. The required expression "+
					"does not cover the same QoS aspect as the provided "+
					"expression. Required: "+contractExpression.Name+
					". Provided: "+providedContractExpression.Name+".");

			// Check all simple constraints.
			foreach (QMLSimpleConstraint requiredConstraint in 
				contractExpression.SimpleConstraints)
				FindSimpleConstraintContractExpressionMismatches(
					providedContractExpression.SimpleConstraints,
					requiredConstraint);

			// Check all aspect constraints
			foreach (QMLAspectConstraint requiredConstraint in 
				contractExpression.AspectConstraints)
				FindAspectConstraintContractExpressionMismatches(
					providedContractExpression.AspectConstraints,
					requiredConstraint);

			this.currentMismatchAttribute = null;
		}


		/// <summary>
		/// Visit method for an QMLContractType.
		/// </summary>
		/// <param name="contractType">A QMLContractType whose Accept 
		/// method has been called.</param>
		public void VisitQMLContractType(QMLContractType contractType)
		{
			throw new NotImplementedException();
		}


		/// <summary>
		/// Visit method for an QMLDimensionDeclaration.
		/// </summary>
		/// <param name="dimensionDeclaration">A QMLDimensionDeclaration whose 
		/// Accept method has been called.</param>
		public void VisitQMLDimensionDeclaration(QMLDimensionDeclaration 
			dimensionDeclaration)
		{
			throw new NotImplementedException();
		}


		/// <summary>
		/// Visit method for an QMLDimensionType.
		/// </summary>
		/// <param name="dimensionType">A QMLDimensionType whose Accept 
		/// method has been called.</param>
		public void VisitQMLDimensionType(QMLDimensionType dimensionType)
		{
			throw new NotImplementedException();
		}


		/// <summary>
		/// Visit method for an QMLEntity.
		/// </summary>
		/// <param name="entity">A QMLEntity whose Accept 
		/// method has been called.</param>
		public void VisitQMLEntity(QMLEntity entity)
		{
			throw new NotImplementedException();
		}


		/// <summary>
		/// Visit method for an QMLFrequencyAspect.
		/// </summary>
		/// <param name="frequencyAspect">A QMLFrequencyAspect whose Accept 
		/// method has been called.</param>
		public void VisitQMLFrequencyAspect(QMLFrequencyAspect frequencyAspect)
		{
			throw new NotImplementedException();
		}


		/// <summary>
		/// Visit method for an QMLMeanAspect.
		/// </summary>
		/// <param name="meanAspect">A QMLMeanAspect whose Accept 
		/// method has been called.</param>
		public void VisitQMLMeanAspect(QMLMeanAspect meanAspect)
		{
			throw new NotImplementedException();
		}
		

		/// <summary>
		/// Visit method for an QMLPercentileAspect.
		/// </summary>
		/// <param name="percentileAspect">A QMLPercentileAspect whose Accept 
		/// method has been called.</param>
		public void VisitQMLPercentileAspect(QMLPercentileAspect 
			percentileAspect)
		{
			throw new NotImplementedException();
		}
		

		/// <summary>
		/// Visit method for an QMLProfile.
		/// </summary>
		/// <param name="profile">A QMLProfile whose Accept 
		/// method has been called.</param>
		public void VisitQMLProfile(QMLProfile profile)
		{	
			this.currentInterfaceName = profile.InterfaceName;
			this.providedVisitor.GoToProfileExpression();
			profile.ProfileExpression.Accept(this);
			this.providedVisitor.GoUp();
			this.currentInterfaceName = null;
		}


		/// <summary>
		/// Visit method for an QMLProfileExpression.
		/// </summary>
		/// <param name="profileExpression">A QMLProfileExpression whose Accept 
		/// method has been called.</param>
		public void VisitQMLProfileExpression(QMLProfileExpression 
			profileExpression)
		{
			foreach (QMLRequirementClause requiredClause in 
				profileExpression.RequirementClauses)
			{
				if (requiredClause.Entities.Count == 0)
				{
					FindInterfaceRelatedClauseMismatches(requiredClause);
				}
				else
				{
					FindEntityRelatedClauseMismatches(requiredClause);
				}
			}
		}
		

		/// <summary>
		/// Visit method for an QMLRequirementClause.
		/// </summary>
		/// <param name="requirementClause">A QMLRequirementClause whose Accept 
		/// method has been called.</param>
		public void VisitQMLRequirementClause(QMLRequirementClause 
			requirementClause)
		{
			foreach (QMLContract contract in requirementClause.Contracts)
			{
				QMLRequirementClause providedRequirementClause = null;
				try
				{
					providedRequirementClause = 
						(QMLRequirementClause)this.providedVisitor.Current;
				}
				catch (InvalidCastException e)
				{
					throw new QMLMismatchSearchException(e.Message+"Expected type"+
						" is QMLRequirementClause. Invalid type is "+
						this.providedVisitor.Current.GetType());
				}

				foreach (QMLContract providedContract in 
					providedRequirementClause.Contracts)
				{
					// TODO: Source this out to QMLContract and 
					// QMLContractExpression
					if (contract.ContractExpression.Name.Equals(
						providedContract.ContractExpression.Name))
					{
						this.providedVisitor.GoToContract(providedContract);
						contract.Accept(this);
						this.providedVisitor.GoUp();
					}
						
				}
			}
		}
		

		/// <summary>
		/// Visit method for an QMLSimpleConstraint.
		/// </summary>
		/// <param name="simpleConstraint">A QMLSimpleConstraint whose Accept 
		/// method has been called.</param>
		public void VisitQMLSimpleConstraint(QMLSimpleConstraint 
			simpleConstraint)
		{

			QMLSimpleConstraint providedConstraint = null;
			try
			{
				providedConstraint =
					(QMLSimpleConstraint)this.providedVisitor.Current;
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" is QMLSimpleConstraint. Invalid type is "+
					this.providedVisitor.Current.GetType());
			}

			if (!providedConstraint.Name.Equals(simpleConstraint.Name))
			{
				// TODO: throw exception
			}

			// The units are not taken into consideration since they do not 
			// have to be given. 
			// Only the matches are described in the following switch 
			// statement. Everything else is defined as not matched and 
			// false is returned.

			// Matching has to be checked for every possible numericOperator
			// of the given constraint.
			bool check = false;
			switch (simpleConstraint.NumericOperator)
			{
				case QMLTokenTypes.NUMOP_EQUAL:
					if ((providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL) 
						&&
						providedConstraint.ValueLiteral.Equals(
							simpleConstraint.ValueLiteral))
						check =  true;
					break;
				case QMLTokenTypes.NUMOP_GTE:
					if (((providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_GTE) 
						||
						(providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL) 
						||
						(providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_GTHAN)
						)
						&&
						(providedConstraint.ValueLiteral.CompareTo(
							simpleConstraint.ValueLiteral) >= 0))
						check = true;
					break;
				case QMLTokenTypes.NUMOP_GTHAN:
					if (((providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_GTHAN) 
						&&
						(providedConstraint.ValueLiteral.CompareTo(
						simpleConstraint.ValueLiteral) >= 0)
						) 
						||
						(((providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_GTE) 
						||
						(providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL)
						) 
						&&
						(providedConstraint.ValueLiteral.CompareTo(
						simpleConstraint.ValueLiteral) > 0)))
						check = true;
					break;
				case QMLTokenTypes.NUMOP_LTE:
					if (((providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL) 
						||
						(providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_LTE) 
						||
						(providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_LTHAN)
						) 
						&&
						(providedConstraint.ValueLiteral.CompareTo(
						simpleConstraint.ValueLiteral) <= 0))
						check = true;
					break;
				case QMLTokenTypes.NUMOP_LTHAN:
					if (((providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_LTHAN) 
						&& 
						(providedConstraint.ValueLiteral.CompareTo(
						simpleConstraint.ValueLiteral) <= 0)
						) 
						||
						(((providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL)
						||
						(providedConstraint.NumericOperator == 
						QMLTokenTypes.NUMOP_LTE)
						)
						&&
						(providedConstraint.ValueLiteral.CompareTo(
						simpleConstraint.ValueLiteral) < 0)))
						check = true;
					break;

			}
			if (!check)
			{
				string mismatchDetails = "Mismatched simple constraint: "+
					simpleConstraint.ToString();
				QMLMismatch mismatch = new QMLMismatch(this.currentInterfaceName, 
					this.currentEntityName, this.currentMismatchAttribute,
					simpleConstraint.Name, mismatchDetails);
				this.mismatches.Add(mismatch);
			}
		}
		

		/// <summary>
		/// Visit method for an QMLSpecification.
		/// </summary>
		/// <param name="specification">A QMLSpecification whose Accept 
		/// method has been called.</param>
		public void VisitQMLSpecification(QMLSpecification specification)
		{
			// For every profile specified in this specification it has to be
			// verfied that the provided specification does not mismatch the
			// required specification
			foreach (QMLProfile profile in specification.Profiles)
			{
				this.providedVisitor.GoToProfile(profile.InterfaceName);
				profile.Accept(this);
				this.providedVisitor.GoUp();
			}
		}
		

		/// <summary>
		/// Visit method for an QMLUnit.
		/// </summary>
		/// <param name="unit">A QMLUnit whose Accept 
		/// method has been called.</param>
		public void VisitQMLUnit(QMLUnit unit)
		{
			throw new NotImplementedException();
		}


		/// <summary>
		/// Visit method for an QMLValueLiteral.
		/// </summary>
		/// <param name="valueLiteral">A QMLValueLiteral whose Accept 
		/// method has been called.</param>
		public void VisitQMLValueLiteral(QMLValueLiteral valueLiteral)
		{
			throw new NotImplementedException();
		}
		

		/// <summary>
		/// Visit method for an QMLVarianceAspect.
		/// </summary>
		/// <param name="varianceAspect">A QMLVarianceAspect whose Accept 
		/// method has been called.</param>
		public void VisitQMLVarianceAspect(QMLVarianceAspect varianceAspect)
		{
			throw new NotImplementedException();
		}

		#endregion

		#region private methods
		/// <summary>
		/// Searches for interface related mismatches for the given
		/// requirement clause.
		/// </summary>
		/// <param name="requiredClause">QMLRequirementClause of the required
		/// interface.</param>
		private void FindInterfaceRelatedClauseMismatches(QMLRequirementClause
			requiredClause)
		{
			QMLProfileExpression providedProfileExpression = 
				(QMLProfileExpression)this.providedVisitor.Current;
			foreach (QMLRequirementClause providedClause in
				providedProfileExpression.RequirementClauses)
			{
				if (providedClause.Entities.Count == 0)
				{
					this.providedVisitor.GoToRequirementClause(
						providedClause);
					requiredClause.Accept(this);
					this.providedVisitor.GoUp();
				}
			}
		}

		/// <summary>
		/// Searches for entity related mismatches for the given
		/// requirement clause.
		/// </summary>
		/// <param name="requiredClause">QMLRequirementClause of the required
		/// interface.</param>
		private void FindEntityRelatedClauseMismatches(QMLRequirementClause
			requiredClause)
		{
			foreach (QMLEntity requiredEntity in 
				requiredClause.Entities)
			{
				QMLProfileExpression providedProfileExpression = 
					(QMLProfileExpression)this.providedVisitor.Current;
				foreach (QMLRequirementClause providedClause in 
					providedProfileExpression.RequirementClauses)
				{
					// search all entities of the current requirement 
					//clause
					if (providedClause.Entities.Count > 0)
					{
						foreach (QMLEntity providedEntity in 
							providedClause.Entities)
						{
							// TODO: Is this still correct for 
							// ENTITY_RESULT_OF?
							if (providedEntity.Name.Equals(
								requiredEntity.Name))
							{
								this.currentEntityName = providedEntity.Name;
								this.providedVisitor.
									GoToRequirementClause(
									providedClause);
								requiredClause.Accept(this);
								this.providedVisitor.GoUp();
								this.currentEntityName = null;
							}
						}
					}
				}
			}
		}

		/// <summary>
		/// Checks if the given QMLSimpleConstraint is matched by one of the
		/// simple constraints defined in the given providedConstraints 
		/// collection.
		/// </summary>
		/// <param name="providedConstraints">List of QMLSimpleConstraints of
		/// the provided specification.</param>
		/// <param name="requiredConstraint">QMLSimpleConstraint defined in 
		/// the required specification.</param>
		private void FindSimpleConstraintContractExpressionMismatches(
			ICollection providedConstraints,
			QMLSimpleConstraint requiredConstraint)
		{
			foreach (QMLSimpleConstraint providedConstraint in 
				providedConstraints)
			{
				
				this.providedVisitor.GoToSimpleConstraint(
					providedConstraint.Name);
				requiredConstraint.Accept(this);
				this.providedVisitor.GoUp();
			}
		}

		/// <summary>
		/// Checks if the given QMLAspectConstraint is matched by one of the
		/// aspect constraints defined in the given providedConstraints 
		/// collection.
		/// </summary>
		/// <param name="providedConstraints">List of QMLSimpleConstraints of
		/// the provided specification.</param>
		/// <param name="requiredConstraint">QMLAspectConstraint defined in 
		/// the required specification.</param>
		private void FindAspectConstraintContractExpressionMismatches(
			ICollection providedConstraints,
			QMLAspectConstraint requiredConstraint)
		{
			foreach (QMLAspectConstraint providedConstraint in 
				providedConstraints)
			{
				this.providedVisitor.GoToAspectConstraint(
					providedConstraint.Name);
				requiredConstraint.Accept(this);
				this.providedVisitor.GoUp();
			}
		}

		/// <summary>
		/// Checks if one of the aspects in providedAspectConstraints matches 
		/// the given aspect of the required interface.
		/// </summary>
		/// <param name="providedAspects">A collection of aspects of the
		/// provided interface.</param>
		/// <param name="requiredAspect">IQMLStatConstraint that is defined in
		/// the required specification.</param>
		/// <returns>string.Empty if one of the aspects in the given collection 
		/// matches the given aspect. Else string that describes the mismatch.
		/// </returns>
		private string AspectMatches(ICollection providedAspects,
			IQMLStatConstraint requiredAspect)
		{
			string mismatchDetails = string.Empty;
			// The loop is cancelled at the first finding of a matching 
			// aspect. One could search for redundant/invalid aspect 
			// definitions, which is not done for simplicity reasons.
			foreach (IQMLStatConstraint providedAspect in providedAspects)
			{
				if (requiredAspect.Type == providedAspect.Type)
				{
					switch (providedAspect.Type)
					{
						//TODO: Check comments from old implementation.
						case QMLTokenTypes.FREQUENCY_CONTR:
							// TODO: implement reasonable comparison of frequency 
							// aspects.
							break;
						case QMLTokenTypes.MEAN_CONTR:
							if (!MeanAspectMatch(
								(QMLMeanAspect)requiredAspect, 
								(QMLMeanAspect)providedAspect))
								mismatchDetails += "Required: "+
									requiredAspect.ToString()+" Provided: "+
									providedAspect.ToString()+" ";
							break;
						case QMLTokenTypes.PERCENTILE_CONTR:
							// TODO: could further implementation be needed here?
							break;
						case QMLTokenTypes.VARIANCE_CONTR:
							// TODO: implement reasonable comparison of frequency 
							// aspects.
							break;
					}	
				}
			}
			return mismatchDetails;
		}

		/// <summary>
		/// Checks if the given percentile of the provided interface match the
		/// given percentiles of the required interface.
		/// </summary>
		/// <param name="providedPercentiles">Collection of percentiles of the
		/// provided interface.</param>
		/// <param name="requiredPercentiles">Collection of percentiles of the
		/// required interface.</param>
		/// <returns>string.Empty if the given percentiles match. Else string 
		/// that provides further details about the mismatch.</returns>
		private string PercentilesMatch (ArrayList providedPercentiles,
			ArrayList requiredPercentiles)
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
								requiredAspect.ToString()+" Provided: "+
								providedAspect.ToString();
						}
							
					}	
				}	
				currentPercentile = providedAspect.Percentile;
			}
			return mismatchDetail;
		}

		/// <summary>
		/// Checks if this QMLMeanAspect matches the given aspect.
		/// I.e. is better or equal to the given aspect. 
		/// As part of a mismatch search this aspect should be part of the
		/// provided specification while the given aspect should be part of the
		/// required specification.
		/// </summary>
		/// <param name="requiredAspect">QMLMeanAspect that is part of the
		/// required specification.</param>
		/// <returns>True if this aspect matches the given aspect, 
		/// else false.</returns>
		public bool MeanAspectMatch (QMLMeanAspect requiredAspect,
			QMLMeanAspect providedAspect)
		{
			if (providedAspect.Type != requiredAspect.Type)
				return false;

			// Matching has to be checked for every possible numericOperator
			// of the given constraint.
			switch (requiredAspect.NumericOperator)
			{
				case QMLTokenTypes.NUMOP_EQUAL:
					if ((providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL) 
						&&
						providedAspect.Value == requiredAspect.Value)
						return true;
					break;
				case QMLTokenTypes.NUMOP_GTE:
					if (((providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_GTE) ||
						(providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL) ||
						(providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_GTHAN)) 
						&&
						(providedAspect.Value >= requiredAspect.Value))
						return true;
					break;
				case QMLTokenTypes.NUMOP_GTHAN:
					if (((providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_GTHAN) &&
						(providedAspect.Value >= requiredAspect.Value)) 
						||
						(((providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_GTE) ||
						(providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL)) 
						&&
						(providedAspect.Value > requiredAspect.Value)))
						return true;
					break;
				case QMLTokenTypes.NUMOP_LTE:
					if (((providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL) ||
						(providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_LTE) ||
						(providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_LTHAN)) 
						&&
						(providedAspect.Value <= requiredAspect.Value))
						return true;
					break;
				case QMLTokenTypes.NUMOP_LTHAN:
					if (((providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_LTHAN) && 
						(providedAspect.Value <= requiredAspect.Value)) 
						||
						(((providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_EQUAL)||
						(providedAspect.NumericOperator == 
						QMLTokenTypes.NUMOP_LTE))
						&&
						(providedAspect.Value < requiredAspect.Value)))
						return true;
					break;
			}
			return false;
		}
		#endregion
	}
}

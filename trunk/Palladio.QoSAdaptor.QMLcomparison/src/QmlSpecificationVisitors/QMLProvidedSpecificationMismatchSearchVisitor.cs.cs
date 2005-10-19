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

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors
{
	/// <summary>
	/// Visits the provided specification during the mismatch search. Is lead
	/// through the tree by a QMLRequiredSpecificationMismatchSearchVisitor.
	/// </summary>
	internal class QMLProvidedSpecificationMismatchSearchVisitor : 
		IQMLSpecificationVisitor
	{
		#region attributes
		/// <summary>
		/// List of visited elements of this visitor. Used to save already 
		/// visited nodes to know the current node and to provide a 
		/// functionality to go up in the tree to formerly visited nodes.
		/// </summary>
		private IList visitedElements;
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a new QMLProvidedSpecificationMismatchSearchVisitor and
		/// initialises the list of visited elements.
		/// </summary>
		internal QMLProvidedSpecificationMismatchSearchVisitor()
		{
			this.visitedElements = new ArrayList();
		}
		#endregion

		#region properties
		/// <summary>
		/// Provides the current profile expression when a profile is visited.
		/// When there is no current profile expression null is returned.
		/// </summary>
		internal IQMLVisitable Current
		{
			get
			{
				return (IQMLVisitable)this.visitedElements[
					this.visitedElements.Count-1];
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
			this.visitedElements.Add(aspectConstraint);
		}

		/// <summary>
		/// Visit method for an QMLContract.
		/// </summary>
		/// <param name="contract">A QMLContract whose Accept 
		/// method has been called.</param>
		public void VisitQMLContract(QMLContract contract)
		{
			this.visitedElements.Add(contract);
		}

		/// <summary>
		/// Visit method for an QMLContractExpression.
		/// </summary>
		/// <param name="contractExpression">A QMLContractExpression whose 
		/// Accept method has been called.</param>
		public void VisitQMLContractExpression(QMLContractExpression 
			contractExpression)
		{
			this.visitedElements.Add(contractExpression);
		}

		/// <summary>
		/// Visit method for an QMLContractType.
		/// </summary>
		/// <param name="contractType">A QMLContractType whose Accept 
		/// method has been called.</param>
		public void VisitQMLContractType(QMLContractType contractType)
		{
			this.visitedElements.Add(contractType);
		}

		/// <summary>
		/// Visit method for an QMLDimensionDeclaration.
		/// </summary>
		/// <param name="dimensionDeclaration">A QMLDimensionDeclaration whose 
		/// Accept method has been called.</param>
		public void VisitQMLDimensionDeclaration(QMLDimensionDeclaration 
			dimensionDeclaration)
		{
			this.visitedElements.Add(dimensionDeclaration);
		}

		/// <summary>
		/// Visit method for an QMLDimensionType.
		/// </summary>
		/// <param name="dimensionType">A QMLDimensionType whose Accept 
		/// method has been called.</param>
		public void VisitQMLDimensionType(QMLDimensionType dimensionType)
		{
			this.visitedElements.Add(dimensionType);
		}

		/// <summary>
		/// Visit method for an QMLEntity.
		/// </summary>
		/// <param name="entity">A QMLEntity whose Accept 
		/// method has been called.</param>
		public void VisitQMLEntity(QMLEntity entity)
		{
			this.visitedElements.Add(entity);
		}

		/// <summary>
		/// Visit method for an QMLFrequencyAspect.
		/// </summary>
		/// <param name="frequencyAspect">A QMLFrequencyAspect whose Accept 
		/// method has been called.</param>
		public void VisitQMLFrequencyAspect(QMLFrequencyAspect frequencyAspect)
		{
			this.visitedElements.Add(frequencyAspect);
		}

		/// <summary>
		/// Visit method for an QMLMeanAspect.
		/// </summary>
		/// <param name="meanAspect">A QMLMeanAspect whose Accept 
		/// method has been called.</param>
		public void VisitQMLMeanAspect(QMLMeanAspect meanAspect)
		{
			this.visitedElements.Add(meanAspect);
		}
		
		/// <summary>
		/// Visit method for an QMLPercentileAspect.
		/// </summary>
		/// <param name="percentileAspect">A QMLPercentileAspect whose Accept 
		/// method has been called.</param>
		public void VisitQMLPercentileAspect(QMLPercentileAspect 
			percentileAspect)
		{
			this.visitedElements.Add(percentileAspect);
		}
		
		/// <summary>
		/// Visit method for an QMLProfile.
		/// </summary>
		/// <param name="profile">A QMLProfile whose Accept 
		/// method has been called.</param>
		public void VisitQMLProfile(QMLProfile profile)
		{
			this.visitedElements.Add(profile);
		}

		/// <summary>
		/// Visit method for an QMLProfileExpression.
		/// </summary>
		/// <param name="profileExpression">A QMLProfileExpression whose Accept 
		/// method has been called.</param>
		public void VisitQMLProfileExpression(QMLProfileExpression 
			profileExpression)
		{
			this.visitedElements.Add(profileExpression);
		}
		
		/// <summary>
		/// Visit method for an QMLRequirementClause.
		/// </summary>
		/// <param name="requirementClause">A QMLRequirementClause whose Accept 
		/// method has been called.</param>
		public void VisitQMLRequirementClause(QMLRequirementClause 
			requirementClause)
		{
			this.visitedElements.Add(requirementClause);
		}
		
		/// <summary>
		/// Visit method for an QMLSimpleConstraint.
		/// </summary>
		/// <param name="simpleConstraint">A QMLSimpleConstraint whose Accept 
		/// method has been called.</param>
		public void VisitQMLSimpleConstraint(QMLSimpleConstraint 
			simpleConstraint)
		{
			this.visitedElements.Add(simpleConstraint);
		}
		
		/// <summary>
		/// Visit method for an QMLSpecification.
		/// </summary>
		/// <param name="specification">A QMLSpecification whose Accept 
		/// method has been called.</param>
		public void VisitQMLSpecification(QMLSpecification specification)
		{
			this.visitedElements.Add(specification);
		}
		
		/// <summary>
		/// Visit method for an QMLUnit.
		/// </summary>
		/// <param name="unit">A QMLUnit whose Accept 
		/// method has been called.</param>
		public void VisitQMLUnit(QMLUnit unit)
		{
			this.visitedElements.Add(unit);
		}

		/// <summary>
		/// Visit method for an QMLValueLiteral.
		/// </summary>
		/// <param name="valueLiteral">A QMLValueLiteral whose Accept 
		/// method has been called.</param>
		public void VisitQMLValueLiteral(QMLValueLiteral valueLiteral)
		{
			this.visitedElements.Add(valueLiteral);
		}
		
		/// <summary>
		/// Visit method for an QMLVarianceAspect.
		/// </summary>
		/// <param name="varianceAspect">A QMLVarianceAspect whose Accept 
		/// method has been called.</param>
		public void VisitQMLVarianceAspect(QMLVarianceAspect varianceAspect)
		{
			this.visitedElements.Add(varianceAspect);
		}
		#endregion

		#region methods for the QMLRequiredSpecificationMismatchSearchVisitor
		internal void GoUp()
		{
			this.visitedElements.RemoveAt(this.visitedElements.Count-1);
		}

		internal void GoToAspectConstraint(string name)
		{
			try
			{
				QMLContractExpression current = (QMLContractExpression)
					this.visitedElements[this.visitedElements.Count-1];
				QMLAspectConstraint aspectConstraint = 
					current.GetAspectConstraint(name);
				aspectConstraint.Accept(this);
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" was QMLContractExpression. Invalid type is "+
					this.visitedElements[this.visitedElements.Count-1].
					GetType());
			}
		}

		internal void GoToContract(QMLContract contract)
		{
			try
			{
				QMLRequirementClause current = (QMLRequirementClause)
					this.visitedElements[this.visitedElements.Count-1];
				if (current.Contracts.Contains(contract))
					contract.Accept(this);
				else
				{
					throw new QMLMismatchSearchException("RequirementClause "+
						"does not contain expected contract "+contract.Name);
				}
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" was QMLRequirementClause. Invalid type is "+
					this.visitedElements[this.visitedElements.Count-1].
					GetType());
			}
		}

		internal void GoToContractExpression()
		{
			try
			{
				QMLContract current = (QMLContract)
					this.visitedElements[this.visitedElements.Count-1];
				current.ContractExpression.Accept(this);
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" was QMLContract. Invalid type is "+
					this.visitedElements[this.visitedElements.Count-1].
					GetType());
			}
		}

		internal void GoToProfile(string interfaceName)
		{
			try
			{
				QMLSpecification current = (QMLSpecification)this.visitedElements[
					this.visitedElements.Count-1];
				QMLProfile profile = current.GetProfile(interfaceName);
				profile.Accept(this);
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" was QMLSpecification. Invalid type is "+
					this.visitedElements[this.visitedElements.Count-1].
					GetType());
			}
		}

		internal void GoToProfileExpression()
		{
			try
			{
				QMLProfile current = (QMLProfile)this.visitedElements[
					this.visitedElements.Count-1];
				QMLProfileExpression profileExpression = current.ProfileExpression;
				profileExpression.Accept(this);
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" was QMLProfile. Invalid type is "+
					this.visitedElements[this.visitedElements.Count-1].
					GetType());
			}
		}

		internal void GoToRequirementClause(QMLRequirementClause 
			requirementClause)
		{
			try
			{
				QMLProfileExpression current = (QMLProfileExpression)
					this.visitedElements[this.visitedElements.Count-1];
				if (current.RequirementClauses.Contains(requirementClause))
					requirementClause.Accept(this);
				else
				{
					throw new QMLMismatchSearchException("Profile Expression "+
						"does not contain expected requirement clause.");
				}
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" was QMLProfileExpression. Invalid type is "+
					this.visitedElements[this.visitedElements.Count-1].
					GetType());
			}
		}

		internal void GoToSimpleConstraint(string name)
		{
			try
			{
				QMLContractExpression current = (QMLContractExpression)
					this.visitedElements[this.visitedElements.Count-1];
				QMLSimpleConstraint simpleConstraint = 
					current.GetSimpleConstraint(name);
				simpleConstraint.Accept(this);
			}
			catch (InvalidCastException e)
			{
				throw new QMLMismatchSearchException(e.Message+"Expected type"+
					" was QMLContractExpression. Invalid type is "+
					this.visitedElements[this.visitedElements.Count-1].
					GetType());
			}
		}
		#endregion
	}
}

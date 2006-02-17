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
	/// Interface that has to be implemented by all visitors that operate on 
	/// the QML specification class tree. For every class of the tree this 
	/// interface provides a method to be called by the accept method of that
	/// class.
	/// </summary>
	public interface IQMLSpecificationVisitor
	{
		/// <summary>
		/// Visit method for an QMLAspectConstraint.
		/// </summary>
		/// <param name="aspectConstraint">A QMLAspectConstraint whose Accept 
		/// method has been called.</param>
		void VisitQMLAspectConstraint(QMLAspectConstraint aspectConstraint);

		/// <summary>
		/// Visit method for an QMLContract.
		/// </summary>
		/// <param name="contract">A QMLContract whose Accept 
		/// method has been called.</param>
		void VisitQMLContract(QMLContract contract);

		/// <summary>
		/// Visit method for an QMLContractExpression.
		/// </summary>
		/// <param name="contractExpression">A QMLContractExpression whose 
		/// Accept method has been called.</param>
		void VisitQMLContractExpression(QMLContractExpression 
			contractExpression);

		/// <summary>
		/// Visit method for an QMLContractType.
		/// </summary>
		/// <param name="contractType">A QMLContractType whose Accept 
		/// method has been called.</param>
		void VisitQMLContractType(QMLContractType contractType);

		/// <summary>
		/// Visit method for an QMLDimensionDeclaration.
		/// </summary>
		/// <param name="dimensionDeclaration">A QMLDimensionDeclaration whose 
		/// Accept method has been called.</param>
		void VisitQMLDimensionDeclaration(QMLDimensionDeclaration 
			dimensionDeclaration);

		/// <summary>
		/// Visit method for an QMLDimensionType.
		/// </summary>
		/// <param name="dimensionType">A QMLDimensionType whose Accept 
		/// method has been called.</param>
		void VisitQMLDimensionType(QMLDimensionType dimensionType);

		/// <summary>
		/// Visit method for an QMLEntity.
		/// </summary>
		/// <param name="entity">A QMLEntity whose Accept 
		/// method has been called.</param>
		void VisitQMLEntity(QMLEntity entity);

		/// <summary>
		/// Visit method for an QMLFrequencyAspect.
		/// </summary>
		/// <param name="frequencyAspect">A QMLFrequencyAspect whose Accept 
		/// method has been called.</param>
		void VisitQMLFrequencyAspect(QMLFrequencyAspect frequencyAspect);

		/// <summary>
		/// Visit method for an QMLMeanAspect.
		/// </summary>
		/// <param name="meanAspect">A QMLMeanAspect whose Accept 
		/// method has been called.</param>
		void VisitQMLMeanAspect(QMLMeanAspect meanAspect);
		
		/// <summary>
		/// Visit method for an QMLPercentileAspect.
		/// </summary>
		/// <param name="percentileAspect">A QMLPercentileAspect whose Accept 
		/// method has been called.</param>
		void VisitQMLPercentileAspect(QMLPercentileAspect percentileAspect);
		
		/// <summary>
		/// Visit method for an QMLProfile.
		/// </summary>
		/// <param name="profile">A QMLProfile whose Accept 
		/// method has been called.</param>
		void VisitQMLProfile(QMLProfile profile);

		/// <summary>
		/// Visit method for an QMLProfileExpression.
		/// </summary>
		/// <param name="profileExpression">A QMLProfileExpression whose Accept 
		/// method has been called.</param>
		void VisitQMLProfileExpression(QMLProfileExpression profileExpression);
		
		/// <summary>
		/// Visit method for an QMLRequirementClause.
		/// </summary>
		/// <param name="requirementClause">A QMLRequirementClause whose Accept 
		/// method has been called.</param>
		void VisitQMLRequirementClause(QMLRequirementClause requirementClause);
		
		/// <summary>
		/// Visit method for an QMLSimpleConstraint.
		/// </summary>
		/// <param name="simpleConstraint">A QMLSimpleConstraint whose Accept 
		/// method has been called.</param>
		void VisitQMLSimpleConstraint(QMLSimpleConstraint simpleConstraint);
		
		/// <summary>
		/// Visit method for an QMLSpecification.
		/// </summary>
		/// <param name="specification">A QMLSpecification whose Accept 
		/// method has been called.</param>
		void VisitQMLSpecification(QMLSpecification specification);
		
		/// <summary>
		/// Visit method for an QMLUnit.
		/// </summary>
		/// <param name="unit">A QMLUnit whose Accept 
		/// method has been called.</param>
		void VisitQMLUnit(QMLUnit unit);

		/// <summary>
		/// Visit method for an QMLValueLiteral.
		/// </summary>
		/// <param name="valueLiteral">A QMLValueLiteral whose Accept 
		/// method has been called.</param>
		void VisitQMLValueLiteral(QMLValueLiteral valueLiteral);
		
		/// <summary>
		/// Visit method for an QMLVarianceAspect.
		/// </summary>
		/// <param name="varianceAspect">A QMLVarianceAspect whose Accept 
		/// method has been called.</param>
		void VisitQMLVarianceAspect(QMLVarianceAspect varianceAspect);
	}
}

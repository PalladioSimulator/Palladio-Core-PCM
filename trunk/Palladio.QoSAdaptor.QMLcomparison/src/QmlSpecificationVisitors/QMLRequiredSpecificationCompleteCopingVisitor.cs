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
	/// Checks the complete coping of a QMLSpecification interpreted as 
	/// required specification and visited by an object of this class and a
	/// provided specification visited by an 
	/// QMLProvidedSpecificationCompleteCopingVisitor.
	/// After the check which is started by first calling the Accept
	/// method of the provided specification with the providedVisitor and then 
	/// calling the Accept method of the required specification with an object
	/// of this class. 
	/// When the provided interfaces does not cover the required interface a
	/// QMLCompleteCopingException will be thrown. The message of the 
	/// exception provides further information about the incorrect part of the 
	/// specification.
	/// Some of the methods of the IQMLSpecificationVisitor interface are not 
	/// implemented, because the corresponding classes are not needed for the 
	/// mismatch search. A NotImplementedException is thrown instead.
	/// </summary>
	internal class QMLRequiredSpecificationCompleteCopingVisitor : 
		IQMLSpecificationVisitor
	{
		#region attributes
		/// <summary>
		/// Visitor of the corresponding provided specification.
		/// </summary>
		private QMLProvidedSpecificationCompleteCopingVisitor providedVisitor;

		/// <summary>
		/// Lists the errors that occurred during the coping check.
		/// </summary>
		private IList copingErrors;

		/// <summary>
		/// Contains the currently visited profile. Used to provide the name
		/// of the profile in error messages.
		/// </summary>
		private QMLProfile currentProfile;

		/// <summary>
		/// Contains the currently visited entity. Used to provide the name
		/// of the entity in error messages.
		/// </summary>		
		private QMLEntity currentEntity;

		/// <summary>
		/// Contains the currently visited contract. Used to provide the name
		/// of the contract in error messages.
		/// </summary>		
		private QMLContract currentContract;
		#endregion

		#region constructor
		/// <summary>
		/// Constructs a new QMLRequiredSpecificationCompleteCopingVisitor. To
		/// start the complete coping check the provided specification has to 
		/// be visited by the given providedVisitor. After that this visitor 
		/// has to be given to the Accept method of the corresponding 
		/// QMLSpecification. 
		/// </summary>
		/// <param name="providedVisitor">The corresponding visitor of the 
		/// provided specification.</param>
		internal QMLRequiredSpecificationCompleteCopingVisitor(
			QMLProvidedSpecificationCompleteCopingVisitor providedVisitor)
		{
			this.providedVisitor = providedVisitor;
			this.copingErrors = new ArrayList();
			this.currentEntity = null;
			this.currentProfile = null;
			this.currentContract = null;
		}
		#endregion

		#region properties
		/// <summary>
		/// A list of strings that contain error messages for coping errors.
		/// </summary>
		public IList CopingErrors
		{
			get
			{
				return this.copingErrors;
			}
		}

		/// <summary>
		/// Returns a list of all errors as one string.
		/// </summary>
		public string CopingErrorMessage
		{
			get
			{
				string message = string.Empty;
				foreach (string error in this.copingErrors)
					message += error+"\n";
				return message;
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
			throw new NotImplementedException();
		}

		/// <summary>
		/// Visit method for an QMLContract.
		/// </summary>
		/// <param name="contract">A QMLContract whose Accept 
		/// method has been called.</param>
		public void VisitQMLContract(QMLContract contract)
		{
			this.currentContract = contract;
			this.providedVisitor.GoToContractExpression();
			contract.ContractExpression.Accept(this);
			this.providedVisitor.GoUp();
			this.currentContract = null;
		}

		/// <summary>
		/// Visit method for an QMLContractExpression.
		/// </summary>
		/// <param name="contractExpression">A QMLContractExpression whose 
		/// Accept method has been called.</param>
		public void VisitQMLContractExpression(QMLContractExpression 
			contractExpression)
		{
			QMLContractExpression providedContractExpression;
			try
			{
				providedContractExpression = 
					(QMLContractExpression)this.providedVisitor.Current;
			}
			catch (InvalidCastException e)
			{
				throw new QMLCompleteCopingException(e.Message+"Expected type"+
					" is QMLContractExpression. Invalid type is "+
					this.providedVisitor.Current.GetType());
			}

			CheckSimpleConstraints(contractExpression, 
				providedContractExpression);

			CheckAspectConstraints(contractExpression, 
				providedContractExpression);
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
			this.providedVisitor.GoToProfileExpression();
			profile.ProfileExpression.Accept(this);
			this.providedVisitor.GoUp();
		}

		/// <summary>
		/// Visit method for an QMLProfileExpression.
		/// </summary>
		/// <param name="profileExpression">A QMLProfileExpression whose Accept 
		/// method has been called.</param>
		public void VisitQMLProfileExpression(QMLProfileExpression 
			profileExpression)
		{
			QMLProfileExpression providedProfileExpression;
			try
			{
				providedProfileExpression = 
					(QMLProfileExpression)this.providedVisitor.Current;
			}
			catch (InvalidCastException e)
			{
				throw new QMLCompleteCopingException(e.Message+"Expected type"+
					" is QMLProfileExpression. Invalid type is "+
					this.providedVisitor.Current.GetType());
			}
			CheckRequirementCoping(profileExpression.RequirementClauses,
				providedProfileExpression.RequirementClauses);

		}
		
		/// <summary>
		/// Visit method for an QMLRequirementClause.
		/// </summary>
		/// <param name="requirementClause">A QMLRequirementClause whose Accept 
		/// method has been called.</param>
		public void VisitQMLRequirementClause(QMLRequirementClause 
			requirementClause)
		{
			throw new NotImplementedException();
		}
		
		/// <summary>
		/// Visit method for an QMLSimpleConstraint.
		/// </summary>
		/// <param name="simpleConstraint">A QMLSimpleConstraint whose Accept 
		/// method has been called.</param>
		public void VisitQMLSimpleConstraint(QMLSimpleConstraint 
			simpleConstraint)
		{
			throw new NotImplementedException();
		}
		
		/// <summary>
		/// Visit method for an QMLSpecification.
		/// </summary>
		/// <param name="specification">A QMLSpecification whose Accept 
		/// method has been called.</param>
		public void VisitQMLSpecification(QMLSpecification specification)
		{
			foreach (QMLProfile profile in specification.Profiles)
			{
				bool uncoveredProfile = false;
				try
				{
					this.providedVisitor.GoToProfile(profile.InterfaceName);
				}
				catch (QMLCompleteCopingUnknownProfileException)
				{
					uncoveredProfile = true;
					string errorMessage = "The provided interface "+
					"does not describe a profile for "+profile.InterfaceName+
					".";
					this.copingErrors.Add(errorMessage);
				}
				if (!uncoveredProfile)
				{
					this.currentProfile = profile;
					profile.Accept(this);
					this.currentProfile = null;
					this.providedVisitor.GoUp();
				}
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
		/// Checks if all given requiredRequirementClauses are covered by 
		/// the given providedRequirementClauses.
		/// </summary>
		/// <param name="requiredRequirementClauses">Requirement clauses which 
		/// shall be covered by the providedRequirementClauses.</param>
		/// <param name="providedRequirementClauses">Requirement clauses of the
		/// provided interface.</param>
		/// <returns>True, if all given requirement clauses are covered.
		/// Else false.</returns>
		private void CheckRequirementCoping (IList requiredRequirementClauses,
			IList providedRequirementClauses)
		{

			// The provided requirement clauses cover the required requirement 
			// clauses, if all entities of the required requirement clauses 
			// also occur in the provided requirement clauses.
			foreach (QMLRequirementClause requiredClause in 
				requiredRequirementClauses)
			{
				// For all entity related contracts and all interface related
				// contracts in requirementClauses check if they are 
				// covered by this.requirement clauses.

				// check interface related contracts
				if (requiredClause.Entities.Count == 0)
				{
					bool interfaceContracts = false;
					foreach (QMLRequirementClause providedClause in
						providedRequirementClauses)
					{
						if (providedClause.Entities.Count == 0)
						{
							interfaceContracts = true;
							CheckForUncoveredContracts(
								providedClause.Contracts, 
								requiredClause.Contracts);
						}
					}
					if (!interfaceContracts)
					{
						string errorMessage = "There is no requirement "+
							"clause without entities in the provided "+
							"specification for interface "+
							currentProfile.InterfaceName+" as required in"+
							" the required interface.";
						this.copingErrors.Add(errorMessage);
					}
				}	
				else 
				{
					// check entity related contracts
					foreach (QMLEntity requiredEntity in
						requiredClause.Entities)
					{
						this.currentEntity = requiredEntity;
						// This variable stays false, if required entity is not
						// contained in any providedRequirementClause.
						bool entityCheck = false;

						foreach (QMLRequirementClause providedClause in
							providedRequirementClauses)
						{
							// This is possible, because a QMLEntity is defined 
							// so that two entities are equal if they have the 
							// same type and name.
							if (providedClause.Entities.Contains(
								requiredEntity))
							{
								entityCheck = true;
								CheckForUncoveredContracts(
									providedClause.Contracts,
									requiredClause.Contracts);
							}
						}
						if (!entityCheck)
						{
							string errorMessage = "The entity "+
								currentProfile.InterfaceName+":"+
								requiredEntity.Name+" is not covered by the "+
								"provided specification.";
							this.copingErrors.Add(errorMessage);
						}
						this.currentEntity = null;
					}
				}
			}	
		}

		/// <summary>
		/// Compares two contract list. Throws an exception, if not all the 
		/// contracts in requiredContracts are also contained in provided 
		/// contracts.
		/// </summary>
		/// <param name="providedContracts">List of QMLContracts of the 
		/// provided interfacer</param>
		/// <param name="requiredContracts">List of QMLContracts of the
		/// required interface.</param>
		private void CheckForUncoveredContracts(IList providedContracts, 
			IList requiredContracts)
		{
			foreach (QMLContract requiredContract in requiredContracts)
			{
				// This is possible, because the Equals method of QMLContract
				// is implemented so that two QMLContracts are equal when they 
				// have the same name and QMLContractExpressions with the same 
				// names.
				if (!providedContracts.Contains(requiredContract))
				{
					string errorMessage = "The contract \n"+
						requiredContract.ToString()+"\nrequired by "+
						this.currentProfile.InterfaceName;
					if (this.currentEntity != null)
						errorMessage += ":"+this.currentEntity.Name;
					errorMessage +=	" is not covered by the "+
						"provided specification";
					this.copingErrors.Add(errorMessage);
				}
				else
				{
					// TODO: check contracts for missing attributes.
					foreach (QMLContract providedContract in 
						providedContracts)
					{
						if (providedContract.Equals(requiredContract))
						{
							this.providedVisitor.GoToContract(
								providedContract);
							requiredContract.Accept(this);
							this.providedVisitor.GoUp();
						}
					}
				}
			}
		}

		/// <summary>
		/// Checks the given contract expression for uncovered 
		/// QMLSimpleConstraints.
		/// </summary>
		/// <param name="requiredContractExpression">QMLContractExpression of
		/// the required interface.</param>
		/// <param name="providedContractExpression">QMLContractExpression of
		/// the provided interface.</param>
		private void CheckSimpleConstraints(
			QMLContractExpression requiredContractExpression,
			QMLContractExpression providedContractExpression)
		{
			foreach (QMLSimpleConstraint simpleConstraint in 
				requiredContractExpression.SimpleConstraints)
			{
				bool isCovered = false;
				foreach (QMLSimpleConstraint providedSimpleConstraint in
					providedContractExpression.SimpleConstraints)
				{
					if (simpleConstraint.Name.Equals(
						providedSimpleConstraint.Name))
						isCovered = true;
				}
				if (!isCovered)
				{
					string errorMessage = "The simple contstraint "+
						simpleConstraint.Name+" in "+
						this.currentProfile.InterfaceName+":";
					if (this.currentEntity != null)
						errorMessage += this.currentEntity.Name+":";
					if (this.currentContract.Name.Equals(""))
						errorMessage += requiredContractExpression.Name;
					else
						errorMessage += this.currentContract.Name;
					errorMessage +=	" is not covered by the provided "+
						"specification.";
					this.copingErrors.Add(errorMessage);
				}
			}
		}

		/// <summary>
		/// Checks the given contract expression for uncovered 
		/// QMLAspectConstraints.
		/// </summary>
		/// <param name="requiredContractExpression">QMLContractExpression of
		/// the required interface.</param>
		/// <param name="providedContractExpression">QMLContractExpression of
		/// the provided interface.</param>
		private void CheckAspectConstraints(
			QMLContractExpression requiredContractExpression,
			QMLContractExpression providedContractExpression)
		{
			foreach (QMLAspectConstraint aspectConstraint in 
				requiredContractExpression.AspectConstraints)
			{
				bool isCovered = false;
				foreach (QMLAspectConstraint providedAspectConstraint in
					providedContractExpression.AspectConstraints)
				{
					if (aspectConstraint.Name.Equals(
						providedAspectConstraint.Name))
						isCovered = true;
				}
				if (!isCovered)
				{
					string errorMessage = "The aspect contstraint "+
						aspectConstraint.Name+" in "+
						this.currentProfile.InterfaceName+":";
					if (this.currentEntity != null)
						errorMessage += this.currentEntity.Name+":";
					if (this.currentContract.Name.Equals(""))
						errorMessage += requiredContractExpression.Name;
					else
						errorMessage += this.currentContract.Name;
					errorMessage +=	" is not covered by the provided "+
						"specification.";
					this.copingErrors.Add(errorMessage);
				}
			}
		}
		#endregion
	}
}


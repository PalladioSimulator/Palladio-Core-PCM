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
using antlr.collections;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Zusammenfassung für QMLProfileExpression.
	/// </summary>
	public class QMLProfileExpression
	{
		#region data
		// Type is specified in QMLParser.QMLTokenTypes. At the moment only 
		// PROFILE_EXP_PROFILE is supported.
		private int type;
		private ArrayList requirementClauses;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLProfileExpression containing the same information as the AST.
		/// </summary>
		/// <param name="profileExpression">AST representing a QML profile 
		/// expression.</param>
		/// /// <param name="specification">The QMLSpecification this profile 
		/// expression is a part of.</param>
		public QMLProfileExpression(AST profileExpression, 
									QMLSpecification specification)
		{
			if (!(profileExpression.Type == QMLTokenTypes.PROFILE_EXP_PROFILE))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLProfileExpression constructor. "+
					"Unknown node type. Note: Refinement is not supported.");

			this.type = profileExpression.Type;
			AST child = profileExpression.getFirstChild();
			this.requirementClauses = new ArrayList();
			for (int i=0; i<profileExpression.getNumberOfChildren(); i++)
			{
				this.requirementClauses.Add(new QMLRequirementClause(child,
															specification));
			}
		}
		#endregion

		#region properties
		/// <summary>
		/// The type of this QMLProfileExpression.
		/// </summary>
		public int ExpressionType
		{
			get
			{
				return this.type;
			}
		}

		/// <summary>
		/// A list of requirement clauses contained in the profile expression.
		/// </summary>
		public IList RequirementClauses
		{
			get
			{
				return this.requirementClauses;
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Checks, if this profile expression covers the same requirements as 
		/// the given profile expression. Thereby it is possible that this 
		/// profile expression describes more entities than the given profile
		/// expression.
		/// It is only checked if the same entities are covered. For this test
		/// it is possible that different contracts are discribed for the 
		/// entities or the interface at all.
		/// TODO: Should the contracts also be checked here so that this has
		/// not to be done in the contract mismatch detection ???
		/// </summary>
		/// <param name="profileExpression">Profile expression which shall 
		/// cover the same interface as this profile expression.</param>
		/// <returns>True, if this profile expression covers the same 
		/// requirements as the given profile expression. False, else.
		/// </returns>
		public bool Covers (QMLProfileExpression profileExpression)
		{
			if (this.type == profileExpression.ExpressionType)
			{
				if (CheckRequirementCoping(
					profileExpression.RequirementClauses))
					return true;
			}
			return false;
		}

		/// <summary>
		/// Searches for mismatches between the entities of this 
		/// QMLProfileExpression and the given provided profile expression.
		/// </summary>
		/// <param name="providedProfileExpression">A QML profile expression
		/// of the provided service.</param>
		/// <param name="interfaceName">The name of the interface this profile
		/// expression is defined for.</param>
		/// <returns>A list of Mismatch objects.</returns>
		public IList FindMismatches(QMLProfileExpression 
			providedProfileExpression, string interfaceName)
		{
			// TODO: Differentiate between the different profile expression
			//       types?
			ArrayList mismatches = new ArrayList();
			foreach (QMLRequirementClause currentClause in 
				this.requirementClauses)
			{
				// Find mismatches for interface related clauses
				if (currentClause.Entities.Count == 0)
				{
					foreach (QMLRequirementClause providedClause in
						providedProfileExpression.RequirementClauses)
					{
						if (providedClause.Entities.Count == 0)
						{
							mismatches.AddRange(
								currentClause.FindContractMismatches(
								providedClause, null, interfaceName));
						}
					}
				}
				// Find mismatches for entities
				else
				{
					foreach (QMLEntity currentEntity in 
						currentClause.Entities)
					{
						mismatches.AddRange(FindEntityMismatches(currentEntity, 
							currentClause, providedProfileExpression, 
							interfaceName));
					}
				}
			}
			
			return mismatches;
		}

		/// <summary>
		/// Returns a new QML profile eypression string containing all 
		/// information in this QMLProfileExpression which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML profile expression.</returns>
		public override string ToString()
		{
			string s = "";
			switch (this.type)
			{
				case QMLTokenTypes.PROFILE_EXP_PROFILE:
					s += "profile {\n";
					break;
			}
			IEnumerator enu = this.requirementClauses.GetEnumerator();
			while (enu.MoveNext())
				s += ((QMLRequirementClause)enu.Current).ToString()+"\n";
			s += "}";
			return s;
		}
		#endregion

		#region private methods
		/// <summary>
		/// Checks if all given requirement clauses of are covered by 
		/// the requirement clauses in this.requirementClauses.
		/// </summary>
		/// <param name="requirementClauses">Requirement clauses which shall be
		/// covered by this profile expression.</param>
		/// <returns>True, if all given requirement clauses are covered.
		/// Else false.</returns>
		private bool CheckRequirementCoping (IList requirementClauses)
		{
			// This profile expression covers the given requirement clauses,
			// if all entities of the given requirement clauses also occur in
			// the requirement clauses of this profile expression.
			bool check = false;
			foreach (QMLRequirementClause currentClause in 
				requirementClauses)
			{
				// For all entity related contracts and all interface related
				// contracts in requirementClauses check if they are 
				// covered by this.requirement clauses.
				check = false;
				// check interface related contracts
				if (currentClause.Entities.Count == 0)
				{
					foreach (QMLRequirementClause thisClause in
						this.requirementClauses)
					{
						if (thisClause.Entities.Count == 0)
						{
							if (CompareContracts(thisClause.Contracts, 
								currentClause.Contracts))
								check = true;
						}
					}
				}	
				else 
				{
					// check entity related contracts
					bool check2 = false;
					foreach (QMLEntity currentEntity in
						currentClause.Entities)
					{
						check2 = false;
						foreach (QMLRequirementClause thisClause in
							this.requirementClauses)
						{
							if (thisClause.Entities.Contains(currentEntity))
							{
								if (CompareContracts(thisClause.Contracts,
									currentClause.Contracts))
								check2 = true;
							}
						}
						if (!check2)
							break;
					}
					if (check2)
						check = true;
				}
				if (!check)
					break;
				}
			if (requirementClauses.Count == 0)
				check = true;
			return check;
		}

		
		/// <summary>
		/// Compares two contract list.
		/// </summary>
		/// <param name="thisContracts">List of QMLContracts of this profile
		/// expression.</param>
		/// <param name="externalContracts">List of QMLContracts of another
		/// profile expression.</param>
		/// <returns>True, if thisContracts contains the contracts of 
		/// externalContracts. Else false.</returns>
		private bool CompareContracts(IList thisContracts, 
			IList externalContracts)
		{
			foreach (QMLContract externalContract in externalContracts)
			{
				bool check = false;
				if (thisContracts.Contains(externalContract))
					check = true;
				if (!check)
					return false;
			}
			return true;
		}

		/// <summary>
		/// Searches in the provided profile for an entity with the same name 
		/// as the given entity and compares the contracts defined for 
		/// these entities.
		/// It is assumed that a corresponding entity to the given entity 
		/// exists in the provided profile expression. This can be ensured
		/// by a comparison of the provided and required specifications with
		/// QMLSpecification.CheckCompleteCoping or this.Covers before 
		/// calling this.FindMismatches.
		/// </summary>
		/// <param name="entity">A QMLEntity of the required interface.</param>
		/// <param name="clause">The QMLRequirementClause the contracts for the
		/// given entity are defined in.</param>
		/// <param name="providedProfileExpression">A QMLProfileExpression of 
		/// the provided interface.</param>
		/// <param name="interfaceName">The name of the interface this profile
		/// expression is defined for.</param>
		/// <returns>A Mismatch object if the contract of the provided entity
		/// corresponding to the given entity does not match the contract of
		/// the given entity. Else null.</returns>
		private IList FindEntityMismatches(QMLEntity entity, 
			QMLRequirementClause clause, 
			QMLProfileExpression providedProfileExpression, 
			string interfaceName)
		{
			ArrayList mismatches = new ArrayList();
			// Search in all requirement clauses
			foreach (QMLRequirementClause currentClause in 
				providedProfileExpression.RequirementClauses)
			{
				// search all entities of the current requirement clause
				if (currentClause.Entities.Count > 0)
				{
					foreach (QMLEntity currentEntity in 
						currentClause.Entities)
					{
						// TODO: Is this still correct for ENTITY_RESULT_OF?
						if (currentEntity.Name.Equals(entity.Name))
						{
							mismatches.AddRange(clause.FindContractMismatches 
								(currentClause, entity.Name, interfaceName));
						}
					}
				}
			}
			return mismatches;
		}
		#endregion
	}
}

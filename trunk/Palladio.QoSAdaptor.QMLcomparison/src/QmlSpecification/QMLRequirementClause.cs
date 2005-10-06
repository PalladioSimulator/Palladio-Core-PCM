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
	/// Zusammenfassung für QMLRequirementClause.
	/// </summary>
	public class QMLRequirementClause
	{
		#region data
		/// <summary>
		/// Contracts for certain methods
		/// </summary>
		private ArrayList entities;
		/// <summary>
		/// Contracts directly associated with an interface
		/// </summary>
		private ArrayList contracts; 
		#endregion

		#region contructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLRequirementClause containing the same information as the AST.
		/// </summary>
		/// <param name="requirementClause">AST representing a QML requirement 
		/// clause.</param>
		/// /// <param name="specification">The QMLSpecification this 
		/// requirement clause is defined in.</param>
		public QMLRequirementClause(AST requirementClause, 
									QMLSpecification specification)
		{
			// check if the AST has the correct root node
			if (!(requirementClause.Type == QMLTokenTypes.REQ_CLAUSE))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLRequirementClause constructor. "+
					"node type "+QMLTokenTypes.REQ_CLAUSE+" expected, but "+
					"found "+requirementClause.Type);

			AST child = requirementClause.getFirstChild();
			this.entities = null;
			this.contracts = new ArrayList();

			// Add entities if 
			if (child.Type == QMLTokenTypes.ENTITY_LIST)
			{
				this.entities = new ArrayList();
				AST entityList = child;
				CreateEntities(entityList);	
				child = child.getNextSibling();
			}

			// Add contracts
			AST contracts = child;
			this.contracts.AddRange(CreateContracts(contracts, 
														specification));
		}
		#endregion

		#region properties
		public IList Entities
		{
			get
			{
				return this.entities;
			}
		}

		public IList Contracts
		{
			get
			{
				return this.contracts;
			}
		}
		#endregion

		#region private methods
		/// <summary>
		/// Creates new QMLEntities for the entrys of the given entity list.
		/// </summary>
		/// <param name="entityList">List of qml entities.</param>
		private void CreateEntities(AST entityList)
		{
			AST entity = entityList.getFirstChild();
			for (int i=0; i<entityList.getNumberOfChildren(); i++)
			{
				this.entities.Add(new QMLEntity(entity));
				entity = entity.getNextSibling();
			}
		}

		/// <summary>
		/// Gets named contracts from the given specification and creates new
		/// unnamed contracts for unnamed contract expressions in profile
		/// expression.
		/// </summary>
		/// <param name="contracts"></param>
		/// <param name="specification"></param>
		/// <returns></returns>
		private IList CreateContracts (AST contracts, 
											QMLSpecification specification)
		{
			ArrayList contractList = new ArrayList();
			if (contracts.Type == QMLTokenTypes.NAME)
			{
				QMLContract contract = specification.GetContract(
					contracts.getText());
				contractList.Add(contract);
			}
			else if (contracts.Type == QMLTokenTypes.CONTRACT_LIST)
			{
				AST contract = contracts.getFirstChild();
				for (int i=0; i<contracts.getNumberOfChildren(); i++)
				{
					contractList.Add(new QMLContract(
						new QMLContractExpression(contract)));
					contract = contract.getNextSibling();
				}
			}
			else 
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLEntity constructor. "+
					"Unknown contract type.");

			return contractList;
		} 
		#endregion

		#region public methods
		public bool hasEntity (QMLEntity entity)
		{
			foreach (QMLEntity currentEntity in this.entities)
			{
				if (currentEntity.Equals(entity))
					return true;
			}
			return false;
		}

		/// <summary>
		/// Returns a new QML requirement clause string containing all 
		/// information in this QMLRequirementClause which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML requirement clause.</returns>
		public override string ToString()
		{
			string s = "";
			if (this.entities.Count > 0)
				s += "from ";
			int count = 0;	
			
			foreach (QMLEntity currentEntity in this.entities)
			{
				if (count != this.entities.Count-1)
					s += ", ";
				s += currentEntity.ToString();
				count ++;
			}
			s += " require ";
			count = 0;
			foreach (QMLContract contract in this.contracts)
			{
				if (count != 0)
					s += ", \n";
				if (contract.Name.Equals(""))
					s += contract.ContractExpression;
				else
					s += contract.Name;
				count++;
			}
			return s;
		}

		/// <summary>
		/// Searches for mismatches in corresponding contracts of this 
		/// requirement clause and the given requirement clause.
		/// </summary>
		/// <param name="clause">QMLRequirementClause of the provided service
		/// that describes the same entity or interface.</param>
		/// <param name="entityName">The name of the entity this requirement 
		/// clause describes. Null, if the clause describes an interface.
		/// </param>
		/// <param name="interfaceName">The name of the interface this clause
		/// is defined for.</param>
		/// <returns>A list of Mismatch objects.</returns>
		public IList FindContractMismatches(QMLRequirementClause clause, 
			string entityName, string interfaceName)
		{
			ArrayList mismatches = new ArrayList();
			foreach (QMLContract contract in this.contracts)
			{
				foreach (QMLContract providedContract in clause.Contracts)
				{
					// TODO: Source this out to QMLContract and 
					// QMLContractExpression
					if (contract.Name.Equals(providedContract.Name))
						mismatches.AddRange(contract.FindMismatches(
							providedContract, entityName, interfaceName));
				}
			}
			return mismatches;
		}
		#endregion
	}
}

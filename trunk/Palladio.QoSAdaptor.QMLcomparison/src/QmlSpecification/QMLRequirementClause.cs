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
using Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Zusammenfassung für QMLRequirementClause.
	/// </summary>
	public class QMLRequirementClause : IQMLVisitable
	{
		#region attributes
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
			this.entities = new ArrayList();
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
		/// <summary>
		/// A list of all entities describes by this requirement clause.
		/// </summary>
		public IList Entities
		{
			get
			{
				return this.entities;
			}
		}

		/// <summary>
		/// A list of contracts described in this requirement clause.
		/// </summary>
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

		#region methods inherited by IQMLVisitable
		public void Accept(IQMLSpecificationVisitor visitor)
		{
			visitor.VisitQMLRequirementClause(this);
		}
		#endregion

		#region public methods
		/// <summary>
		/// Checks, if this QMLRequirementClause describes the given entity.
		/// </summary>
		/// <param name="entity">A QMLEntity.</param>
		/// <returns>True, if the requirement clause contains the given entity.
		/// Else false.</returns>
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
			s += ";";
			return s;
		}

		/// <summary>
		/// If this requirement clause contains a contract with the given name, 
		/// the corresponding QMLContract is returned. 
		/// </summary>
		/// <param name="contractName">Name of the seeked contract.</param>
		/// <returns>Corresponding QMLContract or null if no contract with the
		/// given name exists in this requirement clause.</returns>
		public QMLContract GetContract (string contractName)
		{
			QMLContract contract = null;
			foreach (QMLContract currentContract in this.contracts)
			{
				if (currentContract.Name.Equals(contractName))
				{
					contract = currentContract;
					break;
				}	
			}
			return contract;
		}
		#endregion
	}
}

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

using antlr.collections;
using Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a QMLContract
	/// </summary>
	public class QMLContract : IQMLVisitable
	{
		#region attributes
		private string name;
		private QMLContractExpression contractExpression;
		#endregion

		#region properties
		/// <summary>
		/// Returns the name of this contract.
		/// </summary>
		public string Name
		{
			get
			{
				return this.name;
			}
		}

		/// <summary>
		/// Returns the contract expression belonging to this contract.
		/// </summary>
		public QMLContractExpression ContractExpression
		{
			get
			{
				return this.contractExpression;
			}
		}
		#endregion

		#region constructors
		/// <summary>
		/// Constructor that takes an AST and constructs a new QMLContract
		/// containing the same information as the AST.
		/// </summary>
		/// <param name="contract">AST representing a QMLContract.
		/// </param>
		public QMLContract(AST contract)
		{
			// TOD0: Is a identity default name necessary, if the contract is
			// unnamed, e.g. in a profile declaration ???
			// TODO: take the functionality of QMLContractExpression into this
			// class ???
			// check if the AST has the correct root node
			if (!contract.getText().Equals("contrDecl"))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLContract constructor. "+
					"node name -contrDecl- expected, but is -"+
					contract.getText()+"-");

			AST child = contract.getFirstChild();
			this.name = child.getText();
			child = child.getNextSibling();
			this.contractExpression = new QMLContractExpression(child);
		}

		/// <summary>
		/// Creates an unnamed QMLContract with the given contractExpression.
		/// </summary>
		public QMLContract(QMLContractExpression contractExpression)
		{
			this.name = "";
			this.contractExpression = contractExpression;
		}
		#endregion

		#region method inherited by IQMLVisitable
		/// <summary>
		/// Implements the IQMLVisitable interface. Calls the 
		/// VisitQMLSpecification method of the given visitor.
		/// </summary>
		/// <param name="visitor">Implemenation of the 
		/// IQMLSpecificationVisitor interface that implements an operation on 
		/// the QML specification class tree.</param>
		public void Accept (IQMLSpecificationVisitor visitor)
		{
			visitor.VisitQMLContract(this);
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML contract string containing all information
		/// in this QMLContract which is compatible to the grammar
		/// accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML contract specification.</returns>
		public override string ToString()
		{
			return this.name+" = "+this.contractExpression.ToString();
		}

		/// <summary>
		/// Defines two QMLContracts to be equal when they have the same name
		/// and QMLContractExpression with the same names.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public override bool Equals(object obj)
		{
			if (this.GetType().Equals(obj.GetType()))
			{
				QMLContract contract = (QMLContract)obj;
				if (this.name.Equals(contract.Name) &&
					this.contractExpression.Name.Equals(
					contract.ContractExpression.Name))		
					return true;
			}
			return false;
		}
		#endregion
	}
}


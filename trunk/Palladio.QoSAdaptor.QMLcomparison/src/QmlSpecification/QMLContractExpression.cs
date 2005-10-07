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
	/// Represents a QML contract expression.
	/// </summary>
	public class QMLContractExpression
	{
		#region data
		private string type;
		// The name of the contract expression should be the name of the 
		// corresponding QoS aspect. Else a mapping would be necessary for the
		// mismatch search.
		private string name;
		private ArrayList simpleConstraints;
		private ArrayList aspectConstraints;
		// TODO: hold both in one constraint list???
		#endregion

		#region properties
		/// <summary>
		/// The name of this contract expression
		/// </summary>
		public string Name
		{
			get
			{
				return this.name;
			}
		}
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLContractExpression containing the same information as the AST.
		/// </summary>
		/// <param name="contractExpression">AST representing a QML
		/// contract expression.</param>
		public QMLContractExpression(AST contractExpression)
		{	
			if (!(contractExpression.Type == QMLTokenTypes.CONTRACT_EXP_CONTRACT))
				throw new QMLSpecificationConstructionException
					("Illegal node type in constructor QMLContractExpression. "
					+"Note: Refinement is not supported yet");
			// TODO: implement refinement
			this.type = "contract";
			AST child = contractExpression.getFirstChild();
			this.name = child.getText();
			this.aspectConstraints = new ArrayList();
			this.simpleConstraints = new ArrayList();

			// Create constraints
			child = child.getNextSibling();
			for (int i=0; i<contractExpression.getNumberOfChildren()-1; i++)
			{
				if (child.getText().Equals("aspectConstr"))
					this.aspectConstraints.Add(new QMLAspectConstraint(child));
				else if (child.getText().Equals("simpleConstr"))
					this.simpleConstraints.Add(new QMLSimpleConstraint(child));
				child = child.getNextSibling();
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML contract expression string containing all 
		/// information in this QMLContractExpression which is compatible to 
		/// the grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML contract expression.</returns>
		public override string ToString()
		{
			string s = this.name+" "+this.type+" { \n";
			foreach (QMLAspectConstraint aspect in this.aspectConstraints)
				s += aspect.ToString()+"\n";

			foreach (QMLSimpleConstraint aspect in this.simpleConstraints)
				s += aspect.ToString()+"\n";

			s += "}";
			return s;
		}

		/// <summary>
		/// Compares this contract expression with the given contract 
		/// expression and returns true if this contract expression 
		/// matches the required contract expression. I.e. this expression is
		/// better than or equal to the given contract expression.
		/// </summary>
		/// <param name="requiredContractExpression">The contract expression
		/// this expression shall match.</param>
		/// <returns>True, if this expression matches the given expression. 
		/// Else false</returns>
		public bool Matches (QMLContractExpression requiredContractExpression)
		{
			// Throw exception if the expressions don't describe the same
			// QoS aspect.
			if (!this.name.Equals(requiredContractExpression.Name))
				throw new QMLMismatchSearchException("Error in "+
					"QMLContractExpression.Matches. The given expression "+
					"does not the same QoS aspect as the called expression.");

			// It is assumed that the expressions match. If one constraint 
			// does not match false will be returned immediately without 
			// further checks.

			// Check all simple constraints.
			foreach (QMLSimpleConstraint requiredConstraint in 
				requiredContractExpression.simpleConstraints)
				if (!SimpleConstraintMatches(requiredConstraint))
					return false;

			// Check all aspect constraints
			foreach (QMLAspectConstraint requiredConstraint in 
				requiredContractExpression.aspectConstraints)
				if (!AspectConstraintMatches(requiredConstraint))
					return false;
			return true;
		}

		/// <summary>
		/// Checks, if all constraints of this QMLContractExpression match the
		/// given required QMLContractExpression. The constraints in the 
		/// required expression that are not match are returned by their name.
		/// </summary>
		/// <param name="requiredContractExpression">The contract expression
		/// this expression shall match.</param>
		/// <returns>A list of names of mismatches constraints.</returns>
		public IList GetMismatches (QMLContractExpression requiredContractExpression)
		{
			// Throw exception if the expressions don't describe the same
			// QoS aspect.
			if (!this.name.Equals(requiredContractExpression.Name))
				throw new QMLMismatchSearchException("Error in "+
					"QMLContractExpression.Matches. The given expression "+
					"does not the same QoS aspect as the called expression.");

			// It is assumed that the expressions match. If one constraint 
			// does not match false will be returned immediately without 
			// further checks.
			ArrayList mismatches = new ArrayList();

			// Check all simple constraints.
			foreach (QMLSimpleConstraint requiredConstraint in 
				requiredContractExpression.simpleConstraints)
				if (!SimpleConstraintMatches(requiredConstraint))
					mismatches.Add(requiredConstraint.Name);

			// Check all aspect constraints
			foreach (QMLAspectConstraint requiredConstraint in 
				requiredContractExpression.aspectConstraints)
				if (!AspectConstraintMatches(requiredConstraint))
					mismatches.Add(requiredConstraint.Name);
			return mismatches;
		}
		#endregion

		#region private methods
		/// <summary>
		/// Checks if the given QMLSimpleConstraint is matched by one of the
		/// simple constraints defined in this contract expression.
		/// </summary>
		/// <param name="requiredConstraint">QMLSimpleConstraint defined in the
		/// required specification.</param>
		/// <returns>True if one simple constraint in this contract expression
		/// matches the given constraint. Else false.</returns>
		private bool SimpleConstraintMatches(
			QMLSimpleConstraint requiredConstraint)
		{
			bool check = false;
			foreach (QMLSimpleConstraint thisConstraint in 
				this.simpleConstraints)
			{
				if (thisConstraint.Matches(requiredConstraint))
				{
					check = true;
					break;
				}
			}
			return check;
		}

		/// <summary>
		/// Checks if the given QMLAspectConstraint is matched by one of the
		/// aspect constraints defined in this contract expression.
		/// </summary>
		/// <param name="requiredConstraint">QMLAspectConstraint defined in the
		/// required specification.</param>
		/// <returns>True if one aspect constraint in this contract expression
		/// matches the given constraint. Else false.</returns>
		private bool AspectConstraintMatches (
			QMLAspectConstraint requiredConstraint)
		{
			bool check = false;
			foreach (QMLAspectConstraint thisConstraint in 
				this.aspectConstraints)
			{
				if (thisConstraint.Matches(requiredConstraint))
				{
					check = true;
					break;
				}
			}
			return check;
		}
		#endregion
	}
}

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
	/// Represents a QML contract expression.
	/// </summary>
	public class QMLContractExpression :IQMLVisitable
	{
		#region attributes
		/// <summary>
		/// The type of this contract expression
		/// </summary>
		private string type;
		
		/// <summary>
		/// The name of the contract expression. Should be the name of the 
		/// corresponding quality attribute. Else a mapping would be necessary for the
		/// mismatch search.
		/// </summary>
		private string name;

		/// <summary>
		/// A list of simple constraints of this expression
		/// </summary>
		private ArrayList simpleConstraints;

		/// <summary>
		/// A list of aspect constraints of this expression
		/// </summary>
		private ArrayList aspectConstraints;
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

		/// <summary>
		/// The simple constraints of this contract expression
		/// </summary>
		public ICollection SimpleConstraints
		{
			get
			{
				return this.simpleConstraints;
			}
		}

		/// <summary>
		/// The aspect constraints of this contract expression
		/// </summary>
		public ICollection AspectConstraints
		{
			get
			{
				return this.aspectConstraints;
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
			visitor.VisitQMLContractExpression(this);
		}
		#endregion

		#region public methods
		/// <summary>
		/// If this contract expression contains a aspect constraint with the 
		/// given name the corresponding QMLAspectConstraint is returned. 
		/// </summary>
		/// <param name="name">Name of the seeked aspect constraint.
		/// </param>
		/// <returns>Corresponding QMLAspectConstraint or null if no aspect 
		/// constraint with the given name exists in this contract expression.
		/// </returns>
		public QMLAspectConstraint GetAspectConstraint (string name)
		{
			QMLAspectConstraint aspectConstraint = null;
			foreach (QMLAspectConstraint currentAspectConstraint in 
				this.aspectConstraints)
			{
				if (currentAspectConstraint.Name.Equals(name))
				{
					aspectConstraint = currentAspectConstraint;
					break;
				}	
			}
			return aspectConstraint;
		}

		/// <summary>
		/// If this contract expression contains a simple constraint with the 
		/// given name the corresponding QMLSimpleConstraint is returned. 
		/// </summary>
		/// <param name="name">Name of the seeked simple constraint.
		/// </param>
		/// <returns>Corresponding QMLSimpleConstraint or null if no simple 
		/// constraint with the given name exists in this contract expression.
		/// </returns>
		public QMLSimpleConstraint GetSimpleConstraint (string name)
		{
			QMLSimpleConstraint simpleConstraint = null;
			foreach (QMLSimpleConstraint currentSimpleConstraint in 
				this.simpleConstraints)
			{
				if (currentSimpleConstraint.Name.Equals(name))
				{
					simpleConstraint = currentSimpleConstraint;
					break;
				}	
			}
			return simpleConstraint;
		}

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
		#endregion
	}
}

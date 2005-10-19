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
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a QML simple constraint.
	/// TODO: Inherit from superclass/interface QMLConstraint?
	/// </summary>
	public class QMLSimpleConstraint : IQMLVisitable
	{
		#region attributes
		/// <summary>
		/// The name of this simple constraint.
		/// </summary>
		private string name;

		/// <summary>
		/// The numeric operator of this simple constraint. Values of 
		/// numericOperator are defined as constants in QMLParser.
		/// </summary>
		private int numericOperator; 

		/// <summary>
		/// The literal of this simple constraint
		/// </summary>
		private QMLValueLiteral valueLiteral;

		/// <summary>
		/// The unit of this simple constraint. The unit is null when no 
		/// unit is specified. There is no default value.
		/// </summary>
		private QMLUnit unit;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLSimpleConstraint containing the same information as the AST.
		/// </summary>
		/// <param name="simpleConstraint">AST representing a QML simple 
		/// constraint.</param>
		public QMLSimpleConstraint(AST simpleConstraint)
		{
			// check if the AST has the correct root node
			if (!simpleConstraint.getText().Equals("simpleConstr"))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLSimpleConstraint constructor. "+
					"node name -simpleConstr- expected, but is -"+
					simpleConstraint.getText()+"-");

			AST child = simpleConstraint.getFirstChild();
			this.name = child.getText();

			child = child.getNextSibling();
			if (child.Type == QMLParser.NUMOP_EQUAL ||
				child.Type == QMLParser.NUMOP_GTE ||
				child.Type == QMLParser.NUMOP_GTHAN ||
				child.Type == QMLParser.NUMOP_LTE ||
				child.Type == QMLParser.NUMOP_LTHAN)
				this.numericOperator = child.Type;
			else 
				throw new QMLSpecificationConstructionException
					("Error in QMLSimpleConstraint constructor. "+
					"Unknown numeric operator.");

			child = child.getNextSibling();
			this.valueLiteral = new QMLValueLiteral(child);

			child = child.getNextSibling();
			if (child != null)
				this.unit = new QMLUnit(child);
		}
		#endregion

		#region properties
		/// <summary>
		/// Returns the name of this QMLSimpleConstraint
		/// </summary>
		public string Name
		{
			get
			{
				return this.name;
			}
		}

		/// <summary>
		/// Returns the numeric operator of this QMLSimpleContraint.
		/// </summary>
		public int NumericOperator
		{
			get
			{
				return this.numericOperator;
			}
		}

		/// <summary>
		/// Returns the value of this QMLSimpleConstraint
		/// </summary>
		public QMLValueLiteral ValueLiteral
		{
			get
			{
				return this.valueLiteral;
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
			visitor.VisitQMLSimpleConstraint(this);
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML simple constraint string containing all 
		/// information in this QMLSimpleConstraint which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML simple constraint.</returns>
		public override string ToString()
		{
			string s = this.name+" ";
			switch (this.numericOperator)
			{
				case QMLParser.NUMOP_GTE:
					s += ">=";
					break;
				case QMLParser.NUMOP_GTHAN:
					s += ">";
					break;
				case QMLParser.NUMOP_LTHAN:
					s += "<";
					break;
				case QMLParser.NUMOP_LTE:
					s += "<=";
					break;
				case QMLParser.NUMOP_EQUAL:
					s += "==";
					break;
			}
			s += " "+this.valueLiteral.ToString();
			if (unit != null)
				s += " "+unit.ToString();
			s += ";";
			return s;
		}
		#endregion
	}
}

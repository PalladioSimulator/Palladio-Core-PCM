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
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a QML simple constraint.
	/// TODO: Inherit from superclass/interface QMLConstraint?
	/// </summary>
	public class QMLSimpleConstraint
	{
		#region data
		private string name;
		// Values of numericOperator are defined as constants in QMLParser
		private int numericOperator; 
		private QMLValueLiteral valueLiteral;
		// unit stays null when no unit is specified. No default value.
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

		/// <summary>
		/// Checks if this QMLSimpleConstraint matches the given constraint.
		/// I.e. is better or equal to the given constraint. 
		/// As part of a mismatch search this constraint should be part of the
		/// provided specification while the given constraint should be part of the
		/// required specification
		/// </summary>
		/// <param name="constraint">QMLSimpleConstraint that is part of the
		/// required specification.</param>
		/// <returns>True if this constraint matches the given constraint, 
		/// else false.</returns>
		public bool Matches (QMLSimpleConstraint constraint)
		{
			if (!this.name.Equals(constraint.Name))
				return false;

			// The units are not taken into consideration since they do not 
			// have to be given. 
			// Only the matches are described in the following switch 
			// statement. Everything else is defined as not matched and 
			// false is returned.

			// Matching has to be checked for every possible numericOperator
			// of the given constraint.
			switch (constraint.NumericOperator)
			{
				case QMLTokenTypes.NUMOP_EQUAL:
					if ((this.numericOperator == QMLTokenTypes.NUMOP_EQUAL) &&
						this.valueLiteral.Equals(constraint.ValueLiteral))
						return true;
					break;
				case QMLTokenTypes.NUMOP_GTE:
					if (((this.numericOperator == QMLTokenTypes.NUMOP_GTE) ||
						(this.numericOperator == QMLTokenTypes.NUMOP_EQUAL) ||
						(this.numericOperator == QMLTokenTypes.NUMOP_GTHAN)) 
						&&
						(this.valueLiteral.CompareTo(constraint.ValueLiteral)
						 >= 0))
						return true;
					break;
				case QMLTokenTypes.NUMOP_GTHAN:
					if (((this.numericOperator == QMLTokenTypes.NUMOP_GTHAN) &&
						  (this.valueLiteral.CompareTo(constraint.ValueLiteral)
						     >= 0)) 
						||
						(((this.numericOperator == QMLTokenTypes.NUMOP_GTE) ||
						  (this.numericOperator==QMLTokenTypes.NUMOP_EQUAL)) 
						   &&
						  (this.valueLiteral.CompareTo(constraint.ValueLiteral) 
						 	 > 0)))
						return true;
					break;
				case QMLTokenTypes.NUMOP_LTE:
					if (((this.numericOperator == QMLTokenTypes.NUMOP_EQUAL) ||
						 (this.numericOperator == QMLTokenTypes.NUMOP_LTE) ||
						 (this.numericOperator == QMLTokenTypes.NUMOP_LTHAN)) 
						&&
						(this.valueLiteral.CompareTo(constraint.ValueLiteral)
						   <= 0))
						return true;
					break;
				case QMLTokenTypes.NUMOP_LTHAN:
					if (((this.numericOperator == QMLTokenTypes.NUMOP_LTHAN) && 
						(this.valueLiteral.CompareTo(constraint.ValueLiteral)
						  <= 0)
						) 
						||
						(((this.numericOperator == QMLTokenTypes.NUMOP_EQUAL)||
						  (this.numericOperator == QMLTokenTypes.NUMOP_LTE))
						  &&
						 (this.valueLiteral.CompareTo(constraint.ValueLiteral)
						   < 0)))
						return true;
					break;

			}
			return false;
		}
		#endregion
	}
}

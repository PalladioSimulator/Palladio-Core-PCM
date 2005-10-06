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
using System.Globalization;
using antlr.collections;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Zusammenfassung für QMLMeanAspect.
	/// </summary>
	public class QMLMeanAspect : IQMLStatConstraint
	{
		#region data
		private int type;
		private int numericOperator;
		private double value;
		#endregion

		#region constructor 
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLMeanAspect containing the same information as the AST.
		/// </summary>
		/// <param name="meanAspect">AST representing a QML mean aspect.
		/// </param>
		public QMLMeanAspect(AST meanAspect)
		{
			if (meanAspect.Type != QMLTokenTypes.MEAN_CONTR)
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLMeanAspect constructor. "+
					"Invalid aspect type: "+meanAspect.Type);

			this.type = meanAspect.Type;

			AST child = meanAspect.getFirstChild();
			if (child.Type == QMLParser.NUMOP_EQUAL ||
				child.Type == QMLParser.NUMOP_GTE ||
				child.Type == QMLParser.NUMOP_GTHAN ||
				child.Type == QMLParser.NUMOP_LTE ||
				child.Type == QMLParser.NUMOP_LTHAN)
				this.numericOperator = child.Type;
			else 
				throw new QMLSpecificationConstructionException
					("Error in QMLMeanAspect constructor. "+
					"Unknown numeric operator.");
			
			child = child.getNextSibling();
			this.value = Double.Parse(child.getText(), 
													new CultureInfo("en-US"));
		}
		#endregion

		#region properties
		/// <summary>
		/// Returns the numeric operator of this QMLMeanAspect
		/// </summary>
		public int NumericOperator
		{
			get
			{
				return this.numericOperator;
			}
		}

		/// <summary>
		/// Returns the value of this QMLMeanAspect
		/// </summary>
		public double Value
		{
			get
			{
				return this.value;
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML mean aspect string containing all 
		/// information in this QMLMeanAspect which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML mean aspect.</returns>
		public override string ToString()
		{
			string s = "mean ";
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
			s += " "+this.value+";";
			return s;
		}

		/// <summary>
		/// Getter for the aspect type. Not implemented as property, because
		/// properties are not allowed in interfaces.
		/// </summary>
		/// <returns>The type of this aspect. The value is specified in 
		/// QMLParser.QMLTokenTypes.</returns>
		public int Type()
		{
			return this.type;
		}

		/// <summary>
		/// Checks if this QMLMeanAspect matches the given aspect.
		/// I.e. is better or equal to the given aspect. 
		/// As part of a mismatch search this aspect should be part of the
		/// provided specification while the given aspect should be part of the
		/// required specification.
		/// </summary>
		/// <param name="requiredAspect">QMLMeanAspect that is part of the
		/// required specification.</param>
		/// <returns>True if this aspect matches the given aspect, 
		/// else false.</returns>
		public bool Matches (IQMLStatConstraint requiredAspect)
		{
			if (this.type != requiredAspect.Type())
				return false;

			QMLMeanAspect requiredMeanAspect = (QMLMeanAspect)requiredAspect;

			// Matching has to be checked for every possible numericOperator
			// of the given constraint.
			switch (requiredMeanAspect.NumericOperator)
			{
				case QMLTokenTypes.NUMOP_EQUAL:
					if ((this.numericOperator == QMLTokenTypes.NUMOP_EQUAL) &&
						this.value == requiredMeanAspect.Value)
						return true;
					break;
				case QMLTokenTypes.NUMOP_GTE:
					if (((this.numericOperator == QMLTokenTypes.NUMOP_GTE) ||
						(this.numericOperator == QMLTokenTypes.NUMOP_EQUAL) ||
						(this.numericOperator == QMLTokenTypes.NUMOP_GTHAN)) 
						&&
						(this.value >= requiredMeanAspect.Value))
						return true;
					break;
				case QMLTokenTypes.NUMOP_GTHAN:
					if (((this.numericOperator == QMLTokenTypes.NUMOP_GTHAN) &&
						(this.value >= requiredMeanAspect.Value)) 
						||
						(((this.numericOperator == QMLTokenTypes.NUMOP_GTE) ||
						(this.numericOperator==QMLTokenTypes.NUMOP_EQUAL)) 
						&&
						(this.value > requiredMeanAspect.Value)))
						return true;
					break;
				case QMLTokenTypes.NUMOP_LTE:
					if (((this.numericOperator == QMLTokenTypes.NUMOP_EQUAL) ||
						(this.numericOperator == QMLTokenTypes.NUMOP_LTE) ||
						(this.numericOperator == QMLTokenTypes.NUMOP_LTHAN)) 
						&&
						(this.value <= requiredMeanAspect.Value))
						return true;
					break;
				case QMLTokenTypes.NUMOP_LTHAN:
					if (((this.numericOperator == QMLTokenTypes.NUMOP_LTHAN) && 
						(this.value <= requiredMeanAspect.Value)) 
						||
						(((this.numericOperator == QMLTokenTypes.NUMOP_EQUAL)||
						(this.numericOperator == QMLTokenTypes.NUMOP_LTE))
						&&
						(this.value < requiredMeanAspect.Value)))
						return true;
					break;
			}
			return false;
		}
		#endregion
	}
}

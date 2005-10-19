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
	/// Represents a frequency aspect of an aspect constraint.
	/// </summary>
	public class QMLFrequencyAspect : IQMLStatConstraint
	{
		#region attributes
		/// <summary>
		/// The type of this QMLFrequencyAspect. The value is specified in 
		/// QMLParser.QMLTokenTypes
		/// </summary>
		private int type;

		/// <summary>
		/// The value of this frequency aspect.
		/// </summary>
		private string value;

		/// <summary>
		/// The numeric operator of this frequency aspect. Possible values are
		/// defined as constants in QMLParser.
		/// </summary>
		private int numericOperator;

		/// <summary>
		/// The percentile belonging to the value of this frequency aspect.
		/// </summary>
		private double percentile;
		#endregion
		
		#region constructor 
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLFrequencyAspect containing the same information as the AST.
		/// </summary>
		/// <param name="frequencyAspect">AST representing a QML frequency 
		/// aspect.</param>
		public QMLFrequencyAspect(AST frequencyAspect)
		{
			if (frequencyAspect.Type != QMLTokenTypes.FREQUENCY_CONTR)
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLFrequencyAspect constructor. "+
					"Invalid aspect type: "+frequencyAspect.Type);

			this.type = frequencyAspect.Type;

			AST child = frequencyAspect.getFirstChild();
			this.value = child.getText();

			child = child.getNextSibling();
			if (child.Type == QMLParser.NUMOP_EQUAL ||
				child.Type == QMLParser.NUMOP_GTE ||
				child.Type == QMLParser.NUMOP_GTHAN ||
				child.Type == QMLParser.NUMOP_LTE ||
				child.Type == QMLParser.NUMOP_LTHAN)
				this.numericOperator = child.Type;
			else 
				throw new QMLSpecificationConstructionException
					("Error in QMLFrequencyAspect constructor. "+
					"Unknown numeric operator.");

			child = child.getNextSibling();
			this.percentile = Double.Parse(child.getText(), 
													new CultureInfo("en-US"));
		}
		#endregion

		#region properties
		/// <summary>
		/// The type of this aspect. The value is specified in 
		/// QMLParser.QMLTokenTypes.
		/// </summary>
		public int Type
		{
			get
			{
				return this.type;	
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML frequency aspect string containing all 
		/// information in this QMLFrequencyAspect which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML frequency aspect.</returns>
		public override string ToString()
		{
			string s = "frequency "+this.value+" ";
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
			s += " "+this.percentile+" %;";
			return s;
		}
		#endregion
	}
}

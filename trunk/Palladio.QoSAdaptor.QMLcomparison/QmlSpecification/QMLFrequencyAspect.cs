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
	/// Zusammenfassung für QMLFrequencyAspect.
	/// </summary>
	public class QMLFrequencyAspect : IQMLStatConstraint
	{
		#region data
		private int type;
		private string value;
		private int numericOperator;
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
		/// Checks if this QMLFrequencyAspect matches the given aspect.
		/// I.e. is better or equal to the given aspect. 
		/// As part of a mismatch search this aspect should be part of the
		/// provided specification while the given aspect should be part of the
		/// required specification.
		/// Note: QMLFrequencyAspects are not regarded in mismatch retrieval at
		/// the moment. Hence true is always returned when the given aspects 
		/// type is QMLTokenTypes.FREQUENCY_CONTR so that frequency aspects in 
		/// a contract definition do not cause irregular behaviour during the
		/// mismatch retrieval.
		/// </summary>
		/// <param name="requiredAspect">QMLFrequencyAspect that is part of the
		/// required specification.</param>
		/// <returns>True if this aspect matches the given aspect, 
		/// else false.</returns>
		public bool Matches (IQMLStatConstraint requiredAspect)
		{
			if (this.type != requiredAspect.Type())
				return false;

			// TODO: implement reasonable comparison of frequency aspects.
			return true;
		}
		#endregion
	}
}

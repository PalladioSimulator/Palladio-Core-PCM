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

using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// This class encapsulates helper function for the numeric operator 
	/// constants of the QMLParser.
	/// </summary>
	public class NumericOperatorHelper
	{
		#region static methods
		/// <summary>
		/// Provides the string representations of the numeric operator 
		/// constants of the QMLParser. This static method is included in 
		/// this class, because it is used in the aspect and simple 
		/// constraint classes which are only used by this class.
		/// </summary>
		public static string NumericOperatorToString(int numericOperator)
		{
			string s;
			switch (numericOperator)
			{
				case QMLParser.NUMOP_GTE:
					s = ">=";
					break;
				case QMLParser.NUMOP_GTHAN:
					s = ">";
					break;
				case QMLParser.NUMOP_LTHAN:
					s = "<";
					break;
				case QMLParser.NUMOP_LTE:
					s = "<=";
					break;
				case QMLParser.NUMOP_EQUAL:
					s = "==";
					break;
				default: 
					s = string.Empty;
					break;
			}
			return s;
		}

		/// <summary>
		/// Decides whether the given int is a legal numeric operator.
		/// </summary>
		/// <param name="numericOperator">The numeric operator constant.
		/// </param>
		/// <returns>True, if the given constant is a numeric operator. 
		/// Else false.</returns>
		public static bool IsNumericOperator (int numericOperator)
		{
			if (numericOperator == QMLParser.NUMOP_EQUAL ||
				numericOperator == QMLParser.NUMOP_GTE ||
				numericOperator == QMLParser.NUMOP_GTHAN ||
				numericOperator == QMLParser.NUMOP_LTE ||
				numericOperator == QMLParser.NUMOP_LTHAN)
				return true;
			return false;
		}
		#endregion
	}
}

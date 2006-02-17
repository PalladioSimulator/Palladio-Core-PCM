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
	/// Represents a mean aspect of an aspect constraint.
	/// </summary>
	public class QMLMeanAspect : IQMLStatConstraint
	{
		#region attributes
		/// <summary>
		/// The type of this QMLMeanAspect. The value is specified in 
		/// QMLParser.QMLTokenTypes
		/// </summary>
		private int type;

		/// <summary>
		/// The numeric operator of this mean aspect. Possible values are
		/// defined as constants in QMLParser.
		/// </summary>
		private int numericOperator;

		/// <summary>
		/// The value of this mean aspect.
		/// </summary>
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
			if (NumericOperatorHelper.IsNumericOperator(child.Type))
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
		/// Returns a new QML mean aspect string containing all 
		/// information in this QMLMeanAspect which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML mean aspect.</returns>
		public override string ToString()
		{
			string s = "mean ";
			s += NumericOperatorHelper.NumericOperatorToString(
				this.numericOperator);
			s += " "+this.value+";";
			return s;
		}
		#endregion
	}
}

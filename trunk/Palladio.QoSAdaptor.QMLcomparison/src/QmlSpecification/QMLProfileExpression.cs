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
	/// Zusammenfassung für QMLProfileExpression.
	/// </summary>
	public class QMLProfileExpression : IQMLVisitable
	{
		#region attributes
		// Type is specified in QMLParser.QMLTokenTypes. At the moment only 
		// PROFILE_EXP_PROFILE is supported.
		/// <summary>
		/// The type of this profile expression. The types are specified in 
		/// QMLParser.QMLTokenTypes. At the moment only PROFILE_EXP_PROFILE 
		/// is supported.
		/// </summary>
		private int type;

		/// <summary>
		/// A list of requirement clauses of this profile expression.
		/// </summary>
		private ArrayList requirementClauses;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLProfileExpression containing the same information as the AST.
		/// </summary>
		/// <param name="profileExpression">AST representing a QML profile 
		/// expression.</param>
		/// /// <param name="specification">The QMLSpecification this profile 
		/// expression is a part of.</param>
		public QMLProfileExpression(AST profileExpression, 
									QMLSpecification specification)
		{
			if (!(profileExpression.Type == QMLTokenTypes.PROFILE_EXP_PROFILE))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLProfileExpression constructor. "+
					"Unknown node type. Note: Refinement is not supported.");

			this.type = profileExpression.Type;
			AST child = profileExpression.getFirstChild();
			this.requirementClauses = new ArrayList();
			for (int i=0; i<profileExpression.getNumberOfChildren(); i++)
			{
				this.requirementClauses.Add(new QMLRequirementClause(child,
															specification));
				child = child.getNextSibling();
			}
		}
		#endregion

		#region properties
		/// <summary>
		/// The type of this QMLProfileExpression.
		/// </summary>
		public int ExpressionType
		{
			get
			{
				return this.type;
			}
		}

		/// <summary>
		/// A list of requirement clauses contained in the profile expression.
		/// </summary>
		public IList RequirementClauses
		{
			get
			{
				return this.requirementClauses;
			}
		}
		#endregion

		#region methods inherited by IQMLVisitable
		/// <summary>
		/// Method from the visitor pattern. The visitor method for this 
		/// class is called on the given visitor.
		/// </summary>
		/// <param name="visitor">Visitor that visits this node.</param>
		public void Accept(IQMLSpecificationVisitor visitor)
		{
			visitor.VisitQMLProfileExpression(this);
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML profile eypression string containing all 
		/// information in this QMLProfileExpression which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML profile expression.</returns>
		public override string ToString()
		{
			string s = "";
			switch (this.type)
			{
				case QMLTokenTypes.PROFILE_EXP_PROFILE:
					s += "profile {\n";
					break;
			}
			IEnumerator enu = this.requirementClauses.GetEnumerator();
			while (enu.MoveNext())
				s += ((QMLRequirementClause)enu.Current).ToString()+"\n";
			s += "}";
			return s;
		}
		#endregion
	}
}

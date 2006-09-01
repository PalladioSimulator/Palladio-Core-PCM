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
	/// Represents a QML aspect constraint.
	/// </summary>
	public class QMLAspectConstraint : IQMLVisitable
	{
		#region attributes
		/// <summary>
		/// The name of the aspect constraint
		/// </summary>
		private string name;

		/// <summary>
		/// A list of aspects (IQMLStatConstraint objects)
		/// </summary>
		private ArrayList statConstraints;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLAspectConstraint containing the same information as the AST.
		/// </summary>
		/// <param name="aspectConstraint">AST representing a QML aspect 
		/// constraint.</param>
		public QMLAspectConstraint(AST aspectConstraint)
		{
			// check if the AST has the correct root node
			if (!aspectConstraint.getText().Equals("aspectConstr"))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLAspectConstraint constructor. "+
					"node name -aspectConstr- expected, but is -"+
					aspectConstraint.getText()+"-");

			AST child = aspectConstraint.getFirstChild();
			this.name = child.getText();

			this.statConstraints = new ArrayList();
			child = child.getNextSibling();
			for (int i=0; i<aspectConstraint.getNumberOfChildren()-1; i++)
			{
				this.statConstraints.Add(GetStatConstraint(child));
				child = child.getNextSibling();
			}
		}
		#endregion

		#region properties	
		/// <summary>
		/// Returns the name (QoS aspect) of this QMLAspectConstraint
		/// </summary>
		public string Name
		{
			get
			{
				return this.name;
			}
		}

		/// <summary>
		/// Returns the aspects (percentile, mean, variance, frequency) of
		/// this QMLAspectConstraint.
		/// </summary>
		public IList StatConstraints
		{
			get
			{
				return this.statConstraints;
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
			visitor.VisitQMLAspectConstraint(this);
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML aspect constraint string containing all 
		/// information in this QMLAspectConstraint which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML aspect constraint.</returns>
		public override string ToString()
		{
			string s = this.name+"{\n";
			IEnumerator enu = this.statConstraints.GetEnumerator();
			while (enu.MoveNext())
				s += ((IQMLStatConstraint)enu.Current).ToString()+"\n";
			s += "};";
			return s;
		}
		#endregion

		#region private methods
		/// <summary>
		/// Creates stat constraint objects from the given AST. 
		/// </summary>
		/// <param name="constraintAST">AST representing an 
		/// IQMLStatConstraint</param>
		/// <returns>The created IQMLStatConstraint</returns>
		private IQMLStatConstraint GetStatConstraint (AST constraintAST)
		{
			IQMLStatConstraint statConstraint = null;
			switch (constraintAST.Type)
			{
				case QMLTokenTypes.PERCENTILE_CONTR:
					statConstraint = new QMLPercentileAspect(constraintAST);
					break;
				case QMLTokenTypes.FREQUENCY_CONTR:
					statConstraint = new QMLFrequencyAspect(constraintAST);
					break;
				case QMLTokenTypes.MEAN_CONTR:
					statConstraint = new QMLMeanAspect(constraintAST);
					break;
				case QMLTokenTypes.VARIANCE_CONTR:
					statConstraint = new QMLVarianceAspect(constraintAST);
					break;
				default:
					throw new QMLSpecificationConstructionException
						("Illegal argument in QMLAspectConstraint "+
						"constructor. Unknown aspect type: "
						+constraintAST.Type);
			}
			return statConstraint;
		}
		#endregion
	}
}

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
	/// Represents a QML dimension type. At the moment only numeric types are
	/// supported which are saved as a string. 
	/// TODO: Implement types ENUM_DEF and SET_DEF and check if they can also
	///       be represented by a simple string.
	/// </summary>
	public class QMLDimensionType
	{
		#region data
		private string type;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new QMLDimensionType
		/// containing the same information as the AST.
		/// </summary>
		/// <param name="dimensionType">AST representing a QMLDimensionType.
		/// </param>
		public QMLDimensionType(AST dimensionType)
		{
			if ((dimensionType.Type == QMLTokenTypes.ENUM_DEF) ||
				(dimensionType.Type == QMLTokenTypes.SET_DEF))
				throw new QMLSpecificationConstructionException
					("Dimension types ENUM_DEF and SET_DEF not supported in "+
					"this version of QMLDimensionType.");
			else if (dimensionType.Type == QMLTokenTypes.NUMERIC_DEF)
			{
				AST child = dimensionType.getFirstChild();
				this.type = "";
				for (int i=0; i<dimensionType.getNumberOfChildren(); i++)
				{
					this.type += child.getText()+" ";
					child = child.getNextSibling();
				}
				this.type += dimensionType.getText();
			}
			else 
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLDimensionType constructor. "+
					 "Expected node types: ENUM_DEF, SET_DEF or NUMERIC_DEF");
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML dimension type string containing all information
		/// in this QMLDimensionType which is compatible to the grammar
		/// accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML dimension type.</returns>
		public override string ToString()
		{
			return this.type;
		}

		/// <summary>
		/// Determines whether this object and the given QMLDimensionType 
		/// object have the same value;
		/// </summary>
		/// <param name="obj">Object which is asked to equal this object.
		/// </param>
		/// <returns>True if this and obj have the same type, else false
		/// </returns>
		public override bool Equals(object obj)
		{
			if (obj.GetType().Equals(this.GetType()))
			{
				if (this.type.Equals(((QMLDimensionType)obj).type))
					return true;
			}
			return false;
		}
		#endregion
	}
}

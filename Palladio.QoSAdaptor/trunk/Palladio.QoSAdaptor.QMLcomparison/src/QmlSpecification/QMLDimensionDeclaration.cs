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

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a QML dimension declaration.
	/// </summary>
	public class QMLDimensionDeclaration
	{
		#region attributes
		/// <summary>
		/// The name of this dimension declaration. For the quality-based 
		/// interface model this equals a quality subattribute like the delay
		/// subattribute of the performance attribute.
		/// </summary>
		private string name;

		/// <summary>
		/// The dimension type of this dimension declaration.
		/// </summary>
		private QMLDimensionType dimensionType;

		/// <summary>
		/// The unit of this dimension declaration. E.g. msec or mb/msec
		/// </summary>
		private QMLUnit unit;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLDimensionDeclaration containing the same information as the AST.
		/// </summary>
		/// <param name="dimensionDeclaration">AST representing a 
		/// QMLDimensionDeclaration.</param>
		public QMLDimensionDeclaration(AST dimensionDeclaration)
		{
			// check if the AST has the correct root node
			if (!dimensionDeclaration.getText().Equals("dimensionDecl"))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLSpecification constructor. "+
					"node name -dimensionDecl- expected, but is -"+
					dimensionDeclaration.getText()+"-");

			// initialisation
			AST child = dimensionDeclaration.getFirstChild();
			this.name = child.getText();
			child = child.getNextSibling();
			this.dimensionType = new QMLDimensionType(child);
			child = child.getNextSibling();
			this.unit = new QMLUnit(child);
		}
		#endregion
	
		#region public methods
		/// <summary>
		/// Returns a new QML dimension declaration string containing all 
		/// information in this QMLDimensionDeclaration which is compatible to 
		/// the grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML dimension declaration.</returns>
		public override string ToString()
		{
			return this.name+": "+this.dimensionType+" "+this.unit+";";
		}

		/// <summary>
		/// Determines whether this object and the given 
		/// QMLDimensionDeclaration object have the same value;
		/// </summary>
		/// <param name="obj">Object which is asked to equal this object.
		/// </param>
		/// <returns>True if this and obj have the same name, type and unit, 
		/// else false
		/// </returns>
		public override bool Equals(object obj)
		{
			if (obj.GetType().Equals(this.GetType()))
			{
				if ((this.name.Equals(((QMLDimensionDeclaration)obj).name))
					&& this.dimensionType.Equals(
								((QMLDimensionDeclaration)obj).dimensionType)
					&& this.unit.Equals(
								((QMLDimensionDeclaration)obj).unit))
					return true;
			}
			return false;
		}

		/// <summary>
		/// Overrides GetHashCode. This is necessary, because Equals is 
		/// overridden.
		/// </summary>
		/// <returns>The hashcode of this object.</returns>
		public override int GetHashCode()
		{
			return base.GetHashCode ();
		}
		#endregion

	}
}

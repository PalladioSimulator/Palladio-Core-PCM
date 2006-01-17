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
	/// Represents a QMLUnit.
	/// </summary>
	public class QMLUnit
	{
		#region data
		private string unitString;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new QMLUnit
		/// containing the same information as the AST.
		/// </summary>
		/// <param name="unit">AST representing a QMLUnit.
		/// </param>
		public QMLUnit(AST unit)
		{
			// check if the AST has the correct root node
			if (!unit.getText().Equals("unit"))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLUnit constructor. "+
					"node name -unit- expected, but is -"+
					unit.getText()+"-");

			this.unitString = "";
			AST child = unit.getFirstChild();
			this.unitString += child.getText();
			child = child.getNextSibling();
			if (child != null)
				this.unitString += " / "+child.getText();
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML unit string containing all information
		/// in this QMLUnit which is compatible to the grammar
		/// accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML unit.</returns>
		public override string ToString()
		{
			return this.unitString;
		}

		/// <summary>
		/// Determines whether this object and the given QMLUnit object have 
		/// the same value;
		/// </summary>
		/// <param name="obj">Object which is asked to equal this object.
		/// </param>
		/// <returns>True if this and obj have the same unitString, else false
		/// </returns>
		public override bool Equals(object obj)
		{
			if (obj.GetType().Equals(this.GetType()))
			{
				if (this.unitString.Equals(((QMLUnit)obj).unitString))
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

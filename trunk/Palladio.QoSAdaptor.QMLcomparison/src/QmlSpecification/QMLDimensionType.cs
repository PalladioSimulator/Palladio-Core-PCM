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
	/// TODO: Implement types ENUM_DEF and SET_DEF. Introduce enumeration for 
	///		types.
	/// </summary>
	public class QMLDimensionType
	{
		#region attributes
		/// <summary>
		/// The type of this dimension type. In the current implementation only
		/// NUMERIC is supported. 
		/// </summary>
		private Type type;

		/// <summary>
		/// The dimension order of this dimension type. In the current 
		/// implementation only INCREASING and DECREASING are supported.
		/// </summary>
		private DimensionOrder dimensionOrder;		
		#endregion

		#region enumerations
		/// <summary>
		/// Enumeration that defines possible types of a QMLDimensionType.
		/// </summary>
		public enum Type 
		{	
			/// <summary>
			/// An enumeration of values.
			/// </summary>
			ENUMERATION, 

			/// <summary>
			/// A set of values.
			/// </summary>
			SET, 

			/// <summary>
			/// A numeric value.
			/// </summary>
			NUMERIC
		};

		/// <summary>
		/// Defines the order of values of the domain.
		/// </summary>
		public enum DimensionOrder
		{
			/// <summary>
			/// NO order is defined for the domain values.
			/// </summary>
			NONE, 

			/// <summary>
			/// Values are ordered increasingly.
			/// </summary>
			INCREASING, 

			/// <summary>
			/// Values are ordered decreasingly.
			/// </summary>
			DECREASING
		};
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
				this.type = Type.NUMERIC;
				AST child = dimensionType.getFirstChild();
				for (int i=0; i<dimensionType.getNumberOfChildren(); i++)
				{
					switch (child.Type)
					{
						case QMLTokenTypes.DECREASING_ORDER_SEM:
							this.dimensionOrder = DimensionOrder.DECREASING;
							break;
						case QMLTokenTypes.INCREASING_ORDER_SEM:
							this.dimensionOrder = DimensionOrder.INCREASING;
							break;
						default:
							throw new QMLSpecificationConstructionException
								("Only increasing and decreasing are allowed "+
								"as dimension orders. Dimension declarations "+
								"without a dimension order are not supported" +
								"in the current implementation.");
					}	
					child = child.getNextSibling();
				}
			}
			else 
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLDimensionType constructor. "+
					 "Expected node types: ENUM_DEF, SET_DEF or NUMERIC_DEF");
		}
		#endregion

		#region properties
		/// <summary>
		/// Provides the type of this dimension type.
		/// </summary>
		internal Type DimensionType
		{
			get
			{
				return this.DimensionType;
			}
		}

		/// <summary>
		/// Returns the dimension order of this dimension type.
		/// </summary>
		internal DimensionOrder Order
		{
			get
			{
				return this.dimensionOrder;
			}
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
			string s = "";
			switch (this.dimensionOrder)
			{
				case DimensionOrder.DECREASING:
					s += "decreasing ";
					break;
				case DimensionOrder.INCREASING:
					s += "increasing ";
					break;
			}
			switch (this.type)
			{
				case Type.NUMERIC:
					s += "numeric";
					break;
			}
			return s;
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

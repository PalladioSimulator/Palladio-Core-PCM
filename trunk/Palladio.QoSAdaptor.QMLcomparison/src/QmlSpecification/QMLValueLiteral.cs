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
using System.Collections;
using System.Globalization;
using antlr.collections;
using QmlParser;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a value literal.
	/// 
	/// TODO: Use polymorphy instead of different types in this class?
	/// </summary>
	public class QMLValueLiteral
	{
		#region attributes
		/// <summary>
		/// The type of this value literal. The type value is 
		/// specified in QMLParser.QMLTokenTypes
		/// </summary>
		private int type;
		private double numberValue;
		private string nameValue;
		private ArrayList nameListValue;
		#endregion

		#region properties
		// The value depends on the type. I.e. that the Type property has to
		// be called before one of the *Value propertys can be called.
		/// <summary>
		/// The type of this QMLValueLiteral. The values are specified in 
		/// QMLParser.QMLTokenTypes.
		/// </summary>
		public int Type
		{
			get
			{
				return this.type;
			}
		}
		/// <summary>
		/// The number value of this QMLValueLiteral. Only assigned, if 
		/// Type == QMLTokenTypes.NUMBER
		/// </summary>
		public double NumberValue
		{
			get
			{
				if (this.numberValue == -1)
					throw new QMLNoValidValueException("NumberValue is not "+
						"defined in this instance of QMLValueLiteral. Check "+
						"the Value property before calling NumberValue.");
				else 
					return this.numberValue;
			}
		}

		/// <summary>
		/// The name value of this QMLValueLiteral. Only assigned, if 
		/// Type == QMLTokenTypes.NAME
		/// </summary>
		public string NameValue
		{
			get
			{
				if (this.nameValue.Equals(""))
					throw new QMLNoValidValueException("NameValue is not "+
						"defined in this instance of QMLValueLiteral. Check "+
						"the Value property before calling NameValue.");
				else 
					return this.nameValue;
			}
		}

		/// <summary>
		/// The name list value of this QMLValueLiteral. Only assigned, if 
		/// Type == QMLTokenTypes.NAME_LIST
		/// </summary>
		public IList NameListValue
		{
			get
			{
				if (this.nameListValue != null)
					throw new QMLNoValidValueException("NameListValue is not "+
						"defined in this instance of QMLValueLiteral. Check "+
						"the Value property before calling NameListValue.");
				else 
					return this.nameListValue;
			}
		}
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new QMLValueLiteral
		/// containing the same information as the AST.
		/// </summary>
		/// <param name="valueLiteral">AST representing a QML value literal.
		/// </param>
		public QMLValueLiteral(AST valueLiteral)
		{
			this.type = valueLiteral.Type;
			this.nameValue = null;
			this.nameListValue = null;
			switch (valueLiteral.Type)
			{
				case QMLTokenTypes.NUMBER:
					this.numberValue = Double.Parse(valueLiteral.getText(), 
						new CultureInfo("en-US"));
					break;
				case QMLTokenTypes.NAME:
					this.nameValue = valueLiteral.getText();
					break;
				case QMLTokenTypes.NAME_LIST:
					this.nameListValue = new ArrayList();
					AST child = valueLiteral.getFirstChild();
					for (int i=0; i<valueLiteral.getNumberOfChildren(); i++)
					{
						this.nameListValue.Add(child.getText());
						child = child.getNextSibling();
					}
					break;
				default:
					throw new QMLSpecificationConstructionException
						("Illegal argument in QMLValueLiteral constructor. "+
						"Unknown value literal type: "+valueLiteral.Type);
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML value literal string containing all information
		/// in this QMLValueLiteral which is compatible to the grammar
		/// accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML value literal.</returns>
		public override string ToString()
		{
			string s = "";
			switch (this.type)
			{
				case QMLTokenTypes.NUMBER:
					s = this.numberValue.ToString();
					break;
				case QMLTokenTypes.NAME:
					s = this.nameValue;
					break;
				case QMLTokenTypes.NAME_LIST:
					s = "enum {";
					IEnumerator enu = this.nameListValue.GetEnumerator();
					while (enu.MoveNext())
						s += (string)enu.Current;
					break;
			}
			return s;
		}

		/// <summary>
		/// Tests if the given object equals this QMLValueLiteral.
		/// </summary>
		/// <param name="obj">Object to test.</param>
		/// <returns>True if the given object is a QMLValueLiteral of the same 
		/// type as this QMLValueLiteral and has the same value. Else false.
		/// </returns>
		public override bool Equals(object obj)
		{
			if (this.GetType() == obj.GetType())
			{
				QMLValueLiteral value = (QMLValueLiteral)obj;
				switch (this.type)
				{
					case QMLTokenTypes.NUMBER:
						if (this.numberValue == value.numberValue)
							return true;
						break;
					case QMLTokenTypes.NAME:
						if (this.nameValue.Equals(value.nameValue))
							return true;
						break;
					case QMLTokenTypes.NAME_LIST:
						// TODO: implement
						// TODO: Are name lists ordered ???
						break;
					default:
						throw new Exception("Error on QMLValueLiteral.Equals."+
							"Unknown value literal type: "+this.type);
							
				}
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


		/// <summary>
		/// Compares the given QMLValueLiteral to this QMLValueLiteral. Both
		/// QMLLiterals need to be of the same type.
		/// </summary>
		/// <param name="value">A QMLValueLiteral.</param>
		/// <returns>Integer smaller than 0, if this QMLLiteral is smaller than
		/// the given QMLLiteral. 0, if both are equal. Integer bigger than 0, 
		/// if this QMLLiteral is bigger than the given QMLLiteral.</returns>
		public int CompareTo (QMLValueLiteral value)
		{
			if (this.type != value.Type)
				throw new Exception("Error in QMLLiteral.CompareTo(). The "+
					"given QMLLiteral has a wrong type.");
			switch (this.type)
			{
				case QMLTokenTypes.NUMBER:
					if (this.numberValue < value.numberValue)
						return -1;
					else if (this.numberValue > value.numberValue)
						return 1;
					// the equality case is handled after the switch statement.
					break;
				case QMLTokenTypes.NAME:
					return this.nameValue.CompareTo(value.nameValue);
				case QMLTokenTypes.NAME_LIST:
					if (this.nameListValue.Equals(value.nameListValue))
						return 0;
					else
						throw new Exception("Error in "+
							"QMLValueLiteral.CompareTo(). An order on the "+
							"values of lists is not defined.");
				default:
					throw new Exception("Error in QMLLiteral.CompareTo(). "+
						"Unknown value literal type.");
			}

			// The two objects are assumed to be equal
			return 0;
		}
		#endregion
	}
}

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
	/// Represents QMLTokenTypes.ENTITY, QMLTokenTypes.ENTITY_PARM and 
	/// QMLTokenTypes.ENTITY_RESULT_OF concepts, which are differed by the 
	/// type attribute.
	/// </summary>
	public class QMLEntity
	{
		#region attributes
		/// <summary>
		/// The type of this entity.
		/// </summary>
		private int type;

		/// <summary>
		/// The name of this entity.
		/// </summary>
		private string name;
		#endregion

		#region properties
		/// <summary>
		/// The type of this QMLEntity. Types are specified in 
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
		/// The name of this QMLEntity.
		/// </summary>
		public string Name
		{
			get
			{
				return this.name;
			}
		}
		#endregion

		#region contructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new 
		/// QMLEntity containing the same information as the AST.
		/// </summary>
		/// <param name="entity">AST representing a QML entity.</param>
		public QMLEntity(AST entity)
		{
			AST child = entity.getFirstChild();
			switch (entity.Type)
			{
				case QMLTokenTypes.ENTITY:
					this.name = child.getText();
					break;
				case QMLTokenTypes.ENTITY_PARM:
					this.name = child.getText();
					child = child.getNextSibling();
					this.name += "."+child.getText();
					break;
				case QMLTokenTypes.ENTITY_RESULT_OF:
					this.name = child.getText();
					break;
				default:
					throw new QMLSpecificationConstructionException
						("Illegal argument in QMLEntity constructor. "+
						"expected entity node is not of type ENTITY, ENTITY_PARM "+
						"or ENTITY_RESULT_OF.");
			}
			this.type = entity.Type;
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML entity string containing all 
		/// information in this QMLEntity which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML entity.</returns>
		public override string ToString()
		{
			string s = "";
			if (this.type == QMLTokenTypes.ENTITY_RESULT_OF)
				s+= "result of ";
			s += this.name;
			return s;
		}

		/// <summary>
		/// Defines two objects to be equal if they are both QMLEntity's and 
		/// have the same type and name.
		/// </summary>
		/// <param name="obj"></param>
		/// <returns></returns>
		public override bool Equals(object obj)
		{
			if (this.GetType().Equals(obj.GetType()))
			{
				QMLEntity entity = (QMLEntity)obj;
				if (this.name.Equals(entity.Name) &&
					this.type == entity.Type)
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

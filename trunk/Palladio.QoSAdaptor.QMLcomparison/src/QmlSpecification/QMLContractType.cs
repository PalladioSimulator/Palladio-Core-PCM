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

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a QML contract type specification.
	/// </summary>
	public class QMLContractType
	{
		#region attributes
		/// <summary>
		/// The name of this contract type.
		/// </summary>
		private string name;

		/// <summary>
		/// A list of dimensionDeclarations of this contract type.
		/// </summary>
		private ArrayList dimensionDeclarations;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new QMLContractType
		/// containing the same information as the AST.
		/// </summary>
		/// <param name="contractType">AST representing a QMLContractType.
		/// </param>
		public QMLContractType(AST contractType)
		{
			// check if the AST has the correct root node
			if (!contractType.getText().Equals("contrTypeDecl"))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLContractType constructor. "+
					"node name -contrTypeDecl- expected, but is -"+
					contractType.getText()+"-");
		
			// Initialisations
			this.dimensionDeclarations = new ArrayList();
			AST child = contractType.getFirstChild();
			this.name = child.getText();

			child = child.getNextSibling();
			for (int i=0; i<contractType.getNumberOfChildren()-1; i++)
			{
				this.dimensionDeclarations.Add(
										new QMLDimensionDeclaration(child));
				child = child.getNextSibling();
			}
		}
		#endregion

		#region properties
		/// <summary>
		/// Returns the name of this contract type.
		/// </summary>
		public string Name
		{
			get
			{
				return this.name;
			}
		}

		/// <summary>
		/// Returns a collection of dimension declarations belonging to this 
		/// contract type.
		/// </summary>
		public ICollection DimensionDeclarations
		{
			get
			{
				return this.dimensionDeclarations;
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns a new QML contract type string containing all information
		/// in this QMLContractType which is compatible to the grammar
		/// accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML contract type specification.</returns>
		public override string ToString()
		{
			string s = "type "+this.name+" = contract {\n";
			foreach (QMLDimensionDeclaration declaration in 
				this.dimensionDeclarations)
				s += declaration.ToString()+"\n";
			s += "}";
			return s;
		}

		/// <summary>
		/// Determines whether this object and the given 
		/// QMLContractType object have the same value;
		/// </summary>
		/// <param name="obj">Object which is asked to equal this object.
		/// </param>
		/// <returns>True if this and obj have the name and dimension 
		/// declarations, else false
		/// </returns>
		public override bool Equals(object obj)
		{
			if (obj.GetType().Equals(this.GetType()))
			{
				if (!(this.name.Equals(((QMLContractType)obj).name)))
					return false;
				else
				{
					// Check if both QMLContractTypes have the same dimension
					// declarations
					foreach (QMLDimensionDeclaration thisDeclaration in
						this.dimensionDeclarations)
					{
						bool check = false;
						foreach (QMLDimensionDeclaration objDeclaration in
							((QMLContractType)obj).dimensionDeclarations)
						{
							if (thisDeclaration.Equals(objDeclaration))
								check = true;
						}
						// if the given object does not contain a dimension
						// declaration this object contains, the whole
						// comparsion gets false
						if (!check)
							return false;
					}
					return true;
				}
			}
			return false;
		}
		#endregion
	}
}

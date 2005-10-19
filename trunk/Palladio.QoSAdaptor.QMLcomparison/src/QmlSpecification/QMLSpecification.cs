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
using Palladio.QoSAdaptor.Interfaces;
using Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a QML specification.
	/// </summary>
	public class QMLSpecification : IInterfaceModelSpecification, IQMLVisitable
	{
		#region attributes
		private ArrayList contracts;
		private ArrayList contractTypes;
		private ArrayList profiles;
		#endregion

		#region properties
		/// <summary>
		/// Provides a collection of the profiles of this specification. 
		/// </summary>
		public ICollection Profiles
		{
			get
			{
				return this.profiles;
			}
		}
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new QMLSpecification
		/// containing the same information as the AST.
		/// </summary>
		/// <param name="specification">AST representing a QML specification.
		/// </param>
		public QMLSpecification(AST specification)
		{
			// check if the AST has the correct root node
			if (!specification.getText().Equals("declarations"))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLSpecification constructor. "+
					"node name -declarations- expected, but is -"+
					specification.getText()+"-");
			
			// initialise ArrayLists
			this.contracts = new ArrayList();
			this.contractTypes = new ArrayList();
			this.profiles = new ArrayList();

			// construct contracts, contractTypes and profiles
			AST child = specification.getFirstChild();
			for (int i=0; i<specification.getNumberOfChildren(); i++)
			{
				if (child.getText().Equals("contrTypeDecl"))
					this.contractTypes.Add(new QMLContractType(child));
				else if (child.getText().Equals("contrDecl"))
					this.contracts.Add(new QMLContract(child));
				else if (child.getText().Equals("profileDecl"))
				{
					this.profiles.Add(new QMLProfile(child, this));
					// TODO: check if the profile contains contracts not yet
					// listed in this.contracts and add them.
				}
				child = child.getNextSibling();
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
			visitor.VisitQMLSpecification(this);
		}
		#endregion

		#region public methods
		/// <summary>
		/// If this specification contains a contract with the given name the
		/// corresponding QMLContract is returned. 
		/// </summary>
		/// <param name="contractName">Name of the seeked contract.</param>
		/// <returns>Corresponding QMLContract or null if no contract with the
		/// given name exists in this specification.</returns>
		public QMLContract GetContract (string contractName)
		{
			QMLContract contract = null;
			foreach (QMLContract currentContract in this.contracts)
			{
				if (currentContract.Name.Equals(contractName))
				{
					contract = currentContract;
					break;
				}	
			}
			return contract;
		}

		/// <summary>
		/// If this specification contains a profile with the given interface 
		/// name the corresponding QMLProfile is returned. Else null is 
		/// returned.
		/// </summary>
		/// <param name="interfaceName">Name of the seeked profile.</param>
		/// <returns>Corresponding QMLProfile or null if no contract with the
		/// given name exists in this specification.</returns>
		public QMLProfile GetProfile (string interfaceName)
		{
			QMLProfile profile = null;
			foreach (QMLProfile currentProfile in this.profiles)
			{
				if (currentProfile.InterfaceName.Equals(interfaceName))
				{
					profile = currentProfile;
					break;
				}	
			}
			return profile;
		}

		/// <summary>
		/// Returns a new QML specification string containing all information
		/// in this QMLSpecification which is compatible to the grammar
		/// accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML specification.</returns>
		public override string ToString ()
		{
			string specification = "";
			foreach (QMLContractType contractType in this.contractTypes)
				specification+= contractType.ToString()+"\n\n";

			foreach (QMLContract contract in this.contracts)
				specification += contract.ToString()+"\n\n";

			foreach (QMLProfile profile in this.profiles)
				specification += profile.ToString()+"\n\n";

			return specification;
		}
		#endregion
	}
}

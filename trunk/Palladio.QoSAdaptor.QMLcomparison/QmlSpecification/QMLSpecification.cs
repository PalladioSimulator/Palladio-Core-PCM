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
using Palladio.QoSAdaptor;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Represents a QML specification.
	/// </summary>
	public class QMLSpecification
	{
		#region data
		private ArrayList contracts;
		private ArrayList contractTypes;
		private ArrayList profiles;
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

		#region public methods
		/// <summary>
		/// This method compares this QMLSpecification to the given 
		/// specification, whereas this specification is looked upon as 
		/// the required specification (seen in a CBSE context) and the given
		/// specification as provided specification.
		/// This method returns a list of QoS aspects (e.g. performance or 
		/// reliability) that are required by this specification but not 
		/// provided by the specication given as parameter. 
		/// 
		/// For the search for mismatches it is required that the requirements
		/// for a certain interface a described in exactly one profile.
		/// Discriptions in two different profiles are not recognized. 
		/// TODO: Is this QML standard?
		/// 
		/// The result of this method is a list of Mismatch objects which 
		/// represent a mismatched QoS aspect and the corresponding interface
		/// and entity.
		/// </summary>
		/// <param name="providedSpecification">The provided QMLSpecification 
		/// which is expected to contain mismatches to this specification.
		/// </param>
		/// <returns>IList with Mismatch objects.</returns>
		public IList GetMismatches (QMLSpecification providedSpecification)
		{
			ArrayList mismatches = new ArrayList();
			// To find mismatches the provided specification has to specify the
			// same entities in the same interfaces as this specification.
			// This is called complete coping here.
			foreach (QMLProfile profile in this.profiles)
			{
				// TODO: Throw more precise exception. Which method is not 
				//       covered.
				if (!CheckCompleteCoping(profile, providedSpecification))
					throw new IncompleteInterfaceCopingException 
						("Error in mismatch detection. The given "+
						"specification does not cover the same interface as "+
						"the called QMLSpecification object.");
			}

			// For every entity specified in this specification it has to be
			// verfied that the provided specification does not mismatch the
			// required specification
			foreach (QMLProfile profile in this.profiles)
			{
				mismatches.AddRange(FindProfileMismatches(profile, 
					providedSpecification));
			}
			return mismatches;
		}

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

		#region private methods
		/// <summary>
		/// Checks if the given profile is completely covered by the given 
		/// specification. I.e. the interface and the entities in the profile
		/// are also described by the same contract types in the given 
		/// specification.
		/// </summary>
		/// <param name="profile">A profile of the required specification.
		/// </param>
		/// <param name="specification">The specification of the provided
		/// service.</param>
		/// <returns>True if the profile is covered by the given specification.
		/// Else false.</returns>
		private bool CheckCompleteCoping (QMLProfile profile, 
												QMLSpecification specification)
		{
			bool check = false;
			foreach (QMLProfile currentProfile in specification.profiles)
			{
				if (currentProfile.Covers(profile))
					check = true;
			}
			return check;
		}

		/// <summary>
		/// Searches for profile mismatches. I.e. a contract in the given 
		/// profile is more strict than the corresponding contract in the 
		/// provided specification.
		/// </summary>
		/// <param name="profile">Profile of the required specification.
		/// </param>
		/// <param name="providedSpecification">The QML specification of the 
		/// provided service.</param>
		/// <returns>A list of Mismatch objects.</returns>
		private IList FindProfileMismatches (QMLProfile profile, 
			QMLSpecification providedSpecification)
		{
			ArrayList mismatches = new ArrayList();
			bool check = false;
			foreach (QMLProfile currentProfile in 
				providedSpecification.profiles)
			{
				if (profile.InterfaceName.Equals(currentProfile.InterfaceName))
				{
					// TODO
					mismatches.AddRange(profile.FindMismatches(
						currentProfile));
					check = true;
				}
			}
			if (!check)
				throw new QMLMismatchSearchException("No provided profile for"+
					"interface: "+profile.InterfaceName);

			return mismatches;
		}
		#endregion
	}
}

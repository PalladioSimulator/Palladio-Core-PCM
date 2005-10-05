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
	/// A QML profile describes QoS requirements for a certain interface.
	/// </summary>
	public class QMLProfile
	{
		#region data
		private string name;
		private string interfaceName;
		private QMLProfileExpression profileExpression;
		#endregion

		#region properties
		/// <summary>
		/// The interface for which this profile specifies QoS attributes.
		/// </summary>
		public string InterfaceName
		{
			get
			{
				return this.interfaceName;
			}
		}

		/// <summary>
		/// The profile expression belonging to this profile.
		/// </summary>
		public QMLProfileExpression ProfileExpression
		{
			get
			{
				return this.profileExpression;
			}
		}
		#endregion

		#region constructor
		/// <summary>
		/// Constructor that takes an AST and constructs a new QMLProfile 
		/// containing the same information as the AST.
		/// </summary>
		/// <param name="profile">AST representing a QML profile.</param>
		/// <param name="specification">The QMLSpecification this profile is 
		/// a part of.</param>
		public QMLProfile(AST profile, QMLSpecification specification)
		{
			// check if the AST has the correct root node
			if (!profile.getText().Equals("profileDecl"))
				throw new QMLSpecificationConstructionException
					("Illegal argument in QMLProfile constructor. "+
					"node name -profileDecl- expected, but is -"+
					profile.getText()+"-");

			AST child = profile.getFirstChild();
			this.name = child.getText();
			child = child.getNextSibling();
			this.interfaceName = child.getText();
			child = child.getNextSibling();
			this.profileExpression = new QMLProfileExpression(child, 
																specification);
		}
		#endregion

		#region public methods
		/// <summary>
		/// Checks, if the given profile covers the same interface as this 
		/// profile. Thereby it is possible that this profile describes
		/// more entities than the given profile.
		/// </summary>
		/// <param name="profile">Profile which shall cover the same interface
		/// as this profile.</param>
		/// <returns>True, if this profile covers the same interface as the
		/// given profile. False, else.</returns>
		public bool Covers (QMLProfile profile)
		{
			if (profile.InterfaceName.Equals
				(this.interfaceName))
			{
				// check entities
				if (this.profileExpression.Covers(profile.ProfileExpression))	
					return true;
			}
			return false;
		}

		/// <summary>
		/// Returns a new QML profile string containing all 
		/// information in this QMLProfile which is compatible to the 
		/// grammar accepted by the QMLParser by Lars Karg.
		/// </summary>
		/// <returns>QML profile.</returns>
		public override string ToString()
		{
			return this.name+" for "+this.interfaceName+" = "+
					this.profileExpression.ToString();
		}

		/// <summary>
		/// Searches for mismatches between the entities of this QMLProfile and
		/// the given provided profile.
		/// </summary>
		/// <param name="providedProfile">A QML profile of the provided 
		/// service.</param>
		/// <returns>A list of Mismatch objects.</returns>
		public IList FindMismatches(QMLProfile providedProfile)
		{
			if (!this.interfaceName.Equals(providedProfile.InterfaceName))
				throw new QMLMismatchSearchException("Error in QMLProfile."+
					"FindMismatches. The profiles do not describe the "+
					"same interfaces.");
			
			return this.profileExpression.FindMismatches(
				providedProfile.ProfileExpression, this.interfaceName);
		}
		#endregion
	}
}

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

namespace Palladio.QoSAdaptor.Configuration
{
	/// <summary>
	/// This class is a container for some configuration constants needed by 
	/// the components in the AdapterGeneration projects.
	/// IMPORTANT: All links are specified relative to the bin directory in 
	/// the top Palladio.QoSAdaptor folder. All executables created by the 
	/// Palladio.QoSAdaptor subprojects are therefore assumed to be saved in  
	/// that folder.
	/// </summary>
	public class Config
	{
		#region constants
		/// <summary>
		/// Path to the directory in which all pattern information is saved.
		/// The path is relative to the bin directory.
		/// </summary>
		public const string PATTERN_DIRECTORY = 
											"..\\Patterns\\";

		/// <summary>
		/// Indicates whether subaspects of mismatched QoS aspects should be 
		/// considered when searching for patterns that are able to correct 
		/// the mismatch.
		/// </summary>
		public const bool considerSubAspectsInPatternSearch = false;
		#endregion
	}
}

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

namespace Palladio.QoSAdaptor.Interfaces
{
	/// <summary>
	/// Represents a mismatch between two interface model descriptions. 
	/// 
	/// TODO: Find similarities between the interface model mismatches. 
	/// TODO: How can details about the mismatches as percentiles in an 
	///			QML specification be modelled commonly???
	/// </summary>
	public interface IMismatch
	{
		/// <summary>
		/// String representation of the mismatch needed in the GUI.
		/// </summary>
		/// <returns></returns>
		string ToString();

		/// <summary>
		/// Returns the name of the interface the mismatch occurs in.
		/// </summary>
		string InterfaceName{get;}

		/// <summary>
		/// Returns the name of the entity that corresponds to this mismatch.
		/// Returns null, if the mismatch regards the whole interface.
		/// </summary>
		string Entity{get;}

		/// <summary>
		/// Returns the name of the mismatched attribute belonging to this 
		/// Mismatch
		/// </summary>
		string MismatchAttribute{get;}

		/// <summary>
		/// Returns the name of the mismatched subattribute belonging to this 
		/// Mismatch
		/// </summary>
		string MismatchSubAttribute{get;}

		/// <summary>
		/// Provides further information about the mismatch.
		/// </summary>
		string MismatchDetails{get;}

	}
}

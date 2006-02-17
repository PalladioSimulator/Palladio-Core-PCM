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

namespace Palladio.QoSAdaptor.Enumerations
{
	/// <summary>
	/// Enumeration representing the considered interface model
	/// </summary>
	public enum InterfaceModel
	{
		/// <summary>
		/// The syntax-based interface model describes describes signature
		/// mismatches.
		/// </summary>
		SYNTAX, 
		/// <summary>
		/// The behavioural interface model describes mismatches in 
		/// assertions.
		/// </summary>
		BEHAVIOUR, 
		/// <summary>
		/// The interaction-based interface model describes protocoll 
		/// mismatches.
		/// </summary>
		INTERACTION,
		/// <summary>
		/// The quality-based interface model describes mismatches of 
		/// quality attributes like performance or reliability.
		/// </summary>
		QUALITY,
		/// <summary>
		/// The conceptual interface model describes concept mismatches like 
		/// equally defined entities with different names.
		/// </summary>
		CONCEPTUAL
	}
}

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

namespace Palladio.QoSAdaptor.Pattern
{
	/// <summary>
	/// Enumeration representing the possible values of the suitability of
	/// a mismatch attribute.
	/// </summary>
	public enum SuitabilityValue
	{
		/// <summary>
		/// Suitability of the pattern to fix the mismatch is not known.
		/// </summary>
		UNKNOWN,
		/// <summary>
		/// Pattern is highly suitable to fix the mismatch.
		/// </summary>
		PLUSPLUS, 
		/// <summary>
		/// Pattern is suitable to fix the mismatch.
		/// </summary>
		PLUS, 
		/// <summary>
		/// Usage of the pattern is neutral refering to the considered mismatch.
		/// </summary>
		NEUTRAL,
		/// <summary>
		/// Usage of the pattern will make the mismatch worse or rather cause a 
		/// new mismatch, if there is no mismatch for the described attribute
		/// yet.
		/// </summary>
		MINUS,
		/// <summary>
		/// Usage of the pattern will make the mismatch much worse or rather 
		/// cause a new mismatch, if there is no mismatch for the described 
		/// attribute yet.
		/// </summary>
		MINUSMINUS
	}
}

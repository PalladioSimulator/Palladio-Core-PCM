using Palladio.QoSAdaptor.Pattern;

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

namespace Palladio.QoSAdaptor.Generation
{
	/// <summary>
	/// The provided interface of the Palladio.QoSAdaptor.Generation component. 
	/// </summary>
	public interface IGenerator
	{
		/// <summary>
		/// Starts the generation process for the given pattern. Generates 
		/// artifact using CodeSmith. 
		/// </summary>
		/// <param name="pattern">The PatternDescription of the pattern for 
		/// which artifacts are to be generated.</param>
		/// <param name="configurationPath">The path of the CodeSmith 
		/// configuration file.</param>
		/// 
		/// TODO: Remove configurationPath and use standard path name?
		bool Start(IPatternDescription pattern, string configurationPath);
	}
}

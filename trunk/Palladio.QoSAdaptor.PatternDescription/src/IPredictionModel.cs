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

namespace Palladio.QoSAdaptor.Pattern
{
	/// <summary>
	/// Public interface of a PredictionModel.
	/// 
	/// All constructors and setters are implemented as internal. The 
	/// interface only provides read methods.
	/// </summary>
	public interface IPredictionModel
	{
		#region properties
		/// <summary>
		/// The name of the prediction model.
		/// </summary>
		string Name{get;}

		/// <summary>
		/// States how to use the predicition model.
		/// </summary>
		string UsageInstructions{get; set;}

		/// <summary>
		/// A list of templates belonging to the prediction model.
		/// </summary>
		IList Templates{get;}


		#endregion
	}
}

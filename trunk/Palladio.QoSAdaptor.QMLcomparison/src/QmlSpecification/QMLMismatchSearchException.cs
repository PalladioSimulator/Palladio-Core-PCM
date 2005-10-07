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

using System;

namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecification
{
	/// <summary>
	/// Exception thrown if an error occured during a mismatch search.
	/// </summary>
	public class QMLMismatchSearchException: Exception
	{
		/// <summary>
		/// Constructor that defines a default message and adds the given 
		/// message.
		/// </summary>
		/// <param name="message"></param>
		public QMLMismatchSearchException(string message):
			base("Error in mismatch search. "+message)
		{
		}
	}
}

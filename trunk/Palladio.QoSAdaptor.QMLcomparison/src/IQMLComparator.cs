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

using System.IO;
using Palladio.QoSAdaptor.Interfaces;
using Palladio.QoSAdaptor.QMLComparison.QmlSpecification;

namespace Palladio.QoSAdaptor.QMLComparison
{
	/// <summary>
	/// Interface provided by the Palladio.QoSAdaptor.QMLComparision component.
	/// </summary>
	public interface IQMLComparator : IComparator
	{
		/// <summary>
		/// Creates a QMLSpecification from the textual QML specification given
		/// in form of a textReader.
		/// </summary>
		/// <param name="textReader">TextReader containing a textual 
		/// representation of a QML specification.</param>
		/// <returns></returns>
		QMLSpecification CreateQMLSpecification (TextReader textReader);
	}
}

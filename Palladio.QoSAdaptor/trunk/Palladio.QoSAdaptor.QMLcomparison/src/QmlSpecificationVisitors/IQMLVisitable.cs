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


namespace Palladio.QoSAdaptor.QMLComparison.QmlSpecificationVisitors
{
	/// <summary>
	/// Interface that should be implemented by all classes that accept an
	/// IQMLSpecificationVisitor.
	/// </summary>
	internal interface IQMLVisitable
	{
		/// <summary>
		/// Method to pass a visitor to the visitable class. The implementation
		/// of the method should call corresponding Visit... method of the 
		/// given visitor. 
		/// </summary>
		/// <param name="visitor">Implemenation of the IQMLSpecificationVisitor 
		/// interface that implements an operation on QML specification class 
		/// tree.</param>
		void Accept(IQMLSpecificationVisitor visitor);
	}
}

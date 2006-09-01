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
using Palladio.QoSAdaptor.Enumerations;
using Palladio.QoSAdaptor.Interfaces;

namespace Palladio.QoSAdaptor.Control
{
	/// <summary>
	/// The interface provided by the Palladio.QoSAdaptor.Control component. 
	/// </summary>
	public interface IController
	{
		#region methods
		/// <summary>
		/// This method starts the the analysis of the interface models,
		/// the selection of a pattern that solves interface model mismatches 
		/// and the generation of an adaptor and a prediction model using that
		/// pattern.
		/// </summary>
		/// <param name="interfaceModel">The considered interface model.
		/// </param>
		/// <param name="requiredSpecification">The required interface model 
		/// specification as IInterfaceModelSpecification.
		/// </param>
		/// <param name="providedSpecification">The provided interface model
		/// specification as IInterfaceModelSpecification.</param>
		void Start (InterfaceModel interfaceModel, 
		            IInterfaceModelSpecification requiredSpecification,
					IInterfaceModelSpecification providedSpecification);

		/// <summary>
		/// This method starts the the analysis of the interface models,
		/// the selection of a pattern that solves interface model mismatches 
		/// and the generation of an adaptor and a prediction model using that
		/// pattern.
		/// </summary>
		/// <param name="interfaceModel">The considered interface model.
		/// </param>
		/// <param name="required">The required interface model 
		/// specification as TextReader.
		/// </param>
		/// <param name="provided">The provided interface model
		/// specification as TextReader.</param>
		void Start(InterfaceModel interfaceModel, TextReader required, 
			TextReader provided);
		#endregion
	}
}

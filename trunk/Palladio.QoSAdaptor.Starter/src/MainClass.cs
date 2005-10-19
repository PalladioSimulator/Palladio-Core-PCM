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

using Palladio.QoSAdaptor.Control;
using System.IO;
using Palladio.QoSAdaptor.Enumerations;
using Palladio.QoSAdaptor.Interfaces;
using Palladio.QoSAdaptor.QMLComparison;

namespace Palladio.QoSAdaptor.Starter
{
	/// <summary>
	/// Starts the QoSAdaptor as console application.
	/// </summary>
	public class MainClass
	{
		/// <summary>
		/// The main class of the Starter. Opens the given files and starts the
		/// QoSAdaptor generation application.
		/// </summary>
		/// <param name="args"></param>
		public static void Main (string[] args)
		{
			QMLComparator comparator = new QMLComparator();

			IInterfaceModelSpecification requiredSpecification = null;
			IInterfaceModelSpecification providedSpecification = null;

			// TODO: Exception handling
			StreamReader requiredReader = new StreamReader(new FileStream
				(args[0], System.IO.FileMode.Open));
			requiredSpecification = comparator.CreateQMLSpecification(
				requiredReader);
			requiredReader.Close();

			StreamReader providedReader = new StreamReader(new FileStream
				(args[1], System.IO.FileMode.Open));
			providedSpecification = comparator.CreateQMLSpecification(
				providedReader);
			providedReader.Close();

			IController controller = new Controller();
			controller.Start(InterfaceModel.QUALITY, 
				requiredSpecification, providedSpecification);
		}
	}
}

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

namespace Palladio.QoSAdaptor.Starter
{
	/// <summary>
	/// Starts the QoSAdaptor as console application.
	/// </summary>
	public class MainClass
	{
		public static void Main (string[] args)
		{
			FileStream fileStream = new FileStream(args[0], 
				System.IO.FileMode.Open);
			StreamReader requiredReader = new StreamReader(fileStream);
			fileStream = new FileStream(args[1], System.IO.FileMode.Open);
			StreamReader providedReader = new StreamReader(fileStream);

			Controller controller = new Controller();
			controller.Start(Controller.InterfaceModel.Quality, requiredReader, 
				providedReader);
		}
	}
}

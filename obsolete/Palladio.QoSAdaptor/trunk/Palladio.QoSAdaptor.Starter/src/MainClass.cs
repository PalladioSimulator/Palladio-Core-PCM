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
	
			string requiredFileName;
			string providedFileName;

			try
			{
				requiredFileName = args[0];
				providedFileName = args[1];
			}
			catch (Exception)
			{
				Console.WriteLine("The filenames of the QML specifications "+
					"of the required and the provided interfaces have to be "+
					"given as parameters.");
				return;
			}

			StreamReader requiredReader;
			StreamReader providedReader;

			try
			{
				requiredReader = new StreamReader(new FileStream
					(requiredFileName, System.IO.FileMode.Open));
			}
			catch (Exception)
			{
				Console.WriteLine(requiredFileName+" could not be opened.");
				return;
			}
			try
			{
				providedReader = new StreamReader(new FileStream
					(providedFileName, System.IO.FileMode.Open));
			}
			catch (Exception)
			{
				Console.WriteLine(requiredFileName+" could not be opened.");
				return;
			}

			try
			{
				requiredSpecification = comparator.CreateQMLSpecification(
					requiredReader);
			}
			catch (Exception e)
			{
				Console.WriteLine("The internal representation of the "+
					"required QML specification could not be created.\n\n"+
					e.Message);
				return;
			}

			try
			{
				providedSpecification = comparator.CreateQMLSpecification(
					providedReader);
			}
			catch (Exception e)
			{
				Console.WriteLine("The internal representation of the "+
					"required QML specification could not be created.\n\n"+
					e.Message);
				return;
			}
			
			requiredReader.Close();
			providedReader.Close();

			IController controller = new Controller();
			controller.Start(InterfaceModel.QUALITY, 
				requiredSpecification, providedSpecification);
		}
	}
}

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
using log4net.Config;

namespace Palladio.QoSAdaptor.Measurement
{
	/// <summary>
	/// Starts a measurement scenario.
	/// TODO: Let all scenarios implement the same interface.
	/// </summary>
	public class MainClass
	{
		public static void Main (string[] args)
		{
			// Configure log4net for the measurement component. 
			// The configuration can be found in 
			// Palladio.QoSAdaptor.Measurement.config
			XmlConfigurator.Configure();
			if (args[0] == null)
			{
				Console.WriteLine("Please choose a scenario.");
				Console.WriteLine("Possible values: single concurrent");
			}
			else if (args[0].Equals("single"))
			{
				SingleClientScenario scenario = new SingleClientScenario();
				scenario.Start();
			}
			else if (args[0].Equals("concurrent"))
			{
				ConcurrentClientScenario scenario = new ConcurrentClientScenario();
				scenario.Start();
			}
			else
			{
				Console.WriteLine(args[0]+" is no regular scenario.");
				Console.WriteLine("Possible values: single concurrent");
			}
			
		}
	}
}

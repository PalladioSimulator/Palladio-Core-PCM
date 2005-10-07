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
using System.Threading;

namespace Palladio.QoSAdaptor.TestService
{
	/// <summary>
	/// This class represents a test service for a data cache. It provides a 
	/// getter and a setter method to access the data. The data are integer 
	/// values provided by a randomizer which is always initiated with the same 
	/// seed, so that the sequence of values is always the same in order to get
	/// comparable results.
	/// </summary>
	public class Service 
	{
		#region data
		private Random randomizer;
		private int[] values;
		#endregion

		#region constructor
		/// <summary>
		/// Constructor. Calls a method to initialize the data of the service.
		/// </summary>
		public Service()
		{
			values = new int[100];
			randomizer = new Random(0);
			CreateValues();

		}
		#endregion 

		#region private methods
		/// <summary>
		/// This method creates new random values as service data. 
		/// </summary>
		private void CreateValues()
		{
			int counter = 0;
			while (counter < 100)
			{
				values[counter] = randomizer.Next();
				counter++;
			}
		}
		#endregion

		#region public methods
		/// <summary>
		/// Returns the random integer value for the given index.
		/// </summary>
		/// <param name="index">The index of the wanted value. Has to be 
		/// between 0 and 99.</param>
		/// <returns>The random integer value for the given index.</returns>
		public int Get(int index)
		{
			// Modelling different percentiles of time consumption as indicated
			// in SEA_CacheAdaptor.cst
			Random timeConsumtionRandomizer = new Random();
			int probability = timeConsumtionRandomizer.Next(0,100);
			if (probability < 40)
				Thread.Sleep((int)(probability * 1.25));
			else if (probability < 60)
				Thread.Sleep((int)(probability * 1.333));	
			else 
				Thread.Sleep(probability);	
			
			return values[index];
		}

		/// <summary>
		/// Set a new value at the given index.
		/// </summary>
		/// <param name="index">The index of the new value. Has to be between
		/// 0 and 99.</param>
		/// <param name="value">The new value.</param>
		public void Set(int index, int value)
		{
			Thread.Sleep(100);
			values[index] = value;
		}
		#endregion
	}
}

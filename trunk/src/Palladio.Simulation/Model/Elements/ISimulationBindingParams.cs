using System;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This interface defines a class as parameter structure describing simulationbindings.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	public interface ISimulationBindingParams
	{		
		/// <summary>
		/// returns the loggingtype of the state
		/// </summary>
		LoggingType_t LoggingType
		{
			get;
		}
	}
}
//EOF
using System;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure.Elements
{
	/// <summary>
	/// This interface defines a class as parameter structure describing simulationbindings.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/06/26 15:39:44  joemal
	/// - initial class creation
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
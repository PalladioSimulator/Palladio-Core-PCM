using System;

namespace Palladio.Simulation.Model.Elements
{
	/// <summary>
	/// This interface extends <code>Palladio.ComponentModel.IBinding</code> for usage in the simulation environment.
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
	public interface ISimulationBinding : Palladio.ComponentModel.IBinding, ITimeConsumer
	{
	}
}
//EOF

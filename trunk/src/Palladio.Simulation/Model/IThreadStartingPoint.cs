using System;

namespace Palladio.Simulation.Model
{
	/// <summary>
	/// This interface defines a datastructure which describes the point, where simulationthreads can be started.
	/// This point is defined by a component, an interface of this component and a signature in this interface. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/07/28 15:34:46  sbecker
	/// Review comments added
	///
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
	///
	/// 
	/// </pre>
	/// </remarks>
	/// Raus!!!
	public interface IThreadStartingPoint
	{
		/// <summary>
		/// the id of the Component, in which the thread has to start.
		/// </summary>
		Palladio.Identifier.IIdentifier ComponentID
		{
			get;
		}
        
		/// <summary>
		/// the id of the interface, where the thread has to start.
		/// </summary>
		Palladio.Identifier.IIdentifier InterfaceID
		{
			get;
		}

		/// <summary>
		/// the id of the signature, where the thread has to be started.
		/// </summary>
		Palladio.Identifier.IIdentifier SignatureID
		{
			get;
		}
	}
}
//EOF

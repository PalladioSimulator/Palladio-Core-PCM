using System;

namespace ComponentNetworkSimulation.Structure
{
	/// <summary>
	/// This interface defines a datastructure which describes the point, where simulationthreads can be started.
	/// This point is defined by a component, an interface of this component and a signature in this interface. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.2  2004/06/19 13:48:07  joemal
	/// - now the startingpoint contains the ids of a component, an interface and a signature
	///
	/// Revision 1.1  2004/05/26 16:35:25  joemal
	/// initial creation
	///
	/// 
	/// </pre>
	/// </remarks>
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

using System;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace ComponentNetworkSimulation.Structure
{
	/// <summary>
	/// This interface defines the model of the component architecture. It contains a root component which can be
	/// a basic or a composite component. 
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	/// 
	/// $Log$
	/// Revision 1.1  2004/06/19 16:03:13  joemal
	/// initial class creation
	///
	/// 
	/// </pre>	
	/// </remarks>
	public interface IComponentArchitecture
	{
		/// <summary>
		/// the root component of the architecture
		/// </summary>
		IComponent ArchitectureRootComponent 
		{
			get;
		}

		/// <summary>
		/// called by the simulationenvironment, to reset the architecture. The method can be used to reset dynamic parts of the 
		/// architecture.
		/// </summary>
		void reset();

		/// <summary>
		/// call to create a visitors used for simulationthreads to enter at the point in the architecture
		/// described with given startingpoint.
		/// </summary>
		/// <param name="startingPoint">the point, from where the visitor has to start.</param>
		/// <returns>an instance of <code>IComponentVisitor</code></returns>
		/// <exception cref="Palladio.ComponentModel.ComponentNotFoundException">
		/// thrown, if the component with given id can't be found in architecture
		/// </exception>
		/// <exception cref="Palladio.ComponentModel.RoleIDNotFoundException">
		/// thrown, if the interface with given id can't be found in the component
		/// </exception>
		///	<exception cref="Palladio.ComponentModel.SignatureNotFoundException">
		/// thrown, if the signature with given id can't be found in interface
		/// </exception>
		Visitor.IComponentVisitor CreateVisitor(IThreadStartingPoint startingPoint);

	}
}
//EOF

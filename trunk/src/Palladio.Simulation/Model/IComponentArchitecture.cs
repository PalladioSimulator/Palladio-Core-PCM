using System;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace Palladio.Simulation.Model
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
	/// Revision 1.2  2004/07/29 15:13:47  joemal
	/// - changes from the review
	///
	/// Revision 1.1  2004/07/20 11:46:43  joemal
	/// new cvs module for first release
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
		/// return the builder interface of the root component. If still no component is created, null is returned.
		/// </summary>
		Builder.IComponentBuilder RootComponentBuilder
		{
			get;
		}

		/// <summary>
		/// return true, if the root component is a composite component.
		/// </summary>
		bool IsRootComponentComposite
		{
			get;
		}

		/// <summary>
		/// return true, if the root component is a basic component.
		/// </summary>
		bool IsRootComponentBasic
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
		/// <returns>an instance of <c>IComponentVisitor</c></returns>
		/// <exception cref="Palladio.ComponentModel.Exceptions.ComponentNotFoundException">
		/// thrown, if the component with given id can't be found in architecture
		/// </exception>
		/// <exception cref="Palladio.ComponentModel.Exceptions.RoleIDNotFoundException">
		/// thrown, if the interface with given id can't be found in the component
		/// </exception>
		///	<exception cref="Palladio.ComponentModel.Exceptions.SignatureNotFoundException">
		/// thrown, if the signature with given id can't be found in interface
		/// </exception>
		Visitor.IComponentVisitor CreateVisitor(ThreadStartingPoint startingPoint);

		/// <summary>
		/// call to create an empty basiccomponent and set it as root component. 
		/// The builderinterface for this component is returned to fill this component.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder</returns>
        Builder.IBasicComponentBuilder CreateBasicRootComponent(IIdentifier id, Builder.IBasicComponentObserver observer);

		/// <summary>
		/// call to create an empty compositecomponent and set it as root component. 
		/// The builderinterface for this component is returned to fill this component.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder</returns>
		Builder.ICompositeComponentBuilder CreateCompositeRootComponent(IIdentifier id, Builder.ICompositeComponentObserver observer);
	}
}
//EOF

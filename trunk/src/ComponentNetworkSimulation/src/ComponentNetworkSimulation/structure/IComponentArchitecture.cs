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
	/// Revision 1.4  2004/06/28 10:51:47  joemal
	/// - add observer to the builders
	///
	/// Revision 1.3  2004/06/26 16:36:11  joemal
	/// - remove todo tags
	///
	/// Revision 1.2  2004/06/22 12:09:37  joemal
	/// inital class creation
	///
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

		/// <summary>
		/// call to create an empty basiccomponent and set it as root component. 
		/// The builderinterface for this component is returned to fill this component.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder</returns>
        Builder.IBasicComponentBuilder CreateBasicRootComponent(String id, Builder.IBasicComponentObserver observer);

		/// <summary>
		/// call to create an empty compositecomponent and set it as root component. 
		/// The builderinterface for this component is returned to fill this component.
		/// </summary>
		/// <param name="id">the id of the component</param>
		/// <param name="observer">
		/// The observer for this component. If no observer is needed, this parameter may be null.
		/// </param>
		/// <returns>the builder</returns>
		Builder.ICompositeComponentBuilder CreateCompositeComponent(String id, Builder.ICompositeComponentObserver observer);
	}
}
//EOF

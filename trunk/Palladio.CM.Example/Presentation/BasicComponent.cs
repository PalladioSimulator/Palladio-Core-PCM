using System;
using Palladio.ComponentModel;
using Palladio.ComponentModel.ModelEntities;

namespace Palladio.CM.Example.Presentation
{
	/// <summary>
	/// This is the class for all visual representations of the componentmodels basiccomponents in the example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/06/05 10:41:04  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.1  2005/04/08 10:54:33  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class BasicComponent : Component
	{
		/// <summary>
		/// called to create a visual representation of a basic component
		/// </summary>
		/// <param name="comp">the component</param>
		/// <param name="modelEnvironment">the model</param>
		public BasicComponent(IComponent comp, ComponentModelEnvironment modelEnvironment) : base(comp, modelEnvironment)
		{
		}
	}
}

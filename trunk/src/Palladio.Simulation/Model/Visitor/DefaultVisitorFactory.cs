using System;
using Palladio.ComponentModel;
using Palladio.Identifier;

namespace Palladio.Simulation.Model.Visitor
{
	/// <summary>
	/// This class is the default visitorfactory.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// $Log$
	/// Revision 1.1  2004/07/20 11:46:42  joemal
	/// new cvs module for first release
	///
	///
	/// 
	/// </pre>
	/// </remarks>
	internal class DefaultVisitorFactory : IVisitorFactory
	{
		/// <summary>
		/// called to create a visitor for a composite component. This method is used, if the starting point is placed in
		/// an inner component of this composite component. The inner component is visited by the given visitor.
		/// </summary>
		/// <param name="component">the composite component</param>
		/// <param name="innerComponentVisitor">the visitor of the inner component</param>
		/// <returns>the visitor</returns>
		public IComponentVisitor CreateVisitor(ICompositeComponent component, IComponentVisitor innerComponentVisitor)
		{			
			return new DefaultCompositeComponentVisitor(component,innerComponentVisitor,this);
		}

		/// <summary>
		/// This method is used to create a visitor for a component, where the starting point is placed in
		/// this component. The starting point is defined by an interface id and a signature id.
		/// </summary>
		/// <param name="component">the component</param>
		/// <param name="interfaceID">the id of the interface in which the visitor has to start</param>
		/// <param name="signatureID">the id of the signature in the interface</param>
		/// <returns>the visitor</returns>
		public IComponentVisitor CreateVisitor(IComponent component, IIdentifier interfaceID, IIdentifier signatureID)
		{
			if (component is IBasicComponent)
				return new DefaultBasicComponentVisitor((IBasicComponent)component,interfaceID,signatureID);
			else
				return new DefaultCompositeComponentVisitor((ICompositeComponent)component,interfaceID,signatureID,this);
		}

		/// <summary>
		/// This method is used to create a visitor for a component, where the starting point is placed in
		/// this component. The starting point is defined by an external signature
		/// </summary>
		/// <param name="component">the composite component</param>
		/// <param name="extSig">the external signature</param>
		/// <returns>the visitor</returns>
		public IComponentVisitor CreateVisitor(IComponent component, IExternalSignature extSig)
		{
			if (component is IBasicComponent)
				return new DefaultBasicComponentVisitor((IBasicComponent)component,extSig);
			else
				return new DefaultCompositeComponentVisitor((ICompositeComponent)component,extSig,this);
		}
	}
}
//EOF
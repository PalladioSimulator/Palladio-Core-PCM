using System;
using System.Collections;
using Palladio.Utils.Collections;

namespace Palladio.ComponentModel.Components 
{
	/// <summary>
	/// A CompositeComponent consists of a set of internal components which 
	/// are wired using ComponentBindings and mapped to the outside world 
	/// using ComponentMappings.
	/// </summary>
	internal class CompositeComponent : ICompositeComponent 
	{
		/// <summary>
		/// Interfaces provided by the component to its environment.
		/// </summary>
		ISignatureList[] ProvidesInterfaces { get; }

		/// <summary>
		/// Interfaces required by the component from its environment.
		/// </summary>
		ISignatureList[] RequiresInterfaces { get; }

		/// <summary>
		/// List of IComponent objects assembled by the CompositComponent.
		/// </summary>
		IComponent[] Components 
		{ 
			get;
		}

		/// <summary>
		/// List of CompBinding objects, which represent 
		/// the wiring of the internal components.
		/// </summary>
		IBinding[] Bindings
		{ 
			get;
		}

		/// <summary>
		/// List of ICompProvMappings mapping the ProvidesInterfaces
		/// of the internal components onto the ProvidesInterfaces of the
		/// CompositeComponent.
		/// </summary>
		IProvidesMapping[] ProvidesMappings
		{ 
			get;
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterfaces of the
		/// CompositeComponent.
		/// </summary>
		IRequiresMapping[] RequiresMappings
		{ 
			get;
		}
		
		/// <summary>
		/// Get the ProvidesInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The ProvidesInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		ISignatureList GetProvidesInterface(string aRoleID);
		
		/// <summary>
		/// Get the RequiresInterface with the role aRoleID.
		/// </summary>
		/// <param name="aRoleID">A provided role of the component.</param>
		/// <returns>The RequiresInterface with the role aRoleID. 
		/// If no interface with aRoleID can be found, a RoleNotFoundException is thrown.</returns>
		ISignatureList GetRequiresInterface(string aRoleID);

		void AddComponents(params IComponent[] aCompArray);

		void DeleteComponents(params IComponent[] aCompArray);
		

		void AddProvidesInterface(ISignatureList aProvInterface, IProvidesMapping aProvMapping);

		void AddRequiresInterface(ISignatureList aReqInterface, IRequiresMapping aReqMapping);

		void DeleteProvidesInterface(ISignatureList aProvInterface, IProvidesMapping aProvMapping);

		void DeleteRequiresInterface(ISignatureList aReqInterface, IRequiresMapping aReqMapping);


		IProvidesMapping GetProvidesMappingByOuter(string aProvRoleID);

		IBinding GetBindingByRequires(AttachedInterface aReqInterface);

		IRequiresMapping GetRequiresMappingByInner(AttachedInterface aReqInterface);

		IRequiresMapping GetRequiresMappingByOuter(string aReqRoleID);

		IBinding GetBindingByProvides(AttachedInterface aProvInterface);

		IProvidesMapping GetProvidesMappingByInner(AttachedInterface aProvInterface);

		private 
	}
}

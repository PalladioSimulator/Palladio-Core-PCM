using System;
using System.Collections;
using ReflectionBasedVisitor;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// A ICompositeComponent consists of a set of internal components which 
	/// are wired using ComponentBindings and mapped to the outside world 
	/// using ComponentMappings.
	/// </summary>
	public interface ICompositeComponent : IComponent, IVisitable
	{
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
		IMapping[] ProvidesMappings
		{ 
			get;
		}

		/// <summary>
		/// List of IReqCompMappings mapping the RequireInterfaces
		/// of the internal components onto the RequiresInterface of the
		/// CompositeComponent.
		/// </summary>
		IMapping[] RequiresMappings
		{ 
			get;
		}
		
		void AddComponents(params IComponent[] aCompArray);

		void DeleteComponents(params IComponent[] aCompArray);
		

		void AddProvidesInterfaces(params ISignatureList[] aProvInterfaceArray);

		void AddProvidesMappings(params IMapping[] aProvMappingArray );

		void DeleteProvidesInterfaces(params ISignatureList[] aProvInterfaceArray);
		
		void DeleteProvidesMappings(params IMapping[] aProvMappingArray);

		
		void AddRequiresInterfaces(params ISignatureList[] aReqInterfaceArray);

		void AddRequiresMappings(params IMapping[] aReqMappingArray);

		void DeleteRequiresInterfaces(params ISignatureList[] aReqInterfaceArray);

		void DeleteRequiresMappings(params IMapping[] aReqMappingArray);


		void AddBindings(params IBinding[] aBindingArray);

		void DeleteBindings(params IBinding[] aBindingArray);

		IBinding[] GetOutgoingBindings(IComponent aComponent);
		IBinding[] GetIncomingBindings(IComponent aComponent);
		
		IMapping[] GetIncomingMappings(IComponent aComponent);
		IMapping[] GetOutgoingMappings(IComponent aComponent);



		IMapping GetProvidesMappingByOuter(string aProvRoleID);
		IMapping[] GetProvidesMappingsByInner(AttachedInterface aProvInterface);
		IMapping[] GetProvidesMappingsByInner(IComponent aProvComponent, string aProvRole);

		IBinding GetBindingByRequires(AttachedInterface aReqInterface);
		IBinding GetBindingByRequires(IComponent aReqComponent, string aReqRole);
		IBinding[] GetBindingsByProvides(AttachedInterface aProvInterface);
		IBinding[] GetBindingsByProvides(IComponent aProvComponent, string aProvRole);

		IMapping GetRequiresMappingByInner(AttachedInterface aReqInterface);
		IMapping GetRequiresMappingByInner(IComponent aReqComponent, string aReqRole);
		IMapping[] GetRequiresMappingsByOuter(string aReqRoleID);


		
		bool HasIncomingConnections(IComponent aComponent);

		bool HasOutgoingConnections(IComponent aComponent);

		bool ContainsComponent(IComponent aComponent);

		
	}
}

#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;

using Palladio.ComponentModel;
using Palladio.Editor.Common;
using Palladio.Editor.Common.EntityProxies;

namespace Palladio.Editor.Core.Agents.Root.Abstraction
{
	/// <summary>
	/// The ProxyFactory creates proxy objects for concrete instances of the component model. 
	/// All Proxies are derived from <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy"/>.
	/// </summary>
	internal class ProxyFactory
	{
		/// <summary>
		/// Creates a Proxy object for an <see cref="Palladio.ComponentModel.IBasicComponent"/>.
		/// </summary>
		/// <param name="comp">An instance implementing <see cref="Palladio.ComponentModel.IBasicComponent"/></param>
		/// <param name="compCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this proxy or its aggregated components.</param>
		/// <param name="roleCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// roles within or attached to this proxy.</param>
		/// <param name="ifaceCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// interfaces within or attached to this proxy.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// signatures belonging to interfaces within or attached to this proxy.</param>
		/// <returns>A Proxy object for the specified <see cref="Palladio.ComponentModel.IBasicComponent"/>.</returns>
		public static BasicComponentProxy CreateBasicComponentProxy(
			IBasicComponent comp, 
			CommandHandler compCmdHandler, 
			CommandHandler roleCmdHandler, 
			CommandHandler ifaceCmdHandler, 
			CommandHandler sigCmdHandler)
		{
			BasicComponentProxy proxy = new BasicComponentProxy(comp, compCmdHandler, new RoleProxy[comp.ProvidedRoles.Length], new RoleProxy[comp.ProvidedRoles.Length]);

			// create role proxies for the provides interfaces
			RoleProxy[] providedRoles = new RoleProxy[comp.ProvidedRoles.Length];
			for(int i = 0; i < comp.ProvidedRoles.Length; i++)
			{
				Palladio.ComponentModel.IRole role = comp.GetRole(comp.ProvidedRoles[i]);
				RoleProxy entity = CreateRoleProxy(role, proxy, roleCmdHandler, ifaceCmdHandler, sigCmdHandler);
				providedRoles[i] = entity;
			}

			// create role proxies for the requires interfaces
			RoleProxy[] requiredRoles = new RoleProxy[comp.RequiredRoles.Length];
			for(int i = 0; i < comp.RequiredRoles.Length; i++)
			{
				Palladio.ComponentModel.IRole role = comp.GetRole(comp.RequiredRoles[i]);
				RoleProxy entity = CreateRoleProxy(role, proxy, roleCmdHandler, ifaceCmdHandler, sigCmdHandler);
				requiredRoles[i] = entity;
			}

			proxy.ProvidedRoles.Clear();
			proxy.RequiredRoles.Clear();
			proxy.ProvidedRoles.AddRange(providedRoles);
			proxy.RequiredRoles.AddRange(requiredRoles);

			return proxy;
		}

		/// <summary>
		/// Creates a Proxy object for an <see cref="Palladio.ComponentModel.ICompositeComponent"/>.
		/// </summary>
		/// <param name="comp">An instance implementing <see cref="Palladio.ComponentModel.ICompositeComponent"/></param>
		/// <param name="compCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this proxy or its aggregated components.</param>
		/// <param name="roleCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// roles within or attached to this proxy.</param>
		/// <param name="ifaceCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// interfaces within or attached to this proxy.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// signatures belonging to interfaces within or attached to this proxy.</param>
		/// <returns>A Proxy object for the specified <see cref="Palladio.ComponentModel.ICompositeComponent"/>.</returns>
		public static CompositeComponentProxy CreateCompositeComponentProxy(
			ICompositeComponent comp, 
			CommandHandler compCmdHandler, 
			CommandHandler roleCmdHandler, 
			CommandHandler ifaceCmdHandler, 
			CommandHandler sigCmdHandler)
		{
			ComponentProxy[] subcomps = new ComponentProxy[comp.Components.Length];
			for(int i = 0; i < comp.Components.Length; i++)
			{
				ComponentProxy entity = null;
				Palladio.ComponentModel.IComponent subcomp = comp.Components[i];
				if (subcomp is IBasicComponent)
					entity = CreateBasicComponentProxy(subcomp as IBasicComponent, compCmdHandler, roleCmdHandler, ifaceCmdHandler, sigCmdHandler );
				if (subcomp is ICompositeComponent)
					entity = CreateCompositeComponentProxy(subcomp as ICompositeComponent, compCmdHandler, roleCmdHandler, ifaceCmdHandler, sigCmdHandler);
				subcomps[i] = entity;
			}
			
			CompositeComponentProxy proxy = new CompositeComponentProxy(comp, compCmdHandler, new RoleProxy[comp.ProvidedRoles.Length], new RoleProxy[comp.RequiredRoles.Length], subcomps);

			// create role proxies for the provides interfaces
			RoleProxy[] providedRoles = new RoleProxy[comp.ProvidedRoles.Length];
			for(int i = 0; i < comp.ProvidedRoles.Length; i++)
			{
				Palladio.ComponentModel.IRole role = comp.GetRole(comp.ProvidedRoles[i]);
				RoleProxy entity = CreateRoleProxy(role, proxy, roleCmdHandler, ifaceCmdHandler, sigCmdHandler);
				providedRoles[i] = entity;
			}

			// create role proxies for the requires interfaces
			RoleProxy[] requiredRoles = new RoleProxy[comp.RequiredRoles.Length];
			for(int i = 0; i < comp.RequiredRoles.Length; i++)
			{
				Palladio.ComponentModel.IRole role = comp.GetRole(comp.RequiredRoles[i]);
				RoleProxy entity = CreateRoleProxy(role, proxy, roleCmdHandler, ifaceCmdHandler, sigCmdHandler);
				requiredRoles[i] = entity;
			}

			proxy.ProvidedRoles.Clear();
			proxy.RequiredRoles.Clear();
			proxy.ProvidedRoles.AddRange(providedRoles);
			proxy.RequiredRoles.AddRange(requiredRoles);

			return proxy;
		}

		/// <summary>
		/// Creates a Proxy object for an <see cref="Palladio.ComponentModel.IRole"/>.
		/// </summary>
		/// <param name="role">An instance implementing <see cref="Palladio.ComponentModel.IRole"/></param>
		/// <param name="comp">The Proxy object for the component to which this role is being attached.</param>
		/// <param name="roleCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this role.</param>
		/// <param name="ifaceCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// the interface proxy attached to this role.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// signatures belonging to the interface attached to this role.</param>
		/// <returns>A Proxy object for the specified <see cref="Palladio.ComponentModel.IRole"/>.</returns>
		public static RoleProxy CreateRoleProxy(IRole role, ComponentProxy comp, CommandHandler roleCmdHandler, CommandHandler ifaceCmdHandler, CommandHandler sigCmdHandler)
		{
			InterfaceProxy interfaceProxy = CreateInterfaceProxy(role.Interface, ifaceCmdHandler, sigCmdHandler);
			RoleProxy rp = new RoleProxy(role, comp, interfaceProxy, roleCmdHandler);
			return rp;
		}

		/// <summary>
		/// Creates a Proxy object for an <see cref="Palladio.ComponentModel.IInterfaceModel"/>.
		/// </summary>
		/// <param name="iface">An instance implementing <see cref="Palladio.ComponentModel.IInterfaceModel"/>.</param>
		/// <param name="ifaceCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this interface proxy.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// signatures belonging to this interface proxy.</param>
		/// <returns>A Proxy object for the specified <see cref="Palladio.ComponentModel.IInterfaceModel"/>.</returns>
		public static InterfaceProxy CreateInterfaceProxy(IInterfaceModel iface, CommandHandler ifaceCmdHandler, CommandHandler sigCmdHandler)
		{
			SignatureProxy[] signatures = new SignatureProxy[iface.SignatureList.Count];

			for(int i = 0; i < iface.SignatureList.Count; i++)
			{
				Palladio.ComponentModel.ISignature sig = iface.SignatureList[i];
				SignatureProxy sigProxy = CreateSignatureProxy(sig, null, sigCmdHandler);
				signatures[i] = sigProxy;
			}

			InterfaceProxy ip = new InterfaceProxy(iface, ifaceCmdHandler, signatures);

			foreach(SignatureProxy sig in ip.Signatures)
				sig.Interface = ip;
			
			return ip;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sig">An instance implementing <see cref="Palladio.ComponentModel.ISignature"/>.</param>
		/// <param name="iface">The interface proxy to which this signature belongs.</param>
		/// <param name="sigCmdHandler">The handler that is called when the
		/// <see cref="Palladio.Editor.Common.EntityProxies.EntityProxy.CommandIssued"/> event is fired by 
		/// this proxy.</param>
		/// <returns></returns>
		public static SignatureProxy CreateSignatureProxy(ISignature sig, InterfaceProxy iface, CommandHandler sigCmdHandler)
		{
			ParameterProxy[] parameters = new ParameterProxy[sig.Parameters.Length];

			for(int i = 0; i < sig.Parameters.Length; i++)
			{
				Palladio.ComponentModel.IParameter param = sig.Parameters[i];
				ParameterProxy paramProxy = CreateParameterProxy(param);
				parameters[i] = paramProxy;
			}

			SignatureProxy sp = new SignatureProxy(sig, iface, sigCmdHandler, parameters);
			return sp;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="param"></param>
		/// <returns></returns>
		public static ParameterProxy CreateParameterProxy(IParameter param)
		{
			return new ParameterProxy(param);
		}
	}
}

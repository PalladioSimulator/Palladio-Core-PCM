using System;
using System.Collections;
using System.Reflection;
using Palladio.ComponentModel;
using Palladio.FiniteStateMachines;

namespace Palladio.Reliability.WebserverComponentModel
{
	/// <summary>
	/// </summary>
	public class WebserverModelHelper
	{
		/// <summary>
		/// Returns the model of the interface with the 
		/// corresponding name. If there is no such interface
		/// an exception is thrown.
		/// </summary>
		/// <param name="name"></param>
		/// <returns></returns>
		public static IInterfaceModel GetInterfaceModel(string name)
		{
			string methodName = "Create" + name;
			MethodInfo method = typeof (WebserverInterfaceFactory).GetMethod(methodName);
			if (method == null)
				throw new ApplicationException("No definition found for interface '" + name + "'!");
			method.Invoke(null, new object[0]);
			return (IInterfaceModel) interfaceHash[name];
		}


		/// <summary>
		/// Creates the signature for the get method of a property.
		/// </summary>
		/// <param name="type"></param>
		/// <param name="name"></param>
		/// <returns></returns>
		public static ISignature CreateGetter(Type type, string name)
		{
			return ComponentFactory.CreateSignature(type, "get_" + name, new IParameter[0]);
		}

		/// <summary>
		/// Creates the signature for the set method of property.
		/// </summary>
		/// <param name="type"></param>
		/// <param name="name"></param>
		/// <returns></returns>
		public static ISignature CreateSetter(Type type, string name)
		{
			IParameter par = ComponentFactory.CreateParameter(type, "value");
			return ComponentFactory.CreateSignature(typeof (void), "set_" + name, par);
		}


		/// <summary>
		/// Adds a new transition to the editable fsm.
		/// </summary>
		/// <param name="id"></param>
		/// <param name="fsm"></param>
		/// <param name="sourceID"></param>
		/// <param name="destID"></param>
		/// <param name="method">Must be an IMatchable. For convinience the type cast is performed in this method.</param>
		public static void AddTransition(long id, ref IEditableFiniteStateMachine fsm, long sourceID, long destID, object method)
		{
			IMatchable matchable = (IMatchable) method;
			IState source = CreateStates(sourceID)[0];
			IState dest = CreateStates(destID)[0];
			IInput input = FSMFactory.CreateDefaultInput(matchable);
			ITransition transition = FSMFactory.CreateDefaultTransition(source, input, dest);
			DatabaseIDAttribute.SetAttribute(transition, id);
			fsm.AddInputSymbols(transition.InputSymbol);
			fsm.AddTransitions(transition);
		}

		/// <summary>
		/// Returns the state instance with the given id.
		/// </summary>
		/// <param name="id"></param>
		/// <returns></returns>
		public static IState GetState(long id)
		{
			return (IState) stateHash[id];
		}

		/// <summary>
		/// Creates a set of states using the given ids. If a
		/// state with the id already exists the existing instance
		/// is returned.
		/// </summary>
		/// <param name="ids"></param>
		/// <returns></returns>
		public static IState[] CreateStates(params long[] ids)
		{
			IState[] states = new IState[ids.Length];
			for (int i = 0; i < ids.Length; i++)
			{
				long cID = ids[i];
				if (!stateHash.Contains(cID))
				{
					IState state = FSMFactory.CreateDefaultState(cID.ToString());
					DatabaseIDAttribute.SetAttribute(state, cID);
					stateHash[cID] = state;
				}
				states[i] = (IState) stateHash[cID];
			}
			return states;
		}

		/// <summary>
		/// Creates the service described by the iModel and sigName.
		/// </summary>
		/// <param name="iModel"></param>
		/// <param name="sigName"></param>
		/// <returns></returns>
		public static IService CreateService(IInterfaceModel iModel, string sigName)
		{
			return ComponentFactory.CreateService(iModel, FindSignature(iModel.SignatureList, sigName).ID);
		}

		/// <summary>
		/// Finds the signature with the corresponding name. If there
		/// are several signatures with the same name, only the first one is returned.
		/// </summary>
		/// <param name="sigList"></param>
		/// <param name="name"></param>
		/// <returns></returns>
		public static ISignature FindSignature(ISignatureList sigList, string name)
		{
			foreach (ISignature sig in sigList)
			{
				if (sig.Name == name)
				{
					return sig;
				}
			}
			throw new ApplicationException("Signature '" + name + "' not found!");
		}

		/// <summary>
		/// Returns the service specified by the interfaceName and methodName.
		/// Null, if no such service is found.
		/// </summary>
		/// <param name="serviceList"></param>
		/// <param name="interfaceName"></param>
		/// <param name="methodName"></param>
		/// <returns></returns>
		public static IService FindService(IServiceList serviceList, string interfaceName, string methodName)
		{
			foreach (IService service in serviceList.GetSignatures())
			{
				if (service.Interface.Name.Equals(interfaceName) &&
					(service.Signature.Name.Equals(methodName)))
					return service;
			}
			return null;
		}

		/// <summary>
		/// Returns the service effect specification for the 
		/// signature methodName of the interface with the name
		/// interfaceName. Null, if no such service effect specification
		/// could be found.
		/// </summary>
		/// <param name="comp"></param>
		/// <param name="interfaceName"></param>
		/// <param name="methodName"></param>
		/// <returns></returns>
		public static IServiceEffectSpecification FindServiceEffectSpecification(IBasicComponent comp, string interfaceName, string methodName)
		{
			IInterfaceModel iModel = WebserverInterfaceFactory.GetInterfaceModel(interfaceName);
			return FindServiceEffectSpecification(comp, iModel, methodName);
		}

		/// <summary>
		/// Returns the service effect specification for the 
		/// signature methodName of the interface with the name
		/// interfaceName. Null, if no such service effect specification
		/// could be found.
		/// </summary>
		public static IServiceEffectSpecification FindServiceEffectSpecification(IBasicComponent comp, IInterfaceModel iModel, string methodName)
		{
			IService service = CreateService(iModel, methodName);
			IServiceEffectSpecification seff = null;
			try
			{
				seff = comp.GetServiceEffectSpecification(service);
			}
			catch (Exception)
			{
			}
			return seff;
		}

		/// <summary>
		/// Returns the service effect specification for the 
		/// signature methodName of the interface with the name
		/// interfaceName. Null, if no such service effect specification
		/// could be found.
		/// </summary>
		public static IServiceEffectSpecification FindServiceEffectSpecification(IBasicComponent comp, IInterfaceModel iModel, ISignature signature)
		{
			IService service = ComponentFactory.CreateService(iModel, signature.ID);
			IServiceEffectSpecification seff = null;
			try
			{
				seff = comp.GetServiceEffectSpecification(service);
			}
			catch (Exception)
			{
			}
			return seff;
		}

		/// <summary>
		/// Returns a more useful string representation of 
		/// a transition than the one of the component model does.
		/// </summary>
		/// <param name="transition"></param>
		/// <returns></returns>
		public static string TransitionToString(ITransition transition)
		{
			string result = transition.SourceState.ID;
			result += " - ";
			IService service = (IService) transition.InputSymbol.ID;
			result += service.Interface.Name;
			result += ".";
			result += service.Signature.Name;
			result += " - ";
			result += transition.DestinationState.ID;
			return result;
		}

		/// <summary>
		/// Hide the constructor.
		/// </summary>
		protected WebserverModelHelper()
		{
		}

		// hashtables used for the singleton pattern.
		protected static Hashtable stateHash = new Hashtable();

		protected static Hashtable interfaceHash = new Hashtable();

		protected static Hashtable componentHash = new Hashtable();
	}
}
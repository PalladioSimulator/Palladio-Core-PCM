using System;
using System.Collections;
using Palladio.FiniteStateMachines;
using Utils.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Some useful helper tools.
	/// </summary>
	public class Helper
	{
		/// <summary>
		/// Creates a list of ISignature objects from anInputAlphabet of
		/// a finite state machine.
		/// </summary>
		/// <param name="anInputAlphabet">InputAlphabet of a FSM.</param>
		/// <returns></returns>
		public static IList SigListFromInputAlphabet(IList anInputAlphabet)
		{
			IList resultList = new Vector();
			foreach( Input i in anInputAlphabet)
			{
				ISignature sig = new MethodSignature((string)i.InputSymbol);
				resultList.Add(sig);
			}
			return resultList;
		}

		public static ProtocolIModel LoadProtIModel(string aFileName)
		{
			FSMFactory factory = new FSMFactory();
			IFiniteStateMachine fsm = factory.CreateFSMFromFile(aFileName);
			return new ProtocolIModel(fsm, Helper.SigListFromInputAlphabet(fsm.InputAlphabet));
		}

		public static Service CreateService(string aSigName, string aProtModelFileName)
		{
			ProtocolIModel iModel = LoadProtIModel(aProtModelFileName);
			ISignature sig = new MethodSignature(aSigName);
			return new Service(iModel, sig);
		}

		public static IList CreateServiceList(string aDirectory, params string[] list)
		{
			IList serviceList = new Vector();
			foreach( string str in list )
			{
				Service srv = CreateService(str,aDirectory+"/"+str+".xml");
				serviceList.Add(srv);
			}
			return serviceList;
		}

		public static ProvidesInterface CreateProvidesIface(string aDirectory, string aProvName, params string [] srvNameList)
		{
			ProtocolIModel pModel = LoadProtIModel(aDirectory+"/"+aProvName+".xml");
			IList srvList = CreateServiceList(aDirectory, srvNameList);
			return new ProvidesInterface(pModel, srvList, aProvName);
		}

		public static SignatureListIModel CreateSigListIModel(params string[] aList)
		{
			IList sigList = new Vector();
			foreach( string str in aList )
			{
				sigList.Add( new MethodSignature(str) );
			}
			return new SignatureListIModel(sigList);
		}

		public static ITransition CreateTransition(string aSource, string anInput, string aDestination)
		{
			bool sStart = false;
			bool sFinal = false;
			bool dStart = false;
			bool dFinal = false;
			if (aSource.StartsWith("S"))
				sStart = true;
			if (aSource.StartsWith("F"))
				sFinal = true;
			if (aDestination.StartsWith("S"))
				dStart = true;
			if (aDestination.StartsWith("F"))
				dFinal = true;
			return new Transition( new State(aSource,sStart,sFinal), new Input(anInput), new State(aDestination,dStart,dFinal) );
		}

		public static RequiresInterface CreateReqInterface(string aFsmFile, string aName )
		{
			ProtocolIModel protModel = LoadProtIModel(aFsmFile);
			return new RequiresInterface(protModel, aName);
		}

		public static IParameter CreateParameter(System.Type aType, string aName)
		{
			return  new Parameter(new ReflectedType(aType), aName);
		}

		public static MethodSignature CreateSignature(System.Type aType, string aName, params IParameter[] aParamList)
		{
			return new MethodSignature(new ReflectedType(aType), aName, aParamList );
		}
	}
}

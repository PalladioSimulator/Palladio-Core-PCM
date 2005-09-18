using System;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Query.TypeLevel;
using Palladio.FiniteStateMachines;
using Palladio.FSMWrapper;
using Palladio.Types;

namespace Palladio.CM.Example
{
	/// <summary>
	/// This class creates a componenmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.13  2005/09/18 15:36:05  joemal
	/// add fsm seffs and protocols
	///
	/// Revision 1.12  2005/08/25 16:45:38  joemal
	/// add stream location to serializer
	///
	/// Revision 1.11  2005/08/14 13:43:22  kelsaka
	/// - initial creation of FSM serialization
	///
	/// Revision 1.10  2005/07/29 16:29:30  joemal
	/// add protocols to example
	///
	/// Revision 1.9  2005/07/29 16:00:12  joemal
	/// add fsm wrapper project
	///
	/// Revision 1.8  2005/07/23 18:57:26  joemal
	/// new implementation of IType
	///
	/// Revision 1.7  2005/06/05 10:40:56  joemal
	/// - components now can be added to more than one container
	///
	/// Revision 1.6  2005/05/25 18:15:27  kelsaka
	/// - added new methods to BuilderManager
	/// - use of new methods in example
	///
	/// Revision 1.5  2005/05/24 16:51:26  joemal
	/// xxx
	///
	/// Revision 1.4  2005/05/08 17:24:02  joemal
	/// add xml serialization to example
	///
	/// Revision 1.3  2005/04/20 19:53:19  kelsaka
	/// - Example and CM-Environment are now using the IBuilderManger
	///
	/// Revision 1.2  2005/04/12 17:36:24  joemal
	/// implement the creation of a component model
	///
	/// Revision 1.1  2005/04/08 10:54:33  joemal
	/// initial class creation
	///
	///
	/// </pre>
	/// </remarks>
	public class StaticComponentModel
	{
		#region data

		//holds the model environment
		private ComponentModelEnvironment modelEnvironment;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new staticcomponentmodel
		/// </summary>
		/// <param name="modelEnvironment">the model environment</param>
		public StaticComponentModel(ComponentModelEnvironment modelEnvironment)
		{
			this.modelEnvironment = modelEnvironment;			
		}

		#endregion

		#region public methods

		/// <summary>
		/// called to create the model
		/// </summary>
		public void Create()
		{
			//- zwei interfaces werden erzeugt (rootBuilder.AddInterface("...");)
			//- AddInterface gibt den Builder zu den Interfaces zurück, BuildIFaceWriter füllt das Interface mit Inhalt
			//- BuildIFaceWriter gibt die ID des Interfaces zurück, wird noch benötigt
			IInterfaceIdentifier wrIfaceID = BuildIFaceIWriter(RootBuilder.CreateInterface("IWriter"));
			IInterfaceIdentifier wrbeIfaceID = BuildIFaceIWriterBackEnd(RootBuilder.CreateInterface("IWriterBackEnd"));

			//- Auf ähnliche art und weise die Komponenten basteln
			IComponentIdentifier wrCCID = BuildCC1(RootBuilder.AddNewCompositeComponent("WriteCC"), wrbeIfaceID,wrIfaceID);
			IComponentIdentifier wrbeBCID = BuildBC1(RootBuilder.AddNewBasicComponent("WriterBackendBC"),wrbeIfaceID);
			RootBuilder.AddAssemblyConnector("WR -> WR_BE",wrCCID,wrbeIfaceID,wrbeBCID,wrbeIfaceID);


			//Console.WriteLine("**** " + wrbeBCID);
			//modelEnvironment.BuilderManager.RootTypeLevelBuilder.AddExistingComponent(wrbeBCID);
			//modelEnvironment.BuilderManager.RootTypeLevelBuilder.AddNewBasicComponent(wrbeBCID, "NEU");
			
			//IComponentIdentifier wrCCID2 = BuildCC1(RootBuilder.AddNewCompositeComponent("WriteCC"), wrbeIfaceID,wrIfaceID);
			RootBuilder.AddNewCompositeComponent("WriteCC2").AddExistingComponent(wrbeBCID);
			
		}

		#endregion

		#region private methods

		/// <summary>
		/// returns the root builder 
		/// </summary>
		private IRootBuilder RootBuilder
		{
			get
			{
				return this.modelEnvironment.BuilderManager.RootTypeLevelBuilder;
			}
		}

		/// <summary>
		/// called to return the type level query interface
		/// </summary>
		private IQueryTypeLevel Query
		{
			get
			{
				return this.modelEnvironment.Query.QueryTypeLevel;
			}
		}
		
		//creates the composite component cc1
		private IComponentIdentifier BuildCC1(ICompositeComponentBuilder compositeComponentBuilder,
			IInterfaceIdentifier reqIFace, IInterfaceIdentifier provIFace)
		{
			IComponentIdentifier bc2ID = BuildBC2(compositeComponentBuilder.AddNewBasicComponent("WriterImplBC"),
				provIFace,reqIFace);	

			//Interfaces den der Komponente hinzufügen
			compositeComponentBuilder.AddExistingInterfaceAsProvides(provIFace);
			compositeComponentBuilder.AddExistingInterfaceAsRequires(reqIFace);


			//delegation connector ziehen
			compositeComponentBuilder.AddProvidesDelegationConnector("WRCC.Prov -> WRBC.Prov",provIFace,bc2ID,provIFace);
			compositeComponentBuilder.AddRequiresDelegationConnector("WRCC.Req -> WRBC.Req",bc2ID,reqIFace,reqIFace);
            			
            return compositeComponentBuilder.Component.ComponentID;
		}

		//creates the basic component bc1
		private IComponentIdentifier BuildBC2(IBasicComponentTypeLevelBuilder basicComponentTypeLevelBuilder,
			IInterfaceIdentifier provIfaceID,IInterfaceIdentifier reqIFaceID)
		{
			basicComponentTypeLevelBuilder.AddExistingInterfaceAsProvides(provIfaceID);
			basicComponentTypeLevelBuilder.AddExistingInterfaceAsRequires(reqIFaceID);
			ISignatureIdentifier sigId = this.Query.QueryInterface(provIfaceID).GetSignatures()[0];
			basicComponentTypeLevelBuilder.AddServiceEffectSpecification(CreateSeffBC2(sigId,reqIFaceID),provIfaceID,sigId);
			return basicComponentTypeLevelBuilder.Component.ComponentID;
		}

		//creates the basic component bc1
		private IComponentIdentifier BuildBC1(IBasicComponentTypeLevelBuilder basicComponentTypeLevelBuilder,
			IInterfaceIdentifier provIfaceID)
		{
			basicComponentTypeLevelBuilder.AddExistingInterfaceAsProvides(provIfaceID);
			ISignatureIdentifier sigId = this.Query.QueryInterface(provIfaceID).GetSignatures()[0];			
			basicComponentTypeLevelBuilder.AddServiceEffectSpecification(CreateSeffBC1(),provIfaceID,sigId);
			return basicComponentTypeLevelBuilder.Component.ComponentID;
		}

		//creates the interface IWriter
		private IInterfaceIdentifier BuildIFaceIWriter(IInterfaceTypeLevelBuilder levelBuilder)
		{
			ISignatureBuilder sigBuilder = levelBuilder.AddSignature("WriteSomething");
			sigBuilder.AppendParameter(TypesFactory.CreateStringType("System.string"),"filename",ParameterModifierEnum.REF);
			levelBuilder.AddProtocol(CreateSimpleProtocol(levelBuilder.InterfaceId,sigBuilder.SignatureId));
			return levelBuilder.Interface.InterfaceID;
		}

		//creates the interface IWriterBackend
		private IInterfaceIdentifier BuildIFaceIWriterBackEnd(IInterfaceTypeLevelBuilder levelBuilder)
		{
			ISignatureBuilder sigBuilder = levelBuilder.AddSignature("WriteToDisk");
			sigBuilder.AppendParameter(TypesFactory.CreateStringType("System.string"),"filename",ParameterModifierEnum.REF);
			levelBuilder.AddProtocol(CreateSimpleProtocol(levelBuilder.InterfaceId,sigBuilder.SignatureId));
			return levelBuilder.Interface.InterfaceID;
		}

		//called to create the seff of bc2
		//the id of the signature and the id of the requires interface are used to create an input symbol for
		//the FSMs transition between "StateA" and "StateB"
		private IServiceEffectSpecification CreateSeffBC2(ISignatureIdentifier extSigIds, IInterfaceIdentifier reqIfaceIds)
		{			
			IEditableFiniteStateMachine fsm = FSMFactory.GetEditableFSM(FSMFactory.CreateEmptyFSM());
			IState startState = FSMFactory.CreateDefaultState("StateA");
			IState finalState = FSMFactory.CreateDefaultState("StateB");
			IInput transitionInpKey = FSMWrapperFactory.CreateSignatureCall(reqIfaceIds,extSigIds);
			fsm.AddInputSymbols(transitionInpKey);
			fsm.AddStates(startState,finalState);
			fsm.StartState = startState;
			fsm.FinalStates = new IState[]{finalState};
			fsm.AddTransition(startState.ID,transitionInpKey.ID,finalState.ID);

			return FSMWrapperFactory.CreateFSMServiceEffectSpecification(fsm);
		}

		//called to create the seff of bc2
		private IServiceEffectSpecification CreateSeffBC1()
		{
			IFiniteStateMachine fsm = FSMFactory.CreateFSM(FSMFactory.CreateDefaultState("StateA"));
			return FSMWrapperFactory.CreateFSMServiceEffectSpecification(fsm);			
		}

		//called to create a simple fsm protocol. 
		private IProtocol CreateSimpleProtocol(IInterfaceIdentifier ifaceId, ISignatureIdentifier sigId)
		{
			IEditableFiniteStateMachine fsm = FSMFactory.GetEditableFSM(FSMFactory.CreateEmptyFSM());
			IState startState = FSMFactory.CreateDefaultState("StateA");
			fsm.AddStates(startState);
			fsm.StartState = startState;
			fsm.FinalStates = new IState[]{startState};

			IInput inpSym = FSMWrapperFactory.CreateSignatureCall(ifaceId,sigId);
			fsm.AddInputSymbols(inpSym);
			fsm.AddTransition(startState.ID,inpSym.ID,startState.ID);

			return FSMWrapperFactory.CreateFSMProtocol(fsm);
		}

		#endregion
	}
}

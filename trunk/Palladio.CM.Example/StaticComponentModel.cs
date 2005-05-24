using System;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;

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
		private IRootTypeLevelBuilder rootBuilder;

		#endregion

		#region constructor

		/// <summary>
		/// called to create a new staticcomponentmodel
		/// </summary>
		/// <param name="modelEnvironment">the model environment</param>
		public StaticComponentModel(ComponentModelEnvironment modelEnvironment)
		{
			this.rootBuilder = modelEnvironment.BuilderManager.RootBuilder;
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
			IInterfaceIdentifier wrIfaceID = BuildIFaceIWriter(rootBuilder.AddInterface("IWriter"));
			IInterfaceIdentifier wrbeIfaceID = BuildIFaceIWriterBackEnd(rootBuilder.AddInterface("IWriterBackEnd"));

			//- Auf ähnliche art und weise die Komponenten basteln
			IComponentIdentifier wrCCID = BuildCC1(rootBuilder.AddCompositeComponent("WriteCC"), wrbeIfaceID,wrIfaceID);
			IComponentIdentifier wrbeBCID = BuildBC1(rootBuilder.AddBasicComponent("WriterBackendBC"),wrbeIfaceID);
			rootBuilder.AddAssemblyConnector("WR -> WR_BE",wrCCID,wrbeIfaceID,wrbeBCID,wrbeIfaceID);
		}

		#endregion

		#region private methods
		
		//creates the composite component cc1
		private IComponentIdentifier BuildCC1(ICompositeComponentBuilder compositeComponentBuilder,
			IInterfaceIdentifier reqIFace, IInterfaceIdentifier provIFace)
		{
			IComponentIdentifier bc2ID = BuildBC2(compositeComponentBuilder.AddBasicComponent("WriterImplBC"),
				provIFace,reqIFace);	

			//Interfaces den der Komponente hinzufügen
			compositeComponentBuilder.AddProvidesInterface(provIFace);
			compositeComponentBuilder.AddRequiresInterface(reqIFace);


			//delegation connector ziehen
			compositeComponentBuilder.AddProvidesDelegationConnector("WRCC.Prov -> WRBC.Prov",provIFace,bc2ID,provIFace);
			compositeComponentBuilder.AddRequiresDelegationConnector("WRCC.Req -> WRBC.Req",bc2ID,reqIFace,reqIFace);
            			
            return compositeComponentBuilder.Component.ComponentID;
		}

		//creates the basic component bc1
		private IComponentIdentifier BuildBC2(IBasicComponentTypeLevelBuilder basicComponentTypeLevelBuilder,
			IInterfaceIdentifier provIfaceID,IInterfaceIdentifier reqIFaceID)
		{
			basicComponentTypeLevelBuilder.AddProvidesInterface(provIfaceID);
			basicComponentTypeLevelBuilder.AddRequiresInterface(reqIFaceID);
			return basicComponentTypeLevelBuilder.Component.ComponentID;
		}

		//creates the basic component bc1
		private IComponentIdentifier BuildBC1(IBasicComponentTypeLevelBuilder basicComponentTypeLevelBuilder,
			IInterfaceIdentifier provIfaceID)
		{
			basicComponentTypeLevelBuilder.AddProvidesInterface(provIfaceID);
			return basicComponentTypeLevelBuilder.Component.ComponentID;
		}

		//creates the interface IWriter
		private IInterfaceIdentifier BuildIFaceIWriter(IInterfaceTypeLevelBuilder levelBuilder)
		{
			levelBuilder.AddSignature("WriteSomething").AppendParameter(typeof(string),"filename",ParameterModifierEnum.REF);
			return levelBuilder.Interface.InterfaceID;
		}

		//creates the interface IWriterBackend
		private IInterfaceIdentifier BuildIFaceIWriterBackEnd(IInterfaceTypeLevelBuilder levelBuilder)
		{
			levelBuilder.AddSignature("WriteToDisk").AppendParameter(typeof(string),"filename",ParameterModifierEnum.REF);
			return levelBuilder.Interface.InterfaceID;
		}

		#endregion
	}
}

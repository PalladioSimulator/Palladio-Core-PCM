#if TEST

using Palladio.ComponentModel;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;

namespace Palladio.ComponentModel.UnitTests
{
	public class StaticComponentModel
	{
		#region data

		public static IInterfaceIdentifier IWRITERID;
		public static IInterfaceIdentifier IWRITERBEID;

		public static IComponentIdentifier CCWRITEID;
		public static IComponentIdentifier BCWRITEID; 
		public static IComponentIdentifier BCWRITEBEID; 

		//holds the model environment
		private static IRootTypeLevelBuilder rootBuilder;

		#endregion

		#region public methods

		/// <summary>
		/// called to create the model
		/// </summary>
		public static void Create(ComponentModelEnvironment env)
		{
			rootBuilder = env.BuilderManager.RootBuilder;
			//- zwei interfaces werden erzeugt (rootBuilder.AddInterface("...");)
			//- AddInterface gibt den Builder zu den Interfaces zurück, BuildIFaceWriter füllt das Interface mit Inhalt
			//- BuildIFaceWriter gibt die ID des Interfaces zurück, wird noch benötigt
			IWRITERID = BuildIFaceIWriter(rootBuilder.CreateInterface("IWriter"));
			IWRITERBEID = BuildIFaceIWriterBackEnd(rootBuilder.CreateInterface("IWriterBackEnd"));

			//- Auf ähnliche art und weise die Komponenten basteln
			CCWRITEID = BuildCC1(rootBuilder.AddCompositeComponent("WriteCC"), IWRITERBEID,IWRITERID);
			BCWRITEBEID = BuildBC1(rootBuilder.AddBasicComponent("WriterBackendBC"),IWRITERBEID);
			rootBuilder.AddAssemblyConnector("WR -> WR_BE",CCWRITEID,IWRITERBEID,BCWRITEBEID,IWRITERBEID);
		}

		#endregion

		#region private methods
		
		//creates the composite component cc1
		private static IComponentIdentifier BuildCC1(ICompositeComponentBuilder compositeComponentBuilder,
			IInterfaceIdentifier reqIFace, IInterfaceIdentifier provIFace)
		{
			BCWRITEID = BuildBC2(compositeComponentBuilder.AddBasicComponent("WriterImplBC"),
				provIFace,reqIFace);	

			//Interfaces den der Komponente hinzufügen
			compositeComponentBuilder.AddProvidesInterface(provIFace);
			compositeComponentBuilder.AddRequiresInterface(reqIFace);


			//delegation connector ziehen
			compositeComponentBuilder.AddProvidesDelegationConnector("WRCC.Prov -> WRBC.Prov",provIFace,BCWRITEID,provIFace);
			compositeComponentBuilder.AddRequiresDelegationConnector("WRCC.Req -> WRBC.Req",BCWRITEID,reqIFace,reqIFace);
            			
            return compositeComponentBuilder.Component.ComponentID;
		}

		//creates the basic component bc1
		private static IComponentIdentifier BuildBC2(IBasicComponentTypeLevelBuilder basicComponentTypeLevelBuilder,
			IInterfaceIdentifier provIfaceID,IInterfaceIdentifier reqIFaceID)
		{
			basicComponentTypeLevelBuilder.AddProvidesInterface(provIfaceID);
			basicComponentTypeLevelBuilder.AddRequiresInterface(reqIFaceID);
			return basicComponentTypeLevelBuilder.Component.ComponentID;
		}

		//creates the basic component bc1
		private static IComponentIdentifier BuildBC1(IBasicComponentTypeLevelBuilder basicComponentTypeLevelBuilder,
			IInterfaceIdentifier provIfaceID)
		{
			basicComponentTypeLevelBuilder.AddProvidesInterface(provIfaceID);
			return basicComponentTypeLevelBuilder.Component.ComponentID;
		}

		//creates the interface IWriter
		private static IInterfaceIdentifier BuildIFaceIWriter(IInterfaceTypeLevelBuilder levelBuilder)
		{
			//todo: signatures hinzufügen
			//levelBuilder.AddSignature()
			return levelBuilder.Interface.InterfaceID;
		}

		//creates the interface IWriterBackend
		private static IInterfaceIdentifier BuildIFaceIWriterBackEnd(IInterfaceTypeLevelBuilder levelBuilder)
		{
			//todo: signatures hinzufügen
			//levelBuilder.AddSignature()
			return levelBuilder.Interface.InterfaceID;
		}

		#endregion
	}
}
#endif
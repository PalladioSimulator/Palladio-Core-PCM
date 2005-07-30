#if TEST

using System;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.Identifier;

namespace Palladio.ComponentModel.UnitTests
{
	public class StaticComponentModel
	{
		#region data

		public static ISignatureIdentifier SIG1ID;
		public static ISignatureIdentifier SIG2ID;

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
			rootBuilder = env.BuilderManager.RootTypeLevelBuilder;
			//- zwei interfaces werden erzeugt (rootBuilder.AddInterface("...");)
			//- AddInterface gibt den Builder zu den Interfaces zurück, BuildIFaceWriter füllt das Interface mit Inhalt
			//- BuildIFaceWriter gibt die ID des Interfaces zurück, wird noch benötigt
			IWRITERID = BuildIFaceIWriter(rootBuilder.CreateInterface("IWriter"));
			IWRITERBEID = BuildIFaceIWriterBackEnd(rootBuilder.CreateInterface("IWriterBackEnd"));

			//- Auf ähnliche art und weise die Komponenten basteln
			CCWRITEID = BuildCC1(rootBuilder.AddNewCompositeComponent("WriteCC"), IWRITERBEID,IWRITERID);
			BCWRITEBEID = BuildBC1(rootBuilder.AddNewBasicComponent("WriterBackendBC"),IWRITERBEID);
			rootBuilder.AddAssemblyConnector("WR -> WR_BE",CCWRITEID,IWRITERBEID,BCWRITEBEID,IWRITERBEID);
		}

		#endregion

		#region private methods
		
		//creates the composite component cc1
		private static IComponentIdentifier BuildCC1(ICompositeComponentBuilder compositeComponentBuilder,
			IInterfaceIdentifier reqIFace, IInterfaceIdentifier provIFace)
		{
			BCWRITEID = BuildBC2(compositeComponentBuilder.AddNewBasicComponent("WriterImplBC"),
				provIFace,reqIFace);	

			//Interfaces den der Komponente hinzufügen
			compositeComponentBuilder.AddExistingInterfaceAsProvides(provIFace);
			compositeComponentBuilder.AddExistingInterfaceAsRequires(reqIFace);


			//delegation connector ziehen
			compositeComponentBuilder.AddProvidesDelegationConnector("WRCC.Prov -> WRBC.Prov",provIFace,BCWRITEID,provIFace);
			compositeComponentBuilder.AddRequiresDelegationConnector("WRCC.Req -> WRBC.Req",BCWRITEID,reqIFace,reqIFace);
            			
            return compositeComponentBuilder.Component.ComponentID;
		}

		//creates the basic component bc1
		private static IComponentIdentifier BuildBC2(IBasicComponentTypeLevelBuilder basicComponentTypeLevelBuilder,
			IInterfaceIdentifier provIfaceID,IInterfaceIdentifier reqIFaceID)
		{
			basicComponentTypeLevelBuilder.AddExistingInterfaceAsProvides(provIfaceID);
			basicComponentTypeLevelBuilder.AddExistingInterfaceAsRequires(reqIFaceID);
			return basicComponentTypeLevelBuilder.ComponentId;
		}

		//creates the basic component bc1
		private static IComponentIdentifier BuildBC1(IBasicComponentTypeLevelBuilder basicComponentTypeLevelBuilder,
			IInterfaceIdentifier provIfaceID)
		{
			basicComponentTypeLevelBuilder.AddExistingInterfaceAsProvides(provIfaceID);
			basicComponentTypeLevelBuilder.AddServiceEffectSpecification(new ASeff(),provIfaceID,SIG2ID);
			return basicComponentTypeLevelBuilder.Component.ComponentID;
		}

		//creates the interface IWriter
		private static IInterfaceIdentifier BuildIFaceIWriter(IInterfaceTypeLevelBuilder levelBuilder)
		{
			StaticComponentModel.SIG1ID = levelBuilder.AddSignature("sig1").SignatureId;
			levelBuilder.AddProtocol(new AProtocol());
			return levelBuilder.Interface.InterfaceID;
		}

		//creates the interface IWriterBackend
		private static IInterfaceIdentifier BuildIFaceIWriterBackEnd(IInterfaceTypeLevelBuilder levelBuilder)
		{
			StaticComponentModel.SIG2ID = levelBuilder.AddSignature("sig2").SignatureId;
			return levelBuilder.Interface.InterfaceID;
		}

		#endregion
	}

	class AProtocol : IProtocol
	{
		//type id
		private static IProtocolTypeIdentifier PROTTYPEID=
			ComponentModelIdentifier.CreateProtocolTypeID("D74B20F9-4009-4cf3-B2A6-7D7CFEC37B9F");

		//prot id
		private IProtocolIdentifier protID = ComponentModelIdentifier.CreateProtocolID(Guid.NewGuid().ToString());


		/// <summary>
		/// returns the typed id of the protocol
		/// </summary>
		public IProtocolIdentifier ProtocolID
		{
			get
			{
				return this.protID;
			}
		}

		/// <summary>
		/// returns the id of the type of protocol (fsm, ...)
		/// </summary>
		public IProtocolTypeIdentifier ProtocolTypeID
		{
			get
			{
				return AProtocol.PROTTYPEID;
			}
		}

		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get
			{
				return this.protID;
			}
		}
	}

	class ASeff :IServiceEffectSpecification
	{
		//type id
		private static ISeffTypeIdentifier SEFFTYPEID=
			ComponentModelIdentifier.CreateSeffTypeID("47DFDA70-EED8-4e6f-8D49-C73DC04F64FB");

		//the seff id
		private ISeffIdentifier seffID = ComponentModelIdentifier.CreateSeffID(Guid.NewGuid().ToString());

		/// <summary>
		/// returns the typed id of the seff
		/// </summary>
		public ISeffIdentifier SeffID
		{
			get
			{
				return this.seffID;
			}
		}

		/// <summary>
		/// returns the type id of the seff. 
		/// </summary>
		public ISeffTypeIdentifier SeffTypeID
		{
			get
			{
				return ASeff.SEFFTYPEID;
			}
		}

		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get 
			{
				return this.seffID;
			}
		}
	}
}
#endif
using System;
using System.Collections;
using System.Diagnostics;
using System.IO;
using Palladio.CM.Example.Presentation;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.ModelEntities;
using Palladio.ComponentModel.Serialization;
using Palladio.ComponentModel.Serialization.Xml;
using Palladio.FSMWrapper;
using Palladio.Serialization;
using Palladio.Types;

namespace Palladio.CM.Example
{
	/// <summary>
	/// This is the main class of the componentmodels example.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.17  2005/09/28 19:12:03  joemal
	/// fix bug
	///
	/// Revision 1.16  2005/09/27 17:00:48  kelsaka
	/// - added test case
	///
	/// Revision 1.15  2005/09/18 15:36:05  joemal
	/// add fsm seffs and protocols
	///
	/// Revision 1.14  2005/08/25 16:45:38  joemal
	/// add stream location to serializer
	///
	/// Revision 1.13  2005/08/22 16:39:02  kelsaka
	/// - load: validation against xsd added
	///
	/// Revision 1.12  2005/07/29 16:29:30  joemal
	/// add protocols to example
	///
	/// Revision 1.11  2005/07/29 16:00:12  joemal
	/// add fsm wrapper project
	///
	/// Revision 1.10  2005/07/23 18:57:26  joemal
	/// new implementation of IType
	///
	/// Revision 1.9  2005/07/13 11:09:47  joemal
	/// add clone methods
	///
	/// Revision 1.8  2005/06/25 16:52:20  joemal
	/// changes in the example
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
	/// Revision 1.3  2005/04/08 10:54:51  joemal
	/// start to implement the example
	///
	/// Revision 1.2  2005/02/24 20:13:06  joemal
	/// remove serilization and equals methods
	///
	/// Revision 1.1  2005/02/21 14:04:15  joemal
	/// initial import
	///
	///
	///
	/// </pre>
	/// </remarks>
	class MainClass
	{
		//holds the model environment
		private ComponentModelEnvironment modelEnvironment;
        
		//holds the view
		private StaticView view;

		//the stack that holds the models
		private Stack modelStack = new Stack();

		private bool f1;
		private bool f2;

		/// <summary>
		/// the entry for the applications main thead
		/// </summary>
		[STAThread]
		static void Main(string[] args)
		{
			MainClass test = new MainClass();
//			test.BuildModel();
//			test.NewTest();

//			test.SaveModel("test1.xml");
//			test.LoadModel("test1.xml");
			test.LoadModel("bla.xml");

			Done();

		}

		/// <summary>
		/// constructor
		/// </summary>
		public MainClass()
		{
			Init();
		}

		//does some initial work
		private void Init()
		{
			modelEnvironment = new ComponentModelEnvironment();
			//register the xml serializer
			IXmlSerializer xmlSerializer = DefaultSerializerFactory.
				CreateXMLSerializer(modelEnvironment.Query,modelEnvironment.BuilderManager);
			//here the chance to register xml serializerplugins that are used to serialize protocols,
			//attributes and service effect specifications
			//xmlSerializer.RegisterAttributePlugin(xxx);
			xmlSerializer.RegisterProcotocolPlugin(FSMWrapperFactory.CreateFSMProtocolPlugin());
			xmlSerializer.RegisterSeffPlugin(FSMWrapperFactory.CreateFSMSeffPlugin());
			xmlSerializer.RegisterTypePlugin(TypesFactory.CreateStringTypeXMLSerializerPlugin());
			modelEnvironment.SerializationManager.RegisterSerializer(xmlSerializer);

			//create the static view for the model
			this.view = new StaticView(modelEnvironment);			
		}

		/// <summary>
		/// call to build a hard coded model 
		/// </summary>
		public void BuildModel()
		{
			Console.WriteLine("Start creating the model.");
			new StaticComponentModel(modelEnvironment).Create();
			Done();			
		}

		/// <summary>
		/// call to save the current model to disk (test.xml in execution directory)
		/// </summary>
		/// <param name="filename">the filename</param>
		public void SaveModel(string filename)
		{
			Console.WriteLine("Try to store the model to file test.xml");
			try
			{
				modelEnvironment.SerializationManager.Store(DefaultSerializerFactory.CreateXmlLocation(filename));			
			}
			catch(ModelSerializationException exc)
			{
				Console.WriteLine("Save model: "+exc.InnerException.Message);
			}
			Done();
		}

		/// <summary>
		/// call to load the current model from disk (test.xml in execution directory)
		/// </summary>
		/// <param name="filename">thze filename</param>
		public void LoadModel(string filename)
		{
			Console.WriteLine("Try to load the xmlfile ..");
			try 
			{
				modelEnvironment.SerializationManager.Load(DefaultSerializerFactory.CreateXmlLocation(filename));				
			}
			catch(ModelSerializationException exc)
			{
				Console.WriteLine("Load model: "+exc.InnerException.Message);
			}
			Done();
		}

		//called to display done message and wait for user input
		private static void Done()
		{
			Console.WriteLine("[Done]");
			Console.WriteLine("Press 'Return' to continue.");
			Console.ReadLine();			
		}

		/// <summary>
		/// call to clear the current model
		/// </summary>
		public void ClearModel()
		{
			Console.WriteLine("Clear the model.");			
			modelEnvironment.BuilderManager.RootTypeLevelBuilder.ClearAll();
			Done();
		}

		/// <summary>
		/// call to "repaint" the model 
		/// </summary>
		public void Paint()
		{
			Console.WriteLine("Repaint the model.");			
			view.Paint();
			Done();		
		}

		/// <summary>
		/// call to push the current model to a stack
		/// </summary>
		public void PushModelToStack()
		{
			Console.WriteLine("Push the current model to the stack.");
			try
			{
				Stream stream = new MemoryStream();
				modelEnvironment.SerializationManager.Store(DefaultSerializerFactory.CreateXmlLocation(stream));
				modelStack.Push(stream);
			}
			catch(ModelSerializationException exc)
			{
				Console.WriteLine("Store model: "+exc.InnerException.Message);
			}
			Done();
		}

		/// <summary>
		/// call to restore the model from top of the stack
		/// </summary>
		public void PopModelFromStack()
		{
			Console.WriteLine("Restore the model on top of the stack.");
			if (modelStack.Count==0)
			{
				Console.WriteLine("No model on top of the stack found.");
				Done();
				return;
			}

			try 
			{
				Stream stream = (Stream) modelStack.Pop();
				stream.Seek(0,SeekOrigin.Begin);
				modelEnvironment.SerializationManager.Load(DefaultSerializerFactory.CreateXmlLocation(stream));				
				stream.Close();
			}
			catch(ModelSerializationException exc)
			{
				Console.WriteLine("Restore model: "+exc.InnerException.Message);
			}

			Done();
		}

		public void NewTest ()
		{
			
			ICompositeComponentTypeLevelBuilder cc1 = modelEnvironment.BuilderManager.RootTypeLevelBuilder.AddNewCompositeComponent("CC1");
			IInterfaceTypeLevelBuilder ifp1 = cc1.AddNewInterfaceAsProvides("ifp1");
			IInterfaceTypeLevelBuilder ifr1 = cc1.AddNewInterfaceAsRequires("ifr1");

			ICompositeComponentTypeLevelBuilder cc2 = cc1.AddNewCompositeComponent("cc2");
			IInterfaceTypeLevelBuilder ifp2 = cc2.AddNewInterfaceAsProvides("ifp2");
			IInterfaceTypeLevelBuilder ifr2 = cc2.AddNewInterfaceAsRequires("ifr2");

			modelEnvironment.EventInterface.GetCompositeComponentEvents(cc1.ComponentId).DelegationConnectorAddedEvent += new Palladio.ComponentModel.ModelEventManagement.DelegationConnectorBuildEventHandler(MainClass_DelegationConnectorAddedEvent);

			f1 = false;
			f2 = false;
			Console.Out.WriteLine ("ProvSET");
			cc1.AddProvidesDelegationConnector("pc1", ifp1.InterfaceId, cc2.ComponentId, ifp2.InterfaceId);
			Debug.Assert(f1);
			Debug.Assert(!f2);

			f1 = false;
			f2 = false;
			Console.Out.WriteLine ("ReqSET");
			cc1.AddRequiresDelegationConnector("rc2", cc2.ComponentId, ifr2.InterfaceId, ifr1.InterfaceId);
			Debug.Assert(!f1);
			Debug.Assert(f2);

		}


		private void MainClass_DelegationConnectorAddedEvent(object sender, Palladio.ComponentModel.ModelEventManagement.DelegationConnectorBuildEventArgs args)
		{
			if(args.Role == InterfaceRole.PROVIDES)
			{
				f1 = true;
				Console.Out.WriteLine ("Prov");
			}
			if(args.Role == InterfaceRole.REQUIRES)
			{
				f2 = true;
				Console.Out.WriteLine ("Req");
			}
		}
	}
}

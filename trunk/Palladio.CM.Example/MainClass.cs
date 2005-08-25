using System;
using System.Collections;
using System.IO;
using Palladio.CM.Example.Presentation;
using Palladio.ComponentModel;
using Palladio.ComponentModel.Identifier;
using Palladio.ComponentModel.Serialization;
using Palladio.ComponentModel.Serialization.Xml;
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

		/// <summary>
		/// the entry for the applications main thead
		/// </summary>
		[STAThread]
		static void Main(string[] args)
		{
			MainClass test = new MainClass();
			Console.WriteLine("Push empty model to stack ...");
			test.PushModelToStack();
            test.BuildModel();
			Console.WriteLine("Push a model with three components to stack.");
			test.PushModelToStack();
			test.ClearModel();
			test.PopModelFromStack();
			test.Paint();
			test.PopModelFromStack();
			test.Paint();
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
		public void SaveModel()
		{
			Console.WriteLine("Try to store the model to file test.xml");
			try
			{
				modelEnvironment.SerializationManager.Store(DefaultSerializerFactory.CreateXmlLocation("test.xml"));			
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
		public void LoadModel()
		{
			Console.WriteLine("Try to load the xmlfile ..");
			try 
			{
				modelEnvironment.SerializationManager.Load(DefaultSerializerFactory.CreateXmlLocation("test.xml"));				
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
	}
}

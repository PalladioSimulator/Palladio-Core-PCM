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
		/// <summary>
		/// the entry for the applications main thead
		/// </summary>
		[STAThread]
		static void Main(string[] args)
		{
			//create new model
			ComponentModelEnvironment modelEnvironment = new ComponentModelEnvironment();

			//register the xml serializer
			IXmlSerializer xmlSerializer = DefaultSerializerFactory.
				CreateXMLSerializer(modelEnvironment.Query,modelEnvironment.BuilderManager);
			//here the chance to register xml serializerplugins that are used to serialize protocols,
			//attributes and service effect specifications
			//xmlSerializer.RegisterAttributePlugin(xxx);
			xmlSerializer.RegisterTypePlugin(TypesFactory.CreateStringTypeXMLSerializerPlugin());
			modelEnvironment.SerializationManager.RegisterSerializer(xmlSerializer);

			//create the static view for the model
			StaticView view = new StaticView(modelEnvironment);

			Console.WriteLine("Start creating the model.");
			//use the models builder to create a model
            new StaticComponentModel(modelEnvironment).Create();
			Console.WriteLine("Model created. Press any key to repaint the model.");

			Console.ReadLine();

//			Console.WriteLine("Repaint the model.");			
//			view.Paint();
//			Console.WriteLine("Model repainted.");			

//			Console.ReadLine();

//			Console.WriteLine("Try to store the model to file test.xml");
//			modelEnvironment.SerializationManager.Store(DefaultSerializerFactory.CreateXmlLocation("test.xml"));
//			Console.WriteLine("[Done]");
			Console.WriteLine("Clear the model.");			
			modelEnvironment.BuilderManager.RootTypeLevelBuilder.ClearAll();
			Console.WriteLine("[Done]");
/*			Console.WriteLine("Try to load the xmlfile ..");
			try 
			{
				modelEnvironment.SerializationManager.Load(DefaultSerializerFactory.CreateXmlLocation("test.xml"));				
			}
			catch(ModelSerializationException exc)
			{
				Console.WriteLine("Exc: "+exc.InnerException.Message);
			}
			Console.WriteLine("[Done]");

			Console.ReadLine();

			Console.WriteLine("Repaint the model.");			
			view.Paint();
			Console.WriteLine("Model repainted.");			*/
			Console.WriteLine("Press any key to exit the application.");
			Console.ReadLine();
		}
	}
}

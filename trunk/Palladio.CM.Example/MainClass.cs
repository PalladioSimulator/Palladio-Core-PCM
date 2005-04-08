using System;
using Palladio.CM.Example.Presentation;
using Palladio.ComponentModel;

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

			//create the static view for the model
			StaticView view = new StaticView(modelEnvironment);

			Console.WriteLine("Start creating the model.");
			//use the models builder to create a model
            new StaticComponentModel(modelEnvironment).Create();
			Console.WriteLine("Model created. Press any key to repaint the model.");

			Console.ReadLine();

			Console.WriteLine("Repaint the model.");			
			view.Paint();
			Console.WriteLine("Model repainted.");			

			Console.WriteLine("Press any key to exit the application.");
			Console.ReadLine();
		}
	}
}

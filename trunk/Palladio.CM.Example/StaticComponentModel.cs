using Palladio.ComponentModel;
using Palladio.ComponentModel.Builder;
using Palladio.ComponentModel.Builder.TypeLevelBuilder;

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
			this.rootBuilder = modelEnvironment.RootBuilder;
		}

		#endregion

		#region public methods

		/// <summary>
		/// called to create the model
		/// </summary>
		public void Create()
		{
			BuildIFaceIWriter(rootBuilder.AddInterface("IWriter"));
			BuildIFaceIWriterBackEnd(rootBuilder.AddInterface("IWriterBackEnd"));
			BuildCC1(rootBuilder.AddCompositeComponent("WriteCC"));
			BuildBC1(rootBuilder.AddBasicComponent("WriterBackendBC"));
			//todo: add assembly connector between WriterCC and WriterBackendBC
		}

		#endregion

		#region private methods
		
		//creates the composite component cc1
		private void BuildCC1(ICompositeComponentBuilder compositeComponentBuilder)
		{
			//todo: add interfaces to the component
			//todo: add delegation connectors to the component
			//todo: add basic component WriterImplBC
            //compositeComponentBuilder.AddBasicComponent("WriterImplBC");			
		}

		//creates the basic component bc1
		private void BuildBC1(IBasicComponentTypeLevelBuilder basicComponentTypeLevelBuilder)
		{
			//todo: add interfaces to the components
		}

		private void BuildIFaceIWriter(IInterfaceTypeLevelBuilder levelBuilder)
		{
			//todo: add signatures
		}

		private void BuildIFaceIWriterBackEnd(IInterfaceTypeLevelBuilder levelBuilder)
		{
			//todo: add signatures
		}

		#endregion
	}
}

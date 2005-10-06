using System.IO;

namespace Palladio.QoSAdaptor.Control
{
	/// <summary>
	/// The interface provided by the Palladio.QoSAdaptor.Control component. 
	/// </summary>
	public interface IController
	{
		/// <summary>
		/// This method starts the the analysis of the interface models,
		/// the selection of a pattern that solves interface model mismatches 
		/// and the generation of an adaptor and a prediction model using that
		/// pattern.
		/// </summary>
		/// <param name="interfaceModel">The considered interface model.
		/// </param>
		/// <param name="required">The required interface model description.
		/// </param>
		/// <param name="provided">The provided interface model description.
		/// </param>
		void Start(Controller.InterfaceModel interfaceModel, TextReader required, 
			TextReader provided);
	}
}

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This interface provides all events that can be fired from a signature in the componentmodel.
	/// </summary>
	/// <remarks>
	/// <code>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2005/10/23 16:26:42  kelsaka
	/// - extracted event interfaces to make the events adaptable
	/// - made event classes internal
	///
	/// </code>
	/// </remarks>
	public interface ISignatureEvents : IEntityEvents
	{
		/// <summary>
		/// has to be fired, when the return type of the signature has been changed
		/// </summary>
		event StaticAttributeChangedEventHandler ReturnTypeChanged;

		/// <summary>
		/// has to be fired, when the paremeters of the signature have been changed
		/// </summary>
		event StaticAttributeChangedEventHandler ParametersChanged;

		/// <summary>
		/// has to be fired, when the exceptions of the signature have been changed
		/// </summary>
		event StaticAttributeChangedEventHandler ExceptionsChanged;
	}
}
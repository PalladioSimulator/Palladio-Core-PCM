using Palladio.ComponentModel.ModelEntities;

namespace Palladio.ComponentModel.ModelEventManagement
{
	/// <summary>
	/// This class provides all events that can be fired from a signature in the componentmodel.
	/// </summary>
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.2  2005/04/05 14:23:59  joemal
	/// implement the rest of the notification
	///
	/// Revision 1.1  2005/03/29 13:05:37  joemal
	/// initial class creation
	///
	///
	///
	/// </pre>
	/// </remarks>
	public class SignatureEvents : EntityEvents
	{
		#region constructor

		/// <summary>
		/// called to create a new eventstructure for an entity
		/// </summary>
		internal SignatureEvents(ISignature signature) : base (signature)
		{
			signature.ReturnTypeChanged += new StaticAttributeChangedEventHandler(signature_ReturnTypeChanged);
			signature.ParametersChanged += new StaticAttributeChangedEventHandler(signature_ParametersChanged);
			signature.ExceptionsChanged += new StaticAttributeChangedEventHandler(signature_ExceptionsChanged);
		}


		#endregion

		#region events

		/// <summary>
		/// has to be fired, when the return type of the signature has been changed
		/// </summary>
		public event StaticAttributeChangedEventHandler ReturnTypeChanged;

		/// <summary>
		/// has to be fired, when the paremeters of the signature have been changed
		/// </summary>
		public event StaticAttributeChangedEventHandler ParametersChanged;

		/// <summary>
		/// has to be fired, when the exceptions of the signature have been changed
		/// </summary>
		public event StaticAttributeChangedEventHandler ExceptionsChanged;

		#endregion

		#region private methods

		//called, when the returntype of the signature has been changed
		private void signature_ReturnTypeChanged(object sender)
		{
			if (ReturnTypeChanged != null) ReturnTypeChanged(sender);
		}

		//called, when the parameters of the signature have been changed
		private void signature_ParametersChanged(object sender)
		{
			if (ParametersChanged != null) ParametersChanged(sender);
		}
		//called, when the exceptions of the signature have been changed
		private void signature_ExceptionsChanged(object sender)
		{
			if (ExceptionsChanged != null) ExceptionsChanged(sender);
		}

		#endregion
	}
}

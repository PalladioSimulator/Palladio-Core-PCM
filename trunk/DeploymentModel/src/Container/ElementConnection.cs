using System;

namespace Palladio.DeploymentModel
{
	/// <summary>
	/// </summary>
	public class ElementConnection : IElementConnection
	{
		private ICharacterisedElement source;
		private ICharacterisedElement destination;

		public ICharacterisedElement Source
		{
			get { return source; }
			set { source = value; }
		}

		public ICharacterisedElement Destination
		{
			get { return destination; }
			set { destination = value; }
		}

		public ElementConnection()
		{
			source = destination = null;
		}

		public ElementConnection(ICharacterisedElement source, ICharacterisedElement destination)
		{
			this.source = source;
			this.destination = destination;
		}
	}
}

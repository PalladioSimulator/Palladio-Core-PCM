using Palladio.Identifier;

namespace Palladio.Reliability.Model.Resource
{
	/// <summary>
	/// Zusammenfassung für Resource.
	/// </summary>
	public class Resource : IResource
	{
		private IIdentifier id;

		/// <summary>
		/// The Identifier describing the identified object
		/// </summary>
		public IIdentifier ID
		{
			get { return id; }
		}

		public Resource(IIdentifier id)
		{
			this.id = id;
		}

		public override bool Equals(object obj)
		{
			if (obj is IResource)
			{
				IResource r = (IResource) obj;
				return ID.Equals(r.ID);
			}
			return false;
		}

		public override int GetHashCode()
		{
			return ID.GetHashCode();
		}
	}
}
using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.ComponentModel 
{

	/// <summary>
	/// Default Component class. A component consits of a set of
	/// Provides and RequiresInterfaces which can be adapted to
	/// its environment.
	/// </summary>
	public class Component : IComponent 
	{
		#region Methods

		/// <summary>
		/// Returns an list of adapted provides interfaces of this component.
		/// </summary>
		/// <param name="aProvIfaceList">
		/// List of provides interfaces of the environment.
		///	</param>
		/// <returns>
		/// A list of ProvideInterface objects.
		/// </returns>
		public IList GetProvidesIfaceList(IList aProvIfaceList) 
		{
			return null;
		}

		/// <summary>
		/// Returns a list of adapted requires interfaces of this component.
		/// </summary>
		/// <param name="aReqIfaceList">
		/// List of requires interfaces of the environment.
		/// </param>
		/// <returns>
		/// A list of RequiresInterface objects.
		/// </returns>
		public IList GetRequiresIfaceList(IList aReqIfaceList) 
		{
			return null;
		}

		/// <summary>
		/// Returns a list of unmodified provides interfaces of this component.
		/// </summary>
		/// <returns>
		/// A List of ProvidesInterface objects.
		/// </returns>
		public IList GetProvidesIfaceList() 
		{
			return provIfaceList;
		}

		/// <summary>
		/// Returns a list of unmodified requires interfaces of this component.
		/// </summary>
		/// <returns>
		/// A list of RequiresInterface objects.
		/// </returns>
		public IList GetRequiresIfaceList() 
		{
			return reqIfaceList;
		}

		/// <summary>
		/// Creates a copy of the current instance.
		/// </summary>
		/// <returns>A new object with the same values as the current instance.</returns>
		public object Clone()
		{
			return new Component(this);
		}

		/// <summary>
		/// The Equals method determines whether the specified 
		/// System.Object is equal to the current System.Object.
		/// </summary>
		/// <param name="obj">Contains the Object to compare with 
		/// the current object.</param>
		/// <returns>Returns true if the specified object is equal 
		/// to the current objector or false if the obejcts 
		/// are not equal.</returns>
		public override bool Equals(object obj)
		{
			if (obj is Component)
			{
				Component com = (Component)obj;
				return (this.provIfaceList.Equals(com.provIfaceList) &&
					this.reqIfaceList.Equals(com.reqIfaceList));
			}
			return false;
		}

		/// <summary>
		/// The GetHashCode method serves as a hash function 
		/// for a particular type, suitable for use in hashing 
		/// algorithms and data structures like a hash table.
		/// </summary>
		/// <returns>A hash value for the current object.</returns>
		public override int GetHashCode()
		{
			return base.GetHashCode ();
		}
		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty Component.
		/// </summary>
		public Component() 
		{
			provIfaceList = new Vector();
			reqIfaceList = new Vector();
		}
		
		/// <summary>
		/// Creates a new component with a list of provides interfaces an 
		/// no requirements to the environment.
		/// </summary>
		/// <param name="aProvIfaceList">
		/// A list of ProvidesInterface objects.
		/// </param>
		public Component( IList aProvIfaceList ) : this()
		{
			provIfaceList.AddRange( aProvIfaceList );
		}

		/// <summary>
		/// Creates a new component with a list of ProvidesInterfaces and 
		/// RequiresInterfaces.
		/// </summary>
		/// <param name="aProvIfaceList">
		/// A list of ProvidesInterface objects.
		/// </param>
		/// <param name="aReqIfaceList">
		/// A list of RequiresInterface objects.
		/// </param>
		public Component( IList aProvIfaceList, IList aReqIfaceList ) : this( aProvIfaceList )
		{
			reqIfaceList.AddRange( aReqIfaceList );
		}

		/// <summary>
		/// CopyConstructor.
		/// </summary>
		/// <param name="aComp">Component to copy</param>
		public Component( Component aComp ) : 
			this (aComp.GetProvidesIfaceList(), aComp.GetRequiresIfaceList()) {}

		#endregion

		#region Data

		private Vector provIfaceList;
		private Vector reqIfaceList;
		#endregion
	}
}
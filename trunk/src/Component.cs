using System;
using System.Collections;
using Utils.Collections;

namespace Palladio.ComponentModel 
{

	/// <summary>
	/// Default Component class. A component consits of a set of
	/// provides and requires interfaces, which can be adapted to
	/// its environment.
	/// </summary>
	public class Component : IComponent 
	{

		#region Data

		private Vector provIFaceList;
		private Vector reqIFaceList;

		#endregion

		#region Constructors

		/// <summary>
		/// Creates an empty Component.
		/// </summary>
		public Component() 
		{
			provIFaceList = new Vector();
			reqIFaceList = new Vector();
		}
		

		/// <summary>
		/// Creates a new component with a list of provides interfaces an 
		/// no requirements to the environment.
		/// </summary>
		/// <param name="aProvIFaceList">
		/// A list of ProvidesInterface objects.
		/// </param>
		public Component( IList aProvIFaceList ) : this()
		{
			provIFaceList.AddRange( aProvIFaceList );
		}


		/// <summary>
		/// Creates a new component with a list of provides and requires
		/// interfaces.
		/// </summary>
		/// <param name="aProvIFaceList">
		/// A list of ProvidesInterface objects.
		/// </param>
		/// <param name="aReqIFaceList">
		/// A list of RequiresInterface objects.
		/// </param>
		public Component( IList aProvIFaceList, IList aReqIFaceList ) : this( aProvIFaceList )
		{
			reqIFaceList.AddRange( aReqIFaceList );
		}


		public Component( Component aComp ) : 
			this (aComp.GetProvidesIFaceList(), aComp.GetRequiresIFaceList()) {}


		#endregion

		#region Methods

		/// <summary>
		/// Returns an list of adapted provides interfaces of this component.
		/// </summary>
		/// <param name="aProvIFaceList">
		/// List of provides interfaces of the environment.
		///	</param>
		/// <returns>
		/// A list of ProvideInterface objects.
		/// </returns>
		public IList GetProvidesIFaceList(IList aProvIFaceList) 
		{
			return null;
		}


		/// <summary>
		/// Returns a list of adapted requires interfaces of this component.
		/// </summary>
		/// <param name="aReqIFaceList">
		/// List of requires interfaces of the environment.
		/// </param>
		/// <returns>
		/// A list of RequiresInterface objects.
		/// </returns>
		public IList GetRequiresIFaceList(IList aReqIFaceList) 
		{
			return null;
		}


		/// <summary>
		/// Returns a list of unmodified provides interfaces of this component.
		/// </summary>
		/// <returns>
		/// A List of ProvidesInterface objects.
		/// </returns>
		public IList GetProvidesIFaceList() 
		{
			return provIFaceList;
		}


		/// <summary>
		/// Returns a list of unmodified requires interfaces of this component.
		/// </summary>
		/// <returns>
		/// A list of RequiresInterface objects.
		/// </returns>
		public IList GetRequiresIFaceList() 
		{
			return reqIFaceList;
		}


		public object Clone()
		{
			return new Component(this);
		}


		public override bool Equals(object obj)
		{
			if (obj is Component)
			{
				Component com = (Component)obj;
				return (this.provIFaceList.Equals(com.provIFaceList) &&
					this.reqIFaceList.Equals(com.reqIFaceList));
			}
			return false;
		}


		#endregion
	}
}
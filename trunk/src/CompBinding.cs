using System;
using System.Collections;

namespace Palladio.ComponentModel
{
	/// <summary>
	/// Zusammenfassung für CompBinding.
	/// </summary>
	public class CompBinding : IBinding
	{
		#region Data

		private IComponent provComp;
		private IComponent reqComp;
		private IFaceBinding[] ifaceBindings;
		#endregion

		#region Properties

		public IComponent ProvComp
		{
			get { return provComp; }
		}

		public IComponent ReqComp
		{
			get { return reqComp; }
		}

		public IFaceBinding[] IFaceBindings
		{
			get { return ifaceBindings; }
		}
		#endregion

		#region Constructors

		public CompBinding(IComponent aReqComp, IComponent aProvComp)
		{
			provComp = aProvComp;
			reqComp = aReqComp;
			ifaceBindings = GenerateBindings();
		}

		public CompBinding(IComponent aReqComp, IComponent aProvComp, IList bindingList)
		{
			provComp = aProvComp;
			reqComp = aReqComp;
			ifaceBindings = new IFaceBinding[bindingList.Count];
			bindingList.CopyTo(ifaceBindings,0);
		}
		#endregion

		#region private Methods

		private IFaceBinding[] GenerateBindings()
		{
			IList bindList = new ArrayList();
			foreach( RequiresInterface reqIFace in reqComp.GetRequiresIFaceList() )
			{
				bool found = false;
				foreach ( ProvidesInterface provIFace in provComp.GetProvidesIFaceList() )
				{
					if (reqIFace.Name.Equals(provIFace.Name))
					{
						found = true;
						bindList.Add( new IFaceBinding( reqIFace, provIFace ) );
						break;
					}
				}
				if (!found)
					throw new NoBindingFoundException(reqIFace);
			}
			IFaceBinding[] result = new IFaceBinding[bindList.Count];
			bindList.CopyTo(result,0);
			return result;
		}

		#endregion

		#region IBinding Member

		public bool CheckInteroperability()
		{
			// TODO:  Implementierung von CompBinding.CheckInteroperability hinzufügen
			return false;
		}

		bool Palladio.ComponentModel.IBinding.CheckInteroperability(out System.Collections.IList anErrorList)
		{
			// TODO:  Implementierung von CompBinding.Palladio.ComponentModel.IBinding.CheckInteroperability hinzufügen
			anErrorList = null;
			return false;
		}

		#endregion

		#region IConnection Member

		public IInterfaceModel GetIntersection()
		{
			// TODO:  Implementierung von CompBinding.GetIntersection hinzufügen
			return null;
		}

		#endregion

		#region ICloneable Member

		public object Clone()
		{
			// TODO:  Implementierung von CompBinding.Clone hinzufügen
			return null;
		}

		#endregion
	}
}

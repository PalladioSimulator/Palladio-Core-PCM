//using System;
//
//namespace FiniteStateMachines {
//	/// <summary>
//	///Class representing an Input object which stores also information about the output value of a transition. 
//	/// </summary>
//	public class ReturnInput : Input {
//
//		/// <summary>
//		///String describing the return value, error code or exception of a method.
//		/// </summary>
//		private string returnInfo;
//
//		/// <summary>
//		///String describing the return value, error code or exception of a method.
//		/// </summary>
//		public string ReturnInfo {
//			get {return returnInfo;}
//		}
//
//		/// <summary>
//		/// Constructor creating a new ReturnInput object.
//		/// </summary>
//		/// <param name="anInput">A name of a valid input</param>
//		/// <param name="aReturnInfo">An output</param>
//		public ReturnInput(String anInput, String aReturnInfo) : base(anInput) {
//			returnInfo = aReturnInfo;
//		}
//
//		/// <summary>
//		/// Compares this input to another object.
//		/// </summary>
//		/// <returns>true if both inputs are equal, false otherwise</returns>
//		public override bool Equals(object obj) {
//			if (obj is ReturnInput) {
//				ReturnInput anInput = (ReturnInput)obj;
//				return ((base.Equals(obj)) && (ReturnInfo == anInput.ReturnInfo));
//			}
//			return false;
//		}
//	}
//}
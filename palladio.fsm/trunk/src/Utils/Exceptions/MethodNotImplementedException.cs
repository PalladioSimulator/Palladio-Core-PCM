using System;

namespace Utils.Exceptions {
    /// <summary>This exception is thrown, if the called method is not
    ///     implemented by a class.</summary>
	public class MethodNotImplementedException : ApplicationException {
        public MethodNotImplementedException(){
        }
    }
}

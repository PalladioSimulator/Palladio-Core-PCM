using System;

namespace ComponentModel {
	public enum ErrorLevelEnum { low, medium, high };

	public enum ErrorCodeEnum { xy_not_found, kaputt };

	/// <summary>
	/// </summary>
	public interface IInterOperabilityError {
		ErrorLevelEnum ErrorLevel { get; }
		ErrorCodeEnum ErrorCode { get; }
		string Message { get; }
	}
}

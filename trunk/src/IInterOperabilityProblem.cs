using System;

namespace ComponentModel {
	enum ErrorLevelEnum { low, medium, high };

	enum ErrorCodeEnum { xy_not_found, kaputt };

	/// <summary>
	/// </summary>
	public interface IInterOperabilityError {
		ErrorLevelEnum ErrorLevel { get; }
		ErrorCodeEnum ErrorCode { get; }
		string Message { get; }
	}
}

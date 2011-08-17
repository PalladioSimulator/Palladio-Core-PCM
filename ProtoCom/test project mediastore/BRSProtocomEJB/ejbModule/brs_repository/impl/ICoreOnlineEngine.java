package brs_repository.impl;

public interface ICoreOnlineEngine {

	/* (non-Javadoc)
	 * @see brs_repository.impl.ICoreOnlineEngine#getPortProvided_IAdmin_CoreReportingEngine()
	 */
	public brs_repository.IAdmin getPortProvided_IAdmin_CoreReportingEngine();

	/* (non-Javadoc)
	 * @see brs_repository.impl.ICoreOnlineEngine#getPortProvided_IReporting_CoreReportingEngine()
	 */
	public brs_repository.IReporting getPortProvided_IReporting_CoreReportingEngine();

	/* (non-Javadoc)
	 * @see brs_repository.impl.ICoreOnlineEngine#setContext(brs_repository.impl.contexts.ICoreOnlineEngineContext)
	 */
	public void setContext(
			brs_repository.impl.contexts.ICoreOnlineEngineContext myContext);

}
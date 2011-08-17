package brs_repository.impl;

public interface ICoreGraphicEngine {

	/* (non-Javadoc)
	 * @see brs_repository.impl.ICoreGraphicEngine#getPortProvided_IReporting_CoreReportingEngine2()
	 */
	public brs_repository.IReporting getPortProvided_IReporting_CoreReportingEngine2();

	/* (non-Javadoc)
	 * @see brs_repository.impl.ICoreGraphicEngine#setContext(brs_repository.impl.contexts.ICoreGraphicEngineContext)
	 */
	public void setContext(
			brs_repository.impl.contexts.ICoreGraphicEngineContext myContext);

}
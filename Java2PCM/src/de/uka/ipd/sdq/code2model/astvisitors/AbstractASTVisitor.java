/**
 * 
 */
package de.uka.ipd.sdq.code2model.astvisitors;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.ASTVisitor;

/**
 * @author thomas
 *
 */
public abstract class AbstractASTVisitor extends ASTVisitor {
	protected static final boolean visitChildren = true;
	protected static final boolean skipChildren = false;
	
	protected static Logger logger;

	public AbstractASTVisitor() {
		logger = Logger.getLogger(this.getClass());
	}

}

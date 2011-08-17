package mediastorerepository;


import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class AbstractMediastoreSessionBean implements SessionBean {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4690758915678742009L;

	@Override
	public void ejbActivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {

	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {

	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {

	}

}

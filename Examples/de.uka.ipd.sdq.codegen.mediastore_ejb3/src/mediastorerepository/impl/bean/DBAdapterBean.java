package mediastorerepository.impl.bean;


/** The Enterprise Java Bean for the component DBAdapter
*/
@javax.ejb.Stateless
public class DBAdapterBean extends mediastorerepository.impl.DBAdapter
    implements mediastorerepository.impl.bean.IDBAdapterBean {
    public DBAdapterBean() {
    }

    // Called by the Container to inject a reference to the local interface of this components
    // context class
    @javax.ejb.EJB(name = "ejb/DBAdapter/Context", beanInterface = mediastorerepository.impl.contexts.IDBAdapterContext.class)
    @Override
    public void setContext(
        mediastorerepository.impl.contexts.IDBAdapterContext context) {
        super.setContext(context);
    }
}

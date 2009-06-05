
package mediastorews;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import mediarepository.entities.DBID3v1;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mediastorews package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _QueryFileByField_QNAME = new QName("http://mediastorews/", "queryFileByField");
    private final static QName _DownloadHTTP_QNAME = new QName("http://mediastorews/", "downloadHTTP");
    private final static QName _QueryFileByFieldResponse_QNAME = new QName("http://mediastorews/", "queryFileByFieldResponse");
    private final static QName _QueryID3_QNAME = new QName("http://mediastorews/", "queryID3");
    private final static QName _DownloadHTTPResponse_QNAME = new QName("http://mediastorews/", "downloadHTTPResponse");
    private final static QName _QueryID3Response_QNAME = new QName("http://mediastorews/", "queryID3Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mediastorews
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryFileByField }
     * 
     */
    public QueryFileByField createQueryFileByField() {
        return new QueryFileByField();
    }

    /**
     * Create an instance of {@link QueryID3Response }
     * 
     */
    public QueryID3Response createQueryID3Response() {
        return new QueryID3Response();
    }

    /**
     * Create an instance of {@link QueryFileByFieldResponse }
     * 
     */
    public QueryFileByFieldResponse createQueryFileByFieldResponse() {
        return new QueryFileByFieldResponse();
    }

    /**
     * Create an instance of {@link QueryID3 }
     * 
     */
    public QueryID3 createQueryID3() {
        return new QueryID3();
    }

    /**
     * Create an instance of {@link DownloadHTTP }
     * 
     */
    public DownloadHTTP createDownloadHTTP() {
        return new DownloadHTTP();
    }

    /**
     * Create an instance of {@link DownloadHTTPResponse }
     * 
     */
    public DownloadHTTPResponse createDownloadHTTPResponse() {
        return new DownloadHTTPResponse();
    }

    /**
     * Create an instance of {@link Dbid3V1 }
     * 
     */
    public DBID3v1 createDbid3V1() {
        return new DBID3v1();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryFileByField }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mediastorews/", name = "queryFileByField")
    public JAXBElement<QueryFileByField> createQueryFileByField(QueryFileByField value) {
        return new JAXBElement<QueryFileByField>(_QueryFileByField_QNAME, QueryFileByField.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadHTTP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mediastorews/", name = "downloadHTTP")
    public JAXBElement<DownloadHTTP> createDownloadHTTP(DownloadHTTP value) {
        return new JAXBElement<DownloadHTTP>(_DownloadHTTP_QNAME, DownloadHTTP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryFileByFieldResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mediastorews/", name = "queryFileByFieldResponse")
    public JAXBElement<QueryFileByFieldResponse> createQueryFileByFieldResponse(QueryFileByFieldResponse value) {
        return new JAXBElement<QueryFileByFieldResponse>(_QueryFileByFieldResponse_QNAME, QueryFileByFieldResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryID3 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mediastorews/", name = "queryID3")
    public JAXBElement<QueryID3> createQueryID3(QueryID3 value) {
        return new JAXBElement<QueryID3>(_QueryID3_QNAME, QueryID3 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadHTTPResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mediastorews/", name = "downloadHTTPResponse")
    public JAXBElement<DownloadHTTPResponse> createDownloadHTTPResponse(DownloadHTTPResponse value) {
        return new JAXBElement<DownloadHTTPResponse>(_DownloadHTTPResponse_QNAME, DownloadHTTPResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryID3Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mediastorews/", name = "queryID3Response")
    public JAXBElement<QueryID3Response> createQueryID3Response(QueryID3Response value) {
        return new JAXBElement<QueryID3Response>(_QueryID3Response_QNAME, QueryID3Response.class, null, value);
    }

}

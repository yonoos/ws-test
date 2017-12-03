
package yc.jee.test.ws.soap.endpoint.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the yc.jee.test.ws.soap.endpoint.gen package. 
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

    private final static QName _MultiResponse_QNAME = new QName("http://yc.jee.test.ws.soap.endpoint", "multiResponse");
    private final static QName _Sum_QNAME = new QName("http://yc.jee.test.ws.soap.endpoint", "sum");
    private final static QName _Multi_QNAME = new QName("http://yc.jee.test.ws.soap.endpoint", "multi");
    private final static QName _SumResponse_QNAME = new QName("http://yc.jee.test.ws.soap.endpoint", "sumResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: yc.jee.test.ws.soap.endpoint.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MultiResponse }
     * 
     */
    public MultiResponse createMultiResponse() {
        return new MultiResponse();
    }

    /**
     * Create an instance of {@link Sum }
     * 
     */
    public Sum createSum() {
        return new Sum();
    }

    /**
     * Create an instance of {@link SumResponse }
     * 
     */
    public SumResponse createSumResponse() {
        return new SumResponse();
    }

    /**
     * Create an instance of {@link Multi }
     * 
     */
    public Multi createMulti() {
        return new Multi();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yc.jee.test.ws.soap.endpoint", name = "multiResponse")
    public JAXBElement<MultiResponse> createMultiResponse(MultiResponse value) {
        return new JAXBElement<MultiResponse>(_MultiResponse_QNAME, MultiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yc.jee.test.ws.soap.endpoint", name = "sum")
    public JAXBElement<Sum> createSum(Sum value) {
        return new JAXBElement<Sum>(_Sum_QNAME, Sum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yc.jee.test.ws.soap.endpoint", name = "multi")
    public JAXBElement<Multi> createMulti(Multi value) {
        return new JAXBElement<Multi>(_Multi_QNAME, Multi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://yc.jee.test.ws.soap.endpoint", name = "sumResponse")
    public JAXBElement<SumResponse> createSumResponse(SumResponse value) {
        return new JAXBElement<SumResponse>(_SumResponse_QNAME, SumResponse.class, null, value);
    }

}

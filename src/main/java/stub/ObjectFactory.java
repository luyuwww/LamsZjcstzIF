
package stub;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the stub package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertWork }
     * 
     */
    public InsertWork createInsertWork() {
        return new InsertWork();
    }

    /**
     * Create an instance of {@link WaitWork }
     * 
     */
    public WaitWork createWaitWork() {
        return new WaitWork();
    }

    /**
     * Create an instance of {@link HelloWorldResponse }
     * 
     */
    public HelloWorldResponse createHelloWorldResponse() {
        return new HelloWorldResponse();
    }

    /**
     * Create an instance of {@link DeleteWork }
     * 
     */
    public DeleteWork createDeleteWork() {
        return new DeleteWork();
    }

    /**
     * Create an instance of {@link InsertWorkResponse }
     * 
     */
    public InsertWorkResponse createInsertWorkResponse() {
        return new InsertWorkResponse();
    }

    /**
     * Create an instance of {@link NotifyTodoAppResult }
     * 
     */
    public NotifyTodoAppResult createNotifyTodoAppResult() {
        return new NotifyTodoAppResult();
    }

    /**
     * Create an instance of {@link DeleteWorkResponse }
     * 
     */
    public DeleteWorkResponse createDeleteWorkResponse() {
        return new DeleteWorkResponse();
    }

    /**
     * Create an instance of {@link HelloWorld }
     * 
     */
    public HelloWorld createHelloWorld() {
        return new HelloWorld();
    }

}

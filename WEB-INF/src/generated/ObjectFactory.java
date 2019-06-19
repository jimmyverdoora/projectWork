//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.06.18 alle 10:47:28 AM CEST 
//


package generated;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderStructure }
     * 
     */
    public OrderStructure createOrderStructure() {
        return new OrderStructure();
    }

    /**
     * Create an instance of {@link OrderStructure.Order }
     * 
     */
    public OrderStructure.Order createOrderStructureOrder() {
        return new OrderStructure.Order();
    }

    /**
     * Create an instance of {@link OrderStructure.Order.OrderLines }
     * 
     */
    public OrderStructure.Order.OrderLines createOrderStructureOrderOrderLines() {
        return new OrderStructure.Order.OrderLines();
    }

    /**
     * Create an instance of {@link OrderStructure.Suppliers }
     * 
     */
    public OrderStructure.Suppliers createOrderStructureSuppliers() {
        return new OrderStructure.Suppliers();
    }

    /**
     * Create an instance of {@link OrderStructure.OrderHeader }
     * 
     */
    public OrderStructure.OrderHeader createOrderStructureOrderHeader() {
        return new OrderStructure.OrderHeader();
    }

    /**
     * Create an instance of {@link OrderStructure.Order.OrderLines.OrderLine }
     * 
     */
    public OrderStructure.Order.OrderLines.OrderLine createOrderStructureOrderOrderLinesOrderLine() {
        return new OrderStructure.Order.OrderLines.OrderLine();
    }

    /**
     * Create an instance of {@link OrderStructure.Suppliers.Supplier }
     * 
     */
    public OrderStructure.Suppliers.Supplier createOrderStructureSuppliersSupplier() {
        return new OrderStructure.Suppliers.Supplier();
    }

}

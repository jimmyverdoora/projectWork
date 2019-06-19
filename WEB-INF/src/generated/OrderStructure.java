//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.06.18 alle 10:47:28 AM CEST 
//


package generated;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Suppliers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Supplier" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="FornitoreId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OrderHeader">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CustomerId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Order">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="OrderLines">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="OrderLine" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="OrderLineNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="ItemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ItemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ItemQty" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="ItemPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "suppliers",
    "orderHeader",
    "order"
})
@XmlRootElement(name = "OrderStructure")
public class OrderStructure {

    @XmlElement(name = "Suppliers", required = true)
    protected OrderStructure.Suppliers suppliers;
    @XmlElement(name = "OrderHeader", required = true)
    protected OrderStructure.OrderHeader orderHeader;
    @XmlElement(name = "Order", required = true)
    protected OrderStructure.Order order;

    /**
     * Recupera il valore della proprietà suppliers.
     *
     * @return
     *     possible object is
     *     {@link OrderStructure.Suppliers }
     *
     */
    public OrderStructure.Suppliers getSuppliers() {
        return suppliers;
    }

    /**
     * Imposta il valore della proprietà suppliers.
     *
     * @param value
     *     allowed object is
     *     {@link OrderStructure.Suppliers }
     *
     */
    public void setSuppliers(OrderStructure.Suppliers value) {
        this.suppliers = value;
    }

    /**
     * Recupera il valore della proprietà orderHeader.
     *
     * @return
     *     possible object is
     *     {@link OrderStructure.OrderHeader }
     *
     */
    public OrderStructure.OrderHeader getOrderHeader() {
        return orderHeader;
    }

    /**
     * Imposta il valore della proprietà orderHeader.
     *
     * @param value
     *     allowed object is
     *     {@link OrderStructure.OrderHeader }
     *
     */
    public void setOrderHeader(OrderStructure.OrderHeader value) {
        this.orderHeader = value;
    }

    /**
     * Recupera il valore della proprietà order.
     *
     * @return
     *     possible object is
     *     {@link OrderStructure.Order }
     *
     */
    public OrderStructure.Order getOrder() {
        return order;
    }

    /**
     * Imposta il valore della proprietà order.
     *
     * @param value
     *     allowed object is
     *     {@link OrderStructure.Order }
     *
     */
    public void setOrder(OrderStructure.Order value) {
        this.order = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     *
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="OrderLines">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="OrderLine" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="OrderLineNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                             &lt;element name="ItemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="ItemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="ItemQty" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                             &lt;element name="ItemPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "orderNumber",
        "orderLines"
    })
    public static class Order {

        @XmlElement(name = "OrderNumber")
        @XmlSchemaType(name = "unsignedByte")
        protected short orderNumber;
        @XmlElement(name = "OrderLines", required = true)
        protected OrderStructure.Order.OrderLines orderLines;

        /**
         * Recupera il valore della proprietà orderNumber.
         *
         */
        public short getOrderNumber() {
            return orderNumber;
        }

        /**
         * Imposta il valore della proprietà orderNumber.
         *
         */
        public void setOrderNumber(short value) {
            this.orderNumber = value;
        }

        /**
         * Recupera il valore della proprietà orderLines.
         *
         * @return
         *     possible object is
         *     {@link OrderStructure.Order.OrderLines }
         *
         */
        public OrderStructure.Order.OrderLines getOrderLines() {
            return orderLines;
        }

        /**
         * Imposta il valore della proprietà orderLines.
         *
         * @param value
         *     allowed object is
         *     {@link OrderStructure.Order.OrderLines }
         *
         */
        public void setOrderLines(OrderStructure.Order.OrderLines value) {
            this.orderLines = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         *
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="OrderLine" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="OrderLineNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *                   &lt;element name="ItemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="ItemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="ItemQty" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *                   &lt;element name="ItemPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "orderLine"
        })
        public static class OrderLines {

            @XmlElement(name = "OrderLine", required = true)
            protected List<OrderLine> orderLine;

            /**
             * Gets the value of the orderLine property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the orderLine property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOrderLine().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link OrderStructure.Order.OrderLines.OrderLine }
             *
             *
             */
            public List<OrderLine> getOrderLine() {
                if (orderLine == null) {
                    orderLine = new ArrayList<OrderLine>();
                }
                return this.orderLine;
            }


            /**
             * <p>Classe Java per anonymous complex type.
             *
             * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="OrderLineNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
             *         &lt;element name="ItemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ItemDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ItemQty" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
             *         &lt;element name="ItemPrice" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "orderLineNumber",
                "itemCode",
                "itemDescription",
                "itemQty",
                "itemPrice",
                "state"
            })
            public static class OrderLine {

                @XmlElement(name = "OrderLineNumber")
                @XmlSchemaType(name = "unsignedByte")
                protected short orderLineNumber;
                @XmlElement(name = "ItemCode", required = true)
                protected String itemCode;
                @XmlElement(name = "ItemDescription", required = true)
                protected String itemDescription;
                @XmlElement(name = "ItemQty")
                @XmlSchemaType(name = "unsignedByte")
                protected short itemQty;
                @XmlElement(name = "ItemPrice", required = true)
                protected String itemPrice;
                @XmlElement(required = true)
                protected String state;

                /**
                 * Recupera il valore della proprietà orderLineNumber.
                 *
                 */
                public short getOrderLineNumber() {
                    return orderLineNumber;
                }

                /**
                 * Imposta il valore della proprietà orderLineNumber.
                 *
                 */
                public void setOrderLineNumber(short value) {
                    this.orderLineNumber = value;
                }

                /**
                 * Recupera il valore della proprietà itemCode.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getItemCode() {
                    return itemCode;
                }

                /**
                 * Imposta il valore della proprietà itemCode.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setItemCode(String value) {
                    this.itemCode = value;
                }

                /**
                 * Recupera il valore della proprietà itemDescription.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getItemDescription() {
                    return itemDescription;
                }

                /**
                 * Imposta il valore della proprietà itemDescription.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setItemDescription(String value) {
                    this.itemDescription = value;
                }

                /**
                 * Recupera il valore della proprietà itemQty.
                 *
                 */
                public short getItemQty() {
                    return itemQty;
                }

                /**
                 * Imposta il valore della proprietà itemQty.
                 *
                 */
                public void setItemQty(short value) {
                    this.itemQty = value;
                }

                /**
                 * Recupera il valore della proprietà itemPrice.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getItemPrice() {
                    return itemPrice;
                }

                /**
                 * Imposta il valore della proprietà itemPrice.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setItemPrice(String value) {
                    this.itemPrice = value;
                }

                /**
                 * Recupera il valore della proprietà state.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getState() {
                    return state;
                }

                /**
                 * Imposta il valore della proprietà state.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setState(String value) {
                    this.state = value;
                }

            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     *
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CustomerId" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "customerId"
    })
    public static class OrderHeader {

        @XmlElement(name = "CustomerId")
        @XmlSchemaType(name = "unsignedByte")
        protected short customerId;

        /**
         * Recupera il valore della proprietà customerId.
         *
         */
        public short getCustomerId() {
            return customerId;
        }

        /**
         * Imposta il valore della proprietà customerId.
         *
         */
        public void setCustomerId(short value) {
            this.customerId = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     *
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Supplier" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="FornitoreId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "supplier"
    })
    public static class Suppliers {

        @XmlElement(name = "Supplier", required = true)
        protected List<Supplier> supplier;

        /**
         * Gets the value of the supplier property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the supplier property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSupplier().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OrderStructure.Suppliers.Supplier }
         *
         *
         */
        public List<Supplier> getSupplier() {
            if (supplier == null) {
                supplier = new ArrayList<Supplier>();
            }
            return this.supplier;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="FornitoreId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "fornitoreId"
        })
        public static class Supplier {

            @XmlElement(name = "FornitoreId")
            @XmlSchemaType(name = "unsignedShort")
            protected int fornitoreId;

            /**
             * Recupera il valore della proprietà fornitoreId.
             * 
             */
            public int getFornitoreId() {
                return fornitoreId;
            }

            /**
             * Imposta il valore della proprietà fornitoreId.
             * 
             */
            public void setFornitoreId(int value) {
                this.fornitoreId = value;
            }

        }

    }

}


package org.tempurl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="outpatient_getprescriptiondetailinfoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "outpatientGetprescriptiondetailinfoResult"
})
@XmlRootElement(name = "outpatient_getprescriptiondetailinfoResponse")
public class OutpatientGetprescriptiondetailinfoResponse {

    @XmlElement(name = "outpatient_getprescriptiondetailinfoResult")
    protected String outpatientGetprescriptiondetailinfoResult;

    /**
     * ��ȡoutpatientGetprescriptiondetailinfoResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpatientGetprescriptiondetailinfoResult() {
        return outpatientGetprescriptiondetailinfoResult;
    }

    /**
     * ����outpatientGetprescriptiondetailinfoResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpatientGetprescriptiondetailinfoResult(String value) {
        this.outpatientGetprescriptiondetailinfoResult = value;
    }

}

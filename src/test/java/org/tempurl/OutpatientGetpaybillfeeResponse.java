
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
 *         &lt;element name="outpatient_getpaybillfeeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "outpatientGetpaybillfeeResult"
})
@XmlRootElement(name = "outpatient_getpaybillfeeResponse")
public class OutpatientGetpaybillfeeResponse {

    @XmlElement(name = "outpatient_getpaybillfeeResult")
    protected String outpatientGetpaybillfeeResult;

    /**
     * ��ȡoutpatientGetpaybillfeeResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutpatientGetpaybillfeeResult() {
        return outpatientGetpaybillfeeResult;
    }

    /**
     * ����outpatientGetpaybillfeeResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutpatientGetpaybillfeeResult(String value) {
        this.outpatientGetpaybillfeeResult = value;
    }

}

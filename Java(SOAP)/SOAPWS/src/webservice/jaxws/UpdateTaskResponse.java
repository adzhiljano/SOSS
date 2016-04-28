
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "UpdateTaskResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateTaskResponse", namespace = "http://webservice/")
public class UpdateTaskResponse {

    @XmlElement(name = "return", namespace = "")
    private models.Task _return;

    /**
     * 
     * @return
     *     returns Task
     */
    public models.Task getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(models.Task _return) {
        this._return = _return;
    }

}


package webservice.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetTasksResponse", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTasksResponse", namespace = "http://webservice/")
public class GetTasksResponse {

    @XmlElement(name = "return", namespace = "")
    private List<models.Task> _return;

    /**
     * 
     * @return
     *     returns List<Task>
     */
    public List<models.Task> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<models.Task> _return) {
        this._return = _return;
    }

}

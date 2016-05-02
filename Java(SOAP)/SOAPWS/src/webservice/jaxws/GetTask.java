
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "GetTask", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTask", namespace = "http://webservice/")
public class GetTask {

    @XmlElement(name = "taskId", namespace = "http://webservice/")
    private int taskId;

    /**
     * 
     * @return
     *     returns int
     */
    public int getTaskId() {
        return this.taskId;
    }

    /**
     * 
     * @param taskId
     *     the value for the taskId property
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

}


package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CreateTask", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateTask", namespace = "http://webservice/")
public class CreateTask {

    @XmlElement(name = "arg0", namespace = "")
    private models.Task arg0;

    /**
     * 
     * @return
     *     returns Task
     */
    public models.Task getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(models.Task arg0) {
        this.arg0 = arg0;
    }

}

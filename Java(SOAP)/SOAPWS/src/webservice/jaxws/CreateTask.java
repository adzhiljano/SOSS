
package webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CreateTask", namespace = "http://webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateTask", namespace = "http://webservice/", propOrder = {
    "name",
    "priority",
    "description"
})
public class CreateTask {

    @XmlElement(name = "name", namespace = "http://webservice/")
    private String name;
    @XmlElement(name = "priority", namespace = "http://webservice/")
    private int priority;
    @XmlElement(name = "description", namespace = "http://webservice/")
    private String description;

    /**
     * 
     * @return
     *     returns String
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @param name
     *     the value for the name property
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * 
     * @param priority
     *     the value for the priority property
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * @param description
     *     the value for the description property
     */
    public void setDescription(String description) {
        this.description = description;
    }

}

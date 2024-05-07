package regobj;

import com.sun.nio.sctp.Association;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RegistryObjectList")
public class RegistryObjectList {
    @XmlElement(name = "RegistryPackage")
    private RegistryPackage registryPackage;
    @XmlElement(name = "ExtrinsicObject")
    private ExtrinsicObject extrinsicObject;
    @XmlElement(name = "Association")
    private Association association;
}

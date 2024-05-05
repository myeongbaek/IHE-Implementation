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
@XmlRootElement(name = "rim:RegistryObjectList")
public abstract class RegistryObjectList {
    @XmlElement(name = "rim:RegistryPackage")
    private RegistryPackage registryPackage;
    @XmlElement(name = "rim:ExtrinsicObject")
    private ExtrinsicObject extrinsicObject;
    @XmlElement(name = "rim:Association")
    private Association association;
}

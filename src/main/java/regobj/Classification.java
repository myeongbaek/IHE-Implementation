package regobj;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Classification extends RegistryObject{
    @XmlAttribute
    private String classificationScheme;
    @XmlAttribute
    private String classificationNode;
    @XmlAttribute
    private String classifiedObject;
    @XmlAttribute
    private String nodeRepresentation;
}

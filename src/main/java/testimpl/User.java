package testimpl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "User")
public class User {
    @XmlElement(name = "Header")
    private Header header;
    @XmlElement(name = "Body")
    private Body body;

    @Override
    public String toString() {
        return "User{" +
                "header.timestamp=" + header.getTimestamp() +
                ", body.username=" + body.getUserName() +
                '}';
    }
}

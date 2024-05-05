package testimpl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
    @XmlElement(name = "UserName")
    private List<String> userName;
    @XmlElement(name = "UserJob")
    private String userJob;
    @XmlElement(name = "UserBlog")
    private String userBlog;
}

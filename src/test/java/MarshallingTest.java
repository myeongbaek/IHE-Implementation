import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.junit.jupiter.api.Test;
import testimpl.Body;
import testimpl.Header;
import testimpl.User;

import java.io.StringWriter;
import java.util.Arrays;

public class MarshallingTest {

    @Test
    public void marshallingTest(){
        Header header = Header.builder().timestamp("2024-05-05").build();
        Body body = Body.builder().userName(Arrays.asList("1", "2")).userJob("Junior Deveoloper").userBlog("t-stroy").build();
        User userXml = User.builder().header(header).body(body).build();

        try {
            //	XML 변환[S]
            //	XML 파싱에 필요한 정보를 생성
            JAXBContext context = JAXBContext.newInstance(User.class);

            //	마샬링에 필요한 객체 생성
            Marshaller marshaller = context.createMarshaller();
            //	마샬링 옵션을 통해 XML 결과를 보기 좋게 출력
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(userXml, stringWriter);
            //	XML 변환[E]

            System.err.println(stringWriter.toString());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}

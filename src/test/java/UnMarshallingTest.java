import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.junit.jupiter.api.Test;
import testimpl.User;

import java.io.StringReader;

public class UnMarshallingTest {
    @Test
    public void unMarshallingTest(){


        try {
            //	XML 데이터
            String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<User>\n" +
                    "    <Header>\n" +
                    "        <TimeStamps>2024-05-05</TimeStamps>\n" +
                    "    </Header>\n" +
                    "    <Body>\n" +
                    "        <UserName>최명백</UserName>\n" +
                    "        <UserJob>Junior Deveoloper</UserJob>\n" +
                    "        <UserBlog>t-stroy</UserBlog>\n" +
                    "    </Body>\n" +
                    "</User>\n";

            //	JavaObject 변환[S]
            //	XML 파싱에 필요한 정보를 생성
            JAXBContext context = JAXBContext.newInstance(User.class);

            //	언마샬링에 필요한 객체 생성
            Unmarshaller unmarshaller = context.createUnmarshaller();

            User userXml = (User) unmarshaller.unmarshal(new StringReader(xmlStr));
            //	JavaObject 변환[E]

            System.err.println(userXml.toString());

        } catch (Exception e) {

        }

    }

}

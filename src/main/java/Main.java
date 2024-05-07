import impl.DocumentEntry;
import impl.RegistryObjectListImpl;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import regobj.Classification;
import regobj.RegistryObjectList;
import regobj.Slot;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{

        DocumentEntry extrinsicObject = new DocumentEntry();

        extrinsicObject.setId("ext-id");
        extrinsicObject.setMimeType("text");
        Slot slot1 = new Slot();
        slot1.setName("slot1");
        slot1.setValue(Arrays.asList("1", "2", "3", "4"));
        Slot slot2 = new Slot();
        slot2.setName("slot2");
        slot2.setValue(Arrays.asList("5", "6"));
        extrinsicObject.setSlot(Arrays.asList(slot1, slot2));
        Classification clasfi = new Classification();
        clasfi.setClassificationNode("node");
        clasfi.setClassificationScheme("scheme");
        Classification clasfi2 = new Classification();
        clasfi2.setClassificationNode("node");
        clasfi2.setClassificationScheme("scheme");
        extrinsicObject.setClassification(Arrays.asList(clasfi, clasfi2));

        RegistryObjectListImpl regObjListXml = new RegistryObjectListImpl();
        regObjListXml.setExtrinsicObject(extrinsicObject);

        String xml;

        try {
            JAXBContext context = JAXBContext.newInstance(RegistryObjectListImpl.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();

            marshaller.marshal(regObjListXml, stringWriter);

            System.err.println(stringWriter);
            xml = stringWriter.toString();

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        unMarshallingTest(xml);


    }

    public static void unMarshallingTest(String xmlStr)throws Exception{


                  //	JavaObject 변환[S]
            //	XML 파싱에 필요한 정보를 생성
            JAXBContext context = JAXBContext.newInstance(RegistryObjectListImpl.class);

            //	언마샬링에 필요한 객체 생성
            Unmarshaller unmarshaller = context.createUnmarshaller();

        RegistryObjectList userXml = (RegistryObjectList) unmarshaller.unmarshal(new StringReader(xmlStr));
            //	JavaObject 변환[E]

            System.err.println(userXml.getExtrinsicObject().getSlot().get(0).getValue().get(0));

    }
}

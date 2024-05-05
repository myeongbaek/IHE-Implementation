import impl.DocumentEntry;
import impl.RegistryObjectListImpl;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import regobj.Classification;
import regobj.Slot;

import java.io.StringWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

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

        try {
            JAXBContext context = JAXBContext.newInstance(RegistryObjectListImpl.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();

            marshaller.marshal(regObjListXml, stringWriter);

            System.err.println(stringWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}

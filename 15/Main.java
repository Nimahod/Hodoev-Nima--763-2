import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            
            File xmlFile = new File("tariffs.xml");
            File xsltFile = new File("transform.xsl");

            Source xmlSource = new StreamSource(xmlFile);
            Source xsltSource = new StreamSource(xsltFile);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(xsltSource);

            Result result = new StreamResult(new File("tariffs.html"));

            transformer.transform(xmlSource, result);

            System.out.println("Трансформация завершилась успешно.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
1. Создать файл XML и соответствующую ему схему XSD.
2. При разработке XSD использовать простые и комплексные типы, перечисления, шаблоны и предельные значения.
3. Сгенерировать класс, соответствующий данному описанию.
4. Создать приложение для разбора XML-документа и инициализации коллекции объектов информацией из XML-файла. Для разбора использовать
SAX, DOM и StAX-парсеры. Для сортировки объектов использовать интерфейс Comparator.
5. Произвести проверку XML-документа с привлечением XSD.
6. Определить метод, производящий преобразование разработанного XMLдокумента в документ, указанный в каждом задании.

3. Тарифы мобильных компаний.
Тарифы мобильных компаний могут иметь следующую структуру:
— Name — название тарифа;
— Operator name — название сотового оператора, которому принадлежит
тариф;
— Payroll — абонентская плата в месяц (0–n рублей);
— Сall prices (должно быть несколько) — цены на звонки: внутри сети (0–n
рублей в минуту), вне сети (0–n рублей в минуту), на стационарные телефоны (0–n рублей в минуту);
— SMS price — цена за смс (0–n рублей);
— Parameters (должно быть несколько) — наличие любимого номера (0–n),
тарификация (12-секундная, поминутная), плата за подключение к тарифу (0–n рублей).
Корневой элемент назвать Tariff.
С помощью XSL преобразовать XML-файл в формат НTML, при выводе
отсортировать тарифы по абонентской плате.
*/

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

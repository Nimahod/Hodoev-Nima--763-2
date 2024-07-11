/*21. Электроинструменты. Возможности: создать модель инструмента; ввести
характеристики инструмента; добавить/изменить комплектующие; рассчитать стоимость производства; добавить чертежи; отправить на доработку;
отказать в производстве; запустить в производство; отправить на тестирование; получить результаты тестов. Добавить специализированные методы
для Пиление, Резка, Обработка дерева, Сверление отверстий*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    @SuppressWarnings("null")
	public static void main(String[] args) {
       tool powersaw = new tool("SHTIL-240");
       powersaw.addAcces("Пила");
       powersaw.addAcces("Мотор");
       powersaw.setPlan("Пила + мотор = электропила");
       powersaw.addCharac("Длина пилы 90 см ", 1.0);
       powersaw.addCharac("Мотор 90 кубов мощности", 2.0);
       powersaw.editAcces(2, "Новый мотор");
       powersaw.sentTest("Не работает!");
       powersaw.getTestResult();
       powersaw.revision();
       powersaw.sentTest("Исправно!");
       powersaw.getTestResult();
       powersaw.setCost(12300);
       powersaw.calculateCostVolume(50);
       powersaw.sawing();
       powersaw.startProd();
       
       }
}

class tool {
    private String model;
    private Map<String, Double> charac;
    private List<String> accessories;
    private double cost;
    private String plan;
    private boolean prod;
    private boolean test;
    private String resultTest;

    public tool (String model) {
        this.model = model;
        this.charac = new HashMap<>();
        this.accessories = new ArrayList<>();
        this.prod = false;
        this.test = false;
    }

    public void addCharac(String название, Double значение) {
        charac.put(название, значение);
    }

    public void addAcces(String компонент) {
    	accessories.add(компонент);
    }

    public void editAcces(int index, String новыйКомпонент) {
        if (index >= 0 && index < accessories.size()) {
        	accessories.set(index, новыйКомпонент);
        }
    }
    
    public void setCost(double Cost) {
    	this.cost = Cost;
    }

    public void calculateCostVolume(int volume) {
        double result = volume * cost;
        System.out.println("Стоимость производства " + volume + " штук: " + result);
    }

    public void setPlan(String Plan) {
        this.plan = Plan;
    }

    public void revision() {
    	System.out.println("Отправлено на доработку");
    }

    public void stopProd() {
        prod = false;
    }

    public void startProd() {
        prod = true;
    }

    public void sentTest(String result) {
        test = true;
        resultTest = result;
    }

    public void getTestResult() {
        test = false;
        System.out.println("Результат теста: " + resultTest);
       
    }

    
    public void sawing() {
    	System.out.println("Инструмент пилит");
    }

    public void cutting() {
    	System.out.println("Инструмент режит");
    }

    public void woodProsesing() {
    	System.out.println("Инструмент обрабатывает дерево");
    }

    public void drilling() {
    	System.out.println("Инструмент сверлит отверстие");
    }
}

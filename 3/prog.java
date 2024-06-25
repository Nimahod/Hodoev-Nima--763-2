package practic;
/*
Вариант А
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString(). Определить дополнительно
методы в классе, создающем массив объектов. Задать критерий выбора данных
и вывести эти данные на консоль. В каждом классе, обладающем информацией,
должно быть объявлено несколько конструкторов.

3. Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской
карты, Диагноз.
Создать массив объектов. Вывести:
a) список пациентов, имеющих данный диагноз;
b) список пациентов, номер медицинской карты которых находится в заданном интервале
*/
import java.util.ArrayList;
import java.util.List;

class prog{
    public static void main(String[] args) {
        Patient[] patients = new Patient[2];
        patients[0] = new Patient(1, "Бадмажапов", "Бадмажап", "Бадмажапович", "ул. Неизвестная, д.1", "+89834512121", "222222", "Гастрит");

        patients[1] = new Patient(2, "Петров", "Петя", "Петрович", "ул. Тамошняя, д.2", "+79834567890", "555555", "Туберкулёз");

        Patient.diagnose_find(patients, "Туберкулёз");
        Patient.medic_book_find(patients, 220000, 300000);
    }
}
class Patient {
    int id;
    String surname;
    String name;
    String surname1;
    String address;
    String telephone;
    String medic_book;
    String diagnose;

    public Patient(int id, String surname, String name, String surname1, String address, String telephone, String medic_book, String diagnose){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.surname1 = surname1;
        this.address = address;
        this.telephone = telephone;
        this.medic_book = medic_book;
        this.diagnose = diagnose;
    }
    public static void  diagnose_find(Patient[] patients, String diagnose){
        System.out.println("Диагноз пациента: " + diagnose);
        for(Patient patient : patients){
            if (patient.diagnose.equals(diagnose)){
                System.out.println("Пациент: " + patient.name + " " + patient.surname);
            }
        }
    }
    public static void medic_book_find(Patient[] patients, int StartRange, int endRange){
        System.out.println("Номер медицинской карты пациента находящится в интервале: " + StartRange + " " + endRange);
        int count = 0;
        for (Patient patient : patients) {
            int medic_book = Integer.parseInt(patient.medic_book);
            if (medic_book >= StartRange && medic_book <= endRange) {
                System.out.println(patient.name + " " + patient.surname + " номер карты: " + patient.medic_book);
                count++;
            }
        }
        System.out.print("Всего найдено: " + count);
    }
}

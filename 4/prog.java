/*
Создать приложение, удовлетворяющее требованиям, приведенным в задании. Наследование применять только в тех заданиях, в которых это логически
обосновано. Аргументировать принадлежность классу каждого создаваемого
метода и корректно переопределить для каждого класса методы equals(),
hashCode(), toString().
21. Создать объект класса Сутки, используя классы Час, Минута. Методы: вывести на консоль текущее время, рассчитать время суток (утро, день, вечер, ночь).
*/



package practic;

class Hour {
    private int hours;

    public Hour(int hours) {
        this.hours = hours % 24; // Убедимся, что часы в пределах 0-23
    }

    public int getHours() {
        return hours;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hour hour = (Hour) o;
        return hours == hour.hours;
    }

    public int hashCode() {
        return hours;
    }

    public String toString() {
        return String.format("%02d", hours);
    }
}

class Minute {
    private int minutes;

    public Minute(int minutes) {
        this.minutes = minutes % 60; // Убедимся, что минуты в пределах 0-59
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minute minute = (Minute) o;
        return minutes == minute.minutes;
    }

    public int hashCode() {
        return minutes;
    }

    public String toString() {
        return String.format("%02d", minutes);
    }
}

class Day {
    private Hour hour;
    private Minute minute;

    public Day(int hour, int minute) {
        this.hour = new Hour(hour);
        this.minute = new Minute(minute);
    }

    public void printCurrentTime() {
        System.out.println("Текущее время: " + hour + ":" + minute);
    }

    public void calculatePartOfDay() {
        int h = hour.getHours();
        if (h >= 6 && h < 12) {
            System.out.println("Утро");
        } else if (h >= 12 && h < 18) {
            System.out.println("День");
        } else if (h >= 18 && h < 24) {
            System.out.println("Вечер");
        } else {
            System.out.println("Ночь");
        }
    }
}

public class prog {
    public static void main(String[] args) {
        Day day = new Day(24, 30); 
        day.printCurrentTime();
        day.calculatePartOfDay();
    }
}

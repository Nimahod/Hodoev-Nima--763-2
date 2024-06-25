/*Задания к главе 5
Вариант А
1. Создать класс Notepad с внутренним классом или классами, с помощью
объектов которого могут храниться несколько записей на одну дату.
2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров.
3. Создать класс Account с внутренним классом, с помощью объектов которого можно хранить информацию обо всех операциях со счетом (снятие, платежи, поступления).
*/

package practic;

import java.util.ArrayList;
import java.util.Date;

class Account {
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("поступление", amount));
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("снятие", amount));
        } else {
            System.out.println("Недостаточно средств на счете.");
        }
    }

    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    private class Transaction {
        private String type;
        private double amount;
        private Date date;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.date = new Date(); // текущая дата и время
        }

        @Override
        public String toString() {
            return "Тип операции: " + type + ", Сумма: " + amount + ", Дата: " + date.toString();
        }
    }
}

public class prog {
    public static void main(String[] args) {
        // Создание нового счета
        Account myAccount = new Account("123456789");

        // Проведение операций со счетом
        myAccount.deposit(1000); // Поступление
        myAccount.withdraw(500); // Снятие
        myAccount.deposit(1500); // Поступление
        myAccount.withdraw(700); // Снятие

        // Вывод информации обо всех операциях
        myAccount.printTransactions();
    }
}

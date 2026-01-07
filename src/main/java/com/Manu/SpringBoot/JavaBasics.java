package com.Manu.SpringBoot;

public class JavaBasics {

    public static void main(String[] args) {

        Car car = new Car("Honda", 2024);
        car.drive();

        Customer customer = new Customer("C101", "Manu");
        Account account = new Account("ACC001", 5000);
        account.credit(1000);
        account.debit(500);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Balance: " + account.getBalance());

        Wallet wallet = new Wallet();
        wallet.add(200);
        System.out.println("Wallet balance = " + wallet.getBalance());

        Bike bike = new Bike();
        bike.start();
        bike.ride();

        Notification n = new EmailNotification();
        n.send();
        n = new SmsNotification();
        n.send();

        Payment payment = new UpiPayment();
        payment.process();

        Repository repo = new UserRepository();
        repo.save();

        BaseService service = new OrderService();
        service.execute();

        java.util.List<String> names = new java.util.ArrayList<>();
        names.add("A");
        names.add("B");

        java.util.Set<Integer> ids = new java.util.HashSet<>();
        ids.add(1);
        ids.add(1); // duplicate will be ignored

        java.util.Map<String, Integer> scores = new java.util.HashMap<>();
        scores.put("math", 95);
        scores.put("cs", 99);

        System.out.println("Names = " + names);
        System.out.println("Ids   = " + ids);
        System.out.println("Scores = " + scores);

        // ============================
        // 9) EXCEPTION HANDLING
        // ============================
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Exception demo done");
        }

        // ============================
        // 10) JAVA 8 — LAMBDA & STREAM
        // ============================
        java.util.List<Integer> nums = java.util.Arrays.asList(1, 2, 3, 4, 5);

        // Lambda
        nums.forEach(n1 -> System.out.println("Number: " + n1));

        // Stream
        nums.stream()
                .filter(n1 -> n1 % 2 == 0)
                .map(n1 -> n1 * n1)
                .forEach(System.out::println);
    }
}



// ===================================
// Supporting classes
// ===================================

// BASICS
class Car {
    String brand;
    int year;

    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    void drive() {
        System.out.println(brand + " is driving");
    }
}

// DOMAIN
class Customer {
    private String id;
    private String name;

    Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
}

class Account {
    private String number;
    private double balance;

    Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public void credit(double amount) { balance += amount; }
    public void debit(double amount) { balance -= amount; }
    public double getBalance() { return balance; }
}

// ENCAPSULATION
class Wallet {
    private double balance;

    public void add(double amount) {
        if (amount > 0) balance += amount;
    }

    public double getBalance() { return balance; }
}

// INHERITANCE
class Vehicle {
    void start() { System.out.println("Vehicle starting..."); }
}

class Bike extends Vehicle {
    void ride() { System.out.println("Bike riding..."); }
}

// POLYMORPHISM
class Notification {
    void send() {}
}

class EmailNotification extends Notification {
    void send() { System.out.println("Email sent"); }
}

class SmsNotification extends Notification {
    void send() { System.out.println("SMS sent"); }
}

// ABSTRACTION
abstract class Payment {
    abstract void process();
}

class UpiPayment extends Payment {
    void process() { System.out.println("UPI payment processing"); }
}

// INTERFACE
interface Repository {
    void save();
}

class UserRepository implements Repository {
    public void save() {
        System.out.println("User saved");
    }
}

// ABSTRACT CLASS
abstract class BaseService {
    void log() { System.out.println("logging..."); }
    abstract void execute();
}

class OrderService extends BaseService {
    void execute() {
        log();
        System.out.println("order executed");
    }
}

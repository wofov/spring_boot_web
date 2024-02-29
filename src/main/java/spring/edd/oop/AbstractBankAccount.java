package spring.edd.oop;

public abstract class AbstractBankAccount {
    protected String accountHolder;
    protected double balance;

    public AbstractBankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // 추상 메서드: 하위 클래스에서 반드시 구현해야 함
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public void checkBalance() {
        System.out.println(accountHolder + "님의 현재 잔액: " + balance + "원");
    }
}

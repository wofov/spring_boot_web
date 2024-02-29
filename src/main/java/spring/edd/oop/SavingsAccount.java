package spring.edd.oop;

public class SavingsAccount extends AbstractBankAccount implements InterestBearing{
    private double interestRate;

    public SavingsAccount(String accountHolder, double initialBalance, double interestRate) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolder + "님의 적금계좌에 " + amount + "원을 입금하였습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("입금 금액은 0보다 커야 합니다.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + "님의 적금계좌에서 " + amount + "원을 출금하였습니다. 현재 잔액: " + balance + "원");
        } else {
            System.out.println("출금 금액은 0보다 크고 현재 잔액보다 작아야 합니다.");
        }
    }

    @Override
    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println(accountHolder + "님의 적금에 이자가 지급되었습니다. 현재 잔액: " + balance + "원");
    }
}

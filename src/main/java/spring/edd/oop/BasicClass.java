package spring.edd.oop;

public class BasicClass {

    public void test() {
        // 추상화 클래스와 인터페이스를 사용한 다형성
        AbstractBankAccount mySavingsAccount = new SavingsAccount("홍길동", 100000, 0.05);

        // 다형성을 활용하여 메서드 호출
        mySavingsAccount.deposit(50000);
        mySavingsAccount.withdraw(20000);
        mySavingsAccount.checkBalance();

        // 인터페이스 메서드 호출
        if (mySavingsAccount instanceof InterestBearing) {
            ((InterestBearing) mySavingsAccount).addInterest();
        }

        mySavingsAccount.checkBalance();
    }

}

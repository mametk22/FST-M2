package examples;
import examples.NotEnoughFundsException;

public class BankAccount {
    private Integer balance;
    public BankAccount(Integer initialBalance) {

        balance = initialBalance;

    }
    public Integer withdraw(Integer amount) throws NotEnoughFundsException {

        if (balance < amount) {
            throw new NotEnoughFundsException(amount, balance);
        }
        balance -= amount;
        return balance;
    }
}

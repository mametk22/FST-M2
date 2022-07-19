package examples;

public class NotEnoughFundsException extends Throwable {

    public NotEnoughFundsException(Integer amount, Integer balance) {

        System.out.println("Attempted to withdraw " + amount + " with a balance of " + balance);

    }
}

package examples;

import org.junit.jupiter.api.Test;
import examples.BankAccount;
import examples.NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;

class ExpectedExceptionTest {

    @Test
    void notEnoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(9);


    }

    private void assertThrows(Class<NotEnoughFundsException> notEnoughFundsExceptionClass, Object o, String s) {
    }

    @Test
    void enoughFunds() {
        // Create an object for BankAccount class
        BankAccount account = new BankAccount(100);

        // Assertion for no exceptions
        assertDoesNotThrow(() -> account.withdraw(100));
    }
}

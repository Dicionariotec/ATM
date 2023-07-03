package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domain.Transaction.TransactionInsertInputValidation;
import domain.Transaction.TransactionType;

public class TransactionTest {
    @Test
    public void transactionRefusesLettersWithdrawal() {
        byte withdrawalType = (byte)TransactionType.WITHDRAWAL.index;
        
        Exception exception = assertThrows(Exception.class, () ->
            TransactionInsertInputValidation.validate("1", "aa", withdrawalType)
        );
        assertEquals("Quantidade deve ter apenas numeros", exception.getMessage());
    }

    @Test
    public void transactionRefusesLettersDeposit() {
        byte depositType = (byte)TransactionType.DEPOSIT.index;

        Exception exception = assertThrows(Exception.class, () ->
            TransactionInsertInputValidation.validate("1", "1a2", depositType)
        );
        assertEquals("Quantidade deve ter apenas numeros", exception.getMessage());
    }

    @Test
    public void transactionMaximum() {
        byte depositType = (byte)TransactionType.DEPOSIT.index;

        Exception exception = assertThrows(Exception.class, () ->
            TransactionInsertInputValidation.validate("1000", "10000", depositType)
        );
        assertEquals("Quantidade deve ser maior do que zero e menor do que 9999", exception.getMessage());
    }

    @Test
    public void transactionWithdrawalTooMuch() {
        byte withdrawalType = (byte)TransactionType.WITHDRAWAL.index;
        
        Exception exception = assertThrows(Exception.class, () ->
            TransactionInsertInputValidation.validate("1000", "1001", withdrawalType)
        );
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    public void transactionDeposit() {
        byte depositType = (byte)TransactionType.DEPOSIT.index;

        try {
            TransactionInsertInputValidation.validate("1500", "500", depositType);
        } catch (Exception e) {
            assertTrue(false);
        }

        assertTrue(true);
    }

    @Test
    public void transactionWithdrawal() {
        byte withdrawalType = (byte)TransactionType.WITHDRAWAL.index;

        try {
            TransactionInsertInputValidation.validate("1500", "1500", withdrawalType);
        } catch (Exception e) {
            assertTrue(false);
        }

        assertTrue(true);
    }
}

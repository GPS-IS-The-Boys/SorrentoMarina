package theboys.sorrentomarina.managers;

import java.sql.SQLException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import theboys.sorrentomarina.models.Account;

/**
 * @author Diequ
 */
public class TableAccountManagerTest extends IntegrationTestCase {

  @Test
  public void testFindAccount() throws SQLException {
    TableAccountManager tam = new TableAccountManager(mockDb);
    Optional<Account> optAccount = tam.findAccount("diego@mail.it", "qwerty");
    assertTrue(optAccount.isPresent(), "It should find the account");
  }
}

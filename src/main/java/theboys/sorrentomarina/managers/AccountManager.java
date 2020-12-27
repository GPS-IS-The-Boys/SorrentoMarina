package theboys.sorrentomarina.managers;

import java.sql.SQLException;
import java.util.Optional;

import theboys.sorrentomarina.models.Account;

/**
 * @author Diequ
 */
public interface AccountManager {

  Optional<Account> findAccount(String email, String password) throws SQLException;

  Account createAccount(Account account) throws SQLException;
}

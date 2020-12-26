package theboys.sorrentomarina.managers;

import java.sql.SQLException;
import java.util.Optional;
import javax.sql.DataSource;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import theboys.sorrentomarina.models.Account;

/**
 * @author Diequ
 */
public class TableAccountManager extends TableManager implements AccountManager {

  private static final ResultSetHandler<Account> ACC_MAPPER =
      new BeanHandler<>(Account.class);

  public TableAccountManager(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public Optional<Account> findAccount(String email, String password)
      throws SQLException {
    Account optAccount = runner.query("SELECT id, email, roleId FROM accounts WHERE email=? AND password=?",
        ACC_MAPPER, email, password);
    return Optional.ofNullable(optAccount);
  }

  @Override
  public Account createAccount(Account account) throws SQLException {
    return null;
  }

}

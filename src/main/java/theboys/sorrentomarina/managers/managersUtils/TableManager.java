package theboys.sorrentomarina.managers.managersUtils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

/**
 * @author theboys
 */
public abstract class TableManager {

  protected final QueryRunner runner;

  public TableManager(DataSource dataSource) {
    this.runner = new QueryRunner(dataSource);
  }
}

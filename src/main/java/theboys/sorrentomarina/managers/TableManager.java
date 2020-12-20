package theboys.sorrentomarina.managers;

import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author Diequ
 */
public abstract class TableManager {
    
    protected final QueryRunner runner;

    public TableManager(DataSource dataSource) {
        this.runner = new QueryRunner(dataSource);
    }
}

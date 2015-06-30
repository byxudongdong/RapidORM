package com.wangjie.rapidorm.core.generate.statement;

import com.wangjie.rapidorm.core.config.ColumnConfig;
import com.wangjie.rapidorm.core.config.TableConfig;
import com.wangjie.rapidorm.core.generate.statement.util.SqlUtil;

import java.util.List;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/30/15.
 */
public class InsertStatement<T> extends Statement<T> {
    public InsertStatement(TableConfig<T> tableConfig) {
        super(tableConfig);
    }

    @Override
    protected String generateStatement() {
        List<ColumnConfig> insertColumns = getInsertColumnConfigs(tableConfig);
        StringBuilder builder = new StringBuilder(" INSERT INTO ");
        builder.append(tableConfig.getTableName()).append(" (");
        SqlUtil.appendColumns(builder, insertColumns);
        builder.append(") VALUES (");
        SqlUtil.appendPlaceholders(builder, insertColumns.size());
        builder.append(')');
        return builder.toString();
    }


    public List<ColumnConfig> getInsertColumnConfigs(TableConfig<T> tableConfig) {
        List<ColumnConfig> insertColumns;
        List<ColumnConfig> pkColumnConfigs = tableConfig.getPkColumnConfigs();
        ColumnConfig firstPkColumnConfig;
        if (
                1 == pkColumnConfigs.size()
                        && (firstPkColumnConfig = pkColumnConfigs.get(0)).isPrimaryKey()
                        && firstPkColumnConfig.isAutoincrement()
                ) {
            insertColumns = tableConfig.getNoPkColumnConfigs();
        } else {
            insertColumns = tableConfig.getAllColumnConfigs();
        }
        return insertColumns;
    }

}

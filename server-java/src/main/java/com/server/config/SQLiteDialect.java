package com.server.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.StringType;

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
        registerColumnType(Types.VARCHAR, "text");
        registerColumnType(Types.BIT, "integer");
        registerColumnType(Types.TINYINT, "integer");
        registerColumnType(Types.SMALLINT, "integer");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "integer");
        registerColumnType(Types.REAL, "real");
        registerColumnType(Types.FLOAT, "real");
        registerColumnType(Types.DOUBLE, "real");
        registerColumnType(Types.NUMERIC, "numeric");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CHAR, "char");
        registerColumnType(Types.TIMESTAMP, "datetime");
        registerColumnType(Types.CLOB, "text");

        registerFunction("concat", new VarArgsSQLFunction(StringType.INSTANCE, "", "||", ""));
        registerFunction("mod", new SQLFunctionTemplate(StringType.INSTANCE, "?1 % ?2"));
        registerFunction("substr", new StandardSQLFunction("substr", StringType.INSTANCE));
        registerFunction("length", new StandardSQLFunction("length", StringType.INSTANCE));
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }
}

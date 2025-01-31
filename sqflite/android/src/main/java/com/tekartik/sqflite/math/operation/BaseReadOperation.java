package com.tekartik.sqflite.math.operation;

import com.tekartik.sqflite.math.SqlCommand;

import java.util.List;

import static com.tekartik.sqflite.math.Constant.PARAM_CONTINUE_OR_ERROR;
import static com.tekartik.sqflite.math.Constant.PARAM_NO_RESULT;
import static com.tekartik.sqflite.math.Constant.PARAM_SQL;
import static com.tekartik.sqflite.math.Constant.PARAM_SQL_ARGUMENTS;

/**
 * Created by alex on 09/01/18.
 */

public abstract class BaseReadOperation implements Operation {
    private String getSql() {
        return getArgument(PARAM_SQL);
    }

    private List<Object> getSqlArguments() {
        return getArgument(PARAM_SQL_ARGUMENTS);
    }

    public SqlCommand getSqlCommand() {
        return new SqlCommand(getSql(), getSqlArguments());
    }

    @Override
    public boolean getNoResult() {
        return Boolean.TRUE.equals(getArgument(PARAM_NO_RESULT));
    }

    @Override
    public boolean getContinueOnError() {
        return Boolean.TRUE.equals(getArgument(PARAM_CONTINUE_OR_ERROR));
    }


    // We actually have an inner object that does the implementation
    protected abstract OperationResult getOperationResult();

}

package com.wangjie.rapidorm.compiler.constants;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 3/18/16.
 */
public class GuessClass {

    public static final String BASE_TABLE_CONFIG = "com.wangjie.rapidorm.core.config.TableConfig";

    public static final String CURSOR = "android.database.Cursor";

    public static final String COLUMN_CONFIG = "com.wangjie.rapidorm.core.config.ColumnConfig";



    public static class ModelProperty {
//        public static final String CLASS_NAME = "com.wangjie.rapidorm.core.generate.withoutreflection.IModelProperty";

        public static final String METHOD_NAME_BIND_INSERT_ARGS = "bindInsertArgs";

        public static final String METHOD_NAME_BIND_UPDATE_ARGS = "bindUpdateArgs";

        public static final String METHOD_NAME_BIND_PK_ARGS = "bindPkArgs";

        public static final String METHOD_NAME_PARSE_FROM_CURSOR = "parseFromCursor";


    }


}

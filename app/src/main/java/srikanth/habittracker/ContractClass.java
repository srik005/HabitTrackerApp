package srikanth.habittracker;

import android.provider.BaseColumns;

/**
 * Created by E6420 on 8/12/2016.
 */
public class ContractClass {

    public ContractClass() {
    }
    public static abstract class DbInfo{
        public static final String DBNAME="HabitTracker";
        public static final int DBVERSION=1;
    }
    public static abstract class DbUser implements BaseColumns{
        public static final String TABLE_NAME ="habit_tracker";
        public static final String NAME="user_name";
        public static final String ID="_ID";
        public static final String SALARY="salary";
        public static final String DROP_TABLE="DROP TABLE IF EXISTS";
    }
}

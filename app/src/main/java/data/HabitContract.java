package data;

import android.provider.BaseColumns;

/**
 * Created by Rob on 10/28/2016.
 */

public final class HabitContract {
    private HabitContract(){}

    public static class HabitEntry implements BaseColumns{
        public static final String TABLE_NAME="habits";

        public static final String _ID=BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME="name";
        public static final String COLUMN_HABIT_DATE="date";
        public static final String COLUMN_HABIT_TIME="time";
    }
}

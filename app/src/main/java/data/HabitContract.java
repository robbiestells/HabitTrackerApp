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

        //name of the habit, ie Working Out
        public static final String COLUMN_HABIT_NAME="name";

        //date of the entry, ie January 1, 2017
        public static final String COLUMN_HABIT_DATE="date";

        //time in minutes, ie 30 minutes
        public static final String COLUMN_HABIT_TIME="time";
    }
}

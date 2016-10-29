package data;

import android.provider.BaseColumns;

/**
 * Created by Rob on 10/28/2016.
 */

public final class HabitContract {
    //An empty private constructor makes sure that the class is not going to be initialised.
    private HabitContract(){}

    public static class HabitEntry implements BaseColumns{
        public static final String TABLE_NAME="habits";

        //name of the habit, ie Working Out
        public static final String COLUMN_HABIT_NAME="name";

        //date of the entry, ie January 1, 2017
        public static final String COLUMN_HABIT_DATE="date";

        //time in minutes, ie 30 minutes
        public static final String COLUMN_HABIT_TIME="time";
    }
}

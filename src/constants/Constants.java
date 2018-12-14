package constants;

public final class Constants {
    //    private static final String DATA_PATH = "C:\\Users\\dauut\\Desktop\\0";
//        private static final String DATA_PATH = "C:\\Users\\dauut\\Desktop\\1";
//    private static final String DATA_PATH = "C:\\Users\\dauut\\Desktop\\2";
//    private static final String DATA_PATH = "C:\\Users\\dauut\\Desktop\\3";
//    private static final String DATA_PATH = "C:\\Users\\dauut\\Desktop\\cn_data\\0";
//    private static final String DATA_PATH = "C:\\Users\\dauut\\Desktop\\cn_data\\face_data";
    private static final String DATA_PATH = "C:\\Users\\dauut\\Desktop\\cn_data\\new_users1";
//    private static final String DATA_PATH = "C:\\Users\\dauut\\Desktop\\face_data";

    private static final String STATS_OUTPUT_PATH = "C:\\Users\\dauut\\Desktop\\stats_output\\";
    private static final String NEW_DATA_PATH = "C:\\\\Users\\\\dauut\\\\Desktop\\\\new_users\\\\";

    private static final String SIMULATION_START_DATE = "06/03/2014 12:01:00 am";
    private static final String SIMULATION_END_DATE = "06/04/2014 12:01:00 Pm";

    public static String getSimulationStartDate() {
        return SIMULATION_START_DATE;
    }

    public static String getSimulationEndDate() {
        return SIMULATION_END_DATE;
    }

    public static String getDataPath() {
        return DATA_PATH;
    }

    public static String getStatsOutputPath() {
        return STATS_OUTPUT_PATH;
    }

    public static String getNewDataPath() {
        return NEW_DATA_PATH;
    }
}
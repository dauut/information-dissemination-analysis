package constants;

public class GenerationConstants {

    private static final long AMOUNT_OF_NEW_USER_ID = 20000;
    private static final int MAXIMUM_NEW_FRIENDS_NUMER = 650;
    private static final String SIMULATION_START_DATE = "05/28/2014 12:01:00 am";
    private static final String SIMULATION_END_DATE = "06/11/2014 11:59:00 Pm";
    private static final String DATA_OUTPUT_PATH = "C:\\Users\\dauut\\Desktop\\cn_data\\new_users\\";

    public static String getMainDataPath() {
        return MAIN_DATA_PATH;
    }

    private static final String MAIN_DATA_PATH = "C:\\Users\\dauut\\Desktop\\cn_data\\face_data";

    public static long getAmountOfNewUserId() {
        return AMOUNT_OF_NEW_USER_ID;
    }

    public static String getDataOutputPath() {
        return DATA_OUTPUT_PATH;
    }

    public static String getSimulationStartDate() {
        return SIMULATION_START_DATE;
    }

    public static String getSimulationEndDate() {
        return SIMULATION_END_DATE;
    }

    public static int getMaximumNewFriendsNumer() {
        return MAXIMUM_NEW_FRIENDS_NUMER;
    }
}

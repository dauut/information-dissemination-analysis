package constants;

public class GenerationConstants {

    private static final long AMOUNT_OF_NEW_USER_ID = 20000;
    private static final int MAXIMUM_NEW_FRIENDS_NUMER = 100;
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


    public static int getMaximumNewFriendsNumer() {
        return MAXIMUM_NEW_FRIENDS_NUMER;
    }
}

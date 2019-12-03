package app;

/**
 * User
 */
public class User {
    private String userName = "";
    private int indexPos = -1;
    private static int userCount = 0;

    public User() {

        userCount++;
    }

    /**
     * @return the userCount
     */
    public static int getUserCount() {
        return userCount;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the indexPos
     */
    public int getIndexPos() {
        return indexPos;
    }

    @Override
    public String toString() {
        return userName + ", " + indexPos + ", " + userCount;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
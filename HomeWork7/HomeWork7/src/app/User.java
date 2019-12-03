/**
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

/**
 * User
 */
public class User {
    private String userName = "";
    private int indexPos = -1;
    private static int userCount = 0;

    public User(String userName) {
        this.userName = userName;
        userCount++;
        indexPos++;
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
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
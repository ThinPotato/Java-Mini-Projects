/**
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

import java.util.Comparator;

/**
 * FollowersComparator
 */
public class FollowersComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        User u1 = (User) o1;
        User u2 = (User) o2;
        if (FollowGraphDriver.graph.getFollowerCount(u1.toString()) == FollowGraphDriver.graph
                .getFollowerCount(u2.toString()))
            return 0;
        else if (FollowGraphDriver.graph.getFollowerCount(u1.toString()) > FollowGraphDriver.graph
                .getFollowerCount(u2.toString()))
            return 1;
        else
            return 0;
    }

}
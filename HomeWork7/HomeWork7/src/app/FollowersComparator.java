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
        if (u1.getFollowCount() == u2.getFollowCount())
            return 0;
        else if (u1.getFollowCount() > u2.getFollowCount())
            return 1;
        else
            return 0;
    }

}
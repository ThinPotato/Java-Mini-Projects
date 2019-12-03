package app;

import java.util.Comparator;

/**
 * FollowingComparator
 */
public class FollowingComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        User u1 = (User) o1;
        User u2 = (User) o2;
        if (u1.getFollowingCount() == u2.getFollowingCount())
            return 0;
        else if (u1.getFollowingCount() > u2.getFollowingCount())
            return 1;
        else
            return 0;
    }
    }
}
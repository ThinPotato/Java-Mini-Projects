package app;

import java.util.Comparator;

/**
 * NameComparator
 */
public class NameComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        User u1 = (User) o1;
        User u2 = (User) o2;
        return (u1.getUserName().compareTo(u2.getUserName()));
    }

}
package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * FollowerGraph
 */
public class FollowGraph implements Serializable {
    private ArrayList<User> users = new ArrayList<User>();
    public static final int MAX_USERS = 100;
    private boolean[][] connections;

    public FollowGraph() {

    }

    public void addUser(String username) {
        if (!users.contains(username)) {
            users.add(new User());
        }
    }

    public void addConnection(String userFrom, String userTo) {
        if (users.contains(userFrom) && users.contains(userTo))
            connections[users.indexOf(userFrom)][users.indexOf(userTo)] = true;
        else
            System.err.println("ERROR: Inappropirate users were given");
    }

    public void removeConnection(String userFrom, String userTo) {
        if (users.contains(userFrom) && users.contains(userTo))
            connections[users.indexOf(userFrom)][users.indexOf(userTo)] = false;
        else
            System.err.println("ERROR: Inappropirate users were given");
    }

    public String shortestPath(String userFrom, String userTo) {
        // TODO: Shortest Path Algorithm
    }

    public List[String] allPaths(String userFrom, String userTo){
        //TODO: Shortest Path Alogirthm
    }

    public void printAllUsers(Comparator comp) {
        Collections.sort(users, comp);
        System.out.println(users);
    }

    public void printAllFollowers(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (connections[users.indexOf(userName)][i] == true) {
                System.out.print(users.get(i) + ", ");
            }
        }
    }

    public void printAllFollowing(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (connections[i][users.indexOf(userName)] == true) {
                System.out.print(users.get(i) + ", ");
            }
        }
    }

    public List[String] findAllLoops(){
        //TODO: Shortest Path Alogirthm.
    }

    public void loadAllUsers(String filename) {
        // TODO: File parsing
    }

    public void loadAllConnections(String filename) {
        // TODO: File Parsing
    }
}
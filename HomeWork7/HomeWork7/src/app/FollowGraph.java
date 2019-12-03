/**
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * FollowerGraph
 */
public class FollowGraph implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7499456363074542721L;
    private ArrayList<User> users = new ArrayList<User>();

    public static final int MAX_USERS = 100;
    private boolean[][] connections = new boolean[MAX_USERS][MAX_USERS];

    public FollowGraph() {
        for (int i = 0; i < MAX_USERS; i++) {
            for (int j = 0; j < MAX_USERS; j++) {
                connections[i][j] = false;
            }
        }
    }

    /**
     * @param userName the name of the user to add
     */
    public void addUser(String userName) {
        boolean c = true;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName))
                c = false;
        }

        if (c) {
            users.add(new User(userName));
        } else {
            System.out.println("This user already exists");
        }

    }

    /**
     * @param userFrom the starting user
     * @param userTo   the ending user
     */
    public void addConnection(String userFrom, String userTo) {
        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userFrom))
                i1 = i;
            if (users.get(i).getUserName().equals(userTo))
                i2 = i;
        }
        try {
            connections[i1][i2] = true;
            System.out.println("added connection between " + userFrom + "and " + userTo);

        } catch (Exception e) {
            System.err.println("ERROR: Inappropirate users were given");
        }
    }

    /**
     * @param userFrom the starting user
     * @param userTo   the ending user
     */
    public void removeConnection(String userFrom, String userTo) {
        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userFrom))
                i1 = i;
            if (users.get(i).getUserName().equals(userTo))
                i2 = i;
        }
        try {
            connections[i1][i2] = false;
            System.out.println("added connection between " + userFrom + "and " + userTo);

        } catch (Exception e) {
            System.err.println("ERROR: Inappropirate users were given");
        }
    }

    /**
     * @return the string of the shortest path
     * @param userFrom the starting user
     * @param userTo   the ending user
     */
    public String shortestPath(String userFrom, String userTo) {
        ArrayList<String> paths = new ArrayList<>();
        boolean[] visited = new boolean[MAX_USERS];
        ArrayList<String> list = getAllPaths(userFrom, userTo, visited, paths);
        Collections.sort(list);
        return list.get(0);
    }

    /**
     * @return all users in organized via comp
     * @param comp the method to organize the users
     */
    public void printAllUsers(Comparator comp) {
        Collections.sort(users, comp);
        System.out.println(users);
    }

    /**
     * @return int the number of followers
     * @param userName the name of the user to check
     */
    public int getFollowerCount(String userName) {
        int temp = 0;
        for (int i = 0; i < users.size(); i++) {
            if (connections[getUserIndex(userName)][i] == true) {
                temp++;
            }
        }
        return temp;
    }

    /**
     * @param userName the name of the user to check
     */
    public void printAllFollowers(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (connections[getUserIndex(userName)][i] == true) {
                System.out.print(users.get(i) + ", ");
            }
        }
    }

    /**
     * @return the number of users following
     * @param userName the name of the user to check
     */
    public int getFollowingCount(String userName) {
        int temp = 0;
        for (int i = 0; i < users.size(); i++) {
            if (connections[i][getUserIndex(userName)] == true) {
                temp++;
            }
        }
        return temp;
    }

    /**
     * @param userName the name of the user to check
     */
    public void printAllFollowing(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (connections[i][getUserIndex(userName)] == true) {
                System.out.print(users.get(i) + ", ");
            }
        }
    }

    // public List[String] findAllLoops(){
    // TODO: Shortest Path Alogirthm.
    // }
    /**
     * @param userFrom the starting user
     * @param userTo   the ending user
     */
    public void printPaths(String userFrom, String userTo) {
        ArrayList<String> paths = new ArrayList<>();
        boolean[] visited = new boolean[MAX_USERS];
        paths.add(userFrom);
        getAllPaths(userFrom, userTo, visited, paths);
    }

    /**
     * @return all the paths in the system
     * @param userFrom the starting user
     * @param userTo   the ending user
     * @param visted   an array of all visited positions
     * @param list     the list of nodes
     */
    public void getAllPaths(String userFrom, String userTo, boolean[] visited, ArrayList<String> list) {
        visited[getUserIndex(userFrom)] = true;
        if (userFrom.equals(userTo)) {
            System.out.println(list);
        }
        for (int i = 0; i < connections[getUserIndex(userFrom)].length; i++) {
            if (!(visited[i]) && users.size() > i) {
                list.add(users.get(i).toString());
                getAllPaths(users.get(i).toString(), userTo, visited, list);
                list.remove(users.get(i).toString());
            }
        }
        visited[getUserIndex(userTo)] = false;
    }

    /**
     * @param filename the file to pull data from
     */
    public void loadAllUsers(String filename) {
        User temp;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            temp = (User) in.readObject();
            in.close();
            fileIn.close();
            users.add(temp);
        } catch (Exception e) {
            System.err.println("There was an error");
        }
    }

/**
     * @param filename the file to pull data from
     */
    public void loadAllConnections(String filename) {
        boolean[][] temp;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            temp = in.readBoolean
            in.close();
            fileIn.close();
            temp.
            addConnection(userFrom, userTo);
        } catch (Exception e) {
            System.err.println("There was an error");
        }
    }

    /**
     * @return the user's index number
     * @param name the name of the user
     */
    public static int getUserIndex(String name) {
        for (int i = 0; i < FollowGraphDriver.graph.users.size(); i++) {
            if (FollowGraphDriver.graph.users.get(i).getUserName().equals(name))
                return i;
        }
        return -1;
    }

    /**
     * @return the users
     */
    public ArrayList<User> getUsers() {
        return users;
    }
}
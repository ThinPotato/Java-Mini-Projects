package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        int edgeCount;
        Double dist[][] = new Double[connections.length][connections.length]; // connections.length prob wrong
        int next[][] = new int[connections.length][connections.length];
        for (int u = 0; u < connections.length; u++) {
            for (int v = 0; v < connections.length; v++) {
                dist[u][v] = Double.POSITIVE_INFINITY;
                if (connections[u][v] == true) {
                    dist[u][v] = 1.0;
                    next[u][v] = v;
                    for (int k = 1; u < v; k++) {
                        for (int i = 1; i < v; i++) {
                            for (int j = 1; j < v; j++) {
                                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                                    dist[i][j] = dist[i][j] + dist[k][j];
                                    next[i][j] = next[i][k];
                                }
                            }
                        }
                    }
                }
                if (next[u][v] == null) {
                    return [];
                }
                path = [u];
                while(u != v){
                    u = next[u][v];
                    path.
                }
            }
        }

    }

    public List<String> allPaths(String userFrom, String userTo) {
        // TODO: Shortest Path Alogirthm
        List<String> list;
        for (int i = 0; i < connections.length; i++) {
            for (int j = 0; j < connections.length; j++) {

            }
        }
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
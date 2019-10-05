import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class
 * 
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
public class Player {
    static SongLinkedList linkedList = new SongLinkedList();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        usrPrompt();

        do {
            try {
                usrPrompt();
                input = scan.nextLine();

                if (input.equalsIgnoreCase("a")) {
                    newSong();
                } else if (input.equalsIgnoreCase("p")) {
                    linkedList.printPlaylist();

                } else if (input.equalsIgnoreCase("f")) {
                    linkedList.cursorForwards();
                    linkedList.printPlaylist();
                } else if (input.equalsIgnoreCase("b")) {
                    linkedList.cursorBackwards();
                    linkedList.printPlaylist();
                } else if (input.equalsIgnoreCase("r")) {
                    System.out.println("Removed: " + linkedList.removeCursor().getName());
                    linkedList.setCursor(linkedList.getHead());
                } else if (input.equalsIgnoreCase("t")) {
                    System.out.println("The total number of songs in the playlist is: " + linkedList.getSize());
                } else if (input.equalsIgnoreCase("s")) {
                    linkedList.shuffle();
                    System.out.println("playlist has been shuffled.");
                } else if (input.equalsIgnoreCase("c")) {
                    linkedList.deleteAll();
                    System.out.println("the playlist has been cleared.");
                } else if (input.equalsIgnoreCase("z")) {
                    linkedList.play(linkedList.random().getName());
                } else if (input.equalsIgnoreCase("L")) {
                    playSong();
                }
            } catch (NullPointerException e) {
                System.out.println("The playlist is empty");
            }
        } while (!input.equalsIgnoreCase("q"));

    }

    public static void playSong() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of song to play: ");
        String name = scan.nextLine();
        linkedList.play(name);
        System.out.println("playing " + name);
    }

    public static void newSong() {
        Scanner scan = new Scanner(System.in);
        String title = "";
        String artist = "";
        String album = "";
        int length = -1;
        try {
            System.out.println("Enter song title: ");
            title = scan.nextLine();
            System.out.println("Enter artist(s) of the song: ");
            artist = scan.nextLine();
            System.out.println("Enter album: ");
            album = scan.nextLine();
            System.out.println("enter length (in seconds): ");
            length = scan.nextInt();

            Song newSong = new Song(title, artist, album, length);
            linkedList.insertAfterCursor(newSong);
        } catch (InputMismatchException e) {
            System.out.println("error: Input mismatch. Please enter time as an integer.");
            newSong();
        }
    }

    public static void usrPrompt() {
        System.out.println(
                "(A) Add Song to Playlist\n(F) Go to Next Song\n(B) Go to Previous Song\n(L) Play a Song\n(C) Clear the Playlist\n(R) Remove song from playlist\n(S) Shuffle playlist\n(Z) Random Song\n(P) Print playlist\n(T) Get the total amount of songs in the playlist\n(Q) Exit the playlist");
    }
}
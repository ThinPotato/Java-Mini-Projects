import javax.sound.sampled.AudioInputStream;

import javax.sound.sampled.AudioSystem;

import javax.sound.sampled.Clip;
import java.io.File;

/**
 * SongLinkedList
 * 
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu
 */
class SongLinkedList {
    SongNode head;
    SongNode tail;
    SongNode cursor;
    int size;
    SongLinkedList list;

    SongLinkedList() {
        list = Player.linkedList;
        head = null;
        tail = null;
        cursor = null;

    }

    /**
     * Plays the song indicated by name. The song must be present in your current
     * working directory to play. Refer to the code listed further in the specs for
     * more information on how to play an audio file.
     * 
     * @param name the name of the song to search for
     * @throws IllegalArgumentException
     */

    public void play(String name) throws IllegalArgumentException {
        SongNode temp = head;
        try {

            AudioInputStream AIS = AudioSystem.getAudioInputStream(

                    new File("/home/bryce/Development/CSE214/HomeWork2/songs/" + name + ".wav"));
            // starting the clip

            Clip c = AudioSystem.getClip();

            c.open(AIS);
            do {
                if (temp.getData().getName().equals(name)) {
                    c.start();
                }
                temp = temp.getNext();
            } while (temp.getNext() != null);
            if (temp.getData().getName().equals(name)) {
                c.start();
            }

        }

        catch (Exception ex) {
            System.out.println("error playing " + name);
        }
    }

    /**
     * Moves the cursor to point at the next SongNode. This and the
     * cursorBackwards() method are the user’s main way of moving around the Linked
     * List.
     * 
     */
    public void cursorForwards() {
        if (cursor.getNext() != null) {
            cursor = cursor.getNext();
        } else
            System.out.println("There is no song forwards.");
    }

    /**
     * Moves the cursor to point at the previous SongNode.
     */
    public void cursorBackwards() {
        if (cursor.getPrev() != null) {
            cursor = cursor.getPrev();
        } else
            System.out.println("There is no song backwards.");

    }

    /**
     * Inserts a song into the playlist AFTER the cursor position. The user will
     * have to move the cursor using the cursor methods above to add a song after a
     * specific song if they want.
     * 
     * @param newSong the song to be inserted in the playlist
     * @throws IllegalArgumentException indicates the new song is null
     */
    public void insertAfterCursor(Song newSong) throws IllegalArgumentException {
        SongNode newNode = new SongNode(newSong);
        SongNode temp = cursor;
        if (head == null) {
            head = newNode;
            cursor = head;
        } else if (cursor.getNext() != null) {
            newNode.setNext(cursor.getNext());
            newNode.setPrev(cursor);
            cursor.setNext(newNode);
            newNode.getNext().setPrev(newNode);
        } else {
            // adds to end of list
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrev(temp);
            tail = temp;
        }
        size++;
    }

    /**
     * Removes the SongNode referenced by the cursor and returns the Song contained
     * within the node.
     * 
     * @return
     */
    public Song removeCursor() {
        SongNode temp;

        if (head == cursor) {
            head = cursor.getNext();
        }
        if (cursor.getNext() != null) {
            cursor.getNext().setPrev(cursor.getPrev());
        }
        if (cursor.getPrev() != null) {
            cursor.getPrev().setNext(cursor.getNext());
        }
        size--;
        return cursor.getData();
    }

    /**
     * Determines the number of Song objects currently in the playlist. There will
     * be a size variable (int) that will be able to hold the total number of songs
     * in the playlist.
     * 
     * @return The number of Song objects in the playlist.
     */
    public int getSize() {
        return size;
    }

    /**
     * Selects one of the songs in the playlist and play it at random. Note: This
     * will NOT change the order of the playlist.
     * 
     * @return The Song which was randomly selected.
     */
    public Song random() {
        int random = (int) (Math.random() * size);
        SongNode temp = head;
        for (int i = 0; i < random; i++) {
            if (temp.getNext() != null) {
                temp = temp.getNext();
            }
        }
        return temp.getData();
    }

    /**
     * Randomly shuffles the order of the songs contained within the playlist.
     */
    public void shuffle() {
        SongNode temp;
        int inSize = size;
        SongLinkedList tempList = new SongLinkedList();
        for (int i = 0; i < inSize; i++) {
            int ran = (int) (Math.random() * (inSize - i));
            for (int j = 0; j < ran; j++) {
                System.out.println("curious");
                cursorForwards();
                if (cursor.getNext() == null || cursor == null) {
                    System.out.println("loop");
                    cursor = head;
                }

            }
            tempList.insertAfterCursor(removeCursor());
            cursor = head;
        }
        Player.linkedList = tempList;

    }

    /**
     * Prints the playlist in a neatly-formatted table.
     */
    public void printPlaylist() {
        System.out.println(Player.linkedList.toString());
    }

    /**
     * This will simply delete all of the songs from the playlist.
     */

    public void deleteAll() {
        setTail(null);
        setHead(null);
        setCursor(null);
        setSize(0);
    }

    /**
     * Returns a neatly formatted String representation of the playlist. See the
     * Sample I/O for layout.
     */
    public String toString() {
        SongNode temp = head;
        String str = "";
        try {
            str += String.format("%-16s%-13s%-10s%-17s", "name", "album", "artist", "length");
            while (temp.getNext() != null) {
                str += String.format("\n%-16s%-13s%-10s%-17s", temp.data.getName(), temp.data.getAlbum(),
                        temp.data.getArtist(), temp.data.getLength());
                if (cursor == temp)
                    str += "<-";
                temp = temp.getNext();
            }
            str += String.format("\n%-16s%-13s%-10s%-17s", temp.data.getName(), temp.data.getAlbum(),
                    temp.data.getArtist(), temp.data.getLength());
            if (cursor == temp)
                str += "<-";
        } catch (NullPointerException e) {
            System.out.println("The playlist is empty.");
        }
        return str;
    }

    /**
     * @return the cursor
     */
    public SongNode getCursor() {
        return cursor;
    }

    /**
     * @return the tail
     */
    public SongNode getTail() {
        return tail;
    }

    /**
     * @return the head
     */
    public SongNode getHead() {
        return head;
    }

    /**
     * @param cursor the cursor to set
     */
    public void setCursor(SongNode cursor) {
        this.cursor = cursor;
    }

    /**
     * @param head the head to set
     */
    public void setHead(SongNode head) {
        this.head = head;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(SongNode tail) {
        this.tail = tail;
    }
}
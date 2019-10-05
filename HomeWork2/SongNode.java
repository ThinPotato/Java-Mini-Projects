/**
 * SongNode
 * 
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu
 */
class SongNode {
    SongNode prev;
    SongNode next;
    Song data;

    public SongNode() {

    }

    public SongNode(Song data) {
        this.data = data;
    }

    /**
     * @return the data
     */
    public Song getData() {
        return data;
    }

    /**
     * @return the next
     */
    public SongNode getNext() {
        return next;
    }

    /**
     * @return the prev
     */
    public SongNode getPrev() {
        return prev;
    }

    /**
     * @param data the data to set
     */
    public void setData(Song data) {
        this.data = data;
    }

    /**
     * @param next the next to set
     */
    public void setNext(SongNode next) {
        this.next = next;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(SongNode prev) {
        this.prev = prev;
    }
}
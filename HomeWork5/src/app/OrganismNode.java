package app;

/**
 * OrganismNode
 */
public class OrganismNode {
    String name = "";
    boolean isPlant;
    boolean isHerbivore;
    boolean isCarnivore;
    OrganismNode left;
    OrganismNode right;
    OrganismNode middle;

    OrganismNode() {

    }

    OrganismNode(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the plant status
     */
    public boolean getIsPlant() {
        return isPlant;
    }

    /**
     * @return the Herbivore status
     */
    public boolean getIsHerbivore() {
        return isHerbivore;
    }

    /**
     * @return the Carnivore status
     */
    public boolean getIsCarnivore() {
        return isCarnivore;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(OrganismNode left) {
        this.left = left;
    }

    /**
     * @param middle the middle to set
     */
    public void setMiddle(OrganismNode middle) {
        this.middle = middle;
    }

    /**
     * @param right the right to set
     */
    public void setRight(OrganismNode right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public OrganismNode getLeft() {
        return left;
    }

    /**
     * @return the middle
     */
    public OrganismNode getMiddle() {
        return middle;
    }

    /**
     * @return the right
     */
    public OrganismNode getRight() {
        return right;
    }

    /**
     * @param isCarnivore the isCarnivore to set
     */
    public void setCarnivore(boolean isCarnivore) {
        this.isCarnivore = isCarnivore;
    }

    /**
     * @param isHerbivore the isHerbivore to set
     */
    public void setHerbivore(boolean isHerbivore) {
        this.isHerbivore = isHerbivore;
    }

    /**
     * @param isPlant the isPlant to set
     */
    public void setPlant(boolean isPlant) {
        this.isPlant = isPlant;
    }

    /**
     * Adds preyNode as prey to this node.
     * 
     * @param preyNode the node to add
     */
    public void addPrey(OrganismNode preyNode)
            throws PositionNotAvailableException, IsPlantException, DietMismatchException {
        if (!left.name.equals("")) {
            left = preyNode;
        } else if (!middle.name.equals("")) {
            middle = preyNode;
        } else if (!right.name.equals("")) {
            right = preyNode;
        }
    }
}
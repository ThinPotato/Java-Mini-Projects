package app;

/**
 * OrganismNode
 */
public class OrganismNode {
    String name = "";
    boolean isPlant;
    boolean isHerbivore;
    boolean isCarnivore;
    OrganismNode left = new OrganismNode();
    OrganismNode right = new OrganismNode();
    OrganismNode middle = new OrganismNode();

    OrganismNode() {

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
     * @param preyNode the node to add
     */
    public void addPrey(OrganismNode preyNode)
            throws PositionNotAvailableException, IsPlantException, DietMismatchException {

    }
}
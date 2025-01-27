package app;

/**
 * OrganismTree
 */
public class OrganismTree {
    OrganismNode root = new OrganismNode();
    OrganismNode cursor = new OrganismNode();
    int size = 0;
    String proccessString = "";

    OrganismTree(OrganismNode apexPredator) {
        root = apexPredator;
        cursor = root;
    }

    /**
     * resets the cursor to the root position
     */
    public void cursorReset() {
        cursor = root;
    }

    /**
     * Moves cursor to one of cursor’s children.
     * 
     * @param name The name of the node to be moved to.
     * @throws IllegalArgumentException: Thrown if name does not reference a direct,
     *                                   valid child of cursor.
     */
    public void moveCursor(String name) throws IllegalArgumentException {
        try {
            if (cursor.getLeft() != null && cursor.getLeft().getName().equalsIgnoreCase(name))
                cursor = cursor.getLeft();
            else if (cursor.getLeft() != null && cursor.getMiddle().getName().equalsIgnoreCase(name))
                cursor = cursor.getMiddle();
            else if (cursor.getLeft() != null && cursor.getRight().getName().equalsIgnoreCase(name))
                cursor = cursor.getRight();
            else
                System.err.println("Error: Node not found");
        } catch (IllegalArgumentException e) {
            System.err.println("Error, IllegalArgumentException");
        }
    }

    /**
     * 
     * @return a String including the organism at cursor and all its possible prey
     *         (i.e. in the case of if cursor was at the root of the tree in the
     *         diagram above: bald eagle -> python, carp, raccoon).
     * @throws IsPlantException
     */
    public String listPrey() throws IsPlantException {
        String temp = cursor.getName() + "-> ";
        if (cursor.getLeft() != null)
            temp += cursor.getLeft().getName() + ", ";
        if (cursor.getMiddle() != null)
            temp += cursor.getMiddle().getName() + ", ";
        if (cursor.getRight() != null)
            temp += cursor.getRight().getName() + ", ";
        temp = temp.substring(0, temp.length() - 2);
        return temp;
    }

    /**
     * 
     * @return a String containing the path of organisms that leads from the apex
     *         predator (root) to the organism at cursor. (i.e. in the case of if
     *         cursor was at “seeds” in the diagram above: bald eagle -> python ->
     *         mallard duck -> seeds)
     * 
     */
    public String listFoodChain() {
        // TODO: redo this method
        proccessString = "";
        findParents(cursor);
        String temp[] = proccessString.split(", ");
        proccessString = "";
        for (int i = temp.length - 1; i >= 0; i--) {
            proccessString += temp[i] + "-> ";
        }
        proccessString = proccessString.substring(0, proccessString.length() - 3);
        return proccessString;
    }

    /**
     * Prints out a layered, indented tree by performing a preorder traversal
     * starting at cursor. The cursor should act as the “root” of the printed tree,
     * per se, but the root reference does not move.
     */
    public void printOrganismTree() {
        OrganismNode save = cursor;
        proccessString = "";
        organizeTree(save, 0);
        System.out.println(proccessString);
    }

    /**
     * 
     * @return A String containing a list of all the plants in the food pyramid.
     */
    public String listAllPlants() {
        proccessString = "";
        organizePlants(cursor);
        proccessString = proccessString.substring(0, proccessString.length() - 2);
        return proccessString;
    }

    private void findParents(OrganismNode temp) {
        do {
            proccessString += temp.getName() + ", ";
            temp = temp.getParent();
        } while (temp.parent == root);
        proccessString += temp.getName();
    }

    private void organizeTree(OrganismNode temp, int i) {
        i += 4;
        for (int k = 0; k < i; k++) {
            proccessString += " ";
        }
        if (temp.isPlant) {
            proccessString += "-" + temp.getName() + "\n";
        } else
            proccessString += "|-" + temp.getName() + "\n";
        if (temp.getLeft() != null)
            organizeTree(temp.getLeft(), i);
        if (temp.getMiddle() != null)
            organizeTree(temp.getMiddle(), i);
        if (temp.getRight() != null)
            organizeTree(temp.getRight(), i);
    }

    private void organizePlants(OrganismNode temp) {
        if (temp.getLeft() != null)
            organizePlants(temp.getLeft());
        if (temp.getMiddle() != null)
            organizePlants(temp.getMiddle());
        if (temp.getRight() != null)
            organizePlants(temp.getRight());
        if (temp.left == null && temp.middle == null && temp.right == null && temp.getIsPlant() == true) {
            proccessString += temp.getName() + ", ";
        }
    }

    /**
     * Creates a new animal node with a specific name and diet and adds it as a
     * child of the cursor node.
     * 
     * @param name        The name of the child node.
     * @param isHerbivore value depending on whether the animal consumes plants.
     * @param isCarnivore value depending on whether the animal consumes other
     *                    animals.
     * @throws IllegalArgumentException      Thrown if name references an exact name
     *                                       with one of its would-be siblings.
     * @throws PositionNotAvailableExceptoin Thrown if there is no available child
     *                                       position for a new node to be added.
     */
    public void addAnimalChild(String name, boolean isHerbivore, boolean isCarnivore)
            throws IllegalArgumentException, PositionNotAvailableExceptoin {
        try {
            if (cursor.getIsCarnivore()) {
                OrganismNode temp = new OrganismNode(name);
                temp.setHerbivore(isHerbivore);
                temp.setCarnivore(isCarnivore);
                if (cursor.getLeft() == null)
                    cursor.setLeft(temp);
                else if (cursor.getMiddle() == null)
                    cursor.setMiddle(temp);
                else if (cursor.getRight() == null)
                    cursor.setRight(temp);
                else
                    System.err.println("ERROR: There is no more room in for this predator.");
                temp.setParent(cursor);
                size++;
            } else
                System.err.println("ERROR: This prey cannot be added as it does not match the diet of the predator.");
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                System.err.println("Error, Illegal Argument exception");
            else
                System.err.println("Error, Position Not Avilable Exception");
        }

    }

    /**
     * Creates a new plant node with a specific name and adds it as a child of the
     * cursor node.
     * 
     * @param name The name of the child node.
     * 
     * @throws IllegalArgumentException      Thrown if name references an exact name
     *                                       with one of its would-be siblings.
     * @throws PositionNotAvailableExceptoin Thrown if there is no available child
     *                                       position for a new node to be added.
     */
    public void addPlantChild(String name) throws IllegalArgumentException, PositionNotAvailableException {
        try {
            OrganismNode temp = new OrganismNode(name);
            temp.setPlant(true);
            if (cursor.getLeft() == null)
                cursor.setLeft(temp);
            else if (cursor.getMiddle() == null)
                cursor.setMiddle(temp);
            else if (cursor.getRight() == null)
                cursor.setRight(temp);
            size++;
            temp.setParent(cursor);
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException)
                System.err.println("Error, Illegal Argument exception");
            else
                System.err.println("Error, Position Not Avilable Exception");
        }
    }

    /**
     * Removes the child node of cursor with name name, and properly shifts the
     * deleted node’s other siblings if necessary. If the deleted node has any
     * descendants, those nodes are deleted as well.
     * 
     * @param name The name of the node to be deleted.
     * @throws IllegalArgumentException Thrown if name does not reference a direct
     *                                  child of the cursor.
     */
    public void removeChild(String name) throws IllegalArgumentException {
        try {
            if (cursor.getLeft() != null && cursor.getLeft().getName().equalsIgnoreCase(name))
                cursor.setLeft(null);
            else if (cursor.getLeft() != null && cursor.getMiddle().getName().equalsIgnoreCase(name))
                cursor.setMiddle(null);
            else if (cursor.getLeft() != null && cursor.getRight().getName().equalsIgnoreCase(name))
                cursor.setRight(null);
            else
                System.err.println("ERROR: not found");
            size--;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: illegal Argument");
        }
    }

    /**
     * @return the cursor
     */
    public OrganismNode getCursor() {
        return cursor;
    }

    /**
     * @return the root
     */
    public OrganismNode getRoot() {
        return root;
    }

}
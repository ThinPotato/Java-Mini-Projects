package app;

/**
 * OrganismTree
 */
public class OrganismTree {
    OrganismNode root = new OrganismNode();
    OrganismNode cursor = new OrganismNode();
    int size = 0;

    OrganismTree(OrganismNode apexPredator) {
        root = apexPredator;
        cursor = root;
    }

    public void cursorReset() {
        cursor = root;
    }

    public void moveCursor(String name) throws IllegalArgumentException {
        if (cursor.getLeft().getName().equals(name))
            cursor = cursor.getLeft();
        else if (cursor.getMiddle().getName().equals(name))
            cursor = cursor.getMiddle();
        else if (cursor.getRight().getName().equals(name))
            cursor = cursor.getRight();
    }

    public String listPrey() throws IsPlantException {
        String temp = cursor.getName() + " - > ";
        if (cursor.getLeft() != null)
            temp += cursor.getLeft().getName() + ", ";
        if (cursor.getMiddle() != null)
            temp += cursor.getMiddle().getName() + ", ";
        if (cursor.getRight() != null)
            temp += cursor.getRight().getName();
        return temp;
    }

    public String listFoodChain() {
        String temp = "";
        OrganismNode save = cursor;
        cursor = root;
        do {
            if (cursor.getLeft() != null)
                cursor = cursor.getLeft();
            else if (cursor.getMiddle() != null)
                cursor = cursor.getMiddle();
            else if (cursor.getRight() != null)
                cursor = cursor.getRight();
            temp += cursor.getName() + " -> ";
        } while (!cursor.getName().equals(save.getName()));
        temp += cursor.getName();
        cursor = save;
        return temp;
    }

    public void printOrganismTree() {
        OrganismNode save = cursor;
        System.out.println(traverseTree(save, 0));
    }

    public String listAllPlants() {
        // TODO: redo this method
        return returnleafs(cursor);
    }

    private String[] traverseTree(OrganismNode temp, int i) {
        String hold[] = new String[size];
        if (temp.getLeft() != null)
            traverseTree(temp.getLeft(), i++);
        hold[i] = temp.getName();
        if (temp.getMiddle() != null)
            traverseTree(temp.getMiddle(), i++);
        if (temp.getRight() != null)
            traverseTree(temp.getRight(), i++);
        return hold;
    }

    private String returnleafs(OrganismNode temp) {
        // TODO: this may not connect to listAllPlants() properly
        String string = "";
        if (temp.getLeft() != null)
            returnleafs(temp.getLeft());
        if (temp.getMiddle() != null)
            returnleafs(temp.getMiddle());
        if (temp.getRight() != null)
            returnleafs(temp.getRight());
        if (temp.left == null && temp.middle == null && temp.right == null) {
            string += temp.getName();
        }
        return string;
    }

    public void addAnimalChild(String name, boolean isHerbivore, boolean isCarnivore)
            throws IllegalArgumentException, PositionNotAvailableExceptoin {
        try {
            OrganismNode temp = new OrganismNode(name);
            temp.setHerbivore(isHerbivore);
            temp.setCarnivore(isCarnivore);
            if (cursor.getLeft() == null)
                cursor.setLeft(temp);
            else if (cursor.getMiddle() == null)
                cursor.setMiddle(temp);
            else if (cursor.getRight() == null)
                cursor.setRight(temp);
            size++;
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void addPlantChild(String name) throws IllegalArgumentException, PositionNotAvailableExceptoin {
        try {
            OrganismNode temp = new OrganismNode(name);
            if (cursor.getLeft() != null)
                cursor.setLeft(temp);
            else if (cursor.getMiddle() != null)
                cursor.setMiddle(temp);
            else if (cursor.getRight() != null)
                cursor.setRight(temp);
            size++;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void removeChild(String name) throws IllegalArgumentException {
        try {
            if (cursor.getLeft().getName().equals(name))
                cursor.setLeft(null);
            else if (cursor.getMiddle().getName().equals(name))
                cursor.setMiddle(null);
            else if (cursor.getRight().getName().equals(name))
                cursor.setRight(null);
            size--;
        } catch (Exception e) {
            // TODO: handle exception
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
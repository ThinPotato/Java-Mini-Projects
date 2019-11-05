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
        proccessString = "";
        traverseTree(save);
        System.out.println(proccessString);
    }

    public String listAllPlants() {
        // TODO: redo this method
        proccessString = "";
        organizePlants(cursor);
        proccessString = proccessString.substring(0, proccessString.length() - 1);
        return proccessString;
    }

    private void traverseTree(OrganismNode temp) {
        if (temp.getLeft() != null)
            traverseTree(temp.getLeft());
        proccessString += temp.getName() + "-";
        if (temp.getMiddle() != null)
            traverseTree(temp.getMiddle());
        if (temp.getRight() != null)
            traverseTree(temp.getRight());
    }

    private void organizePlants(OrganismNode temp) {
        // TODO: this may not connect to listAllPlants() properly
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
            temp.setPlant(true);
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
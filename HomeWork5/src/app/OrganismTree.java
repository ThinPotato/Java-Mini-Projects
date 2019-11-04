package app;

/**
 * OrganismTree
 */
public class OrganismTree {
    OrganismNode root = new OrganismNode();
    OrganismNode cursor = new OrganismNode();

    OrganismTree(OrganismNode apexPredator) {
        root = apexPredator;
        cursor = root;
    }

    public void cursorReset() {
        cursor = root;
    }

    public void moveCursor(String name) throws IllegalArgumentException {
        do {
            if (cursor.getLeft() != null)
                cursor = cursor.getLeft();
            else if (cursor.getMiddle() != null)
                cursor = cursor.getMiddle();
            else if (cursor.getRight() != null)
                cursor = cursor.getRight();
        } while (!cursor.getName().equals(name));
    }

    public String listPrey() throws IsPlantException {
        String temp = "";
        if (cursor.getLeft() != null)
            temp += cursor.getLeft().toString();
        else if (cursor.getMiddle() != null)
            temp += cursor.getMiddle().toString();
        else if (cursor.getRight() != null)
            temp += cursor.getRight().toString();
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

    }

    public String listAllPlants() {

    }

    public void addAnimalChild(String name, boolean isHerbivore, boolean isCarnivore)
            throws IllegalArgumentException, PositionNotAvailableExceptoin {
        try {
            OrganismNode temp = new OrganismNode(name);
            temp.setHerbivore(isHerbivore);
            temp.setCarnivore(isCarnivore);
            if (cursor.getLeft() != null)
                cursor.setLeft(temp);
            else if (cursor.getMiddle() != null)
                cursor.setMiddle(temp);
            else if (cursor.getRight() != null)
                cursor.setRight(temp);
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
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
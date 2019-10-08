/**
 * Block
 * 
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

class Block {
    Variable[] variables = new Variable[10];
    int location = 0;

    Block() {

    }

    /**
     * @param location the location to add the variable in the array
     * @param name     the name of the variable
     * @param data     the integer to be added to the variable
     */
    public void addVariable(int location, String name, int data) {
        variables[location] = new Variable(name, data);
    }

    /**
     * @param name the name of the variable
     * @param data the integer to be added to the variable
     */
    public void addVariable(String name, int data) {
        variables[location] = new Variable(name, data);
        location++;
    }

    /**
     * @param location the location of the variable in the variables array
     */
    public void removeVariable(int location) {
        variables[location] = null;
    }

    /**
     * @return all of the variables formatted as name:int as a string
     */
    public String toString() {
        String string = "";
        String[] name = new String[10];
        String[] intvalue = new String[10];
        int count = 0;
        for (int i = 0; i < variables.length; i++) {
            if (variables[i] != null) {
                name[i] = variables[i].getName();
                intvalue[i] = Integer.toString(variables[i].getIntegerValue());
                count++;
            }
        }
        for (int j = 0; j < count; j++) {
            string += name[j] + ":" + intvalue[j] + " ";
        }
        return string;
    }

    /**
     * @return the variable of a certain name
     * @param name the name of the variable to search for
     */
    public Variable findVarialbe(String name) {
        for (int i = 0; i < variables.length; i++)
            if (variables[i] != null && variables[i].getName().equals(name)) {
                return variables[i];
            }
        return null;
    }

    /**
     * @return the variables
     */
    public Variable[] getVariables() {
        return variables;
    }

    /**
     * @return the location
     */
    public int getLocation() {
        return location;
    }
}
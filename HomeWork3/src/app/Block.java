package app;

class Block {
    Variable[] variables = new Variable[10];
    int location = 0;

    Block() {

    }

    public void addVariable(int location, String name, int data) {
        variables[location] = new Variable(name, data);
    }

    public void addVariable(String name, int data) {
        variables[location] = new Variable(name, data);
        location++;
    }

    public void removeVariable(int location) {
        variables[location] = null;
    }

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

    public Variable findVarialbe(String name) {
        for (int i = 0; i < variables.length; i++)
            if (variables[i] != null && variables[i].getName().equals(name)) {
                return variables[i];
            }
        System.out.println("could not find: " + name);
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
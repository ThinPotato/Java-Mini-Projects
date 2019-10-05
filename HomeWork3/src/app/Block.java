package app;

class Block {
    Variable[] variables = new Variable[10];

    Block() {

    }

    public void addVariable(int location, String name, int data) {
        variables[location] = new Variable(name, data);
    }

    public void removeVariable(int location) {
        variables[location] = null;
    }
}
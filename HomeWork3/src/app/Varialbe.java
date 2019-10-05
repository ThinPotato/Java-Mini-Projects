package app;

class Variable {
    String name;
    int integerValue;

    Variable() {

    }

    Variable(String name, int integerValue) {
        this.name = name;
        this.integerValue = integerValue;
    }

    /**
     * @return the integerValue
     */
    public int getIntegerValue() {
        return integerValue;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param integerValue the integerValue to set
     */
    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
/**
 * Variable
 * 
 * @author Bryce Stoker 111999983 R02 Bryce.stoker-schaeffer@stonybrook.edu a
 */
package app;

class Variable {
    String name;
    int integerValue;

    Variable() {

    }

    /**
     * @param name         the name of the variable
     * @param integerValue the integer data of the variable
     */
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
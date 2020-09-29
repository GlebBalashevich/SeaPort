package by.balashevich.seaport.entity;

public class Dock {
    private int number;

    public Dock(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Dock dock = (Dock) o;

        return number == dock.number;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 37 * result + number;

        return result;
    }

    @Override
    public String toString() {
        return String.format("Dock #%d", number);
    }
}

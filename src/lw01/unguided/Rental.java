package lw01.unguided;

public abstract class Rental implements Chargeable {

    private String id;
    private int days;

    public Rental(String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("harii");
        }

        this.id = id;
        this.days = days;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException();
        }

        return units * calculateCharge();
    }


        public String label() {
        return "Rental";
    }

    public String summary(int units) {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}
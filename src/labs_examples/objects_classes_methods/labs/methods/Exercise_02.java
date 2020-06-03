package labs_examples.objects_classes_methods.labs.methods;

public class Exercise_02 {

    public static void main(String[] args) {

        Engines planeEngines = new Engines(2, "jet");
        Seats planeSeats = new Seats(80, 36);
        Windows planeWindows = new Windows(50, false);
        Body planeBody = new Body(150, "green");
        Airplane myAirplane = new Airplane(600, 99, planeEngines, planeSeats, planeWindows, planeBody);

        System.out.println("My airplane is " + planeBody.getColor() + " and has " + planeEngines.getCount() + " " + planeEngines.getType() + " engines.");
        System.out.println("It has " + planeSeats.getCount() + " seats that are each " + planeSeats.getWidth() + " inches wide.");
        System.out.print("The body is " + planeBody.getLength() + "' long and ");
        if (planeWindows.isTinted()) {
            System.out.println("there are " + planeWindows.getCount() + " tinted windows.");
        } else {
            System.out.println("there are " + planeWindows.getCount() + " non-tinted windows.");
        }
        System.out.println("Fuel capacity is " + myAirplane.getFuelCapacity() + " gallons and we are currently " + myAirplane.getCurrentFuelLevel() + "% full.");

        System.out.println(myAirplane.toString());

        planeBody.setColor("red");
        planeBody.setLength(100);
        myAirplane.setBody(planeBody);
        myAirplane.setCurrentFuelLevel(50);

        System.out.println(myAirplane.getBody().toString());
        System.out.println(planeSeats.toString());

    }

}

class Airplane {
    private double fuelCapacity;
    private int currentFuelLevel;
    private Engines engines;
    private Seats seats;
    private Windows windows;
    private Body body;
    public Airplane (double fuelCapacity, int currentFuelLevel, Engines engines, Seats seats, Windows windows, Body body) {
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.engines = engines;
        this.seats = seats;
        this.windows = windows;
        this.body = body;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(int currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public Engines getEngines() {
        return engines;
    }

    public void setEngines(Engines engines) {
        this.engines = engines;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    public Windows getWindows() {
        return windows;
    }

    public void setWindows(Windows windows) {
        this.windows = windows;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fuelCapacity=" + fuelCapacity +
                ", currentFuelLevel=" + currentFuelLevel +
                ", engines=" + engines +
                ", seats=" + seats +
                ", windows=" + windows +
                ", body=" + body +
                '}';
    }
}

class Engines {
    private int count;
    private String type;
    public Engines (int count, String type) {
        this.count = count;
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Engines{" +
                "count=" + count +
                ", type='" + type + '\'' +
                '}';
    }
}

class Seats {
    private int count;
    private int width;
    public Seats(int count, int width) {
        this.count = count;
        this.width = width;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "count=" + count +
                ", width=" + width +
                '}';
    }
}

class Windows {
    private int count;
    private boolean tinted;
    public Windows(int count, boolean tinted) {
        this.count = count;
        this.tinted = tinted;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isTinted() {
        return tinted;
    }

    public void setTinted(boolean tinted) {
        this.tinted = tinted;
    }

    @Override
    public String toString() {
        return "Windows{" +
                "count=" + count +
                ", tinted=" + tinted +
                '}';
    }
}

class Body {
    private int length;
    private String color;
    public Body(int length, String color) {
        this.length = length;
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Body{" +
                "length=" + length +
                ", color='" + color + '\'' +
                '}';
    }
}


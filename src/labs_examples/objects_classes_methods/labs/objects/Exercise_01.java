package labs_examples.objects_classes_methods.labs.objects;

class Exercise {

    public static void main(String[] args) {

        Engines planeEngines = new Engines(2, "jet");
        Seats planeSeats = new Seats(80, 36);
        Windows planeWindows = new Windows(50, false);
        Body planeBody = new Body(150, "green");
        Airplane myAirplane = new Airplane(600, 99, planeEngines, planeSeats, planeWindows, planeBody);

        System.out.println("My airplane is " + planeBody.color + " and has " + planeEngines.count + " " + planeEngines.type + " engines.");
        System.out.println("It has " + planeSeats.count + " seats that are each " + planeSeats.width + " inches wide.");
        System.out.print("The body is " + planeBody.length + "' long and ");
        if (planeWindows.tinted) {
            System.out.println("there are " + planeWindows.count + " tinted windows.");
        } else {
            System.out.println("there are " + planeWindows.count + " non-tinted windows.");
        }
        System.out.println("Fuel capacity is " + myAirplane.fuelCapacity + " gallons and we are currently " + myAirplane.currentFuelLevel + "% full.");

        System.out.println(myAirplane.toString());
    }
}

class Airplane {
    double fuelCapacity;
    int currentFuelLevel;
    Engines engines;
    Seats seats;
    Windows windows;
    Body body;
    public Airplane (double fuelCapacity, int currentFuelLevel, Engines engines, Seats seats, Windows windows, Body body) {
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.engines = engines;
        this.seats = seats;
        this.windows = windows;
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
    int count;
    String type;
    public Engines (int count, String type) {
        this.count = count;
        this.type = type;
    }
}

class Seats {
    int count;
    int width;
    public Seats(int count, int width) {
        this.count = count;
        this.width = width;
    }
}

class Windows {
    int count;
    boolean tinted;
    public Windows(int count, boolean tinted) {
        this.count = count;
        this.tinted = tinted;
    }
}

class Body {
    int length;
    String color;
    public Body(int length, String color) {
        this.length = length;
        this.color = color;
    }
}



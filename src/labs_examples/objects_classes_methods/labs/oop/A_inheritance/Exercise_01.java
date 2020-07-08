package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Exercise_01 {

    public static void main(String[] args) {

        Pet miley = new Pet("Miley","Dog", 7, true);
        miley.takeWalk(3);
        Puppy scrappy = new Puppy("Scrappy", "Dog", 1, false, "Aussie", true, 6);
        scrappy.takeWalk(2);
        Cat whiskers = new Cat("Whiskers", "Cat", 2, false, "Orange");
        whiskers.takeWalk(4);

        System.out.println(scrappy.toString());

    }

}

    class Pet {
        String name;
        String type;
        double weight;
        boolean canWalk;

        public Pet(String name, String type, double weight, boolean canWalk) {
            this.name = name;
            this.type = type;
            this.weight = weight;
            this.canWalk = canWalk;
        }

        public void takeWalk(int distance){
            System.out.println("Walked pet " + distance + " miles.");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public boolean isCanWalk() {
            return canWalk;
        }

        public void setCanWalk(boolean canWalk) {
            this.canWalk = canWalk;
        }

        @Override
        public String toString() {
            return "Pet{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", weight=" + weight +
                    ", canWalk=" + canWalk +
                    '}';
        }
    }

    class Cat extends Pet {
        String color;

        public Cat(String name, String type, double weight, boolean canWalk, String color) {
            super(name, type, weight, canWalk);
            this.color = color;
        }
        @Override
        public void takeWalk(int distance) {
            System.out.println("Cats don't go on walks.");
        }
    }

    class Dog extends Pet {
        String breed;
        boolean hasShots;

        public Dog(String name, String type, double weight, boolean canWalk, String breed, boolean hasShots) {
            super(name, type, weight, canWalk);
            this.breed = breed;
            this.hasShots = hasShots;
        }
    }

    class Puppy extends Dog {
        int weeksOld;

        public Puppy(String name, String type, double weight, boolean canWalk, String breed, boolean hasShots, int weeksOld) {
            super(name, type, weight, canWalk, breed, hasShots);
            this.weeksOld = weeksOld;
        }

        @Override
        public void takeWalk(int distance) {
            System.out.println("Puppies aren't ready for walks yet.");
        }

        @Override
        public String toString() {
            return "Puppy{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", weight=" + weight +
                    ", canWalk=" + canWalk +
                    ", breed='" + breed + '\'' +
                    ", hasShots=" + hasShots +
                    ", weeksOld=" + weeksOld +
                    '}';
        }
    }


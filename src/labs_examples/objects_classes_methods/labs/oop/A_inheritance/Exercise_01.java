package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class Exercise_01 {

    public static void main(String[] args) {

        Pet miley = new Pet("Dog", 7, true);
        miley.takeWalk(3);
        Puppy scrappy = new Puppy("Dog", 1, false, "Aussie", true, 6);
        scrappy.takeWalk(2);

    }

}

    class Pet {
        String type;
        double weight;
        boolean canWalk;

        public Pet(String type, double weight, boolean canWalk) {
            this.type = type;
            this.weight = weight;
            this.canWalk = canWalk;
        }

        public void takeWalk(int distance){
            System.out.println("Walked pet " + distance + " miles.");
        }

    }

    class Dog extends Pet {
        String breed;
        boolean hasShots;

        public Dog(String type, double weight, boolean canWalk, String breed, boolean hasShots) {
            super(type, weight, canWalk);
            this.breed = breed;
            this.hasShots = hasShots;
        }
    }

    class Puppy extends Dog {
        int weeksOld;

        public Puppy(String type, double weight, boolean canWalk, String breed, boolean hasShots, int weeksOld) {
            super(type, weight, canWalk, breed, hasShots);
            this.weeksOld = weeksOld;
        }

        @Override
        public void takeWalk(int distance) {
            System.out.println("Puppies aren't ready for walks yet.");
        }
    }


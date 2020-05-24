package labs_examples.objects_classes_methods.labs.objects;

public class Exercise_02 {

    public static void main(String[] args) {

        Dog fluffy = new Dog("Fluffy", "Mini Aussie", 7);
        Owner guy = new Owner("Bob", "Green Valley", fluffy);

        System.out.println(guy.name + " lives in " + guy.town + " and loves his pet dog " + guy.pet.getName() + ".");
        System.out.println(guy.pet.getName() + " is a " + guy.pet.getBreed() + " and weighs " + fluffy.weight + "lbs.");
        System.out.println();

    }

}

class Dog {
    String name;
    String breed;
    int weight;
    public Dog (String name, String breed, int weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Owner {
    String name;
    String town;
    Dog pet;
    public Owner (String name, String town, Dog pet) {
        this.name = name;
        this.town = town;
        this.pet = pet;
    }
}
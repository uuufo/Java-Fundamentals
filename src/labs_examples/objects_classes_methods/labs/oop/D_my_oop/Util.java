package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Util {
    public boolean checkInput(String userInput, String... expected){
        for(String s : expected){
            if(userInput.equalsIgnoreCase(s)){
                return true;
            }
        }
        System.out.println(userInput + " is not a valid selection, please try again!");
        return false;
    }
}


public class MainClass {


    public static void main(String[] args){

        try {
            new CAGenerate(600, 600, 60,55,120).run();
        }catch (IllegalArgumentException e){
            System.out.println("Cannot generate images with given ruleset.");
        }
    }
}


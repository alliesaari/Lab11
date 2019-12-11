
public class Cowsay {
    System.out.println("Welcome to Cow simulator");
    private static void listCows(Cow[] cows) {
        System.out.print("Regular cows available: ");
for(int i=0; i<cows.length; i++) {
    System.out.print(cows[i].getName() + " ");  //prints cows from array of cows
}
System.out.println();
    }

    private static Cow findCow(String name, Cow[] cows) {

        for(int i=0; i<cows.length; i++) {   // finds the matching name from array of cows
            if (name.equals(cows[i].getName())) {
                Cow newCow = cows[i];
                return newCow;
            }
        }
            System.out.println("Could not find " + name + " cow!");  // prints message if cow is not found
        System.out.println();
        return null;  // returns null if cow is not found
    }
    private static void listFileCows(Cow[] cows){
        System.out.print("File cows available: ");
        for(int i=0; i<cows.length; i++){
            System.out.print(cows[i].getName() + " ");  //prints cows from array of cows
        }
    }

    public static void main(String args[]) {
        Cow newCow;  // creates new cow object
        Dragon newDragon;
        Cow [] cows = HeiferGenerator.getCows();
        Cow [] fileCows = HeiferGenerator.getFileCows();
        switch (args[0]) {  //checks first String
            case "-l":  //lists the cows
                listCows(cows);
                listFileCows(fileCows);
                System.out.println();
                break;

            case "-n":  // finds the cow and prints message
                newCow = findCow(args[1], cows);  //creates cow object
                if (newCow == null) {
                    break;
                }
                System.out.println();
                for (int i = 2; i < args.length; i++) {
                    System.out.print(args[i] + " ");  //prints message
                }
                if(args[1].equals("dragon")){
                    newDragon = (Dragon)newCow;;  //creates dragon object
                    System.out.println();
                    System.out.println(newDragon.getImage());
                    newDragon.canBreatheFire();  //checks if can breathe fire
                    System.out.println();
                    break;
                }
                else if(args[1].equals("ice-dragon")) {
                    IceDragon newIceDragon = (IceDragon)newCow; //creates ice-dragon object
                    System.out.println();
                    System.out.println(newIceDragon.getImage());
                    newIceDragon.canBreatheFire();  //checks if can breathe fire
                    System.out.println();
                    break;
                }
                System.out.println();
                System.out.println(newCow.getImage());  //prints cow image

                break;
            case "-f": //access file
                newCow = findCow(args[1], fileCows);
                if(newCow == null){
                    break;
                }
                System.out.println();
                for (int i = 2; i < args.length; i++) {
                    System.out.print(args[i] + " ");  //prints message
                }
                System.out.println(newCow.getImage());
                break;
                
            default:  //prints message with default cow
                System.out.println();
                newCow = findCow("heifer", HeiferGenerator.getCows());  // creates default cow heifer
                for (int i = 0; i < args.length; i++) {
                    System.out.print(args[i] + " ");     //prints the message
                                         }
                System.out.println();
                System.out.println(newCow.getImage());  // prints cow image
                break;


        }
    }
}


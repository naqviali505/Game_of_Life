import java.util.*;

public class ConwayMain {

   static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ConwayWorld world = new ConwayWorld();

        // initially set some values alive
        for (int i = 0; i < 8; i++) {
            ConwayCell c = new ConwayCell(5, 5+i, world);
            c.setIsAlive(true);
            world.replaceCell(c); // replace the single cell.
        }


        // Add an always-alive cells
        //AbstractCell a = new AlwaysAliveCell(12, 12, world);
        //world.replaceCell(a);

        // Add an always-alive cells
       // AbstractCell n = new NeverAliveCell(17, 17, world);
       // world.replaceCell(n);

        // Add a Blinker cell
        for (int i = 0; i < 3; i++){
            BlinkerCell t = new BlinkerCell(13, 3+i, world);
            t.setIsAlive(true);
            world.replaceCell(t);
        }


        for (int i = 0; i < 19; i++){
            ConwayCell t = new ConwayCell(15, 1+i, world);
            t.setIsAlive(true);
            world.replaceCell(t);

        }

        // Go!
        do {
            world.display();
            world.advanceToNextGeneration();

            System.out.print("Another? (y/n): ");
        } while (input.nextLine().charAt(0) == 'y');
    }
}
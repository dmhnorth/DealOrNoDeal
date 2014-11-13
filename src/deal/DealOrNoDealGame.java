package deal;

import java.util.Random;
import java.util.Scanner;

public class DealOrNoDealGame {
    Random random = new Random();

    public void start() {

        Box[] boxes;
        Box myBox;
        int gameSize = 23;
        Scanner sc = new Scanner(System.in);

        boxes = new Box[gameSize];

        populateBoxes(boxes);

        myBox = boxes[random.nextInt(gameSize)];
        myBox.open();

        System.out.println("Welcome to Deal or No Deal. You have box: " + myBox.toString());

        printGame(boxes);

        System.out.println("Please choose 5 boxes to start the game: ");

        for (int i = 0; i < 5; i++) {
            boxes[sc.nextInt() - 1].open();
            System.out.println("Choose another: ");
        }
        printGame(boxes);

        System.out.println("Your current offer is: " + getCurrentOffer(boxes));




    }

    private int getCurrentOffer(Box[] boxes) {
        return 0;
    }

    private void printGame(Box[] boxes) {
        for (Box b : boxes) {
            System.out.println(b.toString());
        }
    }

    private void populateBoxes(Box[] boxes) {

        int value = 10;

        for (int box = 0; box < boxes.length; box++) {
            boxes[box] = new Box(box + 1, random.nextInt(value + 1000));
            value *= 2;
        }
    }
}


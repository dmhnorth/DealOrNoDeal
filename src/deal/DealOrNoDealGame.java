package deal;

import java.util.ArrayList;
import java.util.Collections;
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

//        populateBoxesWithRandomValues(boxes);
        populateBoxesWithFixedValues(boxes);

        myBox = boxes[random.nextInt(gameSize)];
        myBox.open();

        System.out.println("Welcome to Deal or No Deal. You have box: " + myBox.toString());

        printGame(boxes);
        printCurrentOffer(boxes);

        System.out.println("Please choose 5 boxes to start the game: ");

        for (int i = 0; i < 5; i++) {
            boxes[sc.nextInt() - 1].open();
            System.out.println("Choose another: ");
        }
        printGame(boxes);
        printCurrentOffer(boxes);

    }

    private void printCurrentOffer(Box[] boxes) {
        System.out.println("Your current offer is: " + getCurrentOffer(boxes));

    }

    private int getCurrentOffer(Box[] boxes) {

        int currentOffer = 0;
        int openBoxes = 0;

        for(Box b : boxes) {
            if(b.isOpened()) {
                currentOffer += b.getValue();
                openBoxes++;
            }
        }

        if(openBoxes < 2) {
            openBoxes = 2;
        }
        return currentOffer/openBoxes;
    }

    private void printGame(Box[] boxes) {
        for (Box b : boxes) {
            System.out.println(b.toString());
        }
    }

    private void populateBoxesWithRandomValues(Box[] boxes) {

        int value = 10;

        for (int box = 0; box < boxes.length; box++) {
            boxes[box] = new Box(box + 1, random.nextInt(value + 1000));
            value *= 2;
        }
    }


    private void populateBoxesWithFixedValues(Box[] boxes) {

        int value = 1;

        ArrayList<Integer> fixedValues = new ArrayList<Integer>();
        for (Box ignored : boxes) {
            fixedValues.add(value);
            value += 1;
        }
        Collections.shuffle(fixedValues);

        for (int box = 0; box < boxes.length; box++) {
            boxes[box] = new Box(box + 1, fixedValues.get(box));
        }
    }
}


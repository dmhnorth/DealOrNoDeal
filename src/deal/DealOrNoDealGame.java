package deal;

import java.util.Random;

public class DealOrNoDealGame {

    public void start() {

        Box[] boxes;
        Box myBox;
        int gameSize = 15;

        boxes = new Box[gameSize];

        populateBoxes(boxes);

        Random random = new Random();
        myBox = boxes[random.nextInt(gameSize)];
        myBox.open();

        System.out.println("Welcome to Deal or No Deal. You have box: " + String.valueOf(myBox.getId()));

        for (Box b : boxes) {
            System.out.println(b.toString());

        }
    }

    private static void populateBoxes(Box[] boxes) {

        for (int box = 0; box < boxes.length; box++) {
            boxes[box] = new Box(box + 1, 1000);
        }
    }
}


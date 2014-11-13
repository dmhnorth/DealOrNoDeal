package deal;

import java.util.Random;

public class DealOrNoDealGame {
    Random random = new Random();

    public void start() {

        Box[] boxes;
        Box myBox;
        int gameSize = 15;

        boxes = new Box[gameSize];

        populateBoxes(boxes);

        myBox = boxes[random.nextInt(gameSize)];
        myBox.open();

        System.out.println("Welcome to Deal or No Deal. You have box: " + String.valueOf(myBox.getId()));

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


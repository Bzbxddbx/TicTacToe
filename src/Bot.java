import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Bot {
    public static List<List<Integer>> fieldArray = new ArrayList<>();

    private static int x;
    private static int y;

    public Bot() {
        fieldArray.add(Arrays.asList(0, 0));
        fieldArray.add(Arrays.asList(0, 1));
        fieldArray.add(Arrays.asList(0, 2));
        fieldArray.add(Arrays.asList(1, 0));
        fieldArray.add(Arrays.asList(1, 1));
        fieldArray.add(Arrays.asList(1, 2));
        fieldArray.add(Arrays.asList(2, 0));
        fieldArray.add(Arrays.asList(2, 1));
        fieldArray.add(Arrays.asList(2, 2));

        if (GUI.value % 2 != 0) {
            while (!fieldArray.isEmpty()) {addressGenerate();
                if (fieldArray.contains(Arrays.asList(x, y)) && GUI.buttons[x][y].isEnabled()) {
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {}
                    fieldArray.remove(Arrays.asList(x, y));
                    GUI.buttons[x][y].doClick();
                    break;
                } else {
                    while (!fieldArray.contains(Arrays.asList(x, y)) && !GUI.buttons[x][y].isEnabled()) {
                        addressGenerate();
                    }
                }
            }
        }
    }

    public static void addressGenerate() {
        Random random = new Random();
        x = random.nextInt(3);
        y = random.nextInt(3);
    }
}

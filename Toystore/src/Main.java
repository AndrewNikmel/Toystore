import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Play play = new Play();
        SaveFile csv = new SaveFile();
        List<Toys> toys = play.createToys();
        csv.writeResult(toys.get(0), false);
        toys.remove(0);
        for (Toys item : toys) {
            csv.writeResult(item, true);
        }
        UI ui = new UI();
        ui.menu();
    }
}

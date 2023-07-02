import java.util.List;

public class Print {
    public static void printFiles(List<Toys> toyList){
        for (Toys item: toyList) {
            System.out.printf("%s, ", item.getId());
            System.out.printf("%s, ", item.getName());
            System.out.printf("%s \n", item.getQuantity());
        }
    }

    //public static void printFiles(Toys toy){
    //    System.out.print(String.format("%s. ", toy.getId()));
    //    System.out.print(String.format("%s, ", toy.getName()));
    //    System.out.print(String.format("%s, ", toy.getQuantity()));
    //    System.out.println(String.format("%s ", toy.getFrequency()));
    //}
}

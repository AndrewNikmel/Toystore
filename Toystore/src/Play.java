import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Play {
    public List<Toys> elementWeight(List<Toys> toyList){
//        Print pf = new Print();
        if (toyList.size() > 0){
            ArrayList<Double> weights = new ArrayList<>();
            double sumWeight = 1;
            double count_freq = 0;
            for (Toys item: toyList) {
                weights.add(item.getFrequency());
                sumWeight += item.getFrequency();
            }
            Random rnd = new Random();
            int rndNumber = rnd.nextInt(1, (int) sumWeight);

            for (Toys item: toyList) {
                count_freq += item.getFrequency();
                if (count_freq >= rndNumber){
                    if (item.getQuantity() > 0){
                        System.out.printf("Игрушка: %s, %d\n", item.getName(), item.getQuantity());
                        item.setQuantity(item.getQuantity() - 1);
                        break;
                    }else{
                        System.out.printf("Игрушка: %s, %d\n", item.getName(), item.getQuantity());
                        toyList.remove(item);
                        break;
                    }
                }
            }
        }else{
            System.out.println("Игрушек нет в наличии");
        }

        return toyList;
    }

    public List<Toys> addToy(List<Toys> toys, Toys toy){
        for (Toys item: toys) {
            if (item.getName().equals(toy.getName())){
                item.setQuantity(item.getQuantity() + toy.getQuantity());
                System.out.println("Игрушка с таким именем уже есть");
                return toys;
            }
        }
        toys.add(toy);

        return toys;
    }

    public List<Toys> createToys(){
        Toys toy1 = new Toys(1, "Котенок", 10, 10);
        Toys toy2 = new Toys(2, "Песик", 10, 20);
        Toys toy3 = new Toys(3, "Дельфин", 10, 30);
        Toys toy4 = new Toys(4, "Лисенок", 10, 40);
        Toys toy5 = new Toys(5, "Крокодил", 10, 50);
        Toys toy6 = new Toys(6, "Цыпленок", 10, 60);
        Toys toy7 = new Toys(7, "Обезьянка", 10, 70);
        Toys toy8 = new Toys(8, "Чебурашка", 10, 80);
        Toys toy9 = new Toys(9, "Медвежонок", 10, 90);
        Toys toy10 = new Toys(10, "Рыбка", 10, 99);
        List<Toys> toys = new ArrayList<>();
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);
        toys.add(toy4);
        toys.add(toy5);
        toys.add(toy6);
        toys.add(toy7);
        toys.add(toy8);
        toys.add(toy9);
        toys.add(toy10);
        return toys;
    }
}

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UI {
    final String MENU = "1. Добавить новую игрушку.\n" +
                "2. Загрузить все игрушки.\n" +
                "3. Изменить рейтинг игрушки.\n" +
                "4. Разыграть игрушки.\n" +
                "5. Выход.\n";

    public void menu() throws IOException {
        String name;
        int quantity;
        double frequency;
        int lineNumber;
        Double newFrequency;
        Scanner scan = new Scanner(System.in);
        ReadFile rcvs = new ReadFile();
        List<Toys> toys = rcvs.readFile();
        while (true) {
            System.out.println("Выберите действие: ");
            System.out.println(MENU);
            String user_choose = scan.nextLine();
            if (user_choose.equals("1")) {
                System.out.println("Введите описание новой игрушки");
                while (true) {
                    System.out.println("Введите название Вашей игрушки: ");
                    name = scan.nextLine();
                    if (Proof.isNotEmpty(name)) {
                        break;
                    } else {
                        System.out.println("Вы не ввели никаких данных. Попробуйте еще раз.");
                    }
                }
                while (true) {
                    System.out.println("Введите количество игрушек: ");
                    String quant = scan.nextLine();
                    if (Proof.isNumeric(quant)) {
                        quantity = Integer.parseInt(quant);
                        break;
                    } else {
                        System.out.println("В данную строку нужно вводить только числа. Поробуйте снова.");
                    }
                }
                while (true) {
                    System.out.println("Введите вероятность выпадения игрушки(от 0 до 100 %): ");
                    String frequencyTemp = scan.nextLine();
                    if (Proof.isReal(frequencyTemp) && Proof.isCorrectValue(frequencyTemp)) {
                        frequency = Double.parseDouble(frequencyTemp);
                        break;
                    } else {
                        System.out.println("В данную строку нужно вводить только числа. Попробуйте еще раз.");
                    }
                }
                int len = toys.size() + 1;
                Toys toy = new Toys(len, name, quantity, frequency);
                Play play = new Play();
                play.addToy(toys, toy);

            } else if (user_choose.equals("2")) {
                if (toys.size() != 0) {
                    Print.printFiles(toys);
                } else {
                    System.out.println("Нет доступных игрушек. Необходимо создать новую игрушку.");
                }

            } else if (user_choose.equals("3")) {
                if (toys.size() != 0) {
                    while (true) {
                        System.out.println("Введите номер записи, которую хотите редактировать: ");
                        String lineNumb = scan.nextLine();
                        if (Proof.isNumeric(lineNumb) && Integer.parseInt(lineNumb) <= toys.size()) {
                            lineNumber = Integer.parseInt(lineNumb);
                            break;
                        } else {
                            System.out.println("В данную строку нужно вводить только числа. Попробуйте еще раз.");
                        }
                    }
                    while (true) {
                        System.out.println("Введите новое значение частоты выпадания игрушки в процентах от 0 до 100: ");
                        String frequencyTemp1 = scan.nextLine();
                        if (Proof.isReal(frequencyTemp1) && Proof.isCorrectValue(frequencyTemp1)) {
                            newFrequency = Double.parseDouble(frequencyTemp1);
                            break;
                        } else {
                            System.out.println("В данную строку нужно вводить только числа. Попробуйте еще раз.");
                        }
                    }
                    toys.get(lineNumber - 1).setFrequency(newFrequency);
                } else {
                    System.out.println("Нет подходящих игрушек для редактирования. Создайте новую игрушку.");
                }
            } else if (user_choose.equals("4")) {
                System.out.println("4");
                Play play = new Play();
                play.elementWeight(toys);
            } else if (user_choose.equals("5")) {
                System.out.println("Программа завершила свою работу.");
                if (toys.size() != 0) {
                    SaveFile csv = new SaveFile();
                    csv.writeResult(toys.get(0), false);
                    toys.remove(0);
                    for (Toys item : toys) {
                        csv.writeResult(item, true);
                    }
                    break;
                } else {
                    break;
                }
            } else {
                System.out.println("Некорректный ввод. Попробуйте еще раз");
            }
        }
    }
}

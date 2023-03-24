package Task_27;

public class Logs extends Lumber{

    @Override
    public void harvestTimber() {
        System.out.println("Заготовка бревен");
    }

    @Override
    public void processWood() {
        System.out.println("Обработка бревен");
    }
}
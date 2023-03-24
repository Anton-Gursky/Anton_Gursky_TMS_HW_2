package Task_27;

public class Planks extends Lumber{

    @Override
    public void harvestTimber() {
        System.out.println("Заготовка бревен на доски");
    }

    @Override
    public void processWood() {
        System.out.println("Обработка древесины для создания досок");
    }
}
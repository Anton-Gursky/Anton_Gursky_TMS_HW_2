package Task_27;

public class Panels extends Lumber{

    @Override
    public void harvestTimber() {
        System.out.println("Заготовка дерева на панели");
    }

    @Override
    public void processWood() {
        System.out.println("Заготовка панелей");
    }
}
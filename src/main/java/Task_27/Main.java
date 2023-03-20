package Task_27;

public class Main {

    public static void main(String[] args){

        WoodFactory factory = new WoodFactory();

        //Создаем объект класса Planks и используем методы
        Lumber planks = factory.orderLumber(LumberType.PLANKS);

        //Создаем объект класса Logs и используем методы
        Lumber logs = factory.orderLumber(LumberType.LOGS);

        //Создаем объект класса Panels и используем методы
        Lumber panels = factory.orderLumber(LumberType.PANELS);

        planks.harvestTimber();
        planks.processWood();

        logs.harvestTimber();
        logs.processWood();

        panels.harvestTimber();
        panels.processWood();
    }
}
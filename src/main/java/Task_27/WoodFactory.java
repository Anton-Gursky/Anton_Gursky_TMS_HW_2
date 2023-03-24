package Task_27;

public class WoodFactory {

    public Lumber orderLumber(LumberType type){

        switch (type){
            case PLANKS: return new Planks();
            case LOGS: return new Logs();
            case PANELS: return new Panels();
        }
        return null;
    }
}

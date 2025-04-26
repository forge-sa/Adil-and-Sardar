public class Wizzard extends Unite{
    
    public Wizzard(String t, int h) {
        super(t, h);
        setType("Wizzard");
        setHp(getHp() + 10);
    }
    
}
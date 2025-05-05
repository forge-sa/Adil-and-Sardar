public class Wizzard extends Unite {
    public Wizzard(String t, int h, String s) {
        super(t, h, s);
        setType("Wizard");
        setSloghan("My mana is stronger than katana");
        setHp(getHp() + 10);
    }
}
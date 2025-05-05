public class Elf extends Unite {
    public Elf(String t, int h, String s) {
        super(t, h, s);
        setType("Elf");
        setSloghan("My arrow sends my power");
        setAttack(getAttack() + 2);
    }
}
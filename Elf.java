public class Elf extends Unite{
    
    public Elf(String t, int h) {
        super(t, h);
        setType("Elf");
        setAttack(getAttack() + 2);
    }
    
}
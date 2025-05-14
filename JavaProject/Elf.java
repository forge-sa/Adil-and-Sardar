public class Elf extends Unite{
    
    public Elf(String t, String s, int h) {
        super(t, s, h);
        setType("Elf");
	    setSlog("I CAN FEEL SPIRITS ARE HERE WHITH ME");
        setAttack(getAttack() + 1);
    }
    
}

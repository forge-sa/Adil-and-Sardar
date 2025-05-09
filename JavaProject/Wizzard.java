public class Wizzard extends Unite{
    
    public Wizzard(String t, String s, int h) {
        super(t, s, h);
        setType("Wizzard");
	setSlog("MAGYC P-P-PAW! POODOOF! BOOM!");
        setHp(getHp() + 10);
    }
    
}

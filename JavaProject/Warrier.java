public class Warrier extends Unite{
    
    public Warrier(String t, String s, int h) {
        super(t, s, h);
        setType("Warrier");
	setSlog("ATTACK FOR GO-O-OD AND KI-I-ING!");
        setDefence(getDefence() + 1);
    }
    
}

public class Warrier extends Unite{
    public Warrier(String t, int h, String s) {
        super(t, h);
        setType("Warrier");
        setSloghan("My sword sharper than Shekspirs word");
        setDefence(getDefence() + 2);
    }
}
    
public class Unite{
    private String type;
    private String slog;
    private int hp;
    private double attack;
    private double defence;

    public Unite(String t, String s, int h){
        type = t;
	    slog = s;
        hp = h;
        attack = 3 + Math.random()*4;
        defence = 3 + Math.random()*4;
    }
    // Задает тип
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSlog() {
        return slog;
    }
    public void setSlog(String slog){
        this.slog = slog;
    }
    // Задает деф
    public double getDefence() {
        return defence;
    }
    public void setDefence(double defence) {
        this.defence = defence;
    }
    // Задает дамаг    
    public double getAttack() {
        return attack;
    }
    public void setAttack(double attack) {
        this.attack = attack;
    }
    // Задает хп
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
 public void shoutSlogan() {
        System.out.println(getType() + " SCREAMS: \"" + getSlog() + "\"");
    }
}

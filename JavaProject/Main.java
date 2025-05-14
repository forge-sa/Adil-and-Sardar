import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
    
public class Main {
    public static void main(String[] args) {
        List<Unite> playerCharacters = new ArrayList<>();
        List<Unite> opponentCharacters = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            int choice = random.nextInt(3); // Рандом из 0, 1, и 2
            if (choice == 0) {
                playerCharacters.add(new Warrier("Warrier", "ATTACK FOR GO-O-OD AND KI-I-ING!", 3)); // Делает Варриера
            } else if (choice == 1) {
                playerCharacters.add(new Wizzard("Wizzard", "MAGYC P-P-PAW! POODOOF! BOOM!",3)); // Делает Магу
            } else {
                playerCharacters.add(new Elf("Elf","I CAN FEEL SPIRITS ARE HERE WHITH ME", 3)); // Делает Эльфа
            }
        }

        for (int i = 0; i < 5; i++) {
            int choice = random.nextInt(3); // Рандом из 0, 1, и 2
            if (choice == 0) {
                opponentCharacters.add(new Warrier("Warrier", "ATTACK FOR GO-O-OD AND KI-I-ING!", 3)); // Делает Варриера
            } else if (choice == 1) {
                opponentCharacters.add(new Wizzard("Wizzard", "MAGYC P-P-PAW! POODOOF! BOOM!", 3)); // Делает Магу
            } else {
                opponentCharacters.add(new Elf("Elf","I CAN FEEL SPIRITS ARE HERE WHITH ME", 3)); // Делает Эльфа
            }
        }

        // Стата персонажей игрока
        System.out.println("Player's Characters:");
        for (int i = 0; i < playerCharacters.size(); i++) {
            Unite character = playerCharacters.get(i);
            System.out.println(i + 1 + ". Type: " + character.getType() + 
                               ", HP: " + character.getHp() + 
                               ", Attack: " + (int) character.getAttack() + 
                               ", Defence: " + (int) character.getDefence());
        }
 //        System.out.println("Opponent's Characters: ");
 //        for (int i = 0; i < opponentCharacters.size(); i++) {
 //            Unite character = opponentCharacters.get(i);
 //            System.out.println(i + 1 + ". Type: " + character.getType() + 
 //                               ", HP: " + character.getHp() + 
 //                               ", Attack: " + (int) character.getAttack() + 
 //                               ", Defence: " + (int) character.getDefence());
 //        }

        // Вайл 
        while (!playerCharacters.isEmpty() && !opponentCharacters.isEmpty()) {
            // Выбор игроком
            System.out.println("Choose your character (1-" + playerCharacters.size() + "):");
            int playerChoice = scanner.nextInt() - 1;

            if (playerChoice < 0 || playerChoice >= playerCharacters.size()) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Unite playerCharacter = playerCharacters.get(playerChoice);

            // Противник тычет на рандом
            Unite opponentCharacter = opponentCharacters.get(random.nextInt(opponentCharacters.size()));

            System.out.println("BATTLE:");
            System.out.println(" ");
            System.out.println("Player's " + playerCharacter.getType() + " vs Opponent's " + opponentCharacter.getType());
            System.out.println(" ");
            playerCharacter.shoutSlogan();  // Игрок орёт
            System.out.println(" ");
	        opponentCharacter.shoutSlogan(); // Противник орёт
            System.out.println(" ");

            // Битва дамаг - деф
            int playerPower = (int) (playerCharacter.getAttack() - (opponentCharacter.getDefence() + opponentCharacter.getHp()));
 //            System.out.println("Player's power = Player's attack - Opponent's defence + hp: " + playerPower);
 //            System.out.println("Player's attack: " + (int) playerCharacter.getAttack());
 //            System.out.println("Opponent's defence: " + (int) opponentCharacter.getDefence());
 //            System.out.println("Opponent's hp: " + opponentCharacter.getHp());
            int opponentPower = (int) (opponentCharacter.getAttack() - (playerCharacter.getDefence() + playerCharacter.getHp()));
 //            System.out.println("Opponent's power = Opponent's attack - Player's defence + hp: " + opponentPower);
 //            System.out.println("Opponent's attack: " + (int) opponentCharacter.getAttack());
 //            System.out.println("Player's defence: " + (int) playerCharacter.getDefence());
 //            System.out.println("Player's hp: " + playerCharacter.getHp());
            if (playerPower > opponentPower && playerPower > 0) {
 //                System.out.println("If Player's power > than Opponent's Player wins. Player's power: " + playerPower);
                System.out.println("Player's " + playerCharacter.getType() + " wins!");
                opponentCharacters.remove(opponentCharacter); // Противник теряет персонажа
            } else if (opponentPower > playerPower && opponentPower > 0) {
 //                System.out.println("If Opponent's power > than Player's Opponent wins. Opponent's power: " + opponentPower);
                System.out.println("Opponent's " + opponentCharacter.getType() + " wins!");
                playerCharacters.remove(playerCharacter); // Игрок теряет персонажа
            } else {
                System.out.println("It's a draw! Both characters are dead.");
                playerCharacters.remove(playerCharacter);
                opponentCharacters.remove(opponentCharacter);
            }
            System.out.println(" ");

            // Остаток персонажей
            System.out.println("Remaining Player Characters: " + playerCharacters.size());
            System.out.println("Remaining Opponent Characters: " + opponentCharacters.size());
        }

        // Победттель
        if (playerCharacters.isEmpty() && opponentCharacters.isEmpty()) {
            System.out.println("It's a draw! Both sides lost all characters.");
        } else if (playerCharacters.isEmpty()) {
            System.out.println("Opponent wins!");
        } else {
            System.out.println("Player wins!");
        }

        scanner.close();
    }
}

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

        // Генерирует 5 рандомных персонажей для игрока
        for (int i = 0; i < 5; i++) {
            int choice = random.nextInt(3); // Рандом из 0, 1, и 2
            if (choice == 0) {
                playerCharacters.add(new Warrier("Warrier", 100)); // Делает Варриера
            } else if (choice == 1) {
                playerCharacters.add(new Wizzard("Wizzard", 100)); // Делает Магу
            } else {
                playerCharacters.add(new Elf("Elf", 100)); // Делает Эльфа
            }
        }

        // Генерирует 5 рандомных персонажей для противника
        for (int i = 0; i < 5; i++) {
            int choice = random.nextInt(3); // Рандом из 0, 1, и 2
            if (choice == 0) {
                opponentCharacters.add(new Warrier("Warrier", 100)); // Делает Варриера
            } else if (choice == 1) {
                opponentCharacters.add(new Wizzard("Wizzard", 100)); // Делает Магу
            } else {
                opponentCharacters.add(new Elf("Elf", 100)); // Делает Эльфа
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

        // Вайл 
        while (!playerCharacters.isEmpty() && !opponentCharacters.isEmpty()) {
            // Выбор игроком
            System.out.println("\nChoose your character (1-" + playerCharacters.size() + "):");
            int playerChoice = scanner.nextInt() - 1;

            if (playerChoice < 0 || playerChoice >= playerCharacters.size()) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Unite playerCharacter = playerCharacters.get(playerChoice);

            // Противник тычет на рандом
            Unite opponentCharacter = opponentCharacters.get(random.nextInt(opponentCharacters.size()));

            System.out.println("\nBattle:");
            System.out.println("Player's " + playerCharacter.getType() + " vs Opponent's " + opponentCharacter.getType());

            // Битва дамаг - деф
            int playerPower = (int) (playerCharacter.getAttack() - opponentCharacter.getDefence());
            int opponentPower = (int) (opponentCharacter.getAttack() - playerCharacter.getDefence());
            if (playerCharacter.getDefence() == 0) {
                opponentPower = (int) opponentCharacter.getAttack() - playerCharacter.getHp();
            }
            if (opponentCharacter.getDefence() == 0) {
                playerPower = (int) playerCharacter.getAttack() - opponentCharacter.getHp();
            }
            if (playerPower > opponentPower) {
                System.out.println("Player's " + playerCharacter.getType() + " wins!");
                opponentCharacters.remove(opponentCharacter); // Противник теряет персонажа
            } else if (opponentPower > playerPower) {
                System.out.println("Opponent's " + opponentCharacter.getType() + " wins!");
                playerCharacters.remove(playerCharacter); // Игрок теряет персонажа
            } else {
                System.out.println("It's a draw! Both characters are removed.");
                playerCharacters.remove(playerCharacter);
                opponentCharacters.remove(opponentCharacter);
            }

            // Остаток персонажей
            System.out.println("\nRemaining Player Characters: " + playerCharacters.size());
            System.out.println("Remaining Opponent Characters: " + opponentCharacters.size());
        }

        // Победттель
        if (playerCharacters.isEmpty() && opponentCharacters.isEmpty()) {
            System.out.println("\nIt's a draw! Both sides lost all characters.");
        } else if (playerCharacters.isEmpty()) {
            System.out.println("\nOpponent wins!");
        } else {
            System.out.println("\nPlayer wins!");
        }

        scanner.close();
    }
}
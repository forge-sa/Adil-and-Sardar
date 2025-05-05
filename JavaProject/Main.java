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
            int choice = random.nextInt(3);
            if (choice == 0) {
                playerCharacters.add(new Warrier("Warrier", 100));
            } else if (choice == 1) {
                playerCharacters.add(new Wizzard("Wizzard", 100));
            } else {
                playerCharacters.add(new Elf("Elf", 100));
            }
        }

        // Генерирует 5 рандомных персонажей для противника
        for (int i = 0; i < 5; i++) {
            int choice = random.nextInt(3);
            if (choice == 0) {
                opponentCharacters.add(new Warrier("Warrier", 100));
            } else if (choice == 1) {
                opponentCharacters.add(new Wizzard("Wizzard", 100));
            } else {
                opponentCharacters.add(new Elf("Elf", 100));
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

        // Основной игровой цикл
        while (!playerCharacters.isEmpty() && !opponentCharacters.isEmpty()) {
            // Выбор игроком
            System.out.println("Choose your character (1-" + playerCharacters.size() + "):");
            int playerChoice = scanner.nextInt() - 1;

            if (playerChoice < 0 || playerChoice >= playerCharacters.size()) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Unite playerCharacter = playerCharacters.get(playerChoice);

            // Противник выбирает случайно
            Unite opponentCharacter = opponentCharacters.get(random.nextInt(opponentCharacters.size()));

            System.out.println("Battle:");
            System.out.println("Player's " + playerCharacter.getType() + " vs Opponent's " + opponentCharacter.getType());

            // Расчет боя
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
                opponentCharacters.remove(opponentCharacter);
            } else if (opponentPower > playerPower) {
                System.out.println("Opponent's " + opponentCharacter.getType() + " wins!");
                playerCharacters.remove(playerCharacter);
            } else {
                System.out.println("It's a draw! Both characters are removed.");
                playerCharacters.remove(playerCharacter);
                opponentCharacters.remove(opponentCharacter);
            }

            // Остаток персонажей
            System.out.println("Remaining Player Characters: " + playerCharacters.size());
            System.out.println("Remaining Opponent Characters: " + opponentCharacters.size());
        }

        // Определение победителя
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
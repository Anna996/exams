package enemy;

import java.util.Arrays;
import java.util.List;

public class Runner {

	// Design pattern: Adapter  -  (GoodHelicopter class)
	public static void main(String[] args) {
		List<Enemy> enemies = Arrays.asList(
				new EnemyTank(),
				new GoodHelicopter(new BadHelicopter()));
		
		enemies.forEach(enemy -> {
			System.out.println("Enemy is doing operations:");
			System.out.println("=======================");
			enemy.turnRight();
			enemy.turnLeft();
			enemy.driveForward();
			enemy.driveBackward();
			enemy.fireWeapon();
			System.out.println("\n");
		});
	}
}

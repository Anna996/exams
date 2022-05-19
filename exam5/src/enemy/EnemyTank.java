package enemy;

public class EnemyTank implements Enemy {

	@Override
	public void turnRight() {
		System.out.println("EnemyTank turns right ");
	}

	@Override
	public void turnLeft() {
		System.out.println("EnemyTank turns left ");
	}

	@Override
	public void driveForward() {
		System.out.println("EnemyTank drives forward");
	}

	@Override
	public void driveBackward() {
		System.out.println("EnemyTank drives backward");
	}

	@Override
	public void fireWeapon() {
		System.out.println("EnemyTank fires weapon");
	}
}

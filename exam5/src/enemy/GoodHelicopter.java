package enemy;

public class GoodHelicopter implements Enemy {

	private BadHelicopter helicopter;

	public GoodHelicopter(BadHelicopter helicopter) {
		this.helicopter = helicopter;
	}

	@Override
	public void turnRight() {
		helicopter.yawsRight();
	}

	@Override
	public void turnLeft() {
		helicopter.yawsLeft();
	}

	@Override
	public void driveForward() {
		helicopter.fliesUp();
	}

	@Override
	public void driveBackward() {
		helicopter.fliesDown();
	}

	@Override
	public void fireWeapon() {
		helicopter.launchesMissile();
	}
}

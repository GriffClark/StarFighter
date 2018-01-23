
public class Debuff {
	protected double speedDebuff, healthDebuff, attackDebuff;
	//make it so that each ship can get a debuff. Maybe each ship has an ArrayList of debuffs?
	//so if health debuff is .5 when you take damage your health will subtract by half before taking damage. you want a small debuff (.05) not a big one (.9)

	public double getSpeedDebuff() {
		return speedDebuff;
	}

	public void setSpeedDebuff(double speedDebuff) {
		this.speedDebuff = speedDebuff;
	}

	public double getHealthDebuff() {
		return healthDebuff;
	}

	public void setHealthDebuff(double healthDebuff) {
		this.healthDebuff = healthDebuff;
	}

	public double getAttackDebuff() {
		return attackDebuff;
	}

	public void setAttackDebuff(double attackDebuff) {
		this.attackDebuff = attackDebuff;
	}
}

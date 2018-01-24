
public class PDC extends Weapon{

	public PDC(Ship owner) {
		super(owner);
		range = owner.getRange() / 2;
		attack = owner.getAttack() / 2;
		ammo = owner.getHealth(); //idk had to pick a number
		name = "Point_Defense_Cannons";
		
		
	}
}

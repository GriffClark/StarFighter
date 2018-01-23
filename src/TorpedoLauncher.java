
public class TorpedoLauncher extends Weapon{

	public TorpedoLauncher(Ship owner) {
		super(owner);
		ammo = 4;
	}
	
	@Override
	public void fire(Ship target) {
		if(ammo > 0) {
			ammo --;
			Torpedo torpedo = new Torpedo(owner.getLocation(), target.getLocation());
			Model.getGameModel().getProjectiles().add(torpedo);
		}
		
		
	}
	
	

}

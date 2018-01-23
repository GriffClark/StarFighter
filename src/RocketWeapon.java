import java.util.ArrayList;

public class RocketWeapon extends Weapon {
	protected int speed;

	public RocketWeapon(Ship owner) {
		super(owner);
	}
	
	@Override 
	public void fire(Ship target) {
		int initialDistance = Controller.getDistance(owner.getLocation(), target.getLocation());
		int distanceToTravel = initialDistance;
		if(distanceToTravel <= speed) {
			target.takeDamage(attack);
			special(target);
		}
		//build some sort of suspend method becuase rockets travel at a certian speed
	}
	
	@Override
	public void special (Ship target) {
		//how do I make it so that it explodes on all the things nearby?
	}

}

import java.util.ArrayList;

public class RocketWeapon extends Weapon {
	protected int speed;

	public RocketWeapon(Ship owner) {
		super(owner);
	}
	
	@Override 
	public int fire(Ship target) {
		//build some sort of suspend method becuase rockets travel at a certian speed
	}
	
	@Override
	public void special (Ship target, ArrayList<Object> thingsNearBy) {
		for(int i = 0; i < thingsNearBy.size(); i++) {
			//by doing it this way it only hits things that ship can see. Would be better if I did it 1 around the object
			if(Controller.getDistance(target.getLocation(), thingsNearBy.get(i).getLocation()) <2) {
				Ship maybe;
				if(thingsNearBy.get(i)./*is a ship*/) {
					//deal 1/2 damage to everything nearby
				}
			}
		}
	}

}

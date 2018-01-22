import java.util.ArrayList;

	public class Location {
		protected int x;
		protected int y;
		protected boolean isEmpty; //can I do this? do locations exist independently of ships or are locations only in existance while there are ships
		
		public Location(int x, int y)
		{
			this.x = x;
			this.y = y;
			
		}
		
		public int getX() { return x; }
		public int getY() { return y; }
		public boolean getEmpty() {return isEmpty;}
		public void setEmpty(Boolean empty)
		{
			this.isEmpty = empty;
		}
		
		public String toString()
		{
			return "(" + x +  "," + y + ")";
		}
		}

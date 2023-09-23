class Computer {
	public void playMusic() {
		System.out.println("Playing music");
	}

	public String getMeAPen(int cost) {
		if(cost >= 10)
			return "Pen";

		return "Nothing";
	}
}

public class Hello {
	public static void main(String[] args) {
		Computer comp = new Computer();
		// comp.playMusic();
		System.out.println(comp.getMeAPen(5));
	}
}

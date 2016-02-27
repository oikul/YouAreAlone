package game;

public class Emotion {
	
	public static final Emotion confused = new Emotion("Confused.");
	public static final Emotion hurt = new Emotion("Hurt.");
	public static final Emotion insecure = new Emotion("Insecure.");
	public static final Emotion bitter = new Emotion("Bitter.");
	public static final Emotion ashamed = new Emotion("Ashamed.");
	public static final Emotion tense = new Emotion("Tense.");
	public static final Emotion vulnerable = new Emotion("Vulnerable.");
	public static final Emotion shy = new Emotion("Shy.");
	
	public static final Emotion angry = new Emotion("Angry.");
	public static final Emotion sad = new Emotion("Sad.");
	public static final Emotion fear = new Emotion("Fear.");
	public static final Emotion depressed = new Emotion("Depressed.");
	public static final Emotion hatred = new Emotion("Hatred.");
	public static final Emotion desperate = new Emotion("Desperate.");
	public static final Emotion empty = new Emotion("Empty.");
	public static final Emotion lost = new Emotion("Lost.");
	
	public static final Emotion happy = new Emotion("Happy.");
	
	private String name;
	
	public Emotion(String name){
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

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
	
	public static final Emotion anger = new Emotion("Anger.");
	public static final Emotion sadness = new Emotion("Sadness.");
	public static final Emotion fear = new Emotion("Anger.");
	public static final Emotion depressed = new Emotion("Anger.");
	public static final Emotion hatred = new Emotion("Anger.");
	public static final Emotion desperate = new Emotion("Anger.");
	public static final Emotion empty = new Emotion("Anger.");
	public static final Emotion lost = new Emotion("Anger.");
	
	public static final Emotion happy = new Emotion("Anger.");
	
	private String name;
	
	public Emotion(String name){
		this.name = name;
	}

}

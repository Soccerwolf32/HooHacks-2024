import android.content.SharedPreferences;

/**
 * Contains the data of the friend
 */
public class Friend {

    private int friendStrength;
    private int friendEndurance;
    private int friendCardio;
    private int friendFlexibility;
    private int friendLevel;
    private int friendEXP;
    private int friendEXPThreshold;

    private final int MAX_FRIEND_STRENGTH = 100;
    private final int MAX_FRIEND_ENDURANCE = 100;
    private final int MAX_FRIEND_CARDIO = 100;
    private final int MAX_FRIEND_FLEXIBILITY = 100;
    private final int MAX_FRIEND_LEVEL = 100;
    private final int MAX_FRIEND_EXP = 100;
    private final int THRESHOLD_MULTIPLIER = 2;

    public static final String SHARED_PREFS = "sharedPrefs";


    public Friend(){
        friendStrength = 1;
        friendEndurance = 1;
        friendCardio = 1;
        friendFlexibility = 1;
        friendLevel = 1;
        friendEXP = 1;
        friendEXPThreshold = 1;
    }

    public int getFriendStrength() {
        return friendStrength;
    }

    public void setFriendStrength(int friendStrength) {
        this.friendStrength = friendStrength;
        if(this.friendStrength >= MAX_FRIEND_STRENGTH)
            this.friendStrength = MAX_FRIEND_STRENGTH;
    }

    public int getFriendEndurance() {
        return friendEndurance;
    }

    public void setFriendEndurance(int friendEndurance) {
        this.friendEndurance = friendEndurance;
        if(this.friendEndurance >=  MAX_FRIEND_ENDURANCE)
            this.friendEndurance = MAX_FRIEND_ENDURANCE;
    }

    public int getFriendCardio() {
        return friendCardio;
    }

    public void setFriendCardio(int friendCardio) {
        this.friendCardio = friendCardio;
        if(this.friendCardio >= MAX_FRIEND_CARDIO)
            this.friendCardio = MAX_FRIEND_CARDIO;
    }

    public int getFriendFlexibility() {
        return friendFlexibility;
    }

    public void setFriendFlexibility(int friendFlexibility) {
        this.friendFlexibility = friendFlexibility;
        if(this.friendFlexibility >= MAX_FRIEND_FLEXIBILITY)
            this.friendFlexibility = MAX_FRIEND_FLEXIBILITY;
    }

    public int getFriendLevel() {
        return friendLevel;
    }

    public void setFriendLevel(int friendLevel) {
        this.friendLevel = friendLevel;
        if(this.friendLevel >= MAX_FRIEND_LEVEL)
            this.friendLevel = MAX_FRIEND_LEVEL;
    }

    public int getFriendEXP() {
        return friendEXP;
    }

    public void setFriendEXP(int friendEXP) {
        this.friendEXP = friendEXP;
        if(this.friendEXP >= MAX_FRIEND_EXP)
            this.friendEXP = MAX_FRIEND_EXP;
    }

    public int getFriendEXPThreshold() {
        return friendEXPThreshold;
    }

    public void setFriendEXPThreshold(int friendEXPThreshold) {
        this.friendEXPThreshold = friendEXPThreshold;
    }

    /**
        Levels up and sets new threshold when conditions are met
     */
    public void levelUp(Boss boss){
        if (this.friendLevel <= 100)
        {
            //TODO - Ends the game, Player Wins (or something else)
        }
        if(friendEXP > friendEXPThreshold){
            setFriendLevel(friendLevel + 1);
            setFriendEXPThreshold(friendEXPThreshold * THRESHOLD_MULTIPLIER);

            if (this.friendLevel >= boss.getLevel())
            {
                //TODO - Does something to declare user beats the boss before leveling up the boss
                boss.levelUp();
            }
        }
    }
}

/**
 * Contains the data of the friend
 */
public class Friend {
    private int friendLevel;
    private int friendEXP;
    private int friendEXPThreshold;

    private final int MAX_FRIEND_LEVEL = 100;
    private final int MAX_FRIEND_EXP = 100;
    private final int THRESHOLD_MULTIPLIER = 2;


    public Friend(){
        friendLevel = 1;
        friendEXP = 1;
        friendEXPThreshold = 1;
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

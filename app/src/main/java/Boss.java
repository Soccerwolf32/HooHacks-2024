public class Boss {
    private final int MAX_LEVEL = 100;
    private int bossLevel;

    //This creates the boss and sets it's initial level to 5
    public Boss()
    {
        bossLevel = 5;
    }

    //This levels the boss up by 5 levels each time it is defeated
    public void levelUp()
    {
        if (bossLevel < MAX_LEVEL)
        {
            bossLevel += 5;
        }
        else
        {
            //TODO - end the game or do something to prestige it, maybe reset entirely idk
        }
    }

    //This method returns the Current Level of the boss

    //@return level of the boss
    public int getLevel()
    {
        return this.bossLevel;
    }
}

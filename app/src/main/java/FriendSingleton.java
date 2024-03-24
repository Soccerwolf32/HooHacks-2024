public class FriendSingleton {

    private static Friend friend;

    public static Friend getFriend() {
        return friend;
    }

    public static void setFriend(Friend friend) {
        FriendSingleton.friend = friend;
    }
}

package sample;

public class tempDS {
    private String userID;
    private String userNickName;
    private String chatText;
    private Boolean isBadword;

    public tempDS(String userID, String userNickName, String chatText)
    {
        this.userID = userID;
        this.userNickName = userNickName;
        this.chatText = chatText;
        this.isBadword = false;
    }
    public String getChatText()
    {
        return chatText;
    }
    public String getUserID()
    {
        return userID;
    }
    public String getUserNickName()
    {
        return userNickName;
    }
    public Boolean getIsBadword()
    {
        return isBadword;
    }
    public void setIsBadword(boolean isBadword)
    {
        this.isBadword=isBadword;
    }
}


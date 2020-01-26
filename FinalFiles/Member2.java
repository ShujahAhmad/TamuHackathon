package ad3d.com.completeapp;
import android.widget.Switch;

public class Member2 {
    private String Name;
    private String Address;
    private String DoorLength;
    private String Doorwidth;
    private String MinTableHeight;
    private String ARScore;
    private String ExtraComments;
    private String RampBoolean;

    public Member2(){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDoorLength() {
        return DoorLength;
    }

    public void setDoorLength(String doorLength) {
        DoorLength = doorLength;
    }

    public String getDoorwidth() {
        return Doorwidth;
    }

    public void setDoorwidth(String doorwidth) {
        Doorwidth = doorwidth;
    }

    public String getMinTableHeight() {
        return MinTableHeight;
    }

    public void setMinTableHeight(String minTableHeight) {
        MinTableHeight = minTableHeight;
    }

    public String getARScore() {
        return ARScore;
    }

    public void setARScore(String ARScore) {
        this.ARScore = ARScore;
    }

    public String getExtraComments() {
        return ExtraComments;
    }

    public void setExtraComments(String extraComments) {
        ExtraComments = extraComments;
    }

    public String getRampBoolean() {
        return RampBoolean;
    }

    public void setRampBoolean(String rampBoolean) {
        RampBoolean = rampBoolean;
    }
}

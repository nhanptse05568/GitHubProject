package com.example.caula.gridlayoutwithcheckbox;

public class Girl {
    private String name;
    private int imageID;
    private boolean isChecked;

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Girl(String name, int imageID, boolean isChecked) {
        this.name = name;
        this.imageID = imageID;
        this.isChecked = isChecked;
    }
}

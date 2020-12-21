package org.techtown.animalunteer;

public class Memo {
    int _id;
    String date;
    String shelter;
    String contents;

    public Memo(int _id, String date, String shelter, String contents) {
        this._id = _id;
        this.date = date;
        this.shelter = shelter;
        this.contents = contents;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) { this._id = _id; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShelter() {
        return shelter;
    }

    public void setShelter(String shelter) {
        this.shelter = shelter;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}

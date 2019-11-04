package qa.edu.qu.cmps312.todolistapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Todo implements Parcelable {
    private String title;
    private String status;
    private String priority;
    private String date;
    private String time;

    public Todo() {

    }

    public Todo(String title, String status, String priority, String date, String time) {
        this.title = title;
        this.status = status;
        this.priority = priority;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.status);
        dest.writeString(this.priority);
        dest.writeString(this.date);
        dest.writeString(this.time);
    }

    protected Todo(Parcel in) {
        this.title = in.readString();
        this.status = in.readString();
        this.priority = in.readString();
        this.date = in.readString();
        this.time = in.readString();
    }

    public static final Parcelable.Creator<Todo> CREATOR = new Parcelable.Creator<Todo>() {
        @Override
        public Todo createFromParcel(Parcel source) {
            return new Todo(source);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}

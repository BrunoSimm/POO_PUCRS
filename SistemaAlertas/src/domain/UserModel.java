package domain;

public class UserModel {
    String name;
    int id;
    EnumNotifications notification; //Transformar em array p suportar mais de um tipo de notificação.

    public UserModel(String name, int id, EnumNotifications notification) {
        this.name = name;
        this.id = id;
        this.notification = notification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public EnumNotifications getNotification() {
        return notification;
    }

    public void setNotification(EnumNotifications notification) {
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", name=" + name + ", notification=" + notification + "]";
    }

    

}
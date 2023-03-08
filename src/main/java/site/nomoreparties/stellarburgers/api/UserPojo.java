package site.nomoreparties.stellarburgers.api;


//POJO для работы с пользователем
public class UserPojo {

    private String email;
    private String password;
    private String name;


    public UserPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserPojo() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
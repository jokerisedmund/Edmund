package my.edmund_yapcom.edmundyap;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "user")
public class User {

    @PrimaryKey
    @NonNull
    private String passport;

    private String firstName;

    private String lastName;

    private String fee;

    public User() {

    }

    public User(@NonNull String passport, String firstName, String lastName, String fee) {
        this.passport = passport;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fee = fee;
    }


    @NonNull
    public String getPassport() {
        return passport;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPassport(@NonNull String passport) {
        this.passport = passport;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}

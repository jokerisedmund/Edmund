package my.edmund_yapcom.edmundyap;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    LiveData<List<User>> loadAllUsers();

    @Query("SELECT * FROM user WHERE passport = :passport")
    List<User> findUserByPassport(String passport);

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);


}

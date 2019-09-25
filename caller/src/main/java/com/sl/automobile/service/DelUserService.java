package com.sl.automobile.service;

        import com.sl.automobile.pojo.Deluser;
        import com.sl.automobile.pojo.UserTable;

        import java.util.List;

public interface DelUserService {

    public List<Deluser> loadAlls();

    public boolean addUser1(UserTable userTable);

    public boolean deleteDelUser(int id);


}

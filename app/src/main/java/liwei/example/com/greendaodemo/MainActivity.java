package liwei.example.com.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.anye.greendao.gen.UserDao;

import java.util.List;

import static android.R.attr.id;
import static android.R.attr.multiArch;

public class MainActivity extends AppCompatActivity {

    private UserDao mUserDao;
    private User mUser;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        获取UserDao对象：

        mUserDao = MyApp.getInstances().getDaoSession().getUserDao();






    }
    public void ha1(View view){
//        1. 增
        position++;
        mUser = new User();
        mUser.setName(""+position);
        mUserDao.insert(mUser);//添加一个
    }
     public void ha2(View view){
//         2. 删
         List<User> users = mUserDao.loadAll();
         for(User user:users){
             mUserDao.delete(user);
         }



    }
     public void ha3(View view){
//         3. 改
             mUser.setName("阿斯加尴尬死的");
         mUserDao.update(mUser);
    }
     public void ha4(View view){

//         4. 查
         List<User> users = mUserDao.loadAll();
         String userName = "";
         for (int i = 0; i < users.size(); i++) {
             userName += users.get(i).getName()+",";
             Log.e("1111", "ha4: "+users.get(i).getName() );
         }


     }




}

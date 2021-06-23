package com.example.authenticationlibrary;

import androidx.annotation.NonNull;

import com.example.authenticationlibrary.model.User;
import com.example.authenticationlibrary.retrofit.ApiUtils;
import com.example.authenticationlibrary.retrofit.UserCallBack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void register() {
        System.out.println(ApiUtils.BASE_URL);
        Authentication.register("hod@gmail.com", "1234567", "hod gohas",
                new UserCallBack() {
                    @Override
                    public void onSuccess(@NonNull User value) {
                        System.out.println("Done");
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        System.out.println("Fail");
                    }
                });
//        Authentication.register("hod@gmail.com",
//                "12345678", "hod gohasi");
        assertEquals(4, 2 + 2);
    }
}
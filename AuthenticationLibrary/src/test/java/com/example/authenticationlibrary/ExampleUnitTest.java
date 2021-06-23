package com.example.authenticationlibrary;

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

//    @Test
//    public void register() {
//        System.out.println(ApiUtils.BASE_URL);
//        final boolean[] isDone = {false};
//        Authentication.register("hod@gmail.com", "1234567", "hod gohas",
//                new UserCallBack() {
//                    @Override
//                    public void onSuccess(@NonNull User value) {
//                        System.out.println("Done");
//                        isDone[0] = true;
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable throwable) {
//                        System.out.println("Fail");
//                        isDone[0] = false;
//                    }
//                });
////        Authentication.register("hod@gmail.com",
////                "12345678", "hod gohasi");
//
//        assertEquals(true, isDone[0]);
//    }

//    @Test
//    public void register() {
//        System.out.println(ApiUtils.BASE_URL);
//        final boolean[] isDone = {false};
//        Authentication.home(
//                new UserCallBack() {
//                    @Override
//                    public void onSuccess(@NonNull String value) {
//                        System.out.println("Done : " + value);
//                        isDone[0] = true;
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable throwable) {
//                        System.out.println("Fail");
//                        isDone[0] = false;
//                    }
//                });
////        Authentication.register("hod@gmail.com",
////                "12345678", "hod gohasi");
//
////        assertEquals(true, isDone[0]);
//    }
}
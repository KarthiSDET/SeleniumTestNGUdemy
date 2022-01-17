package org.selenium.pom.api.actions;

import org.selenium.pom.objects.User;
import org.selenium.pom.utils.FakerUtils;

public class DummyClass {
    public static void main(String[] args) {
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User()
            .setUsername(username)
            .setPassword("demopwd")
            .setEmail(username + "@askomdch.com");
        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
//        System.out.println(signUpApi.register(user));
        System.out.println("Register cookies: " + signUpApi.getCookies());

//        System.out.println("Register Form auth value using groovy: " + new SingUpApi().fetchRegisterNonceValueUsingGroovy());
//        System.out.println("Register Form auth value using Jsoup: " + new SingUpApi().fetchRegisterNonceValueUsingJoup());

        CartApi cartApi = new CartApi(signUpApi.getCookies());
        cartApi.addToCart(1215,1);
        System.out.println("Cart cookies: " + cartApi.getCookies());
    }
}

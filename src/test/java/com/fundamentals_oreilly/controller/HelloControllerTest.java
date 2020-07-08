package com.fundamentals_oreilly.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;


public class HelloControllerTest {
    @Test
    public void sayHello() {
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = controller.sayHello("world", model);
        Assert.assertEquals("hello", result);
        Assert.assertEquals("world",model.asMap().get("user"));
    }
}

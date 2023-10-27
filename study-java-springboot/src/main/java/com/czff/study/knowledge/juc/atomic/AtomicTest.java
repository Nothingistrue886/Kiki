package com.czff.study.knowledge.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author cuidi
 * @date 2022/6/10 9:50
 * @description
 */
public class AtomicTest {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(1);
        int i = integer.incrementAndGet();
        System.out.println(i);

        User z3 = new User("z3");
        User l4 = new User("l4");
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(z3);
        boolean b = userAtomicReference.compareAndSet(z3, l4);
        System.out.println(b + "\t" + userAtomicReference.get().toString());
    }

    static class User {
        String name;


        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}

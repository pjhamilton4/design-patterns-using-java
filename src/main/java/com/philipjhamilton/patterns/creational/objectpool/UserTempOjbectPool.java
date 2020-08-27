package com.philipjhamilton.patterns.creational.objectpool;

public class UserTempOjbectPool extends ObjectPool<UserTemp>{
    @Override
    public UserTemp createObject() {
        return new UserTemp(1, (long) (Math.random()+ 100 % 10), "Test1", "phil", "Virginia Beach");
    }
}

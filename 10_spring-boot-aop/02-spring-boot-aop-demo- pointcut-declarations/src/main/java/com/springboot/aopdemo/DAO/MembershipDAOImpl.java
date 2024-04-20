package com.springboot.aopdemo.DAO;

import org.springframework.stereotype.Repository;


@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addAccount() {

        System.out.println(getClass()+"Adding an Membership Account");
        return  true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+ " gotosleep()");
    }
}

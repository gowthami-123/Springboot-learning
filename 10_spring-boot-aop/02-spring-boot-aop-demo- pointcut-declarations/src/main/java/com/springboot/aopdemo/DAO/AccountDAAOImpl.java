package com.springboot.aopdemo.DAO;

import com.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountDAAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account theAccount,boolean flag) {

        System.out.println(getClass()+"Adding an Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "doWork()");
        return true;
    }

    public String getName() {
        System.out.println(getClass() + "in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + "in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + "in getserviceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + "in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts(boolean flag) {
        //simulate an exception
        if(flag==true)
        {
            throw new RuntimeException("No soup for you!..");
        }

        List<Account>myAccounts=new ArrayList<>();

        Account temp1=new Account("Thiru","Gold");
        Account temp2=new Account("Yashmi", "Silver");
        myAccounts.add(temp1);
        myAccounts.add(temp2);

        return myAccounts;
    }
}

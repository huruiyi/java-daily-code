package com.example.tx.demoI;

public interface AccountDao {

  void outMoney(String from, Double money);

  void inMoney(String to, Double money);
}

package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

public class FakeRepository implements CustomerRepo {

        @Override
        public List<Customer> getCustomers() {
            return Arrays.asList(new Customer(1L, "AAA", "111", "email@gmail.com"), new Customer(2L, "BBB", "222", "email@gmail.com"));
        }

}

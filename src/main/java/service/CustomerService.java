package service;

import custom_exceptions.CustomerSameNameException;
import model.Customer;

import java.util.HashMap;

public class CustomerService {
    private static HashMap<String, Customer> customers = new HashMap<String, Customer>();

    public static void addCustomer(Customer c) throws CustomerSameNameException {
        if (!customers.containsKey(c.getName())) {
            customers.put(c.getName(), c);
        } else {
            throw new CustomerSameNameException();
        }
        PersistenceService.saveCustomers();
    }

    public static void reset() {
        customers.clear();
    }

    public static HashMap<String, Customer> getCustomers() {
        return customers;
    }
}

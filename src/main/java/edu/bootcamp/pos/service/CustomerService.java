package edu.bootcamp.pos.service;

import edu.bootcamp.pos.dto.CustomerDto;
import edu.bootcamp.pos.dto.request.CustomerUpdateDto;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDto customerDto);

    String updateCustomer(CustomerUpdateDto customerUpdateDto);

    CustomerDto getCustomerById(int customerId);

    List<CustomerDto> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDto> getAllCustomersByActiveStatus(boolean activeStatus);
}

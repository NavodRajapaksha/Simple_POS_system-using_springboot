package edu.bootcamp.pos.service.impl;

import edu.bootcamp.pos.dto.CustomerDto;
import edu.bootcamp.pos.dto.request.CustomerUpdateDto;
import edu.bootcamp.pos.entity.CustomerEntity;
import edu.bootcamp.pos.exception.NotFoundException;
import edu.bootcamp.pos.repository.CustomerRepository;
import edu.bootcamp.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .address(customerDto.getAddress())
                .contactNumber(customerDto.getContactNumber())
                .nic(customerDto.getNic())
                .active(customerDto.isActive())
                .build();

        customerRepository.save(customerEntity);
        return customerDto.getName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDto customerUpdateDto) {
        if (customerRepository.existsById(customerUpdateDto.getId())) {
            CustomerEntity customerEntity = customerRepository.getReferenceById(customerUpdateDto.getId());
            customerEntity.setName(customerUpdateDto.getName());
            customerEntity.setAddress(customerUpdateDto.getAddress());

            customerRepository.save(customerEntity);
            return customerUpdateDto.getName() + " Update Successful";
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        if (customerRepository.existsById(customerId)) {
            CustomerEntity customerEntity = customerRepository.getReferenceById(customerId);
            CustomerDto customerDto = new CustomerDto(
                    customerEntity.getId(),
                    customerEntity.getName(),
                    customerEntity.getAddress(),
                    customerEntity.getContactNumber(),
                    customerEntity.getNic(),
                    customerEntity.isActive()
            );
            return customerDto;
        } else {
            throw new RuntimeException("No Customer Founded");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerEntity> getAllCustomers = customerRepository.findAll();
        if (getAllCustomers.size()>0) {
            List<CustomerDto> customerDtoList = new ArrayList<>();

            for (CustomerEntity customerEntity : getAllCustomers) {
                CustomerDto customerDto = new CustomerDto(
                        customerEntity.getId(),
                        customerEntity.getName(),
                        customerEntity.getAddress(),
                        customerEntity.getContactNumber(),
                        customerEntity.getNic(),
                        customerEntity.isActive()
                );

                customerDtoList.add(customerDto);
            }
            return customerDtoList;
        }else {
            throw new NotFoundException("No user founded");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return "Delete Successful" + customerId;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomersByActiveStatus(boolean activeStatus) {
        List<CustomerEntity> getAllCustomersByActiveStatus = customerRepository.findAllByActiveEquals(activeStatus);

        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (CustomerEntity customerEntity : getAllCustomersByActiveStatus) {
            CustomerDto customerDto = new CustomerDto(
                    customerEntity.getId(),
                    customerEntity.getName(),
                    customerEntity.getAddress(),
                    customerEntity.getContactNumber(),
                    customerEntity.getNic(),
                    customerEntity.isActive()
            );

            customerDtoList.add(customerDto);
        }
        return customerDtoList;

    }

}

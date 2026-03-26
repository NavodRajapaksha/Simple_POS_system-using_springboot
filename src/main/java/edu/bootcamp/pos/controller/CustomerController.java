package edu.bootcamp.pos.controller;

import edu.bootcamp.pos.dto.CustomerDto;
import edu.bootcamp.pos.dto.request.CustomerUpdateDto;
import edu.bootcamp.pos.service.CustomerService;
import edu.bootcamp.pos.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDto customerUpdateDto){
        String message = customerService.updateCustomer(customerUpdateDto);
        return message;
    }

    @GetMapping(path = "/get-by-id", params = "id" )
    public CustomerDto getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return customerDto;
    }

//    @GetMapping(path = "/get-all-customers")
//    public List<CustomerDto> getAllCustomers(){
//        List<CustomerDto> allCustomers = customerService.getAllCustomers();
//        return allCustomers;
//    }

    @GetMapping(path = "/get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers(){
        List<CustomerDto> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allCustomers)
                , HttpStatus.OK
        );
    }

    @DeleteMapping(path = "delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping(path = "/get-all-customers-by-active-status/{status}")
    public List<CustomerDto> getAllCustomersByActiveStatus(@PathVariable(value = "status") boolean activeStatus){
        List<CustomerDto> allCustomers = customerService.getAllCustomersByActiveStatus(activeStatus);
        return allCustomers;
    }
}

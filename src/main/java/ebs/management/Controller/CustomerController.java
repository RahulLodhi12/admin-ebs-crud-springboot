package ebs.management.Controller;

import ebs.management.Entity.Customer;
import ebs.management.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // 📃 Get All Customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    // ➕ Add Customer
    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    // 🔄 Update Customer
    @PutMapping("/update/{meterNo}")
    public Customer updateCustomer(@PathVariable int meterNo, @RequestBody Customer customer) {
        return customerService.updateCustomer(meterNo,customer);
    }

    // 🔍 Get Customer by meter_no
    @GetMapping("/{meterNo}")
    public Customer getCustomer(@PathVariable int meterNo) {
        return customerService.getCustomerByMeterNo(meterNo)
                .orElse(null); // or throw a custom exception if needed
    }

    // ❌ Delete Customer by meter_no
    @DeleteMapping("/delete/{meterNo}")
    public String deleteCustomer(@PathVariable int meterNo) {
        return customerService.deleteCustomer(meterNo);
    }
}

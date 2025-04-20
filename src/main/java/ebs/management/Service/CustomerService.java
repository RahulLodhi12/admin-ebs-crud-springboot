package ebs.management.Service;

import ebs.management.Entity.Customer;
import ebs.management.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    // Add a customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Delete a customer by meter_no
    public String deleteCustomer(int meterNo) {
        if (customerRepository.existsById(meterNo)) {
            customerRepository.deleteById(meterNo);
            return "Customer with meter no " + meterNo + " deleted successfully.";
        } else {
            return "Customer with meter no " + meterNo + " not found.";
        }
    }

    // Update customer details
    public Customer updateCustomer(int meterNo, Customer customer) {
        Optional<Customer> existing = customerRepository.findById(meterNo);

        if (existing.isPresent()) {
            // You can selectively update fields if needed:
            Customer updated = existing.get();
            updated.setName(customer.getName());
            updated.setAddress(customer.getAddress());
            updated.setCity(customer.getCity());
            updated.setState(customer.getState());
            updated.setEmail(customer.getEmail());
            updated.setPhone(customer.getPhone());

            return customerRepository.save(updated);
        } else {
            // Or throw a custom exception if you'd like
            return null;
        }
    }


    // Search customer by meter_no
    public Optional<Customer> getCustomerByMeterNo(int meterNo) {
        return customerRepository.findById(meterNo);
    }
}

package com.globallogic.procamp.lesson12.onetoone;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.globallogic.procamp.lesson12.entity.onetoone.bidirectional.BankAccountEntity;
import com.globallogic.procamp.lesson12.entity.onetoone.bidirectional.CustomerEntity;
import com.globallogic.procamp.lesson12.entity.onetoone.jointable.Car;
import com.globallogic.procamp.lesson12.entity.onetoone.jointable.Driver;
import com.globallogic.procamp.lesson12.entity.onetoone.mapsid.Post;
import com.globallogic.procamp.lesson12.entity.onetoone.mapsid.PostDetails;
import com.globallogic.procamp.lesson12.repository.AddressRepository;
import com.globallogic.procamp.lesson12.repository.onetoone.bidirectional.BankAccountRepository;
import com.globallogic.procamp.lesson12.repository.onetoone.bidirectional.CustomerRepository;
import com.globallogic.procamp.lesson12.repository.onetoone.jointable.CarRepository;
import com.globallogic.procamp.lesson12.repository.onetoone.jointable.DriverRepository;
import com.globallogic.procamp.lesson12.repository.onetoone.mapsid.PostDetailsRepository;
import com.globallogic.procamp.lesson12.repository.onetoone.mapsid.PostRepository;
import com.globallogic.procamp.lesson12.repository.onetoone.unidirectional.PersonRepository;
import com.globallogic.procamp.lesson12.tasks.BaseRunner;

public class OneToOne extends BaseRunner {

    @Autowired PersonRepository personRepository;
    @Autowired AddressRepository addressRepository;
    @Autowired CustomerRepository customerRepository;
    @Autowired BankAccountRepository bankAccountRepository;
    @Autowired PostRepository postRepository;
    @Autowired PostDetailsRepository postDetailsRepository;
    @Autowired CarRepository carRepository;
    @Autowired DriverRepository driverRepository;
    
    

    @Test
    public void unidirectional() {
        personRepository.findOne(1L);
    }

    @Test
    public void unidirectional_address() {
        addressRepository.findOne(1L);
    }


    @Test
    public void bidirectional_customer() {
        CustomerEntity customer = customerRepository.findOne(1L);
        assertThat(customer.getAccount().getAccountNo(), is("0001"));  
    }

    @Test
    public void bidirectional_account() {
        BankAccountEntity account = bankAccountRepository.findOne(1L);
        assertThat(account.getCustomer().getName(), is(String.class));
    }

    @Test
    public void mapsId_post() {
        Post post = postRepository.findOne(1L);
        assertThat(post.getDetails().getCreatedBy(), is(String.class));
    }


    @Test
    public void mapsId_post_details() {
        PostDetails postDetails = postDetailsRepository.findOne(1L);
        assertThat(postDetails.getPost().getTitle(), is(String.class));
    }

    @Test
    public void joinTable_car() {
        Car car = carRepository.findOne(1L);
        assertThat(car.getDriver().getName(), is(String.class));
    }

    @Test
    public void joinTable_driver() {
        Driver driver = driverRepository.findOne(1L);
        assertThat(driver.getCar().getName(), is(String.class));
    }
}


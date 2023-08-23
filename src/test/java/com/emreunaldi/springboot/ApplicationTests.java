package com.emreunaldi.springboot;

import com.emreunaldi.springboot.data.entity.EmployeeEntity;
import com.emreunaldi.springboot.data.repository.EmployeeRepository;
import com.emreunaldi.springboot.test.TestCrud;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests implements TestCrud {
    @Autowired
    EmployeeRepository employeeRepository;
    @BeforeEach
    public void waitOneSecondBeforeEachTest() throws InterruptedException {
        Thread.sleep(1000); // 1 saniye bekleyin
    }

    // CREATE
    @Test
    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .firstName("Emre Test")
                .lastName("Ünaldı Test")
                .emailId("eu@gmail.com")
                .build();
        // Nesne null ise AssertionError hatası gönderir.
        assertNotNull(employeeRepository.findById(1L));
    }

    // LIST
    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> entityList = employeeRepository.findAll();
        // Eğer sıfırdan büyükse liste var.
        assertThat(entityList).size().isGreaterThan(0);
    }

    // FIND BY ID
    @Test
    @Override
    public void testFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        // Emre Test adında kayıt var mı ?
        assertEquals("Emre Test", employeeEntity.getFirstName());
    }

    // UPDATE
    @Test
    @Override
    public void testUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        employeeEntity.setFirstName("Emre Test 38");
        employeeRepository.save(employeeEntity);
        // Eşit değilse bir sorun olmayacak ama eşitse hata vercek
        assertNotEquals("Emre Test", employeeRepository.findById(1L).get().getFirstName());
    }

    // DELETE
    @Test
    @Override
    public void testDelete() {
        employeeRepository.deleteById(1L);
        // isFalse
        assertThat(employeeRepository.existsById(1L)).isFalse();
    }

    @AfterEach
    public void waitOneSecondAfterEachTest() throws InterruptedException {
        Thread.sleep(1000); // 1 saniye bekleyin
    }
}

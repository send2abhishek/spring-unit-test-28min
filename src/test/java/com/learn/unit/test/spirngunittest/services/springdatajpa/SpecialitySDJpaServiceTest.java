package com.learn.unit.test.spirngunittest.services.springdatajpa;

import com.learn.unit.test.spirngunittest.model.Speciality;
import com.learn.unit.test.spirngunittest.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

//    @Mock creates a mock. @InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations into this instance.
//    Note you must use @RunWith(MockitoJUnitRunner.class) or Mockito.initMocks(this) to initialize these mocks and inject them (JUnit 4).
//    With JUnit 5, you must use @ExtendWith(MockitoExtension.class)

//    @Mock creates a mock implementation for the classes you need.
//    @InjectMock creates an instance of the class and injects the mocks that are marked with the annotations @Mock into it.

    @Mock
    SpecialtyRepository repository;

    // create the instance of class and injects the mocks
    @InjectMocks
    SpecialitySDJpaService service;

    @Test
    void delete() {
        service.delete(new Speciality());
    }

    // run the test 2 times
    @Test
    void deleteById() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(repository,times(2)).deleteById(1L);
    }

    // test can be executed max of 5
    @Test
    void deleteByIdAtMost() {
        service.deleteById(1L);
        service.deleteById(1L);

        verify(repository,atMost(5)).deleteById(1L);
    }

    // test can be executed at least of 3 times
    @Test
    void deleteByIdAtLeast() {
        service.deleteById(1L);
        service.deleteById(1L);
        service.deleteById(1L);

        verify(repository,atLeast(3)).deleteById(1L);
    }

}
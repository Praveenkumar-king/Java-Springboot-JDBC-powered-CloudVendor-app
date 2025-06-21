package com.praveenkumar.rest_demo.repository;

import com.praveenkumar.rest_demo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CloudVendorRepositoryTest {


    // given - when - then

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        cloudVendor = new CloudVendor("1","Amazon",
                "USA", "xxxxx");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
          cloudVendor = null;
          cloudVendorRepository.deleteAll();
    }

    // Test Case SUCCESS

    @Test
    void testFindByVendorName_Found() {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");

        assertThat(cloudVendorList).isNotEmpty(); // First check that result exists

        CloudVendor retrievedVendor = cloudVendorList.get(0);

        // Compare properties directly
        assertThat(retrievedVendor.getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(retrievedVendor.getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
        assertThat(retrievedVendor.getVendorName()).isEqualTo(cloudVendor.getVendorName());
        assertThat(retrievedVendor.getVendorPhoneNumber()).isEqualTo(cloudVendor.getVendorPhoneNumber());
    }


    // Test Case FAILURE
    @Test
    void testFindByVendorName_NotFound() {
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("GCP");
        assertThat(cloudVendorList).isEmpty();
    }

}

/*
 * PropertyRepositoryTest.java
 * This is the test for the property repository
 * Author: Tshegofatso Molefe {219001235}
 * Date: 8 April 2023
 * */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Property;
import za.ac.cput.factory.PropertyFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PropertyRepositoryTest {
    private static PropertyRepository repository = PropertyRepository.getRepository();
    private static Property property = PropertyFactory.createProperty("8 PostGraduate Street Belhar",45000,"Property is close to schools, shopping centers and other amenities");

    @Test
    void a_create() {
        Property created = repository.create(property);
        assertNotNull(property.getPropertyID(), created.getPropertyID());
        System.out.println("Property created :" + created);
    }

    @Test
    void b_read() {
        Property read = repository.read(property.getPropertyID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Property updated = new Property.Builder()
                .copy(property)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updates: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(property.getPropertyID());
        assertTrue(success);
        System.out.println("Deleted" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all properties");
        System.out.println(repository.getAll());
    }
}
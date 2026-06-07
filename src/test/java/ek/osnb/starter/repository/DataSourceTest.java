package ek.osnb.starter.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

@DataJpaTest
// Uncomment the following annotations to test with the Docker container database
@ActiveProfiles("docker")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DataSourceTest {
    @Autowired
    DataSource dataSource;

    @Test
    void testDataSource() throws Exception {
        String dbName = dataSource.getConnection().getMetaData().getDatabaseProductName();
        System.out.println("Database Product Name: " + dbName); // H2
    }
}

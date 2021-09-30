package co.com.sofka.junitmock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DependencyTest {

    @Mock
    private SubDependency subDependencyMock;

    private Dependency dependency;

    @BeforeEach
    void setUpMock() {
        this.subDependencyMock = Mockito.mock(SubDependency.class);
        this.dependency = new Dependency(subDependencyMock);
    }

    @Test
    void testSubdependency(){
        Mockito.when(this.subDependencyMock.getClassName()).thenReturn("hi there 2");

        assertEquals("hi there 2", dependency.getSubdepedencyClassName());
    }

    @AfterEach
    void tearDown() {
    }
}
package co.com.sofka.junitmock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SubDependencyTest {

    @Mock
    private Dependency dependency;

    @BeforeEach
    void setUpMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDependency(){
        Mockito.when(dependency.getClassName()).thenReturn("hi there");

        assertEquals("hi there", dependency.getClassName());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testException() {
        when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);

        dependency.getClassName();
    }

    @Test
    public void testAddTwo(){
        Mockito.when(dependency.addTwo(1)).thenReturn(5);

        assertEquals(5, dependency.addTwo(1));
        assertEquals(0, dependency.addTwo(27));
    }



    @AfterEach
    void tearDown() {
    }
}
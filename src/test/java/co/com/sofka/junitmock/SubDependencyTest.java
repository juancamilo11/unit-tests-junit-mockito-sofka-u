package co.com.sofka.junitmock;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
        when(dependency.getClassName()).thenReturn("hi there");

        assertEquals("hi there", dependency.getClassName());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testException() {
        when(dependency.getClassName()).thenThrow(IllegalArgumentException.class);

        dependency.getClassName();
    }

    @AfterEach
    void tearDown() {
    }
}
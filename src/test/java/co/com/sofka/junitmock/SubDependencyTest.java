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
        //Solo para cuando el parametro es 1, el valor de retorno sera 5
        Mockito.when(dependency.addTwo(1)).thenReturn(5);

        assertEquals(5, dependency.addTwo(1));
        assertEquals(0, dependency.addTwo(27));
    }

    @Test
    public void testAddTwoAny(){
        //Para cualquier otro valor de parametro, el valor de retorno sera 0
        when(dependency.addTwo(Mockito.anyInt())).thenReturn(0);
        assertEquals(0, dependency.addTwo(3));
        assertEquals(0, dependency.addTwo(80));
    }

    @AfterEach
    void tearDown() {
    }
}
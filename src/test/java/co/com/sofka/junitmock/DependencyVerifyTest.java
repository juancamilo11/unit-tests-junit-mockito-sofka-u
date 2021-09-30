package co.com.sofka.junitmock;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class DependencyVerifyTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Dependency dependency;

    @Test
    public void testSimpleVerify(){
        //nunca se ha ejecutado
        Mockito.verify(dependency, never()).getClassNameUpperCase();
        dependency.getClassNameUpperCase();

        //Se ha ejecutado exactamente una vez
        Mockito.verify(dependency, Mockito.times(1)).getClassNameUpperCase();
        dependency.getClassNameUpperCase();

        //se ha ejecutado minimo dos veces
        Mockito.verify(dependency, Mockito.atLeast(1)).getClassNameUpperCase();
        dependency.getClassNameUpperCase();

        //se ha ejecutado maximo dos veces
        Mockito.verify(dependency, Mockito.atMost(3)).getClassNameUpperCase();

        //Descomentar y ejecutar, va a fallar la prueba
        //Mockito.verify(dependency, Mockito.atMost(100)).getClassNameUpperCase();


    }






}

    package com.henrique;

    import org.assertj.core.api.Assertions;
    import org.junit.jupiter.api.Test;
    import org.mockito.Mockito;

    import java.util.ArrayList;
    import java.util.List;

    //outra forma de criar uma lista de mockito
    //@RunWith(MockitoJUnitRunner.class)
    public class MockitoTests {

    //    @Mock
    //   private List<String> lista;

        public MockitoTests() {
            super();
        }

        @Test
        public void primeiroTesteMockito(){
            // criando um objeto mock, este objeto so vai trabalhar com mock, nao aceita incerção de outro tipo
            //pq os mock não são objetos reais!
            List<String> list = Mockito.mock(ArrayList.class);

            //esse metodo mocka os 20 elementos na lista
            Mockito.when(list.size()).thenReturn(20);
            int size = list.size();

            //testa se tem os vinte elementos na lista
            Assertions.assertThat(size).isEqualTo(20);

           //Para verificar se ocorreu chamadas de metodos! o exemplo foi de size.
         //   Mockito.verify(list).size();

            // Verifica quantas vezes o metodo foi chamado
         //   Mockito.verify(list, Mockito.times( 1)).size();

            //Verifica se nao foi chamado
        //    Mockito.verify(list, Mockito.never()).size();

            //Metodo para verificar se foi executado na ordem descrita
        //    InOrder inOrder = Mockito.inOrder(list);
        //    inOrder.verify(list).size();
        //    inOrder.verify(list).add("");

        }
    }

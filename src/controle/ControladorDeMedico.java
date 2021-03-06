package controle;

import manipulacaoDeArquivo.ManipulacaoDeArquivo;
import java.util.ArrayList;

/// CLASSES PRÓPRIAS 
import paciente.DoadorReceptor;
import paciente.Doador;

/**
 * Representa uma preferência
 * @author  samuellucas97
 *          candinhojr
 * @since   03.11.2018
 */
public class ControladorDeMedico {
    
    private ArrayList<DoadorReceptor> paresDoadoresReceptores;
    private ArrayList<Doador> doadoresCadaveres;

    public ControladorDeMedico() {
        this.paresDoadoresReceptores = ManipulacaoDeArquivo.leituraComTratamentoDeArquivoDeDoadoresReceptores("./data/testeDoadoresReceptores.dat");
        this.doadoresCadaveres = ManipulacaoDeArquivo.leituraComTratamentoDeArquivoDeDoadoresCadaver("./data/testeDoadoresCadaveres.dat");
        
        this.defineListaDePreferenciasDoReceptor();
    }

    /**
     * Cria a lista de preferências do receptor
     * @param receptor  Receptor
     * @param doadores  Lista de doadores
     */
    private void defineListaDePreferenciasDoReceptor() {     
        ArrayList<DoadorReceptor> paresDoadoresReceptoresAuxiliar = new ArrayList<DoadorReceptor>();
        
        for( int i = 0; i < paresDoadoresReceptores.size(); ++i ){
            paresDoadoresReceptoresAuxiliar = (ArrayList<DoadorReceptor>)paresDoadoresReceptores.clone();
            paresDoadoresReceptoresAuxiliar.remove(i);
            
            Medico.defineListaDePreferenciasDoReceptor(paresDoadoresReceptores.get(i), paresDoadoresReceptoresAuxiliar);
        }   
    }
    
    public ArrayList<DoadorReceptor> getParesDoadoresReceptores() {
        return paresDoadoresReceptores;
    }

    public ArrayList<Doador> getDoadoresCadaveres() {
        return doadoresCadaveres;
    }
}

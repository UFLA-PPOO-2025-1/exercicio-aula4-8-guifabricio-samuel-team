import java.util.Map;

public class VisaoDeTexto implements VisaoSimulador {
    private EstatisticasCampo estatisticas;

    public VisaoDeTexto() {
        estatisticas = new EstatisticasCampo();
    }

    /**
     * Constrói uma visão de texto para exibir estatísticas do campo.
     */
    @Override
    public void mostrarStatus(int passo, Campo campo) {
        if (campo != null) {
            estatisticas.reiniciar();
            // Percorre o campo e conta os objetos presentes.
            for (int linha = 0; linha < campo.obterComprimento(); linha++) {
                for (int coluna = 0; coluna < campo.obterLargura(); coluna++) {
                    Object objeto = campo.obterObjetoEm(linha, coluna);
                    if (objeto != null) {
                        estatisticas.incrementarContagem(objeto.getClass());
                    }
                }
            }
            estatisticas.finalizarContagem();

            String detalhesPopulacao = estatisticas.obterDetalhesPopulacao(campo);
            System.out.println("Passo " + passo + " - " + detalhesPopulacao);
        }
    }

    @Override
    public void reiniciar() {
        estatisticas.reiniciar();
    }

    @Override
    public boolean ehViavel(Campo campo) {
        return estatisticas.ehViavel(campo);
    }

    @Override
    public void definirCor(Class<?> classeAnimal, java.awt.Color cor) {
        
    }

    @Override
    public void reabilitarOpcoes() {
        
    }
}   
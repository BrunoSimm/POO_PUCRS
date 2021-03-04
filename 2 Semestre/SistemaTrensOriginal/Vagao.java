public abstract class Vagao extends ElementoDeComposicao {
    public String getTipoVagao(Vagao vagao){
        return vagao.getClass().getName();
    }
}

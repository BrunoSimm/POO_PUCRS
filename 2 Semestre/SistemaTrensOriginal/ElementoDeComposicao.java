public abstract class ElementoDeComposicao {
  protected int identificador;
  protected int composicao;

  public int getIdentificador() {
    return identificador;
  }

  public int getComposicao() {
    return composicao;
  }

  public void setComposicao(Composicao composicao) {
    if (composicao == null) {
      this.composicao = -1;
    } else {
      this.composicao = composicao.getIdentificador();
    }
  }

  public abstract String toLineFile(); // Deve ser implementado para cada class.

  public abstract String toString(); // Deve ser implementado para cada class.

}

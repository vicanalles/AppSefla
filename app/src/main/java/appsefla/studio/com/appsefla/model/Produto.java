package appsefla.studio.com.appsefla.model;

/**
 * Created by vinicius on 11/07/17.
 */

public class Produto {

    private String nome;
    private String descricao;
    private int photo;

    public Produto(String nome, String descricao, int photo){
        this.nome = nome;
        this.descricao = descricao;
        this.photo = photo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}

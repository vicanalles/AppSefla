package appsefla.studio.com.appsefla.model;

/**
 * Created by vinicius on 11/07/17.
 */

public class Produto {

    private String nome;
    private int numOfSongs;
    private int thumbnail;

    public Produto(String nome, int numOfSongs, int thumbnail){
        this.nome = nome;
        this.numOfSongs = numOfSongs;
        this.thumbnail  = thumbnail;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

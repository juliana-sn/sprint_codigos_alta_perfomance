package modelos;

public class Colaborador {
    private int id;
    private String nome;
    private String setor;
    private String buddy;
    private int nota;

    public Colaborador(int id, String nome, String setor, String buddy) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.buddy = buddy;
        this.nota = -1;
    }

    public Colaborador(int id, String nome, String setor, String buddy, int nota) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.buddy = buddy;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    public String getBuddy() {
        return buddy;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return id + "\t" + nome + "\t" + setor + "\t" + buddy + "\t" + nota;
    }
}

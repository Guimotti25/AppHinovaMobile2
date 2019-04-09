package com.example.motti.apphinovamobile.Oficinas;

import java.io.Serializable;

public class ListaOficinas implements Serializable {

    private String Nome;
    private String Descricao;
    private String DescricaoCurta;
    private String id;
    private String Endereco;
    private String Latitude;
    private String Longitude;
    private String Foto;
    private String AvaliacaoUsuario;
    private String Email;
    private String Telefone1;
    private String Telefone2;
    private String Ativo = String.valueOf(true);
    private String CodigoAssociacao;

    public String getCodigoAssociacao() { return CodigoAssociacao; }

    public void setCodigoAssociacao(String codigoAssociacao) { CodigoAssociacao = codigoAssociacao; }

    public String getNome() { return Nome; }

    public void setNome(String nome) { Nome = nome; }

    public String getDescricao() { return Descricao; }

    public void setDescricao(String descricao) { Descricao = descricao; }

    public String getDescricaoCurta() { return DescricaoCurta; }

    public void setDescricaoCurta(String descricaoCurta) { DescricaoCurta = descricaoCurta; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getEndereco() { return Endereco; }

    public void setEndereco(String endereco) { Endereco = endereco; }

    public String getLatitude() { return Latitude; }

    public void setLatitude(String latitude) { Latitude = latitude; }

    public String getLongitude() { return Longitude; }

    public void setLongitude(String longitude) { Longitude = longitude; }

    public String getFoto() { return Foto; }

    public void setFoto(String foto) { Foto = foto; }

    public String getAvaliacaoUsuario() { return AvaliacaoUsuario; }

    public void setAvaliacaoUsuario(String avaliacaoUsuario) { AvaliacaoUsuario = avaliacaoUsuario; }

    public String getEmail() { return Email; }

    public void setEmail(String email) { Email = email; }

    public String getTelefone1() { return Telefone1; }

    public void setTelefone1(String telefone1) { Telefone1 = telefone1; }

    public String getTelefone2() { return Telefone2; }

    public void setTelefone2(String telefone2) { Telefone2 = telefone2; }

    public String getAtivo() {
        return Ativo;
    }

    public void setAtivo(String ativo) {
        this.Ativo = ativo;
    }

    @Override
    public String toString() {
        return "ListaOficinas:" + getNome()
                +"\nDescrição" + getDescricao()
                +"\nDescrição Curta" + getDescricaoCurta()
                +"\nEndereço" + getEndereco()
                +"\n Latitude" + getLatitude()
                +"\n Longitude" + getLongitude()
                +"\n Foto" + getFoto()
                +"\n Avaliação Usuario:" + getAvaliacaoUsuario()
                +"\n Email:" + getEmail()
                +"\n Codigo associação:" + getCodigoAssociacao()
                +"\nTelefone1" + getTelefone1()
                +"\nTelefone2"+ getTelefone2();

    }
}
